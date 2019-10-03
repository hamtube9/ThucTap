package com.haiph.apivanlang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class SignInActivity extends AppCompatActivity {
    private EditText edtUserNameRegister,edtPassworRegister;
    private Button btnRegister;
    CheckBox chboxLoginNow;
    ImageView btnShowPasswordRegister;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();
        showPassword();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chboxLoginNow.isChecked()){
                    savePreferences();
                    Intent intent=new Intent(SignInActivity.this,LoginActivity.class);
                    intent.putExtra("username",edtUserNameRegister.getText().toString());
                    intent.putExtra("password",edtPassworRegister.getText().toString());
                    intent.putExtra("checked",true);
                    startActivity(intent);
                }else if (!chboxLoginNow.isChecked()){
                    Intent intent=new Intent(SignInActivity.this,LoginActivity.class);
                    intent.putExtra("username",edtUserNameRegister.getText().toString());
                    intent.putExtra("password",edtPassworRegister.getText().toString());
                    intent.putExtra("checked",false);
                    startActivity(intent);
                }
            }
        });
    }

    private void initView() {
        edtPassworRegister=findViewById(R.id.edtPassworRegister);
        edtUserNameRegister=findViewById(R.id.edtUserNameRegister);
        btnRegister=findViewById(R.id.btnRegister);
        btnShowPasswordRegister=findViewById(R.id.btnShowPasswordRegister);
        chboxLoginNow=findViewById(R.id.checkboxLoginNow);
    }
    private void showPassword() {
        btnShowPasswordRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == false) {
                    check = true;
                    btnShowPasswordRegister.setImageResource(R.drawable.eye);
                    edtPassworRegister.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    btnShowPasswordRegister.setImageResource(R.drawable.hide);
                    edtPassworRegister.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    check = false;
                }
            }
        });
    }

    public void savePreferences() {

        sharedPreferences = getSharedPreferences("userlogin", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String username = edtUserNameRegister.getText().toString();
        String password = edtPassworRegister.getText().toString();
        boolean check = chboxLoginNow.isChecked();
        if (!check) {
            editor.clear();
        }else {
            editor.putString("username", username);
            editor.putString("password", password);
            editor.putBoolean("checked",true);
        }
        editor.commit();

    }
}
