package com.google.android.libraries.places.internal;

import java.io.IOException;

final class zzabc extends zzabf {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzabc(byte[] bArr, int i11, int i12) {
        super((zzabe) null);
        if (bArr != null) {
            int length = bArr.length;
            if (((length - i12) | i12) >= 0) {
                this.zzb = bArr;
                this.zzd = 0;
                this.zzc = i12;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i12)}));
        }
        throw new NullPointerException("buffer");
    }

    public final int zza() {
        return this.zzc - this.zzd;
    }

    public final void zzb(byte b11) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i11 = this.zzd;
            this.zzd = i11 + 1;
            bArr[i11] = b11;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzabd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
        }
    }

    public final void zzc(byte[] bArr, int i11, int i12) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i12);
            this.zzd += i12;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzabd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i12)}), e11);
        }
    }

    public final void zzd(int i11, boolean z11) throws IOException {
        zzq(i11 << 3);
        zzb(z11 ? (byte) 1 : 0);
    }

    public final void zze(int i11, zzaax zzaax) throws IOException {
        zzq((i11 << 3) | 2);
        zzq(zzaax.zzd());
        zzaax.zzh(this);
    }

    public final void zzf(int i11, int i12) throws IOException {
        zzq((i11 << 3) | 5);
        zzg(i12);
    }

    public final void zzg(int i11) throws IOException {
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
            throw new zzabd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
        }
    }

    public final void zzh(int i11, long j11) throws IOException {
        zzq((i11 << 3) | 1);
        zzi(j11);
    }

    public final void zzi(long j11) throws IOException {
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
            throw new zzabd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
        }
    }

    public final void zzj(int i11, int i12) throws IOException {
        zzq(i11 << 3);
        zzk(i12);
    }

    public final void zzk(int i11) throws IOException {
        if (i11 >= 0) {
            zzq(i11);
        } else {
            zzs((long) i11);
        }
    }

    public final void zzl(byte[] bArr, int i11, int i12) throws IOException {
        zzc(bArr, 0, i12);
    }

    public final void zzm(int i11, String str) throws IOException {
        zzq((i11 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i11 = this.zzd;
        try {
            int zzA = zzabf.zzA(str.length() * 3);
            int zzA2 = zzabf.zzA(str.length());
            if (zzA2 == zzA) {
                int i12 = i11 + zzA2;
                this.zzd = i12;
                int zzb2 = zzaep.zzb(str, this.zzb, i12, this.zzc - i12);
                this.zzd = i11;
                zzq((zzb2 - i11) - zzA2);
                this.zzd = zzb2;
                return;
            }
            zzq(zzaep.zzc(str));
            byte[] bArr = this.zzb;
            int i13 = this.zzd;
            this.zzd = zzaep.zzb(str, bArr, i13, this.zzc - i13);
        } catch (zzaeo e11) {
            this.zzd = i11;
            zzE(str, e11);
        } catch (IndexOutOfBoundsException e12) {
            throw new zzabd(e12);
        }
    }

    public final void zzo(int i11, int i12) throws IOException {
        zzq((i11 << 3) | i12);
    }

    public final void zzp(int i11, int i12) throws IOException {
        zzq(i11 << 3);
        zzq(i12);
    }

    public final void zzq(int i11) throws IOException {
        if (zzabf.zzc) {
            int i12 = zzaal.zza;
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
            throw new zzabd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
        }
    }

    public final void zzr(int i11, long j11) throws IOException {
        zzq(i11 << 3);
        zzs(j11);
    }

    public final void zzs(long j11) throws IOException {
        if (!zzabf.zzc || this.zzc - this.zzd < 10) {
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
                throw new zzabd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1}), e11);
            }
        } else {
            while ((j11 & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i13 = this.zzd;
                this.zzd = i13 + 1;
                zzael.zzn(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                j11 >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i14 = this.zzd;
            this.zzd = i14 + 1;
            zzael.zzn(bArr4, (long) i14, (byte) ((int) j11));
        }
    }
}
