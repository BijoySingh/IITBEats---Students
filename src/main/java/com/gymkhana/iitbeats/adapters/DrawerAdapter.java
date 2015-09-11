package com.gymkhana.iitbeats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.items.DrawerItem;

import java.util.List;

/**
 * Created by BijoySingh on 9/11/2015.
 */
public class DrawerAdapter extends ArrayAdapter<DrawerItem> {
    private final Context mContext;
    private final List<DrawerItem> mValues;

    public DrawerAdapter(Context context, List<DrawerItem> values) {
        super(context, R.layout.drawer_item, values);
        this.mContext = context;
        this.mValues = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView;
        rowView = layoutInflater.inflate(R.layout.drawer_item, parent, false);

        TextView title = (TextView) rowView.findViewById(R.id.title);
        ImageView logo = (ImageView) rowView.findViewById(R.id.logo);

        title.setText(mValues.get(position).title);
        logo.setImageResource(mValues.get(position).logo);

        return rowView;
    }
}
