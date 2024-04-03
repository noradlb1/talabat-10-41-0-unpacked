package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzads {
    private static final byte[] zzd = {0, 0, 1};
    public int zza;
    public int zzb;
    public byte[] zzc = new byte[128];
    private boolean zze;

    public zzads(int i11) {
    }

    public final void zza(byte[] bArr, int i11, int i12) {
        if (this.zze) {
            int i13 = i12 - i11;
            byte[] bArr2 = this.zzc;
            int length = bArr2.length;
            int i14 = this.zza + i13;
            if (length < i14) {
                this.zzc = Arrays.copyOf(bArr2, i14 + i14);
            }
            System.arraycopy(bArr, i11, this.zzc, this.zza, i13);
            this.zza += i13;
        }
    }

    public final void zzb() {
        this.zze = false;
        this.zza = 0;
        this.zzb = 0;
    }

    public final boolean zzc(int i11, int i12) {
        if (this.zze) {
            int i13 = this.zza - i12;
            this.zza = i13;
            if (this.zzb == 0 && i11 == 181) {
                this.zzb = i13;
            } else {
                this.zze = false;
                return true;
            }
        } else if (i11 == 179) {
            this.zze = true;
        }
        zza(zzd, 0, 3);
        return false;
    }
}
