package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

final class zzhu {
    public final zzpy zza;
    public final Object zzb;
    public final zzrn[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzhv zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzim[] zzi;
    private final zzsv zzj;
    private final zzie zzk;
    @Nullable
    private zzhu zzl;
    private zzch zzm = zzch.zza;
    private zzsw zzn;
    private long zzo;

    public zzhu(zzim[] zzimArr, long j11, zzsv zzsv, zztk zztk, zzie zzie, zzhv zzhv, zzsw zzsw, byte[] bArr) {
        zzhv zzhv2 = zzhv;
        this.zzi = zzimArr;
        this.zzo = j11;
        this.zzj = zzsv;
        this.zzk = zzie;
        zzpz zzpz = zzhv2.zza;
        this.zzb = zzpz.zza;
        this.zzf = zzhv2;
        this.zzn = zzsw;
        this.zzc = new zzrn[2];
        this.zzh = new boolean[2];
        long j12 = zzhv2.zzb;
        long j13 = zzhv2.zzd;
        zztk zztk2 = zztk;
        zzpy zzo2 = zzie.zzo(zzpz, zztk, j12);
        this.zza = j13 != C.TIME_UNSET ? new zzpg(zzo2, true, 0, j13) : zzo2;
    }

    private final void zzs() {
        if (zzu()) {
            int i11 = 0;
            while (true) {
                zzsw zzsw = this.zzn;
                if (i11 < zzsw.zza) {
                    zzsw.zzb(i11);
                    zzsb zzsb = this.zzn.zze[i11];
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzt() {
        if (zzu()) {
            int i11 = 0;
            while (true) {
                zzsw zzsw = this.zzn;
                if (i11 < zzsw.zza) {
                    zzsw.zzb(i11);
                    zzsb zzsb = this.zzn.zze[i11];
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzsw zzsw, long j11, boolean z11) {
        return zzb(zzsw, j11, false, new boolean[2]);
    }

    public final long zzb(zzsw zzsw, long j11, boolean z11, boolean[] zArr) {
        boolean z12;
        zzsw zzsw2 = zzsw;
        int i11 = 0;
        while (true) {
            boolean z13 = true;
            if (i11 >= zzsw2.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z11 || !zzsw.zza(this.zzn, i11)) {
                z13 = false;
            }
            zArr2[i11] = z13;
            i11++;
        }
        int i12 = 0;
        while (true) {
            zzim[] zzimArr = this.zzi;
            if (i12 >= 2) {
                break;
            }
            zzimArr[i12].zzb();
            i12++;
        }
        zzs();
        this.zzn = zzsw2;
        zzt();
        long zzq = this.zza.zzq(zzsw2.zze, this.zzh, this.zzc, zArr, j11);
        int i13 = 0;
        while (true) {
            zzim[] zzimArr2 = this.zzi;
            if (i13 >= 2) {
                break;
            }
            zzimArr2[i13].zzb();
            i13++;
        }
        this.zze = false;
        int i14 = 0;
        while (true) {
            zzrn[] zzrnArr = this.zzc;
            if (i14 >= 2) {
                return zzq;
            }
            if (zzrnArr[i14] != null) {
                zzdy.zzf(zzsw.zzb(i14));
                this.zzi[i14].zzb();
                this.zze = true;
            } else {
                if (zzsw2.zze[i14] == null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zzdy.zzf(z12);
            }
            i14++;
        }
    }

    public final long zzc() {
        long j11;
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        if (this.zze) {
            j11 = this.zza.zzb();
        } else {
            j11 = Long.MIN_VALUE;
        }
        if (j11 == Long.MIN_VALUE) {
            return this.zzf.zze;
        }
        return j11;
    }

    public final long zzd() {
        if (!this.zzd) {
            return 0;
        }
        return this.zza.zzc();
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzch zzg() {
        return this.zzm;
    }

    @Nullable
    public final zzhu zzh() {
        return this.zzl;
    }

    public final zzsw zzi() {
        return this.zzn;
    }

    public final zzsw zzj(float f11, zzcd zzcd) throws zzgg {
        zzsw zzi2 = this.zzj.zzi(this.zzi, this.zzm, this.zzf.zza, zzcd);
        for (zzsb zzsb : zzi2.zze) {
        }
        return zzi2;
    }

    public final void zzk(long j11) {
        zzdy.zzf(zzu());
        this.zza.zzn(j11 - this.zzo);
    }

    public final void zzl(float f11, zzcd zzcd) throws zzgg {
        this.zzd = true;
        this.zzm = this.zza.zzf();
        zzsw zzj2 = zzj(f11, zzcd);
        zzhv zzhv = this.zzf;
        long j11 = zzhv.zzb;
        long j12 = zzhv.zze;
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            j11 = Math.max(0, j12 - 1);
        }
        long zza2 = zza(zzj2, j11, false);
        long j13 = this.zzo;
        zzhv zzhv2 = this.zzf;
        this.zzo = j13 + (zzhv2.zzb - zza2);
        this.zzf = zzhv2.zzb(zza2);
    }

    public final void zzm(long j11) {
        zzdy.zzf(zzu());
        if (this.zzd) {
            this.zza.zzl(j11 - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzie zzie = this.zzk;
        zzpy zzpy = this.zza;
        try {
            if (zzpy instanceof zzpg) {
                zzie.zzh(((zzpg) zzpy).zza);
            } else {
                zzie.zzh(zzpy);
            }
        } catch (RuntimeException e11) {
            zzep.zza("MediaPeriodHolder", "Period release failed.", e11);
        }
    }

    public final void zzo(@Nullable zzhu zzhu) {
        if (zzhu != this.zzl) {
            zzs();
            this.zzl = zzhu;
            zzt();
        }
    }

    public final void zzp(long j11) {
        this.zzo = 0;
    }

    public final void zzq() {
        zzpy zzpy = this.zza;
        if (zzpy instanceof zzpg) {
            long j11 = this.zzf.zzd;
            if (j11 == C.TIME_UNSET) {
                j11 = Long.MIN_VALUE;
            }
            ((zzpg) zzpy).zzm(0, j11);
        }
    }

    public final boolean zzr() {
        if (!this.zzd) {
            return false;
        }
        if (this.zze) {
            return this.zza.zzb() == Long.MIN_VALUE;
        }
        return true;
    }
}
