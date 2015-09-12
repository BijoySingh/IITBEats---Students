package com.gymkhana.iitbeats.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public ImageView thumbnail;
    public TextView title;

    public CategoryViewHolder(View view) {
        super(view);
        thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        title = (TextView) view.findViewById(R.id.title);
    }
}
