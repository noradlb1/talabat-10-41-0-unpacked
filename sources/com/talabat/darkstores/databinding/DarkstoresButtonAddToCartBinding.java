package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresButtonAddToCartBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView addToCartButtonAdd;
    @NonNull
    public final TextView addToCartButtonQuantity;
    @NonNull
    public final AppCompatImageView addToCartButtonRemove;
    @NonNull
    public final TextView addToCartLimitError;
    @NonNull
    public final Guideline bottomGuideline;
    @NonNull
    public final Guideline leftGuideline;
    @NonNull
    public final Guideline rightGuideline;
    @NonNull
    private final View rootView;
    @NonNull
    public final Guideline topGuideline;

    private DarkstoresButtonAddToCartBinding(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull AppCompatImageView appCompatImageView2, @NonNull TextView textView2, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull Guideline guideline3, @NonNull Guideline guideline4) {
        this.rootView = view;
        this.addToCartButtonAdd = appCompatImageView;
        this.addToCartButtonQuantity = textView;
        this.addToCartButtonRemove = appCompatImageView2;
        this.addToCartLimitError = textView2;
        this.bottomGuideline = guideline;
        this.leftGuideline = guideline2;
        this.rightGuideline = guideline3;
        this.topGuideline = guideline4;
    }

    @NonNull
    public static DarkstoresButtonAddToCartBinding bind(@NonNull View view) {
        int i11 = R.id.add_to_cart_button_add;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.add_to_cart_button_quantity;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.add_to_cart_button_remove;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R.id.add_to_cart_limit_error;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        i11 = R.id.bottomGuideline;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
                        if (guideline != null) {
                            i11 = R.id.leftGuideline;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i11);
                            if (guideline2 != null) {
                                i11 = R.id.rightGuideline;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i11);
                                if (guideline3 != null) {
                                    i11 = R.id.topGuideline;
                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i11);
                                    if (guideline4 != null) {
                                        return new DarkstoresButtonAddToCartBinding(view, appCompatImageView, textView, appCompatImageView2, textView2, guideline, guideline2, guideline3, guideline4);
                                    }
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
    public static DarkstoresButtonAddToCartBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_button_add_to_cart, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
