package com.haiph.apivanlang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.Service.OkHttpService;
import com.haiph.apivanlang.model.PhatTu;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditUserActivity extends AppCompatActivity {
    EditText edtEditPhone, edtEditTenUser, edtEditDiaChi;
    Button btnEditUser;
    Toolbar toolbarEditUser;
    List<PhatTu> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        initView();
        Intent i = getIntent();
        final String id = i.getStringExtra("id");
        String name = i.getStringExtra("name");
        String phone = i.getStringExtra("phone");
        String diachi = i.getStringExtra("diachi");
        edtEditDiaChi.setText(diachi);
        edtEditPhone.setText(phone);
        edtEditTenUser.setText(name);
        Log.e("id", id + " " + name + " " + phone + " " + diachi);
        list = new ArrayList<>();

        btnEditUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameNew = edtEditTenUser.getText().toString();
                String diachiNew = edtEditDiaChi.getText().toString();
                String phoneNew = edtEditPhone.getText().toString();
                PhatTu phatTu = new PhatTu(id, nameNew, diachiNew, phoneNew);
                list.add(phatTu);
                EditData(nameNew, diachiNew, phoneNew);
                Intent i = new Intent(EditUserActivity.this,ListUserActivity.class);
                startActivity(i);
            }
        });

    }

    private void EditData(String name, String diachi, String phone) {
        Intent i = getIntent();
        String tokenEdit = i.getStringExtra("token");
        String idUserEdit = i.getStringExtra("id");
        OkHttpService.getService().postEditPhatTu(tokenEdit, idUserEdit, "", "", "", "", name, "", "", "", phone, diachi, "",
                "", "", "", "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    response.body();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void initView() {
        edtEditDiaChi = findViewById(R.id.edtEditDiaChi);
        edtEditPhone = findViewById(R.id.edtEditPhone);
        edtEditTenUser = findViewById(R.id.edtEditTenUser);
        btnEditUser = findViewById(R.id.btnEditUser);
        toolbarEditUser = findViewById(R.id.toolbarEditUser);
        setSupportActionBar(toolbarEditUser);
        toolbarEditUser.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditUserActivity.this, ListUserActivity.class);
                startActivity(i);
            }
        });
        toolbarEditUser.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
    }
}
