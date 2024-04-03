package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;

public final class ViewOrderConfirmationRiderTipBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout riderInfoChildView;
    @NonNull
    public final ConstraintLayout riderTipCard;
    @NonNull
    public final TextView ripRiderMessage;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final View separatorLine;
    @NonNull
    public final TextView thankYouMessage;
    @NonNull
    public final ConstraintLayout tipRiderGiven;
    @NonNull
    public final ImageView tipRiderInfoIcon;
    @NonNull
    public final TextView tipRiderTextView;
    @NonNull
    public final ImageView tipRiderThankYouInfoIcon;
    @NonNull
    public final TextView tipRiderThankYouMessage;

    private ViewOrderConfirmationRiderTipBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout4, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull ImageView imageView2, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.riderInfoChildView = constraintLayout2;
        this.riderTipCard = constraintLayout3;
        this.ripRiderMessage = textView;
        this.separatorLine = view;
        this.thankYouMessage = textView2;
        this.tipRiderGiven = constraintLayout4;
        this.tipRiderInfoIcon = imageView;
        this.tipRiderTextView = textView3;
        this.tipRiderThankYouInfoIcon = imageView2;
        this.tipRiderThankYouMessage = textView4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r0 = com.talabat.talabatcommon.R.id.separator_line;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatcommon.databinding.ViewOrderConfirmationRiderTipBinding bind(@androidx.annotation.NonNull android.view.View r14) {
        /*
            int r0 = com.talabat.talabatcommon.R.id.rider_info_child_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x006b
            r5 = r14
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            int r0 = com.talabat.talabatcommon.R.id.rip_rider_message
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x006b
            int r0 = com.talabat.talabatcommon.R.id.separator_line
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r7 == 0) goto L_0x006b
            int r0 = com.talabat.talabatcommon.R.id.thank_you_message
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x006b
            int r0 = com.talabat.talabatcommon.R.id.tip_rider_given
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x006b
            int r0 = com.talabat.talabatcommon.R.id.tip_rider_info_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x006b
            int r0 = com.talabat.talabatcommon.R.id.tip_rider_text_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x006b
            int r0 = com.talabat.talabatcommon.R.id.tip_rider_thank_you_info_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x006b
            int r0 = com.talabat.talabatcommon.R.id.tip_rider_thank_you_message
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x006b
            com.talabat.talabatcommon.databinding.ViewOrderConfirmationRiderTipBinding r14 = new com.talabat.talabatcommon.databinding.ViewOrderConfirmationRiderTipBinding
            r2 = r14
            r3 = r5
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.databinding.ViewOrderConfirmationRiderTipBinding.bind(android.view.View):com.talabat.talabatcommon.databinding.ViewOrderConfirmationRiderTipBinding");
    }

    @NonNull
    public static ViewOrderConfirmationRiderTipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewOrderConfirmationRiderTipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_order_confirmation_rider_tip, viewGroup, false);
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
