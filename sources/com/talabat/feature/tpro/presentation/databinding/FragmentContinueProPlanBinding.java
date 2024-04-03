package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.talabatcore.databinding.GenericProgressBarBinding;

public final class FragmentContinueProPlanBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonText;
    @NonNull
    public final AppCompatImageView cancelButton;
    @NonNull
    public final TextView continueProPlanSubtitle;
    @NonNull
    public final TextView continueProPlanTitle;
    @NonNull
    public final View descriptionDivider;
    @NonNull
    public final ConstraintLayout headerContainer;
    @NonNull
    public final GenericProgressBarBinding progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final LinearLayout startExploringLayout;
    @NonNull
    public final AppCompatImageView titleLogo;

    private FragmentContinueProPlanBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view, @NonNull ConstraintLayout constraintLayout2, @NonNull GenericProgressBarBinding genericProgressBarBinding, @NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView2) {
        this.rootView = constraintLayout;
        this.actionButtonText = textView;
        this.cancelButton = appCompatImageView;
        this.continueProPlanSubtitle = textView2;
        this.continueProPlanTitle = textView3;
        this.descriptionDivider = view;
        this.headerContainer = constraintLayout2;
        this.progressBar = genericProgressBarBinding;
        this.startExploringLayout = linearLayout;
        this.titleLogo = appCompatImageView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.progress_bar;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.description_divider;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentContinueProPlanBinding bind(@androidx.annotation.NonNull android.view.View r13) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.action_button_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            androidx.appcompat.widget.AppCompatImageView r5 = (androidx.appcompat.widget.AppCompatImageView) r5
            if (r5 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.continue_pro_plan_subtitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.continue_pro_plan_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.description_divider
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r8 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.header_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.progress_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r1 == 0) goto L_0x006b
            com.talabat.talabatcore.databinding.GenericProgressBarBinding r10 = com.talabat.talabatcore.databinding.GenericProgressBarBinding.bind(r1)
            int r0 = com.talabat.feature.tpro.presentation.R.id.start_exploring_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x006b
            int r0 = com.talabat.feature.tpro.presentation.R.id.title_logo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            androidx.appcompat.widget.AppCompatImageView r12 = (androidx.appcompat.widget.AppCompatImageView) r12
            if (r12 == 0) goto L_0x006b
            com.talabat.feature.tpro.presentation.databinding.FragmentContinueProPlanBinding r0 = new com.talabat.feature.tpro.presentation.databinding.FragmentContinueProPlanBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006b:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentContinueProPlanBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentContinueProPlanBinding");
    }

    @NonNull
    public static FragmentContinueProPlanBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentContinueProPlanBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_continue_pro_plan, viewGroup, false);
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
