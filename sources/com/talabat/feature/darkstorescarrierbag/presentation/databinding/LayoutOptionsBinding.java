package com.talabat.feature.darkstorescarrierbag.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_radio_button.DSRadioButton;
import com.talabat.feature.darkstorescarrierbag.presentation.R;

public final class LayoutOptionsBinding implements ViewBinding {
    @NonNull
    public final TextView btnContinue;
    @NonNull
    public final ConstraintLayout clWithEcoFriendlyBag;
    @NonNull
    public final ConstraintLayout clWithPlasticBag;
    @NonNull
    public final ConstraintLayout clWithoutBag;
    @NonNull
    public final AppCompatImageView ivWithEcoFriendlyBag;
    @NonNull
    public final AppCompatImageView ivWithPlasticBag;
    @NonNull
    public final AppCompatImageView ivWithoutBag;
    @NonNull
    public final DSRadioButton rbWithEcoFriendlyBag;
    @NonNull
    public final DSRadioButton rbWithPlasticBag;
    @NonNull
    public final DSRadioButton rbWithoutBag;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tvDescriptionWithEcoFriendlyBag;
    @NonNull
    public final TextView tvDescriptionWithPlasticBag;
    @NonNull
    public final TextView tvDescriptionWithoutBag;
    @NonNull
    public final TextView tvPriceWithEcoFriendlyBag;
    @NonNull
    public final TextView tvPriceWithPlasticBag;
    @NonNull
    public final TextView tvPriceWithoutBag;
    @NonNull
    public final TextView tvTitle;
    @NonNull
    public final TextView tvTitleWithEcoFriendlyBag;
    @NonNull
    public final TextView tvTitleWithPlasticBag;
    @NonNull
    public final TextView tvTitleWithoutBag;

    private LayoutOptionsBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull DSRadioButton dSRadioButton, @NonNull DSRadioButton dSRadioButton2, @NonNull DSRadioButton dSRadioButton3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull TextView textView10, @NonNull TextView textView11) {
        this.rootView = linearLayout;
        this.btnContinue = textView;
        this.clWithEcoFriendlyBag = constraintLayout;
        this.clWithPlasticBag = constraintLayout2;
        this.clWithoutBag = constraintLayout3;
        this.ivWithEcoFriendlyBag = appCompatImageView;
        this.ivWithPlasticBag = appCompatImageView2;
        this.ivWithoutBag = appCompatImageView3;
        this.rbWithEcoFriendlyBag = dSRadioButton;
        this.rbWithPlasticBag = dSRadioButton2;
        this.rbWithoutBag = dSRadioButton3;
        this.tvDescriptionWithEcoFriendlyBag = textView2;
        this.tvDescriptionWithPlasticBag = textView3;
        this.tvDescriptionWithoutBag = textView4;
        this.tvPriceWithEcoFriendlyBag = textView5;
        this.tvPriceWithPlasticBag = textView6;
        this.tvPriceWithoutBag = textView7;
        this.tvTitle = textView8;
        this.tvTitleWithEcoFriendlyBag = textView9;
        this.tvTitleWithPlasticBag = textView10;
        this.tvTitleWithoutBag = textView11;
    }

    @NonNull
    public static LayoutOptionsBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.btnContinue;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i11);
        if (textView != null) {
            i11 = R.id.clWithEcoFriendlyBag;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
            if (constraintLayout != null) {
                i11 = R.id.clWithPlasticBag;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
                if (constraintLayout2 != null) {
                    i11 = R.id.clWithoutBag;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i11);
                    if (constraintLayout3 != null) {
                        i11 = R.id.ivWithEcoFriendlyBag;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i11);
                        if (appCompatImageView != null) {
                            i11 = R.id.ivWithPlasticBag;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R.id.ivWithoutBag;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view2, i11);
                                if (appCompatImageView3 != null) {
                                    i11 = R.id.rbWithEcoFriendlyBag;
                                    DSRadioButton dSRadioButton = (DSRadioButton) ViewBindings.findChildViewById(view2, i11);
                                    if (dSRadioButton != null) {
                                        i11 = R.id.rbWithPlasticBag;
                                        DSRadioButton dSRadioButton2 = (DSRadioButton) ViewBindings.findChildViewById(view2, i11);
                                        if (dSRadioButton2 != null) {
                                            i11 = R.id.rbWithoutBag;
                                            DSRadioButton dSRadioButton3 = (DSRadioButton) ViewBindings.findChildViewById(view2, i11);
                                            if (dSRadioButton3 != null) {
                                                i11 = R.id.tvDescriptionWithEcoFriendlyBag;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                if (textView2 != null) {
                                                    i11 = R.id.tvDescriptionWithPlasticBag;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                    if (textView3 != null) {
                                                        i11 = R.id.tvDescriptionWithoutBag;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                        if (textView4 != null) {
                                                            i11 = R.id.tvPriceWithEcoFriendlyBag;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                            if (textView5 != null) {
                                                                i11 = R.id.tvPriceWithPlasticBag;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                if (textView6 != null) {
                                                                    i11 = R.id.tvPriceWithoutBag;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                    if (textView7 != null) {
                                                                        i11 = R.id.tvTitle;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                        if (textView8 != null) {
                                                                            i11 = R.id.tvTitleWithEcoFriendlyBag;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                            if (textView9 != null) {
                                                                                i11 = R.id.tvTitleWithPlasticBag;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                                if (textView10 != null) {
                                                                                    i11 = R.id.tvTitleWithoutBag;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, i11);
                                                                                    if (textView11 != null) {
                                                                                        return new LayoutOptionsBinding((LinearLayout) view2, textView, constraintLayout, constraintLayout2, constraintLayout3, appCompatImageView, appCompatImageView2, appCompatImageView3, dSRadioButton, dSRadioButton2, dSRadioButton3, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_options, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
