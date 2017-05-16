package com.smartcity.qhatuni.EditorialesBecas;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.qhatuni.NewFragment;
import com.smartcity.qhatuni.R;

/**
 * Created by kevin on 23/04/16.
 */
public class PagerFragment extends NewFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stand_viewpager, container, false);
        ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MiFragmentPagerAdapter(getChildFragmentManager()));

        // CON ESTO CREO LOS BOTONES DE TABS
        // appbartabs se encuentra en content_sesion
        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.appbartabs);
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        // muestra los tabs
        tabLayout.setupWithViewPager(viewPager);
        // mostrando los iconos del fragment
        /*
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_launcher);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_launcher);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_launcher);
        */
        return v;


    }

    private class MiFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[] {  "Editoriales", "Becas y Cultura","Uni"};

        public MiFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            //f=new ListEditoriales();
            //Bundle arg=new Bundle();
            switch(position) {
                case 0:
                    //f=new ListEditoriales("editorial");
                    f=RecyclerEditoriales.newInstance("editorial");
                    //arg.putInt("tipo",R.array.editorial);
                    break;
                case 1:
                    //f=new ListBecas();
                    f=RecyclerEditoriales.newInstance("becas");
                    //arg.putInt("tipo",R.array.becas);
                    break;
                case 2:
                    //f=new ListUni();
                    f=RecyclerEditoriales.newInstance("uni");
                    //arg.putInt("tipo",R.array.uni);
                    break;
            }
            //f.setArguments(arg);
            return f;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }


    }
}
