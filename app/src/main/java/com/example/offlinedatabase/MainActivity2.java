package com.example.offlinedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    ArrayList<String> Name =new ArrayList<String>();
    ArrayList<String> Contact =new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fab=findViewById(R.id.fab);
        etxtName=findViewById(R.id.etxtName);
        etxtContact=findViewById(R.id.etxtContact);
        listView=findViewById(R.id.list_item);
        btnDisplay=findViewById(R.id.btnDisplay);

        Name=getIntent().getStringArrayListExtra("Name");
        Contact=getIntent().getStringArrayListExtra("Contact");


        phonebookAdapter=new PhonebookAdapter(this,Name,Contact);
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