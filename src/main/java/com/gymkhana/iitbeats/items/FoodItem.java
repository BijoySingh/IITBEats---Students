package com.gymkhana.iitbeats.items;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class FoodItem {
    public Integer id;
    public String name, image;
    public Boolean is_vegetarian;
    public List<Integer> categories = new ArrayList<>();

    public FoodItem(JSONObject json) throws Exception {
        id = json.getInt(JsonKeys.ID);
        name = json.getString(JsonKeys.NAME);
        image = json.getString(JsonKeys.IMAGE);
        is_vegetarian = json.getBoolean(JsonKeys.VEGETARIAN);

        JSONArray categories_array = json.getJSONArray(JsonKeys.CATEGORIES);
        for (int index = 0; index < categories_array.length(); index++) {
            categories.add(categories_array.getInt(index));
        }
    }

    public static final class JsonKeys {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String VEGETARIAN = "vegetarian";
        public static final String CATEGORIES = "categories";
    }
}
