package com.example.administrator.qfindhouse;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class FindHouseMain extends AppCompatActivity {

    //首页
    private View homeFindHouseView,homeRentHouseView,navigationHomeView;
    private List<View> pageList;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private LayoutInflater inflater;

    private RecyclerView homeFindHouseRecyclerView, homeRentHouseRecyclerView;
    private SearchView homeSearchView;
    private TabLayout homeTabLayout;
    private TabItem rentHouseItem,findHouseItem;
    private FloatingActionButton publishMessage;


    private FragmentTransaction fragmentTransaction;//fragment事务
    private FragmentManager fragmentManager;//fragment管理者
    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private SettingFragment settingFragment;
    private BottomNavigationViewEx.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationViewEx.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //TODO
                    showHome();
                    return true;

                case R.id.navigation_message:
                    showMessage();
                    return true;

                case R.id.navigation_setting:
                    showSetting();
                    return true;

            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_house_main);
        init();
    }
    void init()
    {
        initFragmentManager();
        initNavigationBottom();
        initView();
        showHome();
        initViewPager();

        showHome();
    }

    void initFragmentManager()
    {
        fragmentManager = getSupportFragmentManager();
       //

    }

    void initNavigationBottom()
    {
        int[][] states = new int[][]{
                new int[]{-android.R.attr.state_checked},
                new int[]{android.R.attr.state_checked}
        };
        int[] colors = new int[]{ContextCompat.getColor(this, R.color.colorWhiteGray),
                ContextCompat.getColor(this, R.color.colorBlack)};
        BottomNavigationViewEx navigation = (BottomNavigationViewEx) findViewById(R.id.navigation);
        navigation.enableAnimation(true);
        navigation.enableShiftingMode(false);
        navigation.enableItemShiftingMode(false);

        ColorStateList csl = new ColorStateList(states, colors);
        navigation.setItemTextColor(csl);
        navigation.setItemIconTintList(csl);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    void initViewPager()
    {
        inflater = getLayoutInflater();//.from(homeFragment.getContext());
        homeFindHouseView = inflater.inflate(R.layout.home_page_find_home,null);
        homeRentHouseView = inflater.inflate(R.layout.home_page_rent_home,null);
        navigationHomeView=inflater.inflate(R.layout.navigation_home,null);

        pageList = new ArrayList<>();
        pageList.add(homeFindHouseView);
        pageList.add(homeRentHouseView);

        viewPagerAdapter = new ViewPagerAdapter(pageList);
        viewPager = (ViewPager) navigationHomeView.findViewById(R.id.home_cur_pager);
        //viewPager = (ViewPager) findViewById(R.id.home_cur_pager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
    }
    void initView()
    {
        homeTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        rentHouseItem = (TabItem) findViewById(R.id.rent_tab_item);
        findHouseItem = (TabItem) findViewById(R.id.find_tab_item);
    }

    void showHome()
    {
        //FragmentManager manager = getSupportFragmentManager();

        //FragmentTransaction transaction = manager.beginTransaction();
        fragmentTransaction = fragmentManager.beginTransaction();
        if(messageFragment != null) fragmentTransaction.hide(messageFragment);
        if(settingFragment != null) fragmentTransaction.hide(settingFragment);
        homeFragment = new HomeFragment();
        fragmentTransaction.add(R.id.cur_frameLayout, homeFragment);
        fragmentTransaction.commit();
    }

    void showMessage()
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        if(homeFragment != null) fragmentTransaction.hide(homeFragment);
        if(settingFragment != null) fragmentTransaction.hide(settingFragment);
        messageFragment = new MessageFragment();
        fragmentTransaction.add(R.id.cur_frameLayout, messageFragment);
        fragmentTransaction.commit();
    }

    void showSetting()
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        if(homeFragment != null) fragmentTransaction.hide(homeFragment);
        if(messageFragment != null) fragmentTransaction.hide(messageFragment);
        settingFragment  = new SettingFragment();
        fragmentTransaction.add(R.id.cur_frameLayout, settingFragment);
        fragmentTransaction.commit();
    }
}
