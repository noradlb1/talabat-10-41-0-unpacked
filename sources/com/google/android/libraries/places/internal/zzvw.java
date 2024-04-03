package com.google.android.libraries.places.internal;

public final class zzvw extends zzabs<zzvw, zzvt> implements zzada {
    /* access modifiers changed from: private */
    public static final zzvw zzb;
    private int zze;
    private int zzf;
    private int zzg = 1;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private int zzs;
    private int zzt;
    private int zzu;

    static {
        zzvw zzvw = new zzvw();
        zzb = zzvw;
        zzabs.zzG(zzvw.class, zzvw);
    }

    private zzvw() {
    }

    public static zzvt zza() {
        return (zzvt) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzvw zzvw, boolean z11) {
        zzvw.zze |= 4;
        zzvw.zzh = z11;
    }

    public static /* synthetic */ void zze(zzvw zzvw, boolean z11) {
        zzvw.zze |= 8;
        zzvw.zzi = z11;
    }

    public static /* synthetic */ void zzf(zzvw zzvw, boolean z11) {
        zzvw.zze |= 16;
        zzvw.zzj = z11;
    }

    public static /* synthetic */ void zzg(zzvw zzvw, int i11) {
        zzvw.zze |= 32;
        zzvw.zzk = i11;
    }

    public static /* synthetic */ void zzh(zzvw zzvw, int i11) {
        zzvw.zze |= 64;
        zzvw.zzl = i11;
    }

    public static /* synthetic */ void zzi(zzvw zzvw, int i11) {
        zzvw.zze |= 128;
        zzvw.zzm = i11;
    }

    public static /* synthetic */ void zzj(zzvw zzvw, int i11) {
        zzvw.zze |= 256;
        zzvw.zzn = i11;
    }

    public static /* synthetic */ void zzk(zzvw zzvw, int i11) {
        zzvw.zze |= 512;
        zzvw.zzo = i11;
    }

    public static /* synthetic */ void zzl(zzvw zzvw, int i11) {
        zzvw.zze |= 1024;
        zzvw.zzp = i11;
    }

    public static /* synthetic */ void zzm(zzvw zzvw, int i11) {
        zzvw.zze |= 2048;
        zzvw.zzq = i11;
    }

    public static /* synthetic */ void zzn(zzvw zzvw, boolean z11) {
        zzvw.zze |= 4096;
        zzvw.zzr = z11;
    }

    public static /* synthetic */ void zzo(zzvw zzvw, int i11) {
        zzvw.zze |= 8192;
        zzvw.zzs = i11;
    }

    public static /* synthetic */ void zzp(zzvw zzvw, int i11) {
        zzvw.zzf = i11 - 1;
        zzvw.zze |= 1;
    }

    public static /* synthetic */ void zzq(zzvw zzvw, int i11) {
        zzvw.zzg = i11;
        zzvw.zze |= 2;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u0010\u0000\u0001\u0001\u0011\u0010\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဋ\u0005\u0007ဋ\u0006\bဋ\u0007\nဋ\t\u000bဋ\n\fဋ\u000b\rဇ\f\u000eဋ\r\u000fဋ\b\u0010ဋ\u000e\u0011ဌ\u000f", new Object[]{"zze", "zzf", zzvv.zza, "zzg", zzvs.zza, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzo", "zzp", "zzq", "zzr", "zzs", "zzn", "zzt", "zzu", zzvu.zza});
        } else if (i12 == 3) {
            return new zzvw();
        } else {
            if (i12 == 4) {
                return new zzvt((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
