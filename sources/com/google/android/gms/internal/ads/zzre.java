package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzre extends zzpc implements zzqv {
    private final zzaz zza;
    private final zzau zzb;
    private final zzdh zzc;
    private final zznk zzd;
    private final int zze;
    private boolean zzf = true;
    private long zzg = C.TIME_UNSET;
    private boolean zzh;
    private boolean zzi;
    @Nullable
    private zzdx zzj;
    private final zzrb zzk;
    private final zztq zzl;

    public /* synthetic */ zzre(zzaz zzaz, zzdh zzdh, zzrb zzrb, zznk zznk, zztq zztq, int i11, zzrd zzrd, byte[] bArr) {
        zzau zzau = zzaz.zzd;
        zzau.getClass();
        this.zzb = zzau;
        this.zza = zzaz;
        this.zzc = zzdh;
        this.zzk = zzrb;
        this.zzd = zznk;
        this.zzl = zztq;
        this.zze = i11;
    }

    private final void zzu() {
        zzas zzas;
        zzcd zzcd;
        long j11 = this.zzg;
        boolean z11 = this.zzh;
        boolean z12 = this.zzi;
        zzaz zzaz = this.zza;
        if (z12) {
            zzas = zzaz.zzf;
        } else {
            zzas = null;
        }
        zzrr zzrr = r1;
        boolean z13 = z11;
        long j12 = j11;
        zzrr zzrr2 = new zzrr(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j11, j12, 0, 0, z13, false, false, (Object) null, zzaz, zzas);
        if (this.zzf) {
            zzcd = new zzra(this, zzrr);
        } else {
            zzcd = zzrr;
        }
        zzn(zzcd);
    }

    public final void zzA(zzpy zzpy) {
        ((zzqz) zzpy).zzK();
    }

    public final zzpy zzC(zzpz zzpz, zztk zztk, long j11) {
        zzdi zza2 = this.zzc.zza();
        zzdx zzdx = this.zzj;
        if (zzdx != null) {
            zza2.zzb(zzdx);
        }
        Uri uri = this.zzb.zza;
        zzpe zzpe = new zzpe(this.zzk.zza);
        zznk zznk = this.zzd;
        zzne zzb2 = zzb(zzpz);
        zztq zztq = this.zzl;
        zzqi zzd2 = zzd(zzpz);
        String str = this.zzb.zzf;
        return new zzqz(uri, zza2, zzpe, zznk, zzb2, zztq, zzd2, this, zztk, (String) null, this.zze, (byte[]) null);
    }

    public final void zza(long j11, boolean z11, boolean z12) {
        if (j11 == C.TIME_UNSET) {
            j11 = this.zzg;
        }
        if (this.zzf || this.zzg != j11 || this.zzh != z11 || this.zzi != z12) {
            this.zzg = j11;
            this.zzh = z11;
            this.zzi = z12;
            this.zzf = false;
            zzu();
        }
    }

    public final void zzm(@Nullable zzdx zzdx) {
        this.zzj = zzdx;
        zzu();
    }

    public final void zzp() {
    }

    public final void zzv() {
    }

    public final zzaz zzy() {
        return this.zza;
    }
}
