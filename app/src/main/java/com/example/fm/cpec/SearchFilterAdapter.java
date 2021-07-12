package com.example.fm.cpec;

/**
 * Created by Usama Cheema on 12/12/2017.
 */

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.fm.cpec.R.id.map;
import static com.facebook.FacebookSdk.getApplicationContext;

public class SearchFilterAdapter extends RecyclerView.Adapter<SearchFilterAdapter.MyViewHolder>   {

    public int numrows;
    ArrayList<MainViewResponse> mainlist;
    Context context;
    String b=null;
    Bundle savedInstanceState;
    GoogleMap mmap;

    public SearchFilterAdapter(int numrows, Context context, ArrayList<MainViewResponse> mainlist) {
        this.numrows = numrows;
        this.context = context;
        this.mainlist = mainlist;

    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView selling, buying, area, locationt;
//        final Button btnview,btncontact;
//        final ImageView favbtn;
//        MapView map;



//        public RelativeLayout onclickmain;

        public MyViewHolder(View view) {
            super(view);
//            onclickmain=(RelativeLayout)view.findViewById(R.id.onclickmain);
//            title = (TextView) view.findViewById(R.id.titlemain);
//            areaname = (TextView) view.findViewById(R.id.sfplottitle);
            buying = (TextView) view.findViewById(R.id.nsfplotprice);
            area = (TextView) view.findViewById(R.id.nsfplotarea);
            locationt=(TextView)view.findViewById(R.id.nltextt);
            selling=(TextView) view.findViewById(R.id.nsfplotprice2);
//            btnview=(Button) view.findViewById(R.id.sfview);
//            btncontact=(Button) view.findViewById(R.id.sfcontact);
//            favbtn= (ImageView) view.findViewById(R.id.sfimageView3);
//            map = (MapView) view.findViewById(R.id.sffmap);
////            final LatLng latLng = new LatLng(13.05241, 80.25082);
////            mmap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//            map.onCreate(savedInstanceState);

//            initMap();
//            {
//                map.onCreate(null);
//                map.onResume();
//
//            }

        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sfilternew, parent, false);

        return new MyViewHolder(itemView);
    }
   /* @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
    }
    private void initMap() {

        MapFragment mapFragment = (MapFragment) ((Activity)context).getFragmentManager().findFragmentById(R.id.sffmap);
        mapFragment.getMapAsync(this);
    }*/

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

//                hidepDialog();
        //onSignupSuccess();
//        holder.btnview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(context,OpenMain.class);
//                i.putExtra("id",String.valueOf(mainlist.get(position).getId()));
//                context.startActivity(i);
//            }
//        });
        holder.locationt.setText(mainlist.get(position).getTitle());
//        holder.areaname.setText(mainlist.get(position).getAreaname());
        holder.buying.setText(String.valueOf(mainlist.get(position).getPrice()));
        holder.area.setText(String.valueOf(mainlist.get(position).getSqrYard()));
        holder.selling.setText(String.valueOf(mainlist.get(position).getSelling()));
//        holder.map.getMapAsync(new OnMapReadyCallback() {
//
//            @Override
//            public void onMapReady(GoogleMap googleMap) {
//                mmap = googleMap;
//                LatLng latLng = new LatLng(25.158448, 62.324248);
//                mmap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//                mmap.addMarker(new MarkerOptions().position(latLng).title(mainlist.get(position).getTitle())).showInfoWindow();
//                mmap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
//
//            }
//        });

//        holder.btncontact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Dialog dialog=new Dialog(context);
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//                dialog.setContentView(R.layout.phonedialog);
//                Button call,msg;
////                TextView mesagetitle=(TextView)dialog.findViewById(R.id.asking);
////                mesagetitle.setText("Do you Really want to call ?");
//                call=(Button)dialog.findViewById(R.id.callyes);
//                msg=(Button)dialog.findViewById(R.id.callno);
//                call.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(Intent.ACTION_CALL);
//
//                        intent.setData(Uri.parse("tel:" +mainlist.get(position).getPhonenumber() ));
//                        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                            // TODO: Consider calling
//                            //    ActivityCompat#requestPermissions
//                            // here to request the missing permissions, and then overriding
//                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                            //                                          int[] grantResults)
//                            // to handle the case where the user grants the permission. See the documentation
//                            // for ActivityCompat#requestPermissions for more details.
//                            return;
//                        }
//                        context.startActivity(intent);
//                        dialog.dismiss();
//                    }
//                });
//                msg.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        try {
//                            SmsManager smsManager = SmsManager.getDefault();
//                            smsManager.sendTextMessage(mainlist.get(position).getPhonenumber(), null, "Hi, I am interested to purchase your properyt. ", null, null);
//                            Toast.makeText(context, "Message Sent",
//                                    Toast.LENGTH_LONG).show();
//                        } catch (Exception ex) {
//                            Toast.makeText(context,ex.getMessage().toString(),
//                                    Toast.LENGTH_LONG).show();
//                            ex.printStackTrace();
//                        }
//
//                        dialog.dismiss();
//
//                    }
//                });
//
//
//                dialog.show();
//
//
//
//            }
//        });
//        holder.favbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DtabaeHelper mydb;
//                mydb=new DtabaeHelper(context);
//                Cursor a= mydb.checkitems();
//                if( a != null && a.moveToFirst() ){
//                    b= a.getString(1);
//                    a.close();
//                }
//
//                NumberOfRowsMain service = ApiClient.getClient().create(NumberOfRowsMain.class);
//                Call<MSG> userCall = service.insertfav(b,Integer.parseInt(mainlist.get(position).getId()));
//
//                userCall.enqueue(new Callback<MSG>() {
//                    @Override
//                    public void onResponse(Call<MSG> call, Response<MSG> response) {
////                hidepDialog();
//                        //onSignupSuccess();
//                        Log.d("onResponse", "" + response.body().getMessage());
//                        if(response.body().getSuccess() == 0) {
//                            Toast.makeText(context, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                            holder.favbtn.setBackgroundResource(R.drawable.star);
//                        }
//                        else if(response.body().getSuccess() == 2) {
//                            Toast.makeText(context, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
//
//                            holder.favbtn.setBackgroundResource(R.drawable.favoritebtn);
//                        }
//                        else {
//                            Toast.makeText(context, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<MSG> call, Throwable t) {
//                        Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
//                        Log.d("onFailure", t.toString());
//                    }
//                });
//            }
//        });
//        holder.message.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final Dialog dialog=new Dialog(context);
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//                dialog.setContentView(R.layout.phonedialog);
//                Button yes,no;
////                TextView mesagetitle=(TextView)dialog.findViewById(R.id.asking);
////                mesagetitle.setText("Do you Really want to send message ?");
//                yes=(Button)dialog.findViewById(R.id.callyes);
//                no=(Button)dialog.findViewById(R.id.callno);
//                yes.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        try {
//                            SmsManager smsManager = SmsManager.getDefault();
//                            smsManager.sendTextMessage(mainlist.get(position).getPhonenumber(), null, "Hi, I am interested to purchase your properyt. ", null, null);
//                            Toast.makeText(context, "Message Sent",
//                                    Toast.LENGTH_LONG).show();
//                        } catch (Exception ex) {
//                            Toast.makeText(context,ex.getMessage().toString(),
//                                    Toast.LENGTH_LONG).show();
//                            ex.printStackTrace();
//                        }
//
//                        dialog.dismiss();
//                    }
//                });
//                no.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dialog.dismiss();
//                    }
//                });
//
//
//                dialog.show();
//
//
//
//            }
//        });
//                Toast.makeText(context, mainlist.get(position).getPlot(), Toast.LENGTH_SHORT).show();




    }

    @Override
    public int getItemCount() {
        return mainlist.size();
    }

}