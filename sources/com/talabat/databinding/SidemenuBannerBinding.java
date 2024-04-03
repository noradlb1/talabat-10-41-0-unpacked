package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class SidemenuBannerBinding implements ViewBinding {
    @NonNull
    public final WebView adWebview;
    @NonNull
    public final ImageView imageBanner;
    @NonNull
    private final LinearLayout rootView;

    private SidemenuBannerBinding(@NonNull LinearLayout linearLayout, @NonNull WebView webView, @NonNull ImageView imageView) {
        this.rootView = linearLayout;
        this.adWebview = webView;
        this.imageBanner = imageView;
    }

    @NonNull
    public static SidemenuBannerBinding bind(@NonNull View view) {
        int i11 = R.id.ad_webview;
        WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.ad_webview);
        if (webView != null) {
            i11 = R.id.image_banner;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.image_banner);
            if (imageView != null) {
                return new SidemenuBannerBinding((LinearLayout) view, webView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SidemenuBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SidemenuBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.sidemenu_banner, viewGroup, false);
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
