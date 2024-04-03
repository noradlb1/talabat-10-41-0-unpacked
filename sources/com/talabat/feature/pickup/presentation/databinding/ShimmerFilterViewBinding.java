package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.talabat.feature.pickup.presentation.R;

public final class ShimmerFilterViewBinding implements ViewBinding {
    @NonNull
    private final MaterialCardView rootView;

    private ShimmerFilterViewBinding(@NonNull MaterialCardView materialCardView) {
        this.rootView = materialCardView;
    }

    @NonNull
    public static ShimmerFilterViewBinding bind(@NonNull View view) {
        if (view != null) {
            return new ShimmerFilterViewBinding((MaterialCardView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ShimmerFilterViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ShimmerFilterViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.shimmer_filter_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public MaterialCardView getRoot() {
        return this.rootView;
    }
}
