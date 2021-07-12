package com.example.fm.cpec;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Usama Cheema on 12/15/2017.
 */

public class SerachFilterOnsearch extends Activity {
    int c=0;
    SearchFilterOpenAdapter adapter;
    RecyclerView recyclerView;
    ImageView image;
    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchfilternsearch);

        mainlist.clear();
        image= (ImageView) findViewById(R.id.sfback);

        recyclerView = (RecyclerView) findViewById(R.id.searchrecyclerview);
        adapter=new SearchFilterOpenAdapter(0,SerachFilterOnsearch.this,mainlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SerachFilterOnsearch.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recallmethod(c);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void recallmethod(int j)
    {
        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<MainResponselist> userCall =service.searchfilteropen(MainActivity.regionname,Integer.parseInt(MainActivity.minprice),Integer.parseInt(MainActivity.maxprice),Integer.parseInt(MainActivity.minarea),Integer.parseInt(MainActivity.maxarea),j);

        userCall.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();

                if (mainview!=null) {
                    for (int i = 0; i < mainview.size(); i = i + 1) {
                        mainlist.add(mainview.get(i));
                        mainview.clear();
                    }

                    adapter.notifyDataSetChanged();
                    c=c+1;
                    recallmethod(c);
//                                Toast.makeText(getActivity(), String.valueOf(mainlist.size()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResponselist> call, Throwable t) {
                try {
                    Toast.makeText(SerachFilterOnsearch.this, "You don't have internet connection", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
