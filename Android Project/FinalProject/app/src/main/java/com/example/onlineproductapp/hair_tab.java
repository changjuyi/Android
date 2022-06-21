package com.example.onlineproductapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import com.example.onlineproductapp.adapter.ProductAdapter;
import com.example.onlineproductapp.adapter.ProductCategoryAdapter;
import com.example.onlineproductapp.model.ProductCategory;
import com.example.onlineproductapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class hair_tab extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;

    //private RadioButton hair;
    private RadioButton skin;
    private RadioButton face;
    private RadioButton body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_tab);

        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1,"Trending"));
        productCategoryList.add(new ProductCategory(2,"Most Popular"));
        productCategoryList.add(new ProductCategory(3,"All body Products"));
        productCategoryList.add(new ProductCategory(4,"Skin Care"));
        productCategoryList.add(new ProductCategory(5,"Hair Care"));
        productCategoryList.add(new ProductCategory(6,"Make Up"));
        productCategoryList.add(new ProductCategory(7,"Fragrance"));

        setProductRecycler(productCategoryList);


        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1,"Venus女神極致護髮精華油禮盒(三款氣味各一)","30ml/瓶，3瓶/盒", "$ 2000", R.drawable.venus));


        setProdItemRecycler(productsList);

        //hair = findViewById(R.id.hair);
        skin = findViewById(R.id.skin);
        face = findViewById(R.id.face);
        body = findViewById(R.id.body);

        skin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(hair_tab.this, skin_tab.class);
                startActivity(intent);
            }
        });

        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(hair_tab.this, MainActivity.class);
                startActivity(intent);
            }
        });

        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(hair_tab.this, face_tab.class);
                startActivity(intent);
            }
        });

    }

    private void setProductRecycler(List<ProductCategory> productCategoryList) {

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);
    }

    private void setProdItemRecycler(List<Products> productsList) {

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);
    }
}