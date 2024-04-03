package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_radiobutton.DSRadioButton;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemChoiceRevampBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView discountedPrice;
    @NonNull
    public final ImageView itemAddedIndicator;
    @NonNull
    public final TalabatTextView mChoiceName;
    @NonNull
    public final DSRadioButton radioButtonChoice;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatTextView textViewPrice;

    private ItemChoiceRevampBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView2, @NonNull DSRadioButton dSRadioButton, @NonNull TalabatTextView talabatTextView3) {
        this.rootView = relativeLayout;
        this.discountedPrice = talabatTextView;
        this.itemAddedIndicator = imageView;
        this.mChoiceName = talabatTextView2;
        this.radioButtonChoice = dSRadioButton;
        this.textViewPrice = talabatTextView3;
    }

    @NonNull
    public static ItemChoiceRevampBinding bind(@NonNull View view) {
        int i11 = R.id.discounted_price;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.discounted_price);
        if (talabatTextView != null) {
            i11 = R.id.item_added_indicator;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.item_added_indicator);
            if (imageView != null) {
                i11 = R.id.m_choice_name;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.m_choice_name);
                if (talabatTextView2 != null) {
                    i11 = R.id.radioButton_choice;
                    DSRadioButton dSRadioButton = (DSRadioButton) ViewBindings.findChildViewById(view, R.id.radioButton_choice);
                    if (dSRadioButton != null) {
                        i11 = R.id.textView_price;
                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.textView_price);
                        if (talabatTextView3 != null) {
                            return new ItemChoiceRevampBinding((RelativeLayout) view, talabatTextView, imageView, talabatTextView2, dSRadioButton, talabatTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemChoiceRevampBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemChoiceRevampBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_choice_revamp, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
