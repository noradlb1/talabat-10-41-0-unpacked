package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ActivityCheckoutWebViewBinding implements ViewBinding {
    @NonNull
    public final ImageButton backIcon;
    @NonNull
    public final ConstraintLayout header;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textView4;
    @NonNull
    public final WebView walletWebView;

    private ActivityCheckoutWebViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ConstraintLayout constraintLayout2, @NonNull ProgressBar progressBar2, @NonNull TextView textView, @NonNull WebView webView) {
        this.rootView = constraintLayout;
        this.backIcon = imageButton;
        this.header = constraintLayout2;
        this.progressBar = progressBar2;
        this.textView4 = textView;
        this.walletWebView = webView;
    }

    @NonNull
    public static ActivityCheckoutWebViewBinding bind(@NonNull View view) {
        int i11 = R.id.back_icon;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.back_icon);
        if (imageButton != null) {
            i11 = R.id.header;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.header);
            if (constraintLayout != null) {
                i11 = R.id.progress_bar;
                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_bar);
                if (progressBar2 != null) {
                    i11 = R.id.textView4;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView4);
                    if (textView != null) {
                        i11 = R.id.wallet_web_view;
                        WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.wallet_web_view);
                        if (webView != null) {
                            return new ActivityCheckoutWebViewBinding((ConstraintLayout) view, imageButton, constraintLayout, progressBar2, textView, webView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityCheckoutWebViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityCheckoutWebViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_checkout_web_view, viewGroup, false);
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
