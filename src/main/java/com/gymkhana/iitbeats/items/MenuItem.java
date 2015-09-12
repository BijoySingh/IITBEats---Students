package com.gymkhana.iitbeats.items;

import org.json.JSONObject;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class MenuItem {
    public Integer id, food_id, shop_id;
    public Double price;
    public String name, image;
    public Boolean is_vegetarian, is_available;
    public CategoryItem category;

    public MenuItem() {
    }

    public MenuItem(JSONObject json) throws Exception {
        id = json.getInt(JsonKeys.ID);
        food_id = json.getInt(JsonKeys.FOOD_ID);
        shop_id = json.getInt(JsonKeys.SHOP_ID);
        price = json.getDouble(JsonKeys.PRICE);

        name = json.getString(JsonKeys.NAME);
        image = json.getString(JsonKeys.IMAGE);

        is_vegetarian = json.getBoolean(JsonKeys.VEGETARIAN);
        is_available = json.getBoolean(JsonKeys.AVAILABLE);

//        category = new CategoryItem(json.getJSONObject(JsonKeys.CATEGORY));
    }

    public static final class JsonKeys {
        public static final String ID = "id";
        public static final String FOOD_ID = "food_id";
        public static final String SHOP_ID = "shop_id";
        public static final String PRICE = "price";
        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String VEGETARIAN = "vegetarian";
        public static final String AVAILABLE = "available";
        public static final String CATEGORY = "category";
    }

}