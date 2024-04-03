package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsp  reason: invalid package */
public final class zzsp extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzsp zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzss zzf;
    /* access modifiers changed from: private */
    public zzafv zzg = zzafv.zzb;

    static {
        zzsp zzsp = new zzsp();
        zzb = zzsp;
        zzaha.zzH(zzsp.class, zzsp);
    }

    private zzsp() {
    }

    public static zzso zzb() {
        return (zzso) zzb.zzt();
    }

    public static zzsp zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzsp) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public static /* synthetic */ void zzh(zzsp zzsp, zzss zzss) {
        zzss.getClass();
        zzsp.zzf = zzss;
        zzsp.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzss zze() {
        zzss zzss = this.zzf;
        return zzss == null ? zzss.zze() : zzss;
    }

    public final zzafv zzf() {
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
            return new zzsp();
        } else {
            if (i12 == 4) {
                return new zzso((zzsn) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zzk() {
        return (this.zzd & 1) != 0;
    }
}
