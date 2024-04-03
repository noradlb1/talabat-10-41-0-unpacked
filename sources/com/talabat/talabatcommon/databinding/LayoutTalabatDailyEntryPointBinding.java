package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;
import io.supercharge.shimmerlayout.ShimmerLayout;

public final class LayoutTalabatDailyEntryPointBinding implements ViewBinding {
    @NonNull
    public final View anchor;
    @NonNull
    public final View anchor2;
    @NonNull
    public final AppCompatTextView btnDailyOrderNow;
    @NonNull
    public final AppCompatTextView btnShimmerOrder;
    @NonNull
    public final TextView dailyAverageDuration;
    @NonNull
    public final ImageView dailyHeaderImage;
    @NonNull
    public final CardView dailyLogoContainer;
    @NonNull
    public final CardView dailyShimmerContainer;
    @NonNull
    public final Guideline guideline;
    @NonNull
    public final LinearLayout linearLayout;
    @NonNull
    public final LinearLayout linearLayout2;
    @NonNull
    public final TextView newStatusText;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final Guideline shimmerGuideline2;
    @NonNull
    public final Guideline shimmerGuideline3;
    @NonNull
    public final ImageView shimmerHeaderImage;
    @NonNull
    public final LinearLayout shimmerLinearLayout;
    @NonNull
    public final LinearLayout shimmerLinearLayout2;
    @NonNull
    public final ImageView shimmerLogo;
    @NonNull
    public final TextView shimmerTalabatDaily;
    @NonNull
    public final RelativeLayout statusView;
    @NonNull
    public final TextView talabatDaily;
    @NonNull
    public final CardView talabatDailyContainer;
    @NonNull
    public final ImageView talabatDailyLogo;
    @NonNull
    public final ShimmerLayout talabatDailyShimmer;

    private LayoutTalabatDailyEntryPointBinding(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull View view2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull CardView cardView, @NonNull CardView cardView2, @NonNull Guideline guideline2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull TextView textView2, @NonNull Guideline guideline3, @NonNull Guideline guideline4, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull ImageView imageView3, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView4, @NonNull CardView cardView3, @NonNull ImageView imageView4, @NonNull ShimmerLayout shimmerLayout) {
        this.rootView = relativeLayout;
        this.anchor = view;
        this.anchor2 = view2;
        this.btnDailyOrderNow = appCompatTextView;
        this.btnShimmerOrder = appCompatTextView2;
        this.dailyAverageDuration = textView;
        this.dailyHeaderImage = imageView;
        this.dailyLogoContainer = cardView;
        this.dailyShimmerContainer = cardView2;
        this.guideline = guideline2;
        this.linearLayout = linearLayout3;
        this.linearLayout2 = linearLayout4;
        this.newStatusText = textView2;
        this.shimmerGuideline2 = guideline3;
        this.shimmerGuideline3 = guideline4;
        this.shimmerHeaderImage = imageView2;
        this.shimmerLinearLayout = linearLayout5;
        this.shimmerLinearLayout2 = linearLayout6;
        this.shimmerLogo = imageView3;
        this.shimmerTalabatDaily = textView3;
        this.statusView = relativeLayout2;
        this.talabatDaily = textView4;
        this.talabatDailyContainer = cardView3;
        this.talabatDailyLogo = imageView4;
        this.talabatDailyShimmer = shimmerLayout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = com.talabat.talabatcommon.R.id.anchor2;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatcommon.databinding.LayoutTalabatDailyEntryPointBinding bind(@androidx.annotation.NonNull android.view.View r28) {
        /*
            r0 = r28
            int r1 = com.talabat.talabatcommon.R.id.anchor
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.anchor2
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r5 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.btn_daily_order_now
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.appcompat.widget.AppCompatTextView r6 = (androidx.appcompat.widget.AppCompatTextView) r6
            if (r6 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.btn_shimmer_order
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            if (r7 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.daily_average_duration
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.daily_header_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.daily_logo_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.cardview.widget.CardView r10 = (androidx.cardview.widget.CardView) r10
            if (r10 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.daily_shimmer_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.cardview.widget.CardView r11 = (androidx.cardview.widget.CardView) r11
            if (r11 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.constraintlayout.widget.Guideline r12 = (androidx.constraintlayout.widget.Guideline) r12
            if (r12 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.linearLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.linearLayout2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.new_status_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.shimmer_guideline2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.Guideline r16 = (androidx.constraintlayout.widget.Guideline) r16
            if (r16 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.shimmer_guideline3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.constraintlayout.widget.Guideline r17 = (androidx.constraintlayout.widget.Guideline) r17
            if (r17 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.shimmer_header_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            if (r18 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.shimmer_linearLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.LinearLayout r19 = (android.widget.LinearLayout) r19
            if (r19 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.shimmer_linearLayout2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.LinearLayout r20 = (android.widget.LinearLayout) r20
            if (r20 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.shimmer_logo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.ImageView r21 = (android.widget.ImageView) r21
            if (r21 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.shimmer_talabat_daily
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.status_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.RelativeLayout r23 = (android.widget.RelativeLayout) r23
            if (r23 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.talabat_daily
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.talabat_daily_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            androidx.cardview.widget.CardView r25 = (androidx.cardview.widget.CardView) r25
            if (r25 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.talabat_daily_logo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.ImageView r26 = (android.widget.ImageView) r26
            if (r26 == 0) goto L_0x011a
            int r1 = com.talabat.talabatcommon.R.id.talabat_daily_shimmer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            io.supercharge.shimmerlayout.ShimmerLayout r27 = (io.supercharge.shimmerlayout.ShimmerLayout) r27
            if (r27 == 0) goto L_0x011a
            com.talabat.talabatcommon.databinding.LayoutTalabatDailyEntryPointBinding r1 = new com.talabat.talabatcommon.databinding.LayoutTalabatDailyEntryPointBinding
            r2 = r1
            r3 = r0
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x011a:
            android.content.res.Resources r0 = r28.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.databinding.LayoutTalabatDailyEntryPointBinding.bind(android.view.View):com.talabat.talabatcommon.databinding.LayoutTalabatDailyEntryPointBinding");
    }

    @NonNull
    public static LayoutTalabatDailyEntryPointBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutTalabatDailyEntryPointBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_talabat_daily_entry_point, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
