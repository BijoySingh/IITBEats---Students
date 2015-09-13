package com.gymkhana.iitbeats.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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

    public CurrentOrderViewHolder init(Context context) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.orders_item, this, true);

        name = (TextView) view.findViewById(R.id.name);
        quantity = (TextView) view.findViewById(R.id.quantity);
        vegetarian = (ImageView) view.findViewById(R.id.vegetarian);
        toppings = (TextView) view.findViewById(R.id.toppings);
        cost = (TextView) view.findViewById(R.id.cost);

        delete = (TextView) view.findViewById(R.id.delete);
        update = (TextView) view.findViewById(R.id.update);

        return this;
    }

    public void setupView(Context context, SendOrderSubItem item) {
        this.context = context;
        name.setText(item.food.food_item.name);
        vegetarian.setImageResource(item.food.food_item.getVegetarianResource());
        quantity.setText(item.quantity.toString());
        toppings.setText(item.getToppings());
        cost.setText(item.getIndianCost());
    }
}
