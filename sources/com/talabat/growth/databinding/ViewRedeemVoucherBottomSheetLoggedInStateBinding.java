package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_button.DSTertiaryButton;
import com.marshmallow.TalabatAlert;
import com.talabat.growth.R;

public final class ViewRedeemVoucherBottomSheetLoggedInStateBinding implements ViewBinding {
    @NonNull
    public final DSPrimaryButton placeAnOrderButtonLoggedIn;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView validTilImageViewLoggedIn;
    @NonNull
    public final DSTertiaryButton viewVouchersButtonLoggedIn;
    @NonNull
    public final TextView voucherConditionsTextViewLoggedIn;
    @NonNull
    public final TextView voucherDescriptionTextViewLoggedIn;
    @NonNull
    public final TalabatAlert voucherHintAlertLoggedIn;
    @NonNull
    public final ImageView voucherImageViewLoggedIn;
    @NonNull
    public final TextView voucherTitleTextViewLoggedIn;
    @NonNull
    public final TextView voucherValidTilTextViewLoggedIn;

    private ViewRedeemVoucherBottomSheetLoggedInStateBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull ImageView imageView, @NonNull DSTertiaryButton dSTertiaryButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TalabatAlert talabatAlert, @NonNull ImageView imageView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.placeAnOrderButtonLoggedIn = dSPrimaryButton;
        this.validTilImageViewLoggedIn = imageView;
        this.viewVouchersButtonLoggedIn = dSTertiaryButton;
        this.voucherConditionsTextViewLoggedIn = textView;
        this.voucherDescriptionTextViewLoggedIn = textView2;
        this.voucherHintAlertLoggedIn = talabatAlert;
        this.voucherImageViewLoggedIn = imageView2;
        this.voucherTitleTextViewLoggedIn = textView3;
        this.voucherValidTilTextViewLoggedIn = textView4;
    }

    @NonNull
    public static ViewRedeemVoucherBottomSheetLoggedInStateBinding bind(@NonNull View view) {
        int i11 = R.id.placeAnOrderButton_loggedIn;
        DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
        if (dSPrimaryButton != null) {
            i11 = R.id.validTilImageView_LoggedIn;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.viewVouchersButton_loggedIn;
                DSTertiaryButton dSTertiaryButton = (DSTertiaryButton) ViewBindings.findChildViewById(view, i11);
                if (dSTertiaryButton != null) {
                    i11 = R.id.voucherConditionsTextView_loggedIn;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.voucherDescriptionTextView_loggedIn;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.voucherHintAlert_loggedIn;
                            TalabatAlert talabatAlert = (TalabatAlert) ViewBindings.findChildViewById(view, i11);
                            if (talabatAlert != null) {
                                i11 = R.id.voucherImageView_loggedIn;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                                if (imageView2 != null) {
                                    i11 = R.id.voucherTitleTextView_loggedIn;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView3 != null) {
                                        i11 = R.id.voucherValidTilTextView_loggedIn;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView4 != null) {
                                            return new ViewRedeemVoucherBottomSheetLoggedInStateBinding((ConstraintLayout) view, dSPrimaryButton, imageView, dSTertiaryButton, textView, textView2, talabatAlert, imageView2, textView3, textView4);
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
    public static ViewRedeemVoucherBottomSheetLoggedInStateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewRedeemVoucherBottomSheetLoggedInStateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_redeem_voucher_bottom_sheet_logged_in_state, viewGroup, false);
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
