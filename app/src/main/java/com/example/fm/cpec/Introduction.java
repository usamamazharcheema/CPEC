package com.example.fm.cpec;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Introduction extends AppCompatActivity {
    Button next;
    SharedPreferences sharedpreferences;
    String email;
    public static final String Logins = "mypref";
    public static final String emails = "nameKey";
    Locale mylocale;
    DtabaeHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        next= (Button) findViewById(R.id.next);
        sharedpreferences = getSharedPreferences(Logins, Context.MODE_PRIVATE);
        email = sharedpreferences.getString("emails", null);
        Intent in=getIntent();
        Bundle b=in.getExtras();
        mydb=new DtabaeHelper(this);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = mydb.checkitems();
                if(cursor.getCount()==0){
//                    mydb.insertitem("");
//                    Toast.makeText(getApplicationContext(),"Database is Empty",Toast.LENGTH_SHORT).show();
                }
                else {
            StringBuffer data = new StringBuffer();
            while (cursor.moveToNext()){
                String email1=cursor.getString(1);
                if (email1.equals("") ) {
                    Intent intent = new Intent(Introduction.this, LoginSignup.class);
                    startActivity(intent);

                }
                else {

                    Intent intent = new Intent(Introduction.this, MainActivity.class);
                    startActivity(intent);
                }
            }
                }




            }
        });
        if(b!=null){
            String s=b.getString("language");
            if (s.equals("eng"))
            {
                setLanguage("en");
            }
            else if(s.equals("urdu"))
            {
                setLanguage("ur");
            }

            else if(s.equals("chi"))
            {
                setLanguage("zh");
            }
        }
    }
    protected void setLanguage(String language){
        mylocale=new Locale(language);
        Resources resources=getResources();
        DisplayMetrics dm=resources.getDisplayMetrics();
        Configuration conf= resources.getConfiguration();
        conf.locale=mylocale;
        resources.updateConfiguration(conf,dm);
        Intent refreshIntent=new Intent(Introduction.this,Introduction.class);
        startActivity(refreshIntent);
finish();

    }
}
