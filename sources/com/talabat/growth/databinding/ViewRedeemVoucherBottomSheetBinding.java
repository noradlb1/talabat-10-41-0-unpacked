package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.growth.R;

public final class ViewRedeemVoucherBottomSheetBinding implements ViewBinding {
    @NonNull
    public final ImageView closeBottomSheet;
    @NonNull
    public final ViewRedeemVoucherBottomSheetLoadingLoggedInStateBinding loadingLoggedInViewState;
    @NonNull
    public final ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding loadingNotLoggedInViewState;
    @NonNull
    public final ViewRedeemVoucherBottomSheetLoggedInStateBinding loggedInState;
    @NonNull
    public final ViewRedeemVoucherBottomSheetNotLoggedInStateBinding notLoggedInState;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView titleBottomSheet;

    private ViewRedeemVoucherBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ViewRedeemVoucherBottomSheetLoadingLoggedInStateBinding viewRedeemVoucherBottomSheetLoadingLoggedInStateBinding, @NonNull ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding viewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding, @NonNull ViewRedeemVoucherBottomSheetLoggedInStateBinding viewRedeemVoucherBottomSheetLoggedInStateBinding, @NonNull ViewRedeemVoucherBottomSheetNotLoggedInStateBinding viewRedeemVoucherBottomSheetNotLoggedInStateBinding, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.closeBottomSheet = imageView;
        this.loadingLoggedInViewState = viewRedeemVoucherBottomSheetLoadingLoggedInStateBinding;
        this.loadingNotLoggedInViewState = viewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding;
        this.loggedInState = viewRedeemVoucherBottomSheetLoggedInStateBinding;
        this.notLoggedInState = viewRedeemVoucherBottomSheetNotLoggedInStateBinding;
        this.titleBottomSheet = textView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.growth.R.id.loadingLoggedInViewState;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetBinding bind(@androidx.annotation.NonNull android.view.View r10) {
        /*
            int r0 = com.talabat.growth.R.id.closeBottomSheet
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0050
            int r0 = com.talabat.growth.R.id.loadingLoggedInViewState
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r1 == 0) goto L_0x0050
            com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoadingLoggedInStateBinding r5 = com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoadingLoggedInStateBinding.bind(r1)
            int r0 = com.talabat.growth.R.id.loadingNotLoggedInViewState
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r1 == 0) goto L_0x0050
            com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding r6 = com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoadingNotLoggedinStateBinding.bind(r1)
            int r0 = com.talabat.growth.R.id.loggedInState
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r1 == 0) goto L_0x0050
            com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoggedInStateBinding r7 = com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetLoggedInStateBinding.bind(r1)
            int r0 = com.talabat.growth.R.id.notLoggedInState
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r1 == 0) goto L_0x0050
            com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetNotLoggedInStateBinding r8 = com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetNotLoggedInStateBinding.bind(r1)
            int r0 = com.talabat.growth.R.id.titleBottomSheet
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0050
            com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetBinding r0 = new com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0050:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetBinding.bind(android.view.View):com.talabat.growth.databinding.ViewRedeemVoucherBottomSheetBinding");
    }

    @NonNull
    public static ViewRedeemVoucherBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewRedeemVoucherBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_redeem_voucher_bottom_sheet, viewGroup, false);
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
