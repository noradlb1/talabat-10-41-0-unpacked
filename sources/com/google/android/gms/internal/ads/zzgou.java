package com.google.android.gms.internal.ads;

public final class zzgou extends zzgkl<zzgou, zzgot> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzgou zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private zzgoh zzh;
    private zzgol zzi;
    private int zzj;
    private zzgkq zzk = zzgkl.zzaB();
    private String zzl = "";
    private int zzm;
    private zzgku<String> zzn = zzgkl.zzaE();
    private byte zzo = 2;

    static {
        zzgou zzgou = new zzgou();
        zzb = zzgou;
        zzgkl.zzaK(zzgou.class, zzgou);
    }

    private zzgou() {
    }

    public static zzgot zzc() {
        return (zzgot) zzb.zzat();
    }

    public static /* synthetic */ void zzf(zzgou zzgou, int i11) {
        zzgou.zze |= 1;
        zzgou.zzf = i11;
    }

    public static /* synthetic */ void zzg(zzgou zzgou, String str) {
        str.getClass();
        zzgou.zze |= 2;
        zzgou.zzg = str;
    }

    public static /* synthetic */ void zzh(zzgou zzgou, zzgoh zzgoh) {
        zzgoh.getClass();
        zzgou.zzh = zzgoh;
        zzgou.zze |= 4;
    }

    public static /* synthetic */ void zzi(zzgou zzgou, String str) {
        str.getClass();
        zzgku<String> zzgku = zzgou.zzn;
        if (!zzgku.zzc()) {
            zzgou.zzn = zzgkl.zzaF(zzgku);
        }
        zzgou.zzn.add(str);
    }

    public static /* synthetic */ void zzj(zzgou zzgou, int i11) {
        zzgou.zzm = i11 - 1;
        zzgou.zze |= 64;
    }

    public final int zza() {
        return this.zzn.size();
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzo);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzgor.zza, "zzn"});
        } else if (i12 == 3) {
            return new zzgou();
        } else {
            if (i12 == 4) {
                return new zzgot((zzgnx) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzo = b11;
            return null;
        }
    }

    public final String zze() {
        return this.zzg;
    }
}
