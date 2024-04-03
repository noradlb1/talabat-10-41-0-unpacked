package com.google.android.gms.ads.formats;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;

public interface ShouldDelayBannerRenderingListener {
    @KeepName
    boolean shouldDelayBannerRendering(@RecentlyNonNull Runnable runnable);
}
