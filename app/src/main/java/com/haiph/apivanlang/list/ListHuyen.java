package com.haiph.apivanlang.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.adapter.AdapterHuyen;
import com.haiph.apivanlang.model.Huyen;

import java.util.ArrayList;
import java.util.List;

public class ListHuyen extends AppCompatActivity {
    RecyclerView rcHuyen;
    AdapterHuyen adapterHuyen;
    List<Huyen> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_huyen);
        list=new ArrayList<>();
        rcHuyen=findViewById(R.id.rcHuyen);
        adapterHuyen=new AdapterHuyen(list,getApplicationContext());
        rcHuyen.setAdapter(adapterHuyen);
        rcHuyen.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
