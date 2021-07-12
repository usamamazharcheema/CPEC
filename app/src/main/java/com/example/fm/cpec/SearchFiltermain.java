package com.example.fm.cpec;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Usama Cheema on 12/14/2017.
 */

public class SearchFiltermain extends FragmentActivity  {
    TextView title,regionan,areanam;
    public static String regioname=null;
    public static String mregioname=null;
    public static String mareaname=null;
    public static String rregioname=null;
    public static String areaname=null;
    public static String phase=null;

    int c=0;
    int b=0;
    //    Spinner spinner;
    public static ViewPager mViewPager;
    public static SearchFilterPager adapter;
    private ViewPagerAdapter mViewPagerAdapter;
    private RecyclerView recyclerView;
    private TabLayout mTabLayout;
    //    Button price,area,region;
    public static String searchfilter;
    public static String ascedesce;
    ArrayList<String> spinnersort=new ArrayList<>();
    Button sortarow;
    TextView sortedtext;
    ImageView searchback,contact;
    public SearchFilterAdapter searchfilteradapter;
    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
    public  static  int checksort=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchfilterlayoutmain);
        spinnersort.clear();
        mainlist.clear();
//        spinner=(Spinner)findViewById(R.id.spineerde);
        spinnersort.add("Sort By");
        spinnersort.add("ASC");
        spinnersort.add("DESC");
        searchback= (ImageView) findViewById(R.id.searchback);
        contact=(ImageView) findViewById(R.id.con6);
        searchback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        sortarow=(Button)findViewById(R.id.sortarrow);
//        sortedtext=(TextView)findViewById(R.id.sortedtext);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(SearchFiltermain.this, android.R.layout.simple_spinner_item, spinnersort);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
//        spinner.setAdapter(dataAdapter);
//        price=(Button)findViewById(R.id.pricefilter);
//        area=(Button)findViewById(R.id.areafilter);
//        region=(Button)findViewById(R.id.regionfilter);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

//price.setOnClickListener(this);
//        area.setOnClickListener(this);
//       region.setOnClickListener(this);

//sortarow.setOnClickListener(this);

//        recyclerView = (RecyclerView) findViewById(R.id.searchrecyclerview);
        title=(TextView)findViewById(R.id.gtitleplotserachfiltermain);
        regionan=(TextView)findViewById(R.id.phasetext);
        areanam=(TextView)findViewById(R.id.phasetext1);
//        newtoen=(TextView)findViewById(R.id.newtown);
        Bundle bundle = getIntent().getExtras();

        regioname = bundle.getString("regioname");

        regionan.setText(regioname);
        mregioname=bundle.getString("mregioname");
        mareaname=bundle.getString("mareaname");
//        newtoen.setText(mareaname);
        areanam.setText(mareaname);

        rregioname = bundle.getString("rregioname");
        areaname=bundle.getString("areaname");
        phase=bundle.getString("phase");
//        newtoen.setText(areaname);
        title.setText(phase);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(SearchFiltermain.this, ContactUs.class);
                startActivity(in);

            }
        });

//        title.setText(regioname);
//        searchfilteradapter=new SearchFilterAdapter(0,SearchFiltermain.this,mainlist);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SearchFiltermain.this);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(searchfilteradapter);
//        searchfilteradapter.notifyDataSetChanged();
//
/*        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //@Override
            public void onItemSelected(AdapterView<?> parent, View arg1,int arg2, long arg3) {
                // TODO Auto-generated method stub
                String item = spinner.getItemAtPosition(1).toString();
//                Toast.makeText(spinner.getContext(), "Selected: " + spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                String ss=spinner.getSelectedItem().toString();
                ascedesce=spinner.getSelectedItem().toString();
                SearchFilterPager adapter1 = null;
                if(ascedesce.equals("ASC")) {

                    adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 1);
                }
                else if(ascedesce.equals("DESC"))
                {

                    adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 2);
                }
                SearchFiltermain.mViewPager.setAdapter(adapter1);

            }


            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });*/
