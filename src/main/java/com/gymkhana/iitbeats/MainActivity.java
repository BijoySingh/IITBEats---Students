package com.gymkhana.iitbeats;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.gymkhana.iitbeats.fragments.BillsFragment;
import com.gymkhana.iitbeats.fragments.BlankFragment;
import com.gymkhana.iitbeats.fragments.CategoryFragment;
import com.gymkhana.iitbeats.fragments.DrawerFragment;
import com.gymkhana.iitbeats.fragments.MenuFragment;
import com.gymkhana.iitbeats.fragments.OrderItemFragment;
import com.gymkhana.iitbeats.fragments.OrdersFragment;
import com.gymkhana.iitbeats.fragments.SendOrderFragment;
import com.gymkhana.iitbeats.fragments.ShopsFragment;
import com.gymkhana.iitbeats.items.DrawerItem;
import com.gymkhana.iitbeats.utils.Functions;
import com.gymkhana.iitbeats.utils.SessionVariables;

import java.io.Serializable;

public class MainActivity extends ActionBarActivity implements DrawerFragment.OnFragmentInteractionListener {

    private Context mContext;
    private DrawerFragment mDrawerFragment;
    private Integer mFragmentPosition;
    private TextView mOrderBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        startupFunctions();
        firstTimeSetup();

        Functions.setActionBar(this);
        Functions.setActionBarTitle(this, getString(R.string.drawer_menu));

        mDrawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_bar);
        mDrawerFragment.setup((DrawerLayout) findViewById(R.id.drawer_layout));

        ListView lv = mDrawerFragment.setupList();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDrawerFragment.mDrawerLayout.closeDrawers();
                DrawerItem item = (DrawerItem) parent.getItemAtPosition(position);

                if (id == DrawerItem.Tags.LOGOUT) {

                } else if (id == DrawerItem.Tags.LOGIN) {

                }

                displayFragment(item.tag);
            }
        });

        displayFragment(DrawerItem.Tags.CATEGORIES);
    }

    private void switchFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.page_fragment, fragment)
                    .commit();
            mDrawerFragment.mDrawerLayout.closeDrawers();
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    public void displayFragment(Integer id) {
        Fragment fragment = null;
        mFragmentPosition = id;

        if (id == DrawerItem.Tags.MENU) {
            fragment = new MenuFragment();
        } else if (id == DrawerItem.Tags.SHOPS) {
            fragment = new ShopsFragment();
        } else if (id == DrawerItem.Tags.ORDERS) {
            fragment = new OrdersFragment();
        } else if (id == DrawerItem.Tags.BILLS) {
            fragment = new BillsFragment();
        } else if (id == DrawerItem.Tags.CATEGORIES) {
            fragment = new CategoryFragment();
        } else if (id == DrawerItem.Tags.CART) {
            fragment = new SendOrderFragment();
        } else {
            fragment = new BlankFragment();
        }
        switchFragment(fragment);
    }

    public void displayFragment(Integer id, Serializable data) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        mFragmentPosition = id;

        if (id == DrawerItem.Tags.ORDER_ITEM) {
            fragment = new OrderItemFragment();
            bundle.putSerializable(OrderItemFragment.MENU_ITEM, data);
        }

        fragment.setArguments(bundle);
        switchFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        if (mFragmentPosition == DrawerItem.Tags.CATEGORIES) {
            finish();
        } else if (mFragmentPosition == DrawerItem.Tags.ORDER_ITEM) {
            displayFragment(DrawerItem.Tags.MENU);
        } else {
            displayFragment(DrawerItem.Tags.CATEGORIES);
        }
    }

    public void startupFunctions() {
    }

    public void firstTimeSetup() {
    }

    public void updateOrderBadge() {
        mOrderBadge.setText("" + SessionVariables.mSendOrder.items.size());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final Menu actionbar_menu = menu;
        final MenuItem menu_item = menu.findItem(R.id.action_cart);

        menu_item.setActionView(R.layout.actionbar_cart_icon);
        LinearLayout badge = (LinearLayout) menu_item.getActionView();
        mOrderBadge = (TextView) badge.findViewById(R.id.badge);
        badge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(DrawerItem.Tags.CART);
            }
        });
        updateOrderBadge();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (mDrawerFragment.mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerFragment.mDrawerLayout.closeDrawers();
            } else {
                mDrawerFragment.mDrawerLayout.openDrawer(Gravity.LEFT);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

