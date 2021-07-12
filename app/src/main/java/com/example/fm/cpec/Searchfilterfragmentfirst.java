package com.example.fm.cpec;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Usama Cheema on 12/15/2017.
 */

public class Searchfilterfragmentfirst extends Fragment {

    public SearchFilterAdapter searchfilteradapter;
    int c=0;
    int r=0;
    int d=0;
    private RecyclerView recyclerView;
    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
    public static Searchfilterfragmentfirst newInstance() {

        return new Searchfilterfragmentfirst();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainsearchfilterfirst, container, false);
        mainlist.clear();

        recyclerView = (RecyclerView) view.findViewById(R.id.searchrecyclerview);
        searchfilteradapter=new SearchFilterAdapter(0,getActivity(),mainlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(searchfilteradapter);
        searchfilteradapter.notifyDataSetChanged();
        recallmethod(c);
        recallresimethod(r);
        recallgwdmethod(d);

        return view;
    }
    public void recallmethod(int j)
    {
        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<MainResponselist> userCall =service.searchfilter(j, SearchFiltermain.regioname);

        userCall.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();

                if (mainview!=null) {
                    for (int i = 0; i < mainview.size(); i = i + 1) {
                        mainlist.add(mainview.get(i));
                        mainview.clear();
                    }

                    searchfilteradapter.notifyDataSetChanged();
                    c=c+1;
                    recallmethod(c);
//                                Toast.makeText(getActivity(), String.valueOf(mainlist.size()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResponselist> call, Throwable t) {
                try {
                    Toast.makeText(getContext(), "You don't have internet connection", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void recallresimethod(int j)
    {
        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<MainResponselist> userCall =service.searchresifilter(j, SearchFiltermain.rregioname, SearchFiltermain.areaname, SearchFiltermain.phase);

        userCall.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();

                if (mainview!=null) {
                    for (int i = 0; i < mainview.size(); i = i + 1) {
                        mainlist.add(mainview.get(i));
                        mainview.clear();
                    }

                    searchfilteradapter.notifyDataSetChanged();
                    r=r+1;
                    recallresimethod(r);
//                                Toast.makeText(getActivity(), String.valueOf(mainlist.size()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResponselist> call, Throwable t) {
                try {
                    Toast.makeText(getContext(), "You don't have internet connection", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void recallgwdmethod(int j)
    {
        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<MainResponselist> userCall =service.searchrgwdfilter(j, SearchFiltermain.mregioname, SearchFiltermain.mareaname);

        userCall.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();

                if (mainview!=null) {
                    for (int i = 0; i < mainview.size(); i = i + 1) {
                        mainlist.add(mainview.get(i));
                        mainview.clear();
                    }

                    searchfilteradapter.notifyDataSetChanged();
                    d=d+1;
                    recallgwdmethod(d);
//                                Toast.makeText(getActivity(), String.valueOf(mainlist.size()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResponselist> call, Throwable t) {
                try {
                    Toast.makeText(getContext(), "You don't have internet connection", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
