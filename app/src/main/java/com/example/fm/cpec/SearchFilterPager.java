package com.example.fm.cpec;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


//Extending FragmentStatePagerAdapter
public  class SearchFilterPager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;
    int settingtab;
    //Constructor to the class
    public SearchFilterPager(FragmentManager fm, int tabCount , int settingtab) {
        super(fm);
        //Initializing tab count
        this.settingtab=settingtab;
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        Fragment tab1 = null;
//        if (settingtab==1) {
//            tab1 = new AscendingFragment();
//
//        }
//        else if (settingtab==2)
//        {
//            tab1 = new DescendingFragment();
//        }
      if (settingtab==0)
        {
            tab1 = new Searchfilterfragmentfirst();
        }
//        else if (settingtab==3)
//        {
//            tab1=new RegionFragment();
//        }
//        else if (settingtab==4)
//        {
//            tab1=new RegionfragmentDes();
//        }
//        else if (settingtab==5)
//        {
//            tab1=new RegionFragmentNoclick();
//        }
        return tab1;
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}