package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_toast.DSToast;
import com.talabat.feature.tpro.presentation.R;

public final class FragmentTproSubscriptionDetailsBinding implements ViewBinding {
    @NonNull
    public final DSAlert alertUpgradeError;
    @NonNull
    public final LinearLayout bottomContainer;
    @NonNull
    public final DSPrimaryButton btnRenew;
    @NonNull
    public final DSToast dsToast;
    @NonNull
    public final LinearLayout errorNotifyLinearLayout;
    @NonNull
    public final ProgressBar pbDetails;
    @NonNull
    public final RelativeLayout progressLayout;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final RecyclerView rvTproDetailsContent;
    @NonNull
    public final ViewBenefitsShimmerBinding shimmer;

    private FragmentTproSubscriptionDetailsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSAlert dSAlert, @NonNull LinearLayout linearLayout, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull DSToast dSToast, @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull ViewBenefitsShimmerBinding viewBenefitsShimmerBinding) {
        this.rootView = constraintLayout;
        this.alertUpgradeError = dSAlert;
        this.bottomContainer = linearLayout;
        this.btnRenew = dSPrimaryButton;
        this.dsToast = dSToast;
        this.errorNotifyLinearLayout = linearLayout2;
        this.pbDetails = progressBar;
        this.progressLayout = relativeLayout;
        this.rvTproDetailsContent = recyclerView;
        this.shimmer = viewBenefitsShimmerBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.shimmer;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentTproSubscriptionDetailsBinding bind(@androidx.annotation.NonNull android.view.View r13) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.alert_upgrade_error
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            com.designsystem.ds_alert.DSAlert r4 = (com.designsystem.ds_alert.DSAlert) r4
            if (r4 == 0) goto L_0x006e
            int r0 = com.talabat.feature.tpro.presentation.R.id.bottom_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x006e
            int r0 = com.talabat.feature.tpro.presentation.R.id.btn_renew
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            com.designsystem.ds_button_v2.DSPrimaryButton r6 = (com.designsystem.ds_button_v2.DSPrimaryButton) r6
            if (r6 == 0) goto L_0x006e
            int r0 = com.talabat.feature.tpro.presentation.R.id.dsToast
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            com.designsystem.ds_toast.DSToast r7 = (com.designsystem.ds_toast.DSToast) r7
            if (r7 == 0) goto L_0x006e
            int r0 = com.talabat.feature.tpro.presentation.R.id.errorNotifyLinearLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x006e
            int r0 = com.talabat.feature.tpro.presentation.R.id.pb_details
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.ProgressBar r9 = (android.widget.ProgressBar) r9
            if (r9 == 0) goto L_0x006e
            int r0 = com.talabat.feature.tpro.presentation.R.id.progressLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            if (r10 == 0) goto L_0x006e
            int r0 = com.talabat.feature.tpro.presentation.R.id.rv_tpro_details_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            if (r11 == 0) goto L_0x006e
            int r0 = com.talabat.feature.tpro.presentation.R.id.shimmer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r1 == 0) goto L_0x006e
            com.talabat.feature.tpro.presentation.databinding.ViewBenefitsShimmerBinding r12 = com.talabat.feature.tpro.presentation.databinding.ViewBenefitsShimmerBinding.bind(r1)
            com.talabat.feature.tpro.presentation.databinding.FragmentTproSubscriptionDetailsBinding r0 = new com.talabat.feature.tpro.presentation.databinding.FragmentTproSubscriptionDetailsBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006e:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentTproSubscriptionDetailsBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentTproSubscriptionDetailsBinding");
    }

    @NonNull
    public static FragmentTproSubscriptionDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproSubscriptionDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_subscription_details, viewGroup, false);
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
