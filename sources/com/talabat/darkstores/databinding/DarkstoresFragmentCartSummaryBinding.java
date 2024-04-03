package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresFragmentCartSummaryBinding implements ViewBinding {
    @NonNull
    public final TextView btnCheckout;
    @NonNull
    public final ImageButton btnToggleExpand;
    @NonNull
    public final Group groupSummaryDetails;
    @NonNull
    public final Group groupSummaryDetailsServiceFee;
    @NonNull
    public final ImageView imageDeliveryFeeMoreInfo;
    @NonNull
    public final ImageView imageServiceFeeMoreInfo;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvDeliveryFee;
    @NonNull
    public final TextView tvDeliveryFeeBeforeDiscount;
    @NonNull
    public final TextView tvDeliveryFeeLabel;
    @NonNull
    public final TextView tvOfferDiscount;
    @NonNull
    public final TextView tvOfferDiscountLabel;
    @NonNull
    public final TextView tvReadMoreAboutFees;
    @NonNull
    public final TextView tvServiceFee;
    @NonNull
    public final TextView tvServiceFeeLabel;
    @NonNull
    public final TextView tvSubtotal;
    @NonNull
    public final TextView tvSubtotalLabel;
    @NonNull
    public final TextView tvTProDeliveryFeeLabel;
    @NonNull
    public final TextView tvTotal;
    @NonNull
    public final TextView tvTotalLabel;
    @NonNull
    public final View view;

    private DarkstoresFragmentCartSummaryBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageButton imageButton, @NonNull Group group, @NonNull Group group2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull TextView textView10, @NonNull TextView textView11, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14, @NonNull View view2) {
        this.rootView = constraintLayout;
        this.btnCheckout = textView;
        this.btnToggleExpand = imageButton;
        this.groupSummaryDetails = group;
        this.groupSummaryDetailsServiceFee = group2;
        this.imageDeliveryFeeMoreInfo = imageView;
        this.imageServiceFeeMoreInfo = imageView2;
        this.tvDeliveryFee = textView2;
        this.tvDeliveryFeeBeforeDiscount = textView3;
        this.tvDeliveryFeeLabel = textView4;
        this.tvOfferDiscount = textView5;
        this.tvOfferDiscountLabel = textView6;
        this.tvReadMoreAboutFees = textView7;
        this.tvServiceFee = textView8;
        this.tvServiceFeeLabel = textView9;
        this.tvSubtotal = textView10;
        this.tvSubtotalLabel = textView11;
        this.tvTProDeliveryFeeLabel = textView12;
        this.tvTotal = textView13;
        this.tvTotalLabel = textView14;
        this.view = view2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00db, code lost:
        r1 = com.talabat.darkstores.R.id.view;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresFragmentCartSummaryBinding bind(@androidx.annotation.NonNull android.view.View r25) {
        /*
            r0 = r25
            int r1 = com.talabat.darkstores.R.id.btnCheckout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.btnToggleExpand
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageButton r6 = (android.widget.ImageButton) r6
            if (r6 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.groupSummaryDetails
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.Group r7 = (androidx.constraintlayout.widget.Group) r7
            if (r7 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.groupSummaryDetailsServiceFee
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.Group r8 = (androidx.constraintlayout.widget.Group) r8
            if (r8 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.imageDeliveryFeeMoreInfo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.imageServiceFeeMoreInfo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvDeliveryFee
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvDeliveryFeeBeforeDiscount
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvDeliveryFeeLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvOfferDiscount
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvOfferDiscountLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvReadMoreAboutFees
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvServiceFee
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvServiceFeeLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvSubtotal
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvSubtotalLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvTProDeliveryFeeLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvTotal
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.tvTotalLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00ed
            int r1 = com.talabat.darkstores.R.id.view
            android.view.View r24 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r24 == 0) goto L_0x00ed
            com.talabat.darkstores.databinding.DarkstoresFragmentCartSummaryBinding r1 = new com.talabat.darkstores.databinding.DarkstoresFragmentCartSummaryBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r1
        L_0x00ed:
            android.content.res.Resources r0 = r25.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresFragmentCartSummaryBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresFragmentCartSummaryBinding");
    }

    @NonNull
    public static DarkstoresFragmentCartSummaryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentCartSummaryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_cart_summary, viewGroup, false);
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
