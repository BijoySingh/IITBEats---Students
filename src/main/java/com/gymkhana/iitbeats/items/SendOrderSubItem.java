package com.gymkhana.iitbeats.items;

import android.text.TextUtils;

import com.gymkhana.iitbeats.utils.SessionVariables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by BijoySingh on 9/13/2015.
 */
public class SendOrderSubItem {
    public MenuItem food;
    public Integer quantity;
    public Set<Integer> toppings = new HashSet<>();

    public Double getCost() {
        Double cost = 0.0;
        cost += food.price;
        for (Integer topping_id : toppings) {
            cost += SessionVariables.mToppingMapping.get(topping_id).price;
        }
        cost *= quantity;
        return cost;
    }

    public String getIndianCost() {
        return "\u20B9 " + getCost().toString();
    }

    public String getToppings() {
        if (toppings.size() == 0) {
            return "None";
        }

        List<String> list = new ArrayList<>();
        for (Integer topping_id : toppings) {
            list.add(SessionVariables.mToppingMapping.get(topping_id).food_item.name);
        }
        return TextUtils.join(", ", list);
    }
}
