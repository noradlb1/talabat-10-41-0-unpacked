package com.google.android.gms.ads.query;

import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class UpdateClickUrlCallback {
    @KeepForSdk
    public void onFailure(@RecentlyNonNull String str) {
    }

    @KeepForSdk
    public void onSuccess(@RecentlyNonNull Uri uri) {
    }
}
