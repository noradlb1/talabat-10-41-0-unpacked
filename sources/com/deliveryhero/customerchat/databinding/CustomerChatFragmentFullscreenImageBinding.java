package com.deliveryhero.customerchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.deliveryhero.customerchat.R;
import com.github.chrisbanes.photoview.PhotoView;

public final class CustomerChatFragmentFullscreenImageBinding implements ViewBinding {
    @NonNull
    public final ImageView closeFullScreen;
    @NonNull
    public final PhotoView fullscreenImage;
    @NonNull
    private final ConstraintLayout rootView;

    private CustomerChatFragmentFullscreenImageBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull PhotoView photoView) {
        this.rootView = constraintLayout;
        this.closeFullScreen = imageView;
        this.fullscreenImage = photoView;
    }

    @NonNull
    public static CustomerChatFragmentFullscreenImageBinding bind(@NonNull View view) {
        int i11 = R.id.close_full_screen;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.fullscreen_image;
            PhotoView photoView = (PhotoView) ViewBindings.findChildViewById(view, i11);
            if (photoView != null) {
                return new CustomerChatFragmentFullscreenImageBinding((ConstraintLayout) view, imageView, photoView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomerChatFragmentFullscreenImageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomerChatFragmentFullscreenImageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.customer_chat_fragment_fullscreen_image, viewGroup, false);
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
