package com.talabat.feature.rating.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.rating.presentation.PercentageLinearLayout;
import com.talabat.feature.rating.presentation.R;
import com.talabat.talabatcommon.views.TalabatStarRating;

public final class FragmentRatingDeliveryBinding implements ViewBinding {
    @NonNull
    public final ImageView buttonDeliveryClose;
    @NonNull
    public final PercentageLinearLayout deliveryLinear;
    @NonNull
    public final ImageView deliveryLogo;
    @NonNull
    public final TalabatStarRating rbDeliveryRating;
    @NonNull
    private final PercentageLinearLayout rootView;
    @NonNull
    public final TextView tvDeliveryExperienceRatingTitle;

    private FragmentRatingDeliveryBinding(@NonNull PercentageLinearLayout percentageLinearLayout, @NonNull ImageView imageView, @NonNull PercentageLinearLayout percentageLinearLayout2, @NonNull ImageView imageView2, @NonNull TalabatStarRating talabatStarRating, @NonNull TextView textView) {
        this.rootView = percentageLinearLayout;
        this.buttonDeliveryClose = imageView;
        this.deliveryLinear = percentageLinearLayout2;
        this.deliveryLogo = imageView2;
        this.rbDeliveryRating = talabatStarRating;
        this.tvDeliveryExperienceRatingTitle = textView;
    }

    @NonNull
    public static FragmentRatingDeliveryBinding bind(@NonNull View view) {
        int i11 = R.id.buttonDeliveryClose;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            PercentageLinearLayout percentageLinearLayout = (PercentageLinearLayout) view;
            i11 = R.id.deliveryLogo;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView2 != null) {
                i11 = R.id.rbDeliveryRating;
                TalabatStarRating talabatStarRating = (TalabatStarRating) ViewBindings.findChildViewById(view, i11);
                if (talabatStarRating != null) {
                    i11 = R.id.tvDeliveryExperienceRatingTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        return new FragmentRatingDeliveryBinding(percentageLinearLayout, imageView, percentageLinearLayout, imageView2, talabatStarRating, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentRatingDeliveryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentRatingDeliveryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rating_delivery, viewGroup, false);
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
