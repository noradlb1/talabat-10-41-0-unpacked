package com.google.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.ads.AdRequest;

@Deprecated
public interface MediationBannerListener {
    void onClick(@RecentlyNonNull MediationBannerAdapter<?, ?> mediationBannerAdapter);

    void onDismissScreen(@RecentlyNonNull MediationBannerAdapter<?, ?> mediationBannerAdapter);

    void onFailedToReceiveAd(@RecentlyNonNull MediationBannerAdapter<?, ?> mediationBannerAdapter, @RecentlyNonNull AdRequest.ErrorCode errorCode);

    void onLeaveApplication(@RecentlyNonNull MediationBannerAdapter<?, ?> mediationBannerAdapter);

    void onPresentScreen(@RecentlyNonNull MediationBannerAdapter<?, ?> mediationBannerAdapter);

    void onReceivedAd(@RecentlyNonNull MediationBannerAdapter<?, ?> mediationBannerAdapter);
}
