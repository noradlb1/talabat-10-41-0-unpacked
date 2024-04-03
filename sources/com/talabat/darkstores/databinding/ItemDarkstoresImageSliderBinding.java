package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.jsibbold.zoomage.ZoomageView;
import com.talabat.darkstores.R;

public final class ItemDarkstoresImageSliderBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ZoomageView sliderZoomImage;

    private ItemDarkstoresImageSliderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ZoomageView zoomageView) {
        this.rootView = constraintLayout;
        this.sliderZoomImage = zoomageView;
    }

    @NonNull
    public static ItemDarkstoresImageSliderBinding bind(@NonNull View view) {
        int i11 = R.id.sliderZoomImage;
        ZoomageView zoomageView = (ZoomageView) ViewBindings.findChildViewById(view, i11);
        if (zoomageView != null) {
            return new ItemDarkstoresImageSliderBinding((ConstraintLayout) view, zoomageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemDarkstoresImageSliderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemDarkstoresImageSliderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_darkstores_image_slider, viewGroup, false);
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
