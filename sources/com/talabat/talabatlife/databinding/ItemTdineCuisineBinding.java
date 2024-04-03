package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class ItemTdineCuisineBinding implements ViewBinding {
    @NonNull
    public final TextView cuisineName;
    @NonNull
    public final ToggleButton cuisinesCheckBox;
    @NonNull
    private final LinearLayout rootView;

    private ItemTdineCuisineBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ToggleButton toggleButton) {
        this.rootView = linearLayout;
        this.cuisineName = textView;
        this.cuisinesCheckBox = toggleButton;
    }

    @NonNull
    public static ItemTdineCuisineBinding bind(@NonNull View view) {
        int i11 = R.id.cuisineName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.cuisinesCheckBox;
            ToggleButton toggleButton = (ToggleButton) ViewBindings.findChildViewById(view, i11);
            if (toggleButton != null) {
                return new ItemTdineCuisineBinding((LinearLayout) view, textView, toggleButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemTdineCuisineBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemTdineCuisineBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_tdine_cuisine, viewGroup, false);
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
