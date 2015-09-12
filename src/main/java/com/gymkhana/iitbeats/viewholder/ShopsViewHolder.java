package com.gymkhana.iitbeats.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class ShopsViewHolder extends RecyclerView.ViewHolder {
    TextView title, address, owner, phone;
    ImageView status, call;

    public ShopsViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.title);
        address = (TextView) view.findViewById(R.id.address);
        owner = (TextView) view.findViewById(R.id.owner);
        phone = (TextView) view.findViewById(R.id.phone);
        status = (ImageView) view.findViewById(R.id.status);
        call = (ImageView) view.findViewById(R.id.call);
    }
}
