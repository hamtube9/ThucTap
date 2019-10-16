package com.haiph.apivanlang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.model.ChuaHoatDong;

import java.util.List;

public class AdapterChuaHoatDong extends RecyclerView.Adapter<AdapterChuaHoatDong.ViewHolder> {
    List<ChuaHoatDong> list;
    Context context;

    public AdapterChuaHoatDong(List<ChuaHoatDong> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_chua, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvChua.setText(list.get(position).getTenChua());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvChua;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChua = itemView.findViewById(R.id.tvChua);
        }
    }
}
