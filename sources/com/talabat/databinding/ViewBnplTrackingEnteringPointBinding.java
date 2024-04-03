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

public final class ViewBnplTrackingEnteringPointBinding implements ViewBinding {
    @NonNull
    public final TextView bnplDescriptionTextView;
    @NonNull
    public final ImageView bnplEnteringPointIcon;
    @NonNull
    public final TalabatRadioButton bnplEnteringPointRadioButton;
    @NonNull
    public final DSTag bnplEnteringPointTag;
    @NonNull
    public final TextView bnplTextView;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewBnplTrackingEnteringPointBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TalabatRadioButton talabatRadioButton, @NonNull DSTag dSTag, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.bnplDescriptionTextView = textView;
        this.bnplEnteringPointIcon = imageView;
        this.bnplEnteringPointRadioButton = talabatRadioButton;
        this.bnplEnteringPointTag = dSTag;
        this.bnplTextView = textView2;
    }

    @NonNull
    public static ViewBnplTrackingEnteringPointBinding bind(@NonNull View view) {
        int i11 = R.id.bnpl_description_text_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bnpl_description_text_view);
        if (textView != null) {
            i11 = R.id.bnpl_entering_point_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.bnpl_entering_point_icon);
            if (imageView != null) {
                i11 = R.id.bnpl_entering_point_radio_button;
                TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view, R.id.bnpl_entering_point_radio_button);
                if (talabatRadioButton != null) {
                    i11 = R.id.bnpl_entering_point_tag;
                    DSTag dSTag = (DSTag) ViewBindings.findChildViewById(view, R.id.bnpl_entering_point_tag);
                    if (dSTag != null) {
                        i11 = R.id.bnpl_text_view;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.bnpl_text_view);
                        if (textView2 != null) {
                            return new ViewBnplTrackingEnteringPointBinding((ConstraintLayout) view, textView, imageView, talabatRadioButton, dSTag, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewBnplTrackingEnteringPointBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewBnplTrackingEnteringPointBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_bnpl_tracking_entering_point, viewGroup, false);
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
