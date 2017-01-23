package com.xmagicj.android.lazyfragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    /**
     * viewPager.setOffscreenPageLimit()
     */
    static final int VIEWPAGER_OFF_SCREEN_PAGE_LIMIT = 6;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private List<InfoEntity> infoEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        infoEntities.add(new InfoEntity(getResources().getString(R.string.laoyao), "0"));
        infoEntities.add(new InfoEntity(getResources().getString(R.string.laowang), "1"));
        infoEntities.add(new InfoEntity(getResources().getString(R.string.laoliu), "2"));
        infoEntities.add(new InfoEntity(getResources().getString(R.string.laochen), "3"));
        infoEntities.add(new InfoEntity(getResources().getString(R.string.laoguo), "4"));
        infoEntities.add(new InfoEntity(getResources().getString(R.string.laorao), "5"));
        mSectionsPagerAdapter.init(infoEntities);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // 若设置了该属性 则viewpager会缓存指定数量的Fragment
        // mViewPager.setOffscreenPageLimit(VIEWPAGER_OFF_SCREEN_PAGE_LIMIT);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            // 模拟数据变化, 一般是从Presenter层获取服务器或DB数据返回的对象列表
            infoEntities.clear();
            infoEntities.add(new InfoEntity(getResources().getString(R.string.laoyao),
                    String.valueOf(new Random().nextInt(100))));
            infoEntities.add(new InfoEntity(getResources().getString(R.string.laowang),
                    String.valueOf(new Random().nextInt(100))));
            infoEntities.add(new InfoEntity(getResources().getString(R.string.laoliu),
                    String.valueOf(new Random().nextInt(100))));
            infoEntities.add(new InfoEntity(getResources().getString(R.string.laochen),
                    String.valueOf(new Random().nextInt(100))));
            infoEntities.add(new InfoEntity(getResources().getString(R.string.laoguo),
                    String.valueOf(new Random().nextInt(100))));
            infoEntities.add(new InfoEntity(getResources().getString(R.string.laorao),
                    String.valueOf(new Random().nextInt(100))));
            mSectionsPagerAdapter.refreshAllFragment(infoEntities);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
