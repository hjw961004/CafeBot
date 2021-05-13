package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }

    public void goback(View v){
        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
        int i = rg.getCheckedRadioButtonId();

        Intent intent = new Intent();
        intent.putExtra("name", "value");
        setResult(i, intent);
        finish();
    }
}