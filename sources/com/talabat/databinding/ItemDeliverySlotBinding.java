package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_radio_button.DSRadioButton;
import com.talabat.R;

public final class ItemDeliverySlotBinding implements ViewBinding {
    @NonNull
    public final View divider;
    @NonNull
    public final DSRadioButton rbDeliverySlot;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final AppCompatTextView tvSlotTile;

    private ItemDeliverySlotBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull DSRadioButton dSRadioButton, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.divider = view;
        this.rbDeliverySlot = dSRadioButton;
        this.tvSlotTile = appCompatTextView;
    }

    @NonNull
    public static ItemDeliverySlotBinding bind(@NonNull View view) {
        int i11 = R.id.divider;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.divider);
        if (findChildViewById != null) {
            i11 = R.id.rbDeliverySlot;
            DSRadioButton dSRadioButton = (DSRadioButton) ViewBindings.findChildViewById(view, R.id.rbDeliverySlot);
            if (dSRadioButton != null) {
                i11 = R.id.tvSlotTile;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, R.id.tvSlotTile);
                if (appCompatTextView != null) {
                    return new ItemDeliverySlotBinding((ConstraintLayout) view, findChildViewById, dSRadioButton, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemDeliverySlotBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemDeliverySlotBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_delivery_slot, viewGroup, false);
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
