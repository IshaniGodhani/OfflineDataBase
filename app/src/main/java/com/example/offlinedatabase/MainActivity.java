package com.example.offlinedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etxtName,etxtContact;
    Button btnSubmit, btnDisplay;
    ArrayList<Integer> Id=new ArrayList<Integer>();
    ArrayList<String> Name=new ArrayList<String>();
    ArrayList<String> Contact=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxtName=findViewById(R.id.etxtName);
        etxtContact=findViewById(R.id.etxtContact);


        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               String Name=etxtName.getText().toString();
                String Contact=etxtContact.getText().toString();

                DBHelper dbHelper=new DBHelper(MainActivity.this);

                dbHelper.insertData(Name,Contact);
            }
        });
        findViewById(R.id.btnDisplay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                DBHelper dbHelper=new DBHelper(MainActivity.this);
                Cursor cursor=dbHelper.viewData();
                while (cursor.moveToNext())
                {
                    Id.add(cursor.getInt(0));
                    Name.add(cursor.getString(1));
                    Contact.add(cursor.getString(2));
                }
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("Name",Name);
                intent.putExtra("Contact",Contact);
                startActivity(intent);

            }
        });




    }
}