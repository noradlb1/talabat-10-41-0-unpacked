package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.homescreen.R;

public final class LayoutOrderStatusViewBinding implements ViewBinding {
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    private final View rootView;

    private LayoutOrderStatusViewBinding(@NonNull View view, @NonNull RecyclerView recyclerView2) {
        this.rootView = view;
        this.recyclerView = recyclerView2;
    }

    @NonNull
    public static LayoutOrderStatusViewBinding bind(@NonNull View view) {
        int i11 = R.id.recyclerView;
        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView2 != null) {
            return new LayoutOrderStatusViewBinding(view, recyclerView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutOrderStatusViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.layout_order_status_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
