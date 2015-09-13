package com.gymkhana.iitbeats.items;

import com.gymkhana.iitbeats.utils.SessionVariables;

import java.util.HashSet;
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
}
