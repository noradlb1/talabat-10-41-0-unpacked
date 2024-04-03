package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_icon_button.DSIconButton;
import com.talabat.growth.R;
import com.talabat.talabatcommon.views.TalabatImageView;

public final class FragmentBurnOptionsConfirmationBinding implements ViewBinding {
    @NonNull
    public final LinearLayout burnDetailsCurrentPointsLinearLayout;
    @NonNull
    public final ConstraintLayout burnDetailsImageCl;
    @NonNull
    public final TalabatImageView burnDetailsImageView;
    @NonNull
    public final TalabatImageView burnDetailsStaticImageView;
    @NonNull
    public final TextView confirmationTitleTextView;
    @NonNull
    public final DSAlert dsAlert;
    @NonNull
    public final DSIconButton dsIconButtonClose;
    @NonNull
    public final DSPrimaryButton dsPrimaryButtonOrderNow;
    @NonNull
    public final TextView redeemOptionCongratsMessage;
    @NonNull
    public final TextView redeemOptionRemainingPoints;
    @NonNull
    private final ConstraintLayout rootView;

    private FragmentBurnOptionsConfirmationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TalabatImageView talabatImageView, @NonNull TalabatImageView talabatImageView2, @NonNull TextView textView, @NonNull DSAlert dSAlert, @NonNull DSIconButton dSIconButton, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.burnDetailsCurrentPointsLinearLayout = linearLayout;
        this.burnDetailsImageCl = constraintLayout2;
        this.burnDetailsImageView = talabatImageView;
        this.burnDetailsStaticImageView = talabatImageView2;
        this.confirmationTitleTextView = textView;
        this.dsAlert = dSAlert;
        this.dsIconButtonClose = dSIconButton;
        this.dsPrimaryButtonOrderNow = dSPrimaryButton;
        this.redeemOptionCongratsMessage = textView2;
        this.redeemOptionRemainingPoints = textView3;
    }

    @NonNull
    public static FragmentBurnOptionsConfirmationBinding bind(@NonNull View view) {
        int i11 = R.id.burnDetailsCurrentPointsLinearLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout != null) {
            i11 = R.id.burnDetailsImageCl;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
            if (constraintLayout != null) {
                i11 = R.id.burnDetailsImageView;
                TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view, i11);
                if (talabatImageView != null) {
                    i11 = R.id.burnDetailsStaticImageView;
                    TalabatImageView talabatImageView2 = (TalabatImageView) ViewBindings.findChildViewById(view, i11);
                    if (talabatImageView2 != null) {
                        i11 = R.id.confirmationTitleTextView;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            i11 = R.id.dsAlert;
                            DSAlert dSAlert = (DSAlert) ViewBindings.findChildViewById(view, i11);
                            if (dSAlert != null) {
                                i11 = R.id.dsIconButtonClose;
                                DSIconButton dSIconButton = (DSIconButton) ViewBindings.findChildViewById(view, i11);
                                if (dSIconButton != null) {
                                    i11 = R.id.dsPrimaryButtonOrderNow;
                                    DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
                                    if (dSPrimaryButton != null) {
                                        i11 = R.id.redeemOptionCongratsMessage;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView2 != null) {
                                            i11 = R.id.redeemOptionRemainingPoints;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                            if (textView3 != null) {
                                                return new FragmentBurnOptionsConfirmationBinding((ConstraintLayout) view, linearLayout, constraintLayout, talabatImageView, talabatImageView2, textView, dSAlert, dSIconButton, dSPrimaryButton, textView2, textView3);
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
    public static FragmentBurnOptionsConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentBurnOptionsConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_burn_options_confirmation, viewGroup, false);
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
