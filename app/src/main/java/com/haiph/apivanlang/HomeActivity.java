package com.haiph.apivanlang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUsername;
    private Button btnGoToListUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUsername=findViewById(R.id.tvUsername);
        btnGoToListUser=findViewById(R.id.btnGotoListUser);

        final Intent intent = getIntent();

        tvUsername.setText(intent.getStringExtra("name"));
        String token = intent.getStringExtra("token");
        Log.e("token","token : " +token);

        btnGoToListUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(HomeActivity.this,ListUserActivity.class);
                startActivity(intent1);
            }
        });

    }
}
