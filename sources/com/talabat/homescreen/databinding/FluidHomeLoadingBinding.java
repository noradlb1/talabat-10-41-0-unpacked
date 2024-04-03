package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.talabat.homescreen.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class FluidHomeLoadingBinding implements ViewBinding {
    @NonNull
    public final HorizontalScrollView bannerContainer;
    @NonNull
    public final View cardCornerBackground;
    @NonNull
    public final MaterialCardView cardView;
    @NonNull
    public final LinearLayout entryPointLargeContainer;
    @NonNull
    public final LinearLayout entryPointSmallContainer;
    @NonNull
    public final View entryPointTitle;
    @NonNull
    public final View heroBanner;
    @NonNull
    private final ShimmerLayout rootView;
    @NonNull
    public final HorizontalScrollView shortCutsContainer;
    @NonNull
    public final View shortCutsTitle;
    @NonNull
    public final View toolBar;

    private FluidHomeLoadingBinding(@NonNull ShimmerLayout shimmerLayout, @NonNull HorizontalScrollView horizontalScrollView, @NonNull View view, @NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull View view2, @NonNull View view3, @NonNull HorizontalScrollView horizontalScrollView2, @NonNull View view4, @NonNull View view5) {
        this.rootView = shimmerLayout;
        this.bannerContainer = horizontalScrollView;
        this.cardCornerBackground = view;
        this.cardView = materialCardView;
        this.entryPointLargeContainer = linearLayout;
        this.entryPointSmallContainer = linearLayout2;
        this.entryPointTitle = view2;
        this.heroBanner = view3;
        this.shortCutsContainer = horizontalScrollView2;
        this.shortCutsTitle = view4;
        this.toolBar = view5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        r0 = com.talabat.homescreen.R.id.entryPointTitle;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        r0 = com.talabat.homescreen.R.id.heroBanner;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        r0 = com.talabat.homescreen.R.id.shortCutsTitle;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r0 = com.talabat.homescreen.R.id.toolBar;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.homescreen.R.id.cardCornerBackground;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.homescreen.databinding.FluidHomeLoadingBinding bind(@androidx.annotation.NonNull android.view.View r14) {
        /*
            int r0 = com.talabat.homescreen.R.id.bannerContainer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            android.widget.HorizontalScrollView r4 = (android.widget.HorizontalScrollView) r4
            if (r4 == 0) goto L_0x0069
            int r0 = com.talabat.homescreen.R.id.cardCornerBackground
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r5 == 0) goto L_0x0069
            int r0 = com.talabat.homescreen.R.id.cardView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            com.google.android.material.card.MaterialCardView r6 = (com.google.android.material.card.MaterialCardView) r6
            if (r6 == 0) goto L_0x0069
            int r0 = com.talabat.homescreen.R.id.entryPointLargeContainer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0069
            int r0 = com.talabat.homescreen.R.id.entryPointSmallContainer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x0069
            int r0 = com.talabat.homescreen.R.id.entryPointTitle
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r9 == 0) goto L_0x0069
            int r0 = com.talabat.homescreen.R.id.heroBanner
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r10 == 0) goto L_0x0069
            int r0 = com.talabat.homescreen.R.id.shortCutsContainer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.HorizontalScrollView r11 = (android.widget.HorizontalScrollView) r11
            if (r11 == 0) goto L_0x0069
            int r0 = com.talabat.homescreen.R.id.shortCutsTitle
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r12 == 0) goto L_0x0069
            int r0 = com.talabat.homescreen.R.id.toolBar
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r13 == 0) goto L_0x0069
            com.talabat.homescreen.databinding.FluidHomeLoadingBinding r0 = new com.talabat.homescreen.databinding.FluidHomeLoadingBinding
            r3 = r14
            com.talabat.talabatcommon.views.ShimmerLayout r3 = (com.talabat.talabatcommon.views.ShimmerLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0069:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.homescreen.databinding.FluidHomeLoadingBinding.bind(android.view.View):com.talabat.homescreen.databinding.FluidHomeLoadingBinding");
    }

    @NonNull
    public static FluidHomeLoadingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FluidHomeLoadingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fluid_home_loading, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ShimmerLayout getRoot() {
        return this.rootView;
    }
}
