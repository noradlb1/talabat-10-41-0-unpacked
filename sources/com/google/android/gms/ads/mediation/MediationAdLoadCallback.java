package com.google.android.gms.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface MediationAdLoadCallback<MediationAdT, MediationAdCallbackT> {
    void onFailure(@RecentlyNonNull AdError adError);

    @Deprecated
    void onFailure(@RecentlyNonNull String str);

    @RecentlyNonNull
    MediationAdCallbackT onSuccess(@RecentlyNonNull MediationAdT mediationadt);
}
