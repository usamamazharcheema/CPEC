package com.example.fm.cpec;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SellProperty extends FragmentActivity implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    EditText title;
   public static Pager adapter;
    public static String titletext;
    ImageView img4;
    Button img2,img3,img1;
    View v1,v2,v3,v4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_property);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        title=(EditText)findViewById(R.id.newtitle);
        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText(" "));
        tabLayout.addTab(tabLayout.newTab().setText(" "));
        tabLayout.addTab(tabLayout.newTab().setText(" "));
        tabLayout.addTab(tabLayout.newTab().setText(" "));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
v1=getLayoutInflater().inflate(R.layout.tabindustrials, null);
        v2=getLayoutInflater().inflate(R.layout.tabresidential, null);
        v3=getLayoutInflater().inflate(R.layout.tabcomertial, null);
        v4=getLayoutInflater().inflate(R.layout.tabopenland, null);
        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                titletext=title.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        title.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == EditorInfo.IME_ACTION_SEARCH ||
                        keyCode == EditorInfo.IME_ACTION_DONE ||
                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    titletext=title.getText().toString();
                    Toast.makeText(SellProperty.this, titletext, Toast.LENGTH_SHORT).show();
                    return true;


                }

                    return false; // pass on to other listeners.

            }

        });
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount(),1);

        //Adding adapter to pager
        viewPager.setAdapter(adapter);


        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);

        tabLayout.getTabAt(0).setCustomView(v1);
        tabLayout.getTabAt(1).setCustomView(v2);
        tabLayout.getTabAt(2).setCustomView(v3);
        tabLayout.getTabAt(3).setCustomView(v4);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

        img1=(Button)v1.findViewById(R.id.searchimg);
        img2=(Button)v2.findViewById(R.id.searchimg);
        img3=(Button)v3.findViewById(R.id.commertilaimg);
        img4=(ImageView)v4.findViewById(R.id.openimg);
        if (tab.getPosition()==0)
        {
//            tab1();
        }
        else if(tab.getPosition()==1)
        {
//            tab2();
        }
        else if(tab.getPosition()==2)
        {
//tab3();
        }
        else if(tab.getPosition()==3)
        {
//tab4();
        }
    }
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
  /*  public void tab1()
    {
       img1.setImageResource(R.drawable.indutrialicon);
        img2.setImageResource(R.drawable.unselectedresidential);
        img3.setImageResource(R.drawable.unselectedcommertial);
        img4.setImageResource(R.drawable.unselectedopenland);

    }
    public void tab2()
    {
        img1.setImageResource(R.drawable.unselectedindustrial);
        img2.setImageResource(R.drawable.resedentialicon);
        img3.setImageResource(R.drawable.unselectedcommertial);
        img4.setImageResource(R.drawable.unselectedopenland);

    }
    public void tab3()
    {
        img1.setImageResource(R.drawable.unselectedindustrial);
        img2.setImageResource(R.drawable.unselectedresidential);
        img3.setImageResource(R.drawable.commertialicon);
        img4.setImageResource(R.drawable.unselectedopenland);

    }
    public void tab4()
    {
        img1.setImageResource(R.drawable.unselectedindustrial);
        img2.setImageResource(R.drawable.unselectedresidential);
        img3.setImageResource(R.drawable.unselectedcommertial);
        img4.setImageResource(R.drawable.openlandicon);

    }*/
}
