package com.smartcity.qhatuni.StandsQhatuni2017;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.qhatuni.Informacion;
import com.smartcity.qhatuni.NewFragment;
import com.smartcity.qhatuni.ProgramaQhatuni.ProgramaFragment;
import com.smartcity.qhatuni.ProgramaQhatuni.ProgramaQhatuniFragment;
import com.smartcity.qhatuni.R;

import java.util.ArrayList;

/**
 * Created by root on 22/05/17.
 */

public class StandsFragment extends NewFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stand_viewpager, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new StandsFragment.MyFragmentPagerAdapter(getChildFragmentManager()));
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.appbartabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGES = 3;
        public String[] tabTitles = new String[]{"Becas", "Instituciones", "Editoriales"};

        public MyFragmentPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ArrayList<Fragment> paginas = new ArrayList<>();
            paginas.add(StandsQhatuniFragment.newInstance(Informacion.ZONA_BECAS));
            paginas.add(StandsQhatuniFragment.newInstance(Informacion.ZONA_INSTITUCIONAL));
            paginas.add(StandsQhatuniFragment.newInstance(Informacion.ZONA_LIBROS));
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
