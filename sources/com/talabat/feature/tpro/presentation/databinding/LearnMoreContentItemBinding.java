package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class LearnMoreContentItemBinding implements ViewBinding {
    @NonNull
    public final ImageView ivLeading;
    @NonNull
    public final ConstraintLayout learnMoreItemContainer;
    @NonNull
    public final RelativeLayout rlLeadingContainer;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvLeading;
    @NonNull
    public final TextView tvTrailing;

    private LearnMoreContentItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.ivLeading = imageView;
        this.learnMoreItemContainer = constraintLayout2;
        this.rlLeadingContainer = relativeLayout;
        this.tvLeading = textView;
        this.tvTrailing = textView2;
    }

    @NonNull
    public static LearnMoreContentItemBinding bind(@NonNull View view) {
        int i11 = R.id.ivLeading;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R.id.rlLeadingContainer;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
            if (relativeLayout != null) {
                i11 = R.id.tvLeading;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.tvTrailing;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        return new LearnMoreContentItemBinding(constraintLayout, imageView, constraintLayout, relativeLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LearnMoreContentItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LearnMoreContentItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.learn_more_content_item, viewGroup, false);
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
