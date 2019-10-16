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

public class HomeActivity extends AppCompatActivity {
    private TextView tvUsername,tvAddUser,tvListPhatTu,tvDuLieuThongKe;
    private ImageView imgListPhatTu,imgAddPhatTu,imgDuLieuThongKe;
    SharedPreferences sharedPreferences;
    Toolbar toolbar;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
        final      String token =data;
        Log.e("tokenLogin",token+"");
        tvUsername.setText("Chào mừng "+username+" quay trở lại");
        Log.e("usernameHome",""+username);

        restoringPreferences();
        imgListPhatTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(HomeActivity.this, ListUserActivity.class);
                intent1.putExtra("token1",token);

                Log.e("tokenIntent",""+token);

                startActivity(intent1);
            }
        });
        tvListPhatTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(HomeActivity.this,ListUserActivity.class);
                intent1.putExtra("token1",token);

                Log.e("tokenIntent",""+token);

                startActivity(intent1);
            }
        });
        imgDuLieuThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(HomeActivity.this, DuLieuThongKeActivity.class);
                intent1.putExtra("token1",token);


                startActivity(intent1);
            }
        });
        tvDuLieuThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(HomeActivity.this,DuLieuThongKeActivity.class);
                intent1.putExtra("token1",token);

                Log.e("tokenIntent",""+token);

                startActivity(intent1);
            }
        });

        imgAddPhatTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(HomeActivity.this,AddUserActivity.class);
                intent1.putExtra("token1",token);

                Log.e("tokenIntent",""+token);

                startActivity(intent1);
            }
        });

        tvAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(HomeActivity.this,AddUserActivity.class);
                intent1.putExtra("token1",token);

                Log.e("tokenIntent",""+token);

                startActivity(intent1);
            }
        });

    }

    public void restoringPreferences() {

    }

}
