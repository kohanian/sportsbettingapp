package com.bridge.hackathon.sportsbettingapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kimeric on 1/21/17.
 */



public class GameListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Game> mGameList;

    //Constructor

    public GameListAdapter(Context mContext, List<Game> mGame) {
        this.mContext = mContext;
        this.mGameList = mGameList;
    }

    @Override
    public int getCount() {
        return mGameList.size();
    }

    @Override
    public Object getItem(int position) {
        return mGameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.item_game_list, null);
        TextView tvId = (TextView)v.findViewById(R.id.tv_id);
        TextView tvPlayer1 = (TextView)v.findViewById(R.id.tv_player1);
        TextView tvPlayer2 = (TextView)v.findViewById(R.id.tv_player2);
        TextView tvAmount = (TextView)v.findViewById(R.id.tv_amount);

        //set Text for TextView
        tvId.setText(mGameList.get(position).getId());
        tvPlayer1.setText(String.valueOf(mGameList.get(position).getPlayer1() + "'s Team"));
        tvPlayer2.setText(String.valueOf(mGameList.get(position).getPlayer2() + "'s Team"));
        tvAmount.setText(String.valueOf(mGameList.get(position).getAmount()) + " $");

        // set game id to tag
        v.setTag(mGameList.get(position).getId());




        return null;
    }
}
