package com.google.ads.mediation;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;

@Deprecated
@Keep
public final class AdUrlAdapter extends AbstractAdViewAdapter implements MediationInterstitialAdapter {
    private static final String AD_URL_AD_UNIT_ID = "adurl";

    @RecentlyNonNull
    public Bundle buildExtrasBundle(@RecentlyNonNull Bundle bundle, @RecentlyNonNull Bundle bundle2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBundle("sdk_less_server_data", bundle2);
        bundle.putBoolean("_noRefresh", true);
        return bundle;
    }

    @RecentlyNonNull
    public String getAdUnitId(@RecentlyNonNull Bundle bundle) {
        return AD_URL_AD_UNIT_ID;
    }
}
