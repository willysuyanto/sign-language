package com.wildangunawan.bslapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.viewHolder> {
    private ArrayList<ObjekBahasaIsyarat> mItemList;
    private OnTitleListener mOnTitleListener;

    public ListAdapter(ArrayList<ObjekBahasaIsyarat> itemList, OnTitleListener onTitleListener) {
        mItemList = itemList;
        mOnTitleListener = onTitleListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        viewHolder vHolder = new viewHolder(view, mOnTitleListener);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        String currentItem = mItemList.get(position).getTitle();
        int CurrentImage = mItemList.get(position).getImage();
        String currentTitle= mItemList.get(position).getSubtitle();
        holder.text2.setText(currentTitle);
        holder.text.setText(currentItem);
        holder.Images.setImageResource(CurrentImage);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public interface OnTitleListener {
        void OnTitleClick(int position);
    }

    public static class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView text;
        public TextView text2;
        public ImageView Images;
        OnTitleListener onTitleListener;

        public viewHolder(@NonNull View itemView, OnTitleListener onTitleListener) {
            super(itemView);
            text = itemView.findViewById(R.id.textSubtitle);
            text2 = itemView.findViewById(R.id.TextTitle);
            Images = itemView.findViewById(R.id.RecImage);
            this.onTitleListener = onTitleListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTitleListener.OnTitleClick(getAdapterPosition());
        }
    }
}
