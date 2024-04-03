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

public final class FragmentKeepFreeTrialBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonText;
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final TextView keepTrialSubtitle;
    @NonNull
    public final TextView keepTrialTitle;
    @NonNull
    public final GenericProgressBarBinding progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final LinearLayout startExploringLayout;
    @NonNull
    public final ImageView titleLogo;

    private FragmentKeepFreeTrialBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull GenericProgressBarBinding genericProgressBarBinding, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2) {
        this.rootView = constraintLayout;
        this.actionButtonText = textView;
        this.cancelButton = imageView;
        this.keepTrialSubtitle = textView2;
        this.keepTrialTitle = textView3;
        this.progressBar = genericProgressBarBinding;
        this.startExploringLayout = linearLayout;
        this.titleLogo = imageView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.progress_bar;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentKeepFreeTrialBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.action_button_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.keep_trial_subtitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.keep_trial_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.progress_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0058
            com.talabat.talabatcore.databinding.GenericProgressBarBinding r8 = com.talabat.talabatcore.databinding.GenericProgressBarBinding.bind(r1)
            int r0 = com.talabat.feature.tpro.presentation.R.id.start_exploring_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.title_logo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0058
            com.talabat.feature.tpro.presentation.databinding.FragmentKeepFreeTrialBinding r0 = new com.talabat.feature.tpro.presentation.databinding.FragmentKeepFreeTrialBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0058:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentKeepFreeTrialBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentKeepFreeTrialBinding");
    }

    @NonNull
    public static FragmentKeepFreeTrialBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentKeepFreeTrialBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_keep_free_trial, viewGroup, false);
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
