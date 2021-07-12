//package com.example.fm.cpec;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
//import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
//
//import static com.example.fm.cpec.R.id.comertialimg;
//import static com.example.fm.cpec.R.id.industrialimg;
//import static com.example.fm.cpec.R.id.openlandimg;
//import static com.example.fm.cpec.R.id.resiimg;
//
///**
// * Created by kamraan on 12/8/2017.
// */
//
//public class FilterFragment extends Fragment implements View.OnClickListener {
//
//
//    public static FilterFragment newInstance() {
//
//        return new FilterFragment();
//    }
//    EditText areamin,areamax,pricemin,pricemax;
//
//    ImageView imgindus,imgresi,imgcomer,imgopenland,arrowback,searchclick;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        final View filter_fragment =  inflater.inflate(R.layout.fragment_filter, container, false);
//        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) filter_fragment.findViewById(R.id.rangeSeekbar1);
//        final CrystalRangeSeekbar rangeSeekbar1 = (CrystalRangeSeekbar) filter_fragment.findViewById(R.id.rangeSeekbar2);
//        rangeSeekbar.setMaxValue(10000000);
//
//        rangeSeekbar1.setMaxValue(1000000000);
//searchclick=(ImageView)filter_fragment.findViewById(R.id.searchclickbutton);
//areamin=(EditText)filter_fragment.findViewById(R.id.area_min);
//        areamax=(EditText)filter_fragment.findViewById(R.id.area_max);
//        pricemin=(EditText)filter_fragment.findViewById(R.id.price_min);
//        pricemax=(EditText)filter_fragment.findViewById(R.id.price_max);
//        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
//            @Override
//            public void valueChanged(Number minValue, Number maxValue) {
//                areamin.setText(String.valueOf(minValue));
//                areamin.setGravity(Gravity.CENTER);
//                areamax.setText(String.valueOf(maxValue));
//                areamax.setGravity(Gravity.CENTER);
//            }
//        });
//        arrowback=(ImageView)filter_fragment.findViewById(R.id.arrowback);
//        arrowback.setOnClickListener(this);
//rangeSeekbar1.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
//    @Override
//    public void valueChanged(Number minValue, Number maxValue) {
//        pricemin.setText(String.valueOf(minValue));
//        pricemin.setGravity(Gravity.CENTER);
//        pricemax.setText(String.valueOf(maxValue));
//        pricemax.setGravity(Gravity.CENTER);
//    }
//});
//
//        imgindus=(ImageView)filter_fragment.findViewById(industrialimg);
//        imgresi=(ImageView)filter_fragment.findViewById(R.id.resiimg);
//        imgcomer=(ImageView)filter_fragment.findViewById(R.id.comertialimg);
//        imgopenland=(ImageView)filter_fragment.findViewById(openlandimg);
//        imgindus.setOnClickListener(this);
//        imgresi.setOnClickListener(this);
//        imgcomer.setOnClickListener(this);
//        imgopenland.setOnClickListener(this);
//        searchclick.setOnClickListener(this);
//        return filter_fragment;
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId()== industrialimg)
//        {
//            MainActivity.regionname="Industrial";
//
//            imgindus.setImageResource(R.drawable.indutrialicon);
//            imgopenland.setImageResource(R.drawable.unselectedopenland);
//            imgcomer.setImageResource(R.drawable.unselectedcommertial);
//            imgresi.setImageResource(R.drawable.unselectedresidential);
//        }
//        else if (v.getId()== openlandimg)
//        {
//            MainActivity.regionname="Open Land";
//            imgindus.setImageResource(R.drawable.unselectedindustrial);
//            imgopenland.setImageResource(R.drawable.openlandicon);
//            imgcomer.setImageResource(R.drawable.unselectedcommertial);
//            imgresi.setImageResource(R.drawable.unselectedresidential);
//
//        }
//        else if (v.getId()== R.id.resiimg)
//        {
//            MainActivity.regionname="Residential";
//            imgindus.setImageResource(R.drawable.unselectedindustrial);
//            imgopenland.setImageResource(R.drawable.unselectedopenland);
//            imgcomer.setImageResource(R.drawable.unselectedcommertial);
//            imgresi.setImageResource(R.drawable.resedentialicon);
//
//        }
//        else if (v.getId()== R.id.comertialimg)
//        {
//            MainActivity.regionname="Commertial";
//            imgindus.setImageResource(R.drawable.unselectedindustrial);
//            imgopenland.setImageResource(R.drawable.unselectedopenland);
//            imgcomer.setImageResource(R.drawable.commertialicon);
//            imgresi.setImageResource(R.drawable.unselectedresidential);
//
//        }
//        else if (v.getId()== R.id.arrowback)
//        {
//
//           MainActivity.checkback=0;
//            Pager adapter;
//            adapter = new Pager(getActivity().getSupportFragmentManager(), 3,1);
//            MainActivity.mViewPager.setAdapter(adapter);
//            MainActivity.mViewPager.setCurrentItem(0);
//
//
//        }
//        else if (v.getId()== R.id.searchclickbutton)
//        {
////            if (v.getId()!=industrialimg || v.getId()!=openlandimg || v.getId()!=resiimg || v.getId()!=comertialimg){
////
////            }
//            MainActivity.maxarea=areamax.getText().toString();
//            MainActivity.minarea=areamin.getText().toString();
//            MainActivity.maxprice=pricemax.getText().toString();
//            MainActivity.minprice=pricemin.getText().toString();
//            Intent i=new Intent(getActivity(),SerachFilterOnsearch.class);
//            getActivity().startActivity(i);
//
//
//
//        }
//    }
//}