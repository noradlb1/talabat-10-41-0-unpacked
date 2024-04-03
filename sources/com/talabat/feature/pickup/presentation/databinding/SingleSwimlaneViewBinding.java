package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.talabat.feature.pickup.presentation.R;

public final class SingleSwimlaneViewBinding implements ViewBinding {
    @NonNull
    public final ImageView distanceIv;
    @NonNull
    public final TextView distanceTv;
    @NonNull
    public final LinearLayout distanceView;
    @NonNull
    public final ImageView hintIv;
    @NonNull
    public final TextView hintTv;
    @NonNull
    public final LinearLayout hintView;
    @NonNull
    public final ShapeableImageView logoIv;
    @NonNull
    public final TextView ratingCountTv;
    @NonNull
    public final TextView restaurantNameTv;
    @NonNull
    private final ConstraintLayout rootView;

    private SingleSwimlaneViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull ShapeableImageView shapeableImageView, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.distanceIv = imageView;
        this.distanceTv = textView;
        this.distanceView = linearLayout;
        this.hintIv = imageView2;
        this.hintTv = textView2;
        this.hintView = linearLayout2;
        this.logoIv = shapeableImageView;
        this.ratingCountTv = textView3;
        this.restaurantNameTv = textView4;
    }

    @NonNull
    public static SingleSwimlaneViewBinding bind(@NonNull View view) {
        int i11 = R.id.distanceIv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.distanceTv;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.distanceView;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                if (linearLayout != null) {
                    i11 = R.id.hintIv;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView2 != null) {
                        i11 = R.id.hintTv;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.hintView;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                            if (linearLayout2 != null) {
                                i11 = R.id.logoIv;
                                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, i11);
                                if (shapeableImageView != null) {
                                    i11 = R.id.ratingCountTv;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView3 != null) {
                                        i11 = R.id.restaurantNameTv;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView4 != null) {
                                            return new SingleSwimlaneViewBinding((ConstraintLayout) view, imageView, textView, linearLayout, imageView2, textView2, linearLayout2, shapeableImageView, textView3, textView4);
                                        }
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
    public static SingleSwimlaneViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SingleSwimlaneViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.single_swimlane_view, viewGroup, false);
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
