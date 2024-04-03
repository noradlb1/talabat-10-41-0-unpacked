package com.google.android.gms.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;

@Deprecated
public interface MediationBannerListener {
    void onAdClicked(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter);

    void onAdClosed(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter);

    @Deprecated
    void onAdFailedToLoad(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter, int i11);

    void onAdFailedToLoad(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter, @RecentlyNonNull AdError adError);

    void onAdLeftApplication(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter);

    void onAdLoaded(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter);

    void onAdOpened(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter);

    void zzd(@RecentlyNonNull MediationBannerAdapter mediationBannerAdapter, @RecentlyNonNull String str, @RecentlyNonNull String str2);
}
