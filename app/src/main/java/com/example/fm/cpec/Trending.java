package com.example.fm.cpec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Trending extends AppCompatActivity implements View.OnClickListener {
ImageView commertial,residential,openland,industrial;
    LinearLayout back;
    ImageButton imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);
       commertial=findViewById(R.id.comertialtrend);
        residential=findViewById(R.id.residentialtrend);
        openland=findViewById(R.id.openlandtrend);
        industrial=findViewById(R.id.idustrialtrend);
        back=(LinearLayout) findViewById(R.id.back3);
        imgback=findViewById(R.id.imageButton);
        imgback.setOnClickListener(this);
        commertial.setOnClickListener(this);
        residential.setOnClickListener(this);
        industrial.setOnClickListener(this);
        openland.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.comertialtrend)
        {
            Intent intent=new Intent(Trending.this,LineChartActivity.class);
            intent.putExtra("plot","Commercial");
            startActivity(intent);
        }
        else if(view.getId()== R.id.idustrialtrend)
        {
            Intent intent=new Intent(Trending.this,LineChartActivity.class);
            intent.putExtra("plot", "Industrial");
            startActivity(intent);
        }
        else if(view.getId()== R.id.residentialtrend)
        {
            Intent intent=new Intent(Trending.this,LineChartActivity.class);
            intent.putExtra("plot","Residential");
            startActivity(intent);
        }
        else if(view.getId()== R.id.openlandtrend)
        {
            Intent intent=new Intent(Trending.this,LineChartActivity.class);
            intent.putExtra("plot","Open Land");
            startActivity(intent);
        }
        else if(view.getId()== R.id.back3)
        {
           super.onBackPressed();
        }
        else if(view.getId()== R.id.imageButton)
        {
            super.onBackPressed();
        }
    }
}
