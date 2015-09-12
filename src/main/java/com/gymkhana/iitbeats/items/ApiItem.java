package com.gymkhana.iitbeats.items;

import android.content.Context;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class ApiItem {
    public String url, filename;
    public Context context;
    public Integer data_type;

    public ApiItem() {
        ;
    }

    public ApiItem(Context context, String url, String filename, Integer data_type) {
        this.context = context;
        this.url = url;
        this.filename = filename;
        this.data_type = data_type;
    }
}
