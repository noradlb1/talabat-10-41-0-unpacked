package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.growth.R;

public final class ViewCouponCodeBinding implements ViewBinding {
    @NonNull
    public final TextView couponCodeTextView;
    @NonNull
    public final TextView couponTitleTextView;
    @NonNull
    private final LinearLayout rootView;

    private ViewCouponCodeBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.couponCodeTextView = textView;
        this.couponTitleTextView = textView2;
    }

    @NonNull
    public static ViewCouponCodeBinding bind(@NonNull View view) {
        int i11 = R.id.couponCodeTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.couponTitleTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                return new ViewCouponCodeBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewCouponCodeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewCouponCodeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_coupon_code, viewGroup, false);
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
