package com.xmagicj.android.lazyfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mumu
 * on 2015/11/20.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    private List<PlaceHolderFragment> fragmentList = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void init(List<InfoEntity> list) {
        fragmentList.clear();
        for (InfoEntity info : list) {
            fragmentList.add(PlaceHolderFragment.newInstance(info));
        }
    }

    public void refreshAllFragment(List<InfoEntity> list) {
        for (InfoEntity info : list) {
            for (PlaceHolderFragment fragment : fragmentList) {
                //最好使用唯一标示来判定是否刷了正确的Fragment 比如id
                String pageTitle = fragment.getTitle();
                if (pageTitle != null && pageTitle.equals(info.getTitle())) {
                    fragment.refreshData(info);
                }
            }
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentList != null && position < fragmentList.size()) {
            return fragmentList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (getItem(position) instanceof BaseFragment) {
            return ((BaseFragment) getItem(position)).getTitle();
        }
        return super.getPageTitle(position);
    }
}