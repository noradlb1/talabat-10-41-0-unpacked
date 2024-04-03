package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztp  reason: invalid package */
public final class zztp extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zztp zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzahf zze = zzaha.zzA();

    static {
        zztp zztp = new zztp();
        zzb = zztp;
        zzaha.zzH(zztp.class, zztp);
    }

    private zztp() {
    }

    public static zztm zza() {
        return (zztm) zzb.zzt();
    }

    public static /* synthetic */ void zze(zztp zztp, zzto zzto) {
        zzto.getClass();
        zzahf zzahf = zztp.zze;
        if (!zzahf.zzc()) {
            zztp.zze = zzaha.zzB(zzahf);
        }
        zztp.zze.add(zzto);
    }

    public final zzto zzb(int i11) {
        return (zzto) this.zze.get(0);
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzto.class});
        } else if (i12 == 3) {
            return new zztp();
        } else {
            if (i12 == 4) {
                return new zztm((zztl) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
