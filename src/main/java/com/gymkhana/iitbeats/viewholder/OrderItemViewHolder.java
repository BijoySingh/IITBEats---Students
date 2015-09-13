package com.gymkhana.iitbeats.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gymkhana.iitbeats.MainActivity;
import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.items.DrawerItem;
import com.gymkhana.iitbeats.items.MenuItem;
import com.gymkhana.iitbeats.items.SendOrderSubItem;
import com.gymkhana.iitbeats.utils.SessionVariables;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class OrderItemViewHolder {

    public LinearLayout toppings;
    public Context context;
    public TextView name, categories, price, cancel, add, quantity, net;
    public ImageView vegetarian, plus, minus;
    SendOrderSubItem send_order_item = new SendOrderSubItem();

    public OrderItemViewHolder(View view) {
        name = (TextView) view.findViewById(R.id.name);
        price = (TextView) view.findViewById(R.id.price);
        categories = (TextView) view.findViewById(R.id.categories);

        add = (TextView) view.findViewById(R.id.add);
        cancel = (TextView) view.findViewById(R.id.cancel);
        quantity = (TextView) view.findViewById(R.id.quantity);
        net = (TextView) view.findViewById(R.id.net);

        vegetarian = (ImageView) view.findViewById(R.id.vegetarian);
        plus = (ImageView) view.findViewById(R.id.plus);
        minus = (ImageView) view.findViewById(R.id.minus);

        toppings = (LinearLayout) view.findViewById(R.id.toppings);
    }

    public void setupView(Context context, MenuItem item) {
        this.context = context;
        send_order_item.food = item;
        send_order_item.quantity = 1;

        name.setText(item.food_item.name);
        vegetarian.setImageResource(item.food_item.getVegetarianResource());
        categories.setText(item.food_item.getCategories());
        quantity.setText(send_order_item.quantity.toString());
        price.setText(item.getPrice());
        updateCost();
        setQuantityListeners();
        addToppings(context, item);
    }

    public void updateCost() {
        net.setText(send_order_item.getIndianCost());
    }

    public void addToppings(Context context, MenuItem item) {
        for (final Integer topping_id : item.toppings) {
            ToppingItemView item_view = new ToppingItemView(context);
            item_view.setup(SessionVariables.mToppingMapping.get(topping_id));
            item_view.status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        send_order_item.toppings.add(topping_id);
                    else
                        send_order_item.toppings.remove(topping_id);
                    updateCost();
                }
            });
            toppings.addView(item_view);
        }
    }

    public void setQuantityListeners() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionVariables.addItemToOrder(send_order_item);
                ((MainActivity) context).updateOrderBadge();
                ((MainActivity) context).displayFragment(DrawerItem.Tags.MENU);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).displayFragment(DrawerItem.Tags.MENU);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_order_item.quantity = send_order_item.quantity + 1;
                send_order_item.quantity = Math.min(send_order_item.quantity, 10);

                quantity.setText(send_order_item.quantity.toString());
                updateCost();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_order_item.quantity = send_order_item.quantity - 1;
                send_order_item.quantity = Math.max(send_order_item.quantity, 1);

                quantity.setText(send_order_item.quantity.toString());
                updateCost();
            }
        });
    }
}
