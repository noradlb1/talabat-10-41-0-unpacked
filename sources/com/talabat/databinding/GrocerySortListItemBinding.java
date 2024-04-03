package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatRadioButton;
import com.talabat.TalabatTextView;

public final class GrocerySortListItemBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout itemLayout;
    @NonNull
    public final TalabatRadioButton itemRadio;
    @NonNull
    public final TalabatTextView itemTxt;
    @NonNull
    private final RelativeLayout rootView;

    private GrocerySortListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatRadioButton talabatRadioButton, @NonNull TalabatTextView talabatTextView) {
        this.rootView = relativeLayout;
        this.itemLayout = relativeLayout2;
        this.itemRadio = talabatRadioButton;
        this.itemTxt = talabatTextView;
    }

    @NonNull
    public static GrocerySortListItemBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i11 = R.id.item_radio;
        TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view, R.id.item_radio);
        if (talabatRadioButton != null) {
            i11 = R.id.item_txt;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_txt);
            if (talabatTextView != null) {
                return new GrocerySortListItemBinding(relativeLayout, relativeLayout, talabatRadioButton, talabatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GrocerySortListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GrocerySortListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.grocery_sort_list_item, viewGroup, false);
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
