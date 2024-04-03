package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;

public final class FragmentTproUpgradeDetailsBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonUpgrade;
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final LinearLayout confirmUpgradeProLayout;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final ProgressBar genericProgressBar;
    @NonNull
    public final View ivBackground;
    @NonNull
    public final ImageView ivUpgradeImage;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final RecyclerView rvUpgradeBenefits;
    @NonNull
    public final TextView tvUpgradeHeader;
    @NonNull
    public final TextView tvUpgradeInfo;

    private FragmentTproUpgradeDetailsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ProgressBar progressBar, @NonNull View view, @NonNull ImageView imageView2, @NonNull RecyclerView recyclerView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.actionButtonUpgrade = textView;
        this.cancelButton = imageView;
        this.confirmUpgradeProLayout = linearLayout;
        this.container = constraintLayout2;
        this.genericProgressBar = progressBar;
        this.ivBackground = view;
        this.ivUpgradeImage = imageView2;
        this.rvUpgradeBenefits = recyclerView;
        this.tvUpgradeHeader = textView2;
        this.tvUpgradeInfo = textView3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.iv_background;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeDetailsBinding bind(@androidx.annotation.NonNull android.view.View r14) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.action_button_upgrade
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.confirm_upgrade_pro_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x006b
            r7 = r14
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            int r0 = com.talabat.feature.tpro.presentation.R.id.genericProgressBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            android.widget.ProgressBar r8 = (android.widget.ProgressBar) r8
            if (r8 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.iv_background
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r9 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.iv_upgrade_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.rv_upgrade_benefits
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            if (r11 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.tv_upgrade_header
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.tv_upgrade_info
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x006b
            com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeDetailsBinding r14 = new com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeDetailsBinding
            r2 = r14
            r3 = r7
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r14
        L_0x006b:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeDetailsBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeDetailsBinding");
    }

    @NonNull
    public static FragmentTproUpgradeDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproUpgradeDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_upgrade_details, viewGroup, false);
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
