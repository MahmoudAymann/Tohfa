package com.spectraapps.tohfa.bottomtabscreens.home;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spectraapps.tohfa.product.ProductsActivity;
import com.spectraapps.tohfa.R;


import java.util.ArrayList;


public class Home extends Fragment {

    RecyclerView recyclerView;
    HomeRecyclerAdapter mHomeRecyclerAdapter;
    ArrayList<HomeData> mHomeDataArrayList;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.home_recyclerView);

        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }
        else {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        }

        mHomeDataArrayList = new ArrayList<>();
        mHomeDataArrayList.add(new HomeData("اباليك",R.drawable.abalic));
        mHomeDataArrayList.add(new HomeData("اكسسوارات",R.drawable.accessories));
        mHomeDataArrayList.add(new HomeData("تابلوهات",R.drawable.tablohat));
        mHomeDataArrayList.add(new HomeData("دروع",R.drawable.dro33));
        mHomeDataArrayList.add(new HomeData("ديكورات",R.drawable.decories));
        mHomeDataArrayList.add(new HomeData("ساعات",R.drawable.clocks));
        mHomeDataArrayList.add(new HomeData("هدايا",R.drawable.gifts));
        mHomeDataArrayList.add(new HomeData("مكتبات",R.drawable.libraries));
        mHomeDataArrayList.add(new HomeData("ماكيتات",R.drawable.makitat));
        mHomeDataArrayList.add(new HomeData("لافتات",R.drawable.laftat));

        mHomeRecyclerAdapter = new HomeRecyclerAdapter(mHomeDataArrayList, new HomeRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HomeData homeData) {
                startActivity(new Intent(getActivity(), ProductsActivity.class));
            }
        });

        recyclerView.setAdapter(mHomeRecyclerAdapter);
        mHomeRecyclerAdapter.notifyDataSetChanged();

        return rootView;
    }

}//end Home