package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    Button b1;
    EditText elogin,plogin;
    String s1,s2,s3,s4;

    MainActivity()
    {
        s3="admin";
        s4="admin123";
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        elogin=findViewById(R.id.Name);
        plogin=findViewById(R.id.Password);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                s1=elogin.getText().toString().trim();
                s2=plogin.getText().toString().trim();

                if (elogin.getText().toString().trim().length() == 0 ||
                        plogin.getText().toString().trim().length() == 0)
                {
                    Toast.makeText(MainActivity.this, "Error Enter all values", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if( s1.equals("admin") && s2.equals("admin123"))
                {
                    Intent i = new Intent(MainActivity.this, LoginSuccess.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error Invalid Login", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });

    }

    public boolean checkName(String s9)
    {
        return s3.equals(s9);
    }
    public boolean checkPass(String s9)
    {
        return s4.equals(s9);
    }


}