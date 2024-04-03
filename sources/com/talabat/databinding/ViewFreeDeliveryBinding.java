package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ViewFreeDeliveryBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView freeDeliveryReturnValue;
    @NonNull
    public final TalabatTextView freeDeliveryText;
    @NonNull
    public final ConstraintLayout restaurantFreeDeliveryView;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewFreeDeliveryBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.freeDeliveryReturnValue = talabatTextView;
        this.freeDeliveryText = talabatTextView2;
        this.restaurantFreeDeliveryView = constraintLayout2;
    }

    @NonNull
    public static ViewFreeDeliveryBinding bind(@NonNull View view) {
        int i11 = R.id.free_delivery_return_value;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.free_delivery_return_value);
        if (talabatTextView != null) {
            i11 = R.id.free_delivery_text;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.free_delivery_text);
            if (talabatTextView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new ViewFreeDeliveryBinding(constraintLayout, talabatTextView, talabatTextView2, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewFreeDeliveryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewFreeDeliveryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_free_delivery, viewGroup, false);
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
