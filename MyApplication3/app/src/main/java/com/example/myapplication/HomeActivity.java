package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    DotsIndicator dotsIndicator;
    private BottomNavigationView mBottomNV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<DataPage> list = new ArrayList<>();
        list.add(new DataPage(R.drawable.sample_1,"Starbucks", 4900));
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

        mBottomNV = findViewById(R.id.nav_view);
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigate(menuItem.getItemId());

                return true;
            }
        });
    }
    private void BottomNavigate(int id) {  //BottomNavigation 페이지 변경
        String tag = String.valueOf(id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            if (id == R.id.navigation_1) {
                Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent1);
            } else if (id == R.id.navigation_2){
                Intent intent2 = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent2);
            } else if (id == R.id.navigation_3){
                Intent intent3 = new Intent(getApplicationContext(), MainCflistActivity.class);
                startActivity(intent3);
            }

            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();


    }


}