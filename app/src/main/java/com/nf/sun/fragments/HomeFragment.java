package com.nf.sun.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nf.sun.R;
import com.nf.sun.adapter.ViewPagerListAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.pager)ViewPager pager;
    @BindView(R.id.indicator)CirclePageIndicator indicator;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);


        ViewPagerListAdapter viewPagerListAdapter=new ViewPagerListAdapter(getFragmentManager());
        viewPagerListAdapter.addTab(new WetherDataFragment(),"wether data");
        viewPagerListAdapter.addTab(new AddLocationFragment(),"add location");



        pager.setAdapter(viewPagerListAdapter);

        indicator.setViewPager(pager);


        return view;

    }

}
