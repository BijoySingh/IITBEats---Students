package com.gymkhana.iitbeats.utils;

import com.gymkhana.iitbeats.items.BillsItem;
import com.gymkhana.iitbeats.items.CategoryItem;
import com.gymkhana.iitbeats.items.MenuItem;
import com.gymkhana.iitbeats.items.OrdersItem;
import com.gymkhana.iitbeats.items.SendOrderItem;
import com.gymkhana.iitbeats.items.ShopsItem;

import java.util.List;
import java.util.Map;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class SessionVariables {
    public static Integer mShopId = 0;
    public static Integer mCategoryId = 0;

    public static List<ShopsItem> mShopsItems;
    public static List<MenuItem> mMenuItems;
    public static List<MenuItem> mToppingItems;
    public static List<CategoryItem> mCategoryItems;
    public static List<OrdersItem> mOrderItems;
    public static List<BillsItem> mBillsItems;

    public static Map<Integer, CategoryItem> mCategoryMapping;
    public static Map<Integer, MenuItem> mToppingMapping;

    public static SendOrderItem mSendOrder;
}
