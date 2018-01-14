package com.spectraapps.tohfa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.spectraapps.tohfa.bottomtabscreens.cart.Cart;
import com.spectraapps.tohfa.bottomtabscreens.home.Home;
import com.spectraapps.tohfa.bottomtabscreens.notification.Notification;
import com.spectraapps.tohfa.bottomtabscreens.profile.Profile;

/**
 * Created by MahmoudAyman on 11/01/2018.
 */

public class AdapterMainViewPager extends FragmentPagerAdapter{


    AdapterMainViewPager(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 3:
                return new Home();
            case 2:
                return new Cart();
            case 1:
                return new Notification();
            case 0:
                return new Profile();
            default:
                return null;
        }
    }//end getItem

    @Override
    public int getCount() {
        return 4;
    }

}//end class


