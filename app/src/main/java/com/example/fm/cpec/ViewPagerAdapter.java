package com.example.fm.cpec;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int TAB_COUNT = 3;
    private final FragmentManager mFragmentManager;
    private Fragment mFragmentAtPos0;
    public ViewPagerAdapter(FragmentManager fm) {

        super(fm);
        mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return SearchFragment.newInstance();
            case 1:
                return HomeFragment.newInstance();
            case 2:

                return SettingsFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return null;

            case 1:
                return null;

            case 2:
                return null;
        }
        return super.getPageTitle(position);
    }
}
