package com.haiph.apivanlang.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.haiph.apivanlang.R;
import com.haiph.apivanlang.model.PhatTu;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> {
    ArrayList<PhatTu> listUser;
    Context context;
    ItemOnclick i;


    public ListUserAdapter(ArrayList<PhatTu> listUser, Context context, ItemOnclick i) {
        this.listUser = listUser;
        this.context = context;
        this.i = i;

    }




    public interface ItemOnclick{
     public void setOnclickItemSelect(int position);
    }
    @NonNull
    @Override
    public ListUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserAdapter.ViewHolder holder, final int position) {
        PhatTu phatTu = listUser.get(position);
        holder.tvCMT.setText("CMT : "+phatTu.getCMT());
        holder.tvName.setText("Họ và tên : "+phatTu.getName());
        holder.tvPhapDanh.setText("Pháp danh : "+phatTu.getPhapDanh());
        holder.tvDiaChi.setText("Địa chỉ : "+phatTu.getDiachi());
        holder.tvDienThoai.setText("Điện thoại : "+phatTu.getDienthoai());

        Glide.with(context).load("http://api.testqlpt.vla.vn"+phatTu.getAnh())
                .centerCrop()
                .into(holder.imgUser);

        holder.tvID.setText("ID : "+phatTu.getId());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setOnclickItemSelect(position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhapDanh, tvDiaChi, tvDienThoai,tvCMT,tvID;
        ImageView imgUser ;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser=itemView.findViewById(R.id.imgUser);
            tvCMT=itemView.findViewById(R.id.tvCMT);
            tvID=itemView.findViewById(R.id.tvID);
            tvPhapDanh = itemView.findViewById(R.id.tvPhapDanh);
            tvName = itemView.findViewById(R.id.tvName);
            cardView=itemView.findViewById(R.id.cardViewUser);
            tvDiaChi = itemView.findViewById(R.id.tvDiaChi);
            tvDienThoai = itemView.findViewById(R.id.tvDienThoai);
        }
    }


}
