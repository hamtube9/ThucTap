package com.haiph.apivanlang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.Service.OkHttpService;
import com.haiph.apivanlang.adapter.ListUserAdapter;
import com.haiph.apivanlang.model.PhatTu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivity extends AppCompatActivity {
    RecyclerView rcView;
    ListUserAdapter adapter;
    Toolbar toolbar;
    ArrayList<PhatTu> list = new ArrayList<>();
    String token = "Bearer KpWPsSPjIfNNbG60isArijFmcZclhPuvQa9LlUOYl2hdOLnKP10goRYW4Pgw5gXnIqiiJTyI_WSPI_4ZdKvulDjhMdaG9B0E_UmDDs2O4Jim3jvTr2nMIkPpk03jlWIzPqTuu_OXs5MiU3Q-qH_UtTROMfLEGc05gmnN8wjQg3cndDwx3Z9I2keatx8gHtzzj59d6Fx8FFXfRLDGvBmRvGniSmvwAmgKzr89L-Bd61GwH0oow4_cUGU8-W-PThF0zvfAvQocjJmNm-nZO71_R5c3Kket2bPKP9JqP6ehlmU-YAo2dzu8VRdbwJsKBRLekGY4-GZa0OxdXxGyVT3GEtuHTwlMKs3NQB-4j9-jcbZuLQS-s7d_Tq4qCJEZD95_p8QU4GiK5ld9mFszVjvm-zHUlcbjuQaizKM6eZbMXSIvhZJO2Jk0zvbFvKk86P75L45HeTMCt6BNcIAChTqgzJxjG5dNHYi3a0yRAAan4UmBvLDJnYUWSiEZdlCVCPYjVXm3h7zdiacL_CZp66xJK2vbGMsWv5kE-3P57iCW_44";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        toolbar=findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListUserActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        rcView = findViewById(R.id.rcView);
        rcView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new ListUserAdapter(list, getApplicationContext());
        rcView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        SharedPreferences sharedPreferences = getSharedPreferences("apiVanLang", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");
        Log.e("getTokenList", "" + token);
        getUser();

    }

    private void getUser() {
        OkHttpService.getService().getFromDateToDate(token, "2019-08-01", "2019-10-01").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String data = response.body().string();
                        JSONObject j = new JSONObject(data);
                        //      Log.e("data", j + "");
                        JSONArray array = j.getJSONArray("data");
                        //    Log.e("array",array+"");
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);
                            String name = object.getString("hoVaTen");
                            String id = object.getString("id");
                            String diachi = object.getString("diaChi");
                            String dienthoai = object.getString("soDienThoai");
                            Log.e("nameOb", "name : " + name + "/n id " + id + "/n địa chỉ : " + diachi + "/n điện thoại " + dienthoai);
                            PhatTu phatTu = new PhatTu(name, id, diachi, dienthoai);

                            list.add(phatTu);
                        }
                        adapter.notifyDataSetChanged();

                    } catch (Exception e) {
                        Log.e("exception", e + "");
                    }


                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("error", t.getMessage()+"");
            }
        });

    }
}









