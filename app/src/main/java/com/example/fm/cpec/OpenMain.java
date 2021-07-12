package com.example.fm.cpec;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Usama Cheema on 12/13/2017.
 */

public class OpenMain extends Activity implements OnMapReadyCallback {
    ArrayList<MainViewResponse> mainlist=new ArrayList<>();
    Button purchase,lease,call;
    TextView title,additional,titleplot;
    GoogleMap mMap;
    ImageView image;
    ScrollView mainscroll;
    public String phonenumber;
    private ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onopenmain_activity);
        mainscroll=(ScrollView)findViewById(R.id.mainscroll);
        mainlist.clear();
        titleplot=(TextView)findViewById(R.id.titleplot);
        bar = (ProgressBar) findViewById(R.id.progressBar);
        image= (ImageView) findViewById(R.id.back);
        additional=(TextView)findViewById(R.id.textView4);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("id");
        recallmethod(Integer.parseInt(message));
        call=(Button)findViewById(R.id.phoneopen);
//        message1=(Button)findViewById(R.id.openmessage);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpenMain.this, ContactUs.class);
                startActivity(intent);
            }
        });
//        message1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(OpenMain.this, ContactUs.class);
//                startActivity(intent);
//            }
//        });
        purchase=(Button)findViewById(R.id.openpurchase);
        lease=(Button)findViewById(R.id.openlease);
        title=(TextView)findViewById(R.id.titleopentext);
        initMap();
    }
    private void initMap() {

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap map) {
        mMap=map;

    }
    public void recallmethod(int j)
    {

        NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<MainResponselist> userCall =service.openmainresponse(j);

        userCall.enqueue(new Callback<MainResponselist>() {
            @Override
            public void onResponse(Call<MainResponselist> call, Response<MainResponselist> response) {
                ArrayList<MainViewResponse> mainview = (ArrayList<MainViewResponse>) response.body().getResults();


                if (mainview!=null) {
                    for (int i = 0; i < mainview.size(); i = i + 1) {
                        mainlist.add(mainview.get(i));
//                        area.setText(String.valueOf(mainlist.get(i).getSqrYard()));


                        purchase.setText(String.valueOf(mainlist.get(i).getPrice()));
                        lease.setText(String.valueOf(mainlist.get(i).getSqrYard()));
                        title.setText(mainlist.get(i).getAreaname().toString());
                        additional.setText(mainlist.get(i).getTitle().toString());
                        titleplot.setText(mainlist.get(i).getPlot().toString());
                        phonenumber=mainlist.get(i).getPhonenumber().toString();
                        LatLng latLng = new LatLng(25.158448, 62.324248);
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                        mMap.addMarker(new MarkerOptions().position(latLng).title(mainlist.get(i).getAreaname())).showInfoWindow();
                        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    }
                    bar.setVisibility(View.GONE);
                    mainscroll.setVisibility(View.VISIBLE);


                }
            }

            @Override
            public void onFailure(Call<MainResponselist> call, Throwable t) {
                try {
                    Toast.makeText(OpenMain.this, "You don't have internet connection", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
