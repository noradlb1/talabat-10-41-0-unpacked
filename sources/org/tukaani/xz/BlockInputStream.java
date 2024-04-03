package org.tukaani.xz;

import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;

class BlockInputStream extends InputStream {
    private final Check check;
    private long compressedSizeInHeader = -1;
    private long compressedSizeLimit;
    private boolean endReached = false;
    private InputStream filterChain;
    private final int headerSize;
    private final CountingInputStream inCounted;
    private final DataInputStream inData;
    private final byte[] tempBuf = new byte[1];
    private long uncompressedSize = 0;
    private long uncompressedSizeInHeader = -1;
    private final boolean verifyCheck;

    public BlockInputStream(InputStream inputStream, Check check2, boolean z11, int i11, long j11, long j12, ArrayCache arrayCache) throws IOException, IndexIndicatorException {
        String str;
        InputStream inputStream2 = inputStream;
        int i12 = i11;
        long j13 = j12;
        this.check = check2;
        this.verifyCheck = z11;
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        this.inData = dataInputStream;
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if (readUnsignedByte != 0) {
            int i13 = (readUnsignedByte + 1) * 4;
            this.headerSize = i13;
            byte[] bArr = new byte[i13];
            bArr[0] = (byte) readUnsignedByte;
            dataInputStream.readFully(bArr, 1, i13 - 1);
            if (DecoderUtil.isCRC32Valid(bArr, 0, i13 - 4, i13 - 4)) {
                byte b11 = bArr[1];
                if ((b11 & 60) == 0) {
                    int i14 = (b11 & 3) + 1;
                    long[] jArr = new long[i14];
                    byte[][] bArr2 = new byte[i14][];
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 2, i13 - 6);
                    try {
                        this.compressedSizeLimit = (9223372036854775804L - ((long) i13)) - ((long) check2.getSize());
                        if ((bArr[1] & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                            long decodeVLI = DecoderUtil.decodeVLI(byteArrayInputStream);
                            this.compressedSizeInHeader = decodeVLI;
                            str = "XZ Block Header is corrupt";
                            if (decodeVLI != 0) {
                                try {
                                    if (decodeVLI <= this.compressedSizeLimit) {
                                        this.compressedSizeLimit = decodeVLI;
                                    }
                                } catch (IOException unused) {
                                    throw new CorruptedInputException(str);
                                }
                            }
                            throw new CorruptedInputException();
                        }
                        Object obj = "XZ Block Header is corrupt";
                        if ((bArr[1] & 128) != 0) {
                            this.uncompressedSizeInHeader = DecoderUtil.decodeVLI(byteArrayInputStream);
                        }
                        int i15 = 0;
                        while (i15 < i14) {
                            jArr[i15] = DecoderUtil.decodeVLI(byteArrayInputStream);
                            long decodeVLI2 = DecoderUtil.decodeVLI(byteArrayInputStream);
                            if (decodeVLI2 <= ((long) byteArrayInputStream.available())) {
                                byte[] bArr3 = new byte[((int) decodeVLI2)];
                                bArr2[i15] = bArr3;
                                byteArrayInputStream.read(bArr3);
                                i15++;
                            } else {
                                throw new CorruptedInputException();
                            }
                        }
                        int available = byteArrayInputStream.available();
                        while (available > 0) {
                            if (byteArrayInputStream.read() == 0) {
                                available--;
                            } else {
                                throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
                            }
                        }
                        if (j11 != -1) {
                            long size = (long) (this.headerSize + check2.getSize());
                            if (size < j11) {
                                long j14 = j11 - size;
                                if (j14 <= this.compressedSizeLimit) {
                                    long j15 = this.compressedSizeInHeader;
                                    if (j15 == -1 || j15 == j14) {
                                        long j16 = this.uncompressedSizeInHeader;
                                        if (j16 == -1 || j16 == j13) {
                                            this.compressedSizeLimit = j14;
                                            this.compressedSizeInHeader = j14;
                                            this.uncompressedSizeInHeader = j13;
                                        } else {
                                            throw new CorruptedInputException("XZ Index does not match a Block Header");
                                        }
                                    }
                                }
                                throw new CorruptedInputException("XZ Index does not match a Block Header");
                            }
                            throw new CorruptedInputException("XZ Index does not match a Block Header");
                        }
                        FilterDecoder[] filterDecoderArr = new FilterDecoder[i14];
                        for (int i16 = 0; i16 < i14; i16++) {
                            long j17 = jArr[i16];
                            if (j17 == 33) {
                                filterDecoderArr[i16] = new LZMA2Decoder(bArr2[i16]);
                            } else if (j17 == 3) {
                                filterDecoderArr[i16] = new DeltaDecoder(bArr2[i16]);
                            } else if (BCJCoder.isBCJFilterID(j17)) {
                                filterDecoderArr[i16] = new BCJDecoder(jArr[i16], bArr2[i16]);
                            } else {
                                throw new UnsupportedOptionsException("Unknown Filter ID " + jArr[i16]);
                            }
                        }
                        RawCoder.a(filterDecoderArr);
                        if (i12 >= 0) {
                            int i17 = 0;
                            for (int i18 = 0; i18 < i14; i18++) {
                                i17 += filterDecoderArr[i18].getMemoryUsage();
                            }
                            if (i17 > i12) {
                                throw new MemoryLimitException(i17, i12);
                            }
                        }
                        CountingInputStream countingInputStream = new CountingInputStream(inputStream2);
                        this.inCounted = countingInputStream;
                        this.filterChain = countingInputStream;
                        for (int i19 = i14 - 1; i19 >= 0; i19--) {
                            this.filterChain = filterDecoderArr[i19].getInputStream(this.filterChain, arrayCache);
                        }
                    } catch (IOException unused2) {
                        str = "XZ Block Header is corrupt";
                        throw new CorruptedInputException(str);
                    }
                } else {
                    throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
                }
            } else {
                throw new CorruptedInputException("XZ Block Header is corrupt");
            }
        } else {
            throw new IndexIndicatorException();
        }
    }

