package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzws  reason: invalid package */
public final class zzws {
    private final PhoneMultiFactorInfo zza;
    private final String zzb;
    @Nullable
    private final String zzc;
    private final long zzd;
    private final boolean zze;
    @Nullable
    private final String zzf;
    @Nullable
    private final String zzg;
    private final boolean zzh;

    public zzws(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, @Nullable String str2, long j11, boolean z11, boolean z12, @Nullable String str3, @Nullable String str4, boolean z13) {
        this.zza = phoneMultiFactorInfo;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j11;
        this.zze = z11;
        this.zzf = str3;
        this.zzg = str4;
        this.zzh = z13;
    }

    public final long zza() {
        return this.zzd;
    }

    public final PhoneMultiFactorInfo zzb() {
        return this.zza;
    }

    @Nullable
    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    @Nullable
    public final String zze() {
        return this.zzg;
    }

    @Nullable
    public final String zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zze;
    }

    public final boolean zzh() {
        return this.zzh;
    }
}
