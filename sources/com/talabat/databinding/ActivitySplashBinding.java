package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class ActivitySplashBinding implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;

    private ActivitySplashBinding(@NonNull CoordinatorLayout coordinatorLayout) {
        this.rootView = coordinatorLayout;
    }

    @NonNull
    public static ActivitySplashBinding bind(@NonNull View view) {
        if (view != null) {
            return new ActivitySplashBinding((CoordinatorLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ActivitySplashBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivitySplashBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_splash, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}
