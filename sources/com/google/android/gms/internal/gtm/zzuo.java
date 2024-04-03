package com.google.android.gms.internal.gtm;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzuo {
    private final ByteBuffer zzawy;
    private zzqj zzbgz;
    private int zzbha;

    private zzuo(byte[] bArr, int i11, int i12) {
        this(ByteBuffer.wrap(bArr, i11, i12));
    }

    private final void zzab(long j11) throws IOException {
        while ((-128 & j11) != 0) {
            zzca((((int) j11) & 127) | 128);
            j11 >>>= 7;
        }
        zzca((int) j11);
    }

    public static int zzbb(int i11) {
        return zzbj(i11 << 3);
    }

    public static int zzbc(int i11) {
        if (i11 >= 0) {
            return zzbj(i11);
        }
        return 10;
    }

    public static int zzbj(int i11) {
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

    private final void zzca(int i11) throws IOException {
        byte b11 = (byte) i11;
        if (this.zzawy.hasRemaining()) {
            this.zzawy.put(b11);
            return;
        }
        throw new zzup(this.zzawy.position(), this.zzawy.limit());
    }

    private static void zzd(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i11;
        int i12;
        char charAt;
        if (!byteBuffer.isReadOnly()) {
            int i13 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i14 = remaining + arrayOffset;
                    while (i13 < length) {
                        int i15 = i13 + arrayOffset;
                        if (i15 >= i14 || (charAt = charSequence.charAt(i13)) >= 128) {
                            break;
                        }
                        array[i15] = (byte) charAt;
                        i13++;
                    }
                    if (i13 == length) {
                        i11 = arrayOffset + length;
                    } else {
                        i11 = arrayOffset + i13;
                        while (i13 < length) {
                            char charAt2 = charSequence.charAt(i13);
                            if (charAt2 < 128 && i11 < i14) {
                                i12 = i11 + 1;
                                array[i11] = (byte) charAt2;
                            } else if (charAt2 < 2048 && i11 <= i14 - 2) {
                                int i16 = i11 + 1;
                                array[i11] = (byte) ((charAt2 >>> 6) | 960);
                                i11 = i16 + 1;
                                array[i16] = (byte) ((charAt2 & '?') | 128);
                                i13++;
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && i11 <= i14 - 3) {
                                int i17 = i11 + 1;
                                array[i11] = (byte) ((charAt2 >>> 12) | 480);
                                int i18 = i17 + 1;
                                array[i17] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                i12 = i18 + 1;
                                array[i18] = (byte) ((charAt2 & '?') | 128);
                            } else if (i11 <= i14 - 4) {
                                int i19 = i13 + 1;
                                if (i19 != charSequence.length()) {
                                    char charAt3 = charSequence.charAt(i19);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        int i21 = i11 + 1;
                                        array[i11] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                                        int i22 = i21 + 1;
                                        array[i21] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i23 = i22 + 1;
                                        array[i22] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i11 = i23 + 1;
                                        array[i23] = (byte) ((codePoint & 63) | 128);
                                        i13 = i19;
                                        i13++;
                                    } else {
                                        i13 = i19;
                                    }
                                }
                                StringBuilder sb2 = new StringBuilder(39);
                                sb2.append("Unpaired surrogate at index ");
                                sb2.append(i13 - 1);
                                throw new IllegalArgumentException(sb2.toString());
                            } else {
                                StringBuilder sb3 = new StringBuilder(37);
                                sb3.append("Failed writing ");
                                sb3.append(charAt2);
                                sb3.append(" at index ");
                                sb3.append(i11);
                                throw new ArrayIndexOutOfBoundsException(sb3.toString());
                            }
                            i11 = i12;
                            i13++;
                        }
                    }
                    byteBuffer.position(i11 - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e11) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e11);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i13 < length2) {
                    char charAt4 = charSequence.charAt(i13);
                    if (charAt4 < 128) {
                        byteBuffer.put((byte) charAt4);
                    } else if (charAt4 < 2048) {
                        byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                        byteBuffer.put((byte) ((charAt4 & '?') | 128));
                    } else if (charAt4 < 55296 || 57343 < charAt4) {
                        byteBuffer.put((byte) ((charAt4 >>> 12) | 480));
                        byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((charAt4 & '?') | 128));
                    } else {
                        int i24 = i13 + 1;
                        if (i24 != charSequence.length()) {
                            char charAt5 = charSequence.charAt(i24);
                            if (Character.isSurrogatePair(charAt4, charAt5)) {
                                int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                byteBuffer.put((byte) ((codePoint2 >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                i13 = i24;
                            } else {
                                i13 = i24;
                            }
                        }
                        StringBuilder sb4 = new StringBuilder(39);
                        sb4.append("Unpaired surrogate at index ");
                        sb4.append(i13 - 1);
                        throw new IllegalArgumentException(sb4.toString());
                    }
                    i13++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    public static int zzda(String str) {
        int zza = zza(str);
        return zzbj(zza) + zza;
    }

    public static zzuo zzk(byte[] bArr, int i11, int i12) {
        return new zzuo(bArr, 0, i12);
    }

    public static zzuo zzl(byte[] bArr) {
        return zzk(bArr, 0, bArr.length);
    }

    private final zzqj zzrw() throws IOException {
        if (this.zzbgz == null) {
            this.zzbgz = zzqj.zza(this.zzawy);
            this.zzbha = this.zzawy.position();
        } else if (this.zzbha != this.zzawy.position()) {
            this.zzbgz.write(this.zzawy.array(), this.zzbha, this.zzawy.position() - this.zzbha);
            this.zzbha = this.zzawy.position();
        }
        return this.zzbgz;
    }

    public final void zza(int i11, String str) throws IOException {
        zzd(i11, 2);
        try {
            int zzbj = zzbj(str.length());
            if (zzbj == zzbj(str.length() * 3)) {
                int position = this.zzawy.position();
                if (this.zzawy.remaining() >= zzbj) {
                    this.zzawy.position(position + zzbj);
                    zzd((CharSequence) str, this.zzawy);
                    int position2 = this.zzawy.position();
                    this.zzawy.position(position);
                    zzcb((position2 - position) - zzbj);
                    this.zzawy.position(position2);
                    return;
                }
                throw new zzup(position + zzbj, this.zzawy.limit());
            }
            zzcb(zza(str));
            zzd((CharSequence) str, this.zzawy);
        } catch (BufferOverflowException e11) {
            zzup zzup = new zzup(this.zzawy.position(), this.zzawy.limit());
            zzup.initCause(e11);
            throw zzup;
        }
    }

    public final void zzb(int i11, boolean z11) throws IOException {
        zzd(i11, 0);
        byte b11 = z11 ? (byte) 1 : 0;
        if (this.zzawy.hasRemaining()) {
            this.zzawy.put(b11);
            return;
        }
        throw new zzup(this.zzawy.position(), this.zzawy.limit());
    }

    public final void zzcb(int i11) throws IOException {
        while ((i11 & -128) != 0) {
            zzca((i11 & 127) | 128);
            i11 >>>= 7;
        }
        zzca(i11);
    }

    public final void zzcc(int i11) throws IOException {
        if (this.zzawy.remaining() >= 4) {
            this.zzawy.putInt(i11);
            return;
        }
        throw new zzup(this.zzawy.position(), this.zzawy.limit());
    }

    public final void zze(int i11, int i12) throws IOException {
        zzd(i11, 0);
        if (i12 >= 0) {
            zzcb(i12);
        } else {
            zzab((long) i12);
        }
    }

    public final void zzi(int i11, long j11) throws IOException {
        zzd(i11, 0);
        zzab(j11);
    }

    public final void zzm(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzawy.remaining() >= length) {
            this.zzawy.put(bArr, 0, length);
            return;
        }
        throw new zzup(this.zzawy.position(), this.zzawy.limit());
    }

    public final void zzrx() {
        if (this.zzawy.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzawy.remaining())}));
        }
    }

    private zzuo(ByteBuffer byteBuffer) {
        this.zzawy = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static int zzi(int i11, int i12) {
        return zzbb(i11) + zzbc(i12);
    }

    public final void zze(int i11, zzsk zzsk) throws IOException {
        zzqj zzrw = zzrw();
        zzrw.zza(i11, zzsk);
        zzrw.flush();
        this.zzbha = this.zzawy.position();
    }

    public final void zzb(zzuw zzuw) throws IOException {
        zzcb(zzuw.zzse());
        zzuw.zza(this);
    }

    public static int zzb(int i11, String str) {
        return zzbb(i11) + zzda(str);
    }

    public static int zzb(int i11, zzuw zzuw) {
        int zzbb = zzbb(i11);
        int zzpe = zzuw.zzpe();
        return zzbb + zzbj(zzpe) + zzpe;
    }

    public final void zza(int i11, zzuw zzuw) throws IOException {
        zzd(i11, 2);
        zzb(zzuw);
    }

    private static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        int i12 = 0;
        while (i12 < length && charSequence.charAt(i12) < 128) {
            i12++;
        }
        int i13 = length;
        while (true) {
            if (i12 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i12);
            if (charAt < 2048) {
                i13 += (127 - charAt) >>> 31;
                i12++;
            } else {
                int length2 = charSequence.length();
                while (i12 < length2) {
                    char charAt2 = charSequence.charAt(i12);
                    if (charAt2 < 2048) {
                        i11 += (127 - charAt2) >>> 31;
                    } else {
                        i11 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i12) >= 65536) {
                                i12++;
                            } else {
                                StringBuilder sb2 = new StringBuilder(39);
                                sb2.append("Unpaired surrogate at index ");
                                sb2.append(i12);
                                throw new IllegalArgumentException(sb2.toString());
                            }
                        }
                    }
                    i12++;
                }
                i13 += i11;
            }
        }
        if (i13 >= length) {
            return i13;
        }
        StringBuilder sb3 = new StringBuilder(54);
        sb3.append("UTF-8 length does not fit in int: ");
        sb3.append(((long) i13) + 4294967296L);
        throw new IllegalArgumentException(sb3.toString());
    }

    public static int zzd(int i11, long j11) {
        return zzbb(i11) + ((-128 & j11) == 0 ? 1 : (-16384 & j11) == 0 ? 2 : (-2097152 & j11) == 0 ? 3 : (-268435456 & j11) == 0 ? 4 : (-34359738368L & j11) == 0 ? 5 : (-4398046511104L & j11) == 0 ? 6 : (-562949953421312L & j11) == 0 ? 7 : (-72057594037927936L & j11) == 0 ? 8 : (j11 & Long.MIN_VALUE) == 0 ? 9 : 10);
    }

    public final void zzd(int i11, int i12) throws IOException {
        zzcb((i11 << 3) | i12);
    }
}
