package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewVendorLogoBinding implements ViewBinding {
    @NonNull
    public final FrameLayout frameLayoutStatusContainer;
    @NonNull
    public final ImageView imageViewOverlay;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final ImageView vendorLogoImg;
    @NonNull
    public final TextView vendorStatusTxt;

    private ViewVendorLogoBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull ProgressBar progressBar2, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.rootView = frameLayout;
        this.frameLayoutStatusContainer = frameLayout2;
        this.imageViewOverlay = imageView;
        this.progressBar = progressBar2;
        this.vendorLogoImg = imageView2;
        this.vendorStatusTxt = textView;
    }

    @NonNull
    public static ViewVendorLogoBinding bind(@NonNull View view) {
        int i11 = R.id.frameLayout_statusContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
        if (frameLayout != null) {
            i11 = R.id.imageView_overlay;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.progressBar;
                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                if (progressBar2 != null) {
                    i11 = R.id.vendorLogoImg;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView2 != null) {
                        i11 = R.id.vendorStatusTxt;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            return new ViewVendorLogoBinding((FrameLayout) view, frameLayout, imageView, progressBar2, imageView2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewVendorLogoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewVendorLogoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_vendor_logo, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
