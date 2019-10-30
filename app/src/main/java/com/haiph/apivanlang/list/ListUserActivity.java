package com.haiph.apivanlang.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.Service.OkHttpService;
import com.haiph.apivanlang.Service.RetrofitService;
import com.haiph.apivanlang.Service.Service;
import com.haiph.apivanlang.activity.HomeActivity;
import com.haiph.apivanlang.activity.UploadImageActivity;
import com.haiph.apivanlang.adapter.ListUserAdapter;
import com.haiph.apivanlang.model.PhatTu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListUserActivity extends AppCompatActivity {
    private RecyclerView rcView;
    private ListUserAdapter adapter;
    private Toolbar toolbar;
    private ArrayList<PhatTu> list = new ArrayList<>();
    private PhatTu phatTu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        initView();
        getUser();

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        rcView = findViewById(R.id.rcView);
        rcView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        onClick();
        rcView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void onClick() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListUserActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        adapter = new ListUserAdapter(list, getApplicationContext(), new ListUserAdapter.ItemOnclick() {
            @Override
            public void setOnclickItemSelect(final int position) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ListUserActivity.this);
                dialog.setTitle("Bạn muốn cập nhật ảnh hay xóa");
                dialog.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PhatTu phatTu = list.get(position);
                        String idPhatTu = phatTu.getId();
                        deleteUser(idPhatTu);
                        list.remove(idPhatTu);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(ListUserActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setPositiveButton("Sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//

                        Intent i = new Intent(ListUserActivity.this, UploadImageActivity.class);
                        startActivity(i);
                    }
                });
                dialog.show();
            }
        });
    }


    private void getUser() {
        Intent i = getIntent();
        String token = i.getStringExtra("token1");
        final String tokenList = "Bearer " + token;
        Log.e("logToken", "" + tokenList);
        RetrofitService.getInstance().getFromDateToDate(tokenList, "2019-08-01", "2019-10-30").enqueue(new Callback<ResponseBody>() {
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
                            String cmt = object.getString("socmtnd");
                            String phapdanh = object.getString("phapDanh");
                            String anh = object.getString("linkAnhDaiDien");
                            Log.e("anhdaidien", anh + "");
                            //   Log.e("nameOb", "name : " + name + "/n id " + id + "/n địa chỉ : " + diachi + "/n điện thoại " + dienthoai+" /n ảnh :"+anh);
                            phatTu = new PhatTu(name, phapdanh, diachi, dienthoai, cmt, id, anh);
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

            }
        });


    }


    private void deleteUser(String idPhatTu) {
        Intent i = getIntent();
        String data = i.getStringExtra("token1");
        String token = "Bearer " + data;
        Log.e("delete", "" + token);
        RetrofitService.getInstance().deletePhatTu(token, idPhatTu).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    list.remove(response.body());
                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}







