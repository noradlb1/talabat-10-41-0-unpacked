package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ContentLocationWelcomeBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final FrameLayout locationFrgContainer;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final FrameLayout welcomeVideoFragContainer;

    private ContentLocationWelcomeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = constraintLayout;
        this.container = constraintLayout2;
        this.locationFrgContainer = frameLayout;
        this.welcomeVideoFragContainer = frameLayout2;
    }

    @NonNull
    public static ContentLocationWelcomeBinding bind(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R.id.locationFrgContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.locationFrgContainer);
        if (frameLayout != null) {
            i11 = R.id.welcomeVideoFragContainer;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.welcomeVideoFragContainer);
            if (frameLayout2 != null) {
                return new ContentLocationWelcomeBinding(constraintLayout, constraintLayout, frameLayout, frameLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ContentLocationWelcomeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ContentLocationWelcomeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.content_location_welcome, viewGroup, false);
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
