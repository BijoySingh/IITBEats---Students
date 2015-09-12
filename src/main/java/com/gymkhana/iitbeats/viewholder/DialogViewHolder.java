package com.gymkhana.iitbeats.viewholder;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class DialogViewHolder {
    public TextView name, categories, price, cancel, add, quantity;
    public ImageView vegetarian, plus, minus;

    public DialogViewHolder(Dialog dialog) {
        name = (TextView) dialog.findViewById(R.id.name);
        price = (TextView) dialog.findViewById(R.id.price);
        categories = (TextView) dialog.findViewById(R.id.categories);

        add = (TextView) dialog.findViewById(R.id.add);
        cancel = (TextView) dialog.findViewById(R.id.cancel);
        quantity = (TextView) dialog.findViewById(R.id.quantity);

        vegetarian = (ImageView) dialog.findViewById(R.id.vegetarian);
        plus = (ImageView) dialog.findViewById(R.id.plus);
        minus = (ImageView) dialog.findViewById(R.id.minus);
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
