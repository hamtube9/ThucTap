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
import com.haiph.apivanlang.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> {
    ArrayList<User> listUser;
    Context context;

    public ListUserAdapter(ArrayList<User> listUser, Context context) {
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
        User user = listUser.get(position);
        holder.tvName.setText(user.getData().get(position).getTen());
        holder.tvID.setText(user.getData().get(position).getId());
        holder.tvDiaChi.setText(user.getData().get(position).getDiaChi());
        holder.tvDienThoai.setText(user.getData().get(position).getSoDienThoai());
        //   Glide.with(context).load(user.getData().get(position).getLinkAnhDaiDien()).centerCrop().into(holder.imgUser);

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvID, tvDiaChi, tvDienThoai;
        ImageView imgUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            imgUser = itemView.findViewById(R.id.imgUser);
            tvDiaChi = itemView.findViewById(R.id.tvDiaChi);
            tvDienThoai = itemView.findViewById(R.id.tvDienThoai);
        }
    }

    public void updateData(List<User> list) {
        this.listUser.addAll(list);
        notifyDataSetChanged();
    }
}
