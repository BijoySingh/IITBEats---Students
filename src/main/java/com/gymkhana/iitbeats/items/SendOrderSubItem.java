package com.gymkhana.iitbeats.items;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by BijoySingh on 9/13/2015.
 */
public class SendOrderSubItem {
    public MenuItem food;
    public Integer quantity;
    public Set<Integer> toppings = new HashSet<>();
}
