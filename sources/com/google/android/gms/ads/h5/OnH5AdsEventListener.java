package com.google.android.gms.ads.h5;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 21)
public interface OnH5AdsEventListener {
    void onH5AdsEvent(@RecentlyNonNull String str);
}
