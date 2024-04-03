package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzga extends zzfi {
    private static final Logger logger = Logger.getLogger(zzga.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzsr = zzjp.zzij();
    zzgc zzss;

    public static class zza extends IOException {
        public zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zza(Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public zza(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzga.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzga() {
    }

    private static long zzaa(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public static int zzb(double d11) {
        return 8;
    }

    public static int zzba(int i11) {
        return zzbc(i11 << 3);
    }

    public static int zzbb(int i11) {
        if (i11 >= 0) {
            return zzbc(i11);
        }
        return 10;
    }

    public static int zzbc(int i11) {
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

    public static int zzbd(int i11) {
        return zzbc(zzbh(i11));
    }

    public static int zzbe(int i11) {
        return 4;
    }

    public static int zzbf(int i11) {
        return 4;
    }

    public static int zzbg(int i11) {
        return zzbb(i11);
    }

    private static int zzbh(int i11) {
        return (i11 >> 31) ^ (i11 << 1);
    }

    @Deprecated
    public static int zzbi(int i11) {
        return zzbc(i11);
    }

    public static int zzc(int i11, zzfh zzfh) {
        int zzba = zzba(i11);
        int size = zzfh.size();
        return zzba + zzbc(size) + size;
    }

    public static int zzd(int i11, long j11) {
        return zzba(i11) + zzw(j11);
    }

    public static zzga zze(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzf(int i11, long j11) {
        return zzba(i11) + zzw(zzaa(j11));
    }

    public static int zzg(int i11, long j11) {
        return zzba(i11) + 8;
    }

    public static int zzh(int i11, long j11) {
        return zzba(i11) + 8;
    }

    public static int zzl(int i11, int i12) {
        return zzba(i11) + zzbb(i12);
    }

    public static int zzl(boolean z11) {
        return 1;
    }

    public static int zzm(int i11, int i12) {
        return zzba(i11) + zzbc(i12);
    }

    public static int zzn(int i11, int i12) {
        return zzba(i11) + zzbc(zzbh(i12));
    }

    public static int zzo(int i11, int i12) {
        return zzba(i11) + 4;
    }

    public static int zzp(int i11, int i12) {
        return zzba(i11) + 4;
    }

    public static int zzq(int i11, int i12) {
        return zzba(i11) + zzbb(i12);
    }

    public static int zzt(float f11) {
        return 4;
    }

    public static int zzv(long j11) {
        return zzw(j11);
    }

    public static int zzw(long j11) {
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

    public static int zzx(long j11) {
        return zzw(zzaa(j11));
    }

    public static int zzy(long j11) {
        return 8;
    }

    public static int zzy(String str) {
        int i11;
        try {
            i11 = zzjs.zza(str);
        } catch (zzjv unused) {
            i11 = str.getBytes(zzgt.UTF_8).length;
        }
        return zzbc(i11) + i11;
    }

    public static int zzz(long j11) {
        return 8;
    }

    public final void zza(int i11, float f11) throws IOException {
        zzk(i11, Float.floatToRawIntBits(f11));
    }

    public abstract void zza(int i11, long j11) throws IOException;

    public abstract void zza(int i11, zzfh zzfh) throws IOException;

    public abstract void zza(int i11, zzic zzic) throws IOException;

    public abstract void zza(int i11, zzic zzic, zzir zzir) throws IOException;

    public abstract void zza(int i11, String str) throws IOException;

    public abstract void zza(int i11, boolean z11) throws IOException;

    public abstract void zza(zzfh zzfh) throws IOException;

    public abstract void zzaw(int i11) throws IOException;

    public abstract void zzax(int i11) throws IOException;

    public final void zzay(int i11) throws IOException {
        zzax(zzbh(i11));
    }

    public abstract void zzaz(int i11) throws IOException;

    public final void zzb(int i11, long j11) throws IOException {
        zza(i11, zzaa(j11));
    }

    public abstract void zzb(int i11, zzfh zzfh) throws IOException;

    public abstract void zzb(zzic zzic) throws IOException;

    public abstract void zzc(byte b11) throws IOException;

    public abstract void zzc(int i11, long j11) throws IOException;

    public abstract void zze(byte[] bArr, int i11, int i12) throws IOException;

    public abstract int zzfg();

    public final void zzfh() {
        if (zzfg() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzg(int i11, int i12) throws IOException;

    public abstract void zzh(int i11, int i12) throws IOException;

    public abstract void zzi(int i11, int i12) throws IOException;

    public final void zzj(int i11, int i12) throws IOException {
        zzi(i11, zzbh(i12));
    }

    public abstract void zzk(int i11, int i12) throws IOException;

    public final void zzk(boolean z11) throws IOException {
        zzc(z11 ? (byte) 1 : 0);
    }

    public final void zzs(float f11) throws IOException {
        zzaz(Float.floatToRawIntBits(f11));
    }

    public abstract void zzs(long j11) throws IOException;

    public final void zzt(long j11) throws IOException {
        zzs(zzaa(j11));
    }

    public abstract void zzu(long j11) throws IOException;

    public abstract void zzx(String str) throws IOException;

    public static class zzb extends zzga {
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
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i12)}), e11);
            }
        }

        public final void zza(int i11, long j11) throws IOException {
            zzg(i11, 0);
            zzs(j11);
        }

        public final void zzaw(int i11) throws IOException {
            if (i11 >= 0) {
                zzax(i11);
            } else {
                zzs((long) i11);
            }
        }

        public final void zzax(int i11) throws IOException {
            if (!zzga.zzsr || zzfa.zzdr() || zzfg() < 5) {
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
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
                }
            } else if ((i11 & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzjp.zza(bArr3, (long) i14, (byte) i11);
            } else {
                byte[] bArr4 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzjp.zza(bArr4, (long) i15, (byte) (i11 | 128));
                int i16 = i11 >>> 7;
                if ((i16 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i17 = this.position;
                    this.position = i17 + 1;
                    zzjp.zza(bArr5, (long) i17, (byte) i16);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i18 = this.position;
                this.position = i18 + 1;
                zzjp.zza(bArr6, (long) i18, (byte) (i16 | 128));
                int i19 = i16 >>> 7;
                if ((i19 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i21 = this.position;
                    this.position = i21 + 1;
                    zzjp.zza(bArr7, (long) i21, (byte) i19);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i22 = this.position;
                this.position = i22 + 1;
                zzjp.zza(bArr8, (long) i22, (byte) (i19 | 128));
                int i23 = i19 >>> 7;
                if ((i23 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i24 = this.position;
                    this.position = i24 + 1;
                    zzjp.zza(bArr9, (long) i24, (byte) i23);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i25 = this.position;
                this.position = i25 + 1;
                zzjp.zza(bArr10, (long) i25, (byte) (i23 | 128));
                byte[] bArr11 = this.buffer;
                int i26 = this.position;
                this.position = i26 + 1;
                zzjp.zza(bArr11, (long) i26, (byte) (i23 >>> 7));
            }
        }

        public final void zzaz(int i11) throws IOException {
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
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void zzb(int i11, zzfh zzfh) throws IOException {
            zzg(1, 3);
            zzi(2, i11);
            zza(3, zzfh);
            zzg(1, 4);
        }

        public final void zzc(int i11, long j11) throws IOException {
            zzg(i11, 1);
            zzu(j11);
        }

        public final void zze(byte[] bArr, int i11, int i12) throws IOException {
            zzax(i12);
            write(bArr, 0, i12);
        }

        public final int zzfg() {
            return this.limit - this.position;
        }

        public final void zzg(int i11, int i12) throws IOException {
            zzax((i11 << 3) | i12);
        }

        public final void zzh(int i11, int i12) throws IOException {
            zzg(i11, 0);
            zzaw(i12);
        }

        public final void zzi(int i11, int i12) throws IOException {
            zzg(i11, 0);
            zzax(i12);
        }

        public final void zzk(int i11, int i12) throws IOException {
            zzg(i11, 5);
            zzaz(i12);
        }

        public final void zzs(long j11) throws IOException {
            if (!zzga.zzsr || zzfg() < 10) {
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
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
                }
            } else {
                while ((j11 & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzjp.zza(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzjp.zza(bArr4, (long) i14, (byte) ((int) j11));
            }
        }

        public final void zzu(long j11) throws IOException {
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
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void zzx(String str) throws IOException {
            int i11 = this.position;
            try {
                int zzbc = zzga.zzbc(str.length() * 3);
                int zzbc2 = zzga.zzbc(str.length());
                if (zzbc2 == zzbc) {
                    int i12 = i11 + zzbc2;
                    this.position = i12;
                    int zza = zzjs.zza(str, this.buffer, i12, zzfg());
                    this.position = i11;
                    zzax((zza - i11) - zzbc2);
                    this.position = zza;
                    return;
                }
                zzax(zzjs.zza(str));
                this.position = zzjs.zza(str, this.buffer, this.position, zzfg());
            } catch (zzjv e11) {
                this.position = i11;
                zza(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new zza(e12);
            }
        }

        public final void zza(int i11, boolean z11) throws IOException {
            zzg(i11, 0);
            zzc(z11 ? (byte) 1 : 0);
        }

        public final void zzc(byte b11) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                bArr[i11] = b11;
            } catch (IndexOutOfBoundsException e11) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void zza(int i11, String str) throws IOException {
            zzg(i11, 2);
            zzx(str);
        }

        public final void zzb(zzic zzic) throws IOException {
            zzax(zzic.zzgf());
            zzic.zzb(this);
        }

        public final void zzc(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }

        public final void zza(int i11, zzfh zzfh) throws IOException {
            zzg(i11, 2);
            zza(zzfh);
        }

        public final void zza(zzfh zzfh) throws IOException {
            zzax(zzfh.size());
            zzfh.zza((zzfi) this);
        }

        public final void zza(int i11, zzic zzic, zzir zzir) throws IOException {
            zzg(i11, 2);
            zzet zzet = (zzet) zzic;
            int zzdl = zzet.zzdl();
            if (zzdl == -1) {
                zzdl = zzir.zzr(zzet);
                zzet.zzad(zzdl);
            }
            zzax(zzdl);
            zzir.zza(zzic, this.zzss);
        }

        public final void zza(int i11, zzic zzic) throws IOException {
            zzg(1, 3);
            zzi(2, i11);
            zzg(3, 2);
            zzb(zzic);
            zzg(1, 4);
        }
    }

    public static int zzb(int i11, float f11) {
        return zzba(i11) + 4;
    }

    public final void zza(int i11, double d11) throws IOException {
        zzc(i11, Double.doubleToRawLongBits(d11));
    }

    public static int zzb(int i11, double d11) {
        return zzba(i11) + 8;
    }

    public static int zzd(int i11, zzfh zzfh) {
        return (zzba(1) << 1) + zzm(2, i11) + zzc(3, zzfh);
    }

    public static int zze(int i11, long j11) {
        return zzba(i11) + zzw(j11);
    }

    public static int zzf(byte[] bArr) {
        int length = bArr.length;
        return zzbc(length) + length;
    }

    public final void zza(double d11) throws IOException {
        zzu(Double.doubleToRawLongBits(d11));
    }

    public static int zza(int i11, zzhh zzhh) {
        int zzba = zzba(i11);
        int zzgf = zzhh.zzgf();
        return zzba + zzbc(zzgf) + zzgf;
    }

    public static int zzb(int i11, boolean z11) {
        return zzba(i11) + 1;
    }

    public static int zzc(zzic zzic) {
        int zzgf = zzic.zzgf();
        return zzbc(zzgf) + zzgf;
    }

    public static int zzb(int i11, String str) {
        return zzba(i11) + zzy(str);
    }

    public static int zzb(int i11, zzic zzic, zzir zzir) {
        return zzba(i11) + zza(zzic, zzir);
    }

    @Deprecated
    public static int zzc(int i11, zzic zzic, zzir zzir) {
        int zzba = zzba(i11) << 1;
        zzet zzet = (zzet) zzic;
        int zzdl = zzet.zzdl();
        if (zzdl == -1) {
            zzdl = zzir.zzr(zzet);
            zzet.zzad(zzdl);
        }
        return zzba + zzdl;
    }

    @Deprecated
    public static int zzd(zzic zzic) {
        return zzic.zzgf();
    }

    public static int zza(zzhh zzhh) {
        int zzgf = zzhh.zzgf();
        return zzbc(zzgf) + zzgf;
    }

    public static int zzb(int i11, zzic zzic) {
        return (zzba(1) << 1) + zzm(2, i11) + zzba(3) + zzc(zzic);
    }

    public static int zza(zzic zzic, zzir zzir) {
        zzet zzet = (zzet) zzic;
        int zzdl = zzet.zzdl();
        if (zzdl == -1) {
            zzdl = zzir.zzr(zzet);
            zzet.zzad(zzdl);
        }
        return zzbc(zzdl) + zzdl;
    }

    public static int zzb(int i11, zzhh zzhh) {
        return (zzba(1) << 1) + zzm(2, i11) + zza(3, zzhh);
    }

    public static int zzb(zzfh zzfh) {
        int size = zzfh.size();
        return zzbc(size) + size;
    }

    public final void zza(String str, zzjv zzjv) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzjv);
        byte[] bytes = str.getBytes(zzgt.UTF_8);
        try {
            zzax(bytes.length);
            zzc(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zza(e11);
        } catch (zza e12) {
            throw e12;
        }
    }
}
