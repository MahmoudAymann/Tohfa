package com.spectraapps.tohfa.bottomtabscreens.cart;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.spectraapps.tohfa.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cart extends Fragment {
    RecyclerView recyclerView;
    RecyclerCartAdapter recyclerCartAdapter;
    ArrayList<CartData> mCartDataList;


    public Cart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = rootView.findViewById(R.id.cart_recycler);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }

        else
        {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        }

        mCartDataList = new ArrayList<CartData>();
        mCartDataList.add(new CartData("اسم المنتج","19/2/2017"));
        mCartDataList.add(new CartData("اسم المنتج","18/3/2016"));
        mCartDataList.add(new CartData("اسم المنتج","1/9/1995"));
        mCartDataList.add(new CartData("اسم المنتج","2/2/2014"));
        mCartDataList.add(new CartData("اسم المنتج","4/9/2017"));
        mCartDataList.add(new CartData("اسم المنتج","7/1/2017"));
        mCartDataList.add(new CartData("اسم المنتج","7/1/2017"));

        recyclerCartAdapter = new RecyclerCartAdapter(getActivity(), mCartDataList, new RecyclerCartAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CartData cartData) {
                Toast.makeText(getActivity(), ""+ cartData.getName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), ""+ cartData.getName2(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(recyclerCartAdapter);
        recyclerCartAdapter.notifyDataSetChanged();

        return rootView;
    }

}
