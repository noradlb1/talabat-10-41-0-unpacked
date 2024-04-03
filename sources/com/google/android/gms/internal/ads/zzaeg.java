package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzaeg {
    public byte[] zza;
    public int zzb;
    private final int zzc;
    private boolean zzd;
    private boolean zze;

    public zzaeg(int i11, int i12) {
        this.zzc = i11;
        byte[] bArr = new byte[131];
        this.zza = bArr;
        bArr[2] = 1;
    }

    public final void zza(byte[] bArr, int i11, int i12) {
        if (this.zzd) {
            int i13 = i12 - i11;
            byte[] bArr2 = this.zza;
            int length = bArr2.length;
            int i14 = this.zzb + i13;
            if (length < i14) {
                this.zza = Arrays.copyOf(bArr2, i14 + i14);
            }
            System.arraycopy(bArr, i11, this.zza, this.zzb, i13);
            this.zzb += i13;
        }
    }

    public final void zzb() {
        this.zzd = false;
        this.zze = false;
    }

    public final void zzc(int i11) {
        boolean z11 = true;
        zzdy.zzf(!this.zzd);
        if (i11 != this.zzc) {
            z11 = false;
        }
        this.zzd = z11;
        if (z11) {
            this.zzb = 3;
            this.zze = false;
        }
    }

    public final boolean zzd(int i11) {
        if (!this.zzd) {
            return false;
        }
        this.zzb -= i11;
        this.zzd = false;
        this.zze = true;
        return true;
    }

    public final boolean zze() {
        return this.zze;
    }
}
