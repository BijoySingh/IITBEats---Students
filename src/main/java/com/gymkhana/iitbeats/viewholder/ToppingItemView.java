package com.gymkhana.iitbeats.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.items.MenuItem;
import com.rey.material.widget.CheckBox;

/**
 * Created by BijoySingh on 9/13/2015.
 */
public class ToppingItemView extends LinearLayout {

    public ImageView vegetarian;
    public CheckBox status;
    public TextView price;

    public ToppingItemView(Context context) {
        super(context);
        init(context);
    }

    public ToppingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ToppingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.topping_item, this, true);

        vegetarian = (ImageView) view.findViewById(R.id.vegetarian);
        status = (CheckBox) view.findViewById(R.id.food_checkbox);
        price = (TextView) view.findViewById(R.id.price);
    }

    public void setup(MenuItem item) {
        vegetarian.setImageResource(item.food_item.getVegetarianResource());
        status.setText(item.food_item.name);
        price.setText(item.getPrice());
    }
}
