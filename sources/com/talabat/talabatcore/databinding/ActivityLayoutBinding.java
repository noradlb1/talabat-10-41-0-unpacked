package com.talabat.talabatcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcore.R;

public final class ActivityLayoutBinding implements ViewBinding {
    @NonNull
    public final FrameLayout fragmentContainer;
    @NonNull
    private final FrameLayout rootView;

    private ActivityLayoutBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.fragmentContainer = frameLayout2;
    }

    @NonNull
    public static ActivityLayoutBinding bind(@NonNull View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new ActivityLayoutBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ActivityLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_layout, viewGroup, false);
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
