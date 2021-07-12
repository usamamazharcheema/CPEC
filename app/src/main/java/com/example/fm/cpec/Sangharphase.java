package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Sangharphase extends AppCompatActivity {
    ImageView sback,contact;
    Button sphase1,sphase2,sphase3,sphase2e,sphase3e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sangharphase);
        sphase1=(Button) findViewById(R.id.sphase1);
        sphase2=(Button)findViewById(R.id.sphase2);
        sphase3=(Button)findViewById(R.id.sphase3);
        sphase2e=(Button)findViewById(R.id.sphase2e);
        sphase3e=(Button)findViewById(R.id.sphase3e);
        contact=(ImageView)findViewById(R.id.contact1);
        sback=(ImageView)findViewById(R.id.searchshback);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Sangharphase.this, ContactUs.class);
                startActivity(intent);
            }
        });
        sphase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sangharphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","Sanghar");
                intent.putExtra("phase", "Phase 1");
                startActivity(intent);

            }
        });
        sphase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sangharphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","Sanghar");
                intent.putExtra("phase", "Phase 2");
                startActivity(intent);

            }
        });
        sphase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sangharphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","Sanghar");
                intent.putExtra("phase", "Phase 3");
                startActivity(intent);

            }
        });
        sphase2e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sangharphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","Sanghar");
                intent.putExtra("phase", "Phase 2(Extension)");
                startActivity(intent);

            }
        });
        sphase3e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sangharphase.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Residential");
                intent.putExtra("areaname","Sanghar");
                intent.putExtra("phase", "Phase 3(Extension)");
                startActivity(intent);
            }
        });
        sback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
