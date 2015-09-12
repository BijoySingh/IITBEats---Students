package com.gymkhana.iitbeats.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.adapters.ShopsAdapter;
import com.gymkhana.iitbeats.items.ShopsItem;
import com.gymkhana.iitbeats.utils.Filenames;
import com.gymkhana.iitbeats.utils.Functions;

import java.util.List;

@SuppressLint("NewApi")
public class ShopsFragment extends RefreshBasedFragment<ShopsItem> {

    ShopsAdapter mAdapter;
    String FILENAME = Filenames.getFilename(Filenames.SHOP);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recycler_layout, container, false);
        setupRecyclerView(rootView);

        String filetext = Functions.offlineDataReader(getActivity(), FILENAME);
        if (!filetext.contentEquals("")) {

        }

        Functions.setActionBarTitle((ActionBarActivity) getActivity(), getString(R.string.drawer_shops));
        setupRecyclerView(rootView);

        return rootView;
    }

    public void setupRecyclerView(View rootView) {
        initializeRecyclerView(rootView);
        mAdapter = new ShopsAdapter(mContext, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateList(List<ShopsItem> list) {
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

    @Override
    public void refreshList() {
        Log.d("MENU LIST FRAGMENT", "Downloader Called");
    }
}

