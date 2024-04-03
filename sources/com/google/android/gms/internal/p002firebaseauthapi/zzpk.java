package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpk  reason: invalid package */
public final class zzpk extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzpk zzb;
    private int zzd;
    private zzpn zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzpk zzpk = new zzpk();
        zzb = zzpk;
        zzaha.zzH(zzpk.class, zzpk);
    }

    private zzpk() {
    }

    public static zzpj zzb() {
        return (zzpj) zzb.zzt();
    }

    public static zzpk zzd() {
        return zzb;
    }

    public static zzpk zze(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzpk) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzg(zzpk zzpk, zzpn zzpn) {
        zzpn.getClass();
        zzpk.zze = zzpn;
        zzpk.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzpn zzf() {
        zzpn zzpn = this.zze;
        return zzpn == null ? zzpn.zzd() : zzpn;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzpk();
        } else {
            if (i12 == 4) {
                return new zzpj((zzpi) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
