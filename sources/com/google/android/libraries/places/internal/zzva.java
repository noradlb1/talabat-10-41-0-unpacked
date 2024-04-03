package com.google.android.libraries.places.internal;

public final class zzva extends zzabs<zzva, zzuv> implements zzada {
    /* access modifiers changed from: private */
    public static final zzva zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private zzuo zzk;
    private zzuh zzl;
    private zzuc zzm;
    private zzyi zzn;
    private zzuj zzo;
    private zzum zzp;
    private zzyk zzq;
    private zzys zzr;
    private zzyo zzs;
    private int zzt;

    static {
        zzva zzva = new zzva();
        zzb = zzva;
        zzabs.zzG(zzva.class, zzva);
    }

    private zzva() {
    }

    public static zzuv zza() {
        return (zzuv) zzb.zzx();
    }

    public static /* synthetic */ void zzc(zzva zzva, int i11) {
        zzva.zze |= 4;
        zzva.zzh = i11;
    }

    public static /* synthetic */ void zze(zzva zzva, zzuo zzuo) {
        zzuo.getClass();
        zzva.zzk = zzuo;
        zzva.zze |= 32;
    }

    public static /* synthetic */ void zzf(zzva zzva, zzuc zzuc) {
        zzuc.getClass();
        zzva.zzm = zzuc;
        zzva.zze |= 128;
    }

    public static /* synthetic */ void zzg(zzva zzva, zzuj zzuj) {
        zzuj.getClass();
        zzva.zzo = zzuj;
        zzva.zze |= 512;
    }

    public static /* synthetic */ void zzh(zzva zzva, int i11) {
        zzva.zzf = i11 - 1;
        zzva.zze |= 1;
    }

    public static /* synthetic */ void zzi(zzva zzva, int i11) {
        zzva.zzg = i11 - 1;
        zzva.zze |= 2;
    }

    public final Object zzd(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzabs.zzF(zzb, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003င\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000eဉ\r\u000fဌ\u000e", new Object[]{"zze", "zzf", zzux.zza, "zzg", zzuz.zza, "zzh", "zzi", zzuw.zza, "zzj", zzuu.zza, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", zzuy.zza});
        } else if (i12 == 3) {
            return new zzva();
        } else {
            if (i12 == 4) {
                return new zzuv((zztv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
