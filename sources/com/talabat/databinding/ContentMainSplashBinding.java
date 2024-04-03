package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.wang.avi.AVLoadingIndicatorView;

public final class ContentMainSplashBinding implements ViewBinding {
    @NonNull
    public final AVLoadingIndicatorView aviLoading;
    @NonNull
    public final ImageView campaignImage;
    @NonNull
    public final LinearLayout expoLogoContainer;
    @NonNull
    public final ImageView imageViewSplashStatic;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TalabatTextView splashText;
    @NonNull
    public final FrameLayout splashVideoContainer;

    private ContentMainSplashBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AVLoadingIndicatorView aVLoadingIndicatorView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView, @NonNull FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.aviLoading = aVLoadingIndicatorView;
        this.campaignImage = imageView;
        this.expoLogoContainer = linearLayout;
        this.imageViewSplashStatic = imageView2;
        this.splashText = talabatTextView;
        this.splashVideoContainer = frameLayout;
    }

    @NonNull
    public static ContentMainSplashBinding bind(@NonNull View view) {
        int i11 = R.id.avi_loading;
        AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) ViewBindings.findChildViewById(view, R.id.avi_loading);
        if (aVLoadingIndicatorView != null) {
            i11 = R.id.campaignImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.campaignImage);
            if (imageView != null) {
                i11 = R.id.expo_logo_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.expo_logo_container);
                if (linearLayout != null) {
                    i11 = R.id.imageView_splash_static;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_splash_static);
                    if (imageView2 != null) {
                        i11 = R.id.splashText;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.splashText);
                        if (talabatTextView != null) {
                            i11 = R.id.splashVideoContainer;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.splashVideoContainer);
                            if (frameLayout != null) {
                                return new ContentMainSplashBinding((ConstraintLayout) view, aVLoadingIndicatorView, imageView, linearLayout, imageView2, talabatTextView, frameLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ContentMainSplashBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ContentMainSplashBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.content_main_splash, viewGroup, false);
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
