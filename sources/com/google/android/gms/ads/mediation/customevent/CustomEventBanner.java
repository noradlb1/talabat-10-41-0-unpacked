package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;

@Deprecated
public interface CustomEventBanner extends CustomEvent {
    void requestBannerAd(@RecentlyNonNull Context context, @RecentlyNonNull CustomEventBannerListener customEventBannerListener, @Nullable String str, @RecentlyNonNull AdSize adSize, @RecentlyNonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle);
}
