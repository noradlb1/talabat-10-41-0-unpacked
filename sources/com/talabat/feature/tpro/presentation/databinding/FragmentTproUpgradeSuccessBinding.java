package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;

public final class FragmentTproUpgradeSuccessBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonDismiss;
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final LinearLayout dimissUpgradeSuccess;
    @NonNull
    public final View ivBackground;
    @NonNull
    public final ImageView ivUpgradeSuccessImage;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvUpgradeSuccessDescription;
    @NonNull
    public final TextView tvUpgradeSuccessHeader;

    private FragmentTproUpgradeSuccessBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.actionButtonDismiss = textView;
        this.cancelButton = imageView;
        this.container = constraintLayout2;
        this.dimissUpgradeSuccess = linearLayout;
        this.ivBackground = view;
        this.ivUpgradeSuccessImage = imageView2;
        this.tvUpgradeSuccessDescription = textView2;
        this.tvUpgradeSuccessHeader = textView3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.iv_background;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeSuccessBinding bind(@androidx.annotation.NonNull android.view.View r12) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.action_button_dismiss
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0055
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0055
            r6 = r12
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            int r0 = com.talabat.feature.tpro.presentation.R.id.dimiss_upgrade_success
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0055
            int r0 = com.talabat.feature.tpro.presentation.R.id.iv_background
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r8 == 0) goto L_0x0055
            int r0 = com.talabat.feature.tpro.presentation.R.id.iv_upgrade_success_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0055
            int r0 = com.talabat.feature.tpro.presentation.R.id.tv_upgrade_success_description
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0055
            int r0 = com.talabat.feature.tpro.presentation.R.id.tv_upgrade_success_header
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0055
            com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeSuccessBinding r12 = new com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeSuccessBinding
            r2 = r12
            r3 = r6
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r12
        L_0x0055:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeSuccessBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeSuccessBinding");
    }

    @NonNull
    public static FragmentTproUpgradeSuccessBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproUpgradeSuccessBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_upgrade_success, viewGroup, false);
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
