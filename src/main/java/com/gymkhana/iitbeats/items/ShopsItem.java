package com.gymkhana.iitbeats.items;

import org.json.JSONObject;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class ShopsItem {
    public String title, address, phone, owner;
    public Integer id;

    public ShopsItem(JSONObject json) throws Exception {
        id = json.getInt(JsonKeys.ID);

        title = json.getString(JsonKeys.TITLE);
        address = json.getString(JsonKeys.ADDRESS);
        phone = json.getString(JsonKeys.PHONE);
        owner = json.getString(JsonKeys.OWNER);
    }

    public static final class JsonKeys {
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String ADDRESS = "address";
        public static final String PHONE = "phone";
        public static final String OWNER = "owner";
    }
}