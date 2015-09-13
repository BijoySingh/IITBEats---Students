package com.gymkhana.iitbeats.items;

import android.text.TextUtils;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.utils.SessionVariables;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class FoodItem implements Serializable {
    public Integer id;
    public String name, image;
    public Boolean is_vegetarian;
    public List<Integer> categories = new ArrayList<>();

    public FoodItem(JSONObject json) throws Exception {
        id = json.getInt(JsonKeys.ID);
        name = json.getString(JsonKeys.NAME);
        image = json.getString(JsonKeys.IMAGE);
        is_vegetarian = json.getBoolean(JsonKeys.IS_VEG);

        JSONArray categories_array = json.getJSONArray(JsonKeys.CATEGORIES);
        for (int index = 0; index < categories_array.length(); index++) {
            categories.add(categories_array.getInt(index));
        }
    }

    public Integer getVegetarianResource() {
        if (is_vegetarian) {
            return R.drawable.vegetarian;
        } else {
            return R.drawable.non_vegetarian;
        }
    }

    public String getCategories() {
        List<String> list = new ArrayList<>();
        for (int category_id : categories) {
            list.add(SessionVariables.mCategoryMapping.get(category_id).name);
        }
        return TextUtils.join(", ", list);
    }

    public static final class JsonKeys {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String IS_VEG = "is_veg";
        public static final String CATEGORIES = "categories";
    }
}
