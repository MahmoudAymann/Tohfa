package com.spectraapps.tohfa.bottomtabscreens.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joooonho.SelectableRoundedImageView;
import com.spectraapps.tohfa.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by MahmoudAyman on 13/01/2018.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder>{

    private ArrayList<HomeData> mHomeDataArrayList;
    private final OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(HomeData homeData);
    }

    HomeRecyclerAdapter(ArrayList<HomeData> homeDataArrayList, HomeRecyclerAdapter.OnItemClickListener listener) {
        this.mHomeDataArrayList = homeDataArrayList;
        this.listener = listener;
    }

    @Override
    public HomeRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_item_home_view, parent, false);
        return new HomeRecyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeRecyclerAdapter.MyViewHolder holder, int position) {
        holder.bind(mHomeDataArrayList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mHomeDataArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV;
        SelectableRoundedImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.textName);
            imageView = itemView.findViewById(R.id.image);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setCornerRadiiDP(4,4,0,0);
        }

        private void bind(final HomeData homeData, final OnItemClickListener listener) {
            nameTV.setText(homeData.getText());
            Picasso.with(itemView.getContext()).load(homeData.getImage()).into(imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(homeData);
                }
            });
        }
    }
}