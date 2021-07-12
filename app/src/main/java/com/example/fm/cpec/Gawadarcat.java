package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Gawadarcat extends AppCompatActivity {
    ImageView resi,commer,indus,openland,gwdback,contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gawadarcat);
        resi=(ImageView)findViewById(R.id.gresidentialsearchfragment);
        commer=(ImageView)findViewById(R.id.gcommertialsearchfragment);
        indus=(ImageView)findViewById(R.id.gindustrialsearchfragmenr);
        openland=(ImageView)findViewById(R.id.gopenlandsearchfragment);
        gwdback=(ImageView) findViewById(R.id.searchgwdback);
        contact=(ImageView) findViewById(R.id.contactu);
       resi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Gawadarcat.this,ResiSub.class);
               startActivity(i);
           }
       });
        commer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gawadarcat.this,ComrSub.class);
                startActivity(i);

            }
        });
        indus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gawadarcat.this,SearchFiltermain.class);
                i.putExtra("regioname","Gawadar Industrial Estate");
                startActivity(i);
            }
        });
        openland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gawadarcat.this,OpenSub.class);
                startActivity(i);
            }
        });
        gwdback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Gawadarcat.this,ContactUs.class);
                startActivity(i);
            }
        });
    }
}
