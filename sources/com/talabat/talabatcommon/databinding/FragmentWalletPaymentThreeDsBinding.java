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

public final class FragmentWalletPaymentThreeDsBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final WebView walletPaymentThreeDsWebView;

    private FragmentWalletPaymentThreeDsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull WebView webView) {
        this.rootView = constraintLayout;
        this.walletPaymentThreeDsWebView = webView;
    }

    @NonNull
    public static FragmentWalletPaymentThreeDsBinding bind(@NonNull View view) {
        int i11 = R.id.wallet_payment_three_ds_web_view;
        WebView webView = (WebView) ViewBindings.findChildViewById(view, i11);
        if (webView != null) {
            return new FragmentWalletPaymentThreeDsBinding((ConstraintLayout) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentWalletPaymentThreeDsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentWalletPaymentThreeDsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_wallet_payment_three_ds, viewGroup, false);
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
