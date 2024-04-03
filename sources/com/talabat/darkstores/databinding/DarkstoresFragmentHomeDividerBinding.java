package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresFragmentHomeDividerBinding implements ViewBinding {
    @NonNull
    private final View rootView;

    private DarkstoresFragmentHomeDividerBinding(@NonNull View view) {
        this.rootView = view;
    }

    @NonNull
    public static DarkstoresFragmentHomeDividerBinding bind(@NonNull View view) {
        if (view != null) {
            return new DarkstoresFragmentHomeDividerBinding(view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresFragmentHomeDividerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DarkstoresFragmentHomeDividerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_home_divider, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
}
