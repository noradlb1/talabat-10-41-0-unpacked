package com.google.ads.mediation.customevent;

import android.view.View;
import androidx.annotation.RecentlyNonNull;

@Deprecated
public interface CustomEventBannerListener extends CustomEventListener {
    void onClick();

    void onReceivedAd(@RecentlyNonNull View view);
}
