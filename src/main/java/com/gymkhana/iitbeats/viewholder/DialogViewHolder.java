package com.gymkhana.iitbeats.viewholder;

import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class DialogViewHolder {
    public TextView name, categories, price, cancel, add, quantity;
    public ImageView vegetarian;

    public DialogViewHolder(Dialog dialog) {
        name = (TextView) dialog.findViewById(R.id.name);
        price = (TextView) dialog.findViewById(R.id.price);
        categories = (TextView) dialog.findViewById(R.id.categories);

        add = (TextView) dialog.findViewById(R.id.add);
        cancel = (TextView) dialog.findViewById(R.id.cancel);
        quantity = (TextView) dialog.findViewById(R.id.quantity);

        vegetarian = (ImageView) dialog.findViewById(R.id.vegetarian);
    }
}
