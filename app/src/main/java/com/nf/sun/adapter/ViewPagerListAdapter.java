package com.nf.sun.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KarAmad-user on 5/18/2018.
 */

public class ViewPagerListAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList=new ArrayList<>();
    List<String> titleList=new ArrayList<>();


    public ViewPagerListAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }


    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addTab(Fragment fragment, String title)
    {
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
