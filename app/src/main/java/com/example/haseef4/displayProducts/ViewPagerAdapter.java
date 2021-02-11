package com.example.haseef4.displayProducts;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    ArrayList<String> tabs = new ArrayList<String>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String tabTitles){
        this.fragments.add(fragment);
        this.tabs.add(tabTitles);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override
    public int getCount(){
        return fragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position){
        return tabs.get(position);
    }
}
