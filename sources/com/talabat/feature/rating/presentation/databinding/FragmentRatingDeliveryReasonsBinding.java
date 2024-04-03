package com.talabat.feature.rating.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button.DSPrimaryButton;
import com.talabat.feature.rating.presentation.R;
import com.talabat.talabatcommon.views.TalabatStarRating;

public final class FragmentRatingDeliveryReasonsBinding implements ViewBinding {
    @NonNull
    public final ImageView buttonRatingClose;
    @NonNull
    public final DSPrimaryButton buttonRatingNext;
    @NonNull
    public final ImageView ivDeliveryIcon;
    @NonNull
    public final TalabatStarRating rbReasons;
    @NonNull
    public final RecyclerView reasonRatingList;
    @NonNull
    private final ScrollView rootView;
    @NonNull
    public final TextView tvReasonRatingComment;
    @NonNull
    public final TextView tvReasonRatingMessage;
    @NonNull
    public final TextView tvReasonRatingTitle;

    private FragmentRatingDeliveryReasonsBinding(@NonNull ScrollView scrollView, @NonNull ImageView imageView, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull ImageView imageView2, @NonNull TalabatStarRating talabatStarRating, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = scrollView;
        this.buttonRatingClose = imageView;
        this.buttonRatingNext = dSPrimaryButton;
        this.ivDeliveryIcon = imageView2;
        this.rbReasons = talabatStarRating;
        this.reasonRatingList = recyclerView;
        this.tvReasonRatingComment = textView;
        this.tvReasonRatingMessage = textView2;
        this.tvReasonRatingTitle = textView3;
    }

    @NonNull
    public static FragmentRatingDeliveryReasonsBinding bind(@NonNull View view) {
        int i11 = R.id.buttonRatingClose;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.buttonRatingNext;
            DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
            if (dSPrimaryButton != null) {
                i11 = R.id.ivDeliveryIcon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView2 != null) {
                    i11 = R.id.rbReasons;
                    TalabatStarRating talabatStarRating = (TalabatStarRating) ViewBindings.findChildViewById(view, i11);
                    if (talabatStarRating != null) {
                        i11 = R.id.reasonRatingList;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                        if (recyclerView != null) {
                            i11 = R.id.tvReasonRatingComment;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView != null) {
                                i11 = R.id.tvReasonRatingMessage;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView2 != null) {
                                    i11 = R.id.tvReasonRatingTitle;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView3 != null) {
                                        return new FragmentRatingDeliveryReasonsBinding((ScrollView) view, imageView, dSPrimaryButton, imageView2, talabatStarRating, recyclerView, textView, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentRatingDeliveryReasonsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentRatingDeliveryReasonsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rating_delivery_reasons, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ScrollView getRoot() {
        return this.rootView;
    }
}
