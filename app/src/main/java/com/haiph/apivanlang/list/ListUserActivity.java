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
    RecyclerView rcView;
    ListUserAdapter adapter;
    Toolbar toolbar;
    ArrayList<PhatTu> list = new ArrayList<>();
    PhatTu phatTu;
    // String token = "Bearer KpWPsSPjIfNNbG60isArijFmcZclhPuvQa9LlUOYl2hdOLnKP10goRYW4Pgw5gXnIqiiJTyI_WSPI_4ZdKvulDjhMdaG9B0E_UmDDs2O4Jim3jvTr2nMIkPpk03jlWIzPqTuu_OXs5MiU3Q-qH_UtTROMfLEGc05gmnN8wjQg3cndDwx3Z9I2keatx8gHtzzj59d6Fx8FFXfRLDGvBmRvGniSmvwAmgKzr89L-Bd61GwH0oow4_cUGU8-W-PThF0zvfAvQocjJmNm-nZO71_R5c3Kket2bPKP9JqP6ehlmU-YAo2dzu8VRdbwJsKBRLekGY4-GZa0OxdXxGyVT3GEtuHTwlMKs3NQB-4j9-jcbZuLQS-s7d_Tq4qCJEZD95_p8QU4GiK5ld9mFszVjvm-zHUlcbjuQaizKM6eZbMXSIvhZJO2Jk0zvbFvKk86P75L45HeTMCt6BNcIAChTqgzJxjG5dNHYi3a0yRAAan4UmBvLDJnYUWSiEZdlCVCPYjVXm3h7zdiacL_CZp66xJK2vbGMsWv5kE-3P57iCW_44";
    Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListUserActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        rcView = findViewById(R.id.rcView);
        rcView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
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
        rcView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        getUser();

    }



    private void getUser() {
        Intent i = getIntent();
        String token = i.getStringExtra("token1");
        final String tokenList = "Bearer " + token;
        Log.e("logToken", "" + tokenList);
//
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                Request newRequest = chain.request().newBuilder()
//                        .addHeader("Authorization", tokenList)
//                        .build();
//                return chain.proceed(newRequest);
//            }
//        }).build();
//
//        Retrofit.Builder buider = new Retrofit.Builder()
//                .baseUrl("http://api.testqlpt.vla.vn")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = buider.build();
//
//        service = retrofit.create(Service.class);

            RetrofitService.getInstance().getFromDateToDate(tokenList,"2019-08-01","2019-10-20").enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()){

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
                                Log.e("nameOb", "name : " + name + "/n id " + id + "/n địa chỉ : " + diachi + "/n điện thoại " + dienthoai);
                                phatTu = new PhatTu(name, phapdanh, diachi, dienthoai, cmt, id);

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
        String token = "Bearer "+ data;
        Log.e("delete",""+token);
        RetrofitService.getInstance().deletePhatTu(token, idPhatTu).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    list.remove(response.body());

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}







