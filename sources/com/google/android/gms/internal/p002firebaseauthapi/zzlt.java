package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlt  reason: invalid package */
public final class zzlt implements zzlw {
    private final String zza;
    private final zzwf zzb;
    private final zzafv zzc;
    private final zzsw zzd;
    private final zzud zze;
    @Nullable
    private final Integer zzf;

    private zzlt(String str, zzafv zzafv, zzsw zzsw, zzud zzud, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzmg.zzb(str);
        this.zzc = zzafv;
        this.zzd = zzsw;
        this.zze = zzud;
        this.zzf = num;
    }

    public static zzlt zza(String str, zzafv zzafv, zzsw zzsw, zzud zzud, @Nullable Integer num) throws GeneralSecurityException {
        if (zzud == zzud.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzlt(str, zzafv, zzsw, zzud, num);
    }

    public final zzsw zzb() {
        return this.zzd;
    }

    public final zzud zzc() {
        return this.zze;
    }

    public final zzwf zzd() {
        return this.zzb;
    }

    public final zzafv zze() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
