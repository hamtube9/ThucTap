package com.haiph.apivanlang.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.adapter.AdapterXa;
import com.haiph.apivanlang.model.Xa;

import java.util.ArrayList;
import java.util.List;

public class ListXa extends AppCompatActivity {
    RecyclerView rcXa;
    List<Xa> list;
    AdapterXa adapterXa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_xa);
        rcXa=findViewById(R.id.rcXa);
        list=new ArrayList<>();
        adapterXa=new AdapterXa(list,getApplicationContext());
        rcXa.setAdapter(adapterXa);
        rcXa.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
