package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ViewFreeTrialBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView freeTrialInfo;
    @NonNull
    public final RelativeLayout freeTrialLayout;
    @NonNull
    private final RelativeLayout rootView;

    private ViewFreeTrialBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.freeTrialInfo = talabatTextView;
        this.freeTrialLayout = relativeLayout2;
    }

    @NonNull
    public static ViewFreeTrialBinding bind(@NonNull View view) {
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.free_trial_info);
        if (talabatTextView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new ViewFreeTrialBinding(relativeLayout, talabatTextView, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.free_trial_info)));
    }

    @NonNull
    public static ViewFreeTrialBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewFreeTrialBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_free_trial, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
