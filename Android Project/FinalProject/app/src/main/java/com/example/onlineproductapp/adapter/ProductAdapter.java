package com.example.onlineproductapp.adapter;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineproductapp.Productdetails;
import com.example.onlineproductapp.R;
import com.example.onlineproductapp.model.Products;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Products> productsList;

    public ProductAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.products_row_item, viewGroup, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {

        productViewHolder.prodImage.setImageResource(productsList.get(i).getImageUrl());
        productViewHolder.prodName.setText(productsList.get(i).getProductName());
        productViewHolder.prodQty.setText(productsList.get(i).getProductQty());
        productViewHolder.prodPrice.setText(productsList.get(i).getProductPrice());

        productViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent  i = new  Intent(context, Productdetails.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(productViewHolder.prodImage, "image");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                context.startActivity(i, activityOptions.toBundle());

            }
        });

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView prodImage;
        TextView prodName, prodQty, prodPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage = itemView.findViewById(R.id.product_showeroil);
            prodName = itemView.findViewById(R.id.showeroil_name);
            prodQty = itemView.findViewById(R.id.showeroil_qty);
            prodPrice = itemView.findViewById(R.id.showeroil_price);
        }
    }
}
