package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ViewPickupTooltipBinding implements ViewBinding {
    @NonNull
    public final Button dsIconButtonClose;
    @NonNull
    public final RelativeLayout pickupTooltip;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView tooltipHeader;
    @NonNull
    public final ConstraintLayout tooltipLayout;
    @NonNull
    public final TextView tooltipSubtitle;

    private ViewPickupTooltipBinding(@NonNull RelativeLayout relativeLayout, @NonNull Button button, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.dsIconButtonClose = button;
        this.pickupTooltip = relativeLayout2;
        this.tooltipHeader = textView;
        this.tooltipLayout = constraintLayout;
        this.tooltipSubtitle = textView2;
    }

    @NonNull
    public static ViewPickupTooltipBinding bind(@NonNull View view) {
        int i11 = R.id.dsIconButtonClose;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.dsIconButtonClose);
        if (button != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i11 = R.id.tooltipHeader;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tooltipHeader);
            if (textView != null) {
                i11 = R.id.tooltip_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.tooltip_layout);
                if (constraintLayout != null) {
                    i11 = R.id.tooltipSubtitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tooltipSubtitle);
                    if (textView2 != null) {
                        return new ViewPickupTooltipBinding(relativeLayout, button, relativeLayout, textView, constraintLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewPickupTooltipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewPickupTooltipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_pickup_tooltip, viewGroup, false);
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
