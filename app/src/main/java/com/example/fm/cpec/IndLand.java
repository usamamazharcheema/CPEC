package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class IndLand extends AppCompatActivity {
    Button mozahdarbela,mSurbandar,mShankanidar,mKhappar,mNailent,mZiarat,mJorkan,mChibrikani,mDarbela;
    ImageView backpres,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ind_land);
        mozahdarbela=(Button)findViewById(R.id.mozahd);
        mSurbandar=(Button)findViewById(R.id.mozahsu);
        mShankanidar=(Button)findViewById(R.id.mozahsh);
        mKhappar=(Button)findViewById(R.id.mozahkh);
        mNailent=(Button)findViewById(R.id.mozahnai);
        mZiarat=(Button)findViewById(R.id.mozahzia);
        mJorkan=(Button)findViewById(R.id.mozahjo);
        mChibrikani=(Button)findViewById(R.id.mozahchi);
        mDarbela=(Button)findViewById(R.id.mozahdar);
        backpres=(ImageView)findViewById(R.id.isearcopenhback);
        contact=(ImageView)findViewById(R.id.con6);
        mozahdarbela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Industrial Warehouse Land");
                i.putExtra("phase", "Mozah Darbela Janoobi");
                startActivity(i);

            }
        });
        mSurbandar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Industrial Warehouse land");
                i.putExtra("phase", "Mozah Surbandar");
                startActivity(i);

            }
        });
        mShankanidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Industrial Warehouse land");
                i.putExtra("phase", "Mozah Shankanidar");
                startActivity(i);

            }
        });
        mKhappar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Industrial Warehouse land");
                i.putExtra("phase", "Mozah Khappar");
                startActivity(i);

            }
        });
        mNailent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Industrial Warehouse land");
                i.putExtra("phase", "Mozah Nailent");
                startActivity(i);

            }
        });
        mZiarat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Industrial Warehouse land");
                i.putExtra("phase", "Mozah Ziarat Machi Sharqi Gharbi");
                startActivity(i);

            }
        });
        mJorkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Industrial Warehouse land");
                i.putExtra("phase", "Mozah Jorkan");
                startActivity(i);

            }
        });
        mChibrikani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Industrial Warehouse land");
                i.putExtra("phase", "Mozah Chibrikani");
                startActivity(i);

            }
        });
        mDarbela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Industrial Warehouse land");
                i.putExtra("phase", "Mozah Darbela Shumali");
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
                Intent intent=new Intent(IndLand.this, ContactUs.class);
                startActivity(intent);
            }
        });



    }
}
