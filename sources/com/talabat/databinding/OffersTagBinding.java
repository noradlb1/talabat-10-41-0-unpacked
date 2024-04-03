package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class OffersTagBinding implements ViewBinding {
    @NonNull
    public final ImageView iconPromo;
    @NonNull
    private final RelativeLayout rootView;

    private OffersTagBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView) {
        this.rootView = relativeLayout;
        this.iconPromo = imageView;
    }

    @NonNull
    public static OffersTagBinding bind(@NonNull View view) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon_promo);
        if (imageView != null) {
            return new OffersTagBinding((RelativeLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.icon_promo)));
    }

    @NonNull
    public static OffersTagBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OffersTagBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.offers_tag, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
