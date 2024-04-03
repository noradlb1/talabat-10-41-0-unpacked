package com.talabat.talabatcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcore.R;

public final class GenericProgressBarBinding implements ViewBinding {
    @NonNull
    public final ProgressBar genericProgressBar;
    @NonNull
    public final RelativeLayout genericProgressBarRootRelativeLayout;
    @NonNull
    private final RelativeLayout rootView;

    private GenericProgressBarBinding(@NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.genericProgressBar = progressBar;
        this.genericProgressBarRootRelativeLayout = relativeLayout2;
    }

    @NonNull
    public static GenericProgressBarBinding bind(@NonNull View view) {
        int i11 = R.id.genericProgressBar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i11);
        if (progressBar != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new GenericProgressBarBinding(relativeLayout, progressBar, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GenericProgressBarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GenericProgressBarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.generic_progress_bar, viewGroup, false);
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
