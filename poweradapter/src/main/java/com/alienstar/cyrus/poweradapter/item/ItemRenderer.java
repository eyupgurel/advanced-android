package com.alienstar.cyrus.poweradapter.item;

//import android.support.annotation.LayoutRes;
//import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

/**
 * Created by cyrus on 3/18/18.
 */

public interface ItemRenderer<T extends RecyclerItem> {
    @LayoutRes
    int layoutRes();

    View createView(@NonNull ViewGroup parent);

    void render(@NonNull View itemView, @NonNull T item);
}
