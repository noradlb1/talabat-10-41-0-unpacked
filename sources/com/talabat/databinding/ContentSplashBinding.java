package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ContentSplashBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ContentMainSplashBinding splashMainViewContainer;
    @NonNull
    public final ContentLocationWelcomeBinding splashWelcomeViewContainer;

    private ContentSplashBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ContentMainSplashBinding contentMainSplashBinding, @NonNull ContentLocationWelcomeBinding contentLocationWelcomeBinding) {
        this.rootView = constraintLayout;
        this.splashMainViewContainer = contentMainSplashBinding;
        this.splashWelcomeViewContainer = contentLocationWelcomeBinding;
    }

    @NonNull
    public static ContentSplashBinding bind(@NonNull View view) {
        int i11 = R.id.splashMainViewContainer;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.splashMainViewContainer);
        if (findChildViewById != null) {
            ContentMainSplashBinding bind = ContentMainSplashBinding.bind(findChildViewById);
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.splashWelcomeViewContainer);
            if (findChildViewById2 != null) {
                return new ContentSplashBinding((ConstraintLayout) view, bind, ContentLocationWelcomeBinding.bind(findChildViewById2));
            }
            i11 = R.id.splashWelcomeViewContainer;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ContentSplashBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ContentSplashBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.content_splash, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
