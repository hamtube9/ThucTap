package com.haiph.apivanlang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUserName, edtPassword;
    private Button btnLogin;
    private ImageView btnshow;
    boolean check;
    private CheckBox checkBox;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String prefname = "userlogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        restoringPreferences();
        showPassword();
        edtUserName.setText(sharedPreferences.getString("username",""));
        edtPassword.setText(sharedPreferences.getString("password",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked", false));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();

                if ((username.isEmpty()) || (password.isEmpty())) {
                    Toast.makeText(LoginActivity.this, "Hãy điền đầy đủ username và password", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    savePreferences();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("name", username);
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

    public void savePreferences() {

         sharedPreferences = getSharedPreferences(prefname, MODE_PRIVATE);
      editor = sharedPreferences.edit();

        String username = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        boolean check = checkBox.isChecked();
        if (!check) {
            editor.clear();
        }else {
            editor.putString("username", username);
            editor.putString("password", password);
            editor.putBoolean("checked",true);
        }
        editor.commit();

    }

    public void restoringPreferences() {
         sharedPreferences = getSharedPreferences("userlogin", MODE_PRIVATE);
         boolean check = sharedPreferences.getBoolean("checked",false);
         if (check) {
             String username = sharedPreferences.getString("username", "");
             String password = sharedPreferences.getString("password", "");
             edtPassword.setText(password);
             edtUserName.setText(username);

         }
         checkBox.setChecked(check);

    }


    private void initView() {
        edtPassword = findViewById(R.id.edtPassword);
        edtUserName = findViewById(R.id.edtUserName);
        btnshow = findViewById(R.id.btnShow);
        btnLogin = findViewById(R.id.btnLogin);
        checkBox = findViewById(R.id.checkbox);
    }


}
