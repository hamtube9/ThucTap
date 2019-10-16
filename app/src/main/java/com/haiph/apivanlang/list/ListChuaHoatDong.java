package com.haiph.apivanlang.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.adapter.AdapterChuaHoatDong;
import com.haiph.apivanlang.model.ChuaHoatDong;

import java.util.ArrayList;
import java.util.List;

public class ListChuaHoatDong extends AppCompatActivity {
    RecyclerView rcChua;
    List<ChuaHoatDong> list;
    AdapterChuaHoatDong adapterChuaHoatDong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chua_hoat_dong);
        rcChua = findViewById(R.id.rcChua);
        list = new ArrayList<>();
        adapterChuaHoatDong = new AdapterChuaHoatDong(list, getApplicationContext());
        rcChua.setAdapter(adapterChuaHoatDong);
        rcChua.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
