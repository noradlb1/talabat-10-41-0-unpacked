package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button.DSPrimaryButton;
import com.talabat.talabatcommon.R;

public final class TipRiderInfoBinding implements ViewBinding {
    @NonNull
    public final ImageView cancelOrderTip;
    @NonNull
    public final TextView cancelOrderTipMessage;
    @NonNull
    public final ImageView close;
    @NonNull
    public final DSPrimaryButton openTipRiderPaymentWidget;
    @NonNull
    public final TextView riderTipInfoContent;
    @NonNull
    public final TextView riderTipInfoHeader;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView toTipRider;
    @NonNull
    public final TextView toTipRiderMessage;
    @NonNull
    public final ImageView toTipRiderWithCash;
    @NonNull
    public final TextView toTipRiderWithCashMessage;
    @NonNull
    public final ImageView toTipRiderWithEither;
    @NonNull
    public final TextView toTipRiderWithEitherMessage;

    private TipRiderInfoBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView3, @NonNull TextView textView4, @NonNull ImageView imageView4, @NonNull TextView textView5, @NonNull ImageView imageView5, @NonNull TextView textView6) {
        this.rootView = constraintLayout;
        this.cancelOrderTip = imageView;
        this.cancelOrderTipMessage = textView;
        this.close = imageView2;
        this.openTipRiderPaymentWidget = dSPrimaryButton;
        this.riderTipInfoContent = textView2;
        this.riderTipInfoHeader = textView3;
        this.toTipRider = imageView3;
        this.toTipRiderMessage = textView4;
        this.toTipRiderWithCash = imageView4;
        this.toTipRiderWithCashMessage = textView5;
        this.toTipRiderWithEither = imageView5;
        this.toTipRiderWithEitherMessage = textView6;
    }

    @NonNull
    public static TipRiderInfoBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.cancel_order_tip;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i11);
        if (imageView != null) {
            i11 = R.id.cancel_order_tip_message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
            if (textView != null) {
                i11 = R.id.close;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                if (imageView2 != null) {
                    i11 = R.id.open_tip_rider_payment_widget;
                    DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view2, i11);
                    if (dSPrimaryButton != null) {
                        i11 = R.id.rider_tip_info_content;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                        if (textView2 != null) {
                            i11 = R.id.rider_tip_info_header;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                            if (textView3 != null) {
                                i11 = R.id.to_tip_rider;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                if (imageView3 != null) {
                                    i11 = R.id.to_tip_rider_message;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                    if (textView4 != null) {
                                        i11 = R.id.to_tip_rider_with_cash;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                        if (imageView4 != null) {
                                            i11 = R.id.to_tip_rider_with_cash_message;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                            if (textView5 != null) {
                                                i11 = R.id.to_tip_rider_with_either;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                                if (imageView5 != null) {
                                                    i11 = R.id.to_tip_rider_with_either_message;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                    if (textView6 != null) {
                                                        return new TipRiderInfoBinding((ConstraintLayout) view2, imageView, textView, imageView2, dSPrimaryButton, textView2, textView3, imageView3, textView4, imageView4, textView5, imageView5, textView6);
                                                    }
                                                }
                                            }
                                        }
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
    public static TipRiderInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TipRiderInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.tip_rider_info, viewGroup, false);
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
