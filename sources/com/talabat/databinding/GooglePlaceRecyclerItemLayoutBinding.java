package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class GooglePlaceRecyclerItemLayoutBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView description;
    @NonNull
    public final LinearLayout placeItemView;
    @NonNull
    public final TalabatTextView placeTitle;
    @NonNull
    public final ImageView placesImage;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout textLayout;

    private GooglePlaceRecyclerItemLayoutBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.description = talabatTextView;
        this.placeItemView = linearLayout2;
        this.placeTitle = talabatTextView2;
        this.placesImage = imageView;
        this.textLayout = linearLayout3;
    }

    @NonNull
    public static GooglePlaceRecyclerItemLayoutBinding bind(@NonNull View view) {
        int i11 = R.id.description;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.description);
        if (talabatTextView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i11 = R.id.place_title;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.place_title);
            if (talabatTextView2 != null) {
                i11 = R.id.places_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.places_image);
                if (imageView != null) {
                    i11 = R.id.text_layout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.text_layout);
                    if (linearLayout2 != null) {
                        return new GooglePlaceRecyclerItemLayoutBinding(linearLayout, talabatTextView, linearLayout, talabatTextView2, imageView, linearLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GooglePlaceRecyclerItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GooglePlaceRecyclerItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.google_place_recycler_item_layout, viewGroup, false);
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
