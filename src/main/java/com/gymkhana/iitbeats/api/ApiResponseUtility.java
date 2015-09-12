package com.gymkhana.iitbeats.api;

import android.util.Log;

import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.ApiItem;
import com.gymkhana.iitbeats.items.BillsItem;
import com.gymkhana.iitbeats.items.CategoryItem;
import com.gymkhana.iitbeats.items.MenuItem;
import com.gymkhana.iitbeats.items.OrdersItem;
import com.gymkhana.iitbeats.items.ShopsItem;
import com.gymkhana.iitbeats.utils.DataType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class ApiResponseUtility {
    public static final void parseResponse(String response,
                                           ApiItem item,
                                           RefreshBasedFragment fragment) {
        if (response == null || response.isEmpty())
            return;

        try {
            if (item.data_type == DataType.MENU) {
                fragment.updateList(parseMenuItem(response));
            } else if (item.data_type == DataType.CATEGORY) {
                fragment.updateList(filterCategories(parseMenuItem(response)));
            } else if (item.data_type == DataType.SHOPS) {
                fragment.updateList(parseShopsItem(response));
            } else if (item.data_type == DataType.ORDERS) {
                fragment.updateList(parseOrdersItem(response));
            } else if (item.data_type == DataType.BILLS) {
                fragment.updateList(parseBillsItem(response));
            }
        } catch (Exception error) {
            Log.e(ApiResponseUtility.class.getSimpleName(), "Parsing Error", error);
        }
    }

    public static final List<MenuItem> parseMenuItem(String response) throws Exception {
        List<MenuItem> list = new ArrayList<>();
        JSONArray data = new JSONObject(response).getJSONArray("results");
        for (int index = 0; index < data.length(); index++) {
            JSONObject json = data.getJSONObject(index);
            MenuItem item = new MenuItem(json);
            list.add(item);
        }
        return list;
    }

    public static final List<ShopsItem> parseShopsItem(String response) throws Exception {
        JSONArray data = new JSONObject(response).getJSONArray("results");
        return null;
    }

    public static final List<OrdersItem> parseOrdersItem(String response) throws Exception {
        JSONArray data = new JSONObject(response).getJSONArray("results");
        return null;
    }

    public static final List<BillsItem> parseBillsItem(String response) throws Exception {
        JSONArray data = new JSONObject(response).getJSONArray("results");
        return null;
    }

    public static final List<CategoryItem> filterCategories(List<MenuItem> menu) {
        Set<Integer> categories = new HashSet<>();
        List<CategoryItem> list = new ArrayList<>();
        for (MenuItem menu_item : menu) {
            if (!categories.contains(menu_item.food_item.category.id)) {
                list.add(menu_item.food_item.category);
            }
        }
        return list;
    }
}
