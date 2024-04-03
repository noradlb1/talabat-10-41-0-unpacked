package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.talabat.talabatcommon.R;

public final class ViewTalabatMarshmallowProgressBinding implements ViewBinding {
    @NonNull
    public final LottieAnimationView animatedImageView;
    @NonNull
    private final View rootView;

    private ViewTalabatMarshmallowProgressBinding(@NonNull View view, @NonNull LottieAnimationView lottieAnimationView) {
        this.rootView = view;
        this.animatedImageView = lottieAnimationView;
    }

    @NonNull
    public static ViewTalabatMarshmallowProgressBinding bind(@NonNull View view) {
        int i11 = R.id.animated_image_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i11);
        if (lottieAnimationView != null) {
            return new ViewTalabatMarshmallowProgressBinding(view, lottieAnimationView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewTalabatMarshmallowProgressBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_talabat_marshmallow_progress, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
