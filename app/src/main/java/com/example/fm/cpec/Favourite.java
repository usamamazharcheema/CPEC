package com.example.fm.cpec;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by kamraan on 12/8/2017.
 */
public class Favourite extends Activity {
    private ProgressBar bar;
    public static final String TITLE = "Favourite";
    private RecyclerView recyclerView;
    private static final String TAG = MainActivity.class.getSimpleName();
    int c=0;
    int b=0;
    private final static String API_KEY = "https://cpecintel.000webhostapp.com/Industrial/login/favselect.php";
    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
    DtabaeHelper mydb;
    String getemailfav=null;
    ImageView favarrowback;
    public FavouiteAdapter homeRecyclerViewAdapter;
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
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
        favarrowback= (ImageView) findViewById(R.id.favarrowback);
        favarrowback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Favourite.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        homeRecyclerViewAdapter=new FavouiteAdapter(mainlist, R.layout.sfilter, Favourite.this);
        recyclerView.setAdapter(homeRecyclerViewAdapter);
        NumberOfRowsMain apiService = ApiClient.getClient().create(NumberOfRowsMain.class);
//        Toast.makeText(this, getemailfav, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, getemailfav, Toast.LENGTH_SHORT).show();
        Call<MainResponselist> call = apiService.favlistget(getemailfav,c);
        call.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
                int statusCode = response.code();
                ArrayList<MainViewResponse> movies = (ArrayList<MainViewResponse>) response.body().getResults();
//                Toast.makeText(Favourite.this, getemailfav, Toast.LENGTH_SHORT).show();
                if (movies != null) {

                    for (int i = 0; i < movies.size(); i = i + 1) {
                        mainlist.add(movies.get(i));
                    }

                }
                homeRecyclerViewAdapter.notifyDataSetChanged();
                c=c+1;
                favresponseget(c);
            }

            @Override
            public void onFailure(Call<MainResponselist> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    public  boolean hasActiveInternetConnection(Context context) {
        if (isNetworkAvailable(context)) {
            try {
                HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500);
                urlc.connect();
                return (urlc.getResponseCode() == 200);
            } catch (IOException e) {

            }
        } else {

        }
        return false;
    }
    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
public void favresponseget(int j)
{
    NumberOfRowsMain apiService = ApiClient.getClient().create(NumberOfRowsMain.class);
    Call<MainResponselist> call = apiService.favlistget(getemailfav,j);
    call.enqueue(new Callback<MainResponselist>() {
        @Override
        public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
            int statusCode = response.code();
            ArrayList<MainViewResponse> movies = (ArrayList<MainViewResponse>) response.body().getResults();
            if (movies != null) {
                for (int i = 0; i < movies.size(); i = i + 1) {
                    mainlist.add(movies.get(i));
                }

            }
            homeRecyclerViewAdapter.notifyDataSetChanged();
            c=c+1;
            favresponseget(c);
        }

        @Override
        public void onFailure(Call<MainResponselist> call, Throwable t) {
            Log.e(TAG, t.toString());
        }
    });
}
}