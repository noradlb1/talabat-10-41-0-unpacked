package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewEmptyRestaurantSearchResultBinding implements ViewBinding {
    @NonNull
    public final LinearLayout linearLayoutNoRestaurantContainer;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewEmptyRestaurantSearchResultBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.linearLayoutNoRestaurantContainer = linearLayout;
    }

    @NonNull
    public static ViewEmptyRestaurantSearchResultBinding bind(@NonNull View view) {
        int i11 = R.id.linearLayout_noRestaurantContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout != null) {
            return new ViewEmptyRestaurantSearchResultBinding((ConstraintLayout) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewEmptyRestaurantSearchResultBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewEmptyRestaurantSearchResultBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_empty_restaurant_search_result, viewGroup, false);
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
