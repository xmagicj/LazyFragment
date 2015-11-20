package com.xmagicj.android.lazyfragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 * Created by Mumu
 * on 2015/11/20.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceHolderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 6 total pages.
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getResources().getString(R.string.laoyao);
            case 1:
                return mContext.getResources().getString(R.string.laowang);
            case 2:
                return mContext.getResources().getString(R.string.laoliu);
            case 3:
                return mContext.getResources().getString(R.string.laochen);
            case 4:
                return mContext.getResources().getString(R.string.laoguo);
            case 5:
                return mContext.getResources().getString(R.string.laorao);
        }
        return null;
    }
}