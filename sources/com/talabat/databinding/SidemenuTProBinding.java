package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import io.supercharge.shimmerlayout.ShimmerLayout;

public final class SidemenuTProBinding implements ViewBinding {
    @NonNull
    public final CardView cvTproBannerContainer;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TalabatTextView sidemenuDescription;
    @NonNull
    public final ImageView sidemenuPromo;
    @NonNull
    public final ShimmerLayout sidemenuShimmer;
    @NonNull
    public final TalabatTextView sidemenuTitle;
    @NonNull
    public final ImageView sidemenuTproLogo;

    private SidemenuTProBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull ShimmerLayout shimmerLayout, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView2) {
        this.rootView = cardView;
        this.cvTproBannerContainer = cardView2;
        this.sidemenuDescription = talabatTextView;
        this.sidemenuPromo = imageView;
        this.sidemenuShimmer = shimmerLayout;
        this.sidemenuTitle = talabatTextView2;
        this.sidemenuTproLogo = imageView2;
    }

    @NonNull
    public static SidemenuTProBinding bind(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i11 = R.id.sidemenu_description;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.sidemenu_description);
        if (talabatTextView != null) {
            i11 = R.id.sidemenu_promo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.sidemenu_promo);
            if (imageView != null) {
                i11 = R.id.sidemenu_shimmer;
                ShimmerLayout shimmerLayout = (ShimmerLayout) ViewBindings.findChildViewById(view, R.id.sidemenu_shimmer);
                if (shimmerLayout != null) {
                    i11 = R.id.sidemenu_title;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.sidemenu_title);
                    if (talabatTextView2 != null) {
                        i11 = R.id.sidemenu_tpro_logo;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.sidemenu_tpro_logo);
                        if (imageView2 != null) {
                            return new SidemenuTProBinding(cardView, cardView, talabatTextView, imageView, shimmerLayout, talabatTextView2, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SidemenuTProBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SidemenuTProBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.sidemenu_t_pro, viewGroup, false);
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
