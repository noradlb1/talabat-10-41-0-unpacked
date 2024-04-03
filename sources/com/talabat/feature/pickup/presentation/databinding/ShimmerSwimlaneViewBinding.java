package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.pickup.presentation.R;

public final class ShimmerSwimlaneViewBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;

    private ShimmerSwimlaneViewBinding(@NonNull LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    @NonNull
    public static ShimmerSwimlaneViewBinding bind(@NonNull View view) {
        if (view != null) {
            return new ShimmerSwimlaneViewBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ShimmerSwimlaneViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ShimmerSwimlaneViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.shimmer_swimlane_view, viewGroup, false);
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
