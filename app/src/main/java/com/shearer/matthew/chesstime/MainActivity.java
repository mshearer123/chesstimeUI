package com.shearer.matthew.chesstime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements NavigationListener {

    private DrawerLayout drawer;
    private NavigationDrawerFragment navigationDrawer;
    private ScrimInsetsFrameLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.drawer = (DrawerLayout) findViewById(R.id.layoutNavigationDrawer);
        this.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        this.drawer.setStatusBarBackground(R.color.colorPrimaryDark);


        this.drawerLayout = (ScrimInsetsFrameLayout) findViewById(R.id.navigationDrawerContainer);


        if (savedInstanceState == null) {

            this.navigationDrawer = (NavigationDrawerFragment) NavigationDrawerFragment.instantiate(this, NavigationDrawerFragment.TAG);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.add(R.id.navigationDrawerContainer, this.navigationDrawer, NavigationDrawerFragment.TAG);
            transaction.commit();
        } else {
            navigationDrawer = (NavigationDrawerFragment)
                    getSupportFragmentManager().findFragmentById(R.id.container);
        }

        changePage(HomeFragment.TAG, true, new Bundle());
    }

    @Override
    public void changePage(String fragmentName, boolean fade, Bundle args) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = Fragment.instantiate(this, fragmentName);
        fragment.setArguments(args);
        transaction.setTransition(fade ? FragmentTransaction.TRANSIT_FRAGMENT_FADE : FragmentTransaction.TRANSIT_NONE);
        transaction.replace(R.id.container, fragment, fragmentName);
        transaction.commit();
        closeDrawer();

    }


    public void closeDrawer() {
        if (this.drawer != null) {
            this.drawer.closeDrawer(this.drawerLayout);
        }
    }
}
