package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class FragmentAddCardWebViewBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final WebView walletAddCardWebView;

    private FragmentAddCardWebViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull WebView webView) {
        this.rootView = constraintLayout;
        this.walletAddCardWebView = webView;
    }

    @NonNull
    public static FragmentAddCardWebViewBinding bind(@NonNull View view) {
        int i11 = R.id.wallet_add_card_web_view;
        WebView webView = (WebView) ViewBindings.findChildViewById(view, i11);
        if (webView != null) {
            return new FragmentAddCardWebViewBinding((ConstraintLayout) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentAddCardWebViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentAddCardWebViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_card_web_view, viewGroup, false);
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
