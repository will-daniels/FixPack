package com.example.fixpack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        PagerFragment pagerFragment = new PagerFragment();
        Bundle bundle = new Bundle();
        position = position+1; // Start page count at 1
        bundle.putString("message", "Page "+position);
        pagerFragment.setArguments(bundle);

        return pagerFragment;
    }

    @Override
    public int getCount() {
        return 100;
    }
}
