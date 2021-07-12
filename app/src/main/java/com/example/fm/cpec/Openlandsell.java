package com.example.fm.cpec;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Usama Cheema on 12/8/2017.
 */

public class Openlandsell extends Fragment {
    ArrayList<String> locations=new ArrayList<>();
    ArrayList<String> area=new ArrayList<>();
    Spinner locationspiner,areaspiner;
    EditText sqryard,name,phone,aditionalinfo;
    Button submit;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.open_land, container, false);

        sqryard=(EditText)view.findViewById(R.id.titletext);
        name=(EditText)view.findViewById(R.id.openname);
        phone=(EditText)view.findViewById(R.id.openphone);
        aditionalinfo=(EditText)view.findViewById(R.id.openadditional);
        submit=(Button)view.findViewById(R.id.opensubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SignUpByServer();
            }
        });


        locationspiner=(Spinner)view.findViewById(R.id.openlocation);
        areaspiner=(Spinner)view.findViewById(R.id.openarea) ;
        area.add("Location");
        area.add("Coastal Highway front");
        area.add("Link Road front");
        area.add("Khappar");
        area.add("Marine drive");
        area.add("Mozah Dhorghatti");
        area.add("Ankara Janubi");
        area.add("Shabi");
        area.add("Washindoor");
        area.add("Chibkalmati");
        area.add("Nigoor");
        area.add("Kiakallat");
        area.add("Darbella Janubi");
        area.add("Ziarat Machi(Sharqi)");
        area.add("Surbandar");
        locations.add("Select Location");
        locations.add("East Bay");
        locations.add("West Bay");

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
        return view;
    }
   /* private void SignUpByServer() {


        String namee = name.getText().toString();
        String phonee = phone.getText().toString();
        String locationn=locationspiner.getSelectedItem().toString();
        String areaa=areaspiner.getSelectedItem().toString();
        String aditionalinformation=aditionalinfo.getText().toString();
        String sqryardd=sqryard.getText().toString();


        SellPropertyService service = ApiClient.getClient().create( SellPropertyService.class);

        Call<MSG> userCall =service.insertData(namee,phonee,areaa,"Open Lands",sqryardd,aditionalinformation,SellProperty.titletext);

        userCall.enqueue(new Callback<MSG>() {
            @Override
            public void onResponse(Call<MSG> call, Response<MSG> response) {
//                hidepDialog();
                //onSignupSuccess();
                Log.d("onResponse", "" + response.body().getMessage());


                if(response.body().getSuccess() == 1) {
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getActivity(), "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<MSG> call, Throwable t) {
                Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();
                Log.d("onFailure", t.toString());
            }
        });
    }*/
}
