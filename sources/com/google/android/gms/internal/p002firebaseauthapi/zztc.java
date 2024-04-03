package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztc  reason: invalid package */
public final class zztc extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zztc zzb;
    private String zzd = "";
    /* access modifiers changed from: private */
    public zzafv zze = zzafv.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zztc zztc = new zztc();
        zzb = zztc;
        zzaha.zzH(zztc.class, zztc);
    }

    private zztc() {
    }

    public static zztb zza() {
        return (zztb) zzb.zzt();
    }

    public static zztc zzc() {
        return zzb;
    }

    public static zztc zzd(byte[] bArr, zzagn zzagn) throws zzahi {
        return (zztc) zzaha.zzz(zzb, bArr, zzagn);
    }

    public static /* synthetic */ void zzh(zztc zztc, String str) {
        str.getClass();
        zztc.zzd = str;
    }

    public final zzud zze() {
        zzud zzb2 = zzud.zzb(this.zzf);
        return zzb2 == null ? zzud.UNRECOGNIZED : zzb2;
    }

    public final zzafv zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zztc();
        } else {
            if (i12 == 4) {
                return new zztb((zzta) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
