package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class OnBoardingCardLearnMoreBinding implements ViewBinding {
    @NonNull
    public final FrameLayout learnMoreCardContainer;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final RecyclerView rvLearnMoreContent;
    @NonNull
    public final TextView tvTitle;

    private OnBoardingCardLearnMoreBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull RecyclerView recyclerView, @NonNull TextView textView) {
        this.rootView = frameLayout;
        this.learnMoreCardContainer = frameLayout2;
        this.rvLearnMoreContent = recyclerView;
        this.tvTitle = textView;
    }

    @NonNull
    public static OnBoardingCardLearnMoreBinding bind(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i11 = R.id.rvLearnMoreContent;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView != null) {
            i11 = R.id.tvTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new OnBoardingCardLearnMoreBinding(frameLayout, frameLayout, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static OnBoardingCardLearnMoreBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OnBoardingCardLearnMoreBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.on_boarding_card_learn_more, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
