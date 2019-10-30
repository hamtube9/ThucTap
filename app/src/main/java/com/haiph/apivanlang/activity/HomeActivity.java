package com.haiph.apivanlang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.list.DuLieuThongKeActivity;
import com.haiph.apivanlang.list.ListUserActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvUsername,tvAddUser,tvListPhatTu,tvDuLieuThongKe;
    private ImageView imgListPhatTu,imgAddPhatTu,imgDuLieuThongKe;
    private SharedPreferences sharedPreferences;
    private Toolbar toolbar;
    private SharedPreferences.Editor editor;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();


    }

    private void initView() {
        toolbar=findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);
        tvDuLieuThongKe=findViewById(R.id.tvDuLieuThongKe);
        imgDuLieuThongKe=findViewById(R.id.imgDuLieuThongKe);
        tvUsername=findViewById(R.id.tvUsername);
        imgAddPhatTu=findViewById(R.id.imgAddUser);
        imgListPhatTu=findViewById(R.id.imgListPhatTu);
        tvAddUser=findViewById(R.id.tvAddUser);
        tvListPhatTu=findViewById(R.id.tvListPhatTu);
        sharedPreferences = getSharedPreferences("apiVanLang", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String data = sharedPreferences.getString("token","");
        token=data;
        Log.e("tokenLogin",token+"");
        tvUsername.setText("Chào mừng "+username+" quay trở lại");
        Log.e("usernameHome",""+username);
        imgListPhatTu.setOnClickListener(this);
        tvListPhatTu.setOnClickListener(this);
        imgDuLieuThongKe.setOnClickListener(this);
        tvDuLieuThongKe.setOnClickListener(this);
        imgAddPhatTu.setOnClickListener(this);
        tvAddUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgAddUser:
                Intent intent1=new Intent(HomeActivity.this,AddUserActivity.class);
                intent1.putExtra("token1",token);

                Log.e("tokenIntent",""+token);

                startActivity(intent1);
                break;
            case R.id.tvAddUser:
                Intent intent2=new Intent(HomeActivity.this,AddUserActivity.class);
                intent2.putExtra("token1",token);

                Log.e("tokenIntent",""+token);

                startActivity(intent2);
                break;
            case R.id.tvListPhatTu:
                Intent intent3=new Intent(HomeActivity.this,ListUserActivity.class);
                intent3.putExtra("token1",token);

                Log.e("tokenIntent",""+token);

                startActivity(intent3);
                break;
            case R.id.imgListPhatTu:
                Intent intent4=new Intent(HomeActivity.this, ListUserActivity.class);
                intent4.putExtra("token1",token);

                Log.e("tokenIntent",""+token);

                startActivity(intent4);
                break;

        }
    }



}
