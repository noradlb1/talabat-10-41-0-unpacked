package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzoc {
    private int zza = 0;
    private int zzb = -1;
    private int zzc = 0;
    private int[] zzd;
    private int zze;

    public zzoc() {
        int[] iArr = new int[16];
        this.zzd = iArr;
        this.zze = iArr.length - 1;
    }

    public final int zza() {
        int i11 = this.zzc;
        if (i11 != 0) {
            int[] iArr = this.zzd;
            int i12 = this.zza;
            int i13 = iArr[i12];
            this.zza = (i12 + 1) & this.zze;
            this.zzc = i11 - 1;
            return i13;
        }
        throw new NoSuchElementException();
    }

    public final void zzb(int i11) {
        int i12 = this.zzc;
        int[] iArr = this.zzd;
        int length = iArr.length;
        if (i12 == length) {
            int i13 = length + length;
            if (i13 >= 0) {
                int[] iArr2 = new int[i13];
                int i14 = this.zza;
                int i15 = length - i14;
                System.arraycopy(iArr, i14, iArr2, 0, i15);
                System.arraycopy(this.zzd, 0, iArr2, i15, i14);
                this.zza = 0;
                this.zzb = this.zzc - 1;
                this.zzd = iArr2;
                this.zze = iArr2.length - 1;
                iArr = iArr2;
            } else {
                throw new IllegalStateException();
            }
        }
        int i16 = (this.zzb + 1) & this.zze;
        this.zzb = i16;
        iArr[i16] = i11;
        this.zzc++;
    }

    public final void zzc() {
        this.zza = 0;
        this.zzb = -1;
        this.zzc = 0;
    }

    public final boolean zzd() {
        return this.zzc == 0;
    }
}
