package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RentCar extends LoginSuccess {

    Button btn;
    EditText rentno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_car);

        rentno=findViewById(R.id.editrentcarno);
        btn=findViewById(R.id.button7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (rentno.getText().toString().trim().length() == 0) {
                    showMessage("Error", "Please enter Carno");
                    return;
                }
                Cursor c = db.rawQuery("SELECT status FROM cars WHERE carno='" + rentno.getText() + "'", null);
                if (c.moveToNext()&&c.getInt(0)==0) {
                    /*db.execSQL("UPDATE cars SET name='" + editName.getText() + "',marks='" + editCost.getText() +
                            "' WHERE rollno='" + editCarno.getText() + "'");*/
                    db.execSQL("UPDATE cars SET status = 1 WHERE  carno='" + rentno.getText() + "'");

                    showMessage("Success", "Record Modified");
                } else {
                    showMessage("Error", "Rented or Invalid Carno");
                }
                clearText();

            }
        });




    }

    public void clearText() {

        rentno.requestFocus();
    }
    public void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}