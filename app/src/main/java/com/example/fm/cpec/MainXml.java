//package com.example.fm.cpec;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ExpandableListView;
//import android.widget.ExpandableListView.OnChildClickListener;
//import android.widget.ExpandableListView.OnGroupClickListener;
//import android.widget.ExpandableListView.OnGroupCollapseListener;
//import android.widget.ExpandableListView.OnGroupExpandListener;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//import static android.content.ContentValues.TAG;
//
//public class MainXml extends Activity {
//
//	ExpandableListAdapter listAdapter;
//	ExpandableListView expListView;
//	List<String> listDataHeader;
//	ImageView xmlback;
//	int headermain=0;
//	int k=1;
//	private int lastExpandedPosition = -1;
//	ProgressBar bar;
//	public static int checkchild=0;
//	HashMap<String, List<String>> listDataChild;
//	public static int groupname;
//	public static String maintittile;
//	public static 	ArrayList<NumberplotResponse> mainlist=new ArrayList<>();
//	public static 	ArrayList<NumberphaseResponse> mainphase=new ArrayList<>();
//	public static 	ArrayList<NumberpriceResponse> mainprice=new ArrayList<>();
//	public static 	ArrayList<Numberpricelist> mainprice1=new ArrayList<>();
//	TextView title;
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main_xml);
//		MainXml.mainlist.clear();
//		MainXml.mainphase.clear();
//		MainXml.mainprice.clear();
////		listDataHeader.clear();
////		listDataChild.clear();
//		MainXml.checkchild=0;
//		Bundle bundle = getIntent().getExtras();
//		String message = bundle.getString("regioname");
//		MainXml.maintittile=message;
//		title=(TextView)findViewById(R.id.maintitlegraph);
//		title.setText(message);
//		mainlist.clear();
//		bar=(ProgressBar)findViewById(R.id.progressBar);
//		// get the listview
//		expListView = (ExpandableListView) findViewById(R.id.lvExp);
//		xmlback= (ImageView) findViewById(R.id.arrowxmlback);
//
//		getprices("", MainXml.maintittile, 1,"");
////		prepareListData();
//
//
//		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
//
//		// setting list adapter
//		expListView.setAdapter(listAdapter);
////listAdapter.notifyDataSetChanged();
//		// Listview Group click listener
//		xmlback.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				finish();
//			}
//		});
//		expListView.setOnGroupClickListener(new OnGroupClickListener() {
//
//			@Override
//			public boolean onGroupClick(ExpandableListView parent, View v,
//										int groupPosition, long id) {
//				// Toast.makeText(getApplicationContext(),
//				// "Group Clicked " + listDataHeader.get(groupPosition),
//				// Toast.LENGTH_SHORT).show();
//				return false;
//			}
//		});
//
//		// Listview Group expanded listener
//		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
//
//			@Override
//			public void onGroupExpand(int groupPosition) {
//				/*if (lastExpandedPosition != -1
//						&& groupPosition != lastExpandedPosition) {
//					expListView.collapseGroup(lastExpandedPosition);
//				}
//				lastExpandedPosition = groupPosition;*/
//			}
//		});
//
//		// Listview Group collasped listener
//		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
//
//			@Override
//			public void onGroupCollapse(int groupPosition) {
////				MainXml.checkchild=0;
////				Toast.makeText(getApplicationContext(),
////						listDataHeader.get(groupPosition) + " Collapsed",
////						Toast.LENGTH_SHORT).show();
//
//			}
//		});
//
//		// Listview on child click listener
//		expListView.setOnChildClickListener(new OnChildClickListener() {
//
//			@Override
//			public boolean onChildClick(ExpandableListView parent, View v,
//										int groupPosition, int childPosition, long id) {
//				// TODO Auto-generated method stub
//				Toast.makeText(
//						getApplicationContext(),
//						listDataHeader.get(groupPosition)
//								+ " : "
//								+ listDataChild.get(
//								listDataHeader.get(groupPosition)).get(
//								childPosition), Toast.LENGTH_SHORT)
//						.show();
//				return false;
//			}
//		});
//	}
//
//	/*
//	 * Preparing the list data
//	 */
//	private void prepareListData() {
//
//
//		// Adding child data
//
//		NumberOfRowsMain apiService = ApiClient.getClient().create(NumberOfRowsMain.class);
//		Call<Numberofplotlist> call = apiService.getplotnum(MainXml.maintittile);
//		call.enqueue(new Callback<Numberofplotlist>() {
//			@Override
//			public void onResponse(Call<Numberofplotlist> call, Response<Numberofplotlist> response) {
//				int statusCode = response.code();
//				ArrayList<NumberplotResponse> movies = (ArrayList<NumberplotResponse>) response.body().getNumberplotResponse();
//
//				if (movies != null) {
//					for (int i = 0; i < movies.size(); i = i + 1) {
//						mainlist.add(movies.get(i));
//
//
//						if(movies.size()-i==1)
//						{
//							headermain=mainlist.size();
//
//
//
//							getphasenum(mainlist.get(0).getPlot().toString(),MainXml.maintittile,0);
//
//						}
//						/*listDataHeader.add(mainlist.get(i).getPlot().toString());
//
//
//
//
//
//
//
//
//
//						// Adding child data
//						List<String> newtown = new ArrayList<String>();
//						newtown.add("Phase-1");
//						newtown.add("Phase-2");
//
//
//
//						listDataChild.put(listDataHeader.get(i), newtown); // Header, Child data
//						 // Header, Child data
//						listAdapter.notifyDataSetChanged();*/
//
//					}
//
//				}
//
//
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
//			}
//
//			@Override
//			public void onFailure(Call<Numberofplotlist> call, Throwable t) {
//				Log.e(TAG, t.toString());
//			}
//		});
//
//
//
//
//	}
//
//
//	public void getphasenum(final String areaname, final String plotname, final int postitipn)
//	{
//		final List<String> newtown = new ArrayList<String>();
//		newtown.clear();
//		NumberOfRowsMain apiService = ApiClient.getClient().create(NumberOfRowsMain.class);
//		Call<NUmberphaseresponcelist> call = apiService.getphasenum(areaname,plotname);
//		call.enqueue(new Callback<NUmberphaseresponcelist>() {
//			@Override
//			public void onResponse(Call<NUmberphaseresponcelist> call, Response<NUmberphaseresponcelist> response) {
//				int statusCode = response.code();
//				ArrayList<NumberphaseResponse> movies = (ArrayList<NumberphaseResponse>) response.body().getNumberphaseResponse();
//				bar.setVisibility(View.GONE);
//				if (movies != null) {
//					listDataHeader.add(areaname);
//					for (int i = 0; i < movies.size(); i = i + 1) {
//						mainphase.add(movies.get(i));
//
//
//
//
//
//
//
//
//
//
//						// Adding child data
//
//						newtown.add(mainphase.get(i).getPhase());
//
//
//						// Header, Child data
//						// Header, Child data
//
//						if ((movies.size()-i)==1)
//						{
//							listDataChild.put(listDataHeader.get(postitipn), newtown);
//							listAdapter.notifyDataSetChanged();
//							for (int b=0;b<listDataHeader.size();b++)
//							{
//								expListView.expandGroup(b);
//							}
//						}
//						if(k<mainlist.size()) {
//							getphasenum(mainlist.get(k).getPlot().toString(), MainXml.maintittile, k);
//						}
//						k=k+1;
//					}
//
//
//
//
////					getprices(areaname,plotname,postitipn,mainphase.get(i).getPhase());
//					/*for (int k=0;k<mainprice.size();k++)
//					{
//						if(mainprice.get(k).getPlot().equals("Commertial"   ) && mainprice.get(k).getAreaname().equals("New TOWN") && mainprice.get(k).getPhase().equals("phase-1"))
//						{
//							Toast.makeText(MainXml.this, mainprice.get(k).getAreaname().toString(), Toast.LENGTH_SHORT).show();
//						}
//					}
//					Toast.makeText(MainXml.this, "", Toast.LENGTH_SHORT).show();*/
//				}
//
//
//
//			}
//
//			@Override
//			public void onFailure(Call<NUmberphaseresponcelist> call, Throwable t) {
//				Log.e(TAG, t.toString());
//			}
//		});
//	}
//
//	public void getprices(final String areaname, String plotname, final int postitipn,String phase)
//	{
//		listDataHeader = new ArrayList<String>();
//		listDataChild = new HashMap<String, List<String>>();
//		NumberOfRowsMain apiService = ApiClient.getClient().create(NumberOfRowsMain.class);
//		Call<Numberpricelist> call = apiService.getpricenum(areaname,plotname,phase);
//		call.enqueue(new Callback<Numberpricelist>() {
//			@Override
//			public void onResponse(Call<Numberpricelist> call, Response<Numberpricelist> response) {
//				int statusCode = response.code();
//				ArrayList<NumberpriceResponse> movies1 = (ArrayList<NumberpriceResponse>) response.body().getNumberpriceResponse();
//
//				if (movies1 != null) {
////					listDataHeader.add(areaname);
//					for (int i = 0; i < movies1.size(); i = i + 1) {
//						mainprice.add(movies1.get(i));
//						if ((movies1.size()-i)==1) {
//							prepareListData();
//						}
////						Toast.makeText(MainXml.this, mainprice.get(i).getPrice(), Toast.LENGTH_SHORT).show();
//					}
//
//
//
//
//				}
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
//			}
//
//			@Override
//			public void onFailure(Call<Numberpricelist> call, Throwable t) {
//				Log.e(TAG, t.toString());
//			}
//		});
//	}
//
//}
