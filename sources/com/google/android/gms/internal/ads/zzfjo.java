package com.google.android.gms.internal.ads;

public final class zzfjo extends zzgkl<zzfjo, zzfjl> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzfjo zzb;
    /* access modifiers changed from: private */
    public zzgku<zzfjn> zze = zzgkl.zzaE();

    static {
        zzfjo zzfjo = new zzfjo();
        zzb = zzfjo;
        zzgkl.zzaK(zzfjo.class, zzfjo);
    }

    private zzfjo() {
    }

    public static zzfjl zzc() {
        return (zzfjl) zzb.zzat();
    }

    public static /* synthetic */ void zzf(zzfjo zzfjo, zzfjn zzfjn) {
        zzfjn.getClass();
        zzgku<zzfjn> zzgku = zzfjo.zze;
        if (!zzgku.zzc()) {
            zzfjo.zze = zzgkl.zzaF(zzgku);
        }
        zzfjo.zze.add(zzfjn);
    }

    public final int zza() {
        return this.zze.size();
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzfjn.class});
        } else if (i12 == 3) {
            return new zzfjo();
        } else {
            if (i12 == 4) {
                return new zzfjl((zzfjk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
