package com.tikhanovesy.aplikasimarble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.viewHolder> {
    private ArrayList<String> mItemList;
    private OnTitleListener mOnTitleListener;

    public ListAdapter(ArrayList<String> itemList, OnTitleListener onTitleListener) {
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
        String currentItem = String.valueOf(mItemList.get(position));
        holder.text.setText(currentItem);
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
        OnTitleListener onTitleListener;

        public viewHolder(@NonNull View itemView, OnTitleListener onTitleListener) {
            super(itemView);
            text = itemView.findViewById(R.id.TextTitle);
            this.onTitleListener = onTitleListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTitleListener.OnTitleClick(getAdapterPosition());
        }
    }
}
