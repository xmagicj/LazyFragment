package com.xmagicj.android.lazyfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 * Created by Mumu
 * on 2015/11/20.
 */
public class PlaceHolderFragment extends BaseFragment {
    ProgressBar progressBar;
    TextView textView;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceHolderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceHolderFragment newInstance(int sectionNumber) {
        PlaceHolderFragment fragment = new PlaceHolderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        textView = (TextView) rootView.findViewById(R.id.section_label);
        return rootView;
    }

    @Override
    protected void initData() {
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void setDefaultFragmentTitle(String title) {

    }
}
