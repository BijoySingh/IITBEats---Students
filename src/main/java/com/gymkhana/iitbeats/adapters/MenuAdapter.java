package com.gymkhana.iitbeats.adapters;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.MenuItem;
import com.gymkhana.iitbeats.utils.Functions;
import com.gymkhana.iitbeats.viewholder.MenuViewHolder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private final ImageLoader mImageLoader;
    private Context mContext;
    private RefreshBasedFragment<MenuItem> mFragment;

    public MenuAdapter(Context context,
                       RefreshBasedFragment<MenuItem> fragment) {
        mContext = context;
        mFragment = fragment;
        mImageLoader = Functions.loadImageLoader(context);
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
        holder.name.setText(data.food_item.name);
        holder.categories.setText(data.food_item.getCategories());
        holder.price.setText(data.getPrice());
        holder.vegetarian.setImageResource(data.food_item.getVegetarianResource());

        if (URLUtil.isValidUrl(data.food_item.image)) {
            ImageAware imageAware = new ImageViewAware(holder.thumbnail, false);
            mImageLoader.displayImage(data.food_item.image, imageAware);
        }

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = Functions.createOrderDialog(mContext, data);
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFragment.getValues().size();
    }

}