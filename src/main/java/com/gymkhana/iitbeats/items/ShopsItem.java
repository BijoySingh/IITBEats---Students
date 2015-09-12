package com.gymkhana.iitbeats.items;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.utils.Colors;

import org.json.JSONObject;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class ShopsItem {
    public String name, address, phone;
    public Integer id;
    public Boolean status;
    public ShopOwner shop_owner;

    public ShopsItem(JSONObject json) throws Exception {
        id = json.getInt(JsonKeys.ID);

        name = json.getString(JsonKeys.NAME);
        address = json.getString(JsonKeys.ADDRESS);
        phone = json.getString(JsonKeys.PHONE);
        status = json.getBoolean(JsonKeys.STATUS);

        shop_owner = new ShopOwner(json.getJSONObject(JsonKeys.USER));

    }

    public Integer getStatusColor() {
        if (status) {
            return Colors.AVAILABLE;
        }

        return Colors.UNAVAILABLE;
    }

    public Integer getStoreImage(Integer position) {
        switch (position % 6) {
            case 1:
                return R.drawable.store_1;
            case 2:
                return R.drawable.store_2;
            case 3:
                return R.drawable.store_3;
            case 4:
                return R.drawable.store_4;
            case 5:
                return R.drawable.store_5;
            default:
                return R.drawable.store_0;
        }
    }

    public static final class JsonKeys {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String ADDRESS = "address";
        public static final String PHONE = "phone";
        public static final String USER = "user";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String STATUS = "status";
    }

    public class ShopOwner {
        public Integer id;
        public String first_name, last_name;

        public ShopOwner(JSONObject json) throws Exception {
            id = json.getInt(JsonKeys.ID);
            first_name = json.getString(JsonKeys.FIRST_NAME);
            last_name = json.getString(JsonKeys.LAST_NAME);
        }

        public String getName() {
            return first_name + " " + last_name;
        }
    }
}