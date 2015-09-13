package com.gymkhana.iitbeats.items;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class MenuItem implements Serializable {
    public Integer id, shop_id;
    public Double price;
    public Boolean is_available;
    public FoodItem food_item;
    public List<Integer> toppings = new ArrayList<>();

    public MenuItem() {
    }

    public MenuItem(JSONObject json) throws Exception {
        id = json.getInt(JsonKeys.ID);
        // shop_id = json.getInt(JsonKeys.SHOP);
        price = json.getDouble(JsonKeys.PRICE);
        is_available = json.getBoolean(JsonKeys.IS_AVAILABLE);
        food_item = new FoodItem(json.getJSONObject(JsonKeys.FOOD));

        JSONArray toppings_array = json.getJSONArray(JsonKeys.TOPPINGS);
        for (int index = 0; index < toppings_array.length(); index++) {
            toppings.add(toppings_array.getInt(index));
        }
    }

    public static List<MenuItem> filterMenu(List<MenuItem> source, Integer category) {
        List<MenuItem> list = new ArrayList<>();
        for (MenuItem item : source) {
            if (item.food_item.categories.contains(category)) {
                list.add(item);
            }
        }
        return list;
    }

    public static Map<Integer, MenuItem> getMapping(List<MenuItem> source) {
        Map<Integer, MenuItem> mapping = new HashMap<>();
        for (MenuItem item : source) {
            mapping.put(item.id, item);
        }
        return mapping;
    }

    public String getPrice() {
        return "\u20B9 " + price.toString();
    }

    public static final class JsonKeys {
        public static final String ID = "id";
        public static final String FOOD = "food_item";
        public static final String SHOP = "shop";
        public static final String TOPPINGS = "toppings";
        public static final String PRICE = "price";
        public static final String IS_AVAILABLE = "is_available";
    }

}