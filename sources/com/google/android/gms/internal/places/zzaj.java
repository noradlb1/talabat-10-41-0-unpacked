package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzaj extends zzt {
    private static final Logger logger = Logger.getLogger(zzaj.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzer = zzdy.zzdl();
    zzam zzes;

    public static class zzb extends zzaj {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public zzb(byte[] bArr, int i11, int i12) {
            super();
            if (bArr != null) {
                int i13 = i12 + 0;
                if ((i12 | 0 | (bArr.length - i13)) >= 0) {
                    this.buffer = bArr;
                    this.offset = 0;
                    this.position = 0;
                    this.limit = i13;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i12)}));
            }
            throw new NullPointerException("buffer");
        }

        private final void write(byte[] bArr, int i11, int i12) throws IOException {
            try {
                System.arraycopy(bArr, i11, this.buffer, this.position, i12);
                this.position += i12;
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i12)}), e11);
            }
        }

        public final int zzak() {
            return this.limit - this.position;
        }

        public final void zzb(int i11, long j11) throws IOException {
            zzc(i11, 0);
            zzc(j11);
        }

        public final void zzc(int i11, int i12) throws IOException {
            zzo((i11 << 3) | i12);
        }

        public final void zzd(int i11, int i12) throws IOException {
            zzc(i11, 0);
            zzn(i12);
        }

        public final void zze(int i11, int i12) throws IOException {
            zzc(i11, 0);
            zzo(i12);
        }

        public final void zzg(int i11, int i12) throws IOException {
            zzc(i11, 5);
            zzq(i12);
        }

        public final void zzj(String str) throws IOException {
            int i11 = this.position;
            try {
                int zzt = zzaj.zzt(str.length() * 3);
                int zzt2 = zzaj.zzt(str.length());
                if (zzt2 == zzt) {
                    int i12 = i11 + zzt2;
                    this.position = i12;
                    int zzb = zzea.zzb(str, this.buffer, i12, zzak());
                    this.position = i11;
                    zzo((zzb - i11) - zzt2);
                    this.position = zzb;
                    return;
                }
                zzo(zzea.zzb(str));
                this.position = zzea.zzb(str, this.buffer, this.position, zzak());
            } catch (zzee e11) {
                this.position = i11;
                zzb(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new zzc(e12);
            }
        }

        public final void zzn(int i11) throws IOException {
            if (i11 >= 0) {
                zzo(i11);
            } else {
                zzc((long) i11);
            }
        }

        public final void zzo(int i11) throws IOException {
            if (!zzaj.zzer || zzp.zzy() || zzak() < 5) {
                while ((i11 & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i12 = this.position;
                    this.position = i12 + 1;
                    bArr[i12] = (byte) ((i11 & 127) | 128);
                    i11 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    bArr2[i13] = (byte) i11;
                } catch (IndexOutOfBoundsException e11) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
                }
            } else if ((i11 & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzdy.zzb(bArr3, (long) i14, (byte) i11);
            } else {
                byte[] bArr4 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzdy.zzb(bArr4, (long) i15, (byte) (i11 | 128));
                int i16 = i11 >>> 7;
                if ((i16 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i17 = this.position;
                    this.position = i17 + 1;
                    zzdy.zzb(bArr5, (long) i17, (byte) i16);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i18 = this.position;
                this.position = i18 + 1;
                zzdy.zzb(bArr6, (long) i18, (byte) (i16 | 128));
                int i19 = i16 >>> 7;
                if ((i19 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i21 = this.position;
                    this.position = i21 + 1;
                    zzdy.zzb(bArr7, (long) i21, (byte) i19);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i22 = this.position;
                this.position = i22 + 1;
                zzdy.zzb(bArr8, (long) i22, (byte) (i19 | 128));
                int i23 = i19 >>> 7;
                if ((i23 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i24 = this.position;
                    this.position = i24 + 1;
                    zzdy.zzb(bArr9, (long) i24, (byte) i23);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i25 = this.position;
                this.position = i25 + 1;
                zzdy.zzb(bArr10, (long) i25, (byte) (i23 | 128));
                byte[] bArr11 = this.buffer;
                int i26 = this.position;
                this.position = i26 + 1;
                zzdy.zzb(bArr11, (long) i26, (byte) (i23 >>> 7));
            }
        }

        public final void zzq(int i11) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i12 = this.position;
                int i13 = i12 + 1;
                bArr[i12] = (byte) i11;
                int i14 = i13 + 1;
                bArr[i13] = (byte) (i11 >> 8);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (i11 >> 16);
                this.position = i15 + 1;
                bArr[i15] = (byte) (i11 >>> 24);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void zzc(int i11, boolean z11) throws IOException {
            zzc(i11, 0);
            zzd(z11 ? (byte) 1 : 0);
        }

        public final void zzb(int i11, String str) throws IOException {
            zzc(i11, 2);
            zzj(str);
        }

        public final void zzd(int i11, long j11) throws IOException {
            zzc(i11, 1);
            zze(j11);
        }

        public final void zze(byte[] bArr, int i11, int i12) throws IOException {
            zzo(i12);
            write(bArr, 0, i12);
        }

        public final void zzc(int i11, zzw zzw) throws IOException {
            zzc(1, 3);
            zze(2, i11);
            zzb(3, zzw);
            zzc(1, 4);
        }

        public final void zzb(int i11, zzw zzw) throws IOException {
            zzc(i11, 2);
            zzb(zzw);
        }

        public final void zzd(byte b11) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                bArr[i11] = b11;
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void zze(long j11) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i11 = this.position;
                int i12 = i11 + 1;
                bArr[i11] = (byte) ((int) j11);
                int i13 = i12 + 1;
                bArr[i12] = (byte) ((int) (j11 >> 8));
                int i14 = i13 + 1;
                bArr[i13] = (byte) ((int) (j11 >> 16));
                int i15 = i14 + 1;
                bArr[i14] = (byte) ((int) (j11 >> 24));
                int i16 = i15 + 1;
                bArr[i15] = (byte) ((int) (j11 >> 32));
                int i17 = i16 + 1;
                bArr[i16] = (byte) ((int) (j11 >> 40));
                int i18 = i17 + 1;
                bArr[i17] = (byte) ((int) (j11 >> 48));
                this.position = i18 + 1;
                bArr[i18] = (byte) ((int) (j11 >> 56));
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void zzb(zzw zzw) throws IOException {
            zzo(zzw.size());
            zzw.zzb((zzt) this);
        }

        public final void zzc(zzck zzck) throws IOException {
            zzo(zzck.zzbh());
            zzck.zzc(this);
        }

        public final void zzb(int i11, zzck zzck, zzda zzda) throws IOException {
            zzc(i11, 2);
            zzm zzm = (zzm) zzck;
            int zzw = zzm.zzw();
            if (zzw == -1) {
                zzw = zzda.zzn(zzm);
                zzm.zze(zzw);
            }
            zzo(zzw);
            zzda.zzb(zzck, this.zzes);
        }

        public final void zzc(long j11) throws IOException {
            if (!zzaj.zzer || zzak() < 10) {
                while ((j11 & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i11 = this.position;
                    this.position = i11 + 1;
                    bArr[i11] = (byte) ((((int) j11) & 127) | 128);
                    j11 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i12 = this.position;
                    this.position = i12 + 1;
                    bArr2[i12] = (byte) ((int) j11);
                } catch (IndexOutOfBoundsException e11) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
                }
            } else {
                while ((j11 & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzdy.zzb(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzdy.zzb(bArr4, (long) i14, (byte) ((int) j11));
            }
        }

        public final void zzb(int i11, zzck zzck) throws IOException {
            zzc(1, 3);
            zze(2, i11);
            zzc(3, 2);
            zzc(zzck);
            zzc(1, 4);
        }

        public final void zzb(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }
    }

    public static class zzc extends IOException {
        public zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzc(Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public zzc(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L_0x0011
                java.lang.String r3 = r0.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzaj.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzaj() {
    }

    public static int zzc(double d11) {
        return 8;
    }

    public static zzaj zzc(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzd(boolean z11) {
        return 1;
    }

    public static int zze(float f11) {
        return 4;
    }

    public static int zze(int i11, long j11) {
        return zzr(i11) + zzg(j11);
    }

    public static int zzg(int i11, long j11) {
        return zzr(i11) + zzg(zzk(j11));
    }

    public static int zzg(long j11) {
        int i11;
        if ((-128 & j11) == 0) {
            return 1;
        }
        if (j11 < 0) {
            return 10;
        }
        if ((-34359738368L & j11) != 0) {
            j11 >>>= 28;
            i11 = 6;
        } else {
            i11 = 2;
        }
        if ((-2097152 & j11) != 0) {
            i11 += 2;
            j11 >>>= 14;
        }
        return (j11 & -16384) != 0 ? i11 + 1 : i11;
    }

    public static int zzh(int i11, int i12) {
        return zzr(i11) + zzs(i12);
    }

    public static int zzi(int i11, int i12) {
        return zzr(i11) + zzt(i12);
    }

    public static int zzi(long j11) {
        return 8;
    }

    public static int zzj(int i11, int i12) {
        return zzr(i11) + zzt(zzy(i12));
    }

    public static int zzj(long j11) {
        return 8;
    }

    public static int zzk(int i11, int i12) {
        return zzr(i11) + 4;
    }

    private static long zzk(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public static int zzl(int i11, int i12) {
        return zzr(i11) + 4;
    }

    public static int zzm(int i11, int i12) {
        return zzr(i11) + zzs(i12);
    }

    public static int zzr(int i11) {
        return zzt(i11 << 3);
    }

    public static int zzs(int i11) {
        if (i11 >= 0) {
            return zzt(i11);
        }
        return 10;
    }

    public static int zzt(int i11) {
        if ((i11 & -128) == 0) {
            return 1;
        }
        if ((i11 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i11) == 0) {
            return 3;
        }
        return (i11 & -268435456) == 0 ? 4 : 5;
    }

    public static int zzu(int i11) {
        return zzt(zzy(i11));
    }

    public static int zzv(int i11) {
        return 4;
    }

    public static int zzw(int i11) {
        return 4;
    }

    public static int zzx(int i11) {
        return zzs(i11);
    }

    private static int zzy(int i11) {
        return (i11 >> 31) ^ (i11 << 1);
    }

    @Deprecated
    public static int zzz(int i11) {
        return zzt(i11);
    }

    public abstract int zzak();

    public final void zzb(int i11, float f11) throws IOException {
        zzg(i11, Float.floatToRawIntBits(f11));
    }

    public abstract void zzb(int i11, long j11) throws IOException;

    public abstract void zzb(int i11, zzck zzck) throws IOException;

    public abstract void zzb(int i11, zzck zzck, zzda zzda) throws IOException;

    public abstract void zzb(int i11, zzw zzw) throws IOException;

    public abstract void zzb(int i11, String str) throws IOException;

    public abstract void zzb(zzw zzw) throws IOException;

    public abstract void zzc(int i11, int i12) throws IOException;

    public abstract void zzc(int i11, zzw zzw) throws IOException;

    public abstract void zzc(int i11, boolean z11) throws IOException;

    public abstract void zzc(long j11) throws IOException;

    public abstract void zzc(zzck zzck) throws IOException;

    public abstract void zzd(byte b11) throws IOException;

    public abstract void zzd(int i11, int i12) throws IOException;

    public abstract void zzd(int i11, long j11) throws IOException;

    public final void zzd(long j11) throws IOException {
        zzc(zzk(j11));
    }

    public abstract void zze(int i11, int i12) throws IOException;

    public abstract void zze(long j11) throws IOException;

    public abstract void zze(byte[] bArr, int i11, int i12) throws IOException;

    public final void zzf(int i11, int i12) throws IOException {
        zze(i11, zzy(i12));
    }

    public abstract void zzg(int i11, int i12) throws IOException;

    public abstract void zzj(String str) throws IOException;

    public abstract void zzn(int i11) throws IOException;

    public abstract void zzo(int i11) throws IOException;

    public final void zzp(int i11) throws IOException {
        zzo(zzy(i11));
    }

    public abstract void zzq(int i11) throws IOException;

    public static int zzf(int i11, long j11) {
        return zzr(i11) + zzg(j11);
    }

    public static int zzh(int i11, long j11) {
        return zzr(i11) + 8;
    }

    public static int zzi(int i11, long j11) {
        return zzr(i11) + 8;
    }

    public static int zzk(String str) {
        int i11;
        try {
            i11 = zzea.zzb(str);
        } catch (zzee unused) {
            i11 = str.getBytes(zzbd.UTF_8).length;
        }
        return zzt(i11) + i11;
    }

    public final void zzb(int i11, double d11) throws IOException {
        zzd(i11, Double.doubleToRawLongBits(d11));
    }

    public final void zzd(float f11) throws IOException {
        zzq(Float.floatToRawIntBits(f11));
    }

    public static int zzd(int i11, boolean z11) {
        return zzr(i11) + 1;
    }

    public static int zze(int i11, zzw zzw) {
        return (zzr(1) << 1) + zzi(2, i11) + zzd(3, zzw);
    }

    public static int zzf(long j11) {
        return zzg(j11);
    }

    public static int zzh(long j11) {
        return zzg(zzk(j11));
    }

    public final void zzb(double d11) throws IOException {
        zze(Double.doubleToRawLongBits(d11));
    }

    public final void zzc(int i11, long j11) throws IOException {
        zzb(i11, zzk(j11));
    }

    public static int zzb(int i11, zzbp zzbp) {
        int zzr = zzr(i11);
        int zzbh = zzbp.zzbh();
        return zzr + zzt(zzbh) + zzbh;
    }

    public static int zzd(int i11, zzw zzw) {
        int zzr = zzr(i11);
        int size = zzw.size();
        return zzr + zzt(size) + size;
    }

    public final void zzc(boolean z11) throws IOException {
        zzd(z11 ? (byte) 1 : 0);
    }

    public static int zzc(int i11, float f11) {
        return zzr(i11) + 4;
    }

    public static int zzc(int i11, double d11) {
        return zzr(i11) + 8;
    }

    @Deprecated
    public static int zze(zzck zzck) {
        return zzck.zzbh();
    }

    public static int zzb(zzbp zzbp) {
        int zzbh = zzbp.zzbh();
        return zzt(zzbh) + zzbh;
    }

    public static int zzc(int i11, String str) {
        return zzr(i11) + zzk(str);
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        return zzt(length) + length;
    }

    public static int zzc(int i11, zzck zzck, zzda zzda) {
        return zzr(i11) + zzb(zzck, zzda);
    }

    public static int zzb(zzck zzck, zzda zzda) {
        zzm zzm = (zzm) zzck;
        int zzw = zzm.zzw();
        if (zzw == -1) {
            zzw = zzda.zzn(zzm);
            zzm.zze(zzw);
        }
        return zzt(zzw) + zzw;
    }

    public static int zzc(int i11, zzck zzck) {
        return (zzr(1) << 1) + zzi(2, i11) + zzr(3) + zzd(zzck);
    }

    public static int zzd(zzck zzck) {
        int zzbh = zzck.zzbh();
        return zzt(zzbh) + zzbh;
    }

    @Deprecated
    public static int zzd(int i11, zzck zzck, zzda zzda) {
        int zzr = zzr(i11) << 1;
        zzm zzm = (zzm) zzck;
        int zzw = zzm.zzw();
        if (zzw == -1) {
            zzw = zzda.zzn(zzm);
            zzm.zze(zzw);
        }
        return zzr + zzw;
    }

    public static int zzc(int i11, zzbp zzbp) {
        return (zzr(1) << 1) + zzi(2, i11) + zzb(3, zzbp);
    }

    public final void zzb(String str, zzee zzee) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzee);
        byte[] bytes = str.getBytes(zzbd.UTF_8);
        try {
            zzo(bytes.length);
            zzb(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzc(e11);
        } catch (zzc e12) {
            throw e12;
        }
    }

    public static int zzc(zzw zzw) {
        int size = zzw.size();
        return zzt(size) + size;
    }
}
