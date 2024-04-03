package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbjt;
import com.google.android.gms.internal.ads.zzccj;

@KeepForSdk
public class QueryInfo {
    private final zzbjt zza;

    public QueryInfo(zzbjt zzbjt) {
        this.zza = zzbjt;
    }

    @KeepForSdk
    public static void generate(@RecentlyNonNull Context context, @RecentlyNonNull AdFormat adFormat, @Nullable AdRequest adRequest, @RecentlyNonNull QueryInfoGenerationCallback queryInfoGenerationCallback) {
        new zzccj(context, adFormat, adRequest == null ? null : adRequest.zza()).zzb(queryInfoGenerationCallback);
    }

    @RecentlyNonNull
    @KeepForSdk
    public String getQuery() {
        return this.zza.zzb();
    }

    @RecentlyNonNull
    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zza.zza();
    }

    @RecentlyNonNull
    @KeepForSdk
    public String getRequestId() {
        return this.zza.zzd();
    }

    @NonNull
    public final zzbjt zza() {
        return this.zza;
    }
}
