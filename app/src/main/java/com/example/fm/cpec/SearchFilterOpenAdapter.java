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
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFilterOpenAdapter extends RecyclerView.Adapter<SearchFilterOpenAdapter.MyViewHolder> {

    public int numrows;
    ArrayList<MainViewResponse> mainlist;
    Context context;
    String b=null;

    public SearchFilterOpenAdapter(int numrows, Context context, ArrayList<MainViewResponse> mainlist) {
        this.numrows = numrows;
        this.context = context;
        this.mainlist = mainlist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, areaname, price, area;
        public Button phone, message,favbtn;
        public RelativeLayout onclickmain;

        public MyViewHolder(View view) {
            super(view);
            onclickmain=(RelativeLayout)view.findViewById(R.id.onclickmain);
            title = (TextView) view.findViewById(R.id.titlemain);
            areaname = (TextView) view.findViewById(R.id.regioname);
            price = (TextView) view.findViewById(R.id.pricetext);
            area = (TextView) view.findViewById(R.id.areatext);
            phone = (Button) view.findViewById(R.id.phonemain);
            message = (Button) view.findViewById(R.id.messagemain);
            favbtn= (Button) view.findViewById(R.id.favourite);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homerecyclerview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

//                hidepDialog();
        //onSignupSuccess();
        holder.onclickmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,OpenMain.class);
                i.putExtra("id",String.valueOf(mainlist.get(position).getId()));
                context.startActivity(i);
            }
        });
        holder.title.setText(mainlist.get(position).getSqrYard() + " Sqr Yard Plot Availaible");
        holder.areaname.setText(mainlist.get(position).getAreaname() + " Society");
        holder.price.setText(String.valueOf(mainlist.get(position).getPrice()));
//        holder.area.setText(String.valueOf(mainlist.get(position).getSqrYard()));
        holder.favbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        try {
                            Toast.makeText(context, "You don't have internet connection", Toast.LENGTH_SHORT).show();
                            Log.d("onFailure", t.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setContentView(R.layout.phonedialog);
                Button yes,no;
//                TextView mesagetitle=(TextView)dialog.findViewById(R.id.asking);
//                mesagetitle.setText("Do you Really want to call ?");
                yes=(Button)dialog.findViewById(R.id.callyes);
                no=(Button)dialog.findViewById(R.id.callno);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_CALL);

                        intent.setData(Uri.parse("tel:" +mainlist.get(position).getPhonenumber() ));
                        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        context.startActivity(intent);
                        dialog.dismiss();
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                dialog.show();



            }
        });
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog=new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.setContentView(R.layout.phonedialog);
                Button yes,no;
//                TextView mesagetitle=(TextView)dialog.findViewById(R.id.asking);
//                mesagetitle.setText("Do you Really want to send message ?");
                yes=(Button)dialog.findViewById(R.id.callyes);
                no=(Button)dialog.findViewById(R.id.callno);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(mainlist.get(position).getPhonenumber(), null, "Hi, I am interested to purchase your properyt. ", null, null);
                            Toast.makeText(context, "Message Sent",
                                    Toast.LENGTH_LONG).show();
                        } catch (Exception ex) {
                            Toast.makeText(context,ex.getMessage().toString(),
                                    Toast.LENGTH_LONG).show();
                            ex.printStackTrace();
                        }

                        dialog.dismiss();
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                dialog.show();



            }
        });
//                Toast.makeText(context, mainlist.get(position).getPlot(), Toast.LENGTH_SHORT).show();




    }

    @Override
    public int getItemCount() {
        return mainlist.size();
    }
}