package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;

public final class zzawu {
    public byte[] zza;
    private int zzb;
    private int zzc;

    public zzawu() {
    }

    public zzawu(int i11) {
        this.zza = new byte[i11];
        this.zzc = i11;
    }

    public final int zza() {
        return this.zzc - this.zzb;
    }

    public final int zzb() {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        this.zzb = i14 + 1;
        return (bArr[i14] & 255) | ((b11 & 255) << Ascii.CAN) | ((b12 & 255) << Ascii.DLE) | ((b13 & 255) << 8);
    }

    public final int zzf() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        this.zzb = i12 + 1;
        return ((bArr[i12] & 255) << 8) | (b11 & 255);
    }

    public final int zzg() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        this.zzb = i11 + 1;
        return bArr[i11] & 255;
    }

    public final int zzh() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        byte b12 = bArr[i12];
        this.zzb = i12 + 1 + 2;
        return (b12 & 255) | ((b11 & 255) << 8);
    }

    public final int zzi() {
        int zze = zze();
        if (zze >= 0) {
            return zze;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("Top bit not zero: ");
        sb2.append(zze);
        throw new IllegalStateException(sb2.toString());
    }

    public final int zzj() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        this.zzb = i12 + 1;
        return (bArr[i12] & 255) | ((b11 & 255) << 8);
    }

    public final long zzk() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        this.zzb = i14 + 1;
        return ((((long) b12) & 255) << 8) | (((long) b11) & 255) | ((((long) b13) & 255) << 16) | ((((long) bArr[i14]) & 255) << 24);
    }

    public final long zzl() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        int i15 = i14 + 1;
        byte b14 = bArr[i14];
        int i16 = i15 + 1;
        byte b15 = bArr[i15];
        int i17 = i16 + 1;
        byte b16 = bArr[i16];
        int i18 = i17 + 1;
        byte b17 = bArr[i17];
        this.zzb = i18 + 1;
        return ((((long) b12) & 255) << 48) | ((((long) b11) & 255) << 56) | ((((long) b13) & 255) << 40) | ((((long) b14) & 255) << 32) | ((((long) b15) & 255) << 24) | ((((long) b16) & 255) << 16) | ((((long) b17) & 255) << 8) | (((long) bArr[i18]) & 255);
    }

    public final long zzm() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        int i13 = i12 + 1;
        byte b12 = bArr[i12];
        int i14 = i13 + 1;
        byte b13 = bArr[i13];
        this.zzb = i14 + 1;
        return ((((long) b12) & 255) << 16) | ((((long) b11) & 255) << 24) | ((((long) b13) & 255) << 8) | (((long) bArr[i14]) & 255);
    }

    public final long zzn() {
        long zzl = zzl();
        if (zzl >= 0) {
            return zzl;
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("Top bit not zero: ");
        sb2.append(zzl);
        throw new IllegalStateException(sb2.toString());
    }

    public final String zzo(int i11) {
        int i12;
        if (i11 == 0) {
            return "";
        }
        int i13 = this.zzb;
        int i14 = (i13 + i11) - 1;
        if (i14 >= this.zzc || this.zza[i14] != 0) {
            i12 = i11;
        } else {
            i12 = i11 - 1;
        }
        String str = new String(this.zza, i13, i12);
        this.zzb += i11;
        return str;
    }

    public final short zzp() {
        byte[] bArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        this.zzb = i12 + 1;
        return (short) ((bArr[i12] & 255) | ((b11 & 255) << 8));
    }

    public final void zzq(byte[] bArr, int i11, int i12) {
        System.arraycopy(this.zza, this.zzb, bArr, i11, i12);
        this.zzb += i12;
    }

    public final void zzr() {
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zzs(int i11) {
        zzt(zzb() < i11 ? new byte[i11] : this.zza, i11);
    }

    public final void zzt(byte[] bArr, int i11) {
        this.zza = bArr;
        this.zzc = i11;
        this.zzb = 0;
    }

    public final void zzu(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= this.zza.length) {
            z11 = true;
        }
        zzawm.zzc(z11);
        this.zzc = i11;
    }

    public final void zzv(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= this.zzc) {
            z11 = true;
        }
        zzawm.zzc(z11);
        this.zzb = i11;
    }

    public final void zzw(int i11) {
        zzv(this.zzb + i11);
    }

    public zzawu(byte[] bArr) {
        this.zza = bArr;
        this.zzc = bArr.length;
    }
}
