package com.example.com.haoran20190120;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText reg_username;
    private EditText reg_passwrod;
    private EditText reg_password_again;
    private Button regist;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
    }

    private void initView() {
        reg_username = (EditText) findViewById(R.id.reg_username);
        reg_passwrod = (EditText) findViewById(R.id.reg_passwrod);
        reg_password_again = (EditText) findViewById(R.id.reg_password_again);
        regist = (Button) findViewById(R.id.regist);

        regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist://注册
                String password = reg_passwrod.getText().toString();
                String username = reg_username.getText().toString();
                String measure = reg_password_again.getText().toString();
                if (measure.equals(password)) {
                    sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("username", username);
                    edit.putString("password", password);
                    edit.commit();
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegActivity.this, MainActivity.class));

                } else {
                    Toast.makeText(this, "密码前后不统一", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void submit() {
        // validate
        String username = reg_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwrod = reg_passwrod.getText().toString().trim();
        if (TextUtils.isEmpty(passwrod)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String again = reg_password_again.getText().toString().trim();
        if (TextUtils.isEmpty(again)) {
            Toast.makeText(this, "请输密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
