package com.example.fm.cpec;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SettingsFragment extends Fragment implements View.OnClickListener  {

    public static final String TITLE = "Settings";
    public static final String Logins = "mypref";
    public static final String emails = "nameKey";
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public static SettingsFragment newInstance() {

        return new SettingsFragment();
    }
LinearLayout fav,addd,my,contact,singout,aboutus,newsearch;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_settings, container, false);
        fav=(LinearLayout) v.findViewById(R.id.layoutfav);
        addd=(LinearLayout) v.findViewById(R.id.layoutadproperty);
        my=(LinearLayout) v.findViewById(R.id.layoutMyproperties);
        contact=(LinearLayout) v.findViewById(R.id.layoutcontact);
        singout=(LinearLayout) v.findViewById(R.id.layoutSingedout);
        sharedPref = getActivity().getSharedPreferences(Logins, Context.MODE_PRIVATE);
        aboutus=(LinearLayout) v.findViewById(R.id.layoutabout);
        newsearch=(LinearLayout) v.findViewById(R.id.layoutnewsearch);
        addd.setOnClickListener(this);
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Mypropertyget.class);
                getActivity().startActivity(i);
            }
        });
        singout.setOnClickListener(this);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Favourite.class);
                startActivity(intent);

            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Introduction.class);
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ContactUs.class);
                startActivity(intent);
            }
        });
newsearch.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        MainActivity.mViewPager.setCurrentItem(0);
    }
});
        return v;
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.layoutadproperty) {
            MainActivity.checkback = 1;
            Pager adapter;
            adapter = new Pager(getActivity().getSupportFragmentManager(), 3, 3);
            MainActivity.mViewPager.setAdapter(adapter);
            MainActivity.mViewPager.setCurrentItem(2);
        }
        else if (v.getId()==R.id.layoutSingedout)
        {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
            builder1.setTitle(R.string.signout);
            builder1.setMessage(R.string.areusure);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    R.string.yes,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            editor= sharedPref.edit();

                            editor.clear();
//                    editor.putString("passwords", password);
                            editor.commit();
                            DtabaeHelper mydb;
                            mydb=new DtabaeHelper(getActivity());
                            mydb.updateitems("1","");
                            Intent i=new Intent(getActivity(),LoginSignup.class);
                            startActivity(i);
                            getActivity().finish();
                        }
                    });

            builder1.setNegativeButton(
                    R.string.no,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();

        }
    }




}