    private void validate() throws IOException {
        long size = this.inCounted.getSize();
        long j11 = this.compressedSizeInHeader;
        if (j11 == -1 || j11 == size) {
            long j12 = this.uncompressedSizeInHeader;
            if (j12 == -1 || j12 == this.uncompressedSize) {
                while (true) {
                    long j13 = 1 + size;
                    if ((size & 3) == 0) {
                        byte[] bArr = new byte[this.check.getSize()];
                        this.inData.readFully(bArr);
                        if (this.verifyCheck && !Arrays.equals(this.check.finish(), bArr)) {
                            throw new CorruptedInputException("Integrity check (" + this.check.getName() + ") does not match");
                        }
                        return;
                    } else if (this.inData.readUnsignedByte() == 0) {
                        size = j13;
                    } else {
                        throw new CorruptedInputException();
                    }
                }
            }
        }
        throw new CorruptedInputException();
    }

    public int available() throws IOException {
        return this.filterChain.available();
    }

    public void close() {
        try {
            this.filterChain.close();
        } catch (IOException unused) {
        }
        this.filterChain = null;
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public long getUnpaddedSize() {
        return ((long) this.headerSize) + this.inCounted.getSize() + ((long) this.check.getSize());
    }

    public int read() throws IOException {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (r0 == -1) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(byte[] r8, int r9, int r10) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.endReached
            r1 = -1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.io.InputStream r0 = r7.filterChain
            int r0 = r0.read(r8, r9, r10)
            r2 = 1
            if (r0 <= 0) goto L_0x005d
            boolean r3 = r7.verifyCheck
            if (r3 == 0) goto L_0x0018
            org.tukaani.xz.check.Check r3 = r7.check
            r3.update(r8, r9, r0)
        L_0x0018:
            long r8 = r7.uncompressedSize
            long r3 = (long) r0
            long r8 = r8 + r3
            r7.uncompressedSize = r8
            org.tukaani.xz.CountingInputStream r8 = r7.inCounted
            long r8 = r8.getSize()
            r3 = 0
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0057
            long r5 = r7.compressedSizeLimit
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x0057
            long r8 = r7.uncompressedSize
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x0057
            long r3 = r7.uncompressedSizeInHeader
            r5 = -1
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x0042
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0057
        L_0x0042:
            if (r0 < r10) goto L_0x0048
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0064
        L_0x0048:
            java.io.InputStream r8 = r7.filterChain
            int r8 = r8.read()
            if (r8 != r1) goto L_0x0051
            goto L_0x005f
        L_0x0051:
            org.tukaani.xz.CorruptedInputException r8 = new org.tukaani.xz.CorruptedInputException
            r8.<init>()
            throw r8
        L_0x0057:
            org.tukaani.xz.CorruptedInputException r8 = new org.tukaani.xz.CorruptedInputException
            r8.<init>()
            throw r8
        L_0x005d:
            if (r0 != r1) goto L_0x0064
        L_0x005f:
            r7.validate()
            r7.endReached = r2
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.BlockInputStream.read(byte[], int, int):int");
    }
}
