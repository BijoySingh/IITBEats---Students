package com.gymkhana.iitbeats.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class MenuViewHolder extends RecyclerView.ViewHolder {

    public View root;
    public ImageView thumbnail, vegetarian, add_to_cart;
    public TextView name, price, categories;

    public MenuViewHolder(View view) {
        super(view);
        root = view;

        thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        vegetarian = (ImageView) view.findViewById(R.id.vegetarian);
        add_to_cart = (ImageView) view.findViewById(R.id.add_to_cart);

        name = (TextView) view.findViewById(R.id.name);
        price = (TextView) view.findViewById(R.id.price);
        categories = (TextView) view.findViewById(R.id.categories);

    }
}
