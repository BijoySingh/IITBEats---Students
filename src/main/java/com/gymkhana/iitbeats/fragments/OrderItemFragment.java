package com.gymkhana.iitbeats.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.items.MenuItem;
import com.gymkhana.iitbeats.viewholder.OrderItemViewHolder;

/**
 * Created by BijoySingh on 9/13/2015.
 */
public class OrderItemFragment extends Fragment {

    public static final String MENU_ITEM = "MENU_ITEM_KEY";
    OrderItemViewHolder mHolder;
    MenuItem mMenuItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.order_layout, container, false);

        Bundle arguments = getArguments();
        mMenuItem = (MenuItem) arguments.getSerializable(MENU_ITEM);

        mHolder = new OrderItemViewHolder(rootView);
        mHolder.setupView(mMenuItem);

        return rootView;
    }
}

