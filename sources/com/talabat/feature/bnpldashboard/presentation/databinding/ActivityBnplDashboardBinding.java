package com.talabat.feature.bnpldashboard.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.bnpldashboard.presentation.R;

public final class ActivityBnplDashboardBinding implements ViewBinding {
    @NonNull
    public final FrameLayout bnplDashboardFragmentContainer;
    @NonNull
    private final FrameLayout rootView;

    private ActivityBnplDashboardBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.bnplDashboardFragmentContainer = frameLayout2;
    }

    @NonNull
    public static ActivityBnplDashboardBinding bind(@NonNull View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new ActivityBnplDashboardBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ActivityBnplDashboardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityBnplDashboardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_bnpl_dashboard, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
