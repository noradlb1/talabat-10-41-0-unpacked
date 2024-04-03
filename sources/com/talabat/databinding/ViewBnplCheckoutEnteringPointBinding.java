package com.talabat.databinding;

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
import com.designsystem.ds_tag.DSTag;
import com.talabat.R;
import com.talabat.TalabatRadioButton;

public final class ViewBnplCheckoutEnteringPointBinding implements ViewBinding {
    @NonNull
    public final ImageView bnplEligibilityErrorImageView;
    @NonNull
    public final ImageView bnplIcon;
    @NonNull
    public final TextView bnplPlanDescriptionTextView;
    @NonNull
    public final TextView bnplPlanTextView;
    @NonNull
    public final TalabatRadioButton bnplRadioButton;
    @NonNull
    public final DSTag bnplTag;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewBnplCheckoutEnteringPointBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TalabatRadioButton talabatRadioButton, @NonNull DSTag dSTag) {
        this.rootView = constraintLayout;
        this.bnplEligibilityErrorImageView = imageView;
        this.bnplIcon = imageView2;
        this.bnplPlanDescriptionTextView = textView;
        this.bnplPlanTextView = textView2;
        this.bnplRadioButton = talabatRadioButton;
        this.bnplTag = dSTag;
    }

    @NonNull
    public static ViewBnplCheckoutEnteringPointBinding bind(@NonNull View view) {
        int i11 = R.id.bnpl_eligibility_error_image_view;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.bnpl_eligibility_error_image_view);
        if (imageView != null) {
            i11 = R.id.bnpl_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.bnpl_icon);
            if (imageView2 != null) {
                i11 = R.id.bnpl_plan_description_text_view;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bnpl_plan_description_text_view);
                if (textView != null) {
                    i11 = R.id.bnpl_plan_text_view;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.bnpl_plan_text_view);
                    if (textView2 != null) {
                        i11 = R.id.bnpl_radio_button;
                        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view, R.id.bnpl_radio_button);
                        if (talabatRadioButton != null) {
                            i11 = R.id.bnpl_tag;
                            DSTag dSTag = (DSTag) ViewBindings.findChildViewById(view, R.id.bnpl_tag);
                            if (dSTag != null) {
                                return new ViewBnplCheckoutEnteringPointBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2, talabatRadioButton, dSTag);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewBnplCheckoutEnteringPointBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewBnplCheckoutEnteringPointBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_bnpl_checkout_entering_point, viewGroup, false);
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
