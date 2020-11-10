package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReturnCar extends LoginSuccess {
    Button btn1;
    EditText renturnnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_car);

        renturnnow=findViewById(R.id.editReturnNow);
        btn1=findViewById(R.id.button9);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (renturnnow.getText().toString().trim().length() == 0) {
                    showMessage("Error", "Please enter CarNo");
                    return;
                }
                Cursor c = db.rawQuery("SELECT status FROM cars WHERE carno='" + renturnnow.getText() + "'", null);
                if (c.moveToNext()&&c.getInt(0)==1) {
                    /*db.execSQL("UPDATE cars SET name='" + editName.getText() + "',marks='" + editCost.getText() +
                            "' WHERE rollno='" + editCarno.getText() + "'");*/
                    db.execSQL("UPDATE cars SET status = 0 WHERE  carno='" + renturnnow.getText() + "'");

                    showMessage("Success", "Record Modified");
                } else {
                    showMessage("Error", " Invalid Operation");
                }
                clearText();

            }
        });



    }


    public void clearText() {

        renturnnow.requestFocus();
    }
    public void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}