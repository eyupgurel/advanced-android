package com.alienstar.cyrus.poweradapter.adapter;

//import androidx.recyclerview.widget.RecyclerView;
//import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.alienstar.cyrus.poweradapter.item.ItemRenderer;
import com.alienstar.cyrus.poweradapter.item.RecyclerItem;

/**
 * Created by cyrus on 3/18/18.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private final ItemRenderer<RecyclerItem> renderer;

    public RecyclerViewHolder(ViewGroup parent, ItemRenderer<RecyclerItem> renderer) {
        super(renderer.createView(parent));
        this.renderer = renderer;
    }

    void bind(RecyclerItem item) {
        renderer.render(itemView, item);
    }
}
