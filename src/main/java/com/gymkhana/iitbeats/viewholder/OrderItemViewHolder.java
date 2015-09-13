package com.gymkhana.iitbeats.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.items.MenuItem;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class OrderItemViewHolder {
    public TextView name, categories, price, cancel, add, quantity;
    public ImageView vegetarian, plus, minus;

    public OrderItemViewHolder(View view) {
        name = (TextView) view.findViewById(R.id.name);
        price = (TextView) view.findViewById(R.id.price);
        categories = (TextView) view.findViewById(R.id.categories);

        add = (TextView) view.findViewById(R.id.add);
        cancel = (TextView) view.findViewById(R.id.cancel);
        quantity = (TextView) view.findViewById(R.id.quantity);

        vegetarian = (ImageView) view.findViewById(R.id.vegetarian);
        plus = (ImageView) view.findViewById(R.id.plus);
        minus = (ImageView) view.findViewById(R.id.minus);
    }

    public void setupView(MenuItem item) {
        name.setText(item.food_item.name);
        vegetarian.setImageResource(item.food_item.getVegetarianResource());
        categories.setText(item.food_item.getCategories());
        quantity.setText("1");
        price.setText(item.getPrice());
        setQuantityListeners();
    }

    public void setQuantityListeners() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer final_quantity = (Integer.parseInt(quantity.getText().toString()) + 1);
                final_quantity = Math.min(final_quantity, 10);

                quantity.setText(final_quantity.toString());
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer final_quantity = (Integer.parseInt(quantity.getText().toString()) - 1);
                final_quantity = Math.max(final_quantity, 1);

                quantity.setText(final_quantity.toString());
            }
        });
    }
}
