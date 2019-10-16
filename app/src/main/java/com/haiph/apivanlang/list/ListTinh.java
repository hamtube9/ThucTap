package com.haiph.apivanlang.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.haiph.apivanlang.R;

public class ListTinh extends AppCompatActivity {
    RecyclerView rcTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tinh);
        rcTinh=findViewById(R.id.rcTinh);
    }
}
