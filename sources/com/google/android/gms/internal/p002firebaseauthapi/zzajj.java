package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajj  reason: invalid package */
public final class zzajj extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzajj zzb;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzajj zzajj = new zzajj();
        zzb = zzajj;
        zzaha.zzH(zzajj.class, zzajj);
    }

    private zzajj() {
    }

    public static zzaji zzc() {
        return (zzaji) zzb.zzt();
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return new zzaip(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzajj();
        } else {
            if (i12 == 4) {
                return new zzaji((zzajh) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
