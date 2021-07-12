package com.example.fm.cpec;

/**
 * Created by Usama Cheema on 12/12/2017.
 */
import android.*;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavouiteAdapter extends RecyclerView.Adapter<FavouiteAdapter.MovieViewHolder> {

    private ArrayList<MainViewResponse> movies;
    private int rowLayout;
    private Context context;
    String id=null;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public TextView title, areaname,locationt;
        public Button  btnview,price, area,favbtn;
        public ImageView btncontact;

//        MapView map;
//        public RelativeLayout onclickmain;

        public MovieViewHolder(View v) {
            super(v);
//            onclickmain=(RelativeLayout)v.findViewById(R.id.onclickmain);
//            title = (TextView) v.findViewById(R.id.titlemain);
            areaname = (TextView) v.findViewById(R.id.sstitle);
            price = (Button) v.findViewById(R.id.ssprice);
            area = (Button) v.findViewById(R.id.ssarea);
            btnview=(Button) v.findViewById(R.id.ssviewdetails);
            btncontact=(ImageView) v.findViewById(R.id.sfcontact);
            favbtn= (Button) v.findViewById(R.id.ssfav);
//            map = (MapView) v.findViewById(R.id.sffmap);
            locationt=(TextView)v.findViewById(R.id.sdiscription);
////            initMap();
//            {
//                map.onCreate(null);
//                map.onResume();
//
//            }
        }
    }

    public FavouiteAdapter(List<MainViewResponse> movies, int rowLayout, Context context) {
        this.movies = (ArrayList<MainViewResponse>) movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public FavouiteAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,OpenMain.class);
                i.putExtra("id",String.valueOf(movies.get(position).getId()));
                context.startActivity(i);
            }
        });
        holder.locationt.setText(movies.get(position).getTitle());
        holder.areaname.setText(movies.get(position).getAreaname());
        holder.price.setText(String.valueOf(movies.get(position).getPrice()));
        holder.area.setText(String.valueOf(movies.get(position).getSqrYard()));
        holder.favbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=movies.get(position).getId();
                SignUpByServer();
            }
        });
        holder.btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, ContactUs.class);
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
//                        intent.setData(Uri.parse("tel:" +movies.get(position).getPhonenumber() ));
//                        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
//                            smsManager.sendTextMessage(movies.get(position).getPhonenumber(), null, "Hi, I am interested to purchase your properyt. ", null, null);
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
//                            smsManager.sendTextMessage(movies.get(position).getPhonenumber(), null, "Hi, I am interested to purchase your properyt. ", null, null);
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
                    try {
                        Log.d("onResponse", "" + response.body().getMessage());


                        if (response.body().getSuccess() == 0) {
    //                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
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
        return movies.size();
    }
}