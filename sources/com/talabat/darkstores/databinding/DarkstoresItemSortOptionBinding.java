package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresItemSortOptionBinding implements ViewBinding {
    @NonNull
    public final View divider;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final FrameLayout selectedRadioIndicator;
    @NonNull
    public final AppCompatTextView sortItemText;
    @NonNull
    public final RadioButton sortRadioButton;

    private DarkstoresItemSortOptionBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull FrameLayout frameLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull RadioButton radioButton) {
        this.rootView = constraintLayout;
        this.divider = view;
        this.selectedRadioIndicator = frameLayout;
        this.sortItemText = appCompatTextView;
        this.sortRadioButton = radioButton;
    }

    @NonNull
    public static DarkstoresItemSortOptionBinding bind(@NonNull View view) {
        int i11 = R.id.divider;
        View findChildViewById = ViewBindings.findChildViewById(view, i11);
        if (findChildViewById != null) {
            i11 = R.id.selected_radio_indicator;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
            if (frameLayout != null) {
                i11 = R.id.sort_item_text;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                if (appCompatTextView != null) {
                    i11 = R.id.sort_radio_button;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i11);
                    if (radioButton != null) {
                        return new DarkstoresItemSortOptionBinding((ConstraintLayout) view, findChildViewById, frameLayout, appCompatTextView, radioButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemSortOptionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemSortOptionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_sort_option, viewGroup, false);
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
