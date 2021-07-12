package com.example.fm.cpec;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mypropertyget extends AppCompatActivity {
    private ProgressBar bar;

    private RecyclerView recyclerView;
    int c=0;
    int b=0;
    String getemailfav=null;
    DtabaeHelper mydb;
    ImageView imageView;
    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
    public HomeRecyclerViewAdapter homeRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypropertyget);
        mydb=new DtabaeHelper(this);
        Cursor c1=mydb.checkitems();
        if(c1.getCount()==0)
        {

        }
        else
        {
            while (c1.moveToNext())
            {
                getemailfav=c1.getString(1).toString();
            }
        }
        recyclerView = (RecyclerView) findViewById(R.id.favrecyclerview);
        bar = (ProgressBar) findViewById(R.id.favprogressBar);
        homeRecyclerViewAdapter=new HomeRecyclerViewAdapter(0,this,mainlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(homeRecyclerViewAdapter);
        homeRecyclerViewAdapter.notifyDataSetChanged();
        imageView= (ImageView) findViewById(R.id.proarrowback);
        recallmethod(c);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void recallmethod(int j)
    {
        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<MainResponselist> userCall =service.getmyproperty(getemailfav,j);

        userCall.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();

                if (mainview!=null) {
                    for (int i = 0; i < mainview.size(); i = i + 1) {
                        mainlist.add(mainview.get(i));
                    }

                    homeRecyclerViewAdapter.notifyDataSetChanged();
                    c=c+1;
                    recallmethod(c);
//                                Toast.makeText(getActivity(), String.valueOf(mainlist.size()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResponselist> call, Throwable t) {
//                Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();
                Log.d("onFailure", t.toString());
            }
        });
    }
}
