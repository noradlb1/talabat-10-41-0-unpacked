package com.talabat.feature.darkstorescarrierbag.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.darkstorescarrierbag.presentation.R;

public final class LayoutOptionSelectedBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView ivImage;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvContinueToCheckout;
    @NonNull
    public final TextView tvOptionSelectedDescription;
    @NonNull
    public final TextView tvOptionSelectedTitle;

    private LayoutOptionSelectedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.ivImage = appCompatImageView;
        this.tvContinueToCheckout = textView;
        this.tvOptionSelectedDescription = textView2;
        this.tvOptionSelectedTitle = textView3;
    }

    @NonNull
    public static LayoutOptionSelectedBinding bind(@NonNull View view) {
        int i11 = R.id.ivImage;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.tvContinueToCheckout;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.tvOptionSelectedDescription;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.tvOptionSelectedTitle;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        return new LayoutOptionSelectedBinding((ConstraintLayout) view, appCompatImageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutOptionSelectedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutOptionSelectedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_option_selected, viewGroup, false);
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
