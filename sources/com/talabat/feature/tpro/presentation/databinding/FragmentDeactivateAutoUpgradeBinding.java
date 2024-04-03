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

public final class FragmentDeactivateAutoUpgradeBinding implements ViewBinding {
    @NonNull
    public final AppCompatTextView actionButtonText;
    @NonNull
    public final AppCompatImageView cancelButton;
    @NonNull
    public final AppCompatTextView cancelTrialSubtitle;
    @NonNull
    public final AppCompatTextView cancelTrialTitle;
    @NonNull
    public final AppCompatTextView continueProPlanText;
    @NonNull
    public final LinearLayout deactivateAutoUpgradeLayout;
    @NonNull
    public final AppCompatTextView descriptionBenefitLoss;
    @NonNull
    public final View descriptionDivider;
    @NonNull
    public final ConstraintLayout headerContainer;
    @NonNull
    public final AppCompatImageView icBenefitLoss;
    @NonNull
    public final LinearLayout keepProLayout;
    @NonNull
    public final GenericProgressBarBinding progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final AppCompatImageView titleLogo;

    private FragmentDeactivateAutoUpgradeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView5, @NonNull View view, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView2, @NonNull LinearLayout linearLayout2, @NonNull GenericProgressBarBinding genericProgressBarBinding, @NonNull AppCompatImageView appCompatImageView3) {
        this.rootView = constraintLayout;
        this.actionButtonText = appCompatTextView;
        this.cancelButton = appCompatImageView;
        this.cancelTrialSubtitle = appCompatTextView2;
        this.cancelTrialTitle = appCompatTextView3;
        this.continueProPlanText = appCompatTextView4;
        this.deactivateAutoUpgradeLayout = linearLayout;
        this.descriptionBenefitLoss = appCompatTextView5;
        this.descriptionDivider = view;
        this.headerContainer = constraintLayout2;
        this.icBenefitLoss = appCompatImageView2;
        this.keepProLayout = linearLayout2;
        this.progressBar = genericProgressBarBinding;
        this.titleLogo = appCompatImageView3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.description_divider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.progress_bar;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentDeactivateAutoUpgradeBinding bind(@androidx.annotation.NonNull android.view.View r18) {
        /*
            r0 = r18
            int r1 = com.talabat.feature.tpro.presentation.R.id.action_button_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.appcompat.widget.AppCompatTextView r5 = (androidx.appcompat.widget.AppCompatTextView) r5
            if (r5 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.cancel_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6
            if (r6 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.cancel_trial_subtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            if (r7 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.cancel_trial_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.appcompat.widget.AppCompatTextView r8 = (androidx.appcompat.widget.AppCompatTextView) r8
            if (r8 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.continue_pro_plan_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.appcompat.widget.AppCompatTextView r9 = (androidx.appcompat.widget.AppCompatTextView) r9
            if (r9 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.deactivate_auto_upgrade_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.description_benefit_loss
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.appcompat.widget.AppCompatTextView r11 = (androidx.appcompat.widget.AppCompatTextView) r11
            if (r11 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.description_divider
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.header_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.ic_benefit_loss
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.appcompat.widget.AppCompatImageView r14 = (androidx.appcompat.widget.AppCompatImageView) r14
            if (r14 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.keep_pro_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            if (r15 == 0) goto L_0x009a
            int r1 = com.talabat.feature.tpro.presentation.R.id.progress_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x009a
            com.talabat.talabatcore.databinding.GenericProgressBarBinding r16 = com.talabat.talabatcore.databinding.GenericProgressBarBinding.bind(r2)
            int r1 = com.talabat.feature.tpro.presentation.R.id.title_logo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.appcompat.widget.AppCompatImageView r17 = (androidx.appcompat.widget.AppCompatImageView) r17
            if (r17 == 0) goto L_0x009a
            com.talabat.feature.tpro.presentation.databinding.FragmentDeactivateAutoUpgradeBinding r1 = new com.talabat.feature.tpro.presentation.databinding.FragmentDeactivateAutoUpgradeBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r1
        L_0x009a:
            android.content.res.Resources r0 = r18.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentDeactivateAutoUpgradeBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentDeactivateAutoUpgradeBinding");
    }

    @NonNull
    public static FragmentDeactivateAutoUpgradeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentDeactivateAutoUpgradeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_deactivate_auto_upgrade, viewGroup, false);
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
