package com.talabat.feature.darkstores.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.darkstores.presentation.R;

public final class ActivityDarkstoreDeepLinkBinding implements ViewBinding {
    @NonNull
    public final ProgressBar darkstoreDeeplinkLoadingView;
    @NonNull
    private final RelativeLayout rootView;

    private ActivityDarkstoreDeepLinkBinding(@NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar) {
        this.rootView = relativeLayout;
        this.darkstoreDeeplinkLoadingView = progressBar;
    }

    @NonNull
    public static ActivityDarkstoreDeepLinkBinding bind(@NonNull View view) {
        int i11 = R.id.darkstore_deeplink_loading_view;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i11);
        if (progressBar != null) {
            return new ActivityDarkstoreDeepLinkBinding((RelativeLayout) view, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityDarkstoreDeepLinkBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityDarkstoreDeepLinkBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_darkstore_deep_link, viewGroup, false);
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
