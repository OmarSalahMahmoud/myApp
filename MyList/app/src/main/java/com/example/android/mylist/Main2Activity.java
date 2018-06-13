package com.example.android.mylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       final ArrayList<ListItem> items = new ArrayList<ListItem>();
        items.add(new ListItem("ICU","Sunday"));
        items.add(new ListItem("ICU","Monday"));
        items.add(new ListItem("ICU","Tuesday"));
        items.add(new ListItem("ICU","Wednesday"));
        items.add(new ListItem("ICU","Thursday"));
        items.add(new ListItem("ICU","Friday"));
        items.add(new ListItem("ICU","Saturday"));

        MyCustomAdapter myadapter = new MyCustomAdapter(items);
        ListView ls = (ListView)findViewById(R.id.dayslst);
        ls.setAdapter(myadapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==4){
                    Intent myintent = new Intent(view.getContext(),Main3Activity.class);
                    startActivityForResult(myintent,0);
                }
            }
        });
    }


     class MyCustomAdapter extends BaseAdapter {
        ArrayList<ListItem> items = new ArrayList<ListItem>();
         MyCustomAdapter(ArrayList<ListItem>  items) {
            this.items=items;
        }


        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public String getItem(int position) {
            return items.get(position).service;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView2 = mInflater.inflate(R.layout.icu_elemnt,null);

            TextView day =(TextView)myView2.findViewById(R.id.daytxt1);
            TextView icu=(TextView)myView2.findViewById(R.id.icu1);
            day.setText(items.get(i).service);
            icu.setText(items.get(i).department);



            return myView2;

    }



}}
