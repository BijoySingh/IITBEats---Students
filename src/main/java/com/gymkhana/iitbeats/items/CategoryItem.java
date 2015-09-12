package com.gymkhana.iitbeats.items;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class CategoryItem implements Serializable {
    public Integer id;
    public String name, image;

    public CategoryItem() {
    }

    public CategoryItem(Integer id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public CategoryItem(JSONObject json) throws Exception {
        id = json.getInt(JsonKeys.ID);
        name = json.getString(JsonKeys.NAME);
        image = json.getString(JsonKeys.IMAGE);
    }

    public static final class JsonKeys {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String IMAGE = "image";
    }
}