package com.gymkhana.iitbeats.items;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class MenuItem implements Serializable {
    public Integer id, shop_id;
    public Double price;
    public Boolean is_available;
    public FoodItem food_item;

    public MenuItem() {
    }

    public MenuItem(JSONObject json) throws Exception {
        id = json.getInt(JsonKeys.ID);
        shop_id = json.getInt(JsonKeys.SHOP_ID);
        price = json.getDouble(JsonKeys.PRICE);
        is_available = json.getBoolean(JsonKeys.AVAILABLE);
        food_item = new FoodItem(json.getJSONObject(JsonKeys.FOOD));
    }

    public static final class JsonKeys {
        public static final String ID = "id";
        public static final String FOOD = "food";
        public static final String SHOP_ID = "shop_id";
        public static final String PRICE = "price";
        public static final String AVAILABLE = "available";
    }

}