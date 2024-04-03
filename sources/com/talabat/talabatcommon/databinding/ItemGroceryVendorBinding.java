package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.grocery.VendorLogo;

public final class ItemGroceryVendorBinding implements ViewBinding {
    @NonNull
    public final TextView deliveryTime;
    @NonNull
    public final TextView discountTag;
    @NonNull
    public final TextView newTag;
    @NonNull
    public final TextView offersTag;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView vendorCuisine;
    @NonNull
    public final VendorLogo vendorLogo;
    @NonNull
    public final TextView vendorName;

    private ItemGroceryVendorBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull VendorLogo vendorLogo2, @NonNull TextView textView6) {
        this.rootView = constraintLayout;
        this.deliveryTime = textView;
        this.discountTag = textView2;
        this.newTag = textView3;
        this.offersTag = textView4;
        this.vendorCuisine = textView5;
        this.vendorLogo = vendorLogo2;
        this.vendorName = textView6;
    }

    @NonNull
    public static ItemGroceryVendorBinding bind(@NonNull View view) {
        int i11 = R.id.deliveryTime;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.discountTag;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.newTag;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView3 != null) {
                    i11 = R.id.offersTag;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView4 != null) {
                        i11 = R.id.vendorCuisine;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView5 != null) {
                            i11 = R.id.vendorLogo;
                            VendorLogo vendorLogo2 = (VendorLogo) ViewBindings.findChildViewById(view, i11);
                            if (vendorLogo2 != null) {
                                i11 = R.id.vendorName;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView6 != null) {
                                    return new ItemGroceryVendorBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, textView5, vendorLogo2, textView6);
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
    public static ItemGroceryVendorBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemGroceryVendorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_grocery_vendor, viewGroup, false);
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
