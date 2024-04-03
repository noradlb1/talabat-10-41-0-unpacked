package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class PromoTagBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView iconPromo;
    @NonNull
    public final TextView promoTitle;
    @NonNull
    private final RelativeLayout rootView;

    private PromoTagBinding(@NonNull RelativeLayout relativeLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.iconPromo = appCompatImageView;
        this.promoTitle = textView;
    }

    @NonNull
    public static PromoTagBinding bind(@NonNull View view) {
        int i11 = R.id.icon_promo;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.promo_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new PromoTagBinding((RelativeLayout) view, appCompatImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static PromoTagBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static PromoTagBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.promo_tag, viewGroup, false);
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
