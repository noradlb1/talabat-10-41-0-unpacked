package com.google.android.gms.ads.query;

import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
public abstract class UpdateImpressionUrlsCallback {
    @KeepForSdk
    public void onFailure(@RecentlyNonNull String str) {
    }

    @KeepForSdk
    public void onSuccess(@RecentlyNonNull List<Uri> list) {
    }
}
