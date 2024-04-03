package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.pickup.presentation.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class ShimmerVendorListViewBinding implements ViewBinding {
    @NonNull
    private final ShimmerLayout rootView;

    private ShimmerVendorListViewBinding(@NonNull ShimmerLayout shimmerLayout) {
        this.rootView = shimmerLayout;
    }

    @NonNull
    public static ShimmerVendorListViewBinding bind(@NonNull View view) {
        if (view != null) {
            return new ShimmerVendorListViewBinding((ShimmerLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ShimmerVendorListViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ShimmerVendorListViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.shimmer_vendor_list_view, viewGroup, false);
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
