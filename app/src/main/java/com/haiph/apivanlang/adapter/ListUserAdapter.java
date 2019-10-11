package com.haiph.apivanlang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.model.PhatTu;

import java.util.ArrayList;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> {
    ArrayList<PhatTu> listUser;
    Context context;
    ItemOnclick i;


    public ListUserAdapter(ArrayList<PhatTu> listUser, Context context,ItemOnclick i) {
        this.listUser = listUser;
        this.context = context;
        this.i=i;
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
        holder.tvName.setText("Họ và tên : "+phatTu.getName());
        holder.tvID.setText("Mã ID : "+phatTu.getId());
        holder.tvDiaChi.setText("Địa chỉ : "+phatTu.getDiachi());
        holder.tvDienThoai.setText("Điện thoại : "+phatTu.getDienthoai());
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
        TextView tvName, tvID, tvDiaChi, tvDienThoai;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            cardView=itemView.findViewById(R.id.cardViewUser);
            tvDiaChi = itemView.findViewById(R.id.tvDiaChi);
            tvDienThoai = itemView.findViewById(R.id.tvDienThoai);
        }
    }


}
