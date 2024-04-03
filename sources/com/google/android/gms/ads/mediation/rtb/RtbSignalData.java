package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

public class RtbSignalData {
    private final Context zza;
    private final List<MediationConfiguration> zzb;
    private final Bundle zzc;
    @Nullable
    private final AdSize zzd;

    public RtbSignalData(@RecentlyNonNull Context context, @RecentlyNonNull List<MediationConfiguration> list, @RecentlyNonNull Bundle bundle, @Nullable AdSize adSize) {
        this.zza = context;
        this.zzb = list;
        this.zzc = bundle;
        this.zzd = adSize;
    }

    @RecentlyNullable
    public AdSize getAdSize() {
        return this.zzd;
    }

    @Deprecated
    @RecentlyNullable
    public MediationConfiguration getConfiguration() {
        List<MediationConfiguration> list = this.zzb;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.zzb.get(0);
    }

    @RecentlyNonNull
    public List<MediationConfiguration> getConfigurations() {
        return this.zzb;
    }

    @RecentlyNonNull
    public Context getContext() {
        return this.zza;
    }

    @RecentlyNonNull
    public Bundle getNetworkExtras() {
        return this.zzc;
    }
}
