package com.example.fm.cpec;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
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
public class HomeFragment extends Fragment {
    LinearLayout home;

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }
    ArrayList<MainViewResponse> getlastpricees=new ArrayList<>();
    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
    Button graphbtn,news;
    TextView price,area;
    int c=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_home, container, false);
        home= (LinearLayout) v.findViewById(R.id.home);
        graphbtn=(Button)v.findViewById(R.id.trending);
        price=v.findViewById(R.id.price);
        area=v.findViewById(R.id.area);
        news=v.findViewById(R.id.news);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/cpecintl/"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/cpecintl/")));
                }
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Home.class);
                startActivity(intent);
            }
        });
        graphbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),Trending.class);
                startActivity(intent);
            }
        });
        getgraph("");
//        if(hasActiveInternetConnection(getActivity()))
//        {
//            NumberOFROwsHOme();
//        }
//        else
//        {
//            NumberOFROwsHOme();
//            Toast.makeText(getActivity(), "Plesae cehck your internet connection...", Toast.LENGTH_SHORT).show();
//        }

        return v;
    }

    public void getgraph(final String mystring)
    {
        final NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<MainResponselist> userCall =service.getlastprice(mystring);

        userCall.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
//                Toast.makeText(getActivity(), "GOT", Toast.LENGTH_SHORT).show();
                ArrayList<MainViewResponse> numberpriceResponsethis=(ArrayList<MainViewResponse>) response.body().getResults();
                if(numberpriceResponsethis!=null)
                {
                    for(int c=0;c<numberpriceResponsethis.size();c++)
                    {
                        getlastpricees.add(numberpriceResponsethis.get(c));

                        if(numberpriceResponsethis.size()-c==1)
                        {
                            mainmethod();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<MainResponselist> call, Throwable t) {
                try {
//                    Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public void mainmethod()
    {
        price.setText(getlastpricees.get(c).getPrice()+"");
        area.setText(getlastpricees.get(c).getSqrYard()+"");
        try {
            new CountDownTimer(1000, 2000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    c=c+1;
                    if (getlastpricees.size()-c==1)
                    {
                        c=0;
                    }

                    mainmethod();
                }
            }.start();
        }
        catch (Exception e)
        {

        }
    }
}