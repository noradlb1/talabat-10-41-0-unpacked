package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;

public final class UpsellingSingleItemBinding implements ViewBinding {
    @NonNull
    public final CardView backgroundCard;
    @NonNull
    public final RelativeLayout itemImageHolder;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final RelativeLayout touchContainer;
    @NonNull
    public final ImageView upSellingImg;
    @NonNull
    public final TalabatTextView upSellingItemName;
    @NonNull
    public final TalabatTextView upSellingItemPrice;
    @NonNull
    public final TalabatButton upsellingAddToCart;

    private UpsellingSingleItemBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar2, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatButton talabatButton) {
        this.rootView = cardView;
        this.backgroundCard = cardView2;
        this.itemImageHolder = relativeLayout;
        this.progressBar = progressBar2;
        this.touchContainer = relativeLayout2;
        this.upSellingImg = imageView;
        this.upSellingItemName = talabatTextView;
        this.upSellingItemPrice = talabatTextView2;
        this.upsellingAddToCart = talabatButton;
    }

    @NonNull
    public static UpsellingSingleItemBinding bind(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i11 = R.id.item_image_holder;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.item_image_holder);
        if (relativeLayout != null) {
            i11 = R.id.progressBar;
            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
            if (progressBar2 != null) {
                i11 = R.id.touch_container;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.touch_container);
                if (relativeLayout2 != null) {
                    i11 = R.id.up_selling_img;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.up_selling_img);
                    if (imageView != null) {
                        i11 = R.id.up_selling_item_name;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.up_selling_item_name);
                        if (talabatTextView != null) {
                            i11 = R.id.up_selling_item_price;
                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.up_selling_item_price);
                            if (talabatTextView2 != null) {
                                i11 = R.id.upselling_add_to_cart;
                                TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view, R.id.upselling_add_to_cart);
                                if (talabatButton != null) {
                                    return new UpsellingSingleItemBinding(cardView, cardView, relativeLayout, progressBar2, relativeLayout2, imageView, talabatTextView, talabatTextView2, talabatButton);
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
    public static UpsellingSingleItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static UpsellingSingleItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.upselling_single_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
