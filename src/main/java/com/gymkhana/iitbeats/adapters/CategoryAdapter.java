package com.gymkhana.iitbeats.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;

import com.gymkhana.iitbeats.MainActivity;
import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.fragments.RefreshBasedFragment;
import com.gymkhana.iitbeats.items.CategoryItem;
import com.gymkhana.iitbeats.items.DrawerItem;
import com.gymkhana.iitbeats.utils.Functions;
import com.gymkhana.iitbeats.utils.SessionVariables;
import com.gymkhana.iitbeats.viewholder.CategoryViewHolder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private final ImageLoader mImageLoader;
    private Context mContext;
    private RefreshBasedFragment<CategoryItem> mFragment;

    public CategoryAdapter(Context context,
                           RefreshBasedFragment<CategoryItem> fragment) {
        mContext = context;
        mFragment = fragment;
        mImageLoader = Functions.loadImageLoader(context);
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        CategoryViewHolder vh = new CategoryViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int position) {

        final CategoryItem data = mFragment.getValues().get(position);
        holder.title.setText(data.name);

        if (URLUtil.isValidUrl(data.image)) {
            ImageAware imageAware = new ImageViewAware(holder.thumbnail, false);
            mImageLoader.displayImage(data.image, imageAware);
        }

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionVariables.mCategoryId = data.id;
                ((MainActivity) mContext).displayFragment(DrawerItem.Tags.MENU);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFragment.getValues().size();
    }

}