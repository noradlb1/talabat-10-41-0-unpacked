package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ActivityDividersBinding implements ViewBinding {
    @NonNull
    public final View dividerThin;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivityDividersBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view) {
        this.rootView = constraintLayout;
        this.dividerThin = view;
    }

    @NonNull
    public static ActivityDividersBinding bind(@NonNull View view) {
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.divider_thin);
        if (findChildViewById != null) {
            return new ActivityDividersBinding((ConstraintLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.divider_thin)));
    }

    @NonNull
    public static ActivityDividersBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityDividersBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_dividers, viewGroup, false);
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
