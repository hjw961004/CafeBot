package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    DotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<DataPage> list = new ArrayList<>();
        list.add(new DataPage(R.drawable.sample_1, "Starbucks", 4900));
        list.add(new DataPage(R.drawable.sample_2, "Twosome Place", 4100));
        list.add(new DataPage(R.drawable.sample_3, "EDIYA", 3000));
        list.add(new DataPage(R.drawable.sample_3, "EDIYA", 3000));
        list.add(new DataPage(R.drawable.sample_3, "EDIYA", 3000));
        list.add(new DataPage(R.drawable.sample_3, "EDIYA", 3000));
        list.add(new DataPage(R.drawable.sample_3, "EDIYA", 3000));
        list.add(new DataPage(R.drawable.sample_3, "EDIYA", 3000));
        list.add(new DataPage(R.drawable.sample_3, "EDIYA", 3000));
        list.add(new DataPage(R.drawable.sample_3, "EDIYA", 3000));

        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(new ViewPagerAdapter(list));

        dotsIndicator = findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager2(viewPager2);
    }
}






