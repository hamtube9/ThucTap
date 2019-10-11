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

import org.json.JSONException;
import org.json.JSONObject;

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
    String token = "Bearer KpWPsSPjIfNNbG60isArijFmcZclhPuvQa9LlUOYl2hdOLnKP10goRYW4Pgw5gXnIqiiJTyI_WSPI_4ZdKvulDjhMdaG9B0E_UmDDs2O4Jim3jvTr2nMIkPpk03jlWIzPqTuu_OXs5MiU3Q-qH_UtTROMfLEGc05gmnN8wjQg3cndDwx3Z9I2keatx8gHtzzj59d6Fx8FFXfRLDGvBmRvGniSmvwAmgKzr89L-Bd61GwH0oow4_cUGU8-W-PThF0zvfAvQocjJmNm-nZO71_R5c3Kket2bPKP9JqP6ehlmU-YAo2dzu8VRdbwJsKBRLekGY4-GZa0OxdXxGyVT3GEtuHTwlMKs3NQB-4j9-jcbZuLQS-s7d_Tq4qCJEZD95_p8QU4GiK5ld9mFszVjvm-zHUlcbjuQaizKM6eZbMXSIvhZJO2Jk0zvbFvKk86P75L45HeTMCt6BNcIAChTqgzJxjG5dNHYi3a0yRAAan4UmBvLDJnYUWSiEZdlCVCPYjVXm3h7zdiacL_CZp66xJK2vbGMsWv5kE-3P57iCW_44";

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
                Log.e("list",""+list.add(phatTu));
               AddUser(ID,Ten,DiaChi,SoDienThoai);

               Intent i = new Intent(AddUserActivity.this,ListUserActivity.class);
               startActivity(i);

                Toast.makeText(AddUserActivity.this, "Phật tử : "+phatTu, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AddUser(final String ID, final String Ten, final String DiaChi, final String SoDienThoai) {

        Log.e("tokenAddUser","token : "+token);
        OkHttpService.getService().postNewPhatTu(token,ID,"","","",
                "",Ten,"","","",SoDienThoai,DiaChi,"","","","","","",
                "","","","","","","","","",
                "","","","","","","","","","",
                "", "","","","").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    response.body();

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
              Log.e("loiAddUser",t.getMessage());
            }
        });
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarAddUser);
        setSupportActionBar(toolbar);

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
