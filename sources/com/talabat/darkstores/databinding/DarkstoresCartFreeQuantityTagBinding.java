package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresCartFreeQuantityTagBinding implements ViewBinding {
    @NonNull
    public final TextView freeQuantityCount;
    @NonNull
    public final TextView freeQuantityMsg;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresCartFreeQuantityTagBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.freeQuantityCount = textView;
        this.freeQuantityMsg = textView2;
    }

    @NonNull
    public static DarkstoresCartFreeQuantityTagBinding bind(@NonNull View view) {
        int i11 = R.id.free_quantity_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.free_quantity_msg;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                return new DarkstoresCartFreeQuantityTagBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresCartFreeQuantityTagBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresCartFreeQuantityTagBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_cart_free_quantity_tag, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
