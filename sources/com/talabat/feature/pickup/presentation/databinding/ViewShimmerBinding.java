package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.pickup.presentation.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class ViewShimmerBinding implements ViewBinding {
    @NonNull
    public final ShimmerLayout filtersShimmer;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ShimmerVendorListViewBinding shimmer1;
    @NonNull
    public final ShimmerVendorListViewBinding shimmer2;
    @NonNull
    public final ShimmerVendorListViewBinding shimmer3;
    @NonNull
    public final ShimmerVendorListViewBinding shimmer4;
    @NonNull
    public final ShimmerVendorListViewBinding shimmer5;
    @NonNull
    public final ShimmerVendorListViewBinding shimmer6;
    @NonNull
    public final ShimmerLayout swimlanesShimmer;
    @NonNull
    public final ShimmerLayout valuePropShimmer;

    private ViewShimmerBinding(@NonNull LinearLayout linearLayout, @NonNull ShimmerLayout shimmerLayout, @NonNull ShimmerVendorListViewBinding shimmerVendorListViewBinding, @NonNull ShimmerVendorListViewBinding shimmerVendorListViewBinding2, @NonNull ShimmerVendorListViewBinding shimmerVendorListViewBinding3, @NonNull ShimmerVendorListViewBinding shimmerVendorListViewBinding4, @NonNull ShimmerVendorListViewBinding shimmerVendorListViewBinding5, @NonNull ShimmerVendorListViewBinding shimmerVendorListViewBinding6, @NonNull ShimmerLayout shimmerLayout2, @NonNull ShimmerLayout shimmerLayout3) {
        this.rootView = linearLayout;
        this.filtersShimmer = shimmerLayout;
        this.shimmer1 = shimmerVendorListViewBinding;
        this.shimmer2 = shimmerVendorListViewBinding2;
        this.shimmer3 = shimmerVendorListViewBinding3;
        this.shimmer4 = shimmerVendorListViewBinding4;
        this.shimmer5 = shimmerVendorListViewBinding5;
        this.shimmer6 = shimmerVendorListViewBinding6;
        this.swimlanesShimmer = shimmerLayout2;
        this.valuePropShimmer = shimmerLayout3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.feature.pickup.presentation.R.id.shimmer1;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.pickup.presentation.databinding.ViewShimmerBinding bind(@androidx.annotation.NonNull android.view.View r13) {
        /*
            int r0 = com.talabat.feature.pickup.presentation.R.id.filtersShimmer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            com.talabat.talabatcommon.views.ShimmerLayout r4 = (com.talabat.talabatcommon.views.ShimmerLayout) r4
            if (r4 == 0) goto L_0x0073
            int r0 = com.talabat.feature.pickup.presentation.R.id.shimmer1
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r1 == 0) goto L_0x0073
            com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding r5 = com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding.bind(r1)
            int r0 = com.talabat.feature.pickup.presentation.R.id.shimmer2
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r1 == 0) goto L_0x0073
            com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding r6 = com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding.bind(r1)
            int r0 = com.talabat.feature.pickup.presentation.R.id.shimmer3
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r1 == 0) goto L_0x0073
            com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding r7 = com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding.bind(r1)
            int r0 = com.talabat.feature.pickup.presentation.R.id.shimmer4
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r1 == 0) goto L_0x0073
            com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding r8 = com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding.bind(r1)
            int r0 = com.talabat.feature.pickup.presentation.R.id.shimmer5
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r1 == 0) goto L_0x0073
            com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding r9 = com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding.bind(r1)
            int r0 = com.talabat.feature.pickup.presentation.R.id.shimmer6
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r1 == 0) goto L_0x0073
            com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding r10 = com.talabat.feature.pickup.presentation.databinding.ShimmerVendorListViewBinding.bind(r1)
            int r0 = com.talabat.feature.pickup.presentation.R.id.swimlanesShimmer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            com.talabat.talabatcommon.views.ShimmerLayout r11 = (com.talabat.talabatcommon.views.ShimmerLayout) r11
            if (r11 == 0) goto L_0x0073
            int r0 = com.talabat.feature.pickup.presentation.R.id.valuePropShimmer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            com.talabat.talabatcommon.views.ShimmerLayout r12 = (com.talabat.talabatcommon.views.ShimmerLayout) r12
            if (r12 == 0) goto L_0x0073
            com.talabat.feature.pickup.presentation.databinding.ViewShimmerBinding r0 = new com.talabat.feature.pickup.presentation.databinding.ViewShimmerBinding
            r3 = r13
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x0073:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.pickup.presentation.databinding.ViewShimmerBinding.bind(android.view.View):com.talabat.feature.pickup.presentation.databinding.ViewShimmerBinding");
    }

    @NonNull
    public static ViewShimmerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewShimmerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_shimmer, viewGroup, false);
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
