package com.example.fm.cpec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityCatogory extends AppCompatActivity {
    int c=0;
    private RecyclerView recyclerView;
    String regioname;
    ImageView cityback,contactus;
    CityAdapter cityAdapter;
    TextView cityname;
    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_catogory);
        mainlist.clear();
        recyclerView = (RecyclerView) findViewById(R.id.searchcityrecyclerview);
        cityback= (ImageView) findViewById(R.id.cityback);
        contactus=(ImageView) findViewById(R.id.contactus);
        cityname=(TextView) findViewById(R.id.cityplot);
        cityAdapter=new CityAdapter(mainlist,R.layout.citylayout,CityCatogory.this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cityAdapter);
        cityAdapter.notifyDataSetChanged();
        Bundle bundle = getIntent().getExtras();
        regioname = bundle.getString("regioname");
        cityname.setText(regioname.toUpperCase());

        recallmethod(c);
        cityback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CityCatogory.this, ContactUs.class);
                startActivity(intent);

            }
        });
    }
    public void recallmethod(int j)
    {
        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<MainResponselist> userCall =service.searchcityfilter(j, regioname);

        userCall.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();

                if (mainview!=null) {
                    for (int i = 0; i < mainview.size(); i = i + 1) {
                        mainlist.add(mainview.get(i));
                        mainview.clear();
                    }

                    cityAdapter.notifyDataSetChanged();
                    c=c+1;
                    recallmethod(c);
//                                Toast.makeText(getActivity(), String.valueOf(mainlist.size()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResponselist> call, Throwable t) {
                Toast.makeText(CityCatogory.this, "You don't have internet connection", Toast.LENGTH_SHORT).show();
                Log.d("onFailure", t.toString());
            }
        });
    }
}
