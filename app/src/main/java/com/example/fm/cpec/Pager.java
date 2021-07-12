package com.example.fm.cpec;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


//Extending FragmentStatePagerAdapter
public  class Pager extends FragmentStatePagerAdapter {
    
    //integer to count number of tabs
    int tabCount;
int settingtab;
    //Constructor to the class 
    public Pager(FragmentManager fm, int tabCount , int settingtab) {
        super(fm);
        //Initializing tab count
        this.settingtab=settingtab;
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs 
        switch (position) {
            case 0:
                Fragment tab1 = null;
                if (settingtab==1) {
                    tab1 = new SearchFragment();

                }
//                else if(settingtab==2)
//                {
//                    tab1=new FilterFragment();
//
//                }
else if (settingtab==3)
                {
                    tab1 = new SearchFragment();

                }


                return tab1;
            case 1:
                HomeFragment tab2 = new HomeFragment();

                return tab2;
            case 2:
                Fragment tab3 = null;
                if (settingtab==1) {
                     tab3 = new SettingsFragment();

                    
                }
                else if(settingtab==2)
                {
                    tab3 = new SettingsFragment();

                }
                else if(settingtab==3)
                {
                     tab3=new Comertialsell();
                    
                }

                return tab3;
            case 3:
                Openlandsell tab4 = new Openlandsell();

                return tab4;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs 
    @Override
    public int getCount() {
        return tabCount;
    }
}