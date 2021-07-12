//package com.example.fm.cpec;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import android.widget.ExpandableListView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * Created by Usama Cheema on 12/16/2017.
// */
//
//public class RegionFragment extends Fragment {
//    public static RegionFragment newInstance() {
//
//        return new RegionFragment();
//    }
//    CustomExpandableListAdapter listAdapter;
//    ExpandableListView expListView;
//    List<String> listDataHeader;
//    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
//    HashMap<String, List<String>> listDataChild;
//    final int[] prevExpandPosition = {-1};
//int c=0;
//    int r=0;
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.regionsearchfilterlayout, container, false);
//        mainlist.clear();
//        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
//        recallmethod(c);
//        recallRegioncatmethod(r);
//        // preparing list data
//
//
//        listAdapter = new CustomExpandableListAdapter(getActivity(), listDataHeader, listDataChild,mainlist);
//
//        // setting list adapter
//        expListView.setAdapter(listAdapter);
//
//
//        expListView .setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                if (prevExpandPosition[0] >= 0) {
//                    expListView .collapseGroup(prevExpandPosition[0]);
//                }
//                prevExpandPosition[0] = groupPosition;
//            }
//        });
//        return view;
//    }
//
//    /*    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.regionsearchfilterlayout);
//        expListView = (ExpandableListView) findViewById(R.id.lvExp);
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
//        recallmethod(c);
//        // preparing list data
//
//
//        listAdapter = new CustomExpandableListAdapter(this, listDataHeader, listDataChild,mainlist);
//
//        // setting list adapter
//        expListView.setAdapter(listAdapter);
//
//
//        expListView .setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                if (prevExpandPosition[0] >= 0) {
//                    expListView .collapseGroup(prevExpandPosition[0]);
//                }
//                prevExpandPosition[0] = groupPosition;
//            }
//        });
//
//    }*/
//
//    public void prepareListData()
//    {
//
//        listDataHeader.add("Top 250");
//        List<String> top250 = new ArrayList<String>();
//        top250.add("The Shawshank Redemption");
//        listDataHeader.add("Top 251");
//        List<String> top251 = new ArrayList<String>();
//        top251.add("The Shawshank Redemption");
//
//        listDataHeader.add("Top 252");
//        List<String> top252 = new ArrayList<String>();
//        top252.add("The Shawshank Redemption");
//        listDataHeader.add("Top 253");
//        List<String> top253 = new ArrayList<String>();
//        top253.add("The Shawshank Redemption");
//        listDataHeader.add("Top 254");
//        List<String> top254 = new ArrayList<String>();
//        top254.add("The Shawshank Redemption");
//        listDataHeader.add("Top 255");
//        List<String> top255 = new ArrayList<String>();
//        top255.add("The Shawshank Redemption");
//        listDataHeader.add("Top 256");
//        List<String> top256 = new ArrayList<String>();
//        top256.add("The Shawshank Redemption");
//        listDataHeader.add("Top 257");
//        List<String> top257 = new ArrayList<String>();
//        top257.add("The Shawshank Redemption");
//        listDataHeader.add("Top 258");
//        List<String> top258 = new ArrayList<String>();
//        top258.add("The Shawshank Redemption");
//        listDataHeader.add("Top 259");
//        List<String> top259 = new ArrayList<String>();
//        top259.add("The Shawshank Redemption");
//        listDataHeader.add("Top 2510");
//        List<String> top2510 = new ArrayList<String>();
//        top2510.add("The Shawshank Redemption");
//        listDataHeader.add("Top 2511");
//        List<String> top2511 = new ArrayList<String>();
//        top2511.add("The Shawshank Redemption");
//        listDataHeader.add("Top 2512");
//        List<String> top2512 = new ArrayList<String>();
//        top2512.add("The Shawshank Redemption");
//
//
//        listDataChild.put(listDataHeader.get(0), top250);
//        listDataChild.put(listDataHeader.get(1), top251);
//        listDataChild.put(listDataHeader.get(2), top252);
//        listDataChild.put(listDataHeader.get(3), top253);
//        listDataChild.put(listDataHeader.get(4), top254);
//        listDataChild.put(listDataHeader.get(5), top255);
//        listDataChild.put(listDataHeader.get(6), top256);
//        listDataChild.put(listDataHeader.get(7), top257);
//        listDataChild.put(listDataHeader.get(8), top258);
//        listDataChild.put(listDataHeader.get(9), top259);
//        listDataChild.put(listDataHeader.get(10), top2510);
//        listDataChild.put(listDataHeader.get(11), top2511);
//        listDataChild.put(listDataHeader.get(12), top2512);
//    }
//
//    public void recallmethod(final int j)
//    {
//        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);
//
//        Call<MainResponselist> userCall =service.searchfilterresposeasc(SearchFiltermain.regioname,j, SearchFiltermain.searchfilter);
//
//        userCall.enqueue(new Callback<MainResponselist>() {
//            @Override
//            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
//                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();
//
//                if (mainview!=null) {
//                    for (int i = 0; i < mainview.size(); i = i + 1) {
//                        mainlist.add(mainview.get(i));
//
//                        listDataHeader.add(mainlist.get(j).getAreaname().toString());
//                        List<String> top250 = new ArrayList<String>();
//                        top250.add("The Shawshank Redemption");
//                        listDataChild.put(listDataHeader.get(j), top250);
//                        mainview.clear();
//                    }
//
//                    listAdapter.notifyDataSetChanged();
//                    c=c+1;
//                    recallmethod(c);
////                                Toast.makeText(getActivity(), String.valueOf(mainlist.size()), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MainResponselist> call, Throwable t) {
//                Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();
//                Log.d("onFailure", t.toString());
//            }
//        });
//    }
//
//    /*public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.regionsearchfilterlayout, container, false);
//
//        return view;
//    }*/
//    public void recallRegioncatmethod(final int j)
//    {
//        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);
//
//        Call<MainResponselist> userCall =service.searchcatfilterresposeasc(SearchFiltermain.rregioname,j, SearchFiltermain.searchfilter,SearchFiltermain.areaname);
//
//        userCall.enqueue(new Callback<MainResponselist>() {
//            @Override
//            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
//                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();
//
//                if (mainview!=null) {
//                    for (int i = 0; i < mainview.size(); i = i + 1) {
//                        mainlist.add(mainview.get(i));
//
//                        listDataHeader.add(mainlist.get(j).getAreaname().toString());
//                        List<String> top250 = new ArrayList<String>();
//                        top250.add("The Shawshank Redemption");
//                        listDataChild.put(listDataHeader.get(j), top250);
//                        mainview.clear();
//                    }
//
//                    listAdapter.notifyDataSetChanged();
//                    r=r+1;
//                    recallRegioncatmethod(r);
////                                Toast.makeText(getActivity(), String.valueOf(mainlist.size()), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MainResponselist> call, Throwable t) {
//                Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();
//                Log.d("onFailure", t.toString());
//            }
//        });
//    }
//
//}
//
