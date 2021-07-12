//package com.example.fm.cpec;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.github.mikephil.charting.charts.LineChart;
//import com.github.mikephil.charting.components.AxisBase;
//import com.github.mikephil.charting.components.Legend;
//import com.github.mikephil.charting.components.XAxis;
//import com.github.mikephil.charting.components.YAxis;
//import com.github.mikephil.charting.data.Entry;
//import com.github.mikephil.charting.data.LineData;
//import com.github.mikephil.charting.data.LineDataSet;
//import com.github.mikephil.charting.formatter.IAxisValueFormatter;
//import com.github.mikephil.charting.utils.ColorTemplate;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//import static android.content.ContentValues.TAG;
//
//public class NewTab extends Activity  {
//
//    private LineChart mChart;
//    String phase,areaname;
//    TextView areanametext,phasename,titlegraph;
//    Button pricebutton;
//    ProgressBar bar;
//    RelativeLayout rl;
//    LinearLayout li;
//    ArrayList<NumberpriceResponse> mainprice=new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.newtab);
//        Intent intent = getIntent();
//        String[] myStrings = intent.getStringArrayExtra("graph");
//        phase=myStrings[1];
//        areaname=myStrings[0];
////        Toast.makeText(this, phase+" "+areaname+" "+MainXml.maintittile, Toast.LENGTH_SHORT).show();
//        mChart = (LineChart) findViewById(R.id.chart1);
//        getprices(areaname,MainXml.maintittile,1,phase);
//        areanametext=(TextView)findViewById(R.id.areanamegraph);
//        phasename=(TextView)findViewById(R.id.phasegraph);
//        titlegraph=(TextView)findViewById(R.id.titielgraph);
//        phasename.setText(phase);
//        areanametext.setText(areaname);
//        titlegraph.setText(MainXml.maintittile);
//        pricebutton=(Button)findViewById(R.id.purchaseprice);
//        li=(LinearLayout)findViewById(R.id.secondlay);
//        rl=(RelativeLayout)findViewById(R.id.topheader);
//        bar=(ProgressBar)findViewById(R.id.progressBar);
//        // no description text
//        /*mChart.getDescription().setEnabled(false);
//
//        // enable touch gestures
//        mChart.setTouchEnabled(true);
//
//        mChart.setDragDecelerationFrictionCoef(0.9f);
//
//        // enable scaling and dragging
//        mChart.setDragEnabled(true);
//        mChart.setScaleEnabled(true);
//        mChart.setDrawGridBackground(false);
//        mChart.setHighlightPerDragEnabled(true);
//
//        // if disabled, scaling can be done on x- and y-axis separately
//        mChart.setPinchZoom(true);
//
//        // set an alternative background color
//        mChart.setBackgroundColor(Color.BLACK);
//
//        // add data
////        setData(31, 31);
//
//        mChart.animateX(2500);
//
//
//
//        // get the legend (only possible after setting data)
//        Legend l = mChart.getLegend();
//
//        // modify the legend ...
//        l.setForm(Legend.LegendForm.LINE);
//
//        l.setTextSize(11);
//        l.setTextColor(Color.WHITE);
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
//        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
//        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//        l.setDrawInside(false);
//        l.setYOffset(11);
//
////        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(mChart);
//
//        XAxis xAxis = mChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTextSize(11);
//        xAxis.setTextColor(Color.WHITE);
//        xAxis.setDrawGridLines(false);
//        xAxis.setDrawAxisLine(false);
////        xAxis.setValueFormatter(xAxisFormatter);
//
////        IAxisValueFormatter custom = new MyAxisValueFormatter();
//
//        YAxis leftAxis = mChart.getAxisLeft();
//        leftAxis.setTextColor(ColorTemplate.getHoloBlue());
////        leftAxis.setAxisMaximum(200);
////        leftAxis.setAxisMinimum(0);
//        leftAxis.setDrawGridLines(false);
//        leftAxis.setGranularityEnabled(false);*/
////        leftAxis.setValueFormatter(custom);
//        new MyAsyncTask().execute();
//    }
//
//    private void setData(int count, int range) {
//
//        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
//
//        for (int i = 0; i < mainprice.size(); i++) {
//            yVals1.add(new Entry(i,Integer.parseInt(mainprice.get(i).getPrice()) ));
//        }
//
////        ArrayList<Entry> yVals2 = new ArrayList<Entry>();
////
////        for (int i = 0; i < count-1; i++) {
////            float mult = range;
////            float val = (float) (Math.random() * mult) + 450;
////            yVals2.add(new Entry(i, val));
//////            if(i == 10) {
//////                yVals2.add(new Entry(i, val + 50));
//////            }
////        }
//
//        LineDataSet set1, set2;
//
//        if (mChart.getData() != null &&
//                mChart.getData().getDataSetCount() > 0) {
//            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
//            set2 = (LineDataSet) mChart.getData().getDataSetByIndex(1);
//            set1.setValues(yVals1);
//            set1.setDrawFilled(true);
//            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
////            set2.setValues(yVals2);
//            mChart.getData().notifyDataChanged();
//            mChart.notifyDataSetChanged();
//        } else {
//            // create a dataset and give it a type
//            set1 = new LineDataSet(yVals1, "DataSet 1");
//
//            set1.setAxisDependency(YAxis.AxisDependency.LEFT);
//            set1.setColor(ColorTemplate.getHoloBlue());
//            set1.setCircleColor(Color.WHITE);
//            set1.setLineWidth(2);
//            set1.setCircleRadius(3);
//            set1.setFillAlpha(65);
//            set1.setFillColor(ColorTemplate.getHoloBlue());
//            set1.setHighLightColor(Color.rgb(244, 117, 117));
//            set1.setDrawCircleHole(false);
//            //set1.setFillFormatter(new MyFillFormatter(0f));
//            //set1.setDrawHorizontalHighlightIndicator(false);
//            //set1.setVisible(false);
//            //set1.setCircleHoleColor(Color.WHITE);
//
//            // create a dataset and give it a type
////            set2 = new LineDataSet(yVals2, "DataSet 2");
////            set2.setAxisDependency(YAxis.AxisDependency.RIGHT);
////            set2.setColor(Color.RED);
////            set2.setCircleColor(Color.WHITE);
////            set2.setLineWidth(2f);
////            set2.setCircleRadius(3f);
////            set2.setFillAlpha(65);
////            set2.setFillColor(Color.RED);
////            set2.setDrawCircleHole(false);
////            set2.setHighLightColor(Color.rgb(244, 117, 117));
////            //set2.setFillFormatter(new MyFillFormatter(900f));
//
//            // create a data object with the datasets
//            LineData data = new LineData(set1);
//            data.setValueTextColor(Color.WHITE);
//            data.setValueTextSize(9);
//
//            // set data
//            mChart.setData(data);
//        }
//    }
//    public void getprices(final String areaname, String plotname, final int postitipn,String phase)
//    {
////        listDataHeader = new ArrayList<String>();
////        listDataChild = new HashMap<String, List<String>>();
//        NumberOfRowsMain apiService = ApiClient.getClient().create(NumberOfRowsMain.class);
//        Call<Numberpricelist> call = apiService.getpricenumnew(areaname,plotname,phase);
//        call.enqueue(new Callback<Numberpricelist>() {
//            @Override
//            public void onResponse(Call<Numberpricelist> call, Response<Numberpricelist> response) {
//                int statusCode = response.code();
//                ArrayList<NumberpriceResponse> movies1 = (ArrayList<NumberpriceResponse>) response.body().getNumberpriceResponse();
////                Toast.makeText(NewTab.this, "123", Toast.LENGTH_SHORT).show();
//                if (movies1 != null) {
////                    Toast.makeText(NewTab.this, ""+movies1.size(), Toast.LENGTH_SHORT).show();
//                    int b=1;
////					listDataHeader.add(areaname);
//                    for (int i = 0; i < movies1.size(); i = i + 1) {
//
//                        mainprice.add(movies1.get(i));
//
//                        if((movies1.size()-i)==1)
//                        {
//                            pricebutton.setText(String.valueOf(mainprice.get(i).getPrice()));
//                            bar.setVisibility(View.GONE);
//                            li.setVisibility(View.VISIBLE);
//                            rl.setVisibility(View.VISIBLE);
//
////                            Toast.makeText(NewTab.this, "sasa", Toast.LENGTH_SHORT).show();
//                            mChart.getDescription().setEnabled(false);
//
//                            // enable touch gestures
//                            mChart.setTouchEnabled(true);
//
//                            mChart.setDragDecelerationFrictionCoef(0.9f);
//
//                            // enable scaling and dragging
//                            mChart.setDragEnabled(true);
//                            mChart.setScaleEnabled(true);
//                            mChart.setDrawGridBackground(false);
//                            mChart.setHighlightPerDragEnabled(true);
//
//                            // if disabled, scaling can be done on x- and y-axis separately
//                            mChart.setPinchZoom(true);
//
//                            // set an alternative background color
//                            mChart.setBackgroundColor(Color.BLACK);
//
//                            // add data
//                            setData(31, 31);
//
//                            mChart.animateX(2500);
//
//
//
//                            // get the legend (only possible after setting data)
//                            Legend l = mChart.getLegend();
//
//                            // modify the legend ...
//                            l.setForm(Legend.LegendForm.LINE);
//
//                            l.setTextSize(11);
//                            l.setTextColor(Color.WHITE);
//                            l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
//                            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
//                            l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//                            l.setDrawInside(false);
//                            l.setYOffset(11);
//
////        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(mChart);
//
//                            XAxis xAxis = mChart.getXAxis();
//                            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//                            xAxis.setTextSize(11);
//                            xAxis.setTextColor(Color.WHITE);
//                            xAxis.setDrawGridLines(true);
//                            xAxis.setDrawAxisLine(false);
//                            xAxis.setCenterAxisLabels(true);
//                            xAxis.setGranularity(1f);
//                            xAxis.setValueFormatter(new IAxisValueFormatter() {
//                                private SimpleDateFormat mFormat=new SimpleDateFormat("yyyy/MM/dd");
//                                @Override
//                                public String getFormattedValue(float value, AxisBase axis) {
//                                    long millis= TimeUnit.HOURS.toMillis((long) value);
//                                    return mFormat.format(new Date(millis));
//                                }
//                            });
////                            IAxisValueFormatter custom=new MyAxisValueFormatter();
//
////        xAxis.setValueFormatter(xAxisFormatter);
//
////        IAxisValueFormatter custom = new MyAxisValueFormatter();
//
//                            YAxis leftAxis = mChart.getAxisLeft();
//                            leftAxis.setTextColor(ColorTemplate.getHoloBlue());
////        leftAxis.setAxisMaximum(200);
////        leftAxis.setAxisMinimum(0);
//                            leftAxis.setDrawGridLines(false);
//                            leftAxis.setGranularityEnabled(false);
//                        }
//                        b++;
////                        Toast.makeText(NewTab.this, mainprice.get(i).getPrice(), Toast.LENGTH_SHORT).show();
////						Toast.makeText(MainXml.this, mainprice.get(i).getPrice(), Toast.LENGTH_SHORT).show();
//                    }
//
//
////                    prepareListData();
//
//                }
//
//
//				/*if (movies != null) {
//					for (int i = 0; i < movies.size(); i = i + 1) {
//						mainlist.add(movies.get(i));
//					}
//
//				}
//				homeRecyclerViewAdapter.notifyDataSetChanged();
//				c=c+1;
//				favresponseget(c);*/
//            }
//
//            @Override
//            public void onFailure(Call<Numberpricelist> call, Throwable t) {
//                Log.e(TAG, t.toString());
//            }
//        });
//    }
//    private class MyAsyncTask extends AsyncTask<Void, Void, Void>
//    {
//        @Override
//        protected Void doInBackground(Void... params) {
//
//            return null;
//        }
//        @Override
//        protected void onPostExecute(Void result) {
//
////            setData(1, 1);
//        }
//    }
//}
