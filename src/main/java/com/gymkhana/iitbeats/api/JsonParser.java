package com.gymkhana.iitbeats.api;

import android.util.Log;

import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.ApiItem;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class JsonParser {
    public static final void parseResponse(String response, ApiItem item, RefreshBasedFragment fragment) {
        if (response == null || response.isEmpty())
            return;

        try {

        } catch (Exception error) {
            Log.e(JsonParser.class.getSimpleName(), "Parsing Error", error);
        }
    }
}
