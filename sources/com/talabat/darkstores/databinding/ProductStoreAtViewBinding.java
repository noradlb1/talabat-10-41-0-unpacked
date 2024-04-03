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

public final class ProductStoreAtViewBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView txtStoredAtDescription;

    private ProductStoreAtViewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.txtStoredAtDescription = textView;
    }

    @NonNull
    public static ProductStoreAtViewBinding bind(@NonNull View view) {
        int i11 = R.id.txt_stored_at_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            return new ProductStoreAtViewBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ProductStoreAtViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ProductStoreAtViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.product_store_at_view, viewGroup, false);
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
