package com.example.fm.cpec;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends FragmentActivity implements TabLayout.OnTabSelectedListener {

    public static ViewPager mViewPager;
   public static Pager adapter;

    public static String regionname,minarea,maxarea,minprice,maxprice;
    public static int checkback=0;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;
    View v1,v2,v3,v4;
    private int[] tabIcons = {
            R.drawable.search_unselect,
            R.drawable.home_unselect,
            R.drawable.menu_unselect
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        v1=getLayoutInflater().inflate(R.layout.tabindustrials, null);
        v2=getLayoutInflater().inflate(R.layout.tabresidential, null);
        v3=getLayoutInflater().inflate(R.layout.tabcomertial, null);
        v4=getLayoutInflater().inflate(R.layout.tabopenland, null);

        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mTabLayout.addTab(mTabLayout.newTab().setText(" "));
        mTabLayout.addTab(mTabLayout.newTab().setText(" "));
        mTabLayout.addTab(mTabLayout.newTab().setText(" "));
        mTabLayout.getTabAt(0).setCustomView(v1);
        mTabLayout.getTabAt(1).setCustomView(v2);
        mTabLayout.getTabAt(2).setCustomView(v3);
        mTabLayout.setOnTabSelectedListener(this);
        adapter = new Pager(getSupportFragmentManager(), mTabLayout.getTabCount(),1);
        mViewPager.setAdapter(adapter);


        mViewPager.setCurrentItem(1);
//        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//        });
        mTabLayout.setupWithViewPager(mViewPager);

        setViewPager();

    }

    private void setViewPager() {
//        mTabLayout.setupWithViewPager(mViewPager);
//        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//       mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        mTabLayout.getTabAt(0).setIcon(tabIcons[0]);
        mTabLayout.getTabAt(1).setIcon(R.drawable.home_select);
        mTabLayout.getTabAt(2).setIcon(tabIcons[2]);
        mTabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(mViewPager){

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        if(mTabLayout.getSelectedTabPosition()==0){
                            tab.setIcon(R.drawable.search_select);
                            mTabLayout.getTabAt(1).setIcon(tabIcons[1]);
                            mTabLayout.getTabAt(2).setIcon(tabIcons[2]);
                            MainActivity.checkback=4;

                        }
                        else if(mTabLayout.getSelectedTabPosition()==1){
                            tab.setIcon(R.drawable.home_select);
                            mTabLayout.getTabAt(0).setIcon(tabIcons[0]);
                            mTabLayout.getTabAt(2).setIcon(tabIcons[2]);
                            MainActivity.checkback=0;
                        }
                        else {
                            tab.setIcon(R.drawable.menu_select);
                            mTabLayout.getTabAt(0).setIcon(tabIcons[0]);
                            mTabLayout.getTabAt(1).setIcon(tabIcons[1]);
                            MainActivity.checkback=4;
                        }

                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);


                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onBackPressed() {
        if (checkback==1)
        {
            checkback=0;
            Pager adapter;
            adapter = new Pager(getSupportFragmentManager(), 3,1);
            mViewPager.setAdapter(adapter);
            mViewPager.setCurrentItem(2);

        }
        else  if (checkback==2)
        {
            checkback=0;
            Pager adapter;
            adapter = new Pager(getSupportFragmentManager(), 3,1);
            mViewPager.setAdapter(adapter);
            mViewPager.setCurrentItem(0);

        }
else if(checkback==4)
        {
            checkback=0;
            mViewPager.setCurrentItem(1);
        }

        else {
            checkback=0;
           finish();
        }
    }
}
