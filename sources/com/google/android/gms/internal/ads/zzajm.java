package com.google.android.gms.internal.ads;

public final class zzajm extends zzgkl<zzajm, zzajl> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzajm zzb;
    private int zze;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private int zzl = 1000;
    private long zzm = -1;
    private long zzn = -1;
    private long zzo = -1;
    private int zzp = 1000;
    private long zzq = -1;
    private long zzr = -1;
    private long zzs = -1;
    private long zzt = -1;
    private long zzu;
    private long zzv;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;
    private long zzz = -1;

    static {
        zzajm zzajm = new zzajm();
        zzb = zzajm;
        zzgkl.zzaK(zzajm.class, zzajm);
    }

    private zzajm() {
    }

    public static zzajl zza() {
        return (zzajl) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzajm zzajm, long j11) {
        zzajm.zze |= 1;
        zzajm.zzf = j11;
    }

    public static /* synthetic */ void zze(zzajm zzajm, long j11) {
        zzajm.zze |= 2;
        zzajm.zzg = j11;
    }

    public static /* synthetic */ void zzf(zzajm zzajm, long j11) {
        zzajm.zze |= 4;
        zzajm.zzh = j11;
    }

    public static /* synthetic */ void zzg(zzajm zzajm, long j11) {
        zzajm.zze |= 8;
        zzajm.zzi = j11;
    }

    public static /* synthetic */ void zzh(zzajm zzajm) {
        zzajm.zze &= -9;
        zzajm.zzi = -1;
    }

    public static /* synthetic */ void zzi(zzajm zzajm, long j11) {
        zzajm.zze |= 16;
        zzajm.zzj = j11;
    }

    public static /* synthetic */ void zzj(zzajm zzajm, long j11) {
        zzajm.zze |= 32;
        zzajm.zzk = j11;
    }

    public static /* synthetic */ void zzk(zzajm zzajm, long j11) {
        zzajm.zze |= 128;
        zzajm.zzm = j11;
    }

    public static /* synthetic */ void zzl(zzajm zzajm, long j11) {
        zzajm.zze |= 256;
        zzajm.zzn = j11;
    }

    public static /* synthetic */ void zzm(zzajm zzajm, long j11) {
        zzajm.zze |= 512;
        zzajm.zzo = j11;
    }

    public static /* synthetic */ void zzn(zzajm zzajm, long j11) {
        zzajm.zze |= 2048;
        zzajm.zzq = j11;
    }

    public static /* synthetic */ void zzo(zzajm zzajm, long j11) {
        zzajm.zze |= 4096;
        zzajm.zzr = j11;
    }

    public static /* synthetic */ void zzp(zzajm zzajm, long j11) {
        zzajm.zze |= 8192;
        zzajm.zzs = j11;
    }

    public static /* synthetic */ void zzq(zzajm zzajm, long j11) {
        zzajm.zze |= 16384;
        zzajm.zzt = j11;
    }

    public static /* synthetic */ void zzr(zzajm zzajm, long j11) {
        zzajm.zze |= 32768;
        zzajm.zzu = j11;
    }

    public static /* synthetic */ void zzs(zzajm zzajm, long j11) {
        zzajm.zze |= 65536;
        zzajm.zzv = j11;
    }

    public static /* synthetic */ void zzt(zzajm zzajm, long j11) {
        zzajm.zze |= 131072;
        zzajm.zzw = j11;
    }

    public static /* synthetic */ void zzu(zzajm zzajm, long j11) {
        zzajm.zze |= 262144;
        zzajm.zzx = j11;
    }

    public static /* synthetic */ void zzv(zzajm zzajm, int i11) {
        zzajm.zzl = i11 - 1;
        zzajm.zze |= 64;
    }

    public static /* synthetic */ void zzw(zzajm zzajm, int i11) {
        zzajm.zzp = i11 - 1;
        zzajm.zze |= 1024;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgkp zzgkp = zzajv.zza;
            return zzgkl.zzaJ(zzb, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzgkp, "zzm", "zzn", "zzo", "zzp", zzgkp, "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz"});
        } else if (i12 == 3) {
            return new zzajm();
        } else {
            if (i12 == 4) {
                return new zzajl((zzaiy) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
