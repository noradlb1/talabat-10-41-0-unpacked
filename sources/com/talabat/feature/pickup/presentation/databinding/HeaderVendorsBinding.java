package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.pickup.presentation.R;

public final class HeaderVendorsBinding implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;

    private HeaderVendorsBinding(@NonNull FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    @NonNull
    public static HeaderVendorsBinding bind(@NonNull View view) {
        if (view != null) {
            return new HeaderVendorsBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static HeaderVendorsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static HeaderVendorsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.header_vendors, viewGroup, false);
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
