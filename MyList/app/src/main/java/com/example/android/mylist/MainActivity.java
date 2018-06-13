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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final ArrayList<ListItem> items = new ArrayList<ListItem>();
        items.add(new ListItem("Radiology","MRI"));
        items.add(new ListItem("Radiology","CT SCAN"));
        items.add(new ListItem("Radiology","X-Ray"));
        items.add(new ListItem("delivery","Incubator"));
        items.add(new ListItem("","ICU"));
        MyCustomAdapter myadapter = new MyCustomAdapter(items);
        ListView ls = (ListView)findViewById(R.id.lst);
        ls.setAdapter(myadapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==4){
                    Intent myintent = new Intent(view.getContext(),Main2Activity.class);
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
            View myView = mInflater.inflate(R.layout.data_element,null);

            TextView txtsetvice=(TextView)myView.findViewById(R.id.txts);
            TextView txtdepartment=(TextView)myView.findViewById(R.id.txtd);
            txtsetvice.setText(items.get(i).service);
            txtdepartment.setText(items.get(i).department);


            return myView;

    }



}}
