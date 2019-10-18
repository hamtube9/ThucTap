package com.haiph.apivanlang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.Service.RetrofitService;
import com.haiph.apivanlang.model.Token;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUserName, edtPassword;
    private Button btnLogin, btnGotoRegister;
    private ImageView btnshow;
    boolean check;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        showPassword();
        restoringPreferences();
        edtUserName.setText(sharedPreferences.getString("username", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));





        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();


                if ((username.isEmpty()) || (password.isEmpty())) {
                    Toast.makeText(LoginActivity.this, "Hãy điền đầy đủ username và password", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!username.equals("admin") || !password.equals("1")) {
                    Toast.makeText(LoginActivity.this, "Sai thông tin", Toast.LENGTH_SHORT).show();

                } else {
                    getToken();
                   sharedPreferences = getSharedPreferences("APIVanLang",MODE_PRIVATE);
                   editor = sharedPreferences.edit();
                   editor.putString("username",edtUserName.getText().toString());
                   editor.putString("password",edtPassword.getText().toString());

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

                    startActivity(intent);
                }
            }
        });
    }


    private void showPassword() {
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == false) {
                    check = true;
                    btnshow.setImageResource(R.drawable.eye);
                    edtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    btnshow.setImageResource(R.drawable.hide);
                    edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    check = false;
                }
            }
        });
    }




    public void restoringPreferences() {
        sharedPreferences = getSharedPreferences("apiVanLang", MODE_PRIVATE);

        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        edtPassword.setText(password);
        edtUserName.setText(username);
    }


    private void initView() {
        edtPassword = findViewById(R.id.edtPassword);
        edtUserName = findViewById(R.id.edtUserName);
        btnshow = findViewById(R.id.btnShow);
        btnLogin = findViewById(R.id.btnLogin);


    }


    public void getToken() {
        RetrofitService.getInstance().getToken("password","admin",edtPassword.getText().toString()).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
            if (response.isSuccessful())
            {
                response.body();

                sharedPreferences = getSharedPreferences("apiVanLang", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("username", response.body().getUserName());
                token = String.valueOf(editor.putString("token",""+response.body().getAccessToken()));

                editor.commit();
                Log.e("token",""+token);
                Log.e("username",""+response.body().getUserName());
            }

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.e("err",t.getMessage());
            }
        });
    }
}
