package com.nf.sun.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nf.sun.R;

import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddLocationFragment extends Fragment {




    public AddLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


      View view=inflater.inflate(R.layout.fragment_add_location2, container, false);






        return view;
    }



}
