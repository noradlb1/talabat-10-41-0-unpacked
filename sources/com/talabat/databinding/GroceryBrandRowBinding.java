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

public final class GroceryBrandRowBinding implements ViewBinding {
    @NonNull
    public final AppCompatCheckBox brandCheckbox;
    @NonNull
    public final TalabatTextView brandTitle;
    @NonNull
    public final RelativeLayout parentRowView;
    @NonNull
    private final RelativeLayout rootView;

    private GroceryBrandRowBinding(@NonNull RelativeLayout relativeLayout, @NonNull AppCompatCheckBox appCompatCheckBox, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.brandCheckbox = appCompatCheckBox;
        this.brandTitle = talabatTextView;
        this.parentRowView = relativeLayout2;
    }

    @NonNull
    public static GroceryBrandRowBinding bind(@NonNull View view) {
        int i11 = R.id.brand_checkbox;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, R.id.brand_checkbox);
        if (appCompatCheckBox != null) {
            i11 = R.id.brand_title;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.brand_title);
            if (talabatTextView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                return new GroceryBrandRowBinding(relativeLayout, appCompatCheckBox, talabatTextView, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GroceryBrandRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GroceryBrandRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.grocery_brand_row, viewGroup, false);
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
