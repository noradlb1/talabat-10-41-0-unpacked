package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarLinearLayoutContainer;
import com.talabat.helpers.TalabatToolBarTextView;

public final class TalabatwebviewBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarLinearLayoutContainer mainLayout;
    @NonNull
    private final TalabatToolBarLinearLayoutContainer rootView;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final WebView webview;
    @NonNull
    public final TalabatToolBarImageButton webviewBack;
    @NonNull
    public final ProgressBar webviewProgress;
    @NonNull
    public final TalabatToolBarTextView webviewTitle;

    private TalabatwebviewBinding(@NonNull TalabatToolBarLinearLayoutContainer talabatToolBarLinearLayoutContainer, @NonNull TalabatToolBarLinearLayoutContainer talabatToolBarLinearLayoutContainer2, @NonNull TalabatToolBar talabatToolBar, @NonNull WebView webView, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull ProgressBar progressBar, @NonNull TalabatToolBarTextView talabatToolBarTextView) {
        this.rootView = talabatToolBarLinearLayoutContainer;
        this.mainLayout = talabatToolBarLinearLayoutContainer2;
        this.toolbar = talabatToolBar;
        this.webview = webView;
        this.webviewBack = talabatToolBarImageButton;
        this.webviewProgress = progressBar;
        this.webviewTitle = talabatToolBarTextView;
    }

    @NonNull
    public static TalabatwebviewBinding bind(@NonNull View view) {
        TalabatToolBarLinearLayoutContainer talabatToolBarLinearLayoutContainer = (TalabatToolBarLinearLayoutContainer) view;
        int i11 = R.id.toolbar;
        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
        if (talabatToolBar != null) {
            i11 = R.id.webview;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.webview);
            if (webView != null) {
                i11 = R.id.webview_back;
                TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.webview_back);
                if (talabatToolBarImageButton != null) {
                    i11 = R.id.webview_progress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.webview_progress);
                    if (progressBar != null) {
                        i11 = R.id.webview_title;
                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.webview_title);
                        if (talabatToolBarTextView != null) {
                            return new TalabatwebviewBinding(talabatToolBarLinearLayoutContainer, talabatToolBarLinearLayoutContainer, talabatToolBar, webView, talabatToolBarImageButton, progressBar, talabatToolBarTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TalabatwebviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TalabatwebviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.talabatwebview, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatToolBarLinearLayoutContainer getRoot() {
        return this.rootView;
    }
}
