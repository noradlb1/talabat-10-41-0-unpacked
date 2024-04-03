package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;

public abstract class AdListener {
    public void onAdClicked() {
    }

    public void onAdClosed() {
    }

    public void onAdFailedToLoad(@RecentlyNonNull LoadAdError loadAdError) {
    }

    public void onAdImpression() {
    }

    public void onAdLoaded() {
    }

    public void onAdOpened() {
    }
}
