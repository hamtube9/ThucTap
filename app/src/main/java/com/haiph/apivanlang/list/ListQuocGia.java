package com.haiph.apivanlang.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.Service.OkHttpService;
import com.haiph.apivanlang.Service.RetrofitService;
import com.haiph.apivanlang.adapter.AdapterQuocGia;
import com.haiph.apivanlang.model.DuLieuThongKe;
import com.haiph.apivanlang.model.QuocGia;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListQuocGia extends AppCompatActivity {
    RecyclerView rcView;
    AdapterQuocGia adapterQuocGia;
    List<QuocGia> list;
    String token = "Bearer KpWPsSPjIfNNbG60isArijFmcZclhPuvQa9LlUOYl2hdOLnKP10goRYW4Pgw5gXnIqiiJTyI_WSPI_4ZdKvulDjhMdaG9B0E_UmDDs2O4Jim3jvTr2nMIkPpk03jlWIzPqTuu_OXs5MiU3Q-qH_UtTROMfLEGc05gmnN8wjQg3cndDwx3Z9I2keatx8gHtzzj59d6Fx8FFXfRLDGvBmRvGniSmvwAmgKzr89L-Bd61GwH0oow4_cUGU8-W-PThF0zvfAvQocjJmNm-nZO71_R5c3Kket2bPKP9JqP6ehlmU-YAo2dzu8VRdbwJsKBRLekGY4-GZa0OxdXxGyVT3GEtuHTwlMKs3NQB-4j9-jcbZuLQS-s7d_Tq4qCJEZD95_p8QU4GiK5ld9mFszVjvm-zHUlcbjuQaizKM6eZbMXSIvhZJO2Jk0zvbFvKk86P75L45HeTMCt6BNcIAChTqgzJxjG5dNHYi3a0yRAAan4UmBvLDJnYUWSiEZdlCVCPYjVXm3h7zdiacL_CZp66xJK2vbGMsWv5kE-3P57iCW_44";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_quoc_gia);
        rcView=findViewById(R.id.rcQuocGia);
        list=new ArrayList<>();
        adapterQuocGia=new AdapterQuocGia(list,getApplicationContext());
        rcView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcView.setAdapter(adapterQuocGia);

        getQuocGia();

    }

    private void getQuocGia() {
        OkHttpService.getService().getQuocGia(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){

                    try {
                        String dulieu =response.body().string();
                        JSONObject objectDuLieu = new JSONObject(dulieu);
                        JSONArray arrayDulieu = objectDuLieu.getJSONArray("data");
                        for (int i=0;i<arrayDulieu.length();i++){
                            JSONObject object = arrayDulieu.getJSONObject(i);

                            String ten = object.getString("ten");
                            QuocGia duLieuThongKe =new QuocGia(ten);
                            list.add(duLieuThongKe);
                            adapterQuocGia.notifyDataSetChanged();
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
