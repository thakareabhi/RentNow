package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;

public class LoginSuccess extends AppCompatActivity {

    SQLiteDatabase db;
    Button addCar,rentCar,returnCar,Viewcars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        addCar=findViewById(R.id.button2);
        rentCar=findViewById(R.id.button3);
        returnCar=findViewById(R.id.button4);
        Viewcars=findViewById(R.id.button5);


        db = openOrCreateDatabase("CarDB", Context.MODE_PRIVATE, null);
        //open or create ->databaseacting as file
        //private mode to avoid overlap
        db.execSQL("CREATE TABLE IF NOT EXISTS cars(carno VARCHAR,name VARCHAR,cost VARCHAR,status INTEGER);");

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(LoginSuccess.this, AddCar.class);
                startActivity(i);
            }
         });

        rentCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(LoginSuccess.this, RentCar.class);
                startActivity(i);
            }
        });

        returnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(LoginSuccess.this, ReturnCar.class);
                startActivity(i);
            }
        });

        Viewcars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Cursor c = db.rawQuery("SELECT * FROM cars WHERE status=0", null);
                if (c.getCount() == 0) {
                    showMessage("Error", "No records found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()) {
                    buffer.append("Car no: " + c.getString(0) + "\n");//column wise
                    buffer.append("Name : " + c.getString(1) + "\n");
                    String str2=c.getString(2);
                    buffer.append("Cost : " + str2.substring(0,str2.length()) + "\n\n");

                }
                showMessage("Car Details", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}