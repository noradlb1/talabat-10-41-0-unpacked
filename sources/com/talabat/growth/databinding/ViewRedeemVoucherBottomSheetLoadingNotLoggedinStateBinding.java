package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.growth.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding implements ViewBinding {
    @NonNull
    private final ShimmerLayout rootView;
    @NonNull
    public final View view1;
    @NonNull
    public final View view2;
    @NonNull
    public final View view3;
    @NonNull
    public final View view4;
    @NonNull
    public final View view5;
    @NonNull
    public final View view6;

    private ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding(@NonNull ShimmerLayout shimmerLayout, @NonNull View view, @NonNull View view7, @NonNull View view8, @NonNull View view9, @NonNull View view10, @NonNull View view11) {
        this.rootView = shimmerLayout;
        this.view1 = view;
        this.view2 = view7;
        this.view3 = view8;
        this.view4 = view9;
        this.view5 = view10;
        this.view6 = view11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        r0 = com.talabat.growth.R.id.view6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.talabat.growth.R.id.view2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = com.talabat.growth.R.id.view3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r0 = com.talabat.growth.R.id.view4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r0 = com.talabat.growth.R.id.view5;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding bind(@androidx.annotation.NonNull android.view.View r9) {
        /*
            int r0 = com.talabat.growth.R.id.view1
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r3 == 0) goto L_0x003a
            int r0 = com.talabat.growth.R.id.view2
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r4 == 0) goto L_0x003a
            int r0 = com.talabat.growth.R.id.view3
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r5 == 0) goto L_0x003a
            int r0 = com.talabat.growth.R.id.view4
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r6 == 0) goto L_0x003a
            int r0 = com.talabat.growth.R.id.view5
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r7 == 0) goto L_0x003a
            int r0 = com.talabat.growth.R.id.view6
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r8 == 0) goto L_0x003a
            com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding r0 = new com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding
            r2 = r9
            com.talabat.talabatcommon.views.ShimmerLayout r2 = (com.talabat.talabatcommon.views.ShimmerLayout) r2
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003a:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding.bind(android.view.View):com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding");
    }

    @NonNull
    public static ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_redeem_voucher_bottom_sheet_loading_not_loggedin_state, viewGroup, false);
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
