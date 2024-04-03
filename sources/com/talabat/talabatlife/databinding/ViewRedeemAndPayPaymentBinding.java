package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;
import com.talabat.talabatlife.R;

public final class ViewRedeemAndPayPaymentBinding implements ViewBinding {
    @NonNull
    public final WalletPaymentOptionView redeemAndPayPaymentOption;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView titlePayWith;

    private ViewRedeemAndPayPaymentBinding(@NonNull LinearLayout linearLayout, @NonNull WalletPaymentOptionView walletPaymentOptionView, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.redeemAndPayPaymentOption = walletPaymentOptionView;
        this.titlePayWith = textView;
    }

    @NonNull
    public static ViewRedeemAndPayPaymentBinding bind(@NonNull View view) {
        int i11 = R.id.redeemAndPayPaymentOption;
        WalletPaymentOptionView walletPaymentOptionView = (WalletPaymentOptionView) ViewBindings.findChildViewById(view, i11);
        if (walletPaymentOptionView != null) {
            i11 = R.id.titlePayWith;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new ViewRedeemAndPayPaymentBinding((LinearLayout) view, walletPaymentOptionView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewRedeemAndPayPaymentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewRedeemAndPayPaymentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_redeem_and_pay_payment, viewGroup, false);
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
