package com.google.android.gms.ads.mediation;

import androidx.annotation.RecentlyNonNull;

public interface InitializationCompleteCallback {
    void onInitializationFailed(@RecentlyNonNull String str);

    void onInitializationSucceeded();
}
