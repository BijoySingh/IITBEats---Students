package com.gymkhana.iitbeats.api;

import android.util.Log;

import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.ApiItem;
import com.gymkhana.iitbeats.utils.DataType;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class JsonParser {
    public static final void parseResponse(String response, ApiItem item, RefreshBasedFragment fragment) {
        if (response == null || response.isEmpty())
            return;

        try {
            if (item.data_type == DataType.MENU) {

            }
        } catch (Exception error) {
            Log.e(JsonParser.class.getSimpleName(), "Parsing Error", error);
        }
    }
}
