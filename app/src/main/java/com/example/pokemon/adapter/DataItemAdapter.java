package com.example.pokemon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokemon.MainActivity;
import com.example.pokemon.R;
import com.example.pokemon.model.DataItem;
import com.example.pokemon.room.table.DataItemTable;

import java.util.ArrayList;
import java.util.List;

public class DataItemAdapter extends PagedListAdapter<DataItem, DataItemAdapter.ViewHolder> {
    private List<DataItemTable> dataItemTablesList = new ArrayList<>();
    private Context context;
    private Callback callback;

    public DataItemAdapter(Context context, Callback callback) {
        super(DIFF_CALLBACK);
        this.context = context;
        this.callback = callback;
    }

    private static final DiffUtil.ItemCallback<DataItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<DataItem>() {
                @Override
                public boolean areItemsTheSame(@NonNull DataItem oldItem, @NonNull DataItem newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull DataItem oldItem, @NonNull DataItem newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }
            };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pokemon, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataItemTable data = dataItemTablesList.get(position);
        holder.tvName.setText(data.getName());

        Glide.with(context)
                .load(data.getImgSmall())
                .centerCrop()
                .into(holder.ivItem);

        holder.itemView.setOnClickListener(v -> callback.onItemClick(data.getId()));
    }

    @Override
    public int getItemCount() {
        return dataItemTablesList.size();
    }

    public void setDataItems(PagedList<DataItemTable> dataItemTablesList) {
        this.dataItemTablesList = dataItemTablesList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivItem = itemView.findViewById(R.id.iv_item);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    public interface Callback {
        void onItemClick(String id);
    }
}
