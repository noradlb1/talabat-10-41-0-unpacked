package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.ItemCounterNew;

public final class DarkstoresItemProductCartNewCompactBinding implements ViewBinding {
    @NonNull
    public final CardView cvProductImage;
    @NonNull
    public final ItemCounterNew itemCounter;
    @NonNull
    public final AppCompatImageView ivAlert;
    @NonNull
    public final ImageView ivProductImage;
    @NonNull
    public final DarkstoresItemProductCartOosPredictedExpirementBinding oosAlert;
    @NonNull
    public final FrameLayout oosAlertContainer;
    @NonNull
    public final View overlay;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvAlert;
    @NonNull
    public final TextView tvPrice;
    @NonNull
    public final TextView tvTitle;

    private DarkstoresItemProductCartNewCompactBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CardView cardView, @NonNull ItemCounterNew itemCounterNew, @NonNull AppCompatImageView appCompatImageView, @NonNull ImageView imageView, @NonNull DarkstoresItemProductCartOosPredictedExpirementBinding darkstoresItemProductCartOosPredictedExpirementBinding, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.cvProductImage = cardView;
        this.itemCounter = itemCounterNew;
        this.ivAlert = appCompatImageView;
        this.ivProductImage = imageView;
        this.oosAlert = darkstoresItemProductCartOosPredictedExpirementBinding;
        this.oosAlertContainer = frameLayout;
        this.overlay = view;
        this.tvAlert = textView;
        this.tvPrice = textView2;
        this.tvTitle = textView3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        r0 = com.talabat.darkstores.R.id.overlay;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.talabat.darkstores.R.id.oos_alert;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresItemProductCartNewCompactBinding bind(@androidx.annotation.NonNull android.view.View r14) {
        /*
            int r0 = com.talabat.darkstores.R.id.cvProductImage
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            androidx.cardview.widget.CardView r4 = (androidx.cardview.widget.CardView) r4
            if (r4 == 0) goto L_0x0076
            int r0 = com.talabat.darkstores.R.id.itemCounter
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            com.talabat.darkstores.common.view.ItemCounterNew r5 = (com.talabat.darkstores.common.view.ItemCounterNew) r5
            if (r5 == 0) goto L_0x0076
            int r0 = com.talabat.darkstores.R.id.ivAlert
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            if (r6 == 0) goto L_0x0076
            int r0 = com.talabat.darkstores.R.id.ivProductImage
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0076
            int r0 = com.talabat.darkstores.R.id.oos_alert
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r1 == 0) goto L_0x0076
            com.talabat.darkstores.databinding.DarkstoresItemProductCartOosPredictedExpirementBinding r8 = com.talabat.darkstores.databinding.DarkstoresItemProductCartOosPredictedExpirementBinding.bind(r1)
            int r0 = com.talabat.darkstores.R.id.oos_alert_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            android.widget.FrameLayout r9 = (android.widget.FrameLayout) r9
            if (r9 == 0) goto L_0x0076
            int r0 = com.talabat.darkstores.R.id.overlay
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r10 == 0) goto L_0x0076
            int r0 = com.talabat.darkstores.R.id.tvAlert
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0076
            int r0 = com.talabat.darkstores.R.id.tvPrice
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0076
            int r0 = com.talabat.darkstores.R.id.tvTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0076
            com.talabat.darkstores.databinding.DarkstoresItemProductCartNewCompactBinding r0 = new com.talabat.darkstores.databinding.DarkstoresItemProductCartNewCompactBinding
            r3 = r14
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0076:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresItemProductCartNewCompactBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresItemProductCartNewCompactBinding");
    }

    @NonNull
    public static DarkstoresItemProductCartNewCompactBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemProductCartNewCompactBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_product_cart_new_compact, viewGroup, false);
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
