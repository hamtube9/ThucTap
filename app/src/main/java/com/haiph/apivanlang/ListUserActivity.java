package com.haiph.apivanlang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.haiph.apivanlang.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserActivity extends AppCompatActivity {
    RecyclerView rcView;
    ListUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        rcView=findViewById(R.id.rcView);
        rcView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final ArrayList<User> list = new ArrayList<>();
        adapter = new ListUserAdapter(list,getApplicationContext());
        rcView.setAdapter(adapter);
        getUser();

    }

    private void getUser() {
      RetrofitService.getInstance().getFromDateToDate("KpWPsSPjIfNNbG60isArijFmcZclhPuvQa9LlUOYl2hdOLnKP10goRYW4Pgw5gXnIqiiJTyI_WSPI_4ZdKvulDjhMdaG9B0E_UmDDs2O4Jim3jvTr2nMIkPpk03jlWIzPqTuu_OXs5MiU3Q-qH_UtTROMfLEGc05gmnN8wjQg3cndDwx3Z9I2keatx8gHtzzj59d6Fx8FFXfRLDGvBmRvGniSmvwAmgKzr89L-Bd61GwH0oow4_cUGU8-W-PThF0zvfAvQocjJmNm-nZO71_R5c3Kket2bPKP9JqP6ehlmU-YAo2dzu8VRdbwJsKBRLekGY4-GZa0OxdXxGyVT3GEtuHTwlMKs3NQB-4j9-jcbZuLQS-s7d_Tq4qCJEZD95_p8QU4GiK5ld9mFszVjvm-zHUlcbjuQaizKM6eZbMXSIvhZJO2Jk0zvbFvKk86P75L45HeTMCt6BNcIAChTqgzJxjG5dNHYi3a0yRAAan4UmBvLDJnYUWSiEZdlCVCPYjVXm3h7zdiacL_CZp66xJK2vbGMsWv5kE-3P57iCW_44",
              "2019-08-01","2019-10-01").enqueue(new Callback<List<User>>() {
          @Override
          public void onResponse(Call<List<User>> call, Response<List<User>> response) {
              if (response.code()==200 && response.body()!= null) {

                Log.e("data", response.body().toString());
                adapter.updateData(response.body());

            }
          }

          @Override
          public void onFailure(Call<List<User>> call, Throwable t) {
              Log.e("err",t.getMessage());
          }
      });
    }
}
