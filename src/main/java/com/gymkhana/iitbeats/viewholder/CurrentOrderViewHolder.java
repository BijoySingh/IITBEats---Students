package com.gymkhana.iitbeats.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.items.SendOrderSubItem;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class CurrentOrderViewHolder extends LinearLayout {

    public Context context;
    public TextView name, toppings, cost, quantity;
    public TextView delete, update;
    public ImageView vegetarian;

    public CurrentOrderViewHolder(Context context) {
        super(context);
    }

    public CurrentOrderViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CurrentOrderViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CurrentOrderViewHolder init() {
        name = (TextView) findViewById(R.id.name);
        quantity = (TextView) findViewById(R.id.quantity);
        vegetarian = (ImageView) findViewById(R.id.vegetarian);
        toppings = (TextView) findViewById(R.id.toppings);
        cost = (TextView) findViewById(R.id.cost);

        delete = (TextView) findViewById(R.id.delete);
        update = (TextView) findViewById(R.id.update);

        return this;
    }

    public void setupView(Context context, SendOrderSubItem item) {
        this.context = context;
        name.setText(item.food.food_item.name);
        vegetarian.setImageResource(item.food.food_item.getVegetarianResource());
        quantity.setText(item.quantity.toString());
        toppings.setText(item.getIndianCost());
        cost.setText(item.getToppings());
    }
}
