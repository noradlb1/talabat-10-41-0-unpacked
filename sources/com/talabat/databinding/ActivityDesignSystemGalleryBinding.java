package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.marshmallow.views.gridview.TalabtGridView;
import com.talabat.R;

public final class ActivityDesignSystemGalleryBinding implements ViewBinding {
    @NonNull
    public final TalabtGridView gridTest;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivityDesignSystemGalleryBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabtGridView talabtGridView) {
        this.rootView = constraintLayout;
        this.gridTest = talabtGridView;
    }

    @NonNull
    public static ActivityDesignSystemGalleryBinding bind(@NonNull View view) {
        TalabtGridView talabtGridView = (TalabtGridView) ViewBindings.findChildViewById(view, R.id.gridTest);
        if (talabtGridView != null) {
            return new ActivityDesignSystemGalleryBinding((ConstraintLayout) view, talabtGridView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.gridTest)));
    }

    @NonNull
    public static ActivityDesignSystemGalleryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityDesignSystemGalleryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_design_system_gallery, viewGroup, false);
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
