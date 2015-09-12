package com.gymkhana.iitbeats.items;

import org.json.JSONObject;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class FoodItem {
    public Integer id;
    public String name, image;
    public Boolean is_vegetarian;
    public CategoryItem category;

    public FoodItem(JSONObject json) throws Exception {
        id = json.getInt(JsonKeys.ID);
        name = json.getString(JsonKeys.NAME);
        image = json.getString(JsonKeys.IMAGE);
        is_vegetarian = json.getBoolean(JsonKeys.VEGETARIAN);
        category = new CategoryItem(json.getJSONObject(JsonKeys.CATEGORY));
    }

    public static final class JsonKeys {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String VEGETARIAN = "vegetarian";
        public static final String CATEGORY = "category";
    }
}
