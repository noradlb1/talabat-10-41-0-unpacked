package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzub  reason: invalid package */
public final class zzub extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzub zzb;
    private int zzd;
    private String zze = "";
    private zztc zzf;

    static {
        zzub zzub = new zzub();
        zzb = zzub;
        zzaha.zzH(zzub.class, zzub);
    }

    private zzub() {
    }

    public static zzub zzc() {
        return zzb;
    }

    public static zzub zzd(zzafv zzafv, zzagn zzagn) throws zzahi {
        return (zzub) zzaha.zzx(zzb, zzafv, zzagn);
    }

    public final zztc zza() {
        zztc zztc = this.zzf;
        return zztc == null ? zztc.zzc() : zztc;
    }

    public final String zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return (this.zzd & 1) != 0;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzub();
        } else {
            if (i12 == 4) {
                return new zzua((zztz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
