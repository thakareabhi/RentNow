package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTestAct extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test);
    }

    @Test
    public void test() {
        MainActivity m1 = new MainActivity();
        assertEquals(false, m1.checkName("Abcde"));
    }

    @Test
    public void test_check_name() {
        MainActivity m1 = new MainActivity();
        assertEquals(false, m1.checkPass("Abc5de"));
    }

    @Test
    public void test_name_check() {
        MainActivity m1 = new MainActivity();
        assertEquals(true, m1.checkName("admin"));
    }

    @Test
    public void test_pass_check() {
        MainActivity m1 = new MainActivity();
        assertEquals(true, m1.checkPass("admin123"));
    }

    @Test
    public void test_insert_check() {
        AddCar m1 = new AddCar();
        assertEquals(false, m1.insertintab("-3","swift","10"));
    }

    @Test
    public void test_insert_check1() {
        AddCar m1 = new AddCar();
        assertEquals(false, m1.insertintab("4","swift1","-1"));
    }
    
}