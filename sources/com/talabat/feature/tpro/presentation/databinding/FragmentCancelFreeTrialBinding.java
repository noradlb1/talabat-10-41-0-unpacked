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
import com.talabat.talabatcore.databinding.GenericProgressBarBinding;

public final class FragmentCancelFreeTrialBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonText;
    @NonNull
    public final TextView actionCoffeeText;
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final TextView cancelTrialSubtitle;
    @NonNull
    public final TextView cancelTrialTitle;
    @NonNull
    public final LinearLayout confirmCancelTrialLayout;
    @NonNull
    public final TextView descriptionBenefitLoss;
    @NonNull
    public final View descriptionDivider;
    @NonNull
    public final TextView descriptionNoTrial;
    @NonNull
    public final ImageView icBenefitLoss;
    @NonNull
    public final ImageView icNoTrial;
    @NonNull
    public final LinearLayout keepProLayout;
    @NonNull
    public final GenericProgressBarBinding progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView titleLogo;

    private FragmentCancelFreeTrialBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout, @NonNull TextView textView5, @NonNull View view, @NonNull TextView textView6, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout2, @NonNull GenericProgressBarBinding genericProgressBarBinding, @NonNull ImageView imageView4) {
        this.rootView = constraintLayout;
        this.actionButtonText = textView;
        this.actionCoffeeText = textView2;
        this.cancelButton = imageView;
        this.cancelTrialSubtitle = textView3;
        this.cancelTrialTitle = textView4;
        this.confirmCancelTrialLayout = linearLayout;
        this.descriptionBenefitLoss = textView5;
        this.descriptionDivider = view;
        this.descriptionNoTrial = textView6;
        this.icBenefitLoss = imageView2;
        this.icNoTrial = imageView3;
        this.keepProLayout = linearLayout2;
        this.progressBar = genericProgressBarBinding;
        this.titleLogo = imageView4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.description_divider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.progress_bar;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentCancelFreeTrialBinding bind(@androidx.annotation.NonNull android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.talabat.feature.tpro.presentation.R.id.action_button_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.action_coffee_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.cancel_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.cancel_trial_subtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.cancel_trial_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.confirm_cancel_trial_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.description_benefit_loss
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.description_divider
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.description_no_trial
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.ic_benefit_loss
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.ic_no_trial
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.keep_pro_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x00a6
            int r1 = com.talabat.feature.tpro.presentation.R.id.progress_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00a6
            com.talabat.talabatcore.databinding.GenericProgressBarBinding r17 = com.talabat.talabatcore.databinding.GenericProgressBarBinding.bind(r2)
            int r1 = com.talabat.feature.tpro.presentation.R.id.title_logo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            if (r18 == 0) goto L_0x00a6
            com.talabat.feature.tpro.presentation.databinding.FragmentCancelFreeTrialBinding r1 = new com.talabat.feature.tpro.presentation.databinding.FragmentCancelFreeTrialBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        L_0x00a6:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentCancelFreeTrialBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentCancelFreeTrialBinding");
    }

    @NonNull
    public static FragmentCancelFreeTrialBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentCancelFreeTrialBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cancel_free_trial, viewGroup, false);
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
