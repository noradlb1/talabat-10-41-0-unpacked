package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class ViewVendorBranchBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView vendorBranchAreaTextView;
    @NonNull
    public final TextView vendorBranchCityTextView;
    @NonNull
    public final TextView vendorBranchDistanceTextView;
    @NonNull
    public final TextView vendorBranchLocationTextView;

    private ViewVendorBranchBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = linearLayout;
        this.vendorBranchAreaTextView = textView;
        this.vendorBranchCityTextView = textView2;
        this.vendorBranchDistanceTextView = textView3;
        this.vendorBranchLocationTextView = textView4;
    }

    @NonNull
    public static ViewVendorBranchBinding bind(@NonNull View view) {
        int i11 = R.id.vendorBranchAreaTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.vendorBranchCityTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.vendorBranchDistanceTextView;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView3 != null) {
                    i11 = R.id.vendorBranchLocationTextView;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView4 != null) {
                        return new ViewVendorBranchBinding((LinearLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewVendorBranchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewVendorBranchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_vendor_branch, viewGroup, false);
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
