package com.gymkhana.iitbeats.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.adapters.OrdersAdapter;
import com.gymkhana.iitbeats.api.JsonParser;
import com.gymkhana.iitbeats.items.ApiItem;
import com.gymkhana.iitbeats.items.OrdersItem;
import com.gymkhana.iitbeats.utils.DataType;
import com.gymkhana.iitbeats.utils.Functions;

import java.util.List;

@SuppressLint("NewApi")
public class OrdersFragment extends RefreshBasedFragment<OrdersItem> {

    OrdersAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recycler_layout, container, false);
        setupRecyclerView(rootView);

        mApiItem = ApiItem.getInstance(mContext, DataType.ORDERS, null);
        String cache = Functions.offlineDataReader(getActivity(), mApiItem.filename);
        JsonParser.parseResponse(cache, mApiItem, this);
        refreshList();

        Functions.setActionBarTitle((ActionBarActivity) getActivity(), getString(R.string.drawer_orders));
        setupRecyclerView(rootView);

        return rootView;
    }

    public void setupRecyclerView(View rootView) {
        initializeRecyclerView(rootView);
        mAdapter = new OrdersAdapter(mContext, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateList(List<OrdersItem> list) {
        if (list == null) {
            return;
        }

        try {
            mValues = list;
            mAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

