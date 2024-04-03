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

public final class ViewSmallOrderFeeBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final LinearLayout smallOrderFeeClickableArea;
    @NonNull
    public final TextView smallOrderFeeDescription;
    @NonNull
    public final View smallOrderFeeDivider;
    @NonNull
    public final TextView smallOrderFeeLabel;
    @NonNull
    public final ImageView smallOrderFeeTooltipIcon;
    @NonNull
    public final TextView smallOrderFeeValueText;

    private ViewSmallOrderFeeBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3) {
        this.rootView = relativeLayout;
        this.smallOrderFeeClickableArea = linearLayout;
        this.smallOrderFeeDescription = textView;
        this.smallOrderFeeDivider = view;
        this.smallOrderFeeLabel = textView2;
        this.smallOrderFeeTooltipIcon = imageView;
        this.smallOrderFeeValueText = textView3;
    }

    @NonNull
    public static ViewSmallOrderFeeBinding bind(@NonNull View view) {
        int i11 = R.id.small_order_fee_clickable_area;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.small_order_fee_clickable_area);
        if (linearLayout != null) {
            i11 = R.id.small_order_fee_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.small_order_fee_description);
            if (textView != null) {
                i11 = R.id.small_order_fee_divider;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.small_order_fee_divider);
                if (findChildViewById != null) {
                    i11 = R.id.small_order_fee_label;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.small_order_fee_label);
                    if (textView2 != null) {
                        i11 = R.id.small_order_fee_tooltip_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.small_order_fee_tooltip_icon);
                        if (imageView != null) {
                            i11 = R.id.small_order_fee_value_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.small_order_fee_value_text);
                            if (textView3 != null) {
                                return new ViewSmallOrderFeeBinding((RelativeLayout) view, linearLayout, textView, findChildViewById, textView2, imageView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewSmallOrderFeeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewSmallOrderFeeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_small_order_fee, viewGroup, false);
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
