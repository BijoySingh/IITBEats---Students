package com.gymkhana.iitbeats.utils;

import android.content.Context;
import android.util.Log;

import com.gymkhana.iitbeats.api.ApiResponseUtility;
import com.gymkhana.iitbeats.api.ApiUtility;
import com.gymkhana.iitbeats.items.ApiItem;
import com.gymkhana.iitbeats.items.BillsItem;
import com.gymkhana.iitbeats.items.CategoryItem;
import com.gymkhana.iitbeats.items.MenuItem;
import com.gymkhana.iitbeats.items.OrdersItem;
import com.gymkhana.iitbeats.items.SendOrderItem;
import com.gymkhana.iitbeats.items.SendOrderSubItem;
import com.gymkhana.iitbeats.items.ShopsItem;

import java.util.List;
import java.util.Map;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class SessionVariables {
    public static Integer mCategoryId = 0;

    public static List<ShopsItem> mShopsItems;
    public static List<MenuItem> mMenuItems;
    public static List<MenuItem> mToppingItems;
    public static List<CategoryItem> mCategoryItems;
    public static List<OrdersItem> mOrderItems;
    public static List<BillsItem> mBillsItems;

    public static Map<Integer, CategoryItem> mCategoryMapping;
    public static Map<Integer, MenuItem> mToppingMapping;
    public static SendOrderItem mSendOrder = new SendOrderItem();
    private static ShopsItem mActiveShop = null;

    public static void addItemToOrder(SendOrderSubItem item) {
        mSendOrder.items.add(item);
    }

    public static ShopsItem getShopById(Context context, Integer shop_id) {
        try {
            if (mShopsItems == null || mShopsItems.isEmpty()) {
                String cache = Functions.offlineDataReader(context, Filenames.SHOPS);
                mShopsItems = ApiResponseUtility.parseShopsItem(cache);
            }
        } catch (Exception e) {
            ApiUtility.call(ApiItem.getInstance(context, DataType.SHOPS, null), null);
            Log.e(SessionVariables.class.getSimpleName(), e.getLocalizedMessage(), e);
        }

        if (mShopsItems == null) {
            return null;
        }

        for (ShopsItem shop : mShopsItems) {
            if (shop.id == shop_id) {
                return shop;
            }
        }

        return null;
    }

    public static Integer getActiveShopId(Context context) {
        if (mActiveShop == null) {
            Integer activeShop = LocalData.load(context, LocalData.Tags.ACTIVE_SHOP_ID, -1);
            mActiveShop = getShopById(context, activeShop);

            if (mActiveShop == null) {
                return null;
            }
            return mActiveShop.id;
        }
        return mActiveShop.id;
    }

    public static void setActiveShop(Context context, ShopsItem shop) {
        mActiveShop = shop;
        LocalData.save(context, LocalData.Tags.ACTIVE_SHOP_ID, shop.id);
    }
}
