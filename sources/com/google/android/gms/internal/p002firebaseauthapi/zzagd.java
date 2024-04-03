package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagd  reason: invalid package */
abstract class zzagd extends zzagi {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    public zzagd(int i11) {
        super((zzagh) null);
        if (i11 >= 0) {
            byte[] bArr = new byte[Math.max(i11, 20)];
            this.zza = bArr;
            this.zzb = bArr.length;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    public final int zzb() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    public final void zzc(byte b11) {
        byte[] bArr = this.zza;
        int i11 = this.zzc;
        this.zzc = i11 + 1;
        bArr[i11] = b11;
        this.zzd++;
    }

    public final void zzd(int i11) {
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
        this.zzd += 4;
    }

    public final void zze(long j11) {
        byte[] bArr = this.zza;
        int i11 = this.zzc;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((int) (j11 & 255));
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((int) ((j11 >> 8) & 255));
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((int) ((j11 >> 16) & 255));
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((int) (255 & (j11 >> 24)));
        int i16 = i15 + 1;
        bArr[i15] = (byte) (((int) (j11 >> 32)) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) (((int) (j11 >> 40)) & 255);
        int i18 = i17 + 1;
        bArr[i17] = (byte) (((int) (j11 >> 48)) & 255);
        this.zzc = i18 + 1;
        bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
        this.zzd += 8;
    }

    public final void zzf(int i11) {
        if (zzagi.zzb) {
            long j11 = (long) this.zzc;
            while ((i11 & -128) != 0) {
                byte[] bArr = this.zza;
                int i12 = this.zzc;
                this.zzc = i12 + 1;
                zzajv.zzn(bArr, (long) i12, (byte) ((i11 & 127) | 128));
                i11 >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i13 = this.zzc;
            this.zzc = i13 + 1;
            zzajv.zzn(bArr2, (long) i13, (byte) i11);
            this.zzd += (int) (((long) this.zzc) - j11);
            return;
        }
        while ((i11 & -128) != 0) {
            byte[] bArr3 = this.zza;
            int i14 = this.zzc;
            this.zzc = i14 + 1;
            bArr3[i14] = (byte) ((i11 & 127) | 128);
            this.zzd++;
            i11 >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i15 = this.zzc;
        this.zzc = i15 + 1;
        bArr4[i15] = (byte) i11;
        this.zzd++;
    }

    public final void zzg(long j11) {
        if (zzagi.zzb) {
            long j12 = (long) this.zzc;
            while ((j11 & -128) != 0) {
                byte[] bArr = this.zza;
                int i11 = this.zzc;
                this.zzc = i11 + 1;
                zzajv.zzn(bArr, (long) i11, (byte) ((((int) j11) & 127) | 128));
                j11 >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i12 = this.zzc;
            this.zzc = i12 + 1;
            zzajv.zzn(bArr2, (long) i12, (byte) ((int) j11));
            this.zzd += (int) (((long) this.zzc) - j12);
            return;
        }
        while ((j11 & -128) != 0) {
            byte[] bArr3 = this.zza;
            int i13 = this.zzc;
            this.zzc = i13 + 1;
            bArr3[i13] = (byte) ((((int) j11) & 127) | 128);
            this.zzd++;
            j11 >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i14 = this.zzc;
        this.zzc = i14 + 1;
        bArr4[i14] = (byte) ((int) j11);
        this.zzd++;
    }
}
