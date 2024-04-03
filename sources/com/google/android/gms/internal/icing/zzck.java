package com.google.android.gms.internal.icing;

import java.io.IOException;

final class zzck extends zzcm {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzck(byte[] bArr, int i11, int i12) {
        super((zzcj) null);
        int length = bArr.length;
        if (((length - i12) | i12) >= 0) {
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i12;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i12)}));
    }

    public final void zza(int i11, int i12) throws IOException {
        zzl((i11 << 3) | i12);
    }

    public final void zzb(int i11, int i12) throws IOException {
        zzl(i11 << 3);
        zzk(i12);
    }

    public final void zzc(int i11, int i12) throws IOException {
        zzl(i11 << 3);
        zzl(i12);
    }

    public final void zzd(int i11, int i12) throws IOException {
        zzl((i11 << 3) | 5);
        zzm(i12);
    }

    public final void zze(int i11, long j11) throws IOException {
        zzl(i11 << 3);
        zzn(j11);
    }

    public final void zzf(int i11, long j11) throws IOException {
        zzl((i11 << 3) | 1);
        zzo(j11);
    }

    public final void zzg(int i11, boolean z11) throws IOException {
        zzl(i11 << 3);
        zzj(z11 ? (byte) 1 : 0);
    }

    public final void zzh(int i11, String str) throws IOException {
        zzl((i11 << 3) | 2);
        zzr(str);
    }

    public final void zzi(int i11, zzcf zzcf) throws IOException {
        zzl((i11 << 3) | 2);
        zzl(zzcf.zzc());
        zzcf.zzf(this);
    }

    public final void zzj(byte b11) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i11 = this.zzd;
            this.zzd = i11 + 1;
            bArr[i11] = b11;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzcl(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
        }
    }

    public final void zzk(int i11) throws IOException {
        if (i11 >= 0) {
            zzl(i11);
        } else {
            zzn((long) i11);
        }
    }

    public final void zzl(int i11) throws IOException {
        if (zzcm.zzc) {
            int i12 = zzbu.zza;
        }
        while ((i11 & -128) != 0) {
            byte[] bArr = this.zzb;
            int i13 = this.zzd;
            this.zzd = i13 + 1;
            bArr[i13] = (byte) ((i11 & 127) | 128);
            i11 >>>= 7;
        }
        try {
            byte[] bArr2 = this.zzb;
            int i14 = this.zzd;
            this.zzd = i14 + 1;
            bArr2[i14] = (byte) i11;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzcl(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
        }
    }

    public final void zzm(int i11) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i12 = this.zzd;
            int i13 = i12 + 1;
            bArr[i12] = (byte) (i11 & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i11 >> 8) & 255);
            int i15 = i14 + 1;
            bArr[i14] = (byte) ((i11 >> 16) & 255);
            this.zzd = i15 + 1;
            bArr[i15] = (byte) ((i11 >> 24) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzcl(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
        }
    }

    public final void zzn(long j11) throws IOException {
        if (!zzcm.zzc || this.zzc - this.zzd < 10) {
            while ((j11 & -128) != 0) {
                byte[] bArr = this.zzb;
                int i11 = this.zzd;
                this.zzd = i11 + 1;
                bArr[i11] = (byte) ((((int) j11) & 127) | 128);
                j11 >>>= 7;
            }
            try {
                byte[] bArr2 = this.zzb;
                int i12 = this.zzd;
                this.zzd = i12 + 1;
                bArr2[i12] = (byte) ((int) j11);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzcl(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
            }
        } else {
            while ((j11 & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i13 = this.zzd;
                this.zzd = i13 + 1;
                zzfn.zzp(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                j11 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i14 = this.zzd;
            this.zzd = i14 + 1;
            zzfn.zzp(bArr4, (long) i14, (byte) ((int) j11));
        }
    }

    public final void zzo(long j11) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i11 = this.zzd;
            int i12 = i11 + 1;
            bArr[i11] = (byte) (((int) j11) & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) (((int) (j11 >> 8)) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (((int) (j11 >> 16)) & 255);
            int i15 = i14 + 1;
            bArr[i14] = (byte) (((int) (j11 >> 24)) & 255);
            int i16 = i15 + 1;
            bArr[i15] = (byte) (((int) (j11 >> 32)) & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) (((int) (j11 >> 40)) & 255);
            int i18 = i17 + 1;
            bArr[i17] = (byte) (((int) (j11 >> 48)) & 255);
            this.zzd = i18 + 1;
            bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzcl(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
        }
    }

    public final void zzp(byte[] bArr, int i11, int i12) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i12);
            this.zzd += i12;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzcl(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i12)}), e11);
        }
    }

    public final void zzq(byte[] bArr, int i11, int i12) throws IOException {
        zzp(bArr, 0, i12);
    }

    public final void zzr(String str) throws IOException {
        int i11 = this.zzd;
        try {
            int zzw = zzcm.zzw(str.length() * 3);
            int zzw2 = zzcm.zzw(str.length());
            if (zzw2 == zzw) {
                int i12 = i11 + zzw2;
                this.zzd = i12;
                int zzd2 = zzfr.zzd(str, this.zzb, i12, this.zzc - i12);
                this.zzd = i11;
                zzl((zzd2 - i11) - zzw2);
                this.zzd = zzd2;
                return;
            }
            zzl(zzfr.zzc(str));
            byte[] bArr = this.zzb;
            int i13 = this.zzd;
            this.zzd = zzfr.zzd(str, bArr, i13, this.zzc - i13);
        } catch (zzfq e11) {
            this.zzd = i11;
            zzD(str, e11);
        } catch (IndexOutOfBoundsException e12) {
            throw new zzcl(e12);
        }
    }

    public final int zzs() {
        return this.zzc - this.zzd;
    }
}
