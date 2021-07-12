package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CmBechPhase extends AppCompatActivity {
    ImageView csantownback,contact;
    Button bcsphase1,bcsphase2,bcsphase3,bcsphase4,bcsphase5,bcsphase6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_bech_phase);
        bcsphase1=(Button) findViewById(R.id.bcsphase1);
        bcsphase2=(Button)findViewById(R.id.bcsphase2);
        bcsphase3=(Button)findViewById(R.id.bcsphase3);
        bcsphase4=(Button)findViewById(R.id.bcsphase4);
        bcsphase5=(Button)findViewById(R.id.bcsphase5);
       contact=(ImageView)findViewById(R.id.bcsphase6);
        csantownback=(ImageView)findViewById(R.id.searcmbphback);
        bcsphase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmBechPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","BECHS");
                intent.putExtra("phase", "Commercial Zone");
                startActivity(intent);

            }
        });
        bcsphase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmBechPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","BECHS");
                intent.putExtra("phase", "Mini Commercial");
                startActivity(intent);

            }
        });
        bcsphase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmBechPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","BECHS");
                intent.putExtra("phase", "Panjgur Avenue");
                startActivity(intent);

            }
        });
        bcsphase4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmBechPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","BECHS");
                intent.putExtra("phase", "Marine Front");
                startActivity(intent);

            }
        });
        bcsphase5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmBechPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","BECHS");
                intent.putExtra("phase", "Padizar Front");
                startActivity(intent);

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmBechPhase.this, ContactUs.class);
                startActivity(intent);

            }
        });
        csantownback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
