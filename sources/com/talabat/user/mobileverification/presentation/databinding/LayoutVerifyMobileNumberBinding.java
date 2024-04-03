package com.talabat.user.mobileverification.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.user.mobileverification.presentation.R;

public final class LayoutVerifyMobileNumberBinding implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;

    private LayoutVerifyMobileNumberBinding(@NonNull FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    @NonNull
    public static LayoutVerifyMobileNumberBinding bind(@NonNull View view) {
        if (view != null) {
            return new LayoutVerifyMobileNumberBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static LayoutVerifyMobileNumberBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutVerifyMobileNumberBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_verify_mobile_number, viewGroup, false);
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
