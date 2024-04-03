package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class LivetrackonwebBinding implements ViewBinding {
    @NonNull
    public final LinearLayout mainLayout;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final WebView webview;
    @NonNull
    public final ImageButton webviewBack;
    @NonNull
    public final ProgressBar webviewProgress;
    @NonNull
    public final TalabatTextView webviewTitle;

    private LivetrackonwebBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Toolbar toolbar2, @NonNull WebView webView, @NonNull ImageButton imageButton, @NonNull ProgressBar progressBar, @NonNull TalabatTextView talabatTextView) {
        this.rootView = linearLayout;
        this.mainLayout = linearLayout2;
        this.toolbar = toolbar2;
        this.webview = webView;
        this.webviewBack = imageButton;
        this.webviewProgress = progressBar;
        this.webviewTitle = talabatTextView;
    }

    @NonNull
    public static LivetrackonwebBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R.id.toolbar;
        Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
        if (toolbar2 != null) {
            i11 = R.id.webview;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.webview);
            if (webView != null) {
                i11 = R.id.webview_back;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.webview_back);
                if (imageButton != null) {
                    i11 = R.id.webview_progress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.webview_progress);
                    if (progressBar != null) {
                        i11 = R.id.webview_title;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.webview_title);
                        if (talabatTextView != null) {
                            return new LivetrackonwebBinding(linearLayout, linearLayout, toolbar2, webView, imageButton, progressBar, talabatTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LivetrackonwebBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LivetrackonwebBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.livetrackonweb, viewGroup, false);
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
