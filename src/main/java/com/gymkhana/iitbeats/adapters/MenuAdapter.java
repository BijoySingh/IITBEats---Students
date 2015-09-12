package com.gymkhana.iitbeats.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.MenuItem;
import com.gymkhana.iitbeats.viewholder.MenuViewHolder;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private Context mContext;
    private RefreshBasedFragment<MenuItem> mFragment;

    public MenuAdapter(Context context,
                       RefreshBasedFragment<MenuItem> fragment) {
        mContext = context;
        mFragment = fragment;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);
        MenuViewHolder vh = new MenuViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, final int position) {

        final MenuItem data = mFragment.getValues().get(position);

    }

    @Override
    public int getItemCount() {
        return mFragment.getValues().size();
    }

}