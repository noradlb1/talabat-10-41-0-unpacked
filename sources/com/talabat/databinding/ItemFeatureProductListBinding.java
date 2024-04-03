package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ItemFeatureProductListBinding implements ViewBinding {
    @NonNull
    public final RecyclerView featureProductList;
    @NonNull
    public final TextView featureProductTitle;
    @NonNull
    private final ConstraintLayout rootView;

    private ItemFeatureProductListBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.featureProductList = recyclerView;
        this.featureProductTitle = textView;
    }

    @NonNull
    public static ItemFeatureProductListBinding bind(@NonNull View view) {
        int i11 = R.id.featureProductList;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.featureProductList);
        if (recyclerView != null) {
            i11 = R.id.featureProductTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.featureProductTitle);
            if (textView != null) {
                return new ItemFeatureProductListBinding((ConstraintLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemFeatureProductListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemFeatureProductListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_feature_product_list, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
