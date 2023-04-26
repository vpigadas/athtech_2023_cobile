package com.athtech.android.recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athtech.android.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> arrayData;

    public RecyclerAdapter(List<String> arrayData) {
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        if (viewType == R.layout.holder_item_1) {
            return new RecyclerHolder(view);
        } else {
            return new RecyclerTitleHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerHolder) {
            ((RecyclerHolder) holder).bind(arrayData.get(position));
        }else if (holder instanceof RecyclerTitleHolder) {
            ((RecyclerTitleHolder) holder).bind(arrayData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return R.layout.holder_item_1;
        }
        return R.layout.holder_item_2;
    }
}
