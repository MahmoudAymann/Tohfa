package com.spectraapps.tohfa.product;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spectraapps.tohfa.R;
import com.spectraapps.tohfa.product.productdetail.ProductDetailActivity;

import java.util.ArrayList;

public class ProductsActivity extends Fragment {

    RecyclerView recyclerView;
    ProductsRecyclerAdapter mProductsRecyclerAdapter;
    ArrayList<ProductData> mProductDataArrayList;

    public ProductsActivity() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_products, container, false);


        recyclerView = rootView.findViewById(R.id.products_recyclerView);

        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }
        else {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        }

        mProductDataArrayList = new ArrayList<>();
        mProductDataArrayList.add(new ProductData(R.drawable.abalic,"منتج 1","500 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.clocks,"منتج 5","700 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.decories,"منتج 1","700 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.accessories,"منتج 2","609 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.libraries,"منتج 1","150 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.accessories,"منتج 9","10 $"));

        mProductsRecyclerAdapter = new ProductsRecyclerAdapter(mProductDataArrayList,
                new ProductsRecyclerAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(ProductData productData) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.main_frameLayout, new ProductDetailActivity()).commit();
            }
        });

        recyclerView.setAdapter(mProductsRecyclerAdapter);
        mProductsRecyclerAdapter.notifyDataSetChanged();

        return rootView;

    }
}
