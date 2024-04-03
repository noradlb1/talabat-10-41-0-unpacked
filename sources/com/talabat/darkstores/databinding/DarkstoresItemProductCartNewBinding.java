package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.ItemCounterNew;

public final class DarkstoresItemProductCartNewBinding implements ViewBinding {
    @NonNull
    public final TextView campaignMessage;
    @NonNull
    public final Guideline endGuideline;
    @NonNull
    public final DarkstoresCartFreeQuantityTagBinding freeQuantityContainer;
    @NonNull
    public final ImageView image;
    @NonNull
    public final FrameLayout imageContainerFrameLayout;
    @NonNull
    public final DarkstoresItemProductCartOosPredictedExpirementBinding oosAlert;
    @NonNull
    public final FrameLayout oosAlertContainer;
    @NonNull
    public final TextView productAgeRestriction;
    @NonNull
    public final ItemCounterNew productTileCounter;
    @NonNull
    public final LinearLayout promoScoreContainer;
    @NonNull
    public final LinearLayout promotionsLayout;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final PromoTagCartBinding tvOfferBadge;
    @NonNull
    public final TextView tvPreviousPrice;
    @NonNull
    public final TextView tvPrice;
    @NonNull
    public final TextView tvTitle;

    private DarkstoresItemProductCartNewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull Guideline guideline, @NonNull DarkstoresCartFreeQuantityTagBinding darkstoresCartFreeQuantityTagBinding, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull DarkstoresItemProductCartOosPredictedExpirementBinding darkstoresItemProductCartOosPredictedExpirementBinding, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2, @NonNull ItemCounterNew itemCounterNew, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull PromoTagCartBinding promoTagCartBinding, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.rootView = constraintLayout;
        this.campaignMessage = textView;
        this.endGuideline = guideline;
        this.freeQuantityContainer = darkstoresCartFreeQuantityTagBinding;
        this.image = imageView;
        this.imageContainerFrameLayout = frameLayout;
        this.oosAlert = darkstoresItemProductCartOosPredictedExpirementBinding;
        this.oosAlertContainer = frameLayout2;
        this.productAgeRestriction = textView2;
        this.productTileCounter = itemCounterNew;
        this.promoScoreContainer = linearLayout;
        this.promotionsLayout = linearLayout2;
        this.tvOfferBadge = promoTagCartBinding;
        this.tvPreviousPrice = textView3;
        this.tvPrice = textView4;
        this.tvTitle = textView5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r1 = com.talabat.darkstores.R.id.oos_alert;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        r1 = com.talabat.darkstores.R.id.tvOfferBadge;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.talabat.darkstores.R.id.free_quantity_container;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresItemProductCartNewBinding bind(@androidx.annotation.NonNull android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.talabat.darkstores.R.id.campaign_message
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.endGuideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.Guideline r6 = (androidx.constraintlayout.widget.Guideline) r6
            if (r6 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.free_quantity_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00b7
            com.talabat.darkstores.databinding.DarkstoresCartFreeQuantityTagBinding r7 = com.talabat.darkstores.databinding.DarkstoresCartFreeQuantityTagBinding.bind(r2)
            int r1 = com.talabat.darkstores.R.id.image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.imageContainerFrameLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.FrameLayout r9 = (android.widget.FrameLayout) r9
            if (r9 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.oos_alert
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00b7
            com.talabat.darkstores.databinding.DarkstoresItemProductCartOosPredictedExpirementBinding r10 = com.talabat.darkstores.databinding.DarkstoresItemProductCartOosPredictedExpirementBinding.bind(r2)
            int r1 = com.talabat.darkstores.R.id.oos_alert_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.FrameLayout r11 = (android.widget.FrameLayout) r11
            if (r11 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.product_age_restriction
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.product_tile_counter
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.talabat.darkstores.common.view.ItemCounterNew r13 = (com.talabat.darkstores.common.view.ItemCounterNew) r13
            if (r13 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.promo_score_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.promotionsLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            if (r15 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.tvOfferBadge
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00b7
            com.talabat.darkstores.databinding.PromoTagCartBinding r16 = com.talabat.darkstores.databinding.PromoTagCartBinding.bind(r2)
            int r1 = com.talabat.darkstores.R.id.tvPreviousPrice
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.tvPrice
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00b7
            int r1 = com.talabat.darkstores.R.id.tvTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00b7
            com.talabat.darkstores.databinding.DarkstoresItemProductCartNewBinding r1 = new com.talabat.darkstores.databinding.DarkstoresItemProductCartNewBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        L_0x00b7:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresItemProductCartNewBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresItemProductCartNewBinding");
    }

    @NonNull
    public static DarkstoresItemProductCartNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemProductCartNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_product_cart_new, viewGroup, false);
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
