package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CmGiePh extends AppCompatActivity {
    ImageView csantownback,contact;
    Button bcsphase1,bcsphase2,bcsphase3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_gie_ph);
        bcsphase1=(Button) findViewById(R.id.gcsphase1);
        bcsphase2=(Button)findViewById(R.id.gcsphase2);
        bcsphase3=(Button)findViewById(R.id.gcsphase3);
        contact=(ImageView)findViewById(R.id.gcsphase6);
        csantownback=(ImageView)findViewById(R.id.searcmgphback);
        bcsphase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmGiePh.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","Gawadar Industrial Estate");
                intent.putExtra("phase", "Mini Commecial");
                startActivity(intent);
            }
        });
        bcsphase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmGiePh.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","Gawadar Industrial Estate");
                intent.putExtra("phase", "Coastal Highway Commercial");
                startActivity(intent);

            }
        });
        bcsphase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmGiePh.this, SearchFiltermain.class);
                intent.putExtra("rregioname","Commercial");
                intent.putExtra("areaname","Gawadar Industrial Estate");
                intent.putExtra("phase", "Commercial Zone");
                startActivity(intent);

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CmGiePh.this, ContactUs.class);
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
