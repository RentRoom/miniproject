package com.example.administrator.qfindhouse;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

import java.util.List;

public class FindHouseMain extends AppCompatActivity {

    //首页
    private View homeFindHouseView,homeRentHouseView;
    private List<View> pageList;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;

    private RecyclerView homeFindHouseRecyclerView, homeRentHouseRecyclerView;
    private SearchView homeSearchView;
    private TabLayout homeTabLayout;
    private TabItem rentHouseItem,findHouseItem;
    private FloatingActionButton publishMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_house_main);
        initView();
    }
    void initView()
    {
        homeTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        rentHouseItem = (TabItem) findViewById(R.id.rent_tab_item);
        findHouseItem = (TabItem) findViewById(R.id.find_tab_item);
    }
}
