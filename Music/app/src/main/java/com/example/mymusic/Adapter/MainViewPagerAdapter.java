package com.example.mymusic.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayFragent = new ArrayList<>();
    private ArrayList<String> arraytitle = new ArrayList<>();
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayFragent.get(position);
    }

    @Override
    public int getCount() {
        return arrayFragent.size();
    }

    public void addFragment(Fragment fragment, String title ){
        arrayFragent.add(fragment);
        arraytitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arraytitle.get(position);
    }
}
