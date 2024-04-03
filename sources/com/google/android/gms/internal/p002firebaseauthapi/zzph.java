package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzph  reason: invalid package */
public final class zzph extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzph zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzpn zzf;
    /* access modifiers changed from: private */
    public zzafv zzg = zzafv.zzb;

    static {
        zzph zzph = new zzph();
        zzb = zzph;
        zzaha.zzH(zzph.class, zzph);
    }

    private zzph() {
    }

    public static zzpg zzb() {
        return (zzpg) zzb.zzt();
    }

    public static zzph zzd() {
        return zzb;
    }

    public static zzph zze(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzph) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzi(zzph zzph, zzpn zzpn) {
        zzpn.getClass();
        zzph.zzf = zzpn;
        zzph.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzpn zzf() {
        zzpn zzpn = this.zzf;
        return zzpn == null ? zzpn.zzd() : zzpn;
    }

    public final zzafv zzg() {
        return this.zzg;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzph();
        } else {
            if (i12 == 4) {
                return new zzpg((zzpf) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
