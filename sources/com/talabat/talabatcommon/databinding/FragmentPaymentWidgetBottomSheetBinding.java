package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final class FragmentPaymentWidgetBottomSheetBinding implements ViewBinding {
    @NonNull
    public final LinearLayout actionButton;
    @NonNull
    public final TextView actionButtonText;
    @NonNull
    public final ImageButton cancelSubscriptionButton;
    @NonNull
    public final TextView cancelTextView;
    @NonNull
    public final ConstraintLayout cardPaymentContainer;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final LinearLayout errorNotifyLinearLayout;
    @NonNull
    public final ProgressBar genericProgressBar;
    @NonNull
    public final RelativeLayout genericProgressBarRootRelativeLayout;
    @NonNull
    public final TextView nextChargeDateHeader;
    @NonNull
    public final TextView nextChargeDateInfo;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView strikedAmount;
    @NonNull
    public final TextView subscriptionAmountText;
    @NonNull
    public final ConstraintLayout subscriptionViewContainer;
    @NonNull
    public final TextView termsAndConditionsLink;
    @NonNull
    public final WalletPaymentOptionView walletPaymentWidget;

    private FragmentPaymentWidgetBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageButton imageButton, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull ConstraintLayout constraintLayout4, @NonNull TextView textView7, @NonNull WalletPaymentOptionView walletPaymentOptionView) {
        this.rootView = constraintLayout;
        this.actionButton = linearLayout;
        this.actionButtonText = textView;
        this.cancelSubscriptionButton = imageButton;
        this.cancelTextView = textView2;
        this.cardPaymentContainer = constraintLayout2;
        this.container = constraintLayout3;
        this.errorNotifyLinearLayout = linearLayout2;
        this.genericProgressBar = progressBar;
        this.genericProgressBarRootRelativeLayout = relativeLayout;
        this.nextChargeDateHeader = textView3;
        this.nextChargeDateInfo = textView4;
        this.strikedAmount = textView5;
        this.subscriptionAmountText = textView6;
        this.subscriptionViewContainer = constraintLayout4;
        this.termsAndConditionsLink = textView7;
        this.walletPaymentWidget = walletPaymentOptionView;
    }

    @NonNull
    public static FragmentPaymentWidgetBottomSheetBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.action_button;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i11);
        if (linearLayout != null) {
            i11 = R.id.action_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
            if (textView != null) {
                i11 = R.id.cancel_subscription_button;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, i11);
                if (imageButton != null) {
                    i11 = R.id.cancel_text_view;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                    if (textView2 != null) {
                        i11 = R.id.card_payment_container;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
                        if (constraintLayout != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view2;
                            i11 = R.id.errorNotifyLinearLayout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i11);
                            if (linearLayout2 != null) {
                                i11 = R.id.genericProgressBar;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, i11);
                                if (progressBar != null) {
                                    i11 = R.id.genericProgressBarRootRelativeLayout;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, i11);
                                    if (relativeLayout != null) {
                                        i11 = R.id.next_charge_date_header;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                        if (textView3 != null) {
                                            i11 = R.id.next_charge_date_info;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                            if (textView4 != null) {
                                                i11 = R.id.striked_amount;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                if (textView5 != null) {
                                                    i11 = R.id.subscription_amount_text;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                    if (textView6 != null) {
                                                        i11 = R.id.subscription_view_container;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
                                                        if (constraintLayout3 != null) {
                                                            i11 = R.id.terms_and_conditions_link;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                            if (textView7 != null) {
                                                                i11 = R.id.wallet_payment_widget;
                                                                WalletPaymentOptionView walletPaymentOptionView = (WalletPaymentOptionView) ViewBindings.findChildViewById(view2, i11);
                                                                if (walletPaymentOptionView != null) {
                                                                    return new FragmentPaymentWidgetBottomSheetBinding(constraintLayout2, linearLayout, textView, imageButton, textView2, constraintLayout, constraintLayout2, linearLayout2, progressBar, relativeLayout, textView3, textView4, textView5, textView6, constraintLayout3, textView7, walletPaymentOptionView);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentPaymentWidgetBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentPaymentWidgetBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_payment_widget_bottom_sheet, viewGroup, false);
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
