package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

public abstract class zzfx implements zzil, zzim {
    private final int zza;
    private final zzhr zzb = new zzhr();
    @Nullable
    private zzin zzc;
    private int zzd;
    private int zze;
    @Nullable
    private zzrn zzf;
    @Nullable
    private zzab[] zzg;
    private long zzh;
    private long zzi = Long.MIN_VALUE;
    private boolean zzj;
    private boolean zzk;

    public zzfx(int i11) {
        this.zza = i11;
    }

    public final void zzA() {
        this.zzj = true;
    }

    public final void zzB(int i11) {
        this.zzd = i11;
    }

    public /* synthetic */ void zzC(float f11, float f12) {
    }

    public final void zzD() throws zzgg {
        boolean z11 = true;
        if (this.zze != 1) {
            z11 = false;
        }
        zzdy.zzf(z11);
        this.zze = 2;
        zzu();
    }

    public final void zzE() {
        boolean z11;
        if (this.zze == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        this.zze = 1;
        zzv();
    }

    public final boolean zzF() {
        return this.zzi == Long.MIN_VALUE;
    }

    public final boolean zzG() {
        return this.zzj;
    }

    public final boolean zzH() {
        if (zzF()) {
            return this.zzj;
        }
        zzrn zzrn = this.zzf;
        zzrn.getClass();
        return zzrn.zze();
    }

    public final zzab[] zzI() {
        zzab[] zzabArr = this.zzg;
        zzabArr.getClass();
        return zzabArr;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzbm() {
        return this.zze;
    }

    public final int zzbn(zzhr zzhr, zzda zzda, int i11) {
        zzrn zzrn = this.zzf;
        zzrn.getClass();
        int zza2 = zzrn.zza(zzhr, zzda, i11);
        if (zza2 == -4) {
            if (zzda.zzg()) {
                this.zzi = Long.MIN_VALUE;
                if (this.zzj) {
                    return -4;
                }
                return -3;
            }
            long j11 = zzda.zzd + this.zzh;
            zzda.zzd = j11;
            this.zzi = Math.max(this.zzi, j11);
        } else if (zza2 == -5) {
            zzab zzab = zzhr.zza;
            zzab.getClass();
            if (zzab.zzq != Long.MAX_VALUE) {
                zzz zzb2 = zzab.zzb();
                zzb2.zzW(zzab.zzq + this.zzh);
                zzhr.zza = zzb2.zzY();
                return -5;
            }
        }
        return zza2;
    }

    public final zzgg zzbo(Throwable th2, @Nullable zzab zzab, boolean z11, int i11) {
        int i12 = 4;
        if (zzab != null && !this.zzk) {
            this.zzk = true;
            try {
                i12 = zzN(zzab) & 7;
            } catch (zzgg unused) {
            } finally {
                this.zzk = false;
            }
        }
        return zzgg.zzb(th2, zzJ(), this.zzd, zzab, i12, z11, i11);
    }

    public final int zzd(long j11) {
        zzrn zzrn = this.zzf;
        zzrn.getClass();
        return zzrn.zzb(j11 - this.zzh);
    }

    public int zze() throws zzgg {
        return 0;
    }

    public final long zzf() {
        return this.zzi;
    }

    public final zzhr zzh() {
        zzhr zzhr = this.zzb;
        zzhr.zzb = null;
        zzhr.zza = null;
        return zzhr;
    }

    @Nullable
    public zzht zzi() {
        return null;
    }

    public final zzim zzj() {
        return this;
    }

    public final zzin zzk() {
        zzin zzin = this.zzc;
        zzin.getClass();
        return zzin;
    }

    @Nullable
    public final zzrn zzl() {
        return this.zzf;
    }

    public final void zzm() {
        boolean z11 = true;
        if (this.zze != 1) {
            z11 = false;
        }
        zzdy.zzf(z11);
        zzhr zzhr = this.zzb;
        zzhr.zzb = null;
        zzhr.zza = null;
        this.zze = 0;
        this.zzf = null;
        this.zzg = null;
        this.zzj = false;
        zzq();
    }

    public final void zzn(zzin zzin, zzab[] zzabArr, zzrn zzrn, long j11, boolean z11, boolean z12, long j12, long j13) throws zzgg {
        boolean z13;
        boolean z14 = z11;
        if (this.zze == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        zzdy.zzf(z13);
        this.zzc = zzin;
        this.zze = 1;
        zzr(z11, z12);
        zzx(zzabArr, zzrn, j12, j13);
        long j14 = j11;
        zzs(j11, z11);
    }

    public void zzo(int i11, @Nullable Object obj) throws zzgg {
    }

    public final void zzp() throws IOException {
        zzrn zzrn = this.zzf;
        zzrn.getClass();
        zzrn.zzd();
    }

    public void zzq() {
        throw null;
    }

    public void zzr(boolean z11, boolean z12) throws zzgg {
    }

    public void zzs(long j11, boolean z11) throws zzgg {
        throw null;
    }

    public void zzt() {
    }

    public void zzu() throws zzgg {
    }

    public void zzv() {
    }

    public void zzw(zzab[] zzabArr, long j11, long j12) throws zzgg {
        throw null;
    }

    public final void zzx(zzab[] zzabArr, zzrn zzrn, long j11, long j12) throws zzgg {
        zzdy.zzf(!this.zzj);
        this.zzf = zzrn;
        if (this.zzi == Long.MIN_VALUE) {
            this.zzi = j11;
        }
        this.zzg = zzabArr;
        this.zzh = j12;
        zzw(zzabArr, j11, j12);
    }

    public final void zzy() {
        boolean z11;
        if (this.zze == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        zzhr zzhr = this.zzb;
        zzhr.zzb = null;
        zzhr.zza = null;
        zzt();
    }

    public final void zzz(long j11) throws zzgg {
        this.zzj = false;
        this.zzi = j11;
        zzs(j11, false);
    }
}
