package com.talabat.userandlocation.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.userandlocation.login.R;

public final class ActivityEmailLoginBinding implements ViewBinding {
    @NonNull
    public final FrameLayout container;
    @NonNull
    private final FrameLayout rootView;

    private ActivityEmailLoginBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.container = frameLayout2;
    }

    @NonNull
    public static ActivityEmailLoginBinding bind(@NonNull View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new ActivityEmailLoginBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ActivityEmailLoginBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityEmailLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_email_login, viewGroup, false);
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
