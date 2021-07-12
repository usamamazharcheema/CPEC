package com.example.fm.cpec;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.google.android.gms.common.SignInButton;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
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

import java.util.Arrays;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText login_email, login_password;
    Button login_submit;
    Locale mylocale;

    CallbackManager callbackManager;
    Button fbsignin, gmailsignin;
    TextView user_name,profile_pic_dta;
    public static final int RequestSignInCode = 7;
    public FirebaseAuth firebaseAuth;
    public GoogleApiClient googleApiClient;
    String gmail_name, gmail_email,fbUserFirstName,fbUserEmail;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    public static final String Logins = "mypref";
    public static final String emails = "nameKey";
//    public static final String passwords = "emailKey";
//    public static final String Loginsf= "pref";
//    public static final String emailf = "namefKey";
//    public static final String passwordf = "emailfKey";
//    public static final String Loginsg= "prefg";
//    public static final String emailg = "namegKey";
//    public static final String passwordg = "emailgKey";


    JSONObject response, profile_pic_data, profile_pic_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_email=(EditText) findViewById(R.id.email);
       fbsignin = (Button) findViewById(R.id.facebook);
        gmailsignin = (Button) findViewById(R.id.gmail_signin);
        login_password=(EditText) findViewById(R.id.password);
        login_submit= (Button) findViewById(R.id.btn_submit);
        login_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        callbackManager = CallbackManager.Factory.create();
        FacebookSdk.sdkInitialize(getApplicationContext());
        sharedPref = getSharedPreferences(Logins, Context.MODE_PRIVATE);
//        sharedgm = getSharedPreferences(Loginsg, Context.MODE_PRIVATE);
//        sharedFb = getSharedPreferences(Loginsf, Context.MODE_PRIVATE);
        AppEventsLogger.activateApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(Login.this)
                .enableAutoManage(Login.this , new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
        fbsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(Login.this, Arrays.asList("email", "public_profile"));
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        getUserDetails(loginResult);


                    }
                    @Override
                    public void onCancel() {
                        // App code
                    }
                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
            }
        });
       gmailsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSignInMethod();
//                if (gmail_email!=null) {
////                    Toast.makeText(Login.this, gmail_email,Toast.LENGTH_LONG).show();
//                }

            }
        });
        login_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login_email.getText().toString().equals("") || login_password.getText().toString().equals(""))
                {
                    Toast.makeText(Login.this, "Please Fill Up Requiered Fields", Toast.LENGTH_LONG).show();
                }
                else
                {
                    loginByServer();
                }
            }
        });


    }

    public void UserSignInMethod(){
        Intent AuthIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);

        startActivityForResult(AuthIntent, RequestSignInCode);
    }
    public void FirebaseUserAuth(GoogleSignInAccount googleSignInAccount) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
//        Toast.makeText(Login.this,""+ authCredential.getProvider(),Toast.LENGTH_LONG).show();

        firebaseAuth.signInWithCredential(authCredential)
                .addOnCompleteListener(Login.this, new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task AuthResultTask) {
                        if (AuthResultTask.isSuccessful()){
                            // Getting Current Login user details.
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            // Hiding Login in button.
                            gmailsignin.setVisibility(View.VISIBLE);
                            gmail_name=firebaseUser.getDisplayName().toString();
                            gmail_email=firebaseUser.getEmail().toString();
                            loginByGmailServer();
//                            Toast.makeText(Login.this,firebaseUser.getDisplayName().toString(),Toast.LENGTH_LONG).show();

                        }else {
                            Toast.makeText(Login.this,"Something Went Wrong",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
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
        gmailsignin.setVisibility(View.VISIBLE);
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
                super.onActivityResult(requestCode, resultCode, data);

                if (requestCode == RequestSignInCode){

                    GoogleSignInResult googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

                    if (googleSignInResult.isSuccess()){

                        GoogleSignInAccount googleSignInAccount = googleSignInResult.getSignInAccount();

                        FirebaseUserAuth(googleSignInAccount);


                    }
                }





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
//                            user_name.setText(fbUserFirstName);
                            loginByFbServer();
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
    private void loginByServer() {

        final String email = login_email.getText().toString();
        final String password = login_password.getText().toString();
        LoginService service = ApiClient.getClient().create(LoginService.class);
        Call<MSG> userCall = service.userLogIn(email,password);

        userCall.enqueue(new Callback<MSG>() {
            @Override
            public void onResponse(Call<MSG> call, Response<MSG> response) {
//                hidepDialog();
                //onSignupSuccess();
                Log.d("onResponse", "" + response.body().getMessage());
                if(response.body().getSuccess() == 1) {
                     editor= sharedPref.edit();
                    editor.putString("emails", email);
//                    editor.putString("passwords", password);
                    editor.commit();
                    DtabaeHelper mydb;
                    mydb=new DtabaeHelper(Login.this);
                    mydb.updateitems("1",email);
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Intent i=new Intent(Login.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    Toast.makeText(Login.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MSG> call, Throwable t) {
                Toast.makeText(Login.this, "Failure", Toast.LENGTH_SHORT).show();
                Log.d("onFailure", t.toString());
            }
        });
    }

    private void loginByGmailServer() {
        if (gmail_name != null & gmail_email != null) {
            LoginService service = ApiClient.getClient().create(LoginService.class);
            Call<MSG> userCall = service.userGmailLogIn(gmail_email, gmail_name);

            userCall.enqueue(new Callback<MSG>() {
                @Override
                public void onResponse(Call<MSG> call, Response<MSG> response) {
//                hidepDialog();
                    //onSignupSuccess();
                    Log.d("onResponse", "" + response.body().getMessage());


                    if (response.body().getSuccess() == 1) {
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        editor= sharedPref.edit();
//                        editorg.putString("emailg", gmail_name);
                        editor.putString("emails",gmail_email);
                        editor.commit();
                        DtabaeHelper mydb;
                        mydb=new DtabaeHelper(Login.this);
                        mydb.updateitems("1",gmail_email);
                        Toast.makeText(Login.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(Login.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MSG> call, Throwable t) {
                    Toast.makeText(Login.this, "Failure", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                }
            });
        }
    }
    private void loginByFbServer() {

            LoginService service = ApiClient.getClient().create(LoginService.class);
            Call<MSG> userCall = service.userFbLogIn(fbUserEmail, fbUserFirstName);

            userCall.enqueue(new Callback<MSG>() {
                @Override
                public void onResponse(Call<MSG> call, Response<MSG> response) {
//                hidepDialog();
                    //onSignupSuccess();
                    Log.d("onResponse", "" + response.body().getMessage());


                    if (response.body().getSuccess() == 1) {
                        editor= sharedPref.edit();
                        editor.putString("emails", fbUserEmail);
//                        editorf.putString("passwordf", fbUserFirstName);
                        editor.commit();
                        DtabaeHelper mydb;
                        mydb=new DtabaeHelper(Login.this);
                        mydb.updateitems("1",fbUserEmail);
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        Toast.makeText(Login.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(Login.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MSG> call, Throwable t) {
                    Toast.makeText(Login.this, "Failure", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                }
            });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Login.this,LoginSignup.class);
        startActivity(intent);
        finish();
    }
}
