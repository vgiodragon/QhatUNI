package com.smartcity.qhatuni;


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

/**
 * Created by root on 15/04/16.
 */
public class CronogramaFragment extends NewFragment{
    ListView listaStand;
    ArrayAdapter adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stand_viewpager, container, false);
        ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        Log.i("mensaje view","* "+viewPager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager()));

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.appbartabs);
        /*LinearLayout customTab = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab,null);
        ((TextView)customTab.findViewById(R.id.texto_fecha_actividad)).setText("16");
        ((TextView)customTab.findViewById(R.id.texto_dia_actividad)).setText("lunes");*/

        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.getTabAt(0).setCustomView(customTab);
        /*TODO implementar un custom tab para una mejor muestra del dia y fecha
            http://www.androidhive.info/2015/09/android-material-design-working-with-tabs
        */

        /*listaStand = (ListView) v.findViewById(R.id.lista_stands);
        adaptador = new CronogramaArrayAdapter(v.getContext(), DataEvento.EVENTOS, this);
        listaStand.setAdapter(adaptador);

        listaStand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final BuildingStand item = (BuildingStand)adaptador.getItem(position);
                Bundle arguments = new Bundle();
                //arguments.putString("layout", item.stand);
                android.support.v4.app.Fragment fragment = new DetailStand();
                fragment.setArguments(arguments);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                        .replace(R.id.principal, fragment).addToBackStack(null).commit();
            }
        });*/
        return v;
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 5;
        private String tabTitles[] = new String[]{"Lunes\n16","Martes\n17", "Miercoles\n18", "Jueves\n19", "Viernes\n20"};

        public MyFragmentPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            f = new ListaActividades();
            Bundle arg = new Bundle();
            switch (position){
                case 0:
                    arg.putString("dia","lunes");
                    break;
                case 1:
                    arg.putString("dia","martes");
                    break;
                case 2:
                    arg.putString("dia","miercoles");
                    break;
                case 3:
                    arg.putString("dia","jueves");
                    break;
                case 4:
                    arg.putString("dia","viernes");
                    break;
                default:
            }
            f.setArguments(arg);
            return f;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
