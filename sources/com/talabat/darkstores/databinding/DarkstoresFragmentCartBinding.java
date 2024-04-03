package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.customScrollingViews.CustomVerticalRecyclerView;
import com.talabat.darkstores.feature.cart.views.CartProgressView;

public final class DarkstoresFragmentCartBinding implements ViewBinding {
    @NonNull
    public final DarkstoresAgeRestrictionAlertBinding ageRestrictionAlert;
    @NonNull
    public final TextView cartEmptyTextView;
    @NonNull
    public final CartProgressView cartFragmentProgressView;
    @NonNull
    public final CustomVerticalRecyclerView cartRecyclerView;
    @NonNull
    public final DarkstoresFragmentCartSummaryBinding cartSummaryLayout;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final Toolbar toolbar;

    private DarkstoresFragmentCartBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DarkstoresAgeRestrictionAlertBinding darkstoresAgeRestrictionAlertBinding, @NonNull TextView textView, @NonNull CartProgressView cartProgressView, @NonNull CustomVerticalRecyclerView customVerticalRecyclerView, @NonNull DarkstoresFragmentCartSummaryBinding darkstoresFragmentCartSummaryBinding, @NonNull ProgressBar progressBar2, @NonNull Toolbar toolbar2) {
        this.rootView = constraintLayout;
        this.ageRestrictionAlert = darkstoresAgeRestrictionAlertBinding;
        this.cartEmptyTextView = textView;
        this.cartFragmentProgressView = cartProgressView;
        this.cartRecyclerView = customVerticalRecyclerView;
        this.cartSummaryLayout = darkstoresFragmentCartSummaryBinding;
        this.progressBar = progressBar2;
        this.toolbar = toolbar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r0 = com.talabat.darkstores.R.id.cartSummaryLayout;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresFragmentCartBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.darkstores.R.id.age_restriction_alert
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0059
            com.talabat.darkstores.databinding.DarkstoresAgeRestrictionAlertBinding r4 = com.talabat.darkstores.databinding.DarkstoresAgeRestrictionAlertBinding.bind(r1)
            int r0 = com.talabat.darkstores.R.id.cartEmptyTextView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0059
            int r0 = com.talabat.darkstores.R.id.cartFragmentProgressView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            com.talabat.darkstores.feature.cart.views.CartProgressView r6 = (com.talabat.darkstores.feature.cart.views.CartProgressView) r6
            if (r6 == 0) goto L_0x0059
            int r0 = com.talabat.darkstores.R.id.cartRecyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            com.talabat.darkstores.common.customScrollingViews.CustomVerticalRecyclerView r7 = (com.talabat.darkstores.common.customScrollingViews.CustomVerticalRecyclerView) r7
            if (r7 == 0) goto L_0x0059
            int r0 = com.talabat.darkstores.R.id.cartSummaryLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0059
            com.talabat.darkstores.databinding.DarkstoresFragmentCartSummaryBinding r8 = com.talabat.darkstores.databinding.DarkstoresFragmentCartSummaryBinding.bind(r1)
            int r0 = com.talabat.darkstores.R.id.progressBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.ProgressBar r9 = (android.widget.ProgressBar) r9
            if (r9 == 0) goto L_0x0059
            int r0 = com.talabat.darkstores.R.id.toolbar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            androidx.appcompat.widget.Toolbar r10 = (androidx.appcompat.widget.Toolbar) r10
            if (r10 == 0) goto L_0x0059
            com.talabat.darkstores.databinding.DarkstoresFragmentCartBinding r0 = new com.talabat.darkstores.databinding.DarkstoresFragmentCartBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0059:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresFragmentCartBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresFragmentCartBinding");
    }

    @NonNull
    public static DarkstoresFragmentCartBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentCartBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_cart, viewGroup, false);
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
