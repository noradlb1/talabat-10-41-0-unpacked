package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.talabat.growth.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class LoginInfoContainerLifecycleVoucherLoadingBinding implements ViewBinding {
    @NonNull
    public final Guideline guideline2;
    @NonNull
    public final ImageView ivCoverLogo;
    @NonNull
    public final View lifecycleVoucherDescription1;
    @NonNull
    public final View lifecycleVoucherTitle1;
    @NonNull
    private final ShimmerLayout rootView;
    @NonNull
    public final View txtBrandCaption;
    @NonNull
    public final View txtLoginInfo1;
    @NonNull
    public final View txtLoginTitle1;
    @NonNull
    public final View voucherTag1;

    private LoginInfoContainerLifecycleVoucherLoadingBinding(@NonNull ShimmerLayout shimmerLayout, @NonNull Guideline guideline, @NonNull ImageView imageView, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull View view4, @NonNull View view5, @NonNull View view6) {
        this.rootView = shimmerLayout;
        this.guideline2 = guideline;
        this.ivCoverLogo = imageView;
        this.lifecycleVoucherDescription1 = view;
        this.lifecycleVoucherTitle1 = view2;
        this.txtBrandCaption = view3;
        this.txtLoginInfo1 = view4;
        this.txtLoginTitle1 = view5;
        this.voucherTag1 = view6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        r0 = com.talabat.growth.R.id.txt_login_info1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r0 = com.talabat.growth.R.id.txt_login_title1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        r0 = com.talabat.growth.R.id.voucherTag1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.talabat.growth.R.id.lifecycleVoucherDescription1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = com.talabat.growth.R.id.lifecycleVoucherTitle1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r0 = com.talabat.growth.R.id.txt_brand_caption;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.growth.databinding.LoginInfoContainerLifecycleVoucherLoadingBinding bind(@androidx.annotation.NonNull android.view.View r12) {
        /*
            int r0 = com.talabat.growth.R.id.guideline2
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            androidx.constraintlayout.widget.Guideline r4 = (androidx.constraintlayout.widget.Guideline) r4
            if (r4 == 0) goto L_0x0050
            int r0 = com.talabat.growth.R.id.iv_cover_logo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0050
            int r0 = com.talabat.growth.R.id.lifecycleVoucherDescription1
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r6 == 0) goto L_0x0050
            int r0 = com.talabat.growth.R.id.lifecycleVoucherTitle1
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r7 == 0) goto L_0x0050
            int r0 = com.talabat.growth.R.id.txt_brand_caption
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r8 == 0) goto L_0x0050
            int r0 = com.talabat.growth.R.id.txt_login_info1
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r9 == 0) goto L_0x0050
            int r0 = com.talabat.growth.R.id.txt_login_title1
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r10 == 0) goto L_0x0050
            int r0 = com.talabat.growth.R.id.voucherTag1
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r11 == 0) goto L_0x0050
            com.talabat.growth.databinding.LoginInfoContainerLifecycleVoucherLoadingBinding r0 = new com.talabat.growth.databinding.LoginInfoContainerLifecycleVoucherLoadingBinding
            r3 = r12
            com.talabat.talabatcommon.views.ShimmerLayout r3 = (com.talabat.talabatcommon.views.ShimmerLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0050:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.databinding.LoginInfoContainerLifecycleVoucherLoadingBinding.bind(android.view.View):com.talabat.growth.databinding.LoginInfoContainerLifecycleVoucherLoadingBinding");
    }

    @NonNull
    public static LoginInfoContainerLifecycleVoucherLoadingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LoginInfoContainerLifecycleVoucherLoadingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.login_info_container_lifecycle_voucher_loading, viewGroup, false);
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
