package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresPartialFulfillmentOptionTopBinding implements ViewBinding {
    @NonNull
    public final ImageView optionIcon;
    @NonNull
    public final ConstraintLayout preferenceContainer;
    @NonNull
    public final RadioButton radioButtonChoice;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final AppCompatTextView selectionControlBody;
    @NonNull
    public final AppCompatTextView selectionControlTitle;

    private DarkstoresPartialFulfillmentOptionTopBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull RadioButton radioButton, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.optionIcon = imageView;
        this.preferenceContainer = constraintLayout2;
        this.radioButtonChoice = radioButton;
        this.selectionControlBody = appCompatTextView;
        this.selectionControlTitle = appCompatTextView2;
    }

    @NonNull
    public static DarkstoresPartialFulfillmentOptionTopBinding bind(@NonNull View view) {
        int i11 = R.id.option_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R.id.radioButton_choice;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i11);
            if (radioButton != null) {
                i11 = R.id.selection_control_body;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                if (appCompatTextView != null) {
                    i11 = R.id.selection_control_title;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                    if (appCompatTextView2 != null) {
                        return new DarkstoresPartialFulfillmentOptionTopBinding(constraintLayout, imageView, constraintLayout, radioButton, appCompatTextView, appCompatTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresPartialFulfillmentOptionTopBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresPartialFulfillmentOptionTopBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_partial_fulfillment_option_top, viewGroup, false);
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
