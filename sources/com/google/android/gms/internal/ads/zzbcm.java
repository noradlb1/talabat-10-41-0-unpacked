package com.google.android.gms.internal.ads;

public final class zzbcm extends zzgkl<zzbcm, zzbcl> implements zzglw {
    /* access modifiers changed from: private */
    public static final zzbcm zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private int zzh;
    private int zzi = 1000;
    private zzbdw zzj;
    /* access modifiers changed from: private */
    public zzgkt zzk = zzgkl.zzaD();
    private zzbce zzl;
    private zzbch zzm;
    private zzbda zzn;
    private zzbbi zzo;
    private zzbdk zzp;
    private zzber zzq;
    private zzbbr zzr;

    static {
        zzbcm zzbcm = new zzbcm();
        zzb = zzbcm;
        zzgkl.zzaK(zzbcm.class, zzbcm);
    }

    private zzbcm() {
    }

    public static zzbcl zzd() {
        return (zzbcl) zzb.zzat();
    }

    public static /* synthetic */ void zzg(zzbcm zzbcm, String str) {
        str.getClass();
        zzbcm.zze |= 2;
        zzbcm.zzg = str;
    }

    public static /* synthetic */ void zzh(zzbcm zzbcm, Iterable iterable) {
        int i11;
        zzgkt zzgkt = zzbcm.zzk;
        if (!zzgkt.zzc()) {
            int size = zzgkt.size();
            if (size == 0) {
                i11 = 10;
            } else {
                i11 = size + size;
            }
            zzbcm.zzk = zzgkt.zza(i11);
        }
        zzgin.zzap(iterable, zzbcm.zzk);
    }

    public static /* synthetic */ void zzj(zzbcm zzbcm, zzbce zzbce) {
        zzbce.getClass();
        zzbcm.zzl = zzbce;
        zzbcm.zze |= 32;
    }

    public static /* synthetic */ void zzk(zzbcm zzbcm, zzbbi zzbbi) {
        zzbbi.getClass();
        zzbcm.zzo = zzbbi;
        zzbcm.zze |= 256;
    }

    public static /* synthetic */ void zzl(zzbcm zzbcm, zzbdk zzbdk) {
        zzbdk.getClass();
        zzbcm.zzp = zzbdk;
        zzbcm.zze |= 512;
    }

    public static /* synthetic */ void zzm(zzbcm zzbcm, zzber zzber) {
        zzber.getClass();
        zzbcm.zzq = zzber;
        zzbcm.zze |= 1024;
    }

    public static /* synthetic */ void zzn(zzbcm zzbcm, zzbbr zzbbr) {
        zzbbr.getClass();
        zzbcm.zzr = zzbbr;
        zzbcm.zze |= 2048;
    }

    public final zzbbi zza() {
        zzbbi zzbbi = this.zzo;
        return zzbbi == null ? zzbbi.zzc() : zzbbi;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgkl.zzaJ(zzb, "\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\fဌ\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzbcj.zza, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        } else if (i12 == 3) {
            return new zzbcm();
        } else {
            if (i12 == 4) {
                return new zzbcl((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzbce zzc() {
        zzbce zzbce = this.zzl;
        return zzbce == null ? zzbce.zzc() : zzbce;
    }

    public final String zzf() {
        return this.zzg;
    }
}
