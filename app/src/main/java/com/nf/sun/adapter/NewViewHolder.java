package com.nf.sun.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nf.sun.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.flag_image)ImageView flag_image;
    @BindView(R.id.country_name_text)TextView country_name_text;
    @BindView(R.id.card_data)CardView card_data;



    public NewViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);
    }
}
