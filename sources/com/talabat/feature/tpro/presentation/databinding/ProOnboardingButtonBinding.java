package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class ProOnboardingButtonBinding implements ViewBinding {
    @NonNull
    public final CardView cardLayout;
    @NonNull
    public final ImageView ivPlus;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TextView tvButtonText;

    private ProOnboardingButtonBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = cardView;
        this.cardLayout = cardView2;
        this.ivPlus = imageView;
        this.tvButtonText = textView;
    }

    @NonNull
    public static ProOnboardingButtonBinding bind(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i11 = R.id.iv_plus;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.tv_button_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new ProOnboardingButtonBinding(cardView, cardView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ProOnboardingButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ProOnboardingButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.pro_onboarding_button, viewGroup, false);
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
