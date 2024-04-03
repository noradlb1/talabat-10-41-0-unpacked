package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.talabatcore.databinding.GenericProgressBarBinding;

public final class FragmentUnlockProBenefitsBinding implements ViewBinding {
    @NonNull
    public final AppCompatTextView actionButtonText;
    @NonNull
    public final AppCompatImageView cancelAnytimeIv;
    @NonNull
    public final AppCompatTextView cancelAnytimeText;
    @NonNull
    public final AppCompatImageView cancelButton;
    @NonNull
    public final AppCompatImageView deliveryBikeIv;
    @NonNull
    public final View descriptionDivider;
    @NonNull
    public final AppCompatTextView keepTrialTitle;
    @NonNull
    public final GenericProgressBarBinding progressBar;
    @NonNull
    public final AppCompatImageView rewardIv;
    @NonNull
    public final AppCompatTextView rewardText;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final AppCompatTextView saveMoneyText;
    @NonNull
    public final LinearLayout startExploringLayout;
    @NonNull
    public final AppCompatTextView unlimitedFreeDeliveryText;
    @NonNull
    public final AppCompatImageView walletIv;

    private FragmentUnlockProBenefitsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull View view, @NonNull AppCompatTextView appCompatTextView3, @NonNull GenericProgressBarBinding genericProgressBarBinding, @NonNull AppCompatImageView appCompatImageView4, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatImageView appCompatImageView5) {
        this.rootView = constraintLayout;
        this.actionButtonText = appCompatTextView;
        this.cancelAnytimeIv = appCompatImageView;
        this.cancelAnytimeText = appCompatTextView2;
        this.cancelButton = appCompatImageView2;
        this.deliveryBikeIv = appCompatImageView3;
        this.descriptionDivider = view;
        this.keepTrialTitle = appCompatTextView3;
        this.progressBar = genericProgressBarBinding;
        this.rewardIv = appCompatImageView4;
        this.rewardText = appCompatTextView4;
        this.saveMoneyText = appCompatTextView5;
        this.startExploringLayout = linearLayout;
        this.unlimitedFreeDeliveryText = appCompatTextView6;
        this.walletIv = appCompatImageView5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.description_divider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.progress_bar;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentUnlockProBenefitsBinding bind(@androidx.annotation.NonNull android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.talabat.feature.tpro.presentation.R.id.action_button_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.appcompat.widget.AppCompatTextView r5 = (androidx.appcompat.widget.AppCompatTextView) r5
            if (r5 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.cancel_anytime_iv
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            if (r6 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.cancel_anytime_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            if (r7 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.cancel_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.appcompat.widget.AppCompatImageView r8 = (androidx.appcompat.widget.AppCompatImageView) r8
            if (r8 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.delivery_bike_iv
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.appcompat.widget.AppCompatImageView r9 = (androidx.appcompat.widget.AppCompatImageView) r9
            if (r9 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.description_divider
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.keep_trial_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.appcompat.widget.AppCompatTextView r11 = (androidx.appcompat.widget.AppCompatTextView) r11
            if (r11 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.progress_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00a7
            com.talabat.talabatcore.databinding.GenericProgressBarBinding r12 = com.talabat.talabatcore.databinding.GenericProgressBarBinding.bind(r2)
            int r1 = com.talabat.feature.tpro.presentation.R.id.reward_iv
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.appcompat.widget.AppCompatImageView r13 = (androidx.appcompat.widget.AppCompatImageView) r13
            if (r13 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.reward_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.appcompat.widget.AppCompatTextView r14 = (androidx.appcompat.widget.AppCompatTextView) r14
            if (r14 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.save_money_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.appcompat.widget.AppCompatTextView r15 = (androidx.appcompat.widget.AppCompatTextView) r15
            if (r15 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.start_exploring_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.unlimited_free_delivery_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.appcompat.widget.AppCompatTextView r17 = (androidx.appcompat.widget.AppCompatTextView) r17
            if (r17 == 0) goto L_0x00a7
            int r1 = com.talabat.feature.tpro.presentation.R.id.wallet_iv
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            androidx.appcompat.widget.AppCompatImageView r18 = (androidx.appcompat.widget.AppCompatImageView) r18
            if (r18 == 0) goto L_0x00a7
            com.talabat.feature.tpro.presentation.databinding.FragmentUnlockProBenefitsBinding r1 = new com.talabat.feature.tpro.presentation.databinding.FragmentUnlockProBenefitsBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        L_0x00a7:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentUnlockProBenefitsBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentUnlockProBenefitsBinding");
    }

    @NonNull
    public static FragmentUnlockProBenefitsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentUnlockProBenefitsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_unlock_pro_benefits, viewGroup, false);
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
