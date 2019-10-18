package com.haiph.apivanlang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.model.Xa;

import java.util.List;

public class AdapterXa extends RecyclerView.Adapter<AdapterXa.ViewHolder> {
    List<Xa> list;
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_xa, parent, false);
        return new ViewHolder(view);
    }

    public AdapterXa(List<Xa> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvXa.setText(list.get(position).getTenXa());
        holder.idXa.setText(list.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvXa,idXa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvXa=itemView.findViewById(R.id.tvXa);
            idXa=itemView.findViewById(R.id.idXa);
        }
    }
}
