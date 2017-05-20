package com.smartcity.qhatuni.GMapa;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.smartcity.qhatuni.EditorialesBecas.DetailStand;
import com.smartcity.qhatuni.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapaFragment extends Fragment implements OnMapReadyCallback,
        AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private double L;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private MapView mapView;
    private GoogleMap mMap;
    private ArrayList<Polygon> polygons;
    private ArrayList <Marker> markers;
    private Spinner spinner;
    private ArrayList<String> zonas;


    private OnFragmentInteractionListener mListener;

    public MapaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapaFragment newInstance(String param1, String param2) {
        MapaFragment fragment = new MapaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        polygons = new ArrayList<>();
        markers = new ArrayList<>();
        zonas = new ArrayList<>();zonas.add("Zona Libros");zonas.add("Zona Becas");zonas.add("Zona Institucional");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);

        spinner = (Spinner) view.findViewById(R.id.marker_spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,
                zonas);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        mapView = (MapView) view.findViewById(R.id.map);

        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);


        return view;
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }

    public void setZona(){
        double Lan1 =-12.017713;
        double Lon1 =-77.049441;
        double espX = 0.000006;
        double espY = 0.000029;

    }


    public void setStands(){
        setPolygons();
        setLogoStand();

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String titulo=marker.getTitle().toLowerCase();
                Log.d("GIOMAPA",titulo);
                String salta="museo";
                if(titulo.equals("Museo Andrés Del Castillo")){
                    salta="museo";
                }else if (titulo.equals("Fondo de Cultura Económica"))
                    salta="fondodecultura";
                    else
                    salta=titulo;

                Bundle arguments = new Bundle();
                //String name;
                //final BuildingStand item = name;
                arguments.putString("layout", salta);
                android.support.v4.app.Fragment fragment = new DetailStand();
                fragment.setArguments(arguments);
                ((AppCompatActivity)getContext()).getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                        .replace(R.id.principal,fragment).addToBackStack(null).commit();
            }
        });

    }

    public void setLogoStand(){
        double Lan1 =-12.017713;
        double Lon1 =-77.049441;
        double espX = 0.000006;
        double espY = 0.000029;
        int i=0;
        ArrayList<mMarker> mMarkers = new ArrayList<>();
        mMarkers.add(new mMarker(R.drawable.museo,"Museo Andrés Del Castillo",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.meduni,"EDUNI",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.meduni,"EDUNI",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;////UNMSM
        mMarkers.add(new mMarker(R.drawable.meduni,"EDUNI",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; /// PATRIMONIO
        mMarkers.add(new mMarker(R.drawable.mlibun,"LIBUN",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mlibun,"LIBUN",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///6.- UPC
        mMarkers.add(new mMarker(R.drawable.mlibun,"LIBUN",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///7.- PLANETA
        mMarkers.add(new mMarker(R.drawable.marcadia,"ARCADIA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mmacro,"MACRO",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mlumbreras,"LUMBRERAS",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mreverte,"REVERTE",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mmacro,"MACRO",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;///12.-LOS LIBROS MAS PEQUEÑOS DEL MUNDO
        mMarkers.add(new mMarker(R.drawable.mcydma,"CYDMA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;//13.- LIBROS MIR - LIBROS URSS
        mMarkers.add(new mMarker(R.drawable.mfondodecultura,"Fondo de Cultura Económica",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///1
        mMarkers.add(new mMarker(R.drawable.mcydma,"CYDMA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;

        i=0;
        Lan1 =-12.017708;  Lon1 = -77.049207;
        espX = 0.000006;
        espY = 0.000029;
        mMarkers.add(new mMarker(R.drawable.mlibun,"LIBUN",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///22.- Careal
        mMarkers.add(new mMarker(R.drawable.marcadia,"ARCADIA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///21.- U LA MOLINA
        mMarkers.add(new mMarker(R.drawable.mmacro,"MACRO",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; /// 20.- CAYETANO
        mMarkers.add(new mMarker(R.drawable.mpucp,"PUCP",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mreverte,"REVERTE",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;// 19.- PAULINAS
        mMarkers.add(new mMarker(R.drawable.mmacro,"MACRO",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;/// 18.- PAULINAS
        mMarkers.add(new mMarker(R.drawable.mcydma,"CYDMA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; /// 17.- IBERO


        for(int j=0;j<mMarkers.size();j++){
            mMarker marker = mMarkers.get(j);
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(marker.getImagen());
            markers.add(mMap.addMarker(new MarkerOptions().position(marker.getMlLatLng())
                    .title(marker.getTitulo())
                    .icon(icon)));
        }
    }

    public void setLogoBecas(){
        double Lan1 =-12.017713;
        double Lon1 =-77.049441;
        double espX = 0.000006;
        double espY = 0.000029;
        int i=0;
        ArrayList<mMarker> mMarkers = new ArrayList<>();
        mMarkers.add(new mMarker(R.drawable.museo,"Museo Andrés Del Castillo",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.meduni,"EDUNI",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.meduni,"EDUNI",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;////UNMSM
        mMarkers.add(new mMarker(R.drawable.meduni,"EDUNI",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; /// PATRIMONIO
        mMarkers.add(new mMarker(R.drawable.mlibun,"LIBUN",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mlibun,"LIBUN",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///6.- UPC
        mMarkers.add(new mMarker(R.drawable.mlibun,"LIBUN",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///7.- PLANETA
        mMarkers.add(new mMarker(R.drawable.marcadia,"ARCADIA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mmacro,"MACRO",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mlumbreras,"LUMBRERAS",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mreverte,"REVERTE",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mmacro,"MACRO",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;///12.-LOS LIBROS MAS PEQUEÑOS DEL MUNDO
        mMarkers.add(new mMarker(R.drawable.mcydma,"CYDMA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;//13.- LIBROS MIR - LIBROS URSS
        mMarkers.add(new mMarker(R.drawable.mfondodecultura,"Fondo de Cultura Económica",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///1
        mMarkers.add(new mMarker(R.drawable.mcydma,"CYDMA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;

        i=0;
        Lan1 =-12.017708;  Lon1 = -77.049207;
        espX = 0.000006;
        espY = 0.000029;
        mMarkers.add(new mMarker(R.drawable.mlibun,"LIBUN",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///22.- Careal
        mMarkers.add(new mMarker(R.drawable.marcadia,"ARCADIA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; ///21.- U LA MOLINA
        mMarkers.add(new mMarker(R.drawable.mmacro,"MACRO",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; /// 20.- CAYETANO
        mMarkers.add(new mMarker(R.drawable.mpucp,"PUCP",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;
        mMarkers.add(new mMarker(R.drawable.mreverte,"REVERTE",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;// 19.- PAULINAS
        mMarkers.add(new mMarker(R.drawable.mmacro,"MACRO",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++;/// 18.- PAULINAS
        mMarkers.add(new mMarker(R.drawable.mcydma,"CYDMA",new LatLng(Lan1+espX*i, Lon1+espY*i))); i++; /// 17.- IBERO


        for(int j=0;j<mMarkers.size();j++){
            mMarker marker = mMarkers.get(j);
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(marker.getImagen());
            markers.add(mMap.addMarker(new MarkerOptions().position(marker.getMlLatLng())
                    .title(marker.getTitulo())
                    .icon(icon)));
        }
    }

    public void setPolygons(){
        //ArrayList<LatLng> vertices;
        PolygonOptions polygonOptions;
        polygonOptions= new PolygonOptions();
        polygonOptions.add(new LatLng(-12.017708, -77.049451)); polygonOptions.add(new LatLng(-12.017725, -77.049447));
        polygonOptions.add(new LatLng(-12.017602, -77.048763)); polygonOptions.add(new LatLng(-12.017587, -77.048766));
        polygons.add(mMap.addPolygon(polygonOptions));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(markers.size()>0) for (Marker marker : markers) marker.remove();
        if(position==0){
            CameraPosition currentPlace = new CameraPosition.Builder()
                    .target(new LatLng(-12.017708, -77.049207))
                    .bearing(80f).zoom(20).build();

            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(currentPlace));//-12.017711, -77.049428

            setStands();
        }else if(position==1){
            CameraPosition currentPlace = new CameraPosition.Builder()
                    .target(new LatLng(-12.017804, -77.049461))
                    .bearing(80f).zoom(20).build();
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(currentPlace));//-12.017711, -77.049428
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
