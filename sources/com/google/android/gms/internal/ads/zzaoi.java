package com.google.android.gms.internal.ads;

public final class zzaoi extends zzgkl<zzaoi, zzaoh> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzaoi zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private long zzi;
    private long zzj;

    static {
        zzaoi zzaoi = new zzaoi();
        zzb = zzaoi;
        zzgkl.zzaK(zzaoi.class, zzaoi);
    }

    private zzaoi() {
    }

    public static zzaoh zze() {
        return (zzaoh) zzb.zzat();
    }

    public static zzaoi zzg() {
        return zzb;
    }

    public static zzaoi zzh(zzgjf zzgjf) throws zzgkx {
        return (zzaoi) zzgkl.zzaw(zzb, zzgjf);
    }

    public static zzaoi zzi(zzgjf zzgjf, zzgjx zzgjx) throws zzgkx {
        return (zzaoi) zzgkl.zzay(zzb, zzgjf, zzgjx);
    }

    public static /* synthetic */ void zzl(zzaoi zzaoi, String str) {
        str.getClass();
        zzaoi.zze |= 1;
        zzaoi.zzf = str;
    }

    public static /* synthetic */ void zzm(zzaoi zzaoi, long j11) {
        zzaoi.zze |= 16;
        zzaoi.zzj = j11;
    }

    public static /* synthetic */ void zzn(zzaoi zzaoi, String str) {
        str.getClass();
        zzaoi.zze |= 2;
        zzaoi.zzg = str;
    }

    public static /* synthetic */ void zzo(zzaoi zzaoi, long j11) {
        zzaoi.zze |= 4;
        zzaoi.zzh = j11;
    }

    public static /* synthetic */ void zzp(zzaoi zzaoi, long j11) {
        zzaoi.zze |= 8;
        zzaoi.zzi = j11;
    }

    public final long zza() {
        return this.zzi;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i12 == 3) {
            return new zzaoi();
        } else {
            if (i12 == 4) {
                return new zzaoh((zzaog) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final long zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zzj;
    }

    public final String zzj() {
        return this.zzg;
    }

    public final String zzk() {
        return this.zzf;
    }
}
