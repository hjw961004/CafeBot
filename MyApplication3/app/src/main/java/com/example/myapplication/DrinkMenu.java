package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DrinkMenu extends AppCompatActivity {
    private int categoryState = 0;
    private RadioButton caffeine;
    private RadioButton decaffeine;
    private RadioButton latte;
    private RadioButton blended;
    private RadioButton yogurt;
    private RadioButton ade;
    private RadioButton tea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);

        caffeine = (RadioButton)findViewById(R.id.caffeine);
        decaffeine = (RadioButton)findViewById(R.id.decaffeine);
        latte = (RadioButton)findViewById(R.id.latte);
        blended = (RadioButton)findViewById(R.id.blended);
        yogurt = (RadioButton)findViewById(R.id.yogurt);
        ade = (RadioButton)findViewById(R.id.ade);
        tea = (RadioButton)findViewById(R.id.tea);

        Intent intent = getIntent();
        categoryState = intent.getExtras().getInt("categoryState");

        switch (categoryState){
            case 1 :
                caffeine.setChecked(true);
                break;
            case 2 :
                decaffeine.setChecked(true);
                break;
            case 3 :
                latte.setChecked(true);
                break;
            case 4 :
                blended.setChecked(true);
                break;
            case 5 :
                yogurt.setChecked(true);
                break;
            case 6 :
                ade.setChecked(true);
                break;
            case 7 :
                tea.setChecked(true);
                break;
            default:
                break;
        }
    }

    public void goback(View v){
        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup3);
        int i = rg.getCheckedRadioButtonId();

        switch(i){
            case R.id.caffeine :
                categoryState = 1;
                break;
            case R.id.decaffeine :
                categoryState = 2;
                break;
            case R.id.latte :
                categoryState = 3;
                break;
            case R.id.blended :
                categoryState = 4;
                break;
            case R.id.yogurt :
                categoryState = 5;
                break;
            case R.id.ade :
                categoryState = 6;
                break;
            case R.id.tea :
                categoryState = 7;
                break;
            default:
                categoryState = 0;
                break;
        }

        Intent intent = new Intent();
        intent.putExtra("categoryState", categoryState);
        setResult(categoryState, intent);
        finish();
    }
}