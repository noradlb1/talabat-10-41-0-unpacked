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
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_input_field.DSTextAreaField;
import com.talabat.feature.rating.presentation.PercentageLinearLayout;
import com.talabat.feature.rating.presentation.R;

public final class FragmentRatingCommentBinding implements ViewBinding {
    @NonNull
    public final ImageView arrowBack;
    @NonNull
    public final DSPrimaryButton buttonContinue;
    @NonNull
    public final DSTextAreaField editRatingComment;
    @NonNull
    private final PercentageLinearLayout rootView;
    @NonNull
    public final TextView vendorExperienceRatingTitle;

    private FragmentRatingCommentBinding(@NonNull PercentageLinearLayout percentageLinearLayout, @NonNull ImageView imageView, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull DSTextAreaField dSTextAreaField, @NonNull TextView textView) {
        this.rootView = percentageLinearLayout;
        this.arrowBack = imageView;
        this.buttonContinue = dSPrimaryButton;
        this.editRatingComment = dSTextAreaField;
        this.vendorExperienceRatingTitle = textView;
    }

    @NonNull
    public static FragmentRatingCommentBinding bind(@NonNull View view) {
        int i11 = R.id.arrowBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.buttonContinue;
            DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, i11);
            if (dSPrimaryButton != null) {
                i11 = R.id.editRatingComment;
                DSTextAreaField dSTextAreaField = (DSTextAreaField) ViewBindings.findChildViewById(view, i11);
                if (dSTextAreaField != null) {
                    i11 = R.id.vendorExperienceRatingTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        return new FragmentRatingCommentBinding((PercentageLinearLayout) view, imageView, dSPrimaryButton, dSTextAreaField, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentRatingCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentRatingCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rating_comment, viewGroup, false);
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
