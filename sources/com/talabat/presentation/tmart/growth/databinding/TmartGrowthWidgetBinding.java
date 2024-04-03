package com.talabat.presentation.tmart.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.presentation.tmart.growth.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class TmartGrowthWidgetBinding implements ViewBinding {
    @NonNull
    private final View rootView;
    @NonNull
    public final ShimmerLayout shimmerLayout;

    private TmartGrowthWidgetBinding(@NonNull View view, @NonNull ShimmerLayout shimmerLayout2) {
        this.rootView = view;
        this.shimmerLayout = shimmerLayout2;
    }

    @NonNull
    public static TmartGrowthWidgetBinding bind(@NonNull View view) {
        int i11 = R.id.shimmer_layout;
        ShimmerLayout shimmerLayout2 = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
        if (shimmerLayout2 != null) {
            return new TmartGrowthWidgetBinding(view, shimmerLayout2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TmartGrowthWidgetBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.tmart_growth_widget, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
