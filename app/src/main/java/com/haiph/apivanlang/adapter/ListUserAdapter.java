package com.haiph.apivanlang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.haiph.apivanlang.R;
import com.haiph.apivanlang.model.PhatTu;

import java.util.ArrayList;
import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> implements Filterable {
    ArrayList<PhatTu> listUser;
    ArrayList<PhatTu> filterListUser;
    Context context;
    ItemOnclick i;


    public ListUserAdapter(ArrayList<PhatTu> listUser, Context context,ItemOnclick i) {
        this.listUser = listUser;
        this.context = context;
        this.i=i;
        filterListUser=new ArrayList<>(listUser);
    }

    @Override
    public Filter getFilter() {
        return PhatTuFilter;
    }

    private Filter PhatTuFilter =new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<PhatTu> filterList = new ArrayList<>();
            if (constraint==null || constraint.length()==0){
                filterList.addAll(filterListUser);
            }else {
                String filterPartern = constraint.toString().toLowerCase().trim();
                for (PhatTu phatTu : filterListUser){
                    if (phatTu.getName().toLowerCase().contains(filterPartern)){
                        filterList.add(phatTu);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values =filterList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listUser.clear();
            listUser.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

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
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
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
