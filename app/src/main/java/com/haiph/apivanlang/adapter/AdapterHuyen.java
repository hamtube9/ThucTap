package com.haiph.apivanlang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.model.Huyen;

import java.util.List;

public class AdapterHuyen extends RecyclerView.Adapter<AdapterHuyen.ViewHolder> {
    List<Huyen> list;
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_huyen, parent, false);
        return null;
    }

    public AdapterHuyen(List<Huyen> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.tenHuyen.setText(list.get(position).getTenHuyen());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tenHuyen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenHuyen=itemView.findViewById(R.id.tenHuyen);
        }
    }
}
