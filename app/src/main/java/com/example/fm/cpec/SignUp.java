package com.example.fm.cpec;
import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;

import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.fm.cpec.Login.Logins;

public class SignUp extends AppCompatActivity implements LocationListener {
    EditText name, password, location, phonenuber, email;
    Button submit,fbsignup,gmailsignup;
    LocationManager locationManager;
    private ProgressDialog mProgressDialog;
    CallbackManager callbackManager;
    public static final int RequestSignInCode = 7;
    public FirebaseAuth firebaseAuth;
    public GoogleApiClient googleApiClient;
    String gmail_name, gmail_email,fbUserFirstName,fbUserEmail;
    public static final String Logins = "mypref";
    public static final String emails = "nameKey";
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        name = (EditText) findViewById(R.id.signupname);
       TAG =SignUp.class.getSimpleName();
        password = (EditText) findViewById(R.id.signuppassword);
        gmail_name=null;
        gmail_email=null;
        location = (EditText) findViewById(R.id.location);
        phonenuber = (EditText) findViewById(R.id.phonenumber);
        fbsignup=(Button) findViewById(R.id.fbsignup);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        email = (EditText) findViewById(R.id.signupemail);
        submit=(Button)findViewById(R.id.submit);
        gmailsignup=(Button)findViewById(R.id.sign_In_button);
        sharedPref = getSharedPreferences(Logins, Context.MODE_PRIVATE);
        firebaseAuth = FirebaseAuth.getInstance();
        callbackManager = CallbackManager.Factory.create();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(SignUp.this)
                .enableAutoManage(SignUp.this , new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
        gmailsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSignInMethod();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().equals("") || email.getText().toString().equals("") || password.getText().toString().equals("") || location.getText().toString().equals("") || phonenuber.getText().toString().equals(""))
                {
                    Toast.makeText(SignUp.this, "Please Fill Up Requiered Fields", Toast.LENGTH_LONG).show();
                }
                else {
                    SignUpByServer();
                }

            }
        });
        fbsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(SignUp.this, Arrays.asList("email", "public_profile"));
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        getUserDetails(loginResult);

                    }
                    @Override
                    public void onCancel() {
                    }
                    @Override
                    public void onError(FacebookException exception) {
                    }
                });

            }
        });
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
    }
    public void UserSignInMethod(){
        Intent AuthIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(AuthIntent, RequestSignInCode);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RequestSignInCode){
            GoogleSignInResult googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (googleSignInResult.isSuccess()){
                GoogleSignInAccount googleSignInAccount = googleSignInResult.getSignInAccount();
                FirebaseUserAuth(googleSignInAccount);

            }
        }
    }
    public void FirebaseUserAuth(GoogleSignInAccount googleSignInAccount) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
