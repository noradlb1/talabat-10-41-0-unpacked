package com.google.android.gms.internal.ads;

public final class zzfjj extends zzgkl<zzfjj, zzfji> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzfjj zzb;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public long zzg;
    /* access modifiers changed from: private */
    public int zzh;
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    /* access modifiers changed from: private */
    public int zzl;
    private int zzm;
    /* access modifiers changed from: private */
    public int zzn;
    /* access modifiers changed from: private */
    public long zzo;
    private int zzp;
    private String zzq = "";
    private String zzr = "";
    private String zzs = "";
    /* access modifiers changed from: private */
    public String zzt = "";
    private String zzu = "";

    static {
        zzfjj zzfjj = new zzfjj();
        zzb = zzfjj;
        zzgkl.zzaK(zzfjj.class, zzfjj);
    }

    private zzfjj() {
    }

    public static zzfji zza() {
        return (zzfji) zzb.zzat();
    }

    public static /* synthetic */ void zzd(zzfjj zzfjj, String str) {
        str.getClass();
        zzfjj.zzi = str;
    }

    public static /* synthetic */ void zze(zzfjj zzfjj, String str) {
        str.getClass();
        zzfjj.zzj = str;
    }

    public static /* synthetic */ void zzf(zzfjj zzfjj, String str) {
        str.getClass();
        zzfjj.zzk = str;
    }

    public static /* synthetic */ void zzj(zzfjj zzfjj, String str) {
        str.getClass();
        zzfjj.zzq = str;
    }

    public static /* synthetic */ void zzk(zzfjj zzfjj, String str) {
        str.getClass();
        zzfjj.zzr = str;
    }

    public static /* synthetic */ void zzl(zzfjj zzfjj, String str) {
        str.getClass();
        zzfjj.zzs = str;
    }

    public static /* synthetic */ void zzo(zzfjj zzfjj, String str) {
        str.getClass();
        zzfjj.zzu = str;
    }

    public static /* synthetic */ void zzr(zzfjj zzfjj, int i11) {
        if (i11 != 1) {
            zzfjj.zzm = i11 - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static /* synthetic */ void zzs(zzfjj zzfjj, int i11) {
        if (i11 != 1) {
            zzfjj.zzp = i11 - 2;
            return;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0000\u0011\u0000\u0000\u0001\u0011\u0011\u0000\u0000\u0000\u0001\f\u0002\u0007\u0003\u0002\u0004\f\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0004\t\f\n\u0004\u000b\u0002\f\f\rȈ\u000eȈ\u000fȈ\u0010Ȉ\u0011Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
        } else if (i12 == 3) {
            return new zzfjj();
        } else {
            if (i12 == 4) {
                return new zzfji((zzfjh) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
