package com.spectraapps.tohfa.product;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.spectraapps.tohfa.R;
import com.spectraapps.tohfa.bottomtabscreens.home.HomeData;
import com.spectraapps.tohfa.bottomtabscreens.home.HomeRecyclerAdapter;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductsRecyclerAdapter mProductsRecyclerAdapter;
    ArrayList<ProductData> mProductDataArrayList;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        mToolbar = findViewById(R.id.products_toolbar);
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("اسم القسم");

        recyclerView = findViewById(R.id.products_recyclerView);

        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }

        mProductDataArrayList = new ArrayList<>();
        mProductDataArrayList.add(new ProductData(R.drawable.abalic,"منتج 1","500 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.clocks,"منتج 5","700 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.decories,"منتج 1","700 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.accessories,"منتج 2","609 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.libraries,"منتج 1","150 $"));
        mProductDataArrayList.add(new ProductData(R.drawable.accessories,"منتج 9","10 $"));


        mProductsRecyclerAdapter = new ProductsRecyclerAdapter(mProductDataArrayList, new ProductsRecyclerAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(ProductData productData) {
                startActivity(new Intent(ProductsActivity.this, ProductDetailActivity.class));
            }
        });

        recyclerView.setAdapter(mProductsRecyclerAdapter);
        mProductsRecyclerAdapter.notifyDataSetChanged();

    }
}
