package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class zzbxz implements MediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set<String> zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final boolean zzg;
    private final String zzh;

    public zzbxz(@Nullable Date date, int i11, @Nullable Set<String> set, @Nullable Location location, boolean z11, int i12, boolean z12, int i13, String str) {
        this.zza = date;
        this.zzb = i11;
        this.zzc = set;
        this.zze = location;
        this.zzd = z11;
        this.zzf = i12;
        this.zzg = z12;
        this.zzh = str;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzg;
    }

    public final boolean isTesting() {
        return this.zzd;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }
}
