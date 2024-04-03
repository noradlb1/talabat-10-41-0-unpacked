package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;

public final class PaymentwebviewBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final WebView webview;
    @NonNull
    public final ProgressBar webviewProgress;

    private PaymentwebviewBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull WebView webView, @NonNull ProgressBar progressBar) {
        this.rootView = relativeLayout;
        this.back = talabatToolBarImageButton;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.webview = webView;
        this.webviewProgress = progressBar;
    }

    @NonNull
    public static PaymentwebviewBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.title;
            TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
            if (talabatToolBarTextView != null) {
                i11 = R.id.toolbar;
                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                if (talabatToolBar != null) {
                    i11 = R.id.webview;
                    WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.webview);
                    if (webView != null) {
                        i11 = R.id.webview_progress;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.webview_progress);
                        if (progressBar != null) {
                            return new PaymentwebviewBinding((RelativeLayout) view, talabatToolBarImageButton, talabatToolBarTextView, talabatToolBar, webView, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static PaymentwebviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static PaymentwebviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.paymentwebview, viewGroup, false);
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
