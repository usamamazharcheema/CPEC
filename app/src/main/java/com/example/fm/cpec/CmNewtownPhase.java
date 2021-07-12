package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CmNewtownPhase extends AppCompatActivity {
    ImageView cnewtownback;
    Button cphase1,cphase2,cphase3,cphase4,cphase5,cphase6,cphase7,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_newtown_phase);
        cphase1=(Button) findViewById(R.id.cphase1);
        cphase2=(Button)findViewById(R.id.cphase2);
        cphase3=(Button)findViewById(R.id.cphase3);
        cphase4=(Button)findViewById(R.id.cphase4);
        cphase5=(Button)findViewById(R.id.cphase5);
        cphase6=(Button)findViewById(R.id.cphase6);
        cphase7=(Button)findViewById(R.id.cphase7);
        contact=(Button)findViewById(R.id.cphase8);
        cnewtownback=(ImageView)findViewById(R.id.searcmnphback);
        cphase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmNewtownPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Commercial Zone");
                startActivity(intent);

            }
        });
        cphase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmNewtownPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Mini Commercial");
                startActivity(intent);

            }
        });
        cphase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmNewtownPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Pishukan Commercial");
                startActivity(intent);

            }
        });
        cphase4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmNewtownPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Airport Road");
                startActivity(intent);

            }
        });
        cphase5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmNewtownPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Marine Front");
                startActivity(intent);

            }
        });
        cphase6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmNewtownPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Padizar Boulevard");
                startActivity(intent);

            }
        });
        cphase7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmNewtownPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Link Road");
                startActivity(intent);

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CmNewtownPhase.this, ContactUs.class);
                startActivity(intent);
            }
        });
        cnewtownback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
