package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzage  reason: invalid package */
final class zzage extends zzagi {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    public zzage(byte[] bArr, int i11, int i12) {
        super((zzagh) null);
        int length = bArr.length;
        if (((length - i12) | i12) >= 0) {
            this.zza = bArr;
            this.zzc = 0;
            this.zzb = i12;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i12)}));
    }

    public final void zzI() {
    }

    public final void zzJ(byte b11) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i11 = this.zzc;
            this.zzc = i11 + 1;
            bArr[i11] = b11;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzagf(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e11);
        }
    }

    public final void zzK(int i11, boolean z11) throws IOException {
        zzs(i11 << 3);
        zzJ(z11 ? (byte) 1 : 0);
    }

    public final void zzL(int i11, zzafv zzafv) throws IOException {
        zzs((i11 << 3) | 2);
        zzs(zzafv.zzd());
        zzafv.zzj(this);
    }

    public final void zza(byte[] bArr, int i11, int i12) throws IOException {
        zze(bArr, 0, i12);
    }

    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i11, int i12) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zza, this.zzc, i12);
            this.zzc += i12;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzagf(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i12)}), e11);
        }
    }

    public final void zzh(int i11, int i12) throws IOException {
        zzs((i11 << 3) | 5);
        zzi(i12);
    }

    public final void zzi(int i11) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i12 = this.zzc;
            int i13 = i12 + 1;
            bArr[i12] = (byte) (i11 & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i11 >> 8) & 255);
            int i15 = i14 + 1;
            bArr[i14] = (byte) ((i11 >> 16) & 255);
            this.zzc = i15 + 1;
            bArr[i15] = (byte) ((i11 >> 24) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzagf(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e11);
        }
    }

    public final void zzj(int i11, long j11) throws IOException {
        zzs((i11 << 3) | 1);
        zzk(j11);
    }

    public final void zzk(long j11) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i11 = this.zzc;
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
            this.zzc = i18 + 1;
            bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzagf(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e11);
        }
    }

    public final void zzl(int i11, int i12) throws IOException {
        zzs(i11 << 3);
        zzm(i12);
    }

    public final void zzm(int i11) throws IOException {
        if (i11 >= 0) {
            zzs(i11);
        } else {
            zzu((long) i11);
        }
    }

    public final void zzn(int i11, zzaif zzaif, zzair zzair) throws IOException {
        zzs((i11 << 3) | 2);
        zzs(((zzaff) zzaif).zzn(zzair));
        zzair.zzm(zzaif, this.zze);
    }

    public final void zzo(int i11, String str) throws IOException {
        zzs((i11 << 3) | 2);
        zzp(str);
    }

    public final void zzp(String str) throws IOException {
        int i11 = this.zzc;
        try {
            int zzA = zzagi.zzA(str.length() * 3);
            int zzA2 = zzagi.zzA(str.length());
            if (zzA2 == zzA) {
                int i12 = i11 + zzA2;
                this.zzc = i12;
                int zzb2 = zzaka.zzb(str, this.zza, i12, this.zzb - i12);
                this.zzc = i11;
                zzs((zzb2 - i11) - zzA2);
                this.zzc = zzb2;
                return;
            }
            zzs(zzaka.zzc(str));
            byte[] bArr = this.zza;
            int i13 = this.zzc;
            this.zzc = zzaka.zzb(str, bArr, i13, this.zzb - i13);
        } catch (zzajz e11) {
            this.zzc = i11;
            zzE(str, e11);
        } catch (IndexOutOfBoundsException e12) {
            throw new zzagf(e12);
        }
    }

    public final void zzq(int i11, int i12) throws IOException {
        zzs((i11 << 3) | i12);
    }

    public final void zzr(int i11, int i12) throws IOException {
        zzs(i11 << 3);
        zzs(i12);
    }

    public final void zzs(int i11) throws IOException {
        while ((i11 & -128) != 0) {
            byte[] bArr = this.zza;
            int i12 = this.zzc;
            this.zzc = i12 + 1;
            bArr[i12] = (byte) ((i11 & 127) | 128);
            i11 >>>= 7;
        }
        try {
            byte[] bArr2 = this.zza;
            int i13 = this.zzc;
            this.zzc = i13 + 1;
            bArr2[i13] = (byte) i11;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzagf(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e11);
        }
    }

    public final void zzt(int i11, long j11) throws IOException {
        zzs(i11 << 3);
        zzu(j11);
    }

    public final void zzu(long j11) throws IOException {
        if (!zzagi.zzb || this.zzb - this.zzc < 10) {
            while ((j11 & -128) != 0) {
                byte[] bArr = this.zza;
                int i11 = this.zzc;
                this.zzc = i11 + 1;
                bArr[i11] = (byte) ((((int) j11) & 127) | 128);
                j11 >>>= 7;
            }
            try {
                byte[] bArr2 = this.zza;
                int i12 = this.zzc;
                this.zzc = i12 + 1;
                bArr2[i12] = (byte) ((int) j11);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzagf(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e11);
            }
        } else {
            while ((j11 & -128) != 0) {
                byte[] bArr3 = this.zza;
                int i13 = this.zzc;
                this.zzc = i13 + 1;
                zzajv.zzn(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                j11 >>>= 7;
            }
            byte[] bArr4 = this.zza;
            int i14 = this.zzc;
            this.zzc = i14 + 1;
            zzajv.zzn(bArr4, (long) i14, (byte) ((int) j11));
        }
    }
}
