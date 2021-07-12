package com.example.fm.cpec;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by kamraan on 12/8/2017.
 */


public class SearchFragment  extends Fragment implements View.OnClickListener {

    public static final String TITLE = "Search";

    public static SearchFragment newInstance() {

        return new SearchFragment();
    }
    GoogleMap map;
    private GoogleMap googleMap;
    private MapView mapView;
    ImageView searchfilter,resi,isbcity,lhrcity,kchcity,pshcity,hydcity,bhlcity,faicity;
    Button tredning;
    private boolean mapsSupported = true;
    Bundle saveedInstanceState;
    private SupportMapFragment mapFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View search_fragment =  inflater.inflate(R.layout.fragment_search, container, false);
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    LatLng latLng = new LatLng(25.126389, 62.322498);
                    googleMap.addMarker(new MarkerOptions().position(latLng)
                            .title("Gawadar"));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(25.126389, 62.322498), 12.0f));

                    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            });
        }

        // R.id.map is a FrameLayout, not a Fragment
        getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
        resi=(ImageView)search_fragment.findViewById(R.id.gwdsearchfragment);

        isbcity=(ImageView)search_fragment.findViewById(R.id.isbsearchfragment);
        lhrcity=(ImageView)search_fragment.findViewById(R.id.lhrsearchfragment);
        kchcity=(ImageView)search_fragment.findViewById(R.id.kchsearchfragment);
        pshcity=(ImageView)search_fragment.findViewById(R.id.pessearchfragment);
        hydcity=(ImageView)search_fragment.findViewById(R.id.hydsearchfragment);
        bhlcity=(ImageView)search_fragment.findViewById(R.id.bhlsearchfragment);
        faicity=(ImageView)search_fragment.findViewById(R.id.faisearchfragment);
//tredning.setOnClickListener(this);
        resi.setOnClickListener(this);
//        commer.setOnClickListener(this);
//        openland.setOnClickListener(this);
        isbcity.setOnClickListener(this);
        lhrcity.setOnClickListener(this);
        kchcity.setOnClickListener(this);
        pshcity.setOnClickListener(this);
        hydcity.setOnClickListener(this);
        bhlcity.setOnClickListener(this);
//        indus.setOnClickListener(this);
        faicity.setOnClickListener(this);

        return search_fragment;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.gwdsearchfragment)
        {
            Intent i=new Intent(getActivity(),Gawadarcat.class);
            getActivity().startActivity(i);
        }
//        else if (v.getId()== R.id.commertialsearchfragment)
//        {
//            Intent i=new Intent(getActivity(),ComrSub.class);
//            getContext().startActivity(i);
//        }
//        else if (v.getId()== R.id.industrialsearchfragmenr)
//        {
//            Intent i=new Intent(getActivity(),SearchFiltermain.class);
//            i.putExtra("regioname","Industrial");
//            getActivity().startActivity(i);
//        }
//        else if (v.getId()== R.id.openlandsearchfragment)
//        {
//            Intent i=new Intent(getActivity(),OpenSub.class);
//            getActivity().startActivity(i);
//        }
        else if (v.getId()== R.id.isbsearchfragment)
        {
            Intent i=new Intent(getActivity(),CityCatogory.class);
            i.putExtra("regioname","Islamabad");
            getActivity().startActivity(i);
        }
        else if (v.getId()== R.id.lhrsearchfragment)
        {
            Intent i=new Intent(getActivity(),CityCatogory.class);
            i.putExtra("regioname","Lahore");
            getActivity().startActivity(i);
        }
        else if (v.getId()== R.id.bhlsearchfragment)
        {
            Intent i=new Intent(getActivity(),CityCatogory.class);
            i.putExtra("regioname","Bahawalpur");
            getActivity().startActivity(i);
        }
        else if (v.getId()== R.id.hydsearchfragment)
        {
            Intent i=new Intent(getActivity(),CityCatogory.class);
            i.putExtra("regioname","Hyderabad");
            getActivity().startActivity(i);
        }
        else if (v.getId()== R.id.pessearchfragment)
        {
            Intent i=new Intent(getActivity(),CityCatogory.class);
            i.putExtra("regioname","Peshawar");
            getActivity().startActivity(i);
        }
        else if (v.getId()== R.id.kchsearchfragment)
        {
            Intent i=new Intent(getActivity(),CityCatogory.class);
            i.putExtra("regioname","Karachi");
            getActivity().startActivity(i);
        }
        else if (v.getId()== R.id.faisearchfragment)
        {
            Intent i=new Intent(getActivity(),CityCatogory.class);
            i.putExtra("regioname","Faisalabad");
            getActivity().startActivity(i);
        }
//        else if(v.getId()==R.id.fragmentfortrend)
//        {
//            Pager adapter;
//            adapter = new Pager(getActivity().getSupportFragmentManager(), 3,4);
//            MainActivity.mViewPager.setAdapter(adapter);
//            MainActivity.mViewPager.setCurrentItem(0);
//        }
    }



}