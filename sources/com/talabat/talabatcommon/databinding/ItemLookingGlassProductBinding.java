package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ItemLookingGlassProductBinding implements ViewBinding {
    @NonNull
    public final Guideline endGuideline;
    @NonNull
    public final ImageView image;
    @NonNull
    public final FrameLayout imageContainerFrameLayout;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView tvPrice;
    @NonNull
    public final AppCompatTextView tvTitle;

    private ItemLookingGlassProductBinding(@NonNull CardView cardView, @NonNull Guideline guideline, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = cardView;
        this.endGuideline = guideline;
        this.image = imageView;
        this.imageContainerFrameLayout = frameLayout;
        this.tvPrice = textView;
        this.tvTitle = appCompatTextView;
    }

    @NonNull
    public static ItemLookingGlassProductBinding bind(@NonNull View view) {
        int i11 = R.id.endGuideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
        if (guideline != null) {
            i11 = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.imageContainerFrameLayout;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
                if (frameLayout != null) {
                    i11 = R.id.tvPrice;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.tvTitle;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                        if (appCompatTextView != null) {
                            return new ItemLookingGlassProductBinding((CardView) view, guideline, imageView, frameLayout, textView, appCompatTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemLookingGlassProductBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemLookingGlassProductBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_looking_glass_product, viewGroup, false);
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
