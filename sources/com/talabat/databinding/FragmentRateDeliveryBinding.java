package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatSmileyRating;
import com.talabat.talabatcommon.views.TalabatStarRating;

public final class FragmentRateDeliveryBinding implements ViewBinding {
    @NonNull
    public final ImageView btnRatingClose;
    @NonNull
    public final TalabatTextView deliveryExperienceRatingTitleTv;
    @NonNull
    public final TalabatSmileyRating ratingSmiley;
    @NonNull
    public final TalabatStarRating ratingStar;
    @NonNull
    public final LinearLayout reasonsContainer;
    @NonNull
    public final RecyclerView reasonsRecyclerView;
    @NonNull
    private final RelativeLayout rootView;

    private FragmentRateDeliveryBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatSmileyRating talabatSmileyRating, @NonNull TalabatStarRating talabatStarRating, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.btnRatingClose = imageView;
        this.deliveryExperienceRatingTitleTv = talabatTextView;
        this.ratingSmiley = talabatSmileyRating;
        this.ratingStar = talabatStarRating;
        this.reasonsContainer = linearLayout;
        this.reasonsRecyclerView = recyclerView;
    }

    @NonNull
    public static FragmentRateDeliveryBinding bind(@NonNull View view) {
        int i11 = R.id.btn_rating_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_rating_close);
        if (imageView != null) {
            i11 = R.id.deliveryExperienceRatingTitleTv;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.deliveryExperienceRatingTitleTv);
            if (talabatTextView != null) {
                i11 = R.id.rating_smiley;
                TalabatSmileyRating talabatSmileyRating = (TalabatSmileyRating) ViewBindings.findChildViewById(view, R.id.rating_smiley);
                if (talabatSmileyRating != null) {
                    i11 = R.id.rating_star;
                    TalabatStarRating talabatStarRating = (TalabatStarRating) ViewBindings.findChildViewById(view, R.id.rating_star);
                    if (talabatStarRating != null) {
                        i11 = R.id.reasonsContainer;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.reasonsContainer);
                        if (linearLayout != null) {
                            i11 = R.id.reasonsRecyclerView;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.reasonsRecyclerView);
                            if (recyclerView != null) {
                                return new FragmentRateDeliveryBinding((RelativeLayout) view, imageView, talabatTextView, talabatSmileyRating, talabatStarRating, linearLayout, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentRateDeliveryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentRateDeliveryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rate_delivery, viewGroup, false);
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
