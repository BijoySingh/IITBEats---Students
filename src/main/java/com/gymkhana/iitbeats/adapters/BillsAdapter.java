package com.gymkhana.iitbeats.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.BillsItem;
import com.gymkhana.iitbeats.viewholder.BillsViewHolder;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class BillsAdapter extends RecyclerView.Adapter<BillsViewHolder> {

    private Context mContext;
    private RefreshBasedFragment<BillsItem> mFragment;

    public BillsAdapter(Context context,
                        RefreshBasedFragment<BillsItem> fragment) {
        mContext = context;
        mFragment = fragment;
    }

    @Override
    public BillsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_item, parent, false);
        BillsViewHolder vh = new BillsViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(BillsViewHolder holder, final int position) {

        final BillsItem data = mFragment.getValues().get(position);

    }

    @Override
    public int getItemCount() {
        return mFragment.getValues().size();
    }

}