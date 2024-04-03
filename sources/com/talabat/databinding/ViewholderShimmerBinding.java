package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;
import com.talabat.designhelpers.shimmer.ShimmerLayout;

public final class ViewholderShimmerBinding implements ViewBinding {
    @NonNull
    private final ShimmerLayout rootView;

    private ViewholderShimmerBinding(@NonNull ShimmerLayout shimmerLayout) {
        this.rootView = shimmerLayout;
    }

    @NonNull
    public static ViewholderShimmerBinding bind(@NonNull View view) {
        if (view != null) {
            return new ViewholderShimmerBinding((ShimmerLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ViewholderShimmerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewholderShimmerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.viewholder_shimmer, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ShimmerLayout getRoot() {
        return this.rootView;
    }
}
