package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresAgeRestrictionAlertBinding implements ViewBinding {
    @NonNull
    public final TextView ageRestrictionAlertText;
    @NonNull
    public final ImageView alertClose;
    @NonNull
    public final AppCompatImageView alertIcon;
    @NonNull
    public final Guideline endGuideline;
    @NonNull
    private final ConstraintLayout rootView;

    private DarkstoresAgeRestrictionAlertBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull AppCompatImageView appCompatImageView, @NonNull Guideline guideline) {
        this.rootView = constraintLayout;
        this.ageRestrictionAlertText = textView;
        this.alertClose = imageView;
        this.alertIcon = appCompatImageView;
        this.endGuideline = guideline;
    }

    @NonNull
    public static DarkstoresAgeRestrictionAlertBinding bind(@NonNull View view) {
        int i11 = R.id.age_restriction_alert_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.alert_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.alert_icon;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                if (appCompatImageView != null) {
                    i11 = R.id.endGuideline;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
                    if (guideline != null) {
                        return new DarkstoresAgeRestrictionAlertBinding((ConstraintLayout) view, textView, imageView, appCompatImageView, guideline);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresAgeRestrictionAlertBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresAgeRestrictionAlertBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_age_restriction_alert, viewGroup, false);
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
