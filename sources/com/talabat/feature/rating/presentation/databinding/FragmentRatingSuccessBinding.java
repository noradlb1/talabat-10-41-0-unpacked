package com.talabat.feature.rating.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.feature.rating.presentation.PercentageLinearLayout;
import com.talabat.feature.rating.presentation.R;

public final class FragmentRatingSuccessBinding implements ViewBinding {
    @NonNull
    public final PercentageLinearLayout ratingLinear;
    @NonNull
    private final PercentageLinearLayout rootView;

    private FragmentRatingSuccessBinding(@NonNull PercentageLinearLayout percentageLinearLayout, @NonNull PercentageLinearLayout percentageLinearLayout2) {
        this.rootView = percentageLinearLayout;
        this.ratingLinear = percentageLinearLayout2;
    }

    @NonNull
    public static FragmentRatingSuccessBinding bind(@NonNull View view) {
        if (view != null) {
            PercentageLinearLayout percentageLinearLayout = (PercentageLinearLayout) view;
            return new FragmentRatingSuccessBinding(percentageLinearLayout, percentageLinearLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static FragmentRatingSuccessBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentRatingSuccessBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rating_success, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public PercentageLinearLayout getRoot() {
        return this.rootView;
    }
}
