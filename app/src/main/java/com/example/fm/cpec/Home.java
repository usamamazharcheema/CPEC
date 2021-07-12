package com.example.fm.cpec;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class Home extends AppCompatActivity {

    ImageView homeback;
    public static ProgressBar bar;
    public static final String TITLE = "Home";

    private RecyclerView recyclerView;
    int c=0;
    int b=0;
    String fragmentname="available";
    Button available,sold;
    public  NavigationManager mNavigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mNavigationManager = FragmentNavigationManager.obtain(this);

        available=findViewById(R.id.available);
        sold=findViewById(R.id.sold);
        bar = (ProgressBar) findViewById(R.id.progressBar);


        homeback= (ImageView) findViewById(R.id.searchhomeback);
        homeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragmentname.equals("available"))
                {

                }
                else {
                    available.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    sold.setBackgroundColor(Color.parseColor("#663333"));
                    bar.setVisibility(View.VISIBLE);
                    mNavigationManager.showFragmentAction("");
                    fragmentname="available";
                }
            }
        });
        sold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragmentname.equals("sold"))
                {

                }
                else {
                    sold.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    available.setBackgroundColor(Color.parseColor("#663333"));
                    bar.setVisibility(View.VISIBLE);
                    mNavigationManager.showFragmentComedy("");
                    fragmentname="sold";
                }
            }
        });

        if (mNavigationManager != null) {
            mNavigationManager.showFragmentAction("");
        }

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


    public static void hidebar()
    {
        bar.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if(fragmentname.equals("sold"))
        {
            fragmentname="available";
            available.setBackgroundColor(Color.parseColor("#FFFFFF"));
            sold.setBackgroundColor(Color.parseColor("#663333"));
            super.onBackPressed();
        }
        else if(fragmentname.equals("available"))
        {
            Intent i=new Intent(Home.this,MainActivity.class);
            startActivity(i);
            finish();
        }

    }
}
