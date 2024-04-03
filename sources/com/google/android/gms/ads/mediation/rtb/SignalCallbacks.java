package com.google.android.gms.ads.mediation.rtb;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface SignalCallbacks {
    void onFailure(@RecentlyNonNull AdError adError);

    @Deprecated
    void onFailure(@RecentlyNonNull String str);

    void onSuccess(@RecentlyNonNull String str);
}
