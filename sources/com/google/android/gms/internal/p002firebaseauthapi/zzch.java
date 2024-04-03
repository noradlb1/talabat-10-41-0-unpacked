package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzch  reason: invalid package */
public final class zzch {
    @Nullable
    private final Object zza;
    @Nullable
    private final Object zzb;
    private final byte[] zzc;
    private final zzud zzd;
    private final int zze;
    private final String zzf;
    private final zzbm zzg;
    private final int zzh;

    public zzch(@Nullable Object obj, @Nullable Object obj2, byte[] bArr, int i11, zzud zzud, int i12, String str, zzbm zzbm) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = Arrays.copyOf(bArr, bArr.length);
        this.zzh = i11;
        this.zzd = zzud;
        this.zze = i12;
        this.zzf = str;
        this.zzg = zzbm;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzbm zzb() {
        return this.zzg;
    }

    public final zzud zzc() {
        return this.zzd;
    }

    @Nullable
    public final Object zzd() {
        return this.zza;
    }

    @Nullable
    public final Object zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzf;
    }

    @Nullable
    public final byte[] zzg() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int zzh() {
        return this.zzh;
    }
}
