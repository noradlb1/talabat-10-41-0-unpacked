package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

public final class zzbdf extends zzgkl<zzbdf, zzbde> implements zzglw {
    private static final zzgkr<Integer, zzbbu> zzb = new zzbdd();
    /* access modifiers changed from: private */
    public static final zzbdf zze;
    private int zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    private long zzj;
    private zzgkq zzk = zzgkl.zzaB();
    private zzbda zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;

    static {
        zzbdf zzbdf = new zzbdf();
        zze = zzbdf;
        zzgkl.zzaK(zzbdf.class, zzbdf);
    }

    private zzbdf() {
    }

    public static /* synthetic */ void zzA(zzbdf zzbdf, int i11) {
        zzbdf.zzo = i11 - 1;
        zzbdf.zzf |= 128;
    }

    public static /* synthetic */ void zzB(zzbdf zzbdf, int i11) {
        zzbdf.zzq = i11 - 1;
        zzbdf.zzf |= 512;
    }

    public static zzbde zzg() {
        return (zzbde) zze.zzat();
    }

    public static zzbdf zzi(byte[] bArr) throws zzgkx {
        return (zzbdf) zzgkl.zzax(zze, bArr);
    }

    public static /* synthetic */ void zzl(zzbdf zzbdf, long j11) {
        zzbdf.zzf |= 1;
        zzbdf.zzg = j11;
    }

    public static /* synthetic */ void zzm(zzbdf zzbdf, long j11) {
        zzbdf.zzf |= 4;
        zzbdf.zzi = j11;
    }

    public static /* synthetic */ void zzn(zzbdf zzbdf, long j11) {
        zzbdf.zzf |= 8;
        zzbdf.zzj = j11;
    }

    public static /* synthetic */ void zzo(zzbdf zzbdf, Iterable iterable) {
        zzgkq zzgkq = zzbdf.zzk;
        if (!zzgkq.zzc()) {
            zzbdf.zzk = zzgkl.zzaC(zzgkq);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzbdf.zzk.zzh(((zzbbu) it.next()).zza());
        }
    }

    public static /* synthetic */ void zzp(zzbdf zzbdf, zzbda zzbda) {
        zzbda.getClass();
        zzbdf.zzl = zzbda;
        zzbdf.zzf |= 16;
    }

    public static /* synthetic */ void zzq(zzbdf zzbdf, int i11) {
        zzbdf.zzf |= 256;
        zzbdf.zzp = i11;
    }

    public static /* synthetic */ void zzr(zzbdf zzbdf, zzbdj zzbdj) {
        zzbdf.zzr = zzbdj.zza();
        zzbdf.zzf |= 1024;
    }

    public static /* synthetic */ void zzx(zzbdf zzbdf, int i11) {
        zzbdf.zzh = i11 - 1;
        zzbdf.zzf |= 2;
    }

    public static /* synthetic */ void zzy(zzbdf zzbdf, int i11) {
        zzbdf.zzm = i11 - 1;
        zzbdf.zzf |= 32;
    }

    public static /* synthetic */ void zzz(zzbdf zzbdf, int i11) {
        zzbdf.zzn = i11 - 1;
        zzbdf.zzf |= 64;
    }

    public final int zza() {
        return this.zzp;
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgkp zzgkp = zzbcj.zza;
            return zzgkl.zzaJ(zze, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005\u001e\u0006ဉ\u0004\u0007ဌ\u0005\bဌ\u0006\tဌ\u0007\nင\b\u000bဌ\t\fဌ\n", new Object[]{"zzf", "zzg", "zzh", zzgkp, "zzi", "zzj", "zzk", zzbbu.zzc(), "zzl", "zzm", zzgkp, "zzn", zzgkp, "zzo", zzgkp, "zzp", "zzq", zzgkp, "zzr", zzbdj.zzc()});
        } else if (i12 == 3) {
            return new zzbdf();
        } else {
            if (i12 == 4) {
                return new zzbde((zzbbd) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zze;
        }
    }

    public final long zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzi;
    }

    public final long zze() {
        return this.zzg;
    }

    public final zzbda zzf() {
        zzbda zzbda = this.zzl;
        return zzbda == null ? zzbda.zzd() : zzbda;
    }

    public final zzbdj zzj() {
        zzbdj zzb2 = zzbdj.zzb(this.zzr);
        return zzb2 == null ? zzbdj.UNSPECIFIED : zzb2;
    }

    public final List<zzbbu> zzk() {
        return new zzgks(this.zzk, zzb);
    }

    public final int zzs() {
        int zza = zzbck.zza(this.zzn);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzt() {
        int zza = zzbck.zza(this.zzo);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzu() {
        int zza = zzbck.zza(this.zzq);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzv() {
        int zza = zzbck.zza(this.zzh);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzw() {
        int zza = zzbck.zza(this.zzm);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
