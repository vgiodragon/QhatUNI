package com.smartcity.qhatuni.ProgramaQhatuni;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.smartcity.qhatuni.EditorialesBecas.BuildingStand;
import com.smartcity.qhatuni.EditorialesBecas.DetailStand;
import com.smartcity.qhatuni.NewFragment;
import com.smartcity.qhatuni.R;

import java.util.ArrayList;

/**
 * Created by root on 15/04/16.
 */
public class ProgramaFragment extends NewFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stand_viewpager, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager()));
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.appbartabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGES = 4;
        public String[] tabTitles = new String[]{"Martes\n23", "Miercoles\n24", "Jueves\n25", "Viernes\n26"};

        public MyFragmentPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ArrayList<Fragment> paginas = new ArrayList<>();
            paginas.add(ProgramaQhatuniFragment.newInstance("martes"));
            paginas.add(ProgramaQhatuniFragment.newInstance("miercoles"));
            paginas.add(ProgramaQhatuniFragment.newInstance("jueves"));
            paginas.add(ProgramaQhatuniFragment.newInstance("viernes"));
            return paginas.get(position);
        }

        @Override
        public int getCount() {
            return PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
