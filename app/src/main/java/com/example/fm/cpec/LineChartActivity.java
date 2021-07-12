
package com.example.fm.cpec;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LineChartActivity extends AppCompatActivity {
    ProgressBar b;
    ImageView back;
ArrayList<NumberpriceResponse> numberpriceResponses=new ArrayList<>();
ArrayList<Integer> pricelist=new ArrayList<>();
TextView areaname;
LinearLayout li;
    private LineChart mChart;
    String getplot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_linechart);

        Intent intent = getIntent();
getplot=intent.getExtras().getString("plot");
areaname=(TextView)findViewById(R.id.searname);
areaname.setText(getplot.toUpperCase());
        back=(ImageView) findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getgraph(getplot);
        b=(ProgressBar)findViewById(R.id.progressBar);
        li=findViewById(R.id.pricearea);

    }
    private void setData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<Entry>();
        values.add(new Entry(0, 0, getResources().getDrawable(R.drawable.star)));
        values.add(new Entry(1, Integer.parseInt(numberpriceResponses.get(4).getPrice()), getResources().getDrawable(R.drawable.star)));
        values.add(new Entry(2, Integer.parseInt(numberpriceResponses.get(3).getPrice()), getResources().getDrawable(R.drawable.star)));
        values.add(new Entry(3, Integer.parseInt(numberpriceResponses.get(2).getPrice()), getResources().getDrawable(R.drawable.star)));
        values.add(new Entry(4, Integer.parseInt(numberpriceResponses.get(1).getPrice()), getResources().getDrawable(R.drawable.star)));
        values.add(new Entry(5, Integer.parseInt(numberpriceResponses.get(0).getPrice()), getResources().getDrawable(R.drawable.star)));
        values.add(new Entry(6, 0, getResources().getDrawable(R.drawable.star)));

        /*for (int i = 0; i < count; i++) {

        }*/

        LineDataSet set1;
        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
           set1.setValues(values);
            mChart.getData().notifyDataChanged();

        } else {
            set1 = new LineDataSet(values, "");

            set1.setDrawIcons(false);
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set1.setCubicIntensity(0.2f);
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.rgb(78,160,160));
            set1.setCircleColorHole(Color.WHITE);
            set1.setValueTextSize(9f);
            set1.setDrawCircles(true);
            set1.setDrawFilled(true);
            set1.setHighlightEnabled(false);
            set1.setColor(Color.rgb(78,160,160));
            set1.setFormLineWidth(2f);
            set1.setDrawHorizontalHighlightIndicator(false);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);

            if (Utils.getSDKInt() >= 18) {
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.BLACK);
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1);

            LineData data = new LineData(dataSets);
            data.setValueFormatter( new MyValueFormatter());
            mChart.setData(data);
        }
    }
    public void getgraph(final String mystring)
    {
        final NumberOfRowsMain service = ApiClient.getClient().create( NumberOfRowsMain.class);

        Call<Numberpricelist> userCall =service.getpricenum(mystring);

        userCall.enqueue(new Callback<Numberpricelist>() {
            @Override
            public void onResponse(Call<Numberpricelist> call, Response<Numberpricelist> response) {
//                Toast.makeText(LineChartActivity.this, "GOT", Toast.LENGTH_SHORT).show();
ArrayList<NumberpriceResponse> numberpriceResponsethis=(ArrayList<NumberpriceResponse>) response.body().getNumberpriceResponse();
if(numberpriceResponsethis!=null)
{
    for(int c=0;c<numberpriceResponsethis.size();c++)
    {
        numberpriceResponses.add(numberpriceResponsethis.get(c));
        pricelist.add(Integer.parseInt(numberpriceResponsethis.get(c).getPrice()));
        if(numberpriceResponsethis.size()-c==1)
        {
            mainmethod();
        }
    }
}
            }

            @Override
            public void onFailure(Call<Numberpricelist> call, Throwable t) {
                try {
                    Toast.makeText(LineChartActivity.this, "You don't have internet connection", Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", t.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public void mainmethod()
    {


        mChart = (LineChart) findViewById(R.id.chart1);
        b.setVisibility(View.GONE);
        areaname.setVisibility(View.VISIBLE);
        mChart.setVisibility(View.VISIBLE);
        li.setVisibility(View.VISIBLE);
        mChart.setDrawGridBackground(false);
        mChart.getDescription().setEnabled(false);
        mChart.setTouchEnabled(true);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setPinchZoom(true);
        mChart.setBackgroundColor(Color.WHITE);
        mChart.getLegend().setEnabled(false);


        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // restrict interval to 1 (minimum)
        String[] values = new String[]{"",numberpriceResponses.get(4).getDate(), numberpriceResponses.get(3).getDate(), numberpriceResponses.get(2).getDate(), numberpriceResponses.get(1).getDate(),numberpriceResponses.get(0).getDate(),""};
        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));

        YAxis leftAxis = mChart.getAxisLeft();
        IAxisValueFormatter custom = new MyAxisValueFormatter();
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setAxisMaximum(Collections.max(pricelist)+Collections.max(pricelist));
        leftAxis.setAxisMinimum(1f);
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawGridLines(false);
        leftAxis.setDrawAxisLine(false);


        mChart.getAxisRight().setEnabled(false);

        setData(4, 4);

        mChart.animateX(2500);
    }
}