//        Toast.makeText(SignUp.this,""+ authCredential.getProvider(),Toast.LENGTH_SHORT).show();

        firebaseAuth.signInWithCredential(authCredential)
                .addOnCompleteListener(SignUp.this, new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task AuthResultTask) {
                        if (AuthResultTask.isSuccessful()){
                            // Getting Current Login user details.
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            // Hiding Login in button.
                            gmailsignup.setVisibility(View.VISIBLE);
                            gmail_name=firebaseUser.getDisplayName().toString();
                            gmail_email=firebaseUser.getEmail().toString();
                            SignUpByGmailServer();

                        }else {
                            Toast.makeText(SignUp.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    protected void getUserDetails(LoginResult loginResult) {
        GraphRequest data_request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject json_object,
                            GraphResponse response) {
                        try {
                            fbUserFirstName = json_object.optString("name");
                            fbUserEmail = json_object.optString("id");
                            SignUpByFbServer();

//                            profile_pic_dta.setText(fbUserFirstName);
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                });
        Bundle permission_param = new Bundle();
        permission_param.putString("fields", "id,name,email,picture.width(120).height(120)");
        data_request.setParameters(permission_param);
        data_request.executeAsync();
    }
    private void SignUpByFbServer() {


//            String gmail_namee = txtName.getText().toString();
//            String gmail_emaill = txtEmail.getText().toString();

            SignupService service = ApiClient.getClient().create(SignupService.class);

            Call<MSG> userCall = service.FbData(fbUserFirstName, fbUserEmail);

            userCall.enqueue(new Callback<MSG>() {
                @Override
                public void onResponse(Call<MSG> call, retrofit2.Response<MSG> response) {
                    //onSignupSuccess();
                    try {
                        Log.d("onResponse", "" + response.body().getMessage());


                        if (response.body().getSuccess() == 0) {
    //                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            Toast.makeText(SignUp.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            editor= sharedPref.edit();
                            editor.putString("emails", fbUserEmail);
    //                    editor.putString("passwords", password);
                            editor.commit();
                            DtabaeHelper mydb;
                            mydb=new DtabaeHelper(SignUp.this);
                            mydb.updateitems("1",fbUserEmail);
    //                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            Intent i=new Intent(SignUp.this,MainActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(SignUp.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<MSG> call, Throwable t) {
                    try {
                        Toast.makeText(SignUp.this, "Failure", Toast.LENGTH_SHORT).show();
                        Log.d("onFailure", t.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

    }
//    @Override
//    protected void onActivityResult(int requestCode1, int resultCode1, Intent data1) {
//
//        super.onActivityResult(requestCode1, resultCode1, data1);
//
//    }
    public void UserSignOutFunction() {
        // Sing Out the User.
        firebaseAuth.signOut();
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                new ResultCallback() {
                    @Override
                    public void onResult(@NonNull Result result) {

                    }

                    public void onResult(@NonNull Status status) {

                    }
                });
        // After logout setting up login button visibility to visible.
        gmailsignup.setVisibility(View.VISIBLE);
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    @Override
    public void onLocationChanged(Location loc) {

       String country=null;
        Geocoder geocoder = new Geocoder(this);

        try {
            List<Address> addresses = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
            if (geocoder.isPresent()) {
                StringBuilder stringBuilder = new StringBuilder();
                if (addresses.size() > 0) {
                    Address returnAddress = addresses.get(0);
                    country = returnAddress.getCountryName();

                }
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        location.setText(country);
        locationManager.removeUpdates(this);
        locationManager= null;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
    @Override
    public void onProviderEnabled(String provider) {

    }
    @Override
    public void onProviderDisabled(String provider) {
    }
    private void SignUpByServer() {
        final String emaill = email.getText().toString();
        String passwordd = password.getText().toString();
        String loc=location.getText().toString();
        String phone=phonenuber.getText().toString();
        String namee=name.getText().toString();
        SignupService service = ApiClient.getClient().create(SignupService.class);

        Call<MSG> userCall = service.insertData(namee,emaill,loc,phone,passwordd);

        userCall.enqueue(new Callback<MSG>() {
            @Override
            public void onResponse(Call<MSG> call, Response<MSG> response) {
//                hidepDialog();
                //onSignupSuccess();
                Log.d("onResponse", "" + response.body().getMessage());


                if(response.body().getSuccess() == 0) {
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(SignUp.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    editor= sharedPref.edit();
                    editor.putString("emails", emaill);
//                    editor.putString("passwords", password);
                    editor.commit();
                    DtabaeHelper mydb;
                    mydb=new DtabaeHelper(SignUp.this);
                    mydb.updateitems("1",emaill);
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Intent i=new Intent(SignUp.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    Toast.makeText(SignUp.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MSG> call, Throwable t) {
                try {
                    Toast.makeText(SignUp.this, "You don't have internet connection", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void SignUpByGmailServer() {

           SignupService service = ApiClient.getClient().create(SignupService.class);

           Call<MSG> userCall = service.GmailData(gmail_name, gmail_email);

           userCall.enqueue(new Callback<MSG>() {
               @Override
               public void onResponse(Call<MSG> call, Response<MSG> response) {
                   try {
                       Log.d("onResponse", "" + response.body().getMessage());


                       if (response.body().getSuccess() == 0) {
                           //                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                           Toast.makeText(SignUp.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                           editor = sharedPref.edit();
                           editor.putString("emails", gmail_email);
                           //                    editor.putString("passwords", password);
                           editor.commit();
                           DtabaeHelper mydb;
                           mydb = new DtabaeHelper(SignUp.this);
                           mydb.updateitems("1", gmail_email);
                           //                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                           Intent i = new Intent(SignUp.this, MainActivity.class);
                           startActivity(i);
                           finish();
                       } else {
                           Toast.makeText(SignUp.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   } catch (Exception e) {
                       e.printStackTrace();
                   }

               }

               @Override
               public void onFailure(Call<MSG> call, Throwable t) {
                   try {
                       Toast.makeText(SignUp.this, "You don't have internet connection", Toast.LENGTH_SHORT).show();
                       Log.d("onFailure", t.toString());
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           });

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(SignUp.this,LoginSignup.class);
        startActivity(intent);
        finish();
    }
}
