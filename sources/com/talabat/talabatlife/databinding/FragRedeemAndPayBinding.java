package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.talabat.talabatlife.R;

public final class FragRedeemAndPayBinding implements ViewBinding {
    @NonNull
    public final ImageButton backButton;
    @NonNull
    public final LinearLayout errorNotifyLinearLayout;
    @NonNull
    public final ViewRedeemAndPayPaymentBinding payment;
    @NonNull
    public final LottieAnimationView paymentProgressAnimation;
    @NonNull
    public final ViewRedeemAndPayPaymentSummaryBinding paymentSummary;
    @NonNull
    public final View paymentSummarySpacer;
    @NonNull
    public final LottieAnimationView progressAnimation;
    @NonNull
    public final TextView redeemAndPayButtonLabel;
    @NonNull
    public final LinearLayout redeemAndPayRedeemButton;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final ViewRedeemAndPayVendorOffersBinding vendorOffers;

    private FragRedeemAndPayBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageButton imageButton, @NonNull LinearLayout linearLayout, @NonNull ViewRedeemAndPayPaymentBinding viewRedeemAndPayPaymentBinding, @NonNull LottieAnimationView lottieAnimationView, @NonNull ViewRedeemAndPayPaymentSummaryBinding viewRedeemAndPayPaymentSummaryBinding, @NonNull View view, @NonNull LottieAnimationView lottieAnimationView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull Toolbar toolbar2, @NonNull ViewRedeemAndPayVendorOffersBinding viewRedeemAndPayVendorOffersBinding) {
        this.rootView = relativeLayout;
        this.backButton = imageButton;
        this.errorNotifyLinearLayout = linearLayout;
        this.payment = viewRedeemAndPayPaymentBinding;
        this.paymentProgressAnimation = lottieAnimationView;
        this.paymentSummary = viewRedeemAndPayPaymentSummaryBinding;
        this.paymentSummarySpacer = view;
        this.progressAnimation = lottieAnimationView2;
        this.redeemAndPayButtonLabel = textView;
        this.redeemAndPayRedeemButton = linearLayout2;
        this.toolbar = toolbar2;
        this.vendorOffers = viewRedeemAndPayVendorOffersBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        r0 = com.talabat.talabatlife.R.id.vendor_offers;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.talabat.talabatlife.R.id.payment;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r0 = com.talabat.talabatlife.R.id.payment_summary;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatlife.databinding.FragRedeemAndPayBinding bind(@androidx.annotation.NonNull android.view.View r15) {
        /*
            int r0 = com.talabat.talabatlife.R.id.backButton
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
            if (r4 == 0) goto L_0x0083
            int r0 = com.talabat.talabatlife.R.id.errorNotifyLinearLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x0083
            int r0 = com.talabat.talabatlife.R.id.payment
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r1 == 0) goto L_0x0083
            com.talabat.talabatlife.databinding.ViewRedeemAndPayPaymentBinding r6 = com.talabat.talabatlife.databinding.ViewRedeemAndPayPaymentBinding.bind(r1)
            int r0 = com.talabat.talabatlife.R.id.paymentProgressAnimation
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            com.airbnb.lottie.LottieAnimationView r7 = (com.airbnb.lottie.LottieAnimationView) r7
            if (r7 == 0) goto L_0x0083
            int r0 = com.talabat.talabatlife.R.id.payment_summary
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r1 == 0) goto L_0x0083
            com.talabat.talabatlife.databinding.ViewRedeemAndPayPaymentSummaryBinding r8 = com.talabat.talabatlife.databinding.ViewRedeemAndPayPaymentSummaryBinding.bind(r1)
            int r0 = com.talabat.talabatlife.R.id.paymentSummarySpacer
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r9 == 0) goto L_0x0083
            int r0 = com.talabat.talabatlife.R.id.progressAnimation
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            com.airbnb.lottie.LottieAnimationView r10 = (com.airbnb.lottie.LottieAnimationView) r10
            if (r10 == 0) goto L_0x0083
            int r0 = com.talabat.talabatlife.R.id.redeemAndPayButtonLabel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0083
            int r0 = com.talabat.talabatlife.R.id.redeemAndPayRedeemButton
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x0083
            int r0 = com.talabat.talabatlife.R.id.toolbar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            androidx.appcompat.widget.Toolbar r13 = (androidx.appcompat.widget.Toolbar) r13
            if (r13 == 0) goto L_0x0083
            int r0 = com.talabat.talabatlife.R.id.vendor_offers
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r1 == 0) goto L_0x0083
            com.talabat.talabatlife.databinding.ViewRedeemAndPayVendorOffersBinding r14 = com.talabat.talabatlife.databinding.ViewRedeemAndPayVendorOffersBinding.bind(r1)
            com.talabat.talabatlife.databinding.FragRedeemAndPayBinding r0 = new com.talabat.talabatlife.databinding.FragRedeemAndPayBinding
            r3 = r15
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x0083:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.databinding.FragRedeemAndPayBinding.bind(android.view.View):com.talabat.talabatlife.databinding.FragRedeemAndPayBinding");
    }

    @NonNull
    public static FragRedeemAndPayBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragRedeemAndPayBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_redeem_and_pay, viewGroup, false);
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
