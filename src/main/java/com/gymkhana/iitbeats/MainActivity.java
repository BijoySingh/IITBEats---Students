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
import android.widget.ListView;

import com.gymkhana.iitbeats.fragments.BillsFragment;
import com.gymkhana.iitbeats.fragments.BlankFragment;
import com.gymkhana.iitbeats.fragments.CategoryFragment;
import com.gymkhana.iitbeats.fragments.DrawerFragment;
import com.gymkhana.iitbeats.fragments.MenuFragment;
import com.gymkhana.iitbeats.fragments.OrdersFragment;
import com.gymkhana.iitbeats.fragments.ShopsFragment;
import com.gymkhana.iitbeats.items.DrawerItem;
import com.gymkhana.iitbeats.utils.Functions;

public class MainActivity extends ActionBarActivity implements DrawerFragment.OnFragmentInteractionListener {

    private Context mContext;
    private DrawerFragment mDrawerFragment;
    private Integer mFragmentPosition;

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

    public void displayFragment(Integer id) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
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
        } else {
            fragment = new BlankFragment();
        }

        fragment.setArguments(bundle);

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void startupFunctions() {
    }

    public void firstTimeSetup() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

