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
import com.talabat.growth.R;

public final class ViewRedeemVoucherBottomSheetNotLoggedInStateBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final DSPrimaryButton signUpButtonNotLoggedIn;
    @NonNull
    public final TextView voucherConditionsTextViewNotLoggedIn;
    @NonNull
    public final TextView voucherDescriptionTextViewNotLoggedIn;
    @NonNull
    public final ImageView voucherImageViewNotLoggedIn;
    @NonNull
    public final TextView voucherTagTextViewNotLoggedIn;
    @NonNull
    public final TextView voucherTitleTextViewNotLoggedIn;

    private ViewRedeemVoucherBottomSheetNotLoggedInStateBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.signUpButtonNotLoggedIn = dSPrimaryButton;
        this.voucherConditionsTextViewNotLoggedIn = textView;
        this.voucherDescriptionTextViewNotLoggedIn = textView2;
        this.voucherImageViewNotLoggedIn = imageView;
        this.voucherTagTextViewNotLoggedIn = textView3;
        this.voucherTitleTextViewNotLoggedIn = textView4;
    }

    @NonNull
    public static ViewRedeemVoucherBottomSheetNotLoggedInStateBinding bind(@NonNull View view) {
        int i11 = R.id.signUpButton_notLoggedIn;
        DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
        if (dSPrimaryButton != null) {
            i11 = R.id.voucherConditionsTextView_notLoggedIn;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.voucherDescriptionTextView_notLoggedIn;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.voucherImageView_notLoggedIn;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView != null) {
                        i11 = R.id.voucherTagTextView_notLoggedIn;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            i11 = R.id.voucherTitleTextView_notLoggedIn;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView4 != null) {
                                return new ViewRedeemVoucherBottomSheetNotLoggedInStateBinding((ConstraintLayout) view, dSPrimaryButton, textView, textView2, imageView, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewRedeemVoucherBottomSheetNotLoggedInStateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewRedeemVoucherBottomSheetNotLoggedInStateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_redeem_voucher_bottom_sheet_not_logged_in_state, viewGroup, false);
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
