package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

@Deprecated
public interface MediationInterstitialAdapter extends MediationAdapter {
    void requestInterstitialAd(@RecentlyNonNull Context context, @RecentlyNonNull MediationInterstitialListener mediationInterstitialListener, @RecentlyNonNull Bundle bundle, @RecentlyNonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2);

    void showInterstitial();
}
