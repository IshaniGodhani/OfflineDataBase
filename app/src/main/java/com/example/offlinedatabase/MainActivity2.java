package com.example.offlinedatabase;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    FloatingActionButton fab;
    Button btnDisplay;
    EditText etxtName,etxtContact;
    ListView listView;
    PhonebookAdapter phonebookAdapter;
    ArrayList<User> userList= new ArrayList<User>();
//    ArrayList<String> Name =new ArrayList<String>();
//    ArrayList<String> Contact =new ArrayList<String>();
//    ArrayList<Integer> Id = new ArrayList<Integer>();
    //int[] Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fab=findViewById(R.id.fab);
        etxtName=findViewById(R.id.etxtName);
        etxtContact=findViewById(R.id.etxtContact);
        listView=findViewById(R.id.list_item);
        btnDisplay=findViewById(R.id.btnDisplay);

        DBHelper dbHelper=new DBHelper(MainActivity2.this);
        Cursor cursor=dbHelper.viewData();
        while (cursor.moveToNext())
        {

            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String contact=cursor.getString(2);
            User user=new User(id,name,contact);
            userList.add(user);
        }

//        Id=getIntent().getIntArrayExtra("id");
//        Name=getIntent().getStringArrayListExtra("Name");
//        Contact=getIntent().getStringArrayListExtra("Contact");


        phonebookAdapter=new PhonebookAdapter(this,userList);
        listView.setAdapter(phonebookAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                String str1=etxtName.getText().toString();
                String str2=etxtContact.getText().toString();

            }
        });




    }
}