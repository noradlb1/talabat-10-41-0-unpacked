package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ItemInlineAdNewBinding implements ViewBinding {
    @NonNull
    public final ImageView imageViewAdImage;
    @NonNull
    public final ImageView imageViewRestaurantLogo;
    @NonNull
    public final ViewPreOrderLabelBinding layoutPreOrder;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView textViewCuisines;
    @NonNull
    public final TextView textViewRestaurantName;

    private ItemInlineAdNewBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ViewPreOrderLabelBinding viewPreOrderLabelBinding, @NonNull ProgressBar progressBar2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = cardView;
        this.imageViewAdImage = imageView;
        this.imageViewRestaurantLogo = imageView2;
        this.layoutPreOrder = viewPreOrderLabelBinding;
        this.progressBar = progressBar2;
        this.textViewCuisines = textView;
        this.textViewRestaurantName = textView2;
    }

    @NonNull
    public static ItemInlineAdNewBinding bind(@NonNull View view) {
        int i11 = R.id.imageView_adImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_adImage);
        if (imageView != null) {
            i11 = R.id.imageView_restaurantLogo;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_restaurantLogo);
            if (imageView2 != null) {
                i11 = R.id.layout_preOrder;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.layout_preOrder);
                if (findChildViewById != null) {
                    ViewPreOrderLabelBinding bind = ViewPreOrderLabelBinding.bind(findChildViewById);
                    i11 = R.id.progressBar;
                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
                    if (progressBar2 != null) {
                        i11 = R.id.textView_cuisines;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView_cuisines);
                        if (textView != null) {
                            i11 = R.id.textView_restaurantName;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.textView_restaurantName);
                            if (textView2 != null) {
                                return new ItemInlineAdNewBinding((CardView) view, imageView, imageView2, bind, progressBar2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemInlineAdNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemInlineAdNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_inline_ad_new, viewGroup, false);
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
