package com.haiph.apivanlang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.model.DuLieuThongKe;

import java.util.List;

public class AdapterDuLieuThongKe extends RecyclerView.Adapter<AdapterDuLieuThongKe.ViewHolder> {
    List<DuLieuThongKe> list ;
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_du_lieu_thong_ke, parent, false);
        return new ViewHolder(view);
    }

    public AdapterDuLieuThongKe(List<DuLieuThongKe> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DuLieuThongKe duLieuThongKe = list.get(position);
        holder.tenSuKien.setText(duLieuThongKe.getTenSuKien());
        holder.idSukien.setText(duLieuThongKe.getId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tenSuKien,idSukien;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenSuKien=itemView.findViewById(R.id.tenSuKien);
            idSukien=itemView.findViewById(R.id.idSuKien);
        }
    }
}
