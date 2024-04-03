package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.R;

public final class LayoutSampleViewBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;

    private LayoutSampleViewBinding(@NonNull LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    @NonNull
    public static LayoutSampleViewBinding bind(@NonNull View view) {
        if (view != null) {
            return new LayoutSampleViewBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static LayoutSampleViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutSampleViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_sample_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
