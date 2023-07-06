package com.example.belajarsqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MhsAdapter extends RecyclerView.Adapter<MhsAdapter.MhsVH> {

    private ArrayList<MhsModel> mhsList ;

    public MhsAdapter(ArrayList<MhsModel> mhsList) {
        this.mhsList = mhsList;
    }

    @NonNull
    @Override
    public MhsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_listmhs, parent, false);

        return new MhsVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MhsVH holder, int position) {
        holder.tvNamaVal.setText(mhsList.get(position).getNama());
        holder.tvNimVal.setText(mhsList.get(position).getNim());
        holder.tvNoHpVal.setText(mhsList.get(position).getNoHp());
    }

    @Override
    public int getItemCount() {
        return mhsList.size();
    }

    public class MhsVH extends RecyclerView.ViewHolder {

        private TextView tvNamaVal, tvNimVal, tvNoHpVal;

        public MhsVH(@NonNull View itemView) {
            super(itemView);

            tvNamaVal = itemView.findViewById(R.id.tvNamaVal);
            tvNimVal = itemView.findViewById(R.id.tvNimVal);
            tvNoHpVal = itemView.findViewById(R.id.tvNoHpVal);

        }
    }
}
