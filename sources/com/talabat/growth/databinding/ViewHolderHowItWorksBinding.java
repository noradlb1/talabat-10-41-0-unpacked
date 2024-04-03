package com.talabat.growth.databinding;

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
import com.talabat.growth.R;

public final class ViewHolderHowItWorksBinding implements ViewBinding {
    @NonNull
    public final ImageView loyaltyHowItWorksImageView;
    @NonNull
    public final TextView loyaltyHowItWorksTextView;
    @NonNull
    private final LinearLayout rootView;

    private ViewHolderHowItWorksBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.loyaltyHowItWorksImageView = imageView;
        this.loyaltyHowItWorksTextView = textView;
    }

    @NonNull
    public static ViewHolderHowItWorksBinding bind(@NonNull View view) {
        int i11 = R.id.loyaltyHowItWorksImageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.loyaltyHowItWorksTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new ViewHolderHowItWorksBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewHolderHowItWorksBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderHowItWorksBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_how_it_works, viewGroup, false);
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
