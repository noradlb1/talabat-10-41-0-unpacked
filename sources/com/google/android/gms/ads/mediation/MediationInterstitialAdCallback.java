package com.google.android.gms.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;

public interface MediationInterstitialAdCallback extends MediationAdCallback {
    void onAdFailedToShow(@RecentlyNonNull AdError adError);

    @Deprecated
    void onAdFailedToShow(@RecentlyNonNull String str);

    void onAdLeftApplication();
}
