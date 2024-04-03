package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.designhelpers.CustomSquareProgree.SquareProgressBar;

public final class AdScreenBinding implements ViewBinding {
    @NonNull
    public final ImageView adImageView;
    @NonNull
    public final WebView adWebview;
    @NonNull
    public final RelativeLayout addressLayoutView;
    @NonNull
    public final ProgressBar progress;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final SquareProgressBar squareProgressBar;

    private AdScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull WebView webView, @NonNull RelativeLayout relativeLayout2, @NonNull ProgressBar progressBar, @NonNull SquareProgressBar squareProgressBar2) {
        this.rootView = relativeLayout;
        this.adImageView = imageView;
        this.adWebview = webView;
        this.addressLayoutView = relativeLayout2;
        this.progress = progressBar;
        this.squareProgressBar = squareProgressBar2;
    }

    @NonNull
    public static AdScreenBinding bind(@NonNull View view) {
        int i11 = R.id.ad_image_view;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ad_image_view);
        if (imageView != null) {
            i11 = R.id.ad_webview;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.ad_webview);
            if (webView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i11 = R.id.progress;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress);
                if (progressBar != null) {
                    i11 = R.id.square_progress_bar;
                    SquareProgressBar squareProgressBar2 = (SquareProgressBar) ViewBindings.findChildViewById(view, R.id.square_progress_bar);
                    if (squareProgressBar2 != null) {
                        return new AdScreenBinding(relativeLayout, imageView, webView, relativeLayout, progressBar, squareProgressBar2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static AdScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AdScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.ad_screen, viewGroup, false);
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
