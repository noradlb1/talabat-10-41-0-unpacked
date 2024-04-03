package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.AdSize;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MediationBannerAdConfiguration extends MediationAdConfiguration {
    @Nullable
    private final AdSize zza;

    public MediationBannerAdConfiguration(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull Bundle bundle, @RecentlyNonNull Bundle bundle2, boolean z11, @Nullable Location location, int i11, int i12, @RecentlyNonNull String str2, @Nullable AdSize adSize, @RecentlyNonNull String str3) {
        super(context, str, bundle, bundle2, z11, location, i11, i12, str2, str3);
        this.zza = adSize;
    }

    @RecentlyNullable
    public AdSize getAdSize() {
        return this.zza;
    }
}
