package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ViewServiceFeeBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final LinearLayout serviceFeeClickableArea;
    @NonNull
    public final TextView serviceFeeLabel;
    @NonNull
    public final ImageView serviceFeeTooltipIcon;
    @NonNull
    public final TextView serviceFeeValueText;

    private ViewServiceFeeBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.serviceFeeClickableArea = linearLayout;
        this.serviceFeeLabel = textView;
        this.serviceFeeTooltipIcon = imageView;
        this.serviceFeeValueText = textView2;
    }

    @NonNull
    public static ViewServiceFeeBinding bind(@NonNull View view) {
        int i11 = R.id.service_fee_clickable_area;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.service_fee_clickable_area);
        if (linearLayout != null) {
            i11 = R.id.service_fee_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.service_fee_label);
            if (textView != null) {
                i11 = R.id.service_fee_tooltip_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.service_fee_tooltip_icon);
                if (imageView != null) {
                    i11 = R.id.service_fee_value_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.service_fee_value_text);
                    if (textView2 != null) {
                        return new ViewServiceFeeBinding((RelativeLayout) view, linearLayout, textView, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewServiceFeeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewServiceFeeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_service_fee, viewGroup, false);
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
