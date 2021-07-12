


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

public class SoldHomeRecyclerViewAdapter extends RecyclerView.Adapter<SoldHomeRecyclerViewAdapter.MyViewHolder> {

    public int numrows;
    String id=null;
    String b=null;
    Bundle savedInstanceState;
    ArrayList<MainViewResponse> mainlist;
    Context context;
    GoogleMap mmap;

    public SoldHomeRecyclerViewAdapter(int numrows, Context context, ArrayList<MainViewResponse> mainlist) {
        this.numrows = numrows;
        this.context = context;
        this.mainlist = mainlist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,location;
        public Button btnview,btncontact,areaname, price,favbtn;

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
            /*btnview=(Button) view.findViewById(R.id.viewdetails);
            btncontact=(Button) view.findViewById(R.id.contact);
//            map = (MapView) view.findViewById(R.id.sffmap);
//            phone = (Button) view.findViewById(R.id.phonemain);
//            message = (Button) view.findViewById(R.id.messagemain);
            favbtn= (Button) view.findViewById(R.id.fav);
//            map.onCreate(savedInstanceState);*/


        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.soldactivity, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

//                hidepDialog();
        //onSignupSuccess();

        holder.title.setText(String.valueOf(mainlist.get(position).getTitle()));
        holder.areaname.setText(mainlist.get(position).getSqrYard());
        holder.location.setText(mainlist.get(position).getAreaname());
        holder.price.setText(String.valueOf(mainlist.get(position).getPrice()));


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

                    try {
                        Log.d("onFailure", t.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return mainlist.size();
    }
}