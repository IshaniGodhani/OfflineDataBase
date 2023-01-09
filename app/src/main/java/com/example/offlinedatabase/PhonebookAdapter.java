package com.example.offlinedatabase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhonebookAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<String> Name=new ArrayList<String>();
    ArrayList<String> Contact=new ArrayList<String>();
    ArrayList<Integer> Id=new ArrayList<Integer>();
    TextView txt1,txt2;
    ImageView menu;
    ListView listView;


    public PhonebookAdapter(Activity activity, ArrayList<String> name, ArrayList<String> contact, ArrayList<Integer> id) {
        this.activity=activity;
        this.Name=name;
        this.Id=id;
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
        convertView= LayoutInflater.from(activity).inflate(R.layout.item_category,parent,false);
        txt1=convertView.findViewById(R.id.item_name);
        txt2=convertView.findViewById(R.id.item_contact);

        txt1.setText(Name.get(position));
        txt2.setText(Contact.get(position));

//        txt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("Clicked");
//                DBHelper dbHelper=new DBHelper(context);
//                dbHelper.deleteData(Id.get(position));
//                Id.remove(position);
//                Contact.remove(position);
//                Name.remove(position);
//                notifyDataSetChanged();
//            }
//        });



        menu=convertView.findViewById(R.id.menu);
//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DBHelper dbHelper=new DBHelper(context);
//                dbHelper.deleteData(Id.get(position));
//                Id.remove(position);
//                Contact.remove(position);
//                Name.remove(position);
//                notifyDataSetChanged();
//
//            }
//        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                DBHelper dbHelper=new DBHelper(activity);
                Intent intent = new Intent(activity,MainActivity.class );
                intent.putExtra("id",Id);
                intent.putExtra("Name",Name);
                intent.putExtra("Contact",Contact);
                activity.startActivity(intent);
                activity.finish();

            }
        });
        return convertView;
    }
}
