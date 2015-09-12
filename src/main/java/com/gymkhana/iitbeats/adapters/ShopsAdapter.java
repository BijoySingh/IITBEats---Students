package com.gymkhana.iitbeats.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.ShopsItem;
import com.gymkhana.iitbeats.viewholder.ShopsViewHolder;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class ShopsAdapter extends RecyclerView.Adapter<ShopsViewHolder> {

    private Context mContext;
    private RefreshBasedFragment<ShopsItem> mFragment;

    public ShopsAdapter(Context context,
                        RefreshBasedFragment<ShopsItem> fragment) {
        mContext = context;
        mFragment = fragment;
    }

    @Override
    public ShopsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shops_item, parent, false);
        ShopsViewHolder vh = new ShopsViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ShopsViewHolder holder, final int position) {

        final ShopsItem data = mFragment.getValues().get(position);
        holder.title.setText(data.title);
        holder.address.setText(data.address);
        holder.owner.setText(data.owner);
        holder.phone.setText(data.phone);

        if (data.open) {
            holder.status.setColorFilter(Color.parseColor("#388E3C"));
        } else {
            holder.status.setColorFilter(Color.parseColor("#9E9E9E"));
        }
    }

    @Override
    public int getItemCount() {
        return mFragment.getValues().size();
    }

}