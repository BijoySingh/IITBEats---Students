package com.gymkhana.iitbeats.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.items.SendOrderSubItem;
import com.gymkhana.iitbeats.utils.Functions;
import com.gymkhana.iitbeats.utils.SessionVariables;
import com.gymkhana.iitbeats.viewholder.CurrentOrderViewHolder;

/**
 * Created by BijoySingh on 9/13/2015.
 */
public class SendOrderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.current_order_layout, container, false);

        LinearLayout order = (LinearLayout) rootView.findViewById(R.id.order);
        for (SendOrderSubItem item : SessionVariables.mSendOrder.items) {
            CurrentOrderViewHolder holder = new CurrentOrderViewHolder(getContext());
            holder.init(getContext()).setupView(getContext(), item);
            order.addView(holder);
        }

        Functions.setActionBarTitle((ActionBarActivity) getActivity(), getString(R.string.drawer_plate));

        return rootView;
    }
}

