package com.gymkhana.iitbeats.api;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.ApiItem;
import com.gymkhana.iitbeats.utils.Functions;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class ApiUtility {

    public static final String LOG_KEY = ApiUtility.class.getSimpleName();

    public static void call(final ApiItem item, RefreshBasedFragment fragment) {
        Log.d(LOG_KEY, item.filename + " => " + item.url);

        StringRequest request = new StringRequest
                (Request.Method.GET, item.url, new Response
                        .Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (item.filename != null) {
                            Functions.offlineDataWriter(item.context, item.filename,
                                    Functions.correctUTFEncoding(response));
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Log.e(LOG_KEY, Functions.showVolleyError(error));
                    }
                });

        Volley.newRequestQueue(item.context).add(request);
    }
    
}
