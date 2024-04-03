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

public final class ViewLoyaltyPointsSummaryBinding implements ViewBinding {
    @NonNull
    public final TextView loyaltySummaryHowItWorksTextView;
    @NonNull
    public final TextView loyaltySummaryPointsExpirationTextView;
    @NonNull
    public final TextView loyaltySummaryTotalPointsTextView;
    @NonNull
    private final LinearLayout rootView;

    private ViewLoyaltyPointsSummaryBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = linearLayout;
        this.loyaltySummaryHowItWorksTextView = textView;
        this.loyaltySummaryPointsExpirationTextView = textView2;
        this.loyaltySummaryTotalPointsTextView = textView3;
    }

    @NonNull
    public static ViewLoyaltyPointsSummaryBinding bind(@NonNull View view) {
        int i11 = R.id.loyaltySummaryHowItWorksTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.loyaltySummaryPointsExpirationTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.loyaltySummaryTotalPointsTextView;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView3 != null) {
                    return new ViewLoyaltyPointsSummaryBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewLoyaltyPointsSummaryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewLoyaltyPointsSummaryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_loyalty_points_summary, viewGroup, false);
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
