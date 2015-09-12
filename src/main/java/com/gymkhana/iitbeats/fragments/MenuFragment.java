package com.gymkhana.iitbeats.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.adapters.MenuAdapter;
import com.gymkhana.iitbeats.api.ApiResponseUtility;
import com.gymkhana.iitbeats.items.ApiItem;
import com.gymkhana.iitbeats.items.MenuItem;
import com.gymkhana.iitbeats.utils.DataType;
import com.gymkhana.iitbeats.utils.Functions;

import java.util.List;

@SuppressLint("NewApi")
public class MenuFragment extends RefreshBasedFragment<MenuItem> {

    MenuAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recycler_layout, container, false);
        setupRecyclerView(rootView);

        mApiItem = ApiItem.getInstance(mContext, DataType.MENU, null);
        String cache = Functions.offlineDataReader(getActivity(), mApiItem.filename);
        ApiResponseUtility.parseResponse(cache, mApiItem, this);
        refreshList();

        Functions.setActionBarTitle((ActionBarActivity) getActivity(), getString(R.string.drawer_menu));
        setupRecyclerView(rootView);

        return rootView;
    }

    public void setupRecyclerView(View rootView) {
        initLinearRecyclerView(rootView);
        mAdapter = new MenuAdapter(mContext, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateList(List<MenuItem> list) {
        super.updateList(list);
        mAdapter.notifyDataSetChanged();
    }
}

