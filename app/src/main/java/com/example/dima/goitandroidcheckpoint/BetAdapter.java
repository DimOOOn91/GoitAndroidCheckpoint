package com.example.dima.goitandroidcheckpoint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dima.goitandroidcheckpoint.entity.Bet;

import java.util.List;


public class BetAdapter extends BaseAdapter {

    private List<Bet> mList;

    private LayoutInflater mInflater;

    public BetAdapter(Context context, List<Bet> list) {
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = view;
        if (rootView == null) {
            rootView = mInflater.inflate(R.layout.bet_layout_item, viewGroup, false);
        }
        TextView number = (TextView) rootView.findViewById(R.id.number);
        TextView user = (TextView) rootView.findViewById(R.id.user);
        TextView sum = (TextView) rootView.findViewById(R.id.sum);
        TextView horse = (TextView) rootView.findViewById(R.id.horse);
        TextView position = (TextView) rootView.findViewById(R.id.horsePosition);

        Bet bet = mList.get(i);

        number.setText(String.valueOf(mList.indexOf(bet)));
        user.setText(bet.getUser());
        sum.setText(String.valueOf(bet.getSum()));
        horse.setText(bet.getHorseNumber().name());
        position.setText(bet.getHorsePosition());

        return rootView;
    }
}
