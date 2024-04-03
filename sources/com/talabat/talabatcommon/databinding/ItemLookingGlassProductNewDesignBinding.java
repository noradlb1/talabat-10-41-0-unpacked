package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ItemLookingGlassProductNewDesignBinding implements ViewBinding {
    @NonNull
    public final ImageView image;
    @NonNull
    public final CardView imageContainerLayout;
    @NonNull
    public final LinearLayout layoutDiscount;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textviewDiscountPercentage;
    @NonNull
    public final TextView textviewOriginalPrice;
    @NonNull
    public final TextView tvPrice;
    @NonNull
    public final AppCompatTextView tvTitle;

    private ItemLookingGlassProductNewDesignBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.image = imageView;
        this.imageContainerLayout = cardView;
        this.layoutDiscount = linearLayout;
        this.textviewDiscountPercentage = textView;
        this.textviewOriginalPrice = textView2;
        this.tvPrice = textView3;
        this.tvTitle = appCompatTextView;
    }

    @NonNull
    public static ItemLookingGlassProductNewDesignBinding bind(@NonNull View view) {
        int i11 = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.imageContainerLayout;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
            if (cardView != null) {
                i11 = R.id.layout_discount;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                if (linearLayout != null) {
                    i11 = R.id.textview_discount_percentage;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.textview_original_price;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.tvPrice;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView3 != null) {
                                i11 = R.id.tvTitle;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                                if (appCompatTextView != null) {
                                    return new ItemLookingGlassProductNewDesignBinding((ConstraintLayout) view, imageView, cardView, linearLayout, textView, textView2, textView3, appCompatTextView);
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
    public static ItemLookingGlassProductNewDesignBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemLookingGlassProductNewDesignBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_looking_glass_product_new_design, viewGroup, false);
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
