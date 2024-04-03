package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.pickup.presentation.R;

public final class FragmentPickupValuePropBinding implements ViewBinding {
    @NonNull
    public final TextView bodyTv1;
    @NonNull
    public final TextView bodyTv2;
    @NonNull
    public final TextView bodyTv3;
    @NonNull
    public final CardView closeBtn;
    @NonNull
    public final ImageView imageView1;
    @NonNull
    public final ImageView imageView2;
    @NonNull
    public final ImageView imageView3;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView subheadingTv1;
    @NonNull
    public final TextView subheadingTv2;
    @NonNull
    public final TextView subheadingTv3;

    private FragmentPickupValuePropBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.rootView = constraintLayout;
        this.bodyTv1 = textView;
        this.bodyTv2 = textView2;
        this.bodyTv3 = textView3;
        this.closeBtn = cardView;
        this.imageView1 = imageView;
        this.imageView2 = imageView4;
        this.imageView3 = imageView5;
        this.subheadingTv1 = textView4;
        this.subheadingTv2 = textView5;
        this.subheadingTv3 = textView6;
    }

    @NonNull
    public static FragmentPickupValuePropBinding bind(@NonNull View view) {
        int i11 = R.id.bodyTv1;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.bodyTv2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.bodyTv3;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView3 != null) {
                    i11 = R.id.closeBtn;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
                    if (cardView != null) {
                        i11 = R.id.imageView1;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                        if (imageView != null) {
                            i11 = R.id.imageView2;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i11);
                            if (imageView4 != null) {
                                i11 = R.id.imageView3;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i11);
                                if (imageView5 != null) {
                                    i11 = R.id.subheadingTv1;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView4 != null) {
                                        i11 = R.id.subheadingTv2;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView5 != null) {
                                            i11 = R.id.subheadingTv3;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i11);
                                            if (textView6 != null) {
                                                return new FragmentPickupValuePropBinding((ConstraintLayout) view, textView, textView2, textView3, cardView, imageView, imageView4, imageView5, textView4, textView5, textView6);
                                            }
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
    public static FragmentPickupValuePropBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentPickupValuePropBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pickup_value_prop, viewGroup, false);
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
