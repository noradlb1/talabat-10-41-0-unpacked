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
import com.talabat.talabatlife.R;

public final class ViewRedeemAndPayPaymentSummaryBinding implements ViewBinding {
    @NonNull
    public final TextView redeemAndPayDiscountTextView;
    @NonNull
    public final TextView redeemAndPaySubTotalTextView;
    @NonNull
    public final TextView redeemAndPayTotalAmountTextView;
    @NonNull
    private final LinearLayout rootView;

    private ViewRedeemAndPayPaymentSummaryBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = linearLayout;
        this.redeemAndPayDiscountTextView = textView;
        this.redeemAndPaySubTotalTextView = textView2;
        this.redeemAndPayTotalAmountTextView = textView3;
    }

    @NonNull
    public static ViewRedeemAndPayPaymentSummaryBinding bind(@NonNull View view) {
        int i11 = R.id.redeemAndPayDiscountTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.redeemAndPaySubTotalTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.redeemAndPayTotalAmountTextView;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView3 != null) {
                    return new ViewRedeemAndPayPaymentSummaryBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewRedeemAndPayPaymentSummaryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewRedeemAndPayPaymentSummaryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_redeem_and_pay_payment_summary, viewGroup, false);
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
