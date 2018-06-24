package com.example.administrator.qfindhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2018/6/17 0017.
 */
public class HomeFragment extends Fragment {
    private FloatingActionButton publishMessage;
    private View navigationHome;
    private TabLayout tabLayout;
    private CustomViewPager viewPager;
    private Button filterButton;
    private View rentView,findView,filterView; //三个viewpager显示的view
    private List<View> pageList;
    private ViewPagerAdapter viewPagerAdapter;
    private ImageView arrowImage;
    private static boolean flag = true; //筛选使用
    private static int beforeIndex = 0; //筛选返回使用

    //TODO 首页界面的声明，RecycleView相关

    //TODO 筛选界面的布局声明

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        navigationHome=inflater.inflate(R.layout.navigation_home,null);
        publishMessage=navigationHome.findViewById(R.id.add_message);
        tabLayout=navigationHome.findViewById(R.id.tab_layout);
        viewPager = navigationHome.findViewById(R.id.home_cur_pager);
        filterButton = navigationHome.findViewById(R.id.filter_button);
        //return inflater.inflate(R.layout.navigation_home, container, false);//wrong way
        rentView = inflater.inflate(R.layout.home_page_rent_home,null);
        findView = inflater.inflate(R.layout.home_page_find_home,null);
        filterView = inflater.inflate(R.layout.filter_layout,null);
        pageList = new ArrayList<>();
        pageList.add(rentView);
        pageList.add(findView);
        pageList.add(filterView);
        viewPagerAdapter = new ViewPagerAdapter(pageList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
        arrowImage = navigationHome.findViewById(R.id.arrow);

        initHomeLayout();
        initfilterLayout();

        return navigationHome;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        publishMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tabLayout.getSelectedTabPosition()==1){
                    Intent intent=new Intent(getActivity(),PublishFindRoomActivity.class);
                    startActivity(intent);
                }else if(tabLayout.getSelectedTabPosition()==0){
                    Intent intent=new Intent(getActivity(),PublishRentRoomActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),"fail",Toast.LENGTH_SHORT).show();
                }
            }
        });


        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag)
                {
                    beforeIndex = viewPager.getCurrentItem();
                    viewPager.setCurrentItem(2);
                    if(arrowImage != null)
                    {
                        arrowImage.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);//修改图标
                    }
                    flag = !flag;
                }
                else
                {
                    viewPager.setCurrentItem(beforeIndex);
                    if(arrowImage != null)
                    {
                        arrowImage.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);//修改图标
                    }
                    flag = !flag;
                }

            }
        });


        //TODO 点击事件放在这里
    }

    public void initHomeLayout()
    {

    }
    public void initfilterLayout()
    {

    }

}