package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.talabat.talabatcommon.R;

public final class ActivityWallet3dsWebViewBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final DSNavigationBar wallet3dsNavigationBar;
    @NonNull
    public final WebView wallet3dsWebView;

    private ActivityWallet3dsWebViewBinding(@NonNull LinearLayout linearLayout, @NonNull DSNavigationBar dSNavigationBar, @NonNull WebView webView) {
        this.rootView = linearLayout;
        this.wallet3dsNavigationBar = dSNavigationBar;
        this.wallet3dsWebView = webView;
    }

    @NonNull
    public static ActivityWallet3dsWebViewBinding bind(@NonNull View view) {
        int i11 = R.id.wallet_3ds_navigation_bar;
        DSNavigationBar dSNavigationBar = (DSNavigationBar) ViewBindings.findChildViewById(view, i11);
        if (dSNavigationBar != null) {
            i11 = R.id.wallet_3ds_web_view;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, i11);
            if (webView != null) {
                return new ActivityWallet3dsWebViewBinding((LinearLayout) view, dSNavigationBar, webView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityWallet3dsWebViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityWallet3dsWebViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_wallet_3ds_web_view, viewGroup, false);
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
