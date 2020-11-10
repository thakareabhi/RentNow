package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCar extends LoginSuccess {

    EditText editCarno, editName, editCost;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        editCarno = findViewById(R.id.editCarno);
        editName = findViewById(R.id.editName);
        editCost = findViewById(R.id.editCost);
        btn= findViewById(R.id.button6);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editCarno.getText().toString().trim().length() == 0 ||
                        editName.getText().toString().trim().length() == 0 ||
                        editCost.getText().toString().trim().length() == 0)
                {
                    Toast.makeText(AddCar.this, "Error", Toast.LENGTH_SHORT).show();
                    showMessage("Error", "Please enter all values");
                    return;
                }

                /*int a=0;
                db.execSQL("INSERT INTO cars VALUES('" + editCarno.getText() + "','" + editName.getText() +
                        "','" + editCost.getText() + "','"+a+"');");
                //store in db
                showMessage("Success", "Record added");
                //sucess in addition
                clearText();*/
                String g1=editCarno.getText().toString().trim();
                String g2=editName.getText().toString().trim();
                String g3=editCost.getText().toString().trim();
                boolean a=insertintab(g1,g2,g3);


            }
        });

    }

    public boolean insertintab(String str1, String str2, String s3)
    {
        if(Integer.parseInt(s3.toString())>0&&Integer.parseInt(str1.toString())>0)
        {
            int a=0;
            db.execSQL("INSERT INTO cars VALUES('" + str1 + "','" + str2 +
                    "','" + s3 + "','"+a+"');");
            //store in db
            showMessage("Success", "Record added");
            //sucess in addition
            clearText();

            return true;
        }
        else
        {
            return false;
        }

    }



    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        editCarno.setText("");
        editName.setText("");
        editCost.setText("");
        editCarno.requestFocus();
    }

}