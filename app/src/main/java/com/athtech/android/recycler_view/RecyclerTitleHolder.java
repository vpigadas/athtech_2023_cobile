package com.athtech.android.recycler_view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athtech.android.R;

public class RecyclerTitleHolder extends RecyclerView.ViewHolder {

    public RecyclerTitleHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(String data) {
        TextView textView = itemView.findViewById(R.id.holder_title);
        textView.setText(data);
    }
}
