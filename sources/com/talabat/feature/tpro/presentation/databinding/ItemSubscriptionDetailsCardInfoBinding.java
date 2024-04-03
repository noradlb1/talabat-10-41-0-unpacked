package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.talabatcommon.views.ShimmerLayout;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;

public final class ItemSubscriptionDetailsCardInfoBinding implements ViewBinding {
    @NonNull
    public final FrameLayout paymentView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final View separatorSubscriptionDetailsCardBottom;
    @NonNull
    public final TextView tvCardDetailsHeader;
    @NonNull
    public final ShimmerLayout walletPaymentLoading;
    @NonNull
    public final DefaultCardView walletPaymentWidget;

    private ItemSubscriptionDetailsCardInfoBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull TextView textView, @NonNull ShimmerLayout shimmerLayout, @NonNull DefaultCardView defaultCardView) {
        this.rootView = constraintLayout;
        this.paymentView = frameLayout;
        this.separatorSubscriptionDetailsCardBottom = view;
        this.tvCardDetailsHeader = textView;
        this.walletPaymentLoading = shimmerLayout;
        this.walletPaymentWidget = defaultCardView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_details_card_bottom;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsCardInfoBinding bind(@androidx.annotation.NonNull android.view.View r9) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.paymentView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x003e
            int r0 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_details_card_bottom
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r5 == 0) goto L_0x003e
            int r0 = com.talabat.feature.tpro.presentation.R.id.tv_card_details_header
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x003e
            int r0 = com.talabat.feature.tpro.presentation.R.id.wallet_payment_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            com.talabat.talabatcommon.views.ShimmerLayout r7 = (com.talabat.talabatcommon.views.ShimmerLayout) r7
            if (r7 == 0) goto L_0x003e
            int r0 = com.talabat.feature.tpro.presentation.R.id.wallet_payment_widget
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView r8 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView) r8
            if (r8 == 0) goto L_0x003e
            com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsCardInfoBinding r0 = new com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsCardInfoBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003e:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsCardInfoBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsCardInfoBinding");
    }

    @NonNull
    public static ItemSubscriptionDetailsCardInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemSubscriptionDetailsCardInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_subscription_details_card_info, viewGroup, false);
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
