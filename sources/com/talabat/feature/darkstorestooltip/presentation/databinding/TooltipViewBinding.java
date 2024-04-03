package com.talabat.feature.darkstorestooltip.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.darkstorestooltip.presentation.R;

public final class TooltipViewBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView arrowTop;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tooltipText;

    private TooltipViewBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.arrowTop = appCompatImageView;
        this.tooltipText = textView;
    }

    @NonNull
    public static TooltipViewBinding bind(@NonNull View view) {
        int i11 = R.id.arrowTop;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.tooltipText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new TooltipViewBinding((LinearLayout) view, appCompatImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TooltipViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TooltipViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.tooltip_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
