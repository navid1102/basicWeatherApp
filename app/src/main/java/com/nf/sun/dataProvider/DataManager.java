package com.nf.sun.dataProvider;

import com.nf.sun.models.CardModel;

import java.util.ArrayList;
import java.util.List;

public class DataManager
{


    public  List<CardModel> getAsiaflag(){

       List<CardModel> cardModelList=new ArrayList<CardModel>();

        CardModel cardModel=new CardModel();
        cardModel.setCountyName("iran");
        cardModelList.add(cardModel);

        CardModel cardMode2=new CardModel();
        cardMode2.setCountyName("iran");
        cardModelList.add(cardMode2);

        CardModel cardMode3=new CardModel();
        cardMode3.setCountyName("iran");
        cardModelList.add(cardMode3);

        CardModel cardMode4=new CardModel();
        cardMode4.setCountyName("iran");
        cardModelList.add(cardMode4);



        return cardModelList;
}

public List<CardModel> getEuropeFlag(){

     List<CardModel> cardModelList=new ArrayList<>();
     CardModel cardModel=new CardModel();

     cardModel.setCountyName("germany");
     cardModelList.add(cardModel);

     cardModel.setCountyName("germany");
     cardModelList.add(cardModel);

     cardModel.setCountyName("germany");
     cardModelList.add(cardModel);

     cardModel.setCountyName("germany");
     cardModelList.add(cardModel);

     return cardModelList;
}

 public List<CardModel> getAmericaFlag(){

  List<CardModel> cardModelList=new ArrayList<>();
  CardModel cardModel=new CardModel();

  cardModel.setCountyName("usa");
  cardModelList.add(cardModel);

  cardModel.setCountyName("usa");
  cardModelList.add(cardModel);

  cardModel.setCountyName("usa");
  cardModelList.add(cardModel);

  cardModel.setCountyName("usa");
  cardModelList.add(cardModel);

  return cardModelList;
 }




}
