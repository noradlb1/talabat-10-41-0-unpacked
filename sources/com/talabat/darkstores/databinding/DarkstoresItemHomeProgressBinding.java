package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresItemHomeProgressBinding implements ViewBinding {
    @NonNull
    public final ProgressBar pageProgressBar;
    @NonNull
    private final ProgressBar rootView;

    private DarkstoresItemHomeProgressBinding(@NonNull ProgressBar progressBar, @NonNull ProgressBar progressBar2) {
        this.rootView = progressBar;
        this.pageProgressBar = progressBar2;
    }

    @NonNull
    public static DarkstoresItemHomeProgressBinding bind(@NonNull View view) {
        if (view != null) {
            ProgressBar progressBar = (ProgressBar) view;
            return new DarkstoresItemHomeProgressBinding(progressBar, progressBar);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DarkstoresItemHomeProgressBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomeProgressBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_progress, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ProgressBar getRoot() {
        return this.rootView;
    }
}
