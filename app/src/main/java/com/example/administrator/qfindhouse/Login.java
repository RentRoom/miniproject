package com.example.administrator.qfindhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;

public class Login extends AppCompatActivity {

    EditText loginName;
    EditText passWord;
    Button loginButton;
    CheckBox checkBox;
    public static final int RESULTOK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Permission.verifyStoragePermissions(this);
        init();
        setLoginButton();


    }
    void init()
    {
        loginName = (EditText)findViewById(R.id.user_name);
        passWord = (EditText)findViewById(R.id.user_pass);
        loginButton = (Button)findViewById(R.id.login_button);
        checkBox = (CheckBox) findViewById(R.id.is_checked);
    }
    Boolean checkRight(String loginName,String pass)
    {
        if(loginName.length() == 0 || pass.length() == 0 )
        {
            Toast.makeText(Login.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }
        //检查在数据库内是否存在
        return true;
    }

    void setLoginButton()
    {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = loginName.getText().toString();
                String pass = passWord.getText().toString();
                if(!checkBox.isChecked()) {
                    Toast.makeText(Login.this,"请确认同意隐私协议！",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(checkRight(name,pass))
                    {
                        Intent intent = new Intent(Login.this,FindHouseMain.class);
                        intent.putExtra("loginUser",name);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(Login.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}
