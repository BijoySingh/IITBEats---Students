package com.gymkhana.iitbeats.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.items.SendOrderSubItem;
import com.gymkhana.iitbeats.utils.SessionVariables;
import com.gymkhana.iitbeats.viewholder.CurrentOrderViewHolder;

/**
 * Created by BijoySingh on 9/13/2015.
 */
public class SendOrderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.order_layout, container, false);
        
        for (SendOrderSubItem item : SessionVariables.mSendOrder.items) {
            CurrentOrderViewHolder holder = new CurrentOrderViewHolder(getContext());
            holder.init().setupView(getContext(), item);
        }

        return rootView;
    }
}

