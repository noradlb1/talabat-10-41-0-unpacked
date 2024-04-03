package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;

public final class ViewWalletPaymentOptionMarshmallowBinding implements ViewBinding {
    @NonNull
    public final ViewWalletPaymentWidgetNoCardBinding addNewCardView;
    @NonNull
    public final DefaultCardView cardContainer;
    @NonNull
    public final ConstraintLayout cardPaymentContainer;
    @NonNull
    public final ImageView creditCardIcon;
    @NonNull
    public final View divider;
    @NonNull
    public final Switch paymentChoiceSwitch;
    @NonNull
    public final TextView paymentModeStringSwitch;
    @NonNull
    public final LinearLayout paymentView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView talabatPayTextView;
    @NonNull
    public final TextView walletBalance;
    @NonNull
    public final ConstraintLayout walletPaymentContainer;

    private ViewWalletPaymentOptionMarshmallowBinding(@NonNull LinearLayout linearLayout, @NonNull ViewWalletPaymentWidgetNoCardBinding viewWalletPaymentWidgetNoCardBinding, @NonNull DefaultCardView defaultCardView, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull Switch switchR, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = linearLayout;
        this.addNewCardView = viewWalletPaymentWidgetNoCardBinding;
        this.cardContainer = defaultCardView;
        this.cardPaymentContainer = constraintLayout;
        this.creditCardIcon = imageView;
        this.divider = view;
        this.paymentChoiceSwitch = switchR;
        this.paymentModeStringSwitch = textView;
        this.paymentView = linearLayout2;
        this.talabatPayTextView = textView2;
        this.walletBalance = textView3;
        this.walletPaymentContainer = constraintLayout2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r0 = com.talabat.talabatcommon.R.id.divider;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatcommon.databinding.ViewWalletPaymentOptionMarshmallowBinding bind(@androidx.annotation.NonNull android.view.View r15) {
        /*
            int r0 = com.talabat.talabatcommon.R.id.add_new_card_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r1 == 0) goto L_0x0077
            com.talabat.talabatcommon.databinding.ViewWalletPaymentWidgetNoCardBinding r4 = com.talabat.talabatcommon.databinding.ViewWalletPaymentWidgetNoCardBinding.bind(r1)
            int r0 = com.talabat.talabatcommon.R.id.card_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView r5 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView) r5
            if (r5 == 0) goto L_0x0077
            int r0 = com.talabat.talabatcommon.R.id.card_payment_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0077
            int r0 = com.talabat.talabatcommon.R.id.credit_card_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0077
            int r0 = com.talabat.talabatcommon.R.id.divider
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r8 == 0) goto L_0x0077
            int r0 = com.talabat.talabatcommon.R.id.payment_choice_switch
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            android.widget.Switch r9 = (android.widget.Switch) r9
            if (r9 == 0) goto L_0x0077
            int r0 = com.talabat.talabatcommon.R.id.payment_mode_string_switch
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0077
            r11 = r15
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            int r0 = com.talabat.talabatcommon.R.id.talabat_pay_text_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0077
            int r0 = com.talabat.talabatcommon.R.id.wallet_balance
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0077
            int r0 = com.talabat.talabatcommon.R.id.wallet_payment_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x0077
            com.talabat.talabatcommon.databinding.ViewWalletPaymentOptionMarshmallowBinding r15 = new com.talabat.talabatcommon.databinding.ViewWalletPaymentOptionMarshmallowBinding
            r2 = r15
            r3 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r15
        L_0x0077:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.databinding.ViewWalletPaymentOptionMarshmallowBinding.bind(android.view.View):com.talabat.talabatcommon.databinding.ViewWalletPaymentOptionMarshmallowBinding");
    }

    @NonNull
    public static ViewWalletPaymentOptionMarshmallowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewWalletPaymentOptionMarshmallowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_wallet_payment_option_marshmallow, viewGroup, false);
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
