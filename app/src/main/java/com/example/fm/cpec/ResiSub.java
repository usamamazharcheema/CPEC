package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResiSub extends AppCompatActivity {
 Button newtown, sanghar, maanbar, bechs, batail;
    ImageView resiback,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resi_sub);
        newtown= (Button) findViewById(R.id.newtown);
        sanghar=(Button) findViewById(R.id.sanghar);
        maanbar=(Button) findViewById(R.id.Maanbar);
        bechs=(Button) findViewById(R.id.Bechs);
        batail=(Button) findViewById(R.id.Batail);
//        all=(Button) findViewById(R.id.all);
        contact=(ImageView) findViewById(R.id.con);
        resiback=(ImageView)findViewById(R.id.searchresiback);
//        all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(ResiSub.this,SearchFiltermain.class);
//                i.putExtra("regioname","Residential");
//
//               startActivity(i);
//
//            }
//        });
        newtown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ResiSub.this,Newtownphase.class);
                startActivity(i);
            }
        });
        sanghar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ResiSub.this,Sangharphase.class);
                startActivity(i);

            }
        });
        maanbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ResiSub.this,SearchFiltermain.class);
                i.putExtra("mregioname","Residential");
                i.putExtra("mareaname","Maanbar");
                startActivity(i);

            }
        });
        bechs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ResiSub.this,SearchFiltermain.class);
                i.putExtra("mregioname","Residential");
                i.putExtra("mareaname","BECHS");
                startActivity(i);

            }
        });
        batail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ResiSub.this,SearchFiltermain.class);
                i.putExtra("mregioname","Residential");
                i.putExtra("mareaname","Batail");
                startActivity(i);

            }
        });
        resiback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResiSub.this,ContactUs.class);
                startActivity(i);
            }
        });

    }
}
