package com.gymkhana.iitbeats.api;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class ServerUrls {
    public static final String BASE_URL = "http://bijoysingh.com/iitbeats/";
    public static final String DELIMITER = "/";

    public static final String getUrl(String tag) {
        return BASE_URL + tag + DELIMITER;
    }

    public static final String getShops() {
        return getUrl(Tags.SHOPS);
    }

    public static final String getOrders() {
        return getUrl(Tags.ORDERS);
    }

    public static final String getBillings() {
        return getUrl(Tags.BILLS);
    }

    public static final String getMenu(Integer shop_id) {
        return getUrl(Tags.MENU) + shop_id + DELIMITER;
    }

    public static final class Tags {
        public static final String MENU = "menu";
        public static final String SHOPS = "shops";
        public static final String ORDERS = "orders";
        public static final String BILLS = "bills";
    }

}
