package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;

public abstract class AdLoadCallback<AdT> {
    public void onAdFailedToLoad(@RecentlyNonNull LoadAdError loadAdError) {
    }

    public void onAdLoaded(@RecentlyNonNull AdT adt) {
    }
}
