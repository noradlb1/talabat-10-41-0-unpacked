package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import androidx.annotation.RecentlyNonNull;

@Deprecated
public interface CustomEventBannerListener extends CustomEventListener {
    void onAdLoaded(@RecentlyNonNull View view);
}
