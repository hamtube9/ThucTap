package com.haiph.apivanlang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.model.Tinh;

import java.util.List;

public class AdapterTinh extends RecyclerView.Adapter<AdapterTinh.ViewHolder> {
    List<Tinh> list;
    Context context;

    public AdapterTinh(List<Tinh> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_tinh, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTinh.setText(list.get(position).getTenTinh());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTinh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTinh=itemView.findViewById(R.id.tvTinh);
        }
    }
}
