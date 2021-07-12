package com.example.fm.cpec;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

/**
 * Created by fm on 12/7/2017.
 */

public class LoginSignup extends Activity {
    Button login,signup;
    Locale mylocale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsignup);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
//        Intent in=getIntent();
//        Bundle b=in.getExtras();
//        if(b!=null){
//            String s=b.getString("language");
//            if (s.equals("eng"))
//            {
//                setLanguage("en");
//            }
//            else if(s.equals("urdu"))
//            {
//                setLanguage("ur");
//            }
//
//            else if(s.equals("chi"))
//            {
//                setLanguage("zh");
//            }
//        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginSignup.this,Login.class);
                startActivity(intent);
                finish();

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginSignup.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });

    }
//    protected void setLanguage(String language){
//        mylocale=new Locale(language);
//        Resources resources=getResources();
//        DisplayMetrics dm=resources.getDisplayMetrics();
//        Configuration conf= resources.getConfiguration();
//        conf.locale=mylocale;
//        resources.updateConfiguration(conf,dm);
//        Intent refreshIntent=new Intent(LoginSignup.this,LoginSignup.class);
//        startActivity(refreshIntent);
//
//
//    }
}
