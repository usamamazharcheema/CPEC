package com.example.fm.cpec;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResidenLand extends AppCompatActivity {
    ImageView backpres,contact;
    Button mchattish,mankarash,mnigoor,mmazani,mpalleri,mgamaro,mshabi,mpishukan,mpassu,mgunz,mrobar,mbandi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residen_land);
        backpres=(ImageView) findViewById(R.id.rsearcopenhback);
        contact=(ImageView) findViewById(R.id.con11);
        mchattish=(Button) findViewById(R.id.mcshumalli);
        mankarash=(Button) findViewById(R.id.mashumali);
        mnigoor=(Button) findViewById(R.id.mnigoor);
        mmazani=(Button) findViewById(R.id.mmazani);
        mpalleri=(Button)findViewById(R.id.mpalleri);
        mgamaro=(Button) findViewById(R.id.mgamaro);
        mshabi=(Button) findViewById(R.id.mshabi);
        mpishukan=(Button) findViewById(R.id.mpishukan);
        mpassu=(Button) findViewById(R.id.mpassu);
        mgunz=(Button) findViewById(R.id.mguns);
        mrobar=(Button) findViewById(R.id.mrobar);
        mbandi=(Button) findViewById(R.id.mbandi);
        backpres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResidenLand.this, ContactUs.class);
                startActivity(intent);
            }
        });
        mchattish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Chatti Shumali");
                startActivity(i);

            }
        });
        mankarash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Ankara Shumali");
                startActivity(i);

            }
        });
        mnigoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Nigoor");
                startActivity(i);

            }
        });
        mmazani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Mazani");
                startActivity(i);

            }
        });
        mpalleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Palleri Sharqi Gharbi");
                startActivity(i);

            }
        });
        mgamaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Gamaro");
                startActivity(i);

            }
        });
        mshabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Shabi");
                startActivity(i);

            }
        });
        mpishukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Pishukan");
                startActivity(i);

            }
        });
        mpassu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Passu");
                startActivity(i);

            }
        });
        mgunz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Gunz");
                startActivity(i);

            }
        });
        mrobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Robar");
                startActivity(i);

            }
        });
        mbandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ResidenLand.this,SearchFiltermain.class);
                i.putExtra("rregioname","Open land");
                i.putExtra("areaname","Residential Land");
                i.putExtra("phase", "Mozah Bandi");
                startActivity(i);

            }
        });
    }
}
