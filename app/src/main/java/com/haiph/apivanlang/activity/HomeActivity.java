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

public class HomeActivity extends AppCompatActivity {
    private TextView tvUsername,tvAddUser,tvListPhatTu;
    private ImageView imgListPhatTu,imgAddPhatTu;
    SharedPreferences sharedPreferences;
    Toolbar toolbar;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);
        tvUsername=findViewById(R.id.tvUsername);
        imgAddPhatTu=findViewById(R.id.imgAddUser);
        imgListPhatTu=findViewById(R.id.imgListPhatTu);
        tvAddUser=findViewById(R.id.tvAddUser);
        tvListPhatTu=findViewById(R.id.tvListPhatTu);

        restoringPreferences();
        imgListPhatTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(HomeActivity.this, ListUserActivity.class);
                sharedPreferences = getSharedPreferences("apiVanlang",MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("token",sharedPreferences.getString("token",""));
                startActivity(intent1);
            }
        });
        tvListPhatTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(HomeActivity.this,ListUserActivity.class);
                sharedPreferences = getSharedPreferences("apiVanlang",MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("token",sharedPreferences.getString("token",""));
                startActivity(intent1);
            }
        });

        imgAddPhatTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(HomeActivity.this,AddUserActivity.class);
                sharedPreferences = getSharedPreferences("apiVanlang",MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("token",sharedPreferences.getString("token",""));
                startActivity(intent1);
            }
        });

        tvAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(HomeActivity.this,AddUserActivity.class);
                sharedPreferences = getSharedPreferences("apiVanlang",MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("token",sharedPreferences.getString("token",""));
                startActivity(intent1);
            }
        });

    }

    public void restoringPreferences() {
        sharedPreferences = getSharedPreferences("apiVanLang", MODE_PRIVATE);

        String username = sharedPreferences.getString("username", "");
        String token = sharedPreferences.getString("token","");

       tvUsername.setText("Chào mừng "+username+" quay trở lại");
       Log.e("usernameHome",""+username);
       Log.e("tokenHome",""+token);
    }

}
