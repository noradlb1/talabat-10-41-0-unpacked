package com.google.ads.mediation.customevent;

import android.app.Activity;
import androidx.annotation.RecentlyNonNull;
import com.google.ads.mediation.MediationAdRequest;

@Deprecated
public interface CustomEventInterstitial extends CustomEvent {
    void requestInterstitialAd(@RecentlyNonNull CustomEventInterstitialListener customEventInterstitialListener, @RecentlyNonNull Activity activity, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull MediationAdRequest mediationAdRequest, @RecentlyNonNull Object obj);

    void showInterstitial();
}
