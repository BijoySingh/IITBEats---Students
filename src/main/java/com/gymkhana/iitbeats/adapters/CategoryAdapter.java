package com.gymkhana.iitbeats.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.CategoryItem;
import com.gymkhana.iitbeats.viewholder.CategoryViewHolder;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private Context mContext;
    private RefreshBasedFragment<CategoryItem> mFragment;

    public CategoryAdapter(Context context,
                           RefreshBasedFragment<CategoryItem> fragment) {
        mContext = context;
        mFragment = fragment;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_item, parent, false);
        CategoryViewHolder vh = new CategoryViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int position) {

        final CategoryItem data = mFragment.getValues().get(position);

    }

    @Override
    public int getItemCount() {
        return mFragment.getValues().size();
    }

}