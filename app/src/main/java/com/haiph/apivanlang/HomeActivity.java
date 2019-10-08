package com.haiph.apivanlang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUsername,tvListPhatTu;
    private ImageView imgListPhatTu;
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
        tvListPhatTu=findViewById(R.id.tvListPhatTu);
        imgListPhatTu=findViewById(R.id.imgListPhatTu);
        restoringPreferences();




        imgListPhatTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(HomeActivity.this,ListUserActivity.class);
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
