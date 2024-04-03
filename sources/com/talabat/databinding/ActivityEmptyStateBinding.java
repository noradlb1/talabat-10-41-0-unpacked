package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class ActivityEmptyStateBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout hello;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivityEmptyStateBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.hello = constraintLayout2;
    }

    @NonNull
    public static ActivityEmptyStateBinding bind(@NonNull View view) {
        if (view != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new ActivityEmptyStateBinding(constraintLayout, constraintLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ActivityEmptyStateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityEmptyStateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_empty_state, viewGroup, false);
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
