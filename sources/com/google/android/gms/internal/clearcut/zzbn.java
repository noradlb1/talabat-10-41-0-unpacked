package com.google.android.gms.internal.clearcut;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzbn extends zzba {
    private static final Logger logger = Logger.getLogger(zzbn.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzfy = zzfd.zzed();
    zzbp zzfz;

    public static class zza extends zzbn {
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

        public final void zza(byte b11) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                bArr[i11] = b11;
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void zza(int i11, long j11) throws IOException {
            zzb(i11, 0);
            zzb(j11);
        }

        public final void zza(int i11, zzbb zzbb) throws IOException {
            zzb(i11, 2);
            zza(zzbb);
        }

        public final void zza(int i11, zzdo zzdo) throws IOException {
            zzb(i11, 2);
            zzb(zzdo);
        }

        public final void zza(int i11, zzdo zzdo, zzef zzef) throws IOException {
            zzb(i11, 2);
            zzas zzas = (zzas) zzdo;
            int zzs = zzas.zzs();
            if (zzs == -1) {
                zzs = zzef.zzm(zzas);
                zzas.zzf(zzs);
            }
            zzo(zzs);
            zzef.zza(zzdo, this.zzfz);
        }

        public final void zza(int i11, String str) throws IOException {
            zzb(i11, 2);
            zzg(str);
        }

        public final void zza(zzbb zzbb) throws IOException {
            zzo(zzbb.size());
            zzbb.zza((zzba) this);
        }

        public final void zza(zzdo zzdo, zzef zzef) throws IOException {
            zzas zzas = (zzas) zzdo;
            int zzs = zzas.zzs();
            if (zzs == -1) {
                zzs = zzef.zzm(zzas);
                zzas.zzf(zzs);
            }
            zzo(zzs);
            zzef.zza(zzdo, this.zzfz);
        }

        public final void zza(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }

        public final int zzag() {
            return this.limit - this.position;
        }

        public final int zzai() {
            return this.position - this.offset;
        }

        public final void zzb(int i11, int i12) throws IOException {
            zzo((i11 << 3) | i12);
        }

        public final void zzb(int i11, zzbb zzbb) throws IOException {
            zzb(1, 3);
            zzd(2, i11);
            zza(3, zzbb);
            zzb(1, 4);
        }

        public final void zzb(int i11, zzdo zzdo) throws IOException {
            zzb(1, 3);
            zzd(2, i11);
            zza(3, zzdo);
            zzb(1, 4);
        }

        public final void zzb(int i11, boolean z11) throws IOException {
            zzb(i11, 0);
            zza(z11 ? (byte) 1 : 0);
        }

        public final void zzb(long j11) throws IOException {
            if (!zzbn.zzfy || zzag() < 10) {
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
                    zzfd.zza(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzfd.zza(bArr4, (long) i14, (byte) ((int) j11));
            }
        }

        public final void zzb(zzdo zzdo) throws IOException {
            zzo(zzdo.zzas());
            zzdo.zzb(this);
        }

        public final void zzc(int i11, int i12) throws IOException {
            zzb(i11, 0);
            zzn(i12);
        }

        public final void zzc(int i11, long j11) throws IOException {
            zzb(i11, 1);
            zzd(j11);
        }

        public final void zzd(int i11, int i12) throws IOException {
            zzb(i11, 0);
            zzo(i12);
        }

        public final void zzd(long j11) throws IOException {
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

        public final void zzd(byte[] bArr, int i11, int i12) throws IOException {
            zzo(i12);
            write(bArr, 0, i12);
        }

        public final void zzf(int i11, int i12) throws IOException {
            zzb(i11, 5);
            zzq(i12);
        }

        public final void zzg(String str) throws IOException {
            int i11 = this.position;
            try {
                int zzt = zzbn.zzt(str.length() * 3);
                int zzt2 = zzbn.zzt(str.length());
                if (zzt2 == zzt) {
                    int i12 = i11 + zzt2;
                    this.position = i12;
                    int zza = zzff.zza(str, this.buffer, i12, zzag());
                    this.position = i11;
                    zzo((zza - i11) - zzt2);
                    this.position = zza;
                    return;
                }
                zzo(zzff.zza(str));
                this.position = zzff.zza(str, this.buffer, this.position, zzag());
            } catch (zzfi e11) {
                this.position = i11;
                zza(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new zzc((Throwable) e12);
            }
        }

        public final void zzn(int i11) throws IOException {
            if (i11 >= 0) {
                zzo(i11);
            } else {
                zzb((long) i11);
            }
        }

        public final void zzo(int i11) throws IOException {
            if (!zzbn.zzfy || zzag() < 10) {
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
            } else {
                while ((i11 & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i14 = this.position;
                    this.position = i14 + 1;
                    zzfd.zza(bArr3, (long) i14, (byte) ((i11 & 127) | 128));
                    i11 >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzfd.zza(bArr4, (long) i15, (byte) i11);
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
                bArr[i15] = i11 >> Ascii.CAN;
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }
    }

    public static final class zzb extends zza {
        private final ByteBuffer zzga;
        private int zzgb;

        public zzb(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzga = byteBuffer;
            this.zzgb = byteBuffer.position();
        }

        public final void flush() {
            this.zzga.position(this.zzgb + zzai());
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String):void");
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }

        public zzc(Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
        }
    }

    public static final class zzd extends zzbn {
        private final int zzgb;
        private final ByteBuffer zzgc;
        private final ByteBuffer zzgd;

        public zzd(ByteBuffer byteBuffer) {
            super();
            this.zzgc = byteBuffer;
            this.zzgd = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzgb = byteBuffer.position();
        }

        private final void zzi(String str) throws IOException {
            try {
                zzff.zza(str, this.zzgd);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void flush() {
            this.zzgc.position(this.zzgd.position());
        }

        public final void write(byte[] bArr, int i11, int i12) throws IOException {
            try {
                this.zzgd.put(bArr, i11, i12);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzc((Throwable) e11);
            } catch (BufferOverflowException e12) {
                throw new zzc((Throwable) e12);
            }
        }

        public final void zza(byte b11) throws IOException {
            try {
                this.zzgd.put(b11);
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void zza(int i11, long j11) throws IOException {
            zzb(i11, 0);
            zzb(j11);
        }

        public final void zza(int i11, zzbb zzbb) throws IOException {
            zzb(i11, 2);
            zza(zzbb);
        }

        public final void zza(int i11, zzdo zzdo) throws IOException {
            zzb(i11, 2);
            zzb(zzdo);
        }

        public final void zza(int i11, zzdo zzdo, zzef zzef) throws IOException {
            zzb(i11, 2);
            zza(zzdo, zzef);
        }

        public final void zza(int i11, String str) throws IOException {
            zzb(i11, 2);
            zzg(str);
        }

        public final void zza(zzbb zzbb) throws IOException {
            zzo(zzbb.size());
            zzbb.zza((zzba) this);
        }

        public final void zza(zzdo zzdo, zzef zzef) throws IOException {
            zzas zzas = (zzas) zzdo;
            int zzs = zzas.zzs();
            if (zzs == -1) {
                zzs = zzef.zzm(zzas);
                zzas.zzf(zzs);
            }
            zzo(zzs);
            zzef.zza(zzdo, this.zzfz);
        }

        public final void zza(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }

        public final int zzag() {
            return this.zzgd.remaining();
        }

        public final void zzb(int i11, int i12) throws IOException {
            zzo((i11 << 3) | i12);
        }

        public final void zzb(int i11, zzbb zzbb) throws IOException {
            zzb(1, 3);
            zzd(2, i11);
            zza(3, zzbb);
            zzb(1, 4);
        }

        public final void zzb(int i11, zzdo zzdo) throws IOException {
            zzb(1, 3);
            zzd(2, i11);
            zza(3, zzdo);
            zzb(1, 4);
        }

        public final void zzb(int i11, boolean z11) throws IOException {
            zzb(i11, 0);
            zza(z11 ? (byte) 1 : 0);
        }

        public final void zzb(long j11) throws IOException {
            while ((-128 & j11) != 0) {
                this.zzgd.put((byte) ((((int) j11) & 127) | 128));
                j11 >>>= 7;
            }
            try {
                this.zzgd.put((byte) ((int) j11));
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void zzb(zzdo zzdo) throws IOException {
            zzo(zzdo.zzas());
            zzdo.zzb(this);
        }

        public final void zzc(int i11, int i12) throws IOException {
            zzb(i11, 0);
            zzn(i12);
        }

        public final void zzc(int i11, long j11) throws IOException {
            zzb(i11, 1);
            zzd(j11);
        }

        public final void zzd(int i11, int i12) throws IOException {
            zzb(i11, 0);
            zzo(i12);
        }

        public final void zzd(long j11) throws IOException {
            try {
                this.zzgd.putLong(j11);
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void zzd(byte[] bArr, int i11, int i12) throws IOException {
            zzo(i12);
            write(bArr, 0, i12);
        }

        public final void zzf(int i11, int i12) throws IOException {
            zzb(i11, 5);
            zzq(i12);
        }

        public final void zzg(String str) throws IOException {
            int position = this.zzgd.position();
            try {
                int zzt = zzbn.zzt(str.length() * 3);
                int zzt2 = zzbn.zzt(str.length());
                if (zzt2 == zzt) {
                    int position2 = this.zzgd.position() + zzt2;
                    this.zzgd.position(position2);
                    zzi(str);
                    int position3 = this.zzgd.position();
                    this.zzgd.position(position);
                    zzo(position3 - position2);
                    this.zzgd.position(position3);
                    return;
                }
                zzo(zzff.zza(str));
                zzi(str);
            } catch (zzfi e11) {
                this.zzgd.position(position);
                zza(str, e11);
            } catch (IllegalArgumentException e12) {
                throw new zzc((Throwable) e12);
            }
        }

        public final void zzn(int i11) throws IOException {
            if (i11 >= 0) {
                zzo(i11);
            } else {
                zzb((long) i11);
            }
        }

        public final void zzo(int i11) throws IOException {
            while ((i11 & -128) != 0) {
                this.zzgd.put((byte) ((i11 & 127) | 128));
                i11 >>>= 7;
            }
            try {
                this.zzgd.put((byte) i11);
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }

        public final void zzq(int i11) throws IOException {
            try {
                this.zzgd.putInt(i11);
            } catch (BufferOverflowException e11) {
                throw new zzc((Throwable) e11);
            }
        }
    }

    public static final class zze extends zzbn {
        private final ByteBuffer zzgc;
        private final ByteBuffer zzgd;
        private final long zzge;
        private final long zzgf;
        private final long zzgg;
        private final long zzgh;
        private long zzgi;

        public zze(ByteBuffer byteBuffer) {
            super();
            this.zzgc = byteBuffer;
            this.zzgd = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long zzb = zzfd.zzb(byteBuffer);
            this.zzge = zzb;
            long position = ((long) byteBuffer.position()) + zzb;
            this.zzgf = position;
            long limit = zzb + ((long) byteBuffer.limit());
            this.zzgg = limit;
            this.zzgh = limit - 10;
            this.zzgi = position;
        }

        private final void zzk(long j11) {
            this.zzgd.position((int) (j11 - this.zzge));
        }

        public final void flush() {
            this.zzgc.position((int) (this.zzgi - this.zzge));
        }

        public final void write(byte[] bArr, int i11, int i12) throws IOException {
            if (bArr != null && i11 >= 0 && i12 >= 0 && bArr.length - i12 >= i11) {
                long j11 = (long) i12;
                long j12 = this.zzgi;
                if (this.zzgg - j11 >= j12) {
                    zzfd.zza(bArr, (long) i11, j12, j11);
                    this.zzgi += j11;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), Integer.valueOf(i12)}));
        }

        public final void zza(byte b11) throws IOException {
            long j11 = this.zzgi;
            if (j11 < this.zzgg) {
                this.zzgi = 1 + j11;
                zzfd.zza(j11, b11);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), 1}));
        }

        public final void zza(int i11, long j11) throws IOException {
            zzb(i11, 0);
            zzb(j11);
        }

        public final void zza(int i11, zzbb zzbb) throws IOException {
            zzb(i11, 2);
            zza(zzbb);
        }

        public final void zza(int i11, zzdo zzdo) throws IOException {
            zzb(i11, 2);
            zzb(zzdo);
        }

        public final void zza(int i11, zzdo zzdo, zzef zzef) throws IOException {
            zzb(i11, 2);
            zza(zzdo, zzef);
        }

        public final void zza(int i11, String str) throws IOException {
            zzb(i11, 2);
            zzg(str);
        }

        public final void zza(zzbb zzbb) throws IOException {
            zzo(zzbb.size());
            zzbb.zza((zzba) this);
        }

        public final void zza(zzdo zzdo, zzef zzef) throws IOException {
            zzas zzas = (zzas) zzdo;
            int zzs = zzas.zzs();
            if (zzs == -1) {
                zzs = zzef.zzm(zzas);
                zzas.zzf(zzs);
            }
            zzo(zzs);
            zzef.zza(zzdo, this.zzfz);
        }

        public final void zza(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }

        public final int zzag() {
            return (int) (this.zzgg - this.zzgi);
        }

        public final void zzb(int i11, int i12) throws IOException {
            zzo((i11 << 3) | i12);
        }

        public final void zzb(int i11, zzbb zzbb) throws IOException {
            zzb(1, 3);
            zzd(2, i11);
            zza(3, zzbb);
            zzb(1, 4);
        }

        public final void zzb(int i11, zzdo zzdo) throws IOException {
            zzb(1, 3);
            zzd(2, i11);
            zza(3, zzdo);
            zzb(1, 4);
        }

        public final void zzb(int i11, boolean z11) throws IOException {
            zzb(i11, 0);
            zza(z11 ? (byte) 1 : 0);
        }

        public final void zzb(long j11) throws IOException {
            if (this.zzgi <= this.zzgh) {
                while ((j11 & -128) != 0) {
                    long j12 = this.zzgi;
                    this.zzgi = j12 + 1;
                    zzfd.zza(j12, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                long j13 = this.zzgi;
                this.zzgi = 1 + j13;
                zzfd.zza(j13, (byte) ((int) j11));
                return;
            }
            while (true) {
                long j14 = this.zzgi;
                if (j14 >= this.zzgg) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), 1}));
                } else if ((j11 & -128) == 0) {
                    this.zzgi = 1 + j14;
                    zzfd.zza(j14, (byte) ((int) j11));
                    return;
                } else {
                    this.zzgi = j14 + 1;
                    zzfd.zza(j14, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
            }
        }

        public final void zzb(zzdo zzdo) throws IOException {
            zzo(zzdo.zzas());
            zzdo.zzb(this);
        }

        public final void zzc(int i11, int i12) throws IOException {
            zzb(i11, 0);
            zzn(i12);
        }

        public final void zzc(int i11, long j11) throws IOException {
            zzb(i11, 1);
            zzd(j11);
        }

        public final void zzd(int i11, int i12) throws IOException {
            zzb(i11, 0);
            zzo(i12);
        }

        public final void zzd(long j11) throws IOException {
            this.zzgd.putLong((int) (this.zzgi - this.zzge), j11);
            this.zzgi += 8;
        }

        public final void zzd(byte[] bArr, int i11, int i12) throws IOException {
            zzo(i12);
            write(bArr, 0, i12);
        }

        public final void zzf(int i11, int i12) throws IOException {
            zzb(i11, 5);
            zzq(i12);
        }

        public final void zzg(String str) throws IOException {
            long j11 = this.zzgi;
            try {
                int zzt = zzbn.zzt(str.length() * 3);
                int zzt2 = zzbn.zzt(str.length());
                if (zzt2 == zzt) {
                    int i11 = ((int) (this.zzgi - this.zzge)) + zzt2;
                    this.zzgd.position(i11);
                    zzff.zza(str, this.zzgd);
                    int position = this.zzgd.position() - i11;
                    zzo(position);
                    this.zzgi += (long) position;
                    return;
                }
                int zza = zzff.zza(str);
                zzo(zza);
                zzk(this.zzgi);
                zzff.zza(str, this.zzgd);
                this.zzgi += (long) zza;
            } catch (zzfi e11) {
                this.zzgi = j11;
                zzk(j11);
                zza(str, e11);
            } catch (IllegalArgumentException e12) {
                throw new zzc((Throwable) e12);
            } catch (IndexOutOfBoundsException e13) {
                throw new zzc((Throwable) e13);
            }
        }

        public final void zzn(int i11) throws IOException {
            if (i11 >= 0) {
                zzo(i11);
            } else {
                zzb((long) i11);
            }
        }

        public final void zzo(int i11) throws IOException {
            long j11;
            if (this.zzgi <= this.zzgh) {
                while (true) {
                    int i12 = i11 & -128;
                    j11 = this.zzgi;
                    if (i12 == 0) {
                        break;
                    }
                    this.zzgi = j11 + 1;
                    zzfd.zza(j11, (byte) ((i11 & 127) | 128));
                    i11 >>>= 7;
                }
            } else {
                while (true) {
                    j11 = this.zzgi;
                    if (j11 >= this.zzgg) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzgi), Long.valueOf(this.zzgg), 1}));
                    } else if ((i11 & -128) == 0) {
                        break;
                    } else {
                        this.zzgi = j11 + 1;
                        zzfd.zza(j11, (byte) ((i11 & 127) | 128));
                        i11 >>>= 7;
                    }
                }
            }
            this.zzgi = 1 + j11;
            zzfd.zza(j11, (byte) i11);
        }

        public final void zzq(int i11) throws IOException {
            this.zzgd.putInt((int) (this.zzgi - this.zzge), i11);
            this.zzgi += 4;
        }
    }

    private zzbn() {
    }

    public static int zza(int i11, zzcv zzcv) {
        int zzr = zzr(i11);
        int zzas = zzcv.zzas();
        return zzr + zzt(zzas) + zzas;
    }

    public static int zza(zzcv zzcv) {
        int zzas = zzcv.zzas();
        return zzt(zzas) + zzas;
    }

    public static zzbn zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzb(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            return zzfd.zzee() ? new zze(byteBuffer) : new zzd(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static int zzb(double d11) {
        return 8;
    }

    public static int zzb(float f11) {
        return 4;
    }

    public static int zzb(int i11, double d11) {
        return zzr(i11) + 8;
    }

    public static int zzb(int i11, float f11) {
        return zzr(i11) + 4;
    }

    public static int zzb(int i11, zzcv zzcv) {
        return (zzr(1) << 1) + zzh(2, i11) + zza(3, zzcv);
    }

    public static int zzb(int i11, zzdo zzdo, zzef zzef) {
        return zzr(i11) + zzb(zzdo, zzef);
    }

    public static int zzb(int i11, String str) {
        return zzr(i11) + zzh(str);
    }

    public static int zzb(zzbb zzbb) {
        int size = zzbb.size();
        return zzt(size) + size;
    }

    public static int zzb(zzdo zzdo, zzef zzef) {
        zzas zzas = (zzas) zzdo;
        int zzs = zzas.zzs();
        if (zzs == -1) {
            zzs = zzef.zzm(zzas);
            zzas.zzf(zzs);
        }
        return zzt(zzs) + zzs;
    }

    public static int zzb(boolean z11) {
        return 1;
    }

    public static int zzc(int i11, zzbb zzbb) {
        int zzr = zzr(i11);
        int size = zzbb.size();
        return zzr + zzt(size) + size;
    }

    public static int zzc(int i11, zzdo zzdo) {
        return zzr(i11) + zzc(zzdo);
    }

    @Deprecated
    public static int zzc(int i11, zzdo zzdo, zzef zzef) {
        int zzr = zzr(i11) << 1;
        zzas zzas = (zzas) zzdo;
        int zzs = zzas.zzs();
        if (zzs == -1) {
            zzs = zzef.zzm(zzas);
            zzas.zzf(zzs);
        }
        return zzr + zzs;
    }

    public static int zzc(int i11, boolean z11) {
        return zzr(i11) + 1;
    }

    public static int zzc(zzdo zzdo) {
        int zzas = zzdo.zzas();
        return zzt(zzas) + zzas;
    }

    public static zzbn zzc(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzd(int i11, long j11) {
        return zzr(i11) + zzf(j11);
    }

    public static int zzd(int i11, zzbb zzbb) {
        return (zzr(1) << 1) + zzh(2, i11) + zzc(3, zzbb);
    }

    public static int zzd(int i11, zzdo zzdo) {
        return (zzr(1) << 1) + zzh(2, i11) + zzc(3, zzdo);
    }

    @Deprecated
    public static int zzd(zzdo zzdo) {
        return zzdo.zzas();
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        return zzt(length) + length;
    }

    public static int zze(int i11, long j11) {
        return zzr(i11) + zzf(j11);
    }

    public static int zze(long j11) {
        return zzf(j11);
    }

    public static int zzf(int i11, long j11) {
        return zzr(i11) + zzf(zzj(j11));
    }

    public static int zzf(long j11) {
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

    public static int zzg(int i11, int i12) {
        return zzr(i11) + zzs(i12);
    }

    public static int zzg(int i11, long j11) {
        return zzr(i11) + 8;
    }

    public static int zzg(long j11) {
        return zzf(zzj(j11));
    }

    public static int zzh(int i11, int i12) {
        return zzr(i11) + zzt(i12);
    }

    public static int zzh(int i11, long j11) {
        return zzr(i11) + 8;
    }

    public static int zzh(long j11) {
        return 8;
    }

    public static int zzh(String str) {
        int i11;
        try {
            i11 = zzff.zza(str);
        } catch (zzfi unused) {
            i11 = str.getBytes(zzci.UTF_8).length;
        }
        return zzt(i11) + i11;
    }

    public static int zzi(int i11, int i12) {
        return zzr(i11) + zzt(zzy(i12));
    }

    public static int zzi(long j11) {
        return 8;
    }

    public static int zzj(int i11, int i12) {
        return zzr(i11) + 4;
    }

    private static long zzj(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public static int zzk(int i11, int i12) {
        return zzr(i11) + 4;
    }

    public static int zzl(int i11, int i12) {
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

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void zza(byte b11) throws IOException;

    public final void zza(double d11) throws IOException {
        zzd(Double.doubleToRawLongBits(d11));
    }

    public final void zza(float f11) throws IOException {
        zzq(Float.floatToRawIntBits(f11));
    }

    public final void zza(int i11, double d11) throws IOException {
        zzc(i11, Double.doubleToRawLongBits(d11));
    }

    public final void zza(int i11, float f11) throws IOException {
        zzf(i11, Float.floatToRawIntBits(f11));
    }

    public abstract void zza(int i11, long j11) throws IOException;

    public abstract void zza(int i11, zzbb zzbb) throws IOException;

    public abstract void zza(int i11, zzdo zzdo) throws IOException;

    public abstract void zza(int i11, zzdo zzdo, zzef zzef) throws IOException;

    public abstract void zza(int i11, String str) throws IOException;

    public abstract void zza(zzbb zzbb) throws IOException;

    public abstract void zza(zzdo zzdo, zzef zzef) throws IOException;

    public final void zza(String str, zzfi zzfi) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzfi);
        byte[] bytes = str.getBytes(zzci.UTF_8);
        try {
            zzo(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzc((Throwable) e11);
        } catch (zzc e12) {
            throw e12;
        }
    }

    public final void zza(boolean z11) throws IOException {
        zza(z11 ? (byte) 1 : 0);
    }

    public abstract int zzag();

    public abstract void zzb(int i11, int i12) throws IOException;

    public final void zzb(int i11, long j11) throws IOException {
        zza(i11, zzj(j11));
    }

    public abstract void zzb(int i11, zzbb zzbb) throws IOException;

    public abstract void zzb(int i11, zzdo zzdo) throws IOException;

    public abstract void zzb(int i11, boolean z11) throws IOException;

    public abstract void zzb(long j11) throws IOException;

    public abstract void zzb(zzdo zzdo) throws IOException;

    public abstract void zzc(int i11, int i12) throws IOException;

    public abstract void zzc(int i11, long j11) throws IOException;

    public final void zzc(long j11) throws IOException {
        zzb(zzj(j11));
    }

    public abstract void zzd(int i11, int i12) throws IOException;

    public abstract void zzd(long j11) throws IOException;

    public abstract void zzd(byte[] bArr, int i11, int i12) throws IOException;

    public final void zze(int i11, int i12) throws IOException {
        zzd(i11, zzy(i12));
    }

    public abstract void zzf(int i11, int i12) throws IOException;

    public abstract void zzg(String str) throws IOException;

    public abstract void zzn(int i11) throws IOException;

    public abstract void zzo(int i11) throws IOException;

    public final void zzp(int i11) throws IOException {
        zzo(zzy(i11));
    }

    public abstract void zzq(int i11) throws IOException;
}
