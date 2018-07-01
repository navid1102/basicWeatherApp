package com.nf.sun.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.nf.sun.R;
import com.nf.sun.adapter.CardDataCountryAdapter;
import com.nf.sun.dataProvider.DataManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryCardFragment extends Fragment {

    DataManager dataManager=new DataManager();

    @BindView(R.id.recycle_asia)RecyclerView recycle_asia;
    @BindView(R.id.recycle_europe)RecyclerView recycle_europe;
    @BindView(R.id.recycle_america)RecyclerView recycle_america;



    public CountryCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view=inflater.inflate(R.layout.fragment_country_card,container,false);

        ButterKnife.bind(this,view);


        CardDataCountryAdapter cardDataCountryAdapter=new CardDataCountryAdapter(getActivity(), dataManager.getAsiaflag());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        recycle_asia.setAdapter(cardDataCountryAdapter);
        recycle_asia.setLayoutManager(linearLayoutManager);

        CardDataCountryAdapter cardDataCountryAdapter1=new CardDataCountryAdapter(getActivity(),dataManager.getEuropeFlag());
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        recycle_europe.setAdapter(cardDataCountryAdapter1);
        recycle_europe.setLayoutManager(linearLayoutManager1);


        CardDataCountryAdapter cardDataCountryAdapter2=new CardDataCountryAdapter(getActivity(),dataManager.getAmericaFlag());
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        recycle_america.setAdapter(cardDataCountryAdapter2);
        recycle_america.setLayoutManager(linearLayoutManager2);



        return view;
    }

}
