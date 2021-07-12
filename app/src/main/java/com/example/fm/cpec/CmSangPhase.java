package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CmSangPhase extends AppCompatActivity {
    ImageView csantownback,contact;
    Button csphase1,csphase2,csphase3,csphase4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_sang_phase);
        csphase1=(Button) findViewById(R.id.csphase1);
        csphase2=(Button)findViewById(R.id.csphase2);
        csphase3=(Button)findViewById(R.id.csphase3);
        csphase4=(Button)findViewById(R.id.csphase4);
        contact=(ImageView) findViewById(R.id.csphase5);
        csantownback=(ImageView)findViewById(R.id.searcmsphback);
        csphase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmSangPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","Sanghar");
                intent.putExtra("phase", "Phase 1");
                startActivity(intent);

            }
        });
        csphase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmSangPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","Sanghar");
                intent.putExtra("phase", "Phase 2");
                startActivity(intent);

            }
        });
        csphase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmSangPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","Sanghar");
                intent.putExtra("phase", "Phase 3");
                startActivity(intent);

            }
        });
        csphase4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmSangPhase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","Sanghar");
                intent.putExtra("phase", "High Rise");
                startActivity(intent);

            }
        });
        csantownback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CmSangPhase.this, ContactUs.class);
                startActivity(intent);
            }
        });
    }
}
