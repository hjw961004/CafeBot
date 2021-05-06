package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.navigation.NavigationView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //툴바
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    // 가운데
    private ViewPager2 viewPager2;
    private DotsIndicator dotsIndicator;
    private ArrayList<DataPage> list;

    //바텀네비게이션뷰
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private SearchPage fragmentSearch = new SearchPage();
    private HomePage fragmentHome = new HomePage();
    private CafePage fragmentCafe = new CafePage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 바텀네비게이션
        BottomNavigationView bottomNav = findViewById(R.id.navigationView);
        bottomNav.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        this.InitializeLayout(); // 툴바

        this.viewpage(); // 뷰페이저

        //FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();
        // 바텀네비게이션

    }

    private void viewpage(){
        list = new ArrayList<>();
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
    //툴바
    private void InitializeLayout() {
        //toolBar를 통해 App Bar 생성
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //navigationView = (NavigationView) findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        actionBar.setDisplayHomeAsUpEnabled(true);  // 왼쪽 버튼 사용 여부 true
        actionBar.setHomeAsUpIndicator(R.drawable.ic_reorder_white_24dp);  // 왼쪽 버튼 이미지 설정
/*
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.nav_coffeedrink:
                        Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_dessert:
                        Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        Log.e("Frag", "Fragment");*/
    }

    //바텀네비
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.searchItem:
                    transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();
                    break;
                case R.id.homeItem:
                    transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.cafeItem:
                    transaction.replace(R.id.frameLayout, fragmentCafe).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }

    // 툴바 오른쪽 버튼
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                Toast.makeText(getApplicationContext(), "메뉴 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


