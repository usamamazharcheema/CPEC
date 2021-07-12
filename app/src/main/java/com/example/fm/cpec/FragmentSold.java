package com.example.fm.cpec;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ANDROID DEVELOPER on 13/01/2018.
 */

public class FragmentSold extends Fragment {
    public static final String TITLE = "Home";
    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
    private RecyclerView recyclerView;
    int c=0;
    int b=0;

    public SoldHomeRecyclerViewAdapter homeRecyclerViewAdapter;
    private NavigationManager mNavigationManager;
    private static final String KEY_MOVIE_TITLE = "key_title";


    public FragmentSold() {
        // Required empty public constructor
    }
    Button v1btn,v2btn,v3btn;
    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment FragmentAction.
     */
    public static FragmentSold newInstance(String movieTitle) {
        FragmentSold fragmentAction = new FragmentSold();
        Bundle args = new Bundle();
        args.putString(KEY_MOVIE_TITLE, movieTitle);
        fragmentAction.setArguments(args);

        return fragmentAction;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sold, container, false);
    }
    View v1,v2,v3;
    Button homeimg,favimg,cartimg;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.homerecyclerview);
        homeRecyclerViewAdapter=new SoldHomeRecyclerViewAdapter(0,getActivity(),mainlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(homeRecyclerViewAdapter);
        homeRecyclerViewAdapter.notifyDataSetChanged();
        recallmethodsold(1);
    }
    public void recallmethodsold(int j)
    {
        mainlist.clear();

        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<MainResponselist> userCall =service.numberrworesponsesold(j);

        userCall.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {

                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();

                if (mainview!=null) {
                    for (int i = 0; i < mainview.size(); i = i + 1) {
                        mainlist.add(mainview.get(i));
                        if(mainview.size()-i==1)
                        {

                            homeRecyclerViewAdapter.notifyDataSetChanged();
                        }
                    }

                    Home.hidebar();
//                    c=c+1;
//                    recallmethodsold(c);
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
