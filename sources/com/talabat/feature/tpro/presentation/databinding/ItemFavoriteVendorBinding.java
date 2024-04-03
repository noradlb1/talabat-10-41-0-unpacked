package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class ItemFavoriteVendorBinding implements ViewBinding {
    @NonNull
    private final CardView rootView;
    @NonNull
    public final ImageView vendorImage;

    private ItemFavoriteVendorBinding(@NonNull CardView cardView, @NonNull ImageView imageView) {
        this.rootView = cardView;
        this.vendorImage = imageView;
    }

    @NonNull
    public static ItemFavoriteVendorBinding bind(@NonNull View view) {
        int i11 = R.id.vendorImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            return new ItemFavoriteVendorBinding((CardView) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemFavoriteVendorBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemFavoriteVendorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_favorite_vendor, viewGroup, false);
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
