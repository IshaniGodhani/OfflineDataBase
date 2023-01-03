package com.example.offlinedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PhonebookAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> Name=new ArrayList<String>();
    ArrayList<String> Contact=new ArrayList<String>();
    TextView txt1,txt2;

    public PhonebookAdapter(MainActivity2 context, ArrayList<String> name, ArrayList<String> contact) {
        this.context=context;
        this.Name=name;
        this.Contact=contact;
    }

    @Override
    public int getCount() {
        return Name.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_category,parent,false);
        txt1=convertView.findViewById(R.id.item_name);
        txt2=convertView.findViewById(R.id.item_contact);

        txt1.setText(Name.get(position));
        txt2.setText(Contact.get(position));



        return convertView;
    }
}
