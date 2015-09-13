package com.gymkhana.iitbeats.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.adapters.DrawerAdapter;
import com.gymkhana.iitbeats.items.DrawerItem;

import java.util.ArrayList;
import java.util.List;

public class DrawerFragment extends Fragment {

    public ListView mListView = null;

    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private List<DrawerItem> mDrawerListView = new ArrayList<DrawerItem>();

    private View mRootView;
    private OnFragmentInteractionListener mListener;
    private Context mContext;

    public DrawerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NavigationFragment.
     */
    public static DrawerFragment newInstance(String param1, String param2) {
        DrawerFragment fragment = new DrawerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mRootView = inflater.inflate(R.layout.drawer_layout, container, false);
        return mRootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setup(DrawerLayout dl) {
        mDrawerLayout = dl;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), dl,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public ListView setupList() {
        mDrawerListView.add(new DrawerItem(DrawerItem.Tags.CATEGORIES, getString(R.string.drawer_menu), R.drawable.ic_chrome_reader_mode_black_36dp));
        mDrawerListView.add(new DrawerItem(DrawerItem.Tags.SHOPS, getString(R.string.drawer_shops), R.drawable.ic_store_black_36dp));
        mDrawerListView.add(new DrawerItem(DrawerItem.Tags.ORDERS, getString(R.string.drawer_orders), R.drawable.ic_dashboard_black_36dp));
        mDrawerListView.add(new DrawerItem(DrawerItem.Tags.BILLS, getString(R.string.drawer_bills), R.drawable.ic_payment_black_36dp));
        mDrawerListView.add(new DrawerItem(DrawerItem.Tags.BILLS, getString(R.string.drawer_settings), R.drawable.ic_settings_black_48dp));
        mDrawerListView.add(new DrawerItem(DrawerItem.Tags.LOGOUT, getString(R.string.drawer_logout), R.drawable.ic_exit_to_app_black_36dp));

        DrawerAdapter adapter = new DrawerAdapter(getActivity(), mDrawerListView);

        mListView = (ListView) mDrawerLayout.findViewById(R.id.drawer_listview);

        if (adapter != null && mListView != null) {
            mListView.setAdapter(adapter);
        } else if (adapter == null) {
        } else if (mListView == null) {
        }
        return mListView;
    }

    public interface OnFragmentInteractionListener {
    }
}
