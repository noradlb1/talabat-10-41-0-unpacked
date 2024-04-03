package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.campaign.CampaignView;

public final class DarkstoresItemHomeDeliveryCampaignBinding implements ViewBinding {
    @NonNull
    public final CampaignView campaignView;
    @NonNull
    public final AppCompatTextView deliveryCampaignInfo;
    @NonNull
    public final LinearLayout deliveryCampaignRow;
    @NonNull
    public final LinearLayout deliveryCampaignRowContainer;
    @NonNull
    public final AppCompatImageView parallelBinImage;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresItemHomeDeliveryCampaignBinding(@NonNull LinearLayout linearLayout, @NonNull CampaignView campaignView2, @NonNull AppCompatTextView appCompatTextView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull AppCompatImageView appCompatImageView) {
        this.rootView = linearLayout;
        this.campaignView = campaignView2;
        this.deliveryCampaignInfo = appCompatTextView;
        this.deliveryCampaignRow = linearLayout2;
        this.deliveryCampaignRowContainer = linearLayout3;
        this.parallelBinImage = appCompatImageView;
    }

    @NonNull
    public static DarkstoresItemHomeDeliveryCampaignBinding bind(@NonNull View view) {
        int i11 = R.id.campaign_view;
        CampaignView campaignView2 = (CampaignView) ViewBindings.findChildViewById(view, i11);
        if (campaignView2 != null) {
            i11 = R.id.delivery_campaign_info;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
            if (appCompatTextView != null) {
                i11 = R.id.delivery_campaign_row;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                if (linearLayout != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view;
                    i11 = R.id.parallel_bin_image;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                    if (appCompatImageView != null) {
                        return new DarkstoresItemHomeDeliveryCampaignBinding(linearLayout2, campaignView2, appCompatTextView, linearLayout, linearLayout2, appCompatImageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemHomeDeliveryCampaignBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomeDeliveryCampaignBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_delivery_campaign, viewGroup, false);
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
