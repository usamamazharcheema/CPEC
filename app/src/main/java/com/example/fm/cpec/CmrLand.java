package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CmrLand extends AppCompatActivity {
    ImageView backpres,contact;
    Button mozahdarbela,mSurbandar,mShankanidar,mKhappar,mNailent,mZiarat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmr_land);
        mozahdarbela=(Button)findViewById(R.id.mdhor);
        mSurbandar=(Button)findViewById(R.id.mwashin);
        mShankanidar=(Button)findViewById(R.id.mchi);
        mKhappar=(Button)findViewById(R.id.mkia);
        mNailent=(Button)findViewById(R.id.mankara);
        mZiarat=(Button)findViewById(R.id.mchatti);
        backpres=(ImageView)findViewById(R.id.csearcopenhback);
        contact=(ImageView)findViewById(R.id.con11);
        mozahdarbela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CmrLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Commercial Land");
                i.putExtra("phase", "Mozah Dhor Ghatti");
                startActivity(i);

            }
        });
        mSurbandar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CmrLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Commercial Land");
                i.putExtra("phase", "Mozah Washin Door");
                startActivity(i);

            }
        });
        mShankanidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CmrLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Commercial Land");
                i.putExtra("phase", "Mozah Chibkalmati");
                startActivity(i);

            }
        });
        mKhappar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CmrLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Commercial Land");
                i.putExtra("phase", "Mozah Kia Kallat");
                startActivity(i);

            }
        });
        mNailent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CmrLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Commercial Land");
                i.putExtra("phase", "Mozah Ankara Janoobi");
                startActivity(i);

            }
        });
        mZiarat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CmrLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Commercial Land");
                i.putExtra("phase", "Mozah Chatti Janoobi");
                startActivity(i);

            }
        });
        backpres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmrLand.this, ContactUs.class);
                startActivity(intent);
            }
        });


    }
}
