package com.google.android.gms.internal.ads;

public final class zzaip extends zzgkl<zzaip, zzail> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzaip zzb;
    private int zze;
    private String zzf = "";
    private long zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private long zzk;
    private long zzl;
    private String zzm = "";
    private long zzn;
    private String zzo = "";
    private String zzp = "";
    private zzgku<zzain> zzq = zzgkl.zzaE();
    private int zzr;

    static {
        zzaip zzaip = new zzaip();
        zzb = zzaip;
        zzgkl.zzaK(zzaip.class, zzaip);
    }

    private zzaip() {
    }

    public static zzail zza() {
        return (zzail) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzaip zzaip, long j11) {
        zzaip.zze |= 2;
        zzaip.zzg = j11;
    }

    public static /* synthetic */ void zze(zzaip zzaip, String str) {
        str.getClass();
        zzaip.zze |= 4;
        zzaip.zzh = str;
    }

    public static /* synthetic */ void zzf(zzaip zzaip, String str) {
        str.getClass();
        zzaip.zze |= 8;
        zzaip.zzi = str;
    }

    public static /* synthetic */ void zzg(zzaip zzaip, String str) {
        zzaip.zze |= 16;
        zzaip.zzj = str;
    }

    public static /* synthetic */ void zzh(zzaip zzaip, String str) {
        zzaip.zze |= 1024;
        zzaip.zzp = str;
    }

    public static /* synthetic */ void zzi(zzaip zzaip, String str) {
        str.getClass();
        zzaip.zze |= 1;
        zzaip.zzf = str;
    }

    public static /* synthetic */ void zzj(zzaip zzaip, int i11) {
        zzaip.zzr = i11 - 1;
        zzaip.zze |= 2048;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzain.class, "zzr", zzaio.zza});
        } else if (i12 == 3) {
            return new zzaip();
        } else {
            if (i12 == 4) {
                return new zzail((zzaik) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