//
//        NumberOFROwsHOme();
        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mTabLayout.addTab(mTabLayout.newTab().setText(" "));
        adapter = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(),0);
        mViewPager.setAdapter(adapter);

        mViewPager.setCurrentItem(0);
        new CountDownTimer(2000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                SearchFilterPager adapter1 = null;
                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 0);
                SearchFiltermain.mViewPager.setAdapter(adapter1);

            }
        }.start();
    }


//    @Override
//    public void onClick(View v) {
//        if (v.getId()== R.id.pricefilter)
//        {
//            searchfilter="price";
//            ascedesce=sortedtext.getText().toString();
//            SearchFilterPager adapter1 = null;
//            if(ascedesce.equals("ASC")) {
//
//                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 1);
////                price.setBackgroundResource(R.drawable.selectedsort);
////                area.setBackgroundResource(R.drawable.unselectedsort);
////                region.setBackgroundResource(R.drawable.unselectedsort);
//            }
//            else if(ascedesce.equals("DESC"))
//            {
//
//                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 2);
//                price.setBackgroundResource(R.drawable.selectedsort);
//                area.setBackgroundResource(R.drawable.unselectedsort);
//                region.setBackgroundResource(R.drawable.unselectedsort);
//            }
//            else
//            {
//                sortedtext.setText("ASC");
//                ascedesce = sortedtext.getText().toString();
//                price.setBackgroundResource(R.drawable.selectedsort);
//                area.setBackgroundResource(R.drawable.unselectedsort);
//                region.setBackgroundResource(R.drawable.unselectedsort);
//                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 1);
//
//            }
//            SearchFiltermain.mViewPager.setAdapter(adapter1);
//
//        }
//        else if(v.getId()== R.id.areafilter)
//        {
//
//            searchfilter="sqr_yard";
//            ascedesce=sortedtext.getText().toString();
//            SearchFilterPager adapter1 = null;
//            if(ascedesce.equals("ASC")) {
//
//                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 1);
//                price.setBackgroundResource(R.drawable.unselectedsort);
//                area.setBackgroundResource(R.drawable.selectedsort);
//                region.setBackgroundResource(R.drawable.unselectedsort);
//            }
//            else if(ascedesce.equals("DESC"))
//            {
//
//                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 2);
//                price.setBackgroundResource(R.drawable.unselectedsort);
//                area.setBackgroundResource(R.drawable.selectedsort);
//                region.setBackgroundResource(R.drawable.unselectedsort);
//            }
//            else
//            {
//                sortedtext.setText("ASC");
//                ascedesce = sortedtext.getText().toString();
//                price.setBackgroundResource(R.drawable.unselectedsort);
//                area.setBackgroundResource(R.drawable.selectedsort);
//                region.setBackgroundResource(R.drawable.unselectedsort);
//                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 1);
//
//            }
//            SearchFiltermain.mViewPager.setAdapter(adapter1);
//        }
//        else if(v.getId()== R.id.regionfilter)
//        {
//            searchfilter="areaname";
//            ascedesce=sortedtext.getText().toString();
//            SearchFilterPager adapter1 = null;
//            if(ascedesce.equals("ASC")) {
//
//                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 3);
//                price.setBackgroundResource(R.drawable.unselectedsort);
//                area.setBackgroundResource(R.drawable.unselectedsort);
//                region.setBackgroundResource(R.drawable.selectedsort);
//            }
//            else if(ascedesce.equals("DESC"))
//            {
//
//                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 4);
//                price.setBackgroundResource(R.drawable.unselectedsort);
//                area.setBackgroundResource(R.drawable.unselectedsort);
//                region.setBackgroundResource(R.drawable.selectedsort);
//            }
//            else  if (sortedtext.getText().toString().equals("Sort By"))
//            {
////                sortedtext.setText("ASC");
//                searchfilter="areaname";
//                ascedesce=sortedtext.getText().toString();
//                price.setBackgroundResource(R.drawable.unselectedsort);
//                area.setBackgroundResource(R.drawable.unselectedsort);
//                region.setBackgroundResource(R.drawable.selectedsort);
//
//                adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 5);
//
//            }
//            SearchFiltermain.mViewPager.setAdapter(adapter1);
//        }
//        else if(v.getId()== R.id.sortarrow)
//        {
//            searchfilter = "areaname";
//            if(searchfilter.equals("areaname"))
//            {
//                if (sortedtext.getText().toString().equals("Sort By")) {
//
//                    sortedtext.setText("ASC");
//
//
//
//
//                    ascedesce = sortedtext.getText().toString();
//                    price.setBackgroundResource(R.drawable.unselectedsort);
//                    area.setBackgroundResource(R.drawable.unselectedsort);
//                    region.setBackgroundResource(R.drawable.selectedsort);
//                    SearchFilterPager adapter1 = null;
//                    adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 5);
//                    SearchFiltermain.mViewPager.setAdapter(adapter1);
//                } else if (sortedtext.getText().toString().equals("ASC")) {
//                    sortedtext.setText("DESC");
//                    ascedesce = sortedtext.getText().toString();
//                    SearchFilterPager adapter1 = null;
//                    adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 4);
//                    SearchFiltermain.mViewPager.setAdapter(adapter1);
////                price.setBackgroundResource(R.drawable.selectedsort);
////                area.setBackgroundResource(R.drawable.unselectedsort);
////                region.setBackgroundResource(R.drawable.unselectedsort);
//                } else if (sortedtext.getText().toString().equals("DESC")) {
//                    sortedtext.setText("ASC");
//                    ascedesce = sortedtext.getText().toString();
//                    SearchFilterPager adapter1 = null;
//                    adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 3);
//                    SearchFiltermain.mViewPager.setAdapter(adapter1);
////                price.setBackgroundResource(R.drawable.unselectedsort);
////                area.setBackgroundResource(R.drawable.selectedsort);
////                region.setBackgroundResource(R.drawable.unselectedsort);
//                }
//            }
//            else {
//
////            Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
//                if (sortedtext.getText().toString().equals("Sort By")) {
//
//                    sortedtext.setText("ASC");
//
//                    searchfilter = "price";
//
//                    ascedesce = sortedtext.getText().toString();
//                    price.setBackgroundResource(R.drawable.selectedsort);
//                    area.setBackgroundResource(R.drawable.unselectedsort);
//                    region.setBackgroundResource(R.drawable.unselectedsort);
//                    SearchFilterPager adapter1 = null;
//                    adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 1);
//                    SearchFiltermain.mViewPager.setAdapter(adapter1);
//                } else if (sortedtext.getText().toString().equals("ASC")) {
//                    sortedtext.setText("DESC");
//                    ascedesce = sortedtext.getText().toString();
//                    SearchFilterPager adapter1 = null;
//                    adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 2);
//                    SearchFiltermain.mViewPager.setAdapter(adapter1);
////                price.setBackgroundResource(R.drawable.selectedsort);
////                area.setBackgroundResource(R.drawable.unselectedsort);
////                region.setBackgroundResource(R.drawable.unselectedsort);
//                } else if (sortedtext.getText().toString().equals("DESC")) {
//                    sortedtext.setText("ASC");
//                    ascedesce = sortedtext.getText().toString();
//                    SearchFilterPager adapter1 = null;
//                    adapter1 = new SearchFilterPager(getSupportFragmentManager(), mTabLayout.getTabCount(), 1);
//                    SearchFiltermain.mViewPager.setAdapter(adapter1);
////                price.setBackgroundResource(R.drawable.unselectedsort);
////                area.setBackgroundResource(R.drawable.selectedsort);
////                region.setBackgroundResource(R.drawable.unselectedsort);
//                }
//            }
//        }
//    }
}
