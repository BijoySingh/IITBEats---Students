package com.gymkhana.iitbeats.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.api.ApiUtility;
import com.gymkhana.iitbeats.items.ApiItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bijoy on 8/4/15.
 */
public abstract class RefreshBasedFragment<T> extends Fragment {

    ApiItem mApiItem;
    Context mContext;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    List<T> mValues = new ArrayList<>();

    public void updateList(List<T> list) {
        return;
    }

    public void stopRefreshIndicator() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void initializeRecyclerView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshList();
            }
        });
        mSwipeRefreshLayout.setColorSchemeResources(R.color.accent_color, R.color.primary_color);
        mSwipeRefreshLayout.setEnabled(true);
    }

    public void refreshList() {
        Log.d(RefreshBasedFragment.class.getSimpleName(), "API CALL");
        ApiUtility.call(mApiItem, this);
    }

    public boolean renderOfflineList() {
        return false;
    }

    public List<T> getValues() {
        return mValues;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}