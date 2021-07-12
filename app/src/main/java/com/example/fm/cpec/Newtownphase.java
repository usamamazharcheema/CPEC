package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Newtownphase extends AppCompatActivity {
    Button phase1,phase2,phase3,phase4,phase5;
    ImageView newtownback,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtownphase);
        phase1=(Button) findViewById(R.id.phase1);
        phase2=(Button)findViewById(R.id.phase2);
        phase3=(Button)findViewById(R.id.phase3);
        phase4=(Button)findViewById(R.id.phase4);
        phase5=(Button)findViewById(R.id.phase5);
        contact=(ImageView) findViewById(R.id.cont4);
        newtownback=(ImageView)findViewById(R.id.searchphback);
        newtownback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        phase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Newtownphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Phase 1");
                startActivity(intent);

            }
        });
        phase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Newtownphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Phase 2");
                startActivity(intent);

            }
        });
        phase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Newtownphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Phase 3");
                startActivity(intent);

            }
        });
        phase4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Newtownphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Phase 4");
                startActivity(intent);

            }
        });
        phase5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Newtownphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","New Town");
                intent.putExtra("phase", "Phase 5");
                startActivity(intent);

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Newtownphase.this, ContactUs.class);
                startActivity(intent);
            }
        });

    }
}
