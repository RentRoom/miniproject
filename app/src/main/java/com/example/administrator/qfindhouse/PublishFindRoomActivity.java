package com.example.administrator.qfindhouse;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.view.MotionEvent;
import android.widget.DatePicker;
import java.util.Calendar;

public class PublishFindRoomActivity extends AppCompatActivity {
    private Button headerBack,publishFindRoomButton,wholeButton,partButton;
    private EditText budgetBegin,budgetEnd,liveTime,needEdit;
    private int budget_begin,budget_end;
    private long live_time;
    private boolean whole_bool,part_bool;
    String need_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publish_find_room);
        headerBack=findViewById(R.id.header_back);
        publishFindRoomButton=findViewById(R.id.publish_find_room_button);
        wholeButton=findViewById(R.id.whole_button);
        partButton=findViewById(R.id.part_button);
        budgetBegin=findViewById(R.id.budget_begin);
        budgetEnd=findViewById(R.id.budget_end);
        liveTime=findViewById(R.id.live_time);
        needEdit=findViewById(R.id.need_edit);
        whole_bool=false;
        part_bool=false;
        need_edit="";
        headerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PublishFindRoomActivity.this,FindHouseMain.class);
                startActivity(intent);
            }
        });
        publishFindRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publish();
                Intent intent=new Intent(PublishFindRoomActivity.this,FindHouseMain.class);
                startActivity(intent);
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
        liveTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    showDatePickDlg();
                    return true;
                    }
                    return false;

            }
        });
        liveTime.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    showDatePickDlg();
                    }
            }
        });
    }

    protected void showDatePickDlg() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(PublishFindRoomActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                PublishFindRoomActivity.this.liveTime.setText(year + "年" + monthOfYear + "月" + dayOfMonth + "日");
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

        private void publish(){
        budget_begin=Integer.parseInt(budgetBegin.getText().toString());
        budget_end=Integer.parseInt(budgetEnd.getText().toString());
        live_time=Long.parseLong(liveTime.getText().toString());
        need_edit=needEdit.getText().toString();
    }
}
