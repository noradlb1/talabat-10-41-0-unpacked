package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_chip.DSSingleSelectionChip;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final class BottomSheetRiderTipBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout bottomSheet;
    @NonNull
    public final ConstraintLayout cardPaymentContainer;
    @NonNull
    public final ImageView closeTipRider;
    @NonNull
    public final ConstraintLayout containerAll;
    @NonNull
    public final LinearLayout errorNotifyLinearLayout;
    @NonNull
    public final ProgressBar genericProgressBar;
    @NonNull
    public final RelativeLayout genericProgressBarRootRelativeLayout;
    @NonNull
    public final View graySpace;
    @NonNull
    public final BottomSheetLoadingPlaceholderBinding loadingLayout;
    @NonNull
    public final LinearLayout riderBottomSheetCtaButton;
    @NonNull
    public final TextView riderBottomSheetCtaButtonTextView;
    @NonNull
    public final ViewSuccessLayoutBinding riderBottomSheetSuccessView;
    @NonNull
    public final LinearLayout riderBottomSheetTipsChipsContainer;
    @NonNull
    public final HorizontalScrollView riderBottomSheetTipsChipsScrollView;
    @NonNull
    public final RadioGroup riderBottomSheetTipsRadioGroup;
    @NonNull
    public final WalletPaymentOptionView riderBottomSheetTipsWalletPaymentWidget;
    @NonNull
    public final DSSingleSelectionChip riderTipChip1;
    @NonNull
    public final DSSingleSelectionChip riderTipChip2;
    @NonNull
    public final DSSingleSelectionChip riderTipChip3;
    @NonNull
    public final TextView riderTipInfoContent;
    @NonNull
    public final RadioButton riderTipRadioButton1;
    @NonNull
    public final RadioButton riderTipRadioButton2;
    @NonNull
    public final RadioButton riderTipRadioButton3;
    @NonNull
    public final ConstraintLayout riderTipsContent;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView supportYourRider;
    @NonNull
    public final TipRiderInfoBinding tipRiderInfoView;

    private BottomSheetRiderTipBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout3, @NonNull View view, @NonNull BottomSheetLoadingPlaceholderBinding bottomSheetLoadingPlaceholderBinding, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull ViewSuccessLayoutBinding viewSuccessLayoutBinding, @NonNull LinearLayout linearLayout3, @NonNull HorizontalScrollView horizontalScrollView, @NonNull RadioGroup radioGroup, @NonNull WalletPaymentOptionView walletPaymentOptionView, @NonNull DSSingleSelectionChip dSSingleSelectionChip, @NonNull DSSingleSelectionChip dSSingleSelectionChip2, @NonNull DSSingleSelectionChip dSSingleSelectionChip3, @NonNull TextView textView2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView3, @NonNull TipRiderInfoBinding tipRiderInfoBinding) {
        this.rootView = relativeLayout;
        this.bottomSheet = relativeLayout2;
        this.cardPaymentContainer = constraintLayout;
        this.closeTipRider = imageView;
        this.containerAll = constraintLayout2;
        this.errorNotifyLinearLayout = linearLayout;
        this.genericProgressBar = progressBar;
        this.genericProgressBarRootRelativeLayout = relativeLayout3;
        this.graySpace = view;
        this.loadingLayout = bottomSheetLoadingPlaceholderBinding;
        this.riderBottomSheetCtaButton = linearLayout2;
        this.riderBottomSheetCtaButtonTextView = textView;
        this.riderBottomSheetSuccessView = viewSuccessLayoutBinding;
        this.riderBottomSheetTipsChipsContainer = linearLayout3;
        this.riderBottomSheetTipsChipsScrollView = horizontalScrollView;
        this.riderBottomSheetTipsRadioGroup = radioGroup;
        this.riderBottomSheetTipsWalletPaymentWidget = walletPaymentOptionView;
        this.riderTipChip1 = dSSingleSelectionChip;
        this.riderTipChip2 = dSSingleSelectionChip2;
        this.riderTipChip3 = dSSingleSelectionChip3;
        this.riderTipInfoContent = textView2;
        this.riderTipRadioButton1 = radioButton;
        this.riderTipRadioButton2 = radioButton2;
        this.riderTipRadioButton3 = radioButton3;
        this.riderTipsContent = constraintLayout3;
        this.supportYourRider = textView3;
        this.tipRiderInfoView = tipRiderInfoBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r1 = com.talabat.talabatcommon.R.id.gray_space;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r1 = com.talabat.talabatcommon.R.id.loadingLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        r1 = com.talabat.talabatcommon.R.id.riderBottomSheetSuccessView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f7, code lost:
        r1 = com.talabat.talabatcommon.R.id.tip_rider_info_view;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.talabatcommon.databinding.BottomSheetRiderTipBinding bind(@androidx.annotation.NonNull android.view.View r29) {
        /*
            r0 = r29
            r2 = r0
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            int r1 = com.talabat.talabatcommon.R.id.card_payment_container
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            if (r3 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.close_tip_rider
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.container_all
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.errorNotifyLinearLayout
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.genericProgressBar
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
            if (r7 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.genericProgressBarRootRelativeLayout
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            if (r8 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.gray_space
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.loadingLayout
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x010c
            com.talabat.talabatcommon.databinding.BottomSheetLoadingPlaceholderBinding r10 = com.talabat.talabatcommon.databinding.BottomSheetLoadingPlaceholderBinding.bind(r10)
            int r1 = com.talabat.talabatcommon.R.id.riderBottomSheetCtaButton
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderBottomSheetCtaButtonTextView
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderBottomSheetSuccessView
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r13 == 0) goto L_0x010c
            com.talabat.talabatcommon.databinding.ViewSuccessLayoutBinding r13 = com.talabat.talabatcommon.databinding.ViewSuccessLayoutBinding.bind(r13)
            int r1 = com.talabat.talabatcommon.R.id.riderBottomSheetTipsChipsContainer
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderBottomSheetTipsChipsScrollView
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.HorizontalScrollView r15 = (android.widget.HorizontalScrollView) r15
            if (r15 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderBottomSheetTipsRadioGroup
            android.view.View r16 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.RadioGroup r16 = (android.widget.RadioGroup) r16
            if (r16 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderBottomSheetTipsWalletPaymentWidget
            android.view.View r17 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView r17 = (com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView) r17
            if (r17 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderTipChip1
            android.view.View r18 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            com.designsystem.ds_chip.DSSingleSelectionChip r18 = (com.designsystem.ds_chip.DSSingleSelectionChip) r18
            if (r18 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderTipChip2
            android.view.View r19 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            com.designsystem.ds_chip.DSSingleSelectionChip r19 = (com.designsystem.ds_chip.DSSingleSelectionChip) r19
            if (r19 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderTipChip3
            android.view.View r20 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            com.designsystem.ds_chip.DSSingleSelectionChip r20 = (com.designsystem.ds_chip.DSSingleSelectionChip) r20
            if (r20 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.rider_tip_info_content
            android.view.View r21 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderTipRadioButton1
            android.view.View r22 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.RadioButton r22 = (android.widget.RadioButton) r22
            if (r22 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderTipRadioButton2
            android.view.View r23 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.RadioButton r23 = (android.widget.RadioButton) r23
            if (r23 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.riderTipRadioButton3
            android.view.View r24 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.RadioButton r24 = (android.widget.RadioButton) r24
            if (r24 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.rider_tips_content
            android.view.View r25 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            androidx.constraintlayout.widget.ConstraintLayout r25 = (androidx.constraintlayout.widget.ConstraintLayout) r25
            if (r25 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.support_your_rider
            android.view.View r26 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x010c
            int r1 = com.talabat.talabatcommon.R.id.tip_rider_info_view
            android.view.View r27 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r27 == 0) goto L_0x010c
            com.talabat.talabatcommon.databinding.TipRiderInfoBinding r27 = com.talabat.talabatcommon.databinding.TipRiderInfoBinding.bind(r27)
            com.talabat.talabatcommon.databinding.BottomSheetRiderTipBinding r28 = new com.talabat.talabatcommon.databinding.BottomSheetRiderTipBinding
            r0 = r28
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r28
        L_0x010c:
            android.content.res.Resources r0 = r29.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.databinding.BottomSheetRiderTipBinding.bind(android.view.View):com.talabat.talabatcommon.databinding.BottomSheetRiderTipBinding");
    }

    @NonNull
    public static BottomSheetRiderTipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BottomSheetRiderTipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_rider_tip, viewGroup, false);
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
