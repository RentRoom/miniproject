package com.example.administrator.qfindhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by Administrator on 2018/6/17 0017.
 */
public class HomeFragment extends Fragment {
    private FloatingActionButton publishMessage;
    private View navigationHome;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        navigationHome=inflater.inflate(R.layout.navigation_home,null);
        publishMessage=navigationHome.findViewById(R.id.add_message);
        tabLayout=navigationHome.findViewById(R.id.tab_layout);
        viewPager = navigationHome.findViewById(R.id.home_cur_pager);

        //return inflater.inflate(R.layout.navigation_home, container, false);//wrong way
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
    }
}