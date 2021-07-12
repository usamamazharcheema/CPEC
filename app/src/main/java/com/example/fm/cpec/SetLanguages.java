package com.example.fm.cpec;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class SetLanguages extends AppCompatActivity {
      Button btn_english, btn_urdu, btn_chineese;
//    public static final String passwords = "emailKey";
//    public static final String Loginsf= "pref";
//    public static final String emailf = "namefKey";
//    public static final String passwordf = "emailfKey";
//    public static final String Loginsg= "prefg";
//    public static final String emailg = "namegKey";
//    public static final String passwordg = "emailgKey";
DtabaeHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_languages);
        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.CALL_PHONE, android.Manifest.permission.SEND_SMS, android.Manifest.permission.ACCESS_NETWORK_STATE,
                android.Manifest.permission.ACCESS_WIFI_STATE, android.Manifest.permission.INTERNET,android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
        mydb=new DtabaeHelper(this);
       Cursor cursor = mydb.checkitems();
        if(cursor.getCount()==0){
mydb.insertitem("");
            Toast.makeText(getApplicationContext(),"Database is Empty",Toast.LENGTH_SHORT).show();
        }
        else {
            /*StringBuffer data = new StringBuffer();
            while (cursor.moveToNext()){

            }*/
        }
        btn_english=(Button)findViewById(R.id.english1);
        btn_urdu=(Button) findViewById(R.id.urdu);
        btn_chineese=(Button)findViewById(R.id.chineese);
//        sharedf= getSharedPreferences(Loginsf, Context.MODE_PRIVATE);
//        sharedg= getSharedPreferences(Loginsg, Context.MODE_PRIVATE);
    }
public  void eng(View view) {

                Intent i = new Intent(SetLanguages.this, Introduction.class);
                i.putExtra("language", "eng");
                startActivity(i);
            }

//    password = sharedpreferences.getString("passwords", "");
//    emailgm = sharedpreferences.getString("emailg", "");
//    passwordgm = sharedpreferences.getString("passwordg", "");
//    emailfb = sharedpreferences.getString("emailf", "");
//    passwordfb = sharedpreferences.getString("passwordf", "");
//    Toast.makeText(SetLanguages.this, email, Toast.LENGTH_LONG).show();
//    switch (view.getId()) {
//        case 0:
//
//            if (email == "" & password == "") {
//                Intent i = new Intent(SetLanguages.this, LoginSignup.class);
//                i.putExtra("language", "eng");
//                startActivity(i);
//            } else {
//                Toast.makeText(SetLanguages.this, email, Toast.LENGTH_LONG).show();
//                Intent i = new Intent(SetLanguages.this, Introduction.class);
//                i.putExtra("language", "eng");
//                startActivity(i);
//            }
//            break;
//        case 1:
//            if (emailgm == "" & passwordgm == "") {
//                Intent i = new Intent(SetLanguages.this, LoginSignup.class);
//                i.putExtra("language", "eng");
//                startActivity(i);
//            } else {
//                Toast.makeText(SetLanguages.this, email, Toast.LENGTH_LONG).show();
//                Intent i = new Intent(SetLanguages.this, Introduction.class);
//                i.putExtra("language", "eng");
//                startActivity(i);
//            }
//            break;
//        case 2:
//            if (emailfb == "" & passwordfb == "") {
//                Intent i = new Intent(SetLanguages.this, LoginSignup.class);
//                i.putExtra("language", "eng");
//                startActivity(i);
//            } else {
//                Toast.makeText(SetLanguages.this, email, Toast.LENGTH_LONG).show();
//                Intent i = new Intent(SetLanguages.this, Introduction.class);
//                i.putExtra("language", "eng");
//                startActivity(i);
//            }
//            break;
//    }
    public  void uru(View view)
    {
            Intent i = new Intent(SetLanguages.this, Introduction.class);
            i.putExtra("language", "urdu");
            startActivity(i);
        }

    public  void chi(View view)
    {
            Intent i = new Intent(SetLanguages.this, Introduction.class);
            i.putExtra("language", "chi");
            startActivity(i);
    }
    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
