package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto  reason: invalid package */
public final class zzto extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzto zzb;
    private String zzd = "";
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzto zzto = new zzto();
        zzb = zzto;
        zzaha.zzH(zzto.class, zzto);
    }

    private zzto() {
    }

    public static zztn zzb() {
        return (zztn) zzb.zzt();
    }

    public static /* synthetic */ void zzd(zzto zzto, String str) {
        str.getClass();
        zzto.zzd = str;
    }

    public final int zza() {
        return this.zzf;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzto();
        } else {
            if (i12 == 4) {
                return new zztn((zztl) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
