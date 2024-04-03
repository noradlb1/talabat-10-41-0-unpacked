package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.talabat.feature.tpro.presentation.R;

public final class IncludePaymentSectionBinding implements ViewBinding {
    @NonNull
    public final DSPrimaryButton actionButton;
    @NonNull
    public final TextView cancelTextView;
    @NonNull
    public final ConstraintLayout paymentSectionContainer;
    @NonNull
    public final ProgressBar pbSubscribing;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvPrice;
    @NonNull
    public final TextView tvTnc;
    @NonNull
    public final View viewSeparator;

    private IncludePaymentSectionBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull ProgressBar progressBar, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view) {
        this.rootView = constraintLayout;
        this.actionButton = dSPrimaryButton;
        this.cancelTextView = textView;
        this.paymentSectionContainer = constraintLayout2;
        this.pbSubscribing = progressBar;
        this.tvPrice = textView2;
        this.tvTnc = textView3;
        this.viewSeparator = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.view_separator;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.action_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            com.designsystem.ds_button_v2.DSPrimaryButton r4 = (com.designsystem.ds_button_v2.DSPrimaryButton) r4
            if (r4 == 0) goto L_0x004a
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel_text_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x004a
            r6 = r11
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            int r0 = com.talabat.feature.tpro.presentation.R.id.pb_subscribing
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
            if (r7 == 0) goto L_0x004a
            int r0 = com.talabat.feature.tpro.presentation.R.id.tv_price
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x004a
            int r0 = com.talabat.feature.tpro.presentation.R.id.tv_tnc
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004a
            int r0 = com.talabat.feature.tpro.presentation.R.id.view_separator
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r10 == 0) goto L_0x004a
            com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding r11 = new com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding
            r2 = r11
            r3 = r6
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        L_0x004a:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding");
    }

    @NonNull
    public static IncludePaymentSectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static IncludePaymentSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.include_payment_section, viewGroup, false);
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
