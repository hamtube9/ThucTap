package com.haiph.apivanlang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.haiph.apivanlang.model.PhatTu;
import com.haiph.apivanlang.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> {
    ArrayList<PhatTu> listUser;
    Context context;

    public ListUserAdapter(ArrayList<PhatTu> listUser, Context context) {
        this.listUser = listUser;
        this.context = context;
    }

    @NonNull
    @Override
    public ListUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserAdapter.ViewHolder holder, int position) {
        PhatTu phatTu = listUser.get(position);
        holder.tvName.setText("Họ và tên : "+phatTu.getName());
        holder.tvID.setText("Mã ID : "+phatTu.getId());
        holder.tvDiaChi.setText("Địa chỉ : "+phatTu.getDiachi());
        holder.tvDienThoai.setText("Điện thoại : "+phatTu.getDienthoai());

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvID, tvDiaChi, tvDienThoai;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);

            tvDiaChi = itemView.findViewById(R.id.tvDiaChi);
            tvDienThoai = itemView.findViewById(R.id.tvDienThoai);
        }
    }


}
