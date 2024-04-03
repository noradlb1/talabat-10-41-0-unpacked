package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_radiobutton.DSRadioButton;
import com.talabat.feature.tpro.presentation.R;

public final class ItemPlanSelectionBinding implements ViewBinding {
    @NonNull
    public final DSRadioButton rbPlanSelection;
    @NonNull
    private final View rootView;
    @NonNull
    public final TextView tvPlanName;
    @NonNull
    public final TextView tvPlanPricing;
    @NonNull
    public final TextView tvPlanPricingDescription;

    private ItemPlanSelectionBinding(@NonNull View view, @NonNull DSRadioButton dSRadioButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = view;
        this.rbPlanSelection = dSRadioButton;
        this.tvPlanName = textView;
        this.tvPlanPricing = textView2;
        this.tvPlanPricingDescription = textView3;
    }

    @NonNull
    public static ItemPlanSelectionBinding bind(@NonNull View view) {
        int i11 = R.id.rb_plan_selection;
        DSRadioButton dSRadioButton = (DSRadioButton) ViewBindings.findChildViewById(view, i11);
        if (dSRadioButton != null) {
            i11 = R.id.tv_plan_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.tv_plan_pricing;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.tv_plan_pricing_description;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        return new ItemPlanSelectionBinding(view, dSRadioButton, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemPlanSelectionBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.item_plan_selection, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
