package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OpenSub extends AppCompatActivity {
    Button east, west, oil,oilcity;
    ImageView openback, contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_sub);
        east= (Button) findViewById(R.id.oeast);
        west=(Button) findViewById(R.id.owest);
        oil=(Button) findViewById(R.id.oMaanbar);
        oilcity=(Button) findViewById(R.id.oilcity) ;
        contact=(ImageView)findViewById(R.id.con8);
//        all=(Button)findViewById(R.id.oall);
        openback=(ImageView)findViewById(R.id.searcopenhback);
//        all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(OpenSub.this,SearchFiltermain.class);
//                i.putExtra("regioname","Open Land");
//                startActivity(i);
//
//            }
//        });
        east.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OpenSub.this,IndLand.class);
                startActivity(i);

            }
        });
        west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OpenSub.this,CmrLand.class);
                startActivity(i);

            }
        });
        oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OpenSub.this,ResidenLand.class);
                startActivity(i);
            }
        });
        oilcity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OpenSub.this,OilCity.class);
                startActivity(i);

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OpenSub.this, ContactUs.class);
                startActivity(intent);
            }
        });
        openback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
