package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OilCity extends AppCompatActivity {
    ImageView backpres,contact;
    Button mozahdarbela,mSurbandar,mShankanidar,mKhappar,mNailent,mZiarat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil_city);
        mozahdarbela=(Button)findViewById(R.id.mchoken);
        mSurbandar=(Button)findViewById(R.id.mshumal);
        mShankanidar=(Button)findViewById(R.id.mshatangi);
        mKhappar=(Button)findViewById(R.id.mchakli);
        mNailent=(Button)findViewById(R.id.mchurbanber);
        mZiarat=(Button)findViewById(R.id.mpasni);
        backpres=(ImageView)findViewById(R.id.osearcopenhback);
        contact=(ImageView)findViewById(R.id.con12);
        mozahdarbela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OilCity.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Oil City");
                i.putExtra("phase", "Mozah Chokeen");
                startActivity(i);

            }
        });
        mSurbandar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OilCity.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Oil City");
                i.putExtra("phase", "Mozah Shumal Bandhan");
                startActivity(i);

            }
        });
        mShankanidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OilCity.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Oil City");
                i.putExtra("phase", "Mozah Shatangi");
                startActivity(i);

            }
        });
        mKhappar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OilCity.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Oil City");
                i.putExtra("phase", "Mozah Chakli");
                startActivity(i);

            }
        });
        mNailent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OilCity.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Oil City");
                i.putExtra("phase", "Mozah Churbanber");
                startActivity(i);

            }
        });
        mZiarat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OilCity.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Oil City");
                i.putExtra("phase", "Mozah Pasni");
                startActivity(i);

            }
        });
        backpres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OilCity.this, ContactUs.class);
                startActivity(intent);
            }
        });

    }
}
