package com.nf.sun.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nf.sun.R;
import com.nf.sun.models.CardModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardDataCountryAdapter extends RecyclerView.Adapter<CardDataCountryAdapter.view_holder>
{
    List<CardModel> cardModels=new ArrayList<>();
    Context context;
    LayoutInflater inflater;


    public CardDataCountryAdapter(Context context,List<CardModel> cardModelList) {
        cardModels=cardModelList;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.card_country_data,null);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(view_holder holder, int position) {

        CardModel cardModel=cardModels.get(position);
        holder.textView.setText(cardModel.getCountyName());
    }

    @Override
    public int getItemCount() {
        return cardModels.size();
    }






    public class view_holder extends RecyclerView.ViewHolder{

        @BindView(R.id.flag_image)ImageView imageView;
        @BindView(R.id.country_name_text)TextView textView;

        public view_holder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

}

