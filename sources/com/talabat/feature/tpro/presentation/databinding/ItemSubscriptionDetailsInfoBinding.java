package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.talabatcommon.views.wallet.dsalert.DSAlertView;

public final class ItemSubscriptionDetailsInfoBinding implements ViewBinding {
    @NonNull
    public final TextView btnUpgrade;
    @NonNull
    public final DSAlertView dsAlertView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final View separatorSubscriptionDetailsInfo;
    @NonNull
    public final View separatorSubscriptionDetailsTop;
    @NonNull
    public final View separatorSubscriptionPlanDuration;
    @NonNull
    public final TextView tvAutoUpgradeDateContent;
    @NonNull
    public final TextView tvPlanDurationContent;
    @NonNull
    public final TextView tvPlanDurationTitle;
    @NonNull
    public final TextView tvPrice;
    @NonNull
    public final TextView tvPriceContent;
    @NonNull
    public final TextView tvRenewalDateContent;
    @NonNull
    public final TextView tvRenewalHeader;
    @NonNull
    public final TextView tvSubscriptionStatus;

    private ItemSubscriptionDetailsInfoBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull DSAlertView dSAlertView, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9) {
        this.rootView = constraintLayout;
        this.btnUpgrade = textView;
        this.dsAlertView = dSAlertView;
        this.separatorSubscriptionDetailsInfo = view;
        this.separatorSubscriptionDetailsTop = view2;
        this.separatorSubscriptionPlanDuration = view3;
        this.tvAutoUpgradeDateContent = textView2;
        this.tvPlanDurationContent = textView3;
        this.tvPlanDurationTitle = textView4;
        this.tvPrice = textView5;
        this.tvPriceContent = textView6;
        this.tvRenewalDateContent = textView7;
        this.tvRenewalHeader = textView8;
        this.tvSubscriptionStatus = textView9;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_details_info;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_details_top;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_plan_duration;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding bind(@androidx.annotation.NonNull android.view.View r18) {
        /*
            r0 = r18
            int r1 = com.talabat.feature.tpro.presentation.R.id.btn_upgrade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.ds_alert_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.talabat.talabatcommon.views.wallet.dsalert.DSAlertView r6 = (com.talabat.talabatcommon.views.wallet.dsalert.DSAlertView) r6
            if (r6 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_details_info
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_details_top
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_plan_duration
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_auto_upgrade_date_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_plan_duration_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_plan_duration_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_price
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_price_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_renewal_date_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_renewal_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0094
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_subscription_status
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x0094
            com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding r1 = new com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r1
        L_0x0094:
            android.content.res.Resources r0 = r18.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsInfoBinding");
    }

    @NonNull
    public static ItemSubscriptionDetailsInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemSubscriptionDetailsInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_subscription_details_info, viewGroup, false);
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
