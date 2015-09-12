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
import com.gymkhana.iitbeats.utils.SessionVariables;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
                getShopMenu(response);
                fragment.updateList(MenuItem.filterMenu(
                        SessionVariables.mMenuItems,
                        SessionVariables.mCategoryId));
            } else if (item.data_type == DataType.CATEGORY) {
                getShopMenu(response);
                fragment.updateList(SessionVariables.mCategoryItems);
            } else if (item.data_type == DataType.SHOPS) {
                SessionVariables.mShopsItems = parseShopsItem(response);
                fragment.updateList(SessionVariables.mShopsItems);
            } else if (item.data_type == DataType.ORDERS) {
                SessionVariables.mOrderItems = parseOrdersItem(response);
                fragment.updateList(SessionVariables.mOrderItems);
            } else if (item.data_type == DataType.BILLS) {
                SessionVariables.mBillsItems = parseBillsItem(response);
                fragment.updateList(SessionVariables.mBillsItems);
            }
        } catch (Exception error) {
            Log.e(ApiResponseUtility.class.getSimpleName(), "Parsing Error", error);
        }
    }

    public static final void getShopMenu(String response) throws Exception {
        SessionVariables.mMenuItems = parseMenuItem(response);
        SessionVariables.mCategoryItems = parseCategoryItem(response);

        SessionVariables.mCategoryMapping = new HashMap<>();
        for (CategoryItem item : SessionVariables.mCategoryItems) {
            SessionVariables.mCategoryMapping.put(item.id, item);
        }
    }

    public static final List<MenuItem> parseMenuItem(String response) throws Exception {
        List<MenuItem> list = new ArrayList<>();
        JSONArray data = new JSONObject(response).getJSONArray("menu");
        for (int index = 0; index < data.length(); index++) {
            JSONObject json = data.getJSONObject(index);
            MenuItem item = new MenuItem(json);
            list.add(item);
        }
        return list;
    }

    public static final List<CategoryItem> parseCategoryItem(String response) throws Exception {
        List<CategoryItem> list = new ArrayList<>();
        JSONArray data = new JSONObject(response).getJSONArray("categories");
        for (int index = 0; index < data.length(); index++) {
            JSONObject json = data.getJSONObject(index);
            CategoryItem item = new CategoryItem(json);
            list.add(item);
        }
        return list;
    }

    public static final List<ShopsItem> parseShopsItem(String response) throws Exception {
        List<ShopsItem> list = new ArrayList<>();
        JSONArray data = new JSONObject(response).getJSONArray("results");
        for (int index = 0; index < data.length(); index++) {
            JSONObject json = data.getJSONObject(index);
            ShopsItem item = new ShopsItem(json);
            list.add(item);
        }
        return list;
    }

    public static final List<OrdersItem> parseOrdersItem(String response) throws Exception {
        List<OrdersItem> list = new ArrayList<>();
        JSONArray data = new JSONObject(response).getJSONArray("results");
        for (int index = 0; index < data.length(); index++) {
            JSONObject json = data.getJSONObject(index);
            OrdersItem item = new OrdersItem(json);
            list.add(item);
        }
        return list;
    }

    public static final List<BillsItem> parseBillsItem(String response) throws Exception {
        List<BillsItem> list = new ArrayList<>();
        JSONArray data = new JSONObject(response).getJSONArray("results");
        for (int index = 0; index < data.length(); index++) {
            JSONObject json = data.getJSONObject(index);
            BillsItem item = new BillsItem(json);
            list.add(item);
        }
        return list;
    }
}
