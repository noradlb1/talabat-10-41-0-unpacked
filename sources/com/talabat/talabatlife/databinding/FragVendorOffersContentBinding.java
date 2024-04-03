package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.views.wallet.dsalert.DSAlertView;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.vendorOffers.views.branch.VendorBranchView;

public final class FragVendorOffersContentBinding implements ViewBinding {
    @NonNull
    public final DSAlertView limitWarning;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tLifeVendorListCousinTextView;
    @NonNull
    public final TextView tLifeVendorListTitleTextView;
    @NonNull
    public final TextView vendorOffersBranchCount;
    @NonNull
    public final LinearLayout vendorOffersBranchCountLinearLayout;
    @NonNull
    public final RelativeLayout vendorOffersBranchViews;
    @NonNull
    public final ProgressBar vendorOffersBranchesProgressBar;
    @NonNull
    public final ProgressBar vendorOffersProgressBar;
    @NonNull
    public final RecyclerView vendorOffersRecyclerView;
    @NonNull
    public final VendorBranchView vendorOffersVendorBranchView;

    private FragVendorOffersContentBinding(@NonNull LinearLayout linearLayout, @NonNull DSAlertView dSAlertView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar, @NonNull ProgressBar progressBar2, @NonNull RecyclerView recyclerView, @NonNull VendorBranchView vendorBranchView) {
        this.rootView = linearLayout;
        this.limitWarning = dSAlertView;
        this.tLifeVendorListCousinTextView = textView;
        this.tLifeVendorListTitleTextView = textView2;
        this.vendorOffersBranchCount = textView3;
        this.vendorOffersBranchCountLinearLayout = linearLayout2;
        this.vendorOffersBranchViews = relativeLayout;
        this.vendorOffersBranchesProgressBar = progressBar;
        this.vendorOffersProgressBar = progressBar2;
        this.vendorOffersRecyclerView = recyclerView;
        this.vendorOffersVendorBranchView = vendorBranchView;
    }

    @NonNull
    public static FragVendorOffersContentBinding bind(@NonNull View view) {
        int i11 = R.id.limitWarning;
        DSAlertView dSAlertView = (DSAlertView) ViewBindings.findChildViewById(view, i11);
        if (dSAlertView != null) {
            i11 = R.id.tLifeVendorListCousinTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.tLifeVendorListTitleTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.vendorOffersBranchCount;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        i11 = R.id.vendorOffersBranchCountLinearLayout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                        if (linearLayout != null) {
                            i11 = R.id.vendorOffersBranchViews;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
                            if (relativeLayout != null) {
                                i11 = R.id.vendorOffersBranchesProgressBar;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                                if (progressBar != null) {
                                    i11 = R.id.vendorOffersProgressBar;
                                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                                    if (progressBar2 != null) {
                                        i11 = R.id.vendorOffersRecyclerView;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                                        if (recyclerView != null) {
                                            i11 = R.id.vendorOffersVendorBranchView;
                                            VendorBranchView vendorBranchView = (VendorBranchView) ViewBindings.findChildViewById(view, i11);
                                            if (vendorBranchView != null) {
                                                return new FragVendorOffersContentBinding((LinearLayout) view, dSAlertView, textView, textView2, textView3, linearLayout, relativeLayout, progressBar, progressBar2, recyclerView, vendorBranchView);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragVendorOffersContentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragVendorOffersContentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_vendor_offers_content, viewGroup, false);
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
