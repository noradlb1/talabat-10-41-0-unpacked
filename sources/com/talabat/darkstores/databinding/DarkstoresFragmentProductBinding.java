package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.view.LoadingFailedView;
import com.talabat.darkstores.feature.product.views.CartIndicator;
import com.talabat.feature.darkstorestooltip.presentation.TooltipView;

public final class DarkstoresFragmentProductBinding implements ViewBinding {
    @NonNull
    public final TooltipView basketLifetimeTooltipView;
    @NonNull
    public final ImageView btnClose;
    @NonNull
    public final CartIndicator cartIndicator;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final TooltipView extendedInfoTooltipView;
    @NonNull
    public final LoadingFailedView loadingFailedView;
    @NonNull
    public final DarkstoresFragmentProductScrollingContentBinding nestedProductScrollView;
    @NonNull
    private final ConstraintLayout rootView;

    private DarkstoresFragmentProductBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TooltipView tooltipView, @NonNull ImageView imageView, @NonNull CartIndicator cartIndicator2, @NonNull ConstraintLayout constraintLayout2, @NonNull TooltipView tooltipView2, @NonNull LoadingFailedView loadingFailedView2, @NonNull DarkstoresFragmentProductScrollingContentBinding darkstoresFragmentProductScrollingContentBinding) {
        this.rootView = constraintLayout;
        this.basketLifetimeTooltipView = tooltipView;
        this.btnClose = imageView;
        this.cartIndicator = cartIndicator2;
        this.container = constraintLayout2;
        this.extendedInfoTooltipView = tooltipView2;
        this.loadingFailedView = loadingFailedView2;
        this.nestedProductScrollView = darkstoresFragmentProductScrollingContentBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r0 = com.talabat.darkstores.R.id.nestedProductScrollView;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresFragmentProductBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.darkstores.R.id.basketLifetimeTooltipView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            com.talabat.feature.darkstorestooltip.presentation.TooltipView r4 = (com.talabat.feature.darkstorestooltip.presentation.TooltipView) r4
            if (r4 == 0) goto L_0x004e
            int r0 = com.talabat.darkstores.R.id.btnClose
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x004e
            int r0 = com.talabat.darkstores.R.id.cartIndicator
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            com.talabat.darkstores.feature.product.views.CartIndicator r6 = (com.talabat.darkstores.feature.product.views.CartIndicator) r6
            if (r6 == 0) goto L_0x004e
            r7 = r11
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            int r0 = com.talabat.darkstores.R.id.extendedInfoTooltipView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            com.talabat.feature.darkstorestooltip.presentation.TooltipView r8 = (com.talabat.feature.darkstorestooltip.presentation.TooltipView) r8
            if (r8 == 0) goto L_0x004e
            int r0 = com.talabat.darkstores.R.id.loadingFailedView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            com.talabat.darkstores.common.view.LoadingFailedView r9 = (com.talabat.darkstores.common.view.LoadingFailedView) r9
            if (r9 == 0) goto L_0x004e
            int r0 = com.talabat.darkstores.R.id.nestedProductScrollView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x004e
            com.talabat.darkstores.databinding.DarkstoresFragmentProductScrollingContentBinding r10 = com.talabat.darkstores.databinding.DarkstoresFragmentProductScrollingContentBinding.bind(r1)
            com.talabat.darkstores.databinding.DarkstoresFragmentProductBinding r11 = new com.talabat.darkstores.databinding.DarkstoresFragmentProductBinding
            r2 = r11
            r3 = r7
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        L_0x004e:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresFragmentProductBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresFragmentProductBinding");
    }

    @NonNull
    public static DarkstoresFragmentProductBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentProductBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_product, viewGroup, false);
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
