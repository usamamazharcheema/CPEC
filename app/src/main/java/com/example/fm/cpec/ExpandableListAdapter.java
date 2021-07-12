//package com.example.fm.cpec;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.Typeface;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.WindowManager;
//import android.widget.BaseExpandableListAdapter;
//import android.widget.Button;
//import android.widget.ExpandableListView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.github.mikephil.charting.charts.LineChart;
//import com.github.mikephil.charting.components.YAxis;
//import com.github.mikephil.charting.data.Entry;
//import com.github.mikephil.charting.data.LineData;
//import com.github.mikephil.charting.data.LineDataSet;
//import com.github.mikephil.charting.utils.ColorTemplate;
//
//public class ExpandableListAdapter extends BaseExpandableListAdapter {
//
//	private Context _context;
//	private List<String> _listDataHeader; // header titles
//	// child data in format of header title, child title
//	private HashMap<String, List<String>> _listDataChild;
//	int goupname=0;
//	int checkchild=0;
//	public ExpandableListAdapter(Context context, List<String> listDataHeader,
//								 HashMap<String, List<String>> listChildData) {
//		this._context = context;
//		this._listDataHeader = listDataHeader;
//		this._listDataChild = listChildData;
//	}
//
//	@Override
//	public Object getChild(int groupPosition, int childPosititon) {
//		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//				.get(childPosititon);
//	}
//
//	@Override
//	public long getChildId(int groupPosition, int childPosition) {
//		return childPosition;
//	}
//
//	@Override
//	public View getChildView(final int groupPosition, final int childPosition,
//							 boolean isLastChild, View convertView, ViewGroup parent) {
//		if(goupname==groupPosition)
//		{
//
//		}
//		else {
//			if (groupPosition == 0) {
//				MainXml.checkchild = 0;
//			} else {
//				MainXml.checkchild = _listDataChild.get(_listDataHeader.get(groupPosition)).size() + _listDataChild.get(_listDataHeader.get(groupPosition - 1)).size() - 1;
//				_listDataChild.get(_listDataHeader.get(groupPosition));
//
////			Toast.makeText(_context,
////					_listDataChild.get(_listDataHeader.get(groupPosition)).size() + " Expanded",
////					Toast.LENGTH_SHORT).show();
//			}
//		}
////		Toast.makeText(_context, ""+MainXml.checkchild, Toast.LENGTH_SHORT).show();
//		final String childText = (String) getChild(groupPosition, childPosition);
//
//		if (convertView == null) {
//			LayoutInflater infalInflater = (LayoutInflater) this._context
//					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			convertView = infalInflater.inflate(R.layout.child, null);
//		}
//		if (groupPosition==0)
//		{
//			checkchild=0;
//		}
//		else
//		{
//
//			for (int j=0;j<groupPosition;j++)
//			{
//				checkchild=	checkchild+(_listDataChild.get(_listDataHeader.get(groupPosition-1)).size()-1);
//				if((groupPosition-j)==1)
//				{
//					checkchild=(checkchild)+childPosition+1;
//				}
//			}
//		}
//
////		Toast.makeText(_context, String.valueOf(groupPosition), Toast.LENGTH_SHORT).show();
////		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
////				WindowManager.LayoutParams.FLAG_FULLSCREEN);
//		LineChart mChart;
//
//		ArrayList <String> graphsize=new ArrayList<>();
//
//		for(int c=0;c<MainXml.mainprice.size();c++)
//		{
//
//			if (groupPosition>0)
//			{
//				if(MainXml.mainprice.get(c).getAreaname().toString().equals(MainXml.mainlist.get(groupPosition).getPlot().toString()) && MainXml.mainprice.get(c).getPhase().toString().equals(MainXml.mainphase.get(checkchild).getPhase().toString())   )
//				{
//
//
//					graphsize.add(String.valueOf(MainXml.mainprice.get(c).getPrice()));
//				}
//			}
//			else
//			{
//				if(MainXml.mainprice.get(c).getAreaname().toString().equals(MainXml.mainlist.get(groupPosition).getPlot().toString()) && MainXml.mainprice.get(c).getPhase().toString().equals(MainXml.mainphase.get(childPosition).getPhase().toString())   )
//				{
//					graphsize.add(String.valueOf(MainXml.mainprice.get(c).getPrice()));
//				}
//			}
//
//		}
//		Button purchase=(Button)convertView.findViewById(R.id.pricebutton);
//		purchase.setText(graphsize.get(graphsize.size()-1).toString());
//		purchase.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if(groupPosition==0) {
//					String[] myStrings = new String[]{MainXml.mainlist.get(groupPosition).getPlot().toString(), MainXml.mainphase.get(childPosition).getPhase().toString()};
//					Intent i = new Intent(_context, NewTab.class);
//
//					i.putExtra("graph", myStrings);
//					_context.startActivity(i);
//				}
//				else
//				{
//					String[] myStrings = new String[]{MainXml.mainlist.get(groupPosition).getPlot().toString(), MainXml.mainphase.get(checkchild).getPhase().toString()};
//					Intent i = new Intent(_context, NewTab.class);
//
//					i.putExtra("graph", myStrings);
//					_context.startActivity(i);
//				}
//			}
//		});
//		LinearLayout linearLayout=(LinearLayout)convertView.findViewById(R.id.mainchild);
//		TextView textView=(TextView)convertView.findViewById(R.id.lblListItem);
//		textView.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				String[] myStrings = new String[] {MainXml.mainlist.get(groupPosition).getPlot().toString(), MainXml.mainphase.get(MainXml.checkchild).getPhase().toString()};
//				Intent i=new Intent(_context,NewTab.class);
//
//				i.putExtra("graph",myStrings);
//				_context.startActivity(i);
//			}
//		});
//		linearLayout.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if(groupPosition==0) {
//					String[] myStrings = new String[]{MainXml.mainlist.get(groupPosition).getPlot().toString(), MainXml.mainphase.get(childPosition).getPhase().toString()};
//					Intent i = new Intent(_context, NewTab.class);
//
//					i.putExtra("graph", myStrings);
//					_context.startActivity(i);
//				}
//				else
//				{
//					String[] myStrings = new String[]{MainXml.mainlist.get(groupPosition).getPlot().toString(), MainXml.mainphase.get(checkchild).getPhase().toString()};
//					Intent i = new Intent(_context, NewTab.class);
//
//					i.putExtra("graph", myStrings);
//					_context.startActivity(i);
//				}
//			}
//		});
//
//		mChart = (LineChart) convertView.findViewById(R.id.chart1);
//		mChart.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if(groupPosition==0) {
//					String[] myStrings = new String[]{MainXml.mainlist.get(groupPosition).getPlot().toString(), MainXml.mainphase.get(childPosition).getPhase().toString()};
//					Intent i = new Intent(_context, NewTab.class);
//
//					i.putExtra("graph", myStrings);
//					_context.startActivity(i);
//				}
//				else
//				{
//					String[] myStrings = new String[]{MainXml.mainlist.get(groupPosition).getPlot().toString(), MainXml.mainphase.get(checkchild).getPhase().toString()};
//					Intent i = new Intent(_context, NewTab.class);
//
//					i.putExtra("graph", myStrings);
//					_context.startActivity(i);
//				}
//			}
//		});
//		// no description text
//		mChart.getDescription().setEnabled(false);
//
//		// enable touch gestures
//		mChart.setTouchEnabled(true);
//
//		mChart.setDragDecelerationFrictionCoef(0.9f);
//
//		// enable scaling and dragging
//		mChart.setDragEnabled(true);
//		mChart.setScaleEnabled(true);
//		mChart.setDrawGridBackground(true);
//		mChart.setHighlightPerDragEnabled(false);
//
//		// if disabled, scaling can be done on x- and y-axis separately
//		mChart.setPinchZoom(true);
//		mChart.getAxisLeft().setDrawLabels(false);
//		mChart.getAxisRight().setDrawLabels(false);
//		mChart.getXAxis().setDrawLabels(false);
//		mChart.getXAxis().setEnabled(false);
//		mChart.getAxisLeft().setDrawAxisLine(false);
//		mChart.getLegend().setEnabled(false);
//		// set an alternative background color
//		mChart.getAxisLeft().setDrawGridLines(false);
//		mChart.getAxisRight().setDrawGridLines(false);
//		mChart.getAxisRight().setDrawAxisLine(false);
//		mChart.getXAxis().setDrawGridLines(false);
//
//		mChart.setBackgroundColor(Color.TRANSPARENT);
//
//		// add data
//		int c=100;
//		ArrayList<Entry> yVals1 = new ArrayList<Entry>();
//
//		for (int i = 0; i < graphsize.size(); i++) {
//
//			yVals1.add(new Entry(i,Integer.parseInt(graphsize.get(i)) ));
////			if(i%2==0)
////			{
////				c=c+5000;
////			}
////			else
////			{
////				c=c-2000;
////			}
//		}
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
//		LineDataSet set1, set2;
//
//		if (mChart.getData() != null &&
//				mChart.getData().getDataSetCount() > 0) {
//			set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
//			set2 = (LineDataSet) mChart.getData().getDataSetByIndex(1);
//			set1.setValues(yVals1);
////            set2.setValues(yVals2);
//			mChart.getData().notifyDataChanged();
//			mChart.notifyDataSetChanged();
//		} else {
//			// create a dataset and give it a type
//			set1 = new LineDataSet(yVals1, "");
//
//			set1.setAxisDependency(YAxis.AxisDependency.LEFT);
//			set1.setColor(ColorTemplate.rgb("#32CD32"));
//			set1.setDrawValues(false);
//			set1.setDrawCircles(false);
//
//          /*  set1.setLineWidth(2);
//            set1.setCircleRadius(3);
//            set1.setFillAlpha(65);
//            set1.setFillColor(ColorTemplate.getHoloBlue());
//            set1.setHighLightColor(Color.rgb(244, 117, 117));
//            set1.setDrawCircleHole(false);*/
//			//set1.setFillFormatter(new MyFillFormatter(0f));
//			//set1.setDrawHorizontalHighlightIndicator(false);
//			//set1.setVisible(false);
//			//set1.setCircleHoleColor(Color.WHITE);
//
//			// create a dataset and give it a type
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
//			// create a data object with the datasets
//			LineData data = new LineData(set1);
//			data.setValueTextColor(Color.WHITE);
//			data.setValueTextSize(9);
//
//			// set data
//			mChart.setData(data);
//		}
//
//
//		mChart.animateXY(500, 500);
//		TextView txtListChild = (TextView) convertView
//				.findViewById(R.id.lblListItem);
//
//		txtListChild.setText(childText);
//		goupname=groupPosition;
//		checkchild=0;
//		return convertView;
//	}
//
//	@Override
//	public int getChildrenCount(int groupPosition) {
//		return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//				.size();
//	}
//
//	@Override
//	public Object getGroup(int groupPosition) {
//		return this._listDataHeader.get(groupPosition);
//	}
//
//	@Override
//	public int getGroupCount() {
//		return this._listDataHeader.size();
//	}
//
//	@Override
//	public long getGroupId(int groupPosition) {
//		return groupPosition;
//	}
//
//	@Override
//	public View getGroupView(int groupPosition, boolean isExpanded,
//							 View convertView, ViewGroup parent) {
//		String headerTitle = (String) getGroup(groupPosition);
//		if (convertView == null) {
//			LayoutInflater infalInflater = (LayoutInflater) this._context
//					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			convertView = infalInflater.inflate(R.layout.parent, null);
//		}
//
//		TextView lblListHeader = (TextView) convertView
//				.findViewById(R.id.lblListHeader);
//		lblListHeader.setTypeface(null, Typeface.BOLD);
//		lblListHeader.setText(headerTitle);
//
//		/*ExpandableListView mExpandableListView = (ExpandableListView) parent;
//		mExpandableListView.expandGroup(groupPosition);*/
//		return convertView;
//	}
//
//	@Override
//	public boolean hasStableIds() {
//		return false;
//	}
//
//	@Override
//	public boolean isChildSelectable(int groupPosition, int childPosition) {
//		return true;
//	}
//
//}
