package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class FragmentRateFeedbackBinding implements ViewBinding {
    @NonNull
    public final ImageView btnRatingClose;
    @NonNull
    public final TalabatTextView deliveryTimeTag;
    @NonNull
    public final TextInputEditText editTextReview;
    @NonNull
    public final LinearLayout linearLayoutSuggestionContainer;
    @NonNull
    public final TalabatTextView packingTag;
    @NonNull
    public final TalabatTextView qualityFoodTag;
    @NonNull
    public final LinearLayout reviewSuggestion;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatTextView valueOfMoneyTag;

    private FragmentRateFeedbackBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull TextInputEditText textInputEditText, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView4) {
        this.rootView = relativeLayout;
        this.btnRatingClose = imageView;
        this.deliveryTimeTag = talabatTextView;
        this.editTextReview = textInputEditText;
        this.linearLayoutSuggestionContainer = linearLayout;
        this.packingTag = talabatTextView2;
        this.qualityFoodTag = talabatTextView3;
        this.reviewSuggestion = linearLayout2;
        this.valueOfMoneyTag = talabatTextView4;
    }

    @NonNull
    public static FragmentRateFeedbackBinding bind(@NonNull View view) {
        int i11 = R.id.btn_rating_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_rating_close);
        if (imageView != null) {
            i11 = R.id.deliveryTimeTag;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.deliveryTimeTag);
            if (talabatTextView != null) {
                i11 = R.id.editText_review;
                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.editText_review);
                if (textInputEditText != null) {
                    i11 = R.id.linearLayout_suggestionContainer;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout_suggestionContainer);
                    if (linearLayout != null) {
                        i11 = R.id.packingTag;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.packingTag);
                        if (talabatTextView2 != null) {
                            i11 = R.id.qualityFoodTag;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.qualityFoodTag);
                            if (talabatTextView3 != null) {
                                i11 = R.id.reviewSuggestion;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.reviewSuggestion);
                                if (linearLayout2 != null) {
                                    i11 = R.id.valueOfMoneyTag;
                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.valueOfMoneyTag);
                                    if (talabatTextView4 != null) {
                                        return new FragmentRateFeedbackBinding((RelativeLayout) view, imageView, talabatTextView, textInputEditText, linearLayout, talabatTextView2, talabatTextView3, linearLayout2, talabatTextView4);
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
    public static FragmentRateFeedbackBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentRateFeedbackBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rate_feedback, viewGroup, false);
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
