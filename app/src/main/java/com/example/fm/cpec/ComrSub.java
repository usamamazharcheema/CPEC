package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ComrSub extends AppCompatActivity {
    Button newtown, sanghar, maanbar, bechs, gie,pisk,airport;
    ImageView cmrback,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comr_sub);
        newtown= (Button) findViewById(R.id.cnewtown);
        sanghar=(Button) findViewById(R.id.csanghar);
        maanbar=(Button) findViewById(R.id.cMaanbar);
        bechs=(Button) findViewById(R.id.cBechs);
        gie=(Button) findViewById(R.id.cBatail);
//        all=(Button) findViewById(R.id.call);
        contact=(ImageView)findViewById(R.id.cont);
//        pisk=(Button)findViewById(R.id.cpis);
//        airport=(Button) findViewById(R.id.cair);
        cmrback=(ImageView)findViewById(R.id.searchcmrback);
//        all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(ComrSub.this,SearchFiltermain.class);
//                i.putExtra("regioname","Commercial");
//                startActivity(i);
//
//            }
//        });
        newtown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ComrSub.this,CmNewtownPhase.class);

                startActivity(i);


            }
        });
        sanghar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ComrSub.this,CmSangPhase.class);
                startActivity(i);

            }
        });
        maanbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ComrSub.this,SearchFiltermain.class);
                i.putExtra("mregioname","Commercial");
                i.putExtra("mareaname","Maanbar");
                startActivity(i);

            }
        });
        bechs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ComrSub.this,CmBechPhase.class);
                startActivity(i);

            }
        });
        gie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ComrSub.this,CmGiePh.class);

                startActivity(i);

            }
        });
//        airport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(ComrSub.this,SearchFiltermain.class);
//                i.putExtra("mregioname","Commercial");
//                i.putExtra("mareaname","Air Port Road");
//                startActivity(i);
//
//            }
//        });
//        pisk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(ComrSub.this,SearchFiltermain.class);
//                i.putExtra("mregioname","Commercial");
//                i.putExtra("mareaname","Pishukan Avenue");
//                startActivity(i);
//
//            }
//        });
        cmrback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ComrSub.this, ContactUs.class);
                startActivity(intent);
            }
        });
    }
}
