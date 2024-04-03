package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;

public final class ViewHolderEmptyBinding implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;

    private ViewHolderEmptyBinding(@NonNull FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    @NonNull
    public static ViewHolderEmptyBinding bind(@NonNull View view) {
        if (view != null) {
            return new ViewHolderEmptyBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ViewHolderEmptyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderEmptyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_empty, viewGroup, false);
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
