package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresPartialFulfillmentCartSectionBinding implements ViewBinding {
    @NonNull
    public final AppCompatTextView noSelectionSelect;
    @NonNull
    public final ConstraintLayout notSelectedControlContainer;
    @NonNull
    public final AppCompatTextView partialFulfillmentTitle;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ConstraintLayout selectedControlContainer;
    @NonNull
    public final AppCompatTextView selectionChange;
    @NonNull
    public final AppCompatTextView selectionControlBody;
    @NonNull
    public final AppCompatTextView selectionControlTitle;

    private DarkstoresPartialFulfillmentCartSectionBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatTextView appCompatTextView2, @NonNull ConstraintLayout constraintLayout3, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5) {
        this.rootView = constraintLayout;
        this.noSelectionSelect = appCompatTextView;
        this.notSelectedControlContainer = constraintLayout2;
        this.partialFulfillmentTitle = appCompatTextView2;
        this.selectedControlContainer = constraintLayout3;
        this.selectionChange = appCompatTextView3;
        this.selectionControlBody = appCompatTextView4;
        this.selectionControlTitle = appCompatTextView5;
    }

    @NonNull
    public static DarkstoresPartialFulfillmentCartSectionBinding bind(@NonNull View view) {
        int i11 = R.id.no_selection_select;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
        if (appCompatTextView != null) {
            i11 = R.id.not_selected_control_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
            if (constraintLayout != null) {
                i11 = R.id.partial_fulfillment_title;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R.id.selected_control_container;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
                    if (constraintLayout2 != null) {
                        i11 = R.id.selection_change;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R.id.selection_control_body;
                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                            if (appCompatTextView4 != null) {
                                i11 = R.id.selection_control_title;
                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                                if (appCompatTextView5 != null) {
                                    return new DarkstoresPartialFulfillmentCartSectionBinding((ConstraintLayout) view, appCompatTextView, constraintLayout, appCompatTextView2, constraintLayout2, appCompatTextView3, appCompatTextView4, appCompatTextView5);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresPartialFulfillmentCartSectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresPartialFulfillmentCartSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_partial_fulfillment_cart_section, viewGroup, false);
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
