package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzabz {
    public final zzxt zza;
    public final zzacm zzb = new zzacm();
    public final zzfd zzc = new zzfd();
    public zzacn zzd;
    public zzabv zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzfd zzj = new zzfd(1);
    private final zzfd zzk = new zzfd();
    /* access modifiers changed from: private */
    public boolean zzl;

    public zzabz(zzxt zzxt, zzacn zzacn, zzabv zzabv) {
        this.zza = zzxt;
        this.zzd = zzacn;
        this.zze = zzabv;
        zzh(zzacn, zzabv);
    }

    public final int zza() {
        int i11;
        if (!this.zzl) {
            i11 = this.zzd.zzg[this.zzf];
        } else if (this.zzb.zzk[this.zzf]) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (zzf() != null) {
            return i11 | 1073741824;
        }
        return i11;
    }

    public final int zzb() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i11, int i12) {
        zzfd zzfd;
        boolean z11;
        int i13;
        zzacl zzf2 = zzf();
        if (zzf2 == null) {
            return 0;
        }
        int i14 = zzf2.zzd;
        if (i14 != 0) {
            zzfd = this.zzb.zzo;
        } else {
            byte[] bArr = (byte[]) zzfn.zzC(zzf2.zze);
            zzfd zzfd2 = this.zzk;
            int length = bArr.length;
            zzfd2.zzD(bArr, length);
            zzfd = this.zzk;
            i14 = length;
        }
        boolean zzc2 = this.zzb.zzc(this.zzf);
        if (zzc2 || i12 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        byte[] zzH = this.zzj.zzH();
        if (true != z11) {
            i13 = 0;
        } else {
            i13 = 128;
        }
        zzH[0] = (byte) (i13 | i14);
        this.zzj.zzF(0);
        this.zza.zzr(this.zzj, 1, 1);
        this.zza.zzr(zzfd, i14, 1);
        if (!z11) {
            return i14 + 1;
        }
        if (!zzc2) {
            this.zzc.zzC(8);
            byte[] zzH2 = this.zzc.zzH();
            zzH2[0] = 0;
            zzH2[1] = 1;
            zzH2[2] = 0;
            zzH2[3] = (byte) i12;
            zzH2[4] = (byte) ((i11 >> 24) & 255);
            zzH2[5] = (byte) ((i11 >> 16) & 255);
            zzH2[6] = (byte) ((i11 >> 8) & 255);
            zzH2[7] = (byte) (i11 & 255);
            this.zza.zzr(this.zzc, 8, 1);
            return i14 + 9;
        }
        zzfd zzfd3 = this.zzb.zzo;
        int zzo = zzfd3.zzo();
        zzfd3.zzG(-2);
        int i15 = (zzo * 6) + 2;
        if (i12 != 0) {
            this.zzc.zzC(i15);
            byte[] zzH3 = this.zzc.zzH();
            zzfd3.zzB(zzH3, 0, i15);
            int i16 = (((zzH3[2] & 255) << 8) | (zzH3[3] & 255)) + i12;
            zzH3[2] = (byte) ((i16 >> 8) & 255);
            zzH3[3] = (byte) (i16 & 255);
            zzfd3 = this.zzc;
        }
        this.zza.zzr(zzfd3, i15, 1);
        return i14 + 1 + i15;
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        return this.zzb.zza(this.zzf);
    }

    @Nullable
    public final zzacl zzf() {
        if (!this.zzl) {
            return null;
        }
        zzacm zzacm = this.zzb;
        zzabv zzabv = zzacm.zza;
        int i11 = zzfn.zza;
        int i12 = zzabv.zza;
        zzacl zzacl = zzacm.zzn;
        if (zzacl == null) {
            zzacl = this.zzd.zza.zza(i12);
        }
        if (zzacl == null || !zzacl.zza) {
            return null;
        }
        return zzacl;
    }

    public final void zzh(zzacn zzacn, zzabv zzabv) {
        this.zzd = zzacn;
        this.zze = zzabv;
        this.zza.zzk(zzacn.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzacm zzacm = this.zzb;
        zzacm.zzd = 0;
        zzacm.zzq = 0;
        zzacm.zzr = false;
        zzacm.zzl = false;
        zzacm.zzp = false;
        zzacm.zzn = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i11 = this.zzg + 1;
        this.zzg = i11;
        int[] iArr = this.zzb.zzg;
        int i12 = this.zzh;
        if (i11 != iArr[i12]) {
            return true;
        }
        this.zzh = i12 + 1;
        this.zzg = 0;
        return false;
    }
}
