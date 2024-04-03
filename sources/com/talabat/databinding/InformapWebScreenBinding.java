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
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;

public final class InformapWebScreenBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout mainLayout;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout showCaseView;
    @NonNull
    public final TalabatTextView tapHere;
    @NonNull
    public final TalabatTextView textUserGuide;
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

    private InformapWebScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatToolBar talabatToolBar, @NonNull WebView webView, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull ProgressBar progressBar, @NonNull TalabatToolBarTextView talabatToolBarTextView) {
        this.rootView = relativeLayout;
        this.mainLayout = relativeLayout2;
        this.showCaseView = relativeLayout3;
        this.tapHere = talabatTextView;
        this.textUserGuide = talabatTextView2;
        this.toolbar = talabatToolBar;
        this.webview = webView;
        this.webviewBack = talabatToolBarImageButton;
        this.webviewProgress = progressBar;
        this.webviewTitle = talabatToolBarTextView;
    }

    @NonNull
    public static InformapWebScreenBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i11 = R.id.show_case_view;
        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.show_case_view);
        if (relativeLayout2 != null) {
            i11 = R.id.tap_here;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tap_here);
            if (talabatTextView != null) {
                i11 = R.id.text_user_guide;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.text_user_guide);
                if (talabatTextView2 != null) {
                    i11 = R.id.toolbar;
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
                                        return new InformapWebScreenBinding(relativeLayout, relativeLayout, relativeLayout2, talabatTextView, talabatTextView2, talabatToolBar, webView, talabatToolBarImageButton, progressBar, talabatToolBarTextView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static InformapWebScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static InformapWebScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.informap_web_screen, viewGroup, false);
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
