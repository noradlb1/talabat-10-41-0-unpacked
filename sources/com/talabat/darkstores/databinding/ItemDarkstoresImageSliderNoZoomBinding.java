package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class ItemDarkstoresImageSliderNoZoomBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView sliderImage;

    private ItemDarkstoresImageSliderNoZoomBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView) {
        this.rootView = constraintLayout;
        this.sliderImage = imageView;
    }

    @NonNull
    public static ItemDarkstoresImageSliderNoZoomBinding bind(@NonNull View view) {
        int i11 = R.id.sliderImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            return new ItemDarkstoresImageSliderNoZoomBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemDarkstoresImageSliderNoZoomBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemDarkstoresImageSliderNoZoomBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_darkstores_image_slider_no_zoom, viewGroup, false);
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
