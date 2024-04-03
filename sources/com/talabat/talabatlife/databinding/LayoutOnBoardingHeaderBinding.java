package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class LayoutOnBoardingHeaderBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView tLifeOnBoardingBannerImageView;
    @NonNull
    public final TextView tLifeOnBoardingSubTitleTextView;
    @NonNull
    public final TextView tLifeOnBoardingTitleTextView;

    private LayoutOnBoardingHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.tLifeOnBoardingBannerImageView = imageView;
        this.tLifeOnBoardingSubTitleTextView = textView;
        this.tLifeOnBoardingTitleTextView = textView2;
    }

    @NonNull
    public static LayoutOnBoardingHeaderBinding bind(@NonNull View view) {
        int i11 = R.id.tLifeOnBoardingBannerImageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.tLifeOnBoardingSubTitleTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.tLifeOnBoardingTitleTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new LayoutOnBoardingHeaderBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutOnBoardingHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutOnBoardingHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_on_boarding_header, viewGroup, false);
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
