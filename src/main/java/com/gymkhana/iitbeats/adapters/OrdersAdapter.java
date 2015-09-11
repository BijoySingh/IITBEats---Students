package com.gymkhana.iitbeats.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.OrdersItem;
import com.gymkhana.iitbeats.viewholder.OrdersViewHolder;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class OrdersAdapter extends RecyclerView.Adapter<OrdersViewHolder> {

    private Context mContext;
    private RefreshBasedFragment<OrdersItem> mFragment;

    public OrdersAdapter(Context context,
                         RefreshBasedFragment<OrdersItem> fragment) {
        mContext = context;
        mFragment = fragment;
    }

    @Override
    public OrdersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_item, parent, false);
        OrdersViewHolder vh = new OrdersViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(OrdersViewHolder holder, final int position) {

        final OrdersItem data = mFragment.getValues().get(position);

    }

    @Override
    public int getItemCount() {
        return mFragment.getValues().size();
    }

}