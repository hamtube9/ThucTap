package com.haiph.apivanlang.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.JsonObject;
import com.haiph.apivanlang.R;
import com.haiph.apivanlang.Service.OkHttpService;
import com.haiph.apivanlang.Service.RetrofitService;
import com.haiph.apivanlang.adapter.AdapterDuLieuThongKe;
import com.haiph.apivanlang.model.DuLieuThongKe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DuLieuThongKeActivity extends AppCompatActivity {
    private AdapterDuLieuThongKe adapter;
     List<DuLieuThongKe>  list=new ArrayList<>();
    RecyclerView rcView;
    ;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du_lieu_thong_ke);
        rcView=findViewById(R.id.rcDuLieuThongKe);

        adapter=new AdapterDuLieuThongKe(list,getApplicationContext());
        rcView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcView.setAdapter(adapter);

        getDuLieu();
    }

    private void getDuLieu() {
        Intent i = getIntent();
        String token = i.getStringExtra("token");

        OkHttpService.getService().getDuLieu(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){


                    Log.e("dulieu",""+response.body());
                    try {
                        String dulieu =response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i=0;i<arrayDulieu.length();i++){
                            JSONObject object = arrayDulieu.getJSONObject(i);
                          int id = object.getInt("id");
                            String tenSuKien = object.getString("ten");
                            DuLieuThongKe duLieuThongKe =new DuLieuThongKe(tenSuKien,id);
                            list.add(duLieuThongKe);
                            adapter.notifyDataSetChanged();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
