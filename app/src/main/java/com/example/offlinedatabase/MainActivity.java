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

//    ArrayList<String> Name =new ArrayList<String>();
//    ArrayList<String> Contact =new ArrayList<String>();
//    ArrayList<Integer> Id = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxtName=findViewById(R.id.etxtName);
        etxtContact=findViewById(R.id.etxtContact);
        btnSubmit=findViewById(R.id.btnSubmit);

        if(getIntent().getExtras()!=null) {
            int id= getIntent().getIntExtra("Id",0);
            String name = getIntent().getStringExtra("Name");
            String contact = getIntent().getStringExtra("Contact");
            System.out.println("id="+id);
            etxtName.setText("" + name);
            etxtContact.setText("" + contact);


            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Name = etxtName.getText().toString();
                    String Contact = etxtContact.getText().toString();

////                    if (getIntent().getExtras() == null) {
//                        DBHelper dbHelper = new DBHelper(MainActivity.this);
//                        dbHelper.insertData(Name, Contact);
//                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                    {
                        String txt1 = etxtName.getText().toString();
                        String txt2 = etxtContact.getText().toString();

                        DBHelper dbHelper = new DBHelper(MainActivity.this);
                        dbHelper.updateData(id, txt1, txt2);
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        finish();
//                    }
                }

            });
        }


        findViewById(R.id.btnDisplay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });




    }
}