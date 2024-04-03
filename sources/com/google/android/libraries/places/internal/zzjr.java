package com.google.android.libraries.places.internal;

public final class zzjr extends zzabs<zzjr, zzjp> implements zzada {
    /* access modifiers changed from: private */
    public static final zzjr zzb;
    private int zze;
    private int zzf = 1;
    private zzwh zzg;
    private zzlt zzh;
    private zzzc zzi;
    private zzte zzj;
    private zzpb zzk;
    private zzmm zzl;
    private zzln zzm;
    private zzkt zzn;
    private zzmg zzo;
    private zzqo zzp;
    private zzrc zzq;
    private zzrf zzr;
    private zzkd zzs;
    private zzni zzt;
    private byte zzu = 2;

    static {
        zzjr zzjr = new zzjr();
        zzb = zzjr;
        zzabs.zzG(zzjr.class, zzjr);
    }

    private zzjr() {
    }

    public static zzjp zza() {
        return (zzjp) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzjr zzjr, zzwh zzwh) {
        zzwh.getClass();
        zzjr.zzg = zzwh;
        zzjr.zze |= 2;
    }

    public static /* synthetic */ void zze(zzjr zzjr, int i11) {
        zzjr.zzf = 1;
        zzjr.zze = 1 | zzjr.zze;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzu);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u000f\u0000\u0001\u0001\u0010\u000f\u0000\u0000\u0002\u0001ဌ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000fဉ\r\u0010ဉ\u000e", new Object[]{"zze", "zzf", zzjq.zza, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        } else if (i12 == 3) {
            return new zzjr();
        } else {
            if (i12 == 4) {
                return new zzjp((zzjo) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzu = b11;
            return null;
        }
    }
}
