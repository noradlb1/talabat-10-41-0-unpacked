package com.google.android.gms.ads.query;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class QueryInfoGenerationCallback {
    @KeepForSdk
    public void onFailure(@RecentlyNonNull String str) {
    }

    @KeepForSdk
    public void onSuccess(@RecentlyNonNull QueryInfo queryInfo) {
    }
}
