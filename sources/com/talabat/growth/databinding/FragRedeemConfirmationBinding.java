package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_button_v2.DSTertiaryButton;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.views.CouponCodeView;

public final class FragRedeemConfirmationBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout clRedeemBottom;
    @NonNull
    public final CouponCodeView couponCodeView;
    @NonNull
    public final DSPrimaryButton dsPrimaryButtonBackToRewards;
    @NonNull
    public final DSPrimaryButton dsPrimaryButtonOrderNow;
    @NonNull
    public final DSTertiaryButton dsTertiaryButtonBackToRewards;
    @NonNull
    public final NestedScrollView redeemBodyRelativeLayout;
    @NonNull
    public final TextView redeemOptionCongrats;
    @NonNull
    public final ImageView redeemOptionCongratsCharityIcon;
    @NonNull
    public final AppCompatImageView redeemOptionCongratsIcon;
    @NonNull
    public final TextView redeemOptionCongratsMessage;
    @NonNull
    public final TextView redeemOptionRemainingPoints;
    @NonNull
    public final TextView redeemOptionRemainingPointsTitle;
    @NonNull
    public final TextView redeemOptionTitle;
    @NonNull
    public final TextView redeemOptionVoucherAdded;
    @NonNull
    public final DSPrimaryButton redeemUseVoucherButton;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView showVoucherCodeHintTextView;

    private FragRedeemConfirmationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull CouponCodeView couponCodeView2, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull DSPrimaryButton dSPrimaryButton2, @NonNull DSTertiaryButton dSTertiaryButton, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull DSPrimaryButton dSPrimaryButton3, @NonNull TextView textView7) {
        this.rootView = constraintLayout;
        this.clRedeemBottom = constraintLayout2;
        this.couponCodeView = couponCodeView2;
        this.dsPrimaryButtonBackToRewards = dSPrimaryButton;
        this.dsPrimaryButtonOrderNow = dSPrimaryButton2;
        this.dsTertiaryButtonBackToRewards = dSTertiaryButton;
        this.redeemBodyRelativeLayout = nestedScrollView;
        this.redeemOptionCongrats = textView;
        this.redeemOptionCongratsCharityIcon = imageView;
        this.redeemOptionCongratsIcon = appCompatImageView;
        this.redeemOptionCongratsMessage = textView2;
        this.redeemOptionRemainingPoints = textView3;
        this.redeemOptionRemainingPointsTitle = textView4;
        this.redeemOptionTitle = textView5;
        this.redeemOptionVoucherAdded = textView6;
        this.redeemUseVoucherButton = dSPrimaryButton3;
        this.showVoucherCodeHintTextView = textView7;
    }

    @NonNull
    public static FragRedeemConfirmationBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.clRedeemBottom;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
        if (constraintLayout != null) {
            i11 = R.id.couponCodeView;
            CouponCodeView couponCodeView2 = (CouponCodeView) ViewBindings.findChildViewById(view2, i11);
            if (couponCodeView2 != null) {
                i11 = R.id.dsPrimaryButtonBackToRewards;
                DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view2, i11);
                if (dSPrimaryButton != null) {
                    i11 = R.id.dsPrimaryButtonOrderNow;
                    DSPrimaryButton dSPrimaryButton2 = (DSPrimaryButton) ViewBindings.findChildViewById(view2, i11);
                    if (dSPrimaryButton2 != null) {
                        i11 = R.id.dsTertiaryButtonBackToRewards;
                        DSTertiaryButton dSTertiaryButton = (DSTertiaryButton) ViewBindings.findChildViewById(view2, i11);
                        if (dSTertiaryButton != null) {
                            i11 = R.id.redeemBodyRelativeLayout;
                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, i11);
                            if (nestedScrollView != null) {
                                i11 = R.id.redeemOptionCongrats;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
                                if (textView != null) {
                                    i11 = R.id.redeemOptionCongratsCharityIcon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i11);
                                    if (imageView != null) {
                                        i11 = R.id.redeemOptionCongratsIcon;
                                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i11);
                                        if (appCompatImageView != null) {
                                            i11 = R.id.redeemOptionCongratsMessage;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                            if (textView2 != null) {
                                                i11 = R.id.redeemOptionRemainingPoints;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                if (textView3 != null) {
                                                    i11 = R.id.redeemOptionRemainingPointsTitle;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                    if (textView4 != null) {
                                                        i11 = R.id.redeemOptionTitle;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                        if (textView5 != null) {
                                                            i11 = R.id.redeemOptionVoucherAdded;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                            if (textView6 != null) {
                                                                i11 = R.id.redeemUseVoucherButton;
                                                                DSPrimaryButton dSPrimaryButton3 = (DSPrimaryButton) ViewBindings.findChildViewById(view2, i11);
                                                                if (dSPrimaryButton3 != null) {
                                                                    i11 = R.id.showVoucherCodeHintTextView;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                    if (textView7 != null) {
                                                                        return new FragRedeemConfirmationBinding((ConstraintLayout) view2, constraintLayout, couponCodeView2, dSPrimaryButton, dSPrimaryButton2, dSTertiaryButton, nestedScrollView, textView, imageView, appCompatImageView, textView2, textView3, textView4, textView5, textView6, dSPrimaryButton3, textView7);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragRedeemConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragRedeemConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_redeem_confirmation, viewGroup, false);
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
