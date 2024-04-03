package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemAddonChoiceBinding implements ViewBinding {
    @NonNull
    public final AppCompatCheckBox checkboxOptionalItem;
    @NonNull
    public final TalabatTextView discountedPrice;
    @NonNull
    public final TalabatTextView mChoiceName;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatTextView textViewPrice;

    private ItemAddonChoiceBinding(@NonNull RelativeLayout relativeLayout, @NonNull AppCompatCheckBox appCompatCheckBox, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3) {
        this.rootView = relativeLayout;
        this.checkboxOptionalItem = appCompatCheckBox;
        this.discountedPrice = talabatTextView;
        this.mChoiceName = talabatTextView2;
        this.textViewPrice = talabatTextView3;
    }

    @NonNull
    public static ItemAddonChoiceBinding bind(@NonNull View view) {
        int i11 = R.id.checkbox_optionalItem;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.checkbox_optionalItem);
        if (appCompatCheckBox != null) {
            i11 = R.id.discounted_price;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.discounted_price);
            if (talabatTextView != null) {
                i11 = R.id.m_choice_name;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.m_choice_name);
                if (talabatTextView2 != null) {
                    i11 = R.id.textView_price;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.textView_price);
                    if (talabatTextView3 != null) {
                        return new ItemAddonChoiceBinding((RelativeLayout) view, appCompatCheckBox, talabatTextView, talabatTextView2, talabatTextView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemAddonChoiceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemAddonChoiceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_addon_choice, viewGroup, false);
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
