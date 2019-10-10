package com.haiph.apivanlang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.Service.OkHttpService;
import com.haiph.apivanlang.model.PhatTu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edtTenUser, edtDiaChi, edtSoDienThoai, edtID;
    private Button btnAddUser;
    List<PhatTu> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        initView();

        list = new ArrayList<>();


        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String ID = edtID.getText().toString();
                 String Ten = edtTenUser.getText().toString();
                 String DiaChi = edtDiaChi.getText().toString();
                 String SoDienThoai = edtSoDienThoai.getText().toString();
                PhatTu phatTu=new PhatTu(ID,Ten,DiaChi,SoDienThoai);
                list.add(phatTu);
               AddUser(ID,Ten,DiaChi,SoDienThoai);

               Intent i = new Intent(AddUserActivity.this,ListUserActivity.class);
               startActivity(i);

            }
        });
    }

    private void AddUser(String ID, String Ten, String DiaChi, String SoDienThoai) {
        SharedPreferences sharedPreferences= getSharedPreferences("apiVanLang",MODE_PRIVATE);
        String token = sharedPreferences.getString("token","");
        Log.e("tokenAddUser","token : "+token);
        OkHttpService.getService().postNewPhatTu(token,ID,"","","",
                "",Ten,"","","",SoDienThoai,DiaChi,"","","","","","","","","","","","","","","",
                "","","","","","","","","","",
                "", "","","","").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.e("dataAdd","data : "+response.body());

                    Toast.makeText(AddUserActivity.this, "Success", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(AddUserActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarAddUser);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Thêm Phật Tử");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddUserActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtTenUser = findViewById(R.id.edtTenUser);
        edtSoDienThoai = findViewById(R.id.edtPhone);
        edtID = findViewById(R.id.edtID);
        btnAddUser = findViewById(R.id.btnAddUser);



    }
}
