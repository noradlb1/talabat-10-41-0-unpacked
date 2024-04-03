package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;

public final class ItemSubscriptionDetailsManageBinding implements ViewBinding {
    @NonNull
    public final LinearLayoutCompat containerEndMembership;
    @NonNull
    public final LinearLayoutCompat containerManageAutoUpgrade;
    @NonNull
    public final ConstraintLayout containerManageTnc;
    @NonNull
    public final ImageView ivEndSubscription;
    @NonNull
    public final AppCompatImageView ivEndSubscriptionNext;
    @NonNull
    public final AppCompatImageView ivManageAutoUpgrade;
    @NonNull
    public final AppCompatImageView ivManageAutoUpgradeNext;
    @NonNull
    public final ImageView ivTnc;
    @NonNull
    public final AppCompatImageView ivTncNext;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final View separatorManageAutoUpgrade;
    @NonNull
    public final View separatorSubscriptionDetailsManageInfo;
    @NonNull
    public final TextView tvHeaderManagerSubscription;
    @NonNull
    public final TextView tvManageAutoUpgrade;
    @NonNull
    public final TextView tvManageEndSub;
    @NonNull
    public final TextView tvManageTnc;

    private ItemSubscriptionDetailsManageBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull ImageView imageView2, @NonNull AppCompatImageView appCompatImageView4, @NonNull View view, @NonNull View view2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.containerEndMembership = linearLayoutCompat;
        this.containerManageAutoUpgrade = linearLayoutCompat2;
        this.containerManageTnc = constraintLayout2;
        this.ivEndSubscription = imageView;
        this.ivEndSubscriptionNext = appCompatImageView;
        this.ivManageAutoUpgrade = appCompatImageView2;
        this.ivManageAutoUpgradeNext = appCompatImageView3;
        this.ivTnc = imageView2;
        this.ivTncNext = appCompatImageView4;
        this.separatorManageAutoUpgrade = view;
        this.separatorSubscriptionDetailsManageInfo = view2;
        this.tvHeaderManagerSubscription = textView;
        this.tvManageAutoUpgrade = textView2;
        this.tvManageEndSub = textView3;
        this.tvManageTnc = textView4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.separator_manage_auto_upgrade;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_details_manage_info;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsManageBinding bind(@androidx.annotation.NonNull android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.talabat.feature.tpro.presentation.R.id.container_end_membership
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.appcompat.widget.LinearLayoutCompat r5 = (androidx.appcompat.widget.LinearLayoutCompat) r5
            if (r5 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.container_manage_auto_upgrade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.appcompat.widget.LinearLayoutCompat r6 = (androidx.appcompat.widget.LinearLayoutCompat) r6
            if (r6 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.container_manage_tnc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.iv_end_subscription
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.iv_end_subscription_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.appcompat.widget.AppCompatImageView r9 = (androidx.appcompat.widget.AppCompatImageView) r9
            if (r9 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.iv_manage_auto_upgrade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.appcompat.widget.AppCompatImageView r10 = (androidx.appcompat.widget.AppCompatImageView) r10
            if (r10 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.iv_manage_auto_upgrade_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.appcompat.widget.AppCompatImageView r11 = (androidx.appcompat.widget.AppCompatImageView) r11
            if (r11 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.iv_tnc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.iv_tnc_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.appcompat.widget.AppCompatImageView r13 = (androidx.appcompat.widget.AppCompatImageView) r13
            if (r13 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.separator_manage_auto_upgrade
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r14 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.separator_subscription_details_manage_info
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r15 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_header_manager_subscription
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_manage_auto_upgrade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_manage_end_sub
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00af
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_manage_tnc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00af
            com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsManageBinding r1 = new com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsManageBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        L_0x00af:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsManageBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.ItemSubscriptionDetailsManageBinding");
    }

    @NonNull
    public static ItemSubscriptionDetailsManageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemSubscriptionDetailsManageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_subscription_details_manage, viewGroup, false);
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
