package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ActivitySwitchBinding implements ViewBinding {
    @NonNull
    public final LinearLayout ll1;
    @NonNull
    public final LinearLayout ll2;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivitySwitchBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.ll1 = linearLayout;
        this.ll2 = linearLayout2;
    }

    @NonNull
    public static ActivitySwitchBinding bind(@NonNull View view) {
        int i11 = R.id.ll_1;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_1);
        if (linearLayout != null) {
            i11 = R.id.ll_2;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_2);
            if (linearLayout2 != null) {
                return new ActivitySwitchBinding((ConstraintLayout) view, linearLayout, linearLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivitySwitchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivitySwitchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_switch, viewGroup, false);
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
