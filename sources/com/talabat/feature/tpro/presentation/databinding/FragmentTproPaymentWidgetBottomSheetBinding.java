package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.talabatcommon.views.ShimmerLayout;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;

public final class FragmentTproPaymentWidgetBottomSheetBinding implements ViewBinding {
    @NonNull
    public final DSPrimaryButton actionButton;
    @NonNull
    public final AppCompatTextView autoUpgradeInfoText;
    @NonNull
    public final ImageView closeBottomSheet;
    @NonNull
    public final AppCompatTextView debitCardDisclaimerText;
    @NonNull
    public final LinearLayout errorNotifyLinearLayout;
    @NonNull
    public final ProgressBar genericProgressBar;
    @NonNull
    public final AppCompatImageView giftIcon;
    @NonNull
    public final LinearLayout multiplanFreeTrialPaymentInfo;
    @NonNull
    public final ConstraintLayout paymentContainer;
    @NonNull
    public final FrameLayout paymentView;
    @NonNull
    public final LinearLayout priceAndTncContainer;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ConstraintLayout shahidPlanPaymentInfo;
    @NonNull
    public final AppCompatTextView shahidPlanTitle;
    @NonNull
    public final TextView tvFirstPayment;
    @NonNull
    public final TextView tvPaymentHeader;
    @NonNull
    public final TextView tvPrice;
    @NonNull
    public final TextView tvTnc;
    @NonNull
    public final TextView txtFreeTrial;
    @NonNull
    public final View viewSeparator;
    @NonNull
    public final ShimmerLayout walletPaymentLoading;
    @NonNull
    public final DefaultCardView walletPaymentWidget;

    private FragmentTproPaymentWidgetBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull AppCompatTextView appCompatTextView, @NonNull ImageView imageView, @NonNull AppCompatTextView appCompatTextView2, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayout linearLayout2, @NonNull ConstraintLayout constraintLayout2, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout3, @NonNull ConstraintLayout constraintLayout3, @NonNull AppCompatTextView appCompatTextView3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull View view, @NonNull ShimmerLayout shimmerLayout, @NonNull DefaultCardView defaultCardView) {
        this.rootView = constraintLayout;
        this.actionButton = dSPrimaryButton;
        this.autoUpgradeInfoText = appCompatTextView;
        this.closeBottomSheet = imageView;
        this.debitCardDisclaimerText = appCompatTextView2;
        this.errorNotifyLinearLayout = linearLayout;
        this.genericProgressBar = progressBar;
        this.giftIcon = appCompatImageView;
        this.multiplanFreeTrialPaymentInfo = linearLayout2;
        this.paymentContainer = constraintLayout2;
        this.paymentView = frameLayout;
        this.priceAndTncContainer = linearLayout3;
        this.shahidPlanPaymentInfo = constraintLayout3;
        this.shahidPlanTitle = appCompatTextView3;
        this.tvFirstPayment = textView;
        this.tvPaymentHeader = textView2;
        this.tvPrice = textView3;
        this.tvTnc = textView4;
        this.txtFreeTrial = textView5;
        this.viewSeparator = view;
        this.walletPaymentLoading = shimmerLayout;
        this.walletPaymentWidget = defaultCardView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cf, code lost:
        r1 = com.talabat.feature.tpro.presentation.R.id.view_separator;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.feature.tpro.presentation.databinding.FragmentTproPaymentWidgetBottomSheetBinding bind(@androidx.annotation.NonNull android.view.View r26) {
        /*
            r0 = r26
            int r1 = com.talabat.feature.tpro.presentation.R.id.action_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.designsystem.ds_button_v2.DSPrimaryButton r5 = (com.designsystem.ds_button_v2.DSPrimaryButton) r5
            if (r5 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.auto_upgrade_info_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.appcompat.widget.AppCompatTextView r6 = (androidx.appcompat.widget.AppCompatTextView) r6
            if (r6 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.close_bottom_sheet
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.debit_card_disclaimer_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.appcompat.widget.AppCompatTextView r8 = (androidx.appcompat.widget.AppCompatTextView) r8
            if (r8 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.errorNotifyLinearLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.genericProgressBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ProgressBar r10 = (android.widget.ProgressBar) r10
            if (r10 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.gift_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.appcompat.widget.AppCompatImageView r11 = (androidx.appcompat.widget.AppCompatImageView) r11
            if (r11 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.multiplan_free_trial_payment_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.payment_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.paymentView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.FrameLayout r14 = (android.widget.FrameLayout) r14
            if (r14 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.price_and_tnc_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            if (r15 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.shahid_plan_payment_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.ConstraintLayout r16 = (androidx.constraintlayout.widget.ConstraintLayout) r16
            if (r16 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.shahid_plan_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.appcompat.widget.AppCompatTextView r17 = (androidx.appcompat.widget.AppCompatTextView) r17
            if (r17 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_first_payment
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_payment_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_price
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.tv_tnc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.txt_free_trial
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.view_separator
            android.view.View r23 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r23 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.wallet_payment_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            com.talabat.talabatcommon.views.ShimmerLayout r24 = (com.talabat.talabatcommon.views.ShimmerLayout) r24
            if (r24 == 0) goto L_0x00f9
            int r1 = com.talabat.feature.tpro.presentation.R.id.wallet_payment_widget
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView r25 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView) r25
            if (r25 == 0) goto L_0x00f9
            com.talabat.feature.tpro.presentation.databinding.FragmentTproPaymentWidgetBottomSheetBinding r1 = new com.talabat.feature.tpro.presentation.databinding.FragmentTproPaymentWidgetBottomSheetBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r1
        L_0x00f9:
            android.content.res.Resources r0 = r26.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.databinding.FragmentTproPaymentWidgetBottomSheetBinding.bind(android.view.View):com.talabat.feature.tpro.presentation.databinding.FragmentTproPaymentWidgetBottomSheetBinding");
    }

    @NonNull
    public static FragmentTproPaymentWidgetBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproPaymentWidgetBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_payment_widget_bottom_sheet, viewGroup, false);
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
