package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdSize;

@Deprecated
public interface MediationBannerAdapter extends MediationAdapter {
    @RecentlyNonNull
    View getBannerView();

    void requestBannerAd(@RecentlyNonNull Context context, @RecentlyNonNull MediationBannerListener mediationBannerListener, @RecentlyNonNull Bundle bundle, @RecentlyNonNull AdSize adSize, @RecentlyNonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2);
}
