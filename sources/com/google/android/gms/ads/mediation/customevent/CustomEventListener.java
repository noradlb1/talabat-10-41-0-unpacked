package com.google.android.gms.ads.mediation.customevent;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;

@Deprecated
public interface CustomEventListener {
    void onAdClicked();

    void onAdClosed();

    @Deprecated
    void onAdFailedToLoad(int i11);

    void onAdFailedToLoad(@RecentlyNonNull AdError adError);

    void onAdLeftApplication();

    void onAdOpened();
}
