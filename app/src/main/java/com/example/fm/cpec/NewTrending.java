//package com.example.fm.cpec;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//
///**
// * Created by Usama Cheema on 12/18/2017.
// */
//
//public class NewTrending extends Fragment implements View.OnClickListener {
//
//    public static final String TITLE = "Search";
//
//    public static NewTrending newInstance() {
//
//        return new NewTrending();
//    }
//    ImageView resi,commer,indus,openland;
//    Button forsale;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        final View search_fragment =  inflater.inflate(R.layout.newtrendmainlayout, container, false);
//
//        resi=(ImageView)search_fragment.findViewById(R.id.residentialsearchfragment);
//        commer=(ImageView)search_fragment.findViewById(R.id.commertialsearchfragment);
//        indus=(ImageView)search_fragment.findViewById(R.id.industrialsearchfragmenr);
//        openland=(ImageView)search_fragment.findViewById(R.id.openlandsearchfragment);
//        forsale=(Button)search_fragment.findViewById(R.id.trednforsale);
//        resi.setOnClickListener(this);
//        commer.setOnClickListener(this);
//        openland.setOnClickListener(this);
//        indus.setOnClickListener(this);
//        forsale.setOnClickListener(this);
//        return search_fragment;
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId()== R.id.residentialsearchfragment)
//        {
//            Intent i=new Intent(getActivity(),MainXml.class);
//            i.putExtra("regioname","Residential");
//            getActivity().startActivity(i);
//        }
//        else if (v.getId()== R.id.commertialsearchfragment)
//        {
//            Intent i=new Intent(getActivity(),MainXml.class);
//            i.putExtra("regioname","Commertial");
//            getActivity().startActivity(i);
//        }
//        else if (v.getId()== R.id.industrialsearchfragmenr)
//        {
//            Intent i=new Intent(getActivity(),MainXml.class);
//            i.putExtra("regioname","Industrial");
//            getActivity().startActivity(i);
//        }
//        else if (v.getId()== R.id.openlandsearchfragment)
//        {
//            Intent i=new Intent(getActivity(),MainXml.class);
//            i.putExtra("regioname","Open Land");
//            getActivity().startActivity(i);
//        }
//        else if(v.getId()==R.id.trednforsale)
//        {
//            Pager adapter;
//            adapter = new Pager(getActivity().getSupportFragmentManager(), 3,1);
//            MainActivity.mViewPager.setAdapter(adapter);
//            MainActivity.mViewPager.setCurrentItem(0);
//        }
//    }
//}