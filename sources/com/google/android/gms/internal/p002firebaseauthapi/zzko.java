package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzko  reason: invalid package */
public final class zzko extends zzce {
    private final zzlu zza;

    public zzko(zzlu zzlu) {
        this.zza = zzlu;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzko)) {
            return false;
        }
        zzlu zzlu = ((zzko) obj).zza;
        if (!this.zza.zzc().zze().equals(zzlu.zzc().zze()) || !this.zza.zzc().zzg().equals(zzlu.zzc().zzg()) || !this.zza.zzc().zzf().equals(zzlu.zzc().zzf())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        zzlu zzlu = this.zza;
        return Arrays.hashCode(new Object[]{zzlu.zzc(), zzlu.zzd()});
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zzc().zzg();
        zzud zze = this.zza.zzc().zze();
        zzud zzud = zzud.UNKNOWN_PREFIX;
        int ordinal = zze.ordinal();
        if (ordinal == 1) {
            str = "TINK";
        } else if (ordinal == 2) {
            str = "LEGACY";
        } else if (ordinal == 3) {
            str = "RAW";
        } else if (ordinal != 4) {
            str = "UNKNOWN";
        } else {
            str = "CRUNCHY";
        }
        objArr[1] = str;
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public final zzlu zza() {
        return this.zza;
    }
}
