package com.gymkhana.iitbeats.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.utils.Functions;

/**
 * Created by BijoySingh on 9/12/2015.
 */
public class ShopsViewHolder extends RecyclerView.ViewHolder {
    public TextView title, address;
    public ImageView call;

    public ShopsViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.title);
        address = (TextView) view.findViewById(R.id.address);
        call = (ImageView) view.findViewById(R.id.call);
    }

    public void setCallListener(final Context context, final String phone) {
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.callPhone(context, phone);
            }
        });
    }
}
