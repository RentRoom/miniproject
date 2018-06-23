package com.example.administrator.qfindhouse;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.tencent.tencentmap.mapsdk.maps.TencentMap;

//
//地图API需要更改其他文件添加依赖
// 参考：http://lbs.qq.com/android_v1/guide-project-setup.html
//
public class PublishRentRoomActivity extends AppCompatActivity {
    //both pages
    private Button headerBack,publishRentRoomButtonNext;
    //page1
    private EditText needEdit,publishRentRoomLocation;
    private ImageView addImage;
    private Button setLocationButton;
    //page2
    private EditText budgetBegin,budgetEnd,liveTime;
    private Button publishRentRoomButton,wholeButton,partButton;
    //consistent variables
    private int budget_begin,budget_end;
    private long live_time;
    private boolean whole_bool,part_bool;
    private String need_edit,publish_rent_room_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init_var();
        setRentHome1();
    }
    private void addListener1(){
        headerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PublishRentRoomActivity.this,FindHouseMain.class);
                startActivity(intent);
            }
        });
        publishRentRoomButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRentHome2();
            }
        });
        needEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                need_edit=needEdit.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        publishRentRoomLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                publish_rent_room_location=publishRentRoomLocation.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        setLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add
            }
        });
    }
    private void addListener2(){
        headerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRentHome1();
            }
        });
        publishRentRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    publish();
                    Intent intent=new Intent(PublishRentRoomActivity.this,FindHouseMain.class);
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(PublishRentRoomActivity.this,"please fill in the blanks",Toast.LENGTH_SHORT).show();
                }
            }
        });
        wholeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(whole_bool){
                    whole_bool=false;
                    wholeButton.setBackgroundColor(Color.WHITE);
                }else{
                    whole_bool=true;
                    wholeButton.setBackgroundColor(Color.BLACK);
                    part_bool=false;
                    partButton.setBackgroundColor(Color.WHITE);
                }
            }
        });
        partButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(part_bool){
                    part_bool=false;
                    partButton.setBackgroundColor(Color.WHITE);
                }else{
                    part_bool=true;
                    partButton.setBackgroundColor(Color.BLACK);
                    whole_bool=false;
                    wholeButton.setBackgroundColor(Color.WHITE);
                }
            }
        });
        budgetBegin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    budget_begin = Integer.parseInt(budgetBegin.getText().toString());
                }catch (Exception e){
                    ;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        budgetEnd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    budget_end = Integer.parseInt(budgetEnd.getText().toString());
                }catch(Exception e){
                    ;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        liveTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    live_time = Long.parseLong(liveTime.getText().toString());
                }catch (Exception e){
                    ;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void init_var(){
        whole_bool=false;
        part_bool=false;
        need_edit="";
        publish_rent_room_location="";
        budget_begin=0;
        budget_end=0;
        live_time=0;
    }
    private void setRentHome1(){
        setContentView(R.layout.publish_rent_room);
        headerBack=findViewById(R.id.header_back);
        needEdit=findViewById(R.id.need_edit);
        addImage=findViewById(R.id.add_image);
        publishRentRoomButtonNext=findViewById(R.id.publish_rent_room_button_next);
        publishRentRoomLocation=findViewById(R.id.publish_rent_room_location);
        setLocationButton=findViewById(R.id.set_location_button);
        //restore var
        needEdit.setText(need_edit);
        publishRentRoomLocation.setText(publish_rent_room_location);
        addListener1();
    }
    private void setRentHome2(){
        setContentView(R.layout.publish_rent_room_next);
        headerBack=findViewById(R.id.header_back);
        publishRentRoomButton=findViewById(R.id.publish_rent_room_button_finish);
        wholeButton=findViewById(R.id.whole_button);
        partButton=findViewById(R.id.part_button);
        budgetBegin=findViewById(R.id.budget_begin);
        budgetEnd=findViewById(R.id.budget_end);
        liveTime=findViewById(R.id.live_time);
        //restore var
        //budgetBegin.setText(String.valueOf(budget_begin));
        //budgetEnd.setText(String.valueOf(budget_end));
        //liveTime.setText(String.valueOf(live_time));
        //if(whole_bool){
        //    wholeButton.setBackgroundColor(Color.BLACK);
        //}
        //if(part_bool){
        //    partButton.setBackgroundColor(Color.BLACK);
        //}
        addListener2();
    }
    private void publish(){
        budget_begin = Integer.parseInt(budgetBegin.getText().toString());
        budget_end = Integer.parseInt(budgetEnd.getText().toString());
        live_time = Long.parseLong(liveTime.getText().toString());
    }
}
