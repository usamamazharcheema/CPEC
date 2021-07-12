package com.example.fm.cpec;

/**
 * Created by Usama Cheema on 12/12/2017.
 */

import android.Manifest;
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
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder> {

    public int numrows;
    String id=null;
    String b=null;
    Bundle savedInstanceState;
    ArrayList<MainViewResponse> mainlist;
    Context context;
    GoogleMap mmap;

    public HomeRecyclerViewAdapter(int numrows, Context context, ArrayList<MainViewResponse> mainlist) {
        this.numrows = numrows;
        this.context = context;
        this.mainlist = mainlist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,location;
        public Button btnview,areaname, price,favbtn;
        public ImageView btncontact;

        public RelativeLayout onclickmain;
//        MapView map;

        public MyViewHolder(View view) {
            super(view);
//            onclickmain=(RelativeLayout)view.findViewById(R.id.onclickmain);
            title = (TextView) view.findViewById(R.id.discription);
            areaname = (Button) view.findViewById(R.id.area);
            price = (Button) view.findViewById(R.id.price);
//            area = (TextView) view.findViewById(R.id.areatext);
            location=(TextView) view.findViewById(R.id.title);
            btnview=(Button) view.findViewById(R.id.viewdetails);
            btncontact=(ImageView) view.findViewById(R.id.contact);
//            map = (MapView) view.findViewById(R.id.sffmap);
//            phone = (Button) view.findViewById(R.id.phonemain);
//            message = (Button) view.findViewById(R.id.messagemain);
            favbtn= (Button) view.findViewById(R.id.fav);
//            map.onCreate(savedInstanceState);


        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newhomefilter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

//                hidepDialog();
        //onSignupSuccess();
        holder.btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,OpenMain.class);
                i.putExtra("id",String.valueOf(mainlist.get(position).getId()));
                context.startActivity(i);
            }
        });
        holder.title.setText(String.valueOf(mainlist.get(position).getTitle()));
        holder.areaname.setText(mainlist.get(position).getSqrYard());
        holder.location.setText(mainlist.get(position).getAreaname());
        holder.price.setText(String.valueOf(mainlist.get(position).getPrice()));
//        holder.area.setText(String.valueOf(mainlist.get(position).getSqrYard()));
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
        holder.favbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=mainlist.get(position).getId();
                DtabaeHelper mydb;
                mydb=new DtabaeHelper(context);
                Cursor a= mydb.checkitems();
                if( a != null && a.moveToFirst() ){
                    b= a.getString(1);
                    a.close();
                }
                NumberOfRowsMain service = ApiClient.getClient().create(NumberOfRowsMain.class);
                Call<MSG> userCall = service.insertfav(b,Integer.parseInt(mainlist.get(position).getId()));

                userCall.enqueue(new Callback<MSG>() {
                    @Override
                    public void onResponse(Call<MSG> call, Response<MSG> response) {
//                hidepDialog();
                        //onSignupSuccess();
                        Log.d("onResponse", "" + response.body().getMessage());
                        if(response.body().getSuccess() == 0) {
                            Toast.makeText(context, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            holder.favbtn.setBackgroundResource(R.drawable.star);
                        }
                        else if(response.body().getSuccess() == 2) {
                            Toast.makeText(context, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            holder.favbtn.setBackgroundResource(R.drawable.favoritebtn);
                        }
                        else {
                            Toast.makeText(context, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<MSG> call, Throwable t) {
                        Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
                        Log.d("onFailure", t.toString());
                    }
                });
            }
        });
        holder.btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ContactUs.class);
                context.startActivity(intent);
//                final Dialog dialog=new Dialog(context);
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//                dialog.setContentView(R.layout.phonedialog);
//                Button yes,no;
////                TextView mesagetitle=(TextView)dialog.findViewById(R.id.asking);
////                mesagetitle.setText("Do you Really want to call ?");
//                yes=(Button)dialog.findViewById(R.id.callyes);
//                no=(Button)dialog.findViewById(R.id.callno);
//                yes.setOnClickListener(new View.OnClickListener() {
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
//                no.setOnClickListener(new View.OnClickListener() {
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
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
            }
        });
//        holder.message.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
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
    private void SignUpByServer() {
        if (id != null) {

            SignupService service = ApiClient.getClient().create(SignupService.class);

            Call<MSG> userCall = service.insertFavData(id);

            userCall.enqueue(new Callback<MSG>() {
                @Override
                public void onResponse(Call<MSG> call, Response<MSG> response) {
//                hidepDialog();
                    //onSignupSuccess();
                    Log.d("onResponse", "" + response.body().getMessage());


                    if (response.body().getSuccess() == 0) {
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {

                    }
                }

                @Override
                public void onFailure(Call<MSG> call, Throwable t) {

                    Log.d("onFailure", t.toString());
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return mainlist.size();
    }
}