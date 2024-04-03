package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class ViewRedeemAndPayVendorOffersBinding implements ViewBinding {
    @NonNull
    public final TextView redeemAndPayAmountTextView;
    @NonNull
    public final TextView redeemAndPayBrandTitleTextView;
    @NonNull
    public final RecyclerView redeemAndPayOffersRecyclerView;
    @NonNull
    private final LinearLayout rootView;

    private ViewRedeemAndPayVendorOffersBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.redeemAndPayAmountTextView = textView;
        this.redeemAndPayBrandTitleTextView = textView2;
        this.redeemAndPayOffersRecyclerView = recyclerView;
    }

    @NonNull
    public static ViewRedeemAndPayVendorOffersBinding bind(@NonNull View view) {
        int i11 = R.id.redeemAndPayAmountTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.redeemAndPayBrandTitleTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.redeemAndPayOffersRecyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                if (recyclerView != null) {
                    return new ViewRedeemAndPayVendorOffersBinding((LinearLayout) view, textView, textView2, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewRedeemAndPayVendorOffersBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewRedeemAndPayVendorOffersBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_redeem_and_pay_vendor_offers, viewGroup, false);
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
