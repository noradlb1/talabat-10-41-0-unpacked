package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztj  reason: invalid package */
public final class zztj extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zztj zzb;
    private int zzd;
    private zzsx zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;
    /* access modifiers changed from: private */
    public int zzh;

    static {
        zztj zztj = new zztj();
        zzb = zztj;
        zzaha.zzH(zztj.class, zztj);
    }

    private zztj() {
    }

    public static zzti zzc() {
        return (zzti) zzb.zzt();
    }

    public static /* synthetic */ void zzf(zztj zztj, zzsx zzsx) {
        zzsx.getClass();
        zztj.zze = zzsx;
        zztj.zzd |= 1;
    }

    public final int zza() {
        return this.zzg;
    }

    public final zzsx zzb() {
        zzsx zzsx = this.zze;
        return zzsx == null ? zzsx.zzd() : zzsx;
    }

    public final zzud zze() {
        zzud zzb2 = zzud.zzb(this.zzh);
        return zzb2 == null ? zzud.UNRECOGNIZED : zzb2;
    }

    public final boolean zzi() {
        return (this.zzd & 1) != 0;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zztj();
        } else {
            if (i12 == 4) {
                return new zzti((zztg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzk() {
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
}
