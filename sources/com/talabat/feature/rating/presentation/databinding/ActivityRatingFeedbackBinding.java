package com.talabat.feature.rating.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.rating.presentation.R;

public final class ActivityRatingFeedbackBinding implements ViewBinding {
    @NonNull
    public final FragmentContainerView ratingNavHostFragment;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivityRatingFeedbackBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.ratingNavHostFragment = fragmentContainerView;
    }

    @NonNull
    public static ActivityRatingFeedbackBinding bind(@NonNull View view) {
        int i11 = R.id.rating_nav_host_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i11);
        if (fragmentContainerView != null) {
            return new ActivityRatingFeedbackBinding((ConstraintLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityRatingFeedbackBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityRatingFeedbackBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_rating_feedback, viewGroup, false);
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
