package com.example.fm.cpec;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Usama Cheema on 12/8/2017.
 */

public class Comertialsell extends Fragment implements View.OnClickListener {
    ArrayList<String> locations=new ArrayList<>();
    ArrayList<String> area=new ArrayList<>();
    Spinner locationspiner,areaspiner;
    EditText sqryard,name,phone,aditionalinfo,titlenew,pricetext,neartext,phasetext;
    ImageView arrowback;
    Button submit;
String textmainarea;
    ImageView imgindus,imgresi,imgcomer,imgopenland;
DtabaeHelper mydb;
    public static final String TITLE = "Settings";

    public static Comertialsell newInstance() {

        return new Comertialsell();
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.commertial_sell, container, false);
        sqryard=(EditText)view.findViewById(R.id.titletext);
        name=(EditText)view.findViewById(R.id.commertialname);
        phone=(EditText)view.findViewById(R.id.commertialphone);
        neartext=(EditText)view.findViewById(R.id.neartext);
        phasetext=(EditText)view.findViewById(R.id.phasetext);
        pricetext=(EditText)view.findViewById(R.id.ppricetext);
        aditionalinfo=(EditText)view.findViewById(R.id.commertialadditional);
        arrowback=(ImageView)view.findViewById(R.id.carrowback);
        titlenew=(EditText)view.findViewById(R.id.newtitle);
        submit=(Button)view.findViewById(R.id.commertialsubmit);
        mydb=new DtabaeHelper(getActivity());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 if (name.getText().toString().equals("")||sqryard.getText().toString().equals("")||neartext.getText().toString().equals("")||phasetext.getText().toString().equals("")||pricetext.getText().toString().equals("")||phone.getText().toString().equals("")||aditionalinfo.getText().toString().equals("")||titlenew.getText().toString().equals("")||areaspiner.getSelectedItem().toString().equals("Select Location")||areaspiner.getSelectedItem().toString().equals(""))
 {
     Toast.makeText(getActivity(), "Please Select or fill up all required fields.", Toast.LENGTH_SHORT).show();
 }
                else {
     SignUpByServer();
 }
            }
        });

        imgindus=(ImageView)view.findViewById(R.id.indusbtn);
        imgresi=(ImageView)view.findViewById(R.id.redbtn);
        imgcomer=(ImageView)view.findViewById(R.id.comertialbtn);
        imgopenland=(ImageView)view.findViewById(R.id.openlandbtn);
        arrowback.setOnClickListener(this);
        imgindus.setOnClickListener(this);
        imgresi.setOnClickListener(this);
        imgcomer.setOnClickListener(this);
        imgopenland.setOnClickListener(this);
        locationspiner=(Spinner)view.findViewById(R.id.commertiallocation);
        areaspiner=(Spinner)view.findViewById(R.id.commertialarea) ;
        area.add("Location");
        area.add("Normal");
        area.add("Main");
        area.add("Other");
        locations.add("Select Location");
        locations.add("Gawadar Industrial Estate");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, locations);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        areaspiner.setAdapter(dataAdapter);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, area);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        locationspiner.setAdapter(dataAdapter1);
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return view;
    }


    private void SignUpByServer() {


        String namee = name.getText().toString();
        String phonee = phone.getText().toString();
        String locationn=locationspiner.getSelectedItem().toString();
        String areaa=areaspiner.getSelectedItem().toString();
        String aditionalinformation=aditionalinfo.getText().toString();
        String sqryardd=sqryard.getText().toString();
        String pricet=pricetext.getText().toString();
        String neart=neartext.getText().toString();
        String phaset=phasetext.getText().toString();
        String email=null;
        Cursor c=mydb.checkitems();

        if (c.getCount()==0)
        {

        }
        else
        {
            while (c.moveToNext()) {
                email = c.getString(1).toString();
            }
        }

        SellPropertyService service = ApiClient.getClient().create( SellPropertyService.class);

        Call<MSG> userCall =service.insertData(namee,phonee,areaa,textmainarea,sqryardd,pricet,neart,phaset,aditionalinformation,titlenew.getText().toString(),email);

        userCall.enqueue(new Callback<MSG>() {
            @Override
            public void onResponse(Call<MSG> call, Response<MSG> response) {
//                hidepDialog();
                //onSignupSuccess();
                try {
                    Log.d("onResponse", "" + response.body().getMessage());


                    if(response.body().getSuccess() == 1) {
    //                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Property added", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MSG> call, Throwable t) {
                try {
                    Toast.makeText(getActivity(), "You don't have internet connection", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.indusbtn)
        {
            locations.clear();
            locations.add("Select Location");
            locations.add("Gawadar Industrial Estate");
            textmainarea="Industrial";
            imgindus.setImageResource(R.drawable.indutrialicon);
            imgopenland.setImageResource(R.drawable.unselectedopenland);
            imgcomer.setImageResource(R.drawable.unselectedcommertial);
            imgresi.setImageResource(R.drawable.unselectedresidential);
        }
        else if (v.getId()== R.id.openlandbtn)
        {
            locations.clear();
            locations.add("Select Location");
            locations.add("Industrial/Warehouse Land");
            locations.add("Commercial Land");
            locations.add("Residential Land");
            locations.add("Oil City");
            imgindus.setImageResource(R.drawable.unselectedindustrial);
            imgopenland.setImageResource(R.drawable.openlandicon);
            imgcomer.setImageResource(R.drawable.unselectedcommertial);
            imgresi.setImageResource(R.drawable.unselectedresidential);
            textmainarea="Open Land";
        }

        else if (v.getId()== R.id.redbtn)
        { locations.clear();
            locations.add("Select Location");
            locations.add("New Town");
            locations.add("Sanghar");
            locations.add("Maanbar");
            locations.add("BECHS");
            locations.add("BATAIL");
            imgindus.setImageResource(R.drawable.unselectedindustrial);
            imgopenland.setImageResource(R.drawable.unselectedopenland);
            imgcomer.setImageResource(R.drawable.unselectedcommertial);
            imgresi.setImageResource(R.drawable.resedentialicon);
textmainarea="Residential";
        }
        else if (v.getId()== R.id.comertialbtn)
        {
            locations.clear();
            locations.add("Select Location");
            locations.add("New Town");
            locations.add("Sanghar");
            locations.add("Maanbar");
            locations.add("Gawadar Industrial Estate");
            locations.add("BECHS");
            imgindus.setImageResource(R.drawable.unselectedindustrial);
            imgopenland.setImageResource(R.drawable.unselectedopenland);
            imgcomer.setImageResource(R.drawable.commertialicon);
            imgresi.setImageResource(R.drawable.unselectedresidential);
textmainarea="Commercial";
        }
        else if (v.getId()== R.id.carrowback)
        {

            MainActivity.checkback=0;
            Pager adapter;
            adapter = new Pager(getActivity().getSupportFragmentManager(), 3,1);
            MainActivity.mViewPager.setAdapter(adapter);
            MainActivity.mViewPager.setCurrentItem(2);

        }

    }

}