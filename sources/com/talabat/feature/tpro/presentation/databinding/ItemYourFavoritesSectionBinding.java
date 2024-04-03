package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class ItemYourFavoritesSectionBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final RecyclerView rvFavoriteVendors;
    @NonNull
    public final TextView tvOnBoardingFavoritesHeader;
    @NonNull
    public final TextView tvOnBoardingFavoritesHeaderPro;

    private ItemYourFavoritesSectionBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.rvFavoriteVendors = recyclerView;
        this.tvOnBoardingFavoritesHeader = textView;
        this.tvOnBoardingFavoritesHeaderPro = textView2;
    }

    @NonNull
    public static ItemYourFavoritesSectionBinding bind(@NonNull View view) {
        int i11 = R.id.rv_favorite_vendors;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView != null) {
            i11 = R.id.tv_on_boarding_favorites_header;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.tv_on_boarding_favorites_header_pro;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new ItemYourFavoritesSectionBinding((ConstraintLayout) view, recyclerView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemYourFavoritesSectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemYourFavoritesSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_your_favorites_section, viewGroup, false);
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
