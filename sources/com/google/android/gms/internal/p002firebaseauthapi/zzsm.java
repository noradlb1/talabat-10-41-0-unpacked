package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsm  reason: invalid package */
public final class zzsm extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzsm zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzsm zzsm = new zzsm();
        zzb = zzsm;
        zzaha.zzH(zzsm.class, zzsm);
    }

    private zzsm() {
    }

    public static zzsl zza() {
        return (zzsl) zzb.zzt();
    }

    public static zzsm zzc() {
        return zzb;
    }

    public final int zzd() {
        int i11 = this.zzf;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 1 ? i11 != 2 ? i11 != 3 ? 0 : 5 : 4 : 3;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public final int zze() {
        int i11 = this.zze;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 1 ? i11 != 2 ? i11 != 3 ? 0 : 5 : 4 : 3;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public final int zzf() {
        int i11 = this.zzd;
        int i12 = 2;
        if (i11 != 0) {
            i12 = i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? 0 : 6 : 5 : 4 : 3;
        }
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzsm();
        } else {
            if (i12 == 4) {
                return new zzsl((zzsk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
