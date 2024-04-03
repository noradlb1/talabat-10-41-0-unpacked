package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;
import com.talabat.talabatcore.databinding.GenericProgressBarBinding;

public final class FragmentConfirmCancellationBinding implements ViewBinding {
    @NonNull
    public final TalabatStrokeButton cancel;
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final TextView cancelSubscriptionHeader;
    @NonNull
    public final TextView cancelSubscriptionMessage;
    @NonNull
    public final TextView cancelSubscriptionQuestion;
    @NonNull
    public final TalabatFillButton confirm;
    @NonNull
    public final GenericProgressBarBinding progressBar;
    @NonNull
    private final ConstraintLayout rootView;

    private FragmentConfirmCancellationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TalabatFillButton talabatFillButton, @NonNull GenericProgressBarBinding genericProgressBarBinding) {
        this.rootView = constraintLayout;
        this.cancel = talabatStrokeButton;
        this.cancelButton = imageView;
        this.cancelSubscriptionHeader = textView;
        this.cancelSubscriptionMessage = textView2;
        this.cancelSubscriptionQuestion = textView3;
        this.confirm = talabatFillButton;
        this.progressBar = genericProgressBarBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.talabat.feature.tpro.presentation.R.id.progress_bar;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentConfirmCancellationBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            com.talabat.talabatcommon.views.TalabatStrokeButton r4 = (com.talabat.talabatcommon.views.TalabatStrokeButton) r4
            if (r4 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel_subscription_header
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel_subscription_message
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.cancel_subscription_question
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.confirm
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            com.talabat.talabatcommon.views.TalabatFillButton r9 = (com.talabat.talabatcommon.views.TalabatFillButton) r9
            if (r9 == 0) goto L_0x0058
            int r0 = com.talabat.feature.tpro.presentation.R.id.progress_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0058
            com.talabat.talabatcore.databinding.GenericProgressBarBinding r10 = com.talabat.talabatcore.databinding.GenericProgressBarBinding.bind(r1)
            com.talabat.feature.tpro.presentation.databinding.FragmentConfirmCancellationBinding r0 = new com.talabat.feature.tpro.presentation.databinding.FragmentConfirmCancellationBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentConfirmCancellationBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentConfirmCancellationBinding");
    }

    @NonNull
    public static FragmentConfirmCancellationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentConfirmCancellationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_confirm_cancellation, viewGroup, false);
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
