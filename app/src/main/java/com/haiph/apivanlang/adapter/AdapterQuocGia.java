package com.haiph.apivanlang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.model.QuocGia;

import java.util.List;

public class AdapterQuocGia extends RecyclerView.Adapter<AdapterQuocGia.ViewHolder> {
    List<QuocGia> list;
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_quoc_gia, parent, false);
        return new ViewHolder(view);
    }

    public AdapterQuocGia(List<QuocGia> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvQuocGia.setText(list.get(position).getTenQuocGia());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuocGia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuocGia=itemView.findViewById(R.id.tvQuocGia);
        }
    }
}
