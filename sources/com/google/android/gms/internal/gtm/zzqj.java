package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzqj extends zzpr {
    private static final Logger logger = Logger.getLogger(zzqj.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzawt = zztx.zzrm();
    zzql zzawu;

    public static final class zzb extends zza {
        private final ByteBuffer zzawv;
        private int zzaww;

        public zzb(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzawv = byteBuffer;
            this.zzaww = byteBuffer.position();
        }

        public final void flush() {
            this.zzawv.position(this.zzaww + zzok());
        }
    }

    public static class zzc extends IOException {
        public zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public zzc(java.lang.String r3) {
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
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqj.zzc.<init>(java.lang.String):void");
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqj.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzqj() {
    }

    public static zzqj zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzb(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (zztx.zzrn()) {
            return new zze(byteBuffer);
        } else {
            return new zzd(byteBuffer);
        }
    }

    public static int zzb(float f11) {
        return 4;
    }

    public static int zzbb(int i11) {
        return zzbd(i11 << 3);
    }

    public static int zzbc(int i11) {
        if (i11 >= 0) {
            return zzbd(i11);
        }
        return 10;
    }

    public static int zzbd(int i11) {
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

    public static int zzbe(int i11) {
        return zzbd(zzbi(i11));
    }

    public static int zzbf(int i11) {
        return 4;
    }

    public static int zzbg(int i11) {
        return 4;
    }

    public static int zzbh(int i11) {
        return zzbc(i11);
    }

    private static int zzbi(int i11) {
        return (i11 >> 31) ^ (i11 << 1);
    }

    @Deprecated
    public static int zzbj(int i11) {
        return zzbd(i11);
    }

    public static int zzc(double d11) {
        return 8;
    }

    public static int zzc(int i11, boolean z11) {
        return zzbb(i11) + 1;
    }

    public static int zzd(int i11, long j11) {
        return zzbb(i11) + zzt(j11);
    }

    public static int zzda(String str) {
        int i11;
        try {
            i11 = zztz.zza(str);
        } catch (zzud unused) {
            i11 = str.getBytes(zzre.UTF_8).length;
        }
        return zzbd(i11) + i11;
    }

    public static int zze(int i11, long j11) {
        return zzbb(i11) + zzt(j11);
    }

    public static int zzf(int i11, long j11) {
        return zzbb(i11) + zzt(zzx(j11));
    }

    public static zzqj zzg(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzh(int i11, long j11) {
        return zzbb(i11) + 8;
    }

    public static int zzj(int i11, int i12) {
        return zzbb(i11) + zzbd(i12);
    }

    public static int zzj(boolean z11) {
        return 1;
    }

    public static int zzk(int i11, int i12) {
        return zzbb(i11) + zzbd(zzbi(i12));
    }

    public static int zzl(int i11, int i12) {
        return zzbb(i11) + 4;
    }

    public static int zzm(int i11, int i12) {
        return zzbb(i11) + 4;
    }

    public static int zzn(int i11, int i12) {
        return zzbb(i11) + zzbc(i12);
    }

    public static int zzs(long j11) {
        return zzt(j11);
    }

    public static int zzt(long j11) {
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

    public static int zzu(long j11) {
        return zzt(zzx(j11));
    }

    public static int zzv(long j11) {
        return 8;
    }

    public static int zzw(long j11) {
        return 8;
    }

    private static long zzx(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void zza(int i11, long j11) throws IOException;

    public abstract void zza(int i11, zzps zzps) throws IOException;

    public abstract void zza(int i11, zzsk zzsk) throws IOException;

    public abstract void zza(int i11, zzsk zzsk, zzsz zzsz) throws IOException;

    public abstract void zza(int i11, String str) throws IOException;

    public abstract void zza(zzps zzps) throws IOException;

    public abstract void zza(zzsk zzsk, zzsz zzsz) throws IOException;

    public abstract void zzax(int i11) throws IOException;

    public abstract void zzay(int i11) throws IOException;

    public final void zzaz(int i11) throws IOException {
        zzay(zzbi(i11));
    }

    public final void zzb(int i11, long j11) throws IOException {
        zza(i11, zzx(j11));
    }

    public abstract void zzb(int i11, zzps zzps) throws IOException;

    public abstract void zzb(int i11, zzsk zzsk) throws IOException;

    public abstract void zzb(int i11, boolean z11) throws IOException;

    public abstract void zzb(zzsk zzsk) throws IOException;

    public abstract void zzba(int i11) throws IOException;

    public abstract void zzc(byte b11) throws IOException;

    public abstract void zzc(int i11, long j11) throws IOException;

    public abstract void zzcz(String str) throws IOException;

    public abstract void zzd(int i11, int i12) throws IOException;

    public abstract void zze(int i11, int i12) throws IOException;

    public abstract void zze(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void zzf(int i11, int i12) throws IOException;

    public abstract void zzh(int i11, int i12) throws IOException;

    public final void zzi(boolean z11) throws IOException {
        zzc(z11 ? (byte) 1 : 0);
    }

    public abstract int zzoi();

    public abstract void zzp(long j11) throws IOException;

    public final void zzq(long j11) throws IOException {
        zzp(zzx(j11));
    }

    public abstract void zzr(long j11) throws IOException;

    public static class zza extends zzqj {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public zza(byte[] bArr, int i11, int i12) {
            super();
            if (bArr != null) {
                int i13 = i11 + i12;
                if ((i11 | i12 | (bArr.length - i13)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i11;
                    this.position = i11;
                    this.limit = i13;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final void write(byte[] bArr, int i11, int i12) throws IOException {
            try {
                System.arraycopy(bArr, i11, this.buffer, this.position, i12);
                this.position += i12;
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i12)}), e11);
            }
        }

        public final void zza(int i11, long j11) throws IOException {
            zzd(i11, 0);
            zzp(j11);
        }

        public final void zzax(int i11) throws IOException {
            if (i11 >= 0) {
                zzay(i11);
            } else {
                zzp((long) i11);
            }
        }

        public final void zzay(int i11) throws IOException {
            if (!zzqj.zzawt || zzpp.zzna() || zzoi() < 5) {
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
                zztx.zza(bArr3, (long) i14, (byte) i11);
            } else {
                byte[] bArr4 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zztx.zza(bArr4, (long) i15, (byte) (i11 | 128));
                int i16 = i11 >>> 7;
                if ((i16 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i17 = this.position;
                    this.position = i17 + 1;
                    zztx.zza(bArr5, (long) i17, (byte) i16);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i18 = this.position;
                this.position = i18 + 1;
                zztx.zza(bArr6, (long) i18, (byte) (i16 | 128));
                int i19 = i16 >>> 7;
                if ((i19 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i21 = this.position;
                    this.position = i21 + 1;
                    zztx.zza(bArr7, (long) i21, (byte) i19);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i22 = this.position;
                this.position = i22 + 1;
                zztx.zza(bArr8, (long) i22, (byte) (i19 | 128));
                int i23 = i19 >>> 7;
                if ((i23 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i24 = this.position;
                    this.position = i24 + 1;
                    zztx.zza(bArr9, (long) i24, (byte) i23);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i25 = this.position;
                this.position = i25 + 1;
                zztx.zza(bArr10, (long) i25, (byte) (i23 | 128));
                byte[] bArr11 = this.buffer;
                int i26 = this.position;
                this.position = i26 + 1;
                zztx.zza(bArr11, (long) i26, (byte) (i23 >>> 7));
            }
        }

        public final void zzb(int i11, boolean z11) throws IOException {
            zzd(i11, 0);
            zzc(z11 ? (byte) 1 : 0);
        }

        public final void zzba(int i11) throws IOException {
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

        public final void zzc(int i11, long j11) throws IOException {
            zzd(i11, 1);
            zzr(j11);
        }

        public final void zzcz(String str) throws IOException {
            int i11 = this.position;
            try {
                int zzbd = zzqj.zzbd(str.length() * 3);
                int zzbd2 = zzqj.zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int i12 = i11 + zzbd2;
                    this.position = i12;
                    int zza = zztz.zza(str, this.buffer, i12, zzoi());
                    this.position = i11;
                    zzay((zza - i11) - zzbd2);
                    this.position = zza;
                    return;
                }
                zzay(zztz.zza(str));
                this.position = zztz.zza(str, this.buffer, this.position, zzoi());
            } catch (zzud e11) {
                this.position = i11;
                zza(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new zzc((Throwable) e12);
            }
        }

        public final void zzd(int i11, int i12) throws IOException {
            zzay((i11 << 3) | i12);
        }

        public final void zze(int i11, int i12) throws IOException {
            zzd(i11, 0);
            zzax(i12);
        }

        public final void zzf(int i11, int i12) throws IOException {
            zzd(i11, 0);
            zzay(i12);
        }

        public final void zzh(int i11, int i12) throws IOException {
            zzd(i11, 5);
            zzba(i12);
        }

        public final int zzoi() {
            return this.limit - this.position;
        }

        public final int zzok() {
            return this.position - this.offset;
        }

        public final void zzp(long j11) throws IOException {
            if (!zzqj.zzawt || zzoi() < 10) {
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
                    zztx.zza(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zztx.zza(bArr4, (long) i14, (byte) ((int) j11));
            }
        }

        public final void zzr(long j11) throws IOException {
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

        public final void zza(int i11, String str) throws IOException {
            zzd(i11, 2);
            zzcz(str);
        }

        public final void zzb(int i11, zzsk zzsk) throws IOException {
            zzd(1, 3);
            zzf(2, i11);
            zza(3, zzsk);
            zzd(1, 4);
        }

        public final void zzc(byte b11) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                bArr[i11] = b11;
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void zze(byte[] bArr, int i11, int i12) throws IOException {
            zzay(i12);
            write(bArr, 0, i12);
        }

        public final void zza(int i11, zzps zzps) throws IOException {
            zzd(i11, 2);
            zza(zzps);
        }

        public final void zza(zzps zzps) throws IOException {
            zzay(zzps.size());
            zzps.zza((zzpr) this);
        }

        public final void zzb(int i11, zzps zzps) throws IOException {
            zzd(1, 3);
            zzf(2, i11);
            zza(3, zzps);
            zzd(1, 4);
        }

        public final void zza(int i11, zzsk zzsk) throws IOException {
            zzd(i11, 2);
            zzb(zzsk);
        }

        public final void zza(int i11, zzsk zzsk, zzsz zzsz) throws IOException {
            zzd(i11, 2);
            zzpl zzpl = (zzpl) zzsk;
            int zzmw = zzpl.zzmw();
            if (zzmw == -1) {
                zzmw = zzsz.zzad(zzpl);
                zzpl.zzag(zzmw);
            }
            zzay(zzmw);
            zzsz.zza(zzsk, this.zzawu);
        }

        public final void zzb(zzsk zzsk) throws IOException {
            zzay(zzsk.zzpe());
            zzsk.zzb(this);
        }

        public final void zza(zzsk zzsk, zzsz zzsz) throws IOException {
            zzpl zzpl = (zzpl) zzsk;
            int zzmw = zzpl.zzmw();
            if (zzmw == -1) {
                zzmw = zzsz.zzad(zzpl);
                zzpl.zzag(zzmw);
            }
            zzay(zzmw);
            zzsz.zza(zzsk, this.zzawu);
        }

        public final void zza(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }
    }

    public static final class zzd extends zzqj {
        private final int zzaww;
        private final ByteBuffer zzawx;
        private final ByteBuffer zzawy;

        public zzd(ByteBuffer byteBuffer) {
            super();
            this.zzawx = byteBuffer;
            this.zzawy = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzaww = byteBuffer.position();
        }

        private final void zzdb(String str) throws IOException {
            try {
                zztz.zza(str, this.zzawy);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void flush() {
            this.zzawx.position(this.zzawy.position());
        }

        public final void write(byte[] bArr, int i11, int i12) throws IOException {
            try {
                this.zzawy.put(bArr, i11, i12);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc((Throwable) e11);
            } catch (BufferOverflowException e12) {
                throw new zzc((Throwable) e12);
            }
        }

        public final void zza(int i11, long j11) throws IOException {
            zzd(i11, 0);
            zzp(j11);
        }

        public final void zzax(int i11) throws IOException {
            if (i11 >= 0) {
                zzay(i11);
            } else {
                zzp((long) i11);
            }
        }

        public final void zzay(int i11) throws IOException {
            while ((i11 & -128) != 0) {
                this.zzawy.put((byte) ((i11 & 127) | 128));
                i11 >>>= 7;
            }
            try {
                this.zzawy.put((byte) i11);
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void zzb(int i11, boolean z11) throws IOException {
            zzd(i11, 0);
            zzc(z11 ? (byte) 1 : 0);
        }

        public final void zzba(int i11) throws IOException {
            try {
                this.zzawy.putInt(i11);
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void zzc(int i11, long j11) throws IOException {
            zzd(i11, 1);
            zzr(j11);
        }

        public final void zzcz(String str) throws IOException {
            int position = this.zzawy.position();
            try {
                int zzbd = zzqj.zzbd(str.length() * 3);
                int zzbd2 = zzqj.zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int position2 = this.zzawy.position() + zzbd2;
                    this.zzawy.position(position2);
                    zzdb(str);
                    int position3 = this.zzawy.position();
                    this.zzawy.position(position);
                    zzay(position3 - position2);
                    this.zzawy.position(position3);
                    return;
                }
                zzay(zztz.zza(str));
                zzdb(str);
            } catch (zzud e11) {
                this.zzawy.position(position);
                zza(str, e11);
            } catch (IllegalArgumentException e12) {
                throw new zzc((Throwable) e12);
            }
        }

        public final void zzd(int i11, int i12) throws IOException {
            zzay((i11 << 3) | i12);
        }

        public final void zze(int i11, int i12) throws IOException {
            zzd(i11, 0);
            zzax(i12);
        }

        public final void zzf(int i11, int i12) throws IOException {
            zzd(i11, 0);
            zzay(i12);
        }

        public final void zzh(int i11, int i12) throws IOException {
            zzd(i11, 5);
            zzba(i12);
        }

        public final int zzoi() {
            return this.zzawy.remaining();
        }

        public final void zzp(long j11) throws IOException {
            while ((-128 & j11) != 0) {
                this.zzawy.put((byte) ((((int) j11) & 127) | 128));
                j11 >>>= 7;
            }
            try {
                this.zzawy.put((byte) ((int) j11));
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void zzr(long j11) throws IOException {
            try {
                this.zzawy.putLong(j11);
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void zza(int i11, String str) throws IOException {
            zzd(i11, 2);
            zzcz(str);
        }

        public final void zzb(int i11, zzsk zzsk) throws IOException {
            zzd(1, 3);
            zzf(2, i11);
            zza(3, zzsk);
            zzd(1, 4);
        }

        public final void zzc(byte b11) throws IOException {
            try {
                this.zzawy.put(b11);
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void zze(byte[] bArr, int i11, int i12) throws IOException {
            zzay(i12);
            write(bArr, 0, i12);
        }

        public final void zza(int i11, zzps zzps) throws IOException {
            zzd(i11, 2);
            zza(zzps);
        }

        public final void zza(int i11, zzsk zzsk) throws IOException {
            zzd(i11, 2);
            zzb(zzsk);
        }

        public final void zzb(int i11, zzps zzps) throws IOException {
            zzd(1, 3);
            zzf(2, i11);
            zza(3, zzps);
            zzd(1, 4);
        }

        public final void zza(int i11, zzsk zzsk, zzsz zzsz) throws IOException {
            zzd(i11, 2);
            zza(zzsk, zzsz);
        }

        public final void zza(zzsk zzsk, zzsz zzsz) throws IOException {
            zzpl zzpl = (zzpl) zzsk;
            int zzmw = zzpl.zzmw();
            if (zzmw == -1) {
                zzmw = zzsz.zzad(zzpl);
                zzpl.zzag(zzmw);
            }
            zzay(zzmw);
            zzsz.zza(zzsk, this.zzawu);
        }

        public final void zzb(zzsk zzsk) throws IOException {
            zzay(zzsk.zzpe());
            zzsk.zzb(this);
        }

        public final void zza(zzps zzps) throws IOException {
            zzay(zzps.size());
            zzps.zza((zzpr) this);
        }

        public final void zza(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }
    }

    public static final class zze extends zzqj {
        private final ByteBuffer zzawx;
        private final ByteBuffer zzawy;
        private final long zzawz;
        private final long zzaxa;
        private final long zzaxb;
        private final long zzaxc;
        private long zzaxd;

        public zze(ByteBuffer byteBuffer) {
            super();
            this.zzawx = byteBuffer;
            this.zzawy = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long zzb = zztx.zzb(byteBuffer);
            this.zzawz = zzb;
            long position = ((long) byteBuffer.position()) + zzb;
            this.zzaxa = position;
            long limit = zzb + ((long) byteBuffer.limit());
            this.zzaxb = limit;
            this.zzaxc = limit - 10;
            this.zzaxd = position;
        }

        private final void zzy(long j11) {
            this.zzawy.position((int) (j11 - this.zzawz));
        }

        public final void flush() {
            this.zzawx.position((int) (this.zzaxd - this.zzawz));
        }

        public final void write(byte[] bArr, int i11, int i12) throws IOException {
            if (bArr != null && i11 >= 0 && i12 >= 0 && bArr.length - i12 >= i11) {
                long j11 = (long) i12;
                long j12 = this.zzaxd;
                if (this.zzaxb - j11 >= j12) {
                    zztx.zza(bArr, (long) i11, j12, j11);
                    this.zzaxd += j11;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzaxd), Long.valueOf(this.zzaxb), Integer.valueOf(i12)}));
        }

        public final void zza(int i11, long j11) throws IOException {
            zzd(i11, 0);
            zzp(j11);
        }

        public final void zzax(int i11) throws IOException {
            if (i11 >= 0) {
                zzay(i11);
            } else {
                zzp((long) i11);
            }
        }

        public final void zzay(int i11) throws IOException {
            if (this.zzaxd <= this.zzaxc) {
                while ((i11 & -128) != 0) {
                    long j11 = this.zzaxd;
                    this.zzaxd = j11 + 1;
                    zztx.zza(j11, (byte) ((i11 & 127) | 128));
                    i11 >>>= 7;
                }
                long j12 = this.zzaxd;
                this.zzaxd = 1 + j12;
                zztx.zza(j12, (byte) i11);
                return;
            }
            while (true) {
                long j13 = this.zzaxd;
                if (j13 >= this.zzaxb) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzaxd), Long.valueOf(this.zzaxb), 1}));
                } else if ((i11 & -128) == 0) {
                    this.zzaxd = 1 + j13;
                    zztx.zza(j13, (byte) i11);
                    return;
                } else {
                    this.zzaxd = j13 + 1;
                    zztx.zza(j13, (byte) ((i11 & 127) | 128));
                    i11 >>>= 7;
                }
            }
        }

        public final void zzb(int i11, boolean z11) throws IOException {
            zzd(i11, 0);
            zzc(z11 ? (byte) 1 : 0);
        }

        public final void zzba(int i11) throws IOException {
            this.zzawy.putInt((int) (this.zzaxd - this.zzawz), i11);
            this.zzaxd += 4;
        }

        public final void zzc(int i11, long j11) throws IOException {
            zzd(i11, 1);
            zzr(j11);
        }

        public final void zzcz(String str) throws IOException {
            long j11 = this.zzaxd;
            try {
                int zzbd = zzqj.zzbd(str.length() * 3);
                int zzbd2 = zzqj.zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int i11 = ((int) (this.zzaxd - this.zzawz)) + zzbd2;
                    this.zzawy.position(i11);
                    zztz.zza(str, this.zzawy);
                    int position = this.zzawy.position() - i11;
                    zzay(position);
                    this.zzaxd += (long) position;
                    return;
                }
                int zza = zztz.zza(str);
                zzay(zza);
                zzy(this.zzaxd);
                zztz.zza(str, this.zzawy);
                this.zzaxd += (long) zza;
            } catch (zzud e11) {
                this.zzaxd = j11;
                zzy(j11);
                zza(str, e11);
            } catch (IllegalArgumentException e12) {
                throw new zzc((Throwable) e12);
            } catch (IndexOutOfBoundsException e13) {
                throw new zzc((Throwable) e13);
            }
        }

        public final void zzd(int i11, int i12) throws IOException {
            zzay((i11 << 3) | i12);
        }

        public final void zze(int i11, int i12) throws IOException {
            zzd(i11, 0);
            zzax(i12);
        }

        public final void zzf(int i11, int i12) throws IOException {
            zzd(i11, 0);
            zzay(i12);
        }

        public final void zzh(int i11, int i12) throws IOException {
            zzd(i11, 5);
            zzba(i12);
        }

        public final int zzoi() {
            return (int) (this.zzaxb - this.zzaxd);
        }

        public final void zzp(long j11) throws IOException {
            if (this.zzaxd <= this.zzaxc) {
                while ((j11 & -128) != 0) {
                    long j12 = this.zzaxd;
                    this.zzaxd = j12 + 1;
                    zztx.zza(j12, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                long j13 = this.zzaxd;
                this.zzaxd = 1 + j13;
                zztx.zza(j13, (byte) ((int) j11));
                return;
            }
            while (true) {
                long j14 = this.zzaxd;
                if (j14 >= this.zzaxb) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzaxd), Long.valueOf(this.zzaxb), 1}));
                } else if ((j11 & -128) == 0) {
                    this.zzaxd = 1 + j14;
                    zztx.zza(j14, (byte) ((int) j11));
                    return;
                } else {
                    this.zzaxd = j14 + 1;
                    zztx.zza(j14, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
            }
        }

        public final void zzr(long j11) throws IOException {
            this.zzawy.putLong((int) (this.zzaxd - this.zzawz), j11);
            this.zzaxd += 8;
        }

        public final void zza(int i11, String str) throws IOException {
            zzd(i11, 2);
            zzcz(str);
        }

        public final void zzb(int i11, zzsk zzsk) throws IOException {
            zzd(1, 3);
            zzf(2, i11);
            zza(3, zzsk);
            zzd(1, 4);
        }

        public final void zzc(byte b11) throws IOException {
            long j11 = this.zzaxd;
            if (j11 < this.zzaxb) {
                this.zzaxd = 1 + j11;
                zztx.zza(j11, b11);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzaxd), Long.valueOf(this.zzaxb), 1}));
        }

        public final void zze(byte[] bArr, int i11, int i12) throws IOException {
            zzay(i12);
            write(bArr, 0, i12);
        }

        public final void zza(int i11, zzps zzps) throws IOException {
            zzd(i11, 2);
            zza(zzps);
        }

        public final void zza(int i11, zzsk zzsk) throws IOException {
            zzd(i11, 2);
            zzb(zzsk);
        }

        public final void zzb(int i11, zzps zzps) throws IOException {
            zzd(1, 3);
            zzf(2, i11);
            zza(3, zzps);
            zzd(1, 4);
        }

        public final void zza(int i11, zzsk zzsk, zzsz zzsz) throws IOException {
            zzd(i11, 2);
            zza(zzsk, zzsz);
        }

        public final void zza(zzsk zzsk, zzsz zzsz) throws IOException {
            zzpl zzpl = (zzpl) zzsk;
            int zzmw = zzpl.zzmw();
            if (zzmw == -1) {
                zzmw = zzsz.zzad(zzpl);
                zzpl.zzag(zzmw);
            }
            zzay(zzmw);
            zzsz.zza(zzsk, this.zzawu);
        }

        public final void zzb(zzsk zzsk) throws IOException {
            zzay(zzsk.zzpe());
            zzsk.zzb(this);
        }

        public final void zza(zzps zzps) throws IOException {
            zzay(zzps.size());
            zzps.zza((zzpr) this);
        }

        public final void zza(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }
    }

    public static int zzc(int i11, zzps zzps) {
        int zzbb = zzbb(i11);
        int size = zzps.size();
        return zzbb + zzbd(size) + size;
    }

    public static int zzh(byte[] bArr) {
        int length = bArr.length;
        return zzbd(length) + length;
    }

    public static int zzi(int i11, int i12) {
        return zzbb(i11) + zzbc(i12);
    }

    public final void zzb(double d11) throws IOException {
        zzr(Double.doubleToRawLongBits(d11));
    }

    public static int zzb(int i11, float f11) {
        return zzbb(i11) + 4;
    }

    public static int zzd(int i11, zzsk zzsk) {
        return (zzbb(1) << 1) + zzj(2, i11) + zzc(3, zzsk);
    }

    public final void zzg(int i11, int i12) throws IOException {
        zzf(i11, zzbi(i12));
    }

    public static int zzb(int i11, double d11) {
        return zzbb(i11) + 8;
    }

    public static int zzg(int i11, long j11) {
        return zzbb(i11) + 8;
    }

    public static int zzb(int i11, String str) {
        return zzbb(i11) + zzda(str);
    }

    public static int zzc(int i11, zzsk zzsk) {
        return zzbb(i11) + zzc(zzsk);
    }

    public static int zzb(int i11, zzsk zzsk, zzsz zzsz) {
        return zzbb(i11) + zzb(zzsk, zzsz);
    }

    public static int zzc(zzsk zzsk) {
        int zzpe = zzsk.zzpe();
        return zzbd(zzpe) + zzpe;
    }

    public static int zzd(int i11, zzps zzps) {
        return (zzbb(1) << 1) + zzj(2, i11) + zzc(3, zzps);
    }

    public static int zzb(int i11, zzrr zzrr) {
        return (zzbb(1) << 1) + zzj(2, i11) + zza(3, zzrr);
    }

    @Deprecated
    public static int zzc(int i11, zzsk zzsk, zzsz zzsz) {
        int zzbb = zzbb(i11) << 1;
        zzpl zzpl = (zzpl) zzsk;
        int zzmw = zzpl.zzmw();
        if (zzmw == -1) {
            zzmw = zzsz.zzad(zzpl);
            zzpl.zzag(zzmw);
        }
        return zzbb + zzmw;
    }

    public final void zza(int i11, float f11) throws IOException {
        zzh(i11, Float.floatToRawIntBits(f11));
    }

    @Deprecated
    public static int zzd(zzsk zzsk) {
        return zzsk.zzpe();
    }

    public final void zza(int i11, double d11) throws IOException {
        zzc(i11, Double.doubleToRawLongBits(d11));
    }

    public static int zzb(zzps zzps) {
        int size = zzps.size();
        return zzbd(size) + size;
    }

    public final void zza(float f11) throws IOException {
        zzba(Float.floatToRawIntBits(f11));
    }

    public static int zza(int i11, zzrr zzrr) {
        int zzbb = zzbb(i11);
        int zzpe = zzrr.zzpe();
        return zzbb + zzbd(zzpe) + zzpe;
    }

    public static int zzb(zzsk zzsk, zzsz zzsz) {
        zzpl zzpl = (zzpl) zzsk;
        int zzmw = zzpl.zzmw();
        if (zzmw == -1) {
            zzmw = zzsz.zzad(zzpl);
            zzpl.zzag(zzmw);
        }
        return zzbd(zzmw) + zzmw;
    }

    public static int zza(zzrr zzrr) {
        int zzpe = zzrr.zzpe();
        return zzbd(zzpe) + zzpe;
    }

    public final void zza(String str, zzud zzud) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzud);
        byte[] bytes = str.getBytes(zzre.UTF_8);
        try {
            zzay(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzc((Throwable) e11);
        } catch (zzc e12) {
            throw e12;
        }
    }
}
