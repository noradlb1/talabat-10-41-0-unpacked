package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class OrderDetailsCartItemsBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView itemChoicesName;
    @NonNull
    public final TalabatTextView itemName;
    @NonNull
    public final TalabatTextView itemPrice;
    @NonNull
    public final TalabatTextView itemQuantity;
    @NonNull
    public final TalabatTextView itemSpecialRequest;
    @NonNull
    private final LinearLayout rootView;

    private OrderDetailsCartItemsBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5) {
        this.rootView = linearLayout;
        this.itemChoicesName = talabatTextView;
        this.itemName = talabatTextView2;
        this.itemPrice = talabatTextView3;
        this.itemQuantity = talabatTextView4;
        this.itemSpecialRequest = talabatTextView5;
    }

    @NonNull
    public static OrderDetailsCartItemsBinding bind(@NonNull View view) {
        int i11 = R.id.item_choices_name;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_choices_name);
        if (talabatTextView != null) {
            i11 = R.id.item_name;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_name);
            if (talabatTextView2 != null) {
                i11 = R.id.item_price;
                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_price);
                if (talabatTextView3 != null) {
                    i11 = R.id.item_quantity;
                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_quantity);
                    if (talabatTextView4 != null) {
                        i11 = R.id.item_special_request;
                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_special_request);
                        if (talabatTextView5 != null) {
                            return new OrderDetailsCartItemsBinding((LinearLayout) view, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4, talabatTextView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static OrderDetailsCartItemsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OrderDetailsCartItemsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.order_details_cart_items, viewGroup, false);
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
