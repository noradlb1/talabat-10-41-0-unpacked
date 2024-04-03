package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import s20.a;

public class FramedSnappyCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    static final int COMPRESSED_CHUNK_TYPE = 0;
    static final long MASK_OFFSET = 2726488792L;
    private static final int MAX_SKIPPABLE_TYPE = 253;
    private static final int MAX_UNSKIPPABLE_TYPE = 127;
    private static final int MIN_UNSKIPPABLE_TYPE = 2;
    private static final int PADDING_CHUNK_TYPE = 254;
    private static final int STREAM_IDENTIFIER_TYPE = 255;
    static final byte[] SZ_SIGNATURE = {-1, 6, 0, 0, 115, 78, 97, 80, 112, 89};
    private static final int UNCOMPRESSED_CHUNK_TYPE = 1;
    private final int blockSize;
    private final PureJavaCrc32C checksum;
    private final CountingInputStream countingStream;
    private SnappyCompressorInputStream currentCompressedChunk;
    private final FramedSnappyDialect dialect;
    private boolean endReached;
    private long expectedChecksum;
    private boolean inUncompressedChunk;
    private final PushbackInputStream inputStream;
    private final byte[] oneByte;
    private final ByteUtils.ByteSupplier supplier;
    private int uncompressedBytesRemaining;
    private long unreadBytes;

    public FramedSnappyCompressorInputStream(InputStream inputStream2) throws IOException {
        this(inputStream2, FramedSnappyDialect.STANDARD);
    }

    public static boolean matches(byte[] bArr, int i11) {
        byte[] bArr2 = SZ_SIGNATURE;
        if (i11 < bArr2.length) {
            return false;
        }
        if (bArr.length > bArr2.length) {
            byte[] bArr3 = new byte[bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr2.length);
            bArr = bArr3;
        }
        return Arrays.equals(bArr, bArr2);
    }

    private long readCrc() throws IOException {
        byte[] bArr = new byte[4];
        int readFully = IOUtils.readFully((InputStream) this.inputStream, bArr);
        count(readFully);
        if (readFully == 4) {
            return ByteUtils.fromLittleEndian(bArr);
        }
        throw new IOException("Premature end of stream");
    }

    private void readNextBlock() throws IOException {
        long j11;
        verifyLastChecksumAndReset();
        this.inUncompressedChunk = false;
        int readOneByte = readOneByte();
        if (readOneByte == -1) {
            this.endReached = true;
        } else if (readOneByte == 255) {
            this.inputStream.unread(readOneByte);
            this.unreadBytes++;
            pushedBackBytes(1);
            readStreamIdentifier();
            readNextBlock();
        } else if (readOneByte == PADDING_CHUNK_TYPE || (readOneByte > 127 && readOneByte <= MAX_SKIPPABLE_TYPE)) {
            skipBlock();
            readNextBlock();
        } else if (readOneByte >= 2 && readOneByte <= 127) {
            throw new IOException("Unskippable chunk with type " + readOneByte + " (hex " + Integer.toHexString(readOneByte) + ") detected.");
        } else if (readOneByte == 1) {
            this.inUncompressedChunk = true;
            int readSize = readSize() - 4;
            this.uncompressedBytesRemaining = readSize;
            if (readSize >= 0) {
                this.expectedChecksum = unmask(readCrc());
                return;
            }
            throw new IOException("Found illegal chunk with negative size");
        } else if (readOneByte == 0) {
            boolean usesChecksumWithCompressedChunks = this.dialect.usesChecksumWithCompressedChunks();
            long readSize2 = (long) readSize();
            if (usesChecksumWithCompressedChunks) {
                j11 = 4;
            } else {
                j11 = 0;
            }
            long j12 = readSize2 - j11;
            if (j12 >= 0) {
                if (usesChecksumWithCompressedChunks) {
                    this.expectedChecksum = unmask(readCrc());
                } else {
                    this.expectedChecksum = -1;
                }
                SnappyCompressorInputStream snappyCompressorInputStream = new SnappyCompressorInputStream(new BoundedInputStream(this.inputStream, j12), this.blockSize);
                this.currentCompressedChunk = snappyCompressorInputStream;
                count(snappyCompressorInputStream.getBytesRead());
                return;
            }
            throw new IOException("Found illegal chunk with negative size");
        } else {
            throw new IOException("Unknown chunk type " + readOneByte + " detected.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int readOnce(byte[] r5, int r6, int r7) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r4.inUncompressedChunk
            r1 = -1
            if (r0 == 0) goto L_0x001f
            int r0 = r4.uncompressedBytesRemaining
            int r7 = java.lang.Math.min(r0, r7)
            if (r7 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.io.PushbackInputStream r0 = r4.inputStream
            int r7 = r0.read(r5, r6, r7)
            if (r7 == r1) goto L_0x0042
            int r0 = r4.uncompressedBytesRemaining
            int r0 = r0 - r7
            r4.uncompressedBytesRemaining = r0
            r4.count((int) r7)
            goto L_0x0042
        L_0x001f:
            org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream r0 = r4.currentCompressedChunk
            if (r0 == 0) goto L_0x0043
            long r2 = r0.getBytesRead()
            org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream r0 = r4.currentCompressedChunk
            int r7 = r0.read(r5, r6, r7)
            if (r7 != r1) goto L_0x0038
            org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream r0 = r4.currentCompressedChunk
            r0.close()
            r0 = 0
            r4.currentCompressedChunk = r0
            goto L_0x0042
        L_0x0038:
            org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream r0 = r4.currentCompressedChunk
            long r0 = r0.getBytesRead()
            long r0 = r0 - r2
            r4.count((long) r0)
        L_0x0042:
            r1 = r7
        L_0x0043:
            if (r1 <= 0) goto L_0x004a
            org.apache.commons.compress.compressors.snappy.PureJavaCrc32C r7 = r4.checksum
            r7.update(r5, r6, r1)
        L_0x004a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorInputStream.readOnce(byte[], int, int):int");
    }

    /* access modifiers changed from: private */
    public int readOneByte() throws IOException {
        int read = this.inputStream.read();
        if (read == -1) {
            return -1;
        }
        count(1);
        return read & 255;
    }

    private int readSize() throws IOException {
        return (int) ByteUtils.fromLittleEndian(this.supplier, 3);
    }

    private void readStreamIdentifier() throws IOException {
        byte[] bArr = new byte[10];
        int readFully = IOUtils.readFully((InputStream) this.inputStream, bArr);
        count(readFully);
        if (10 != readFully || !matches(bArr, 10)) {
            throw new IOException("Not a framed Snappy stream");
        }
    }

    private void skipBlock() throws IOException {
        int readSize = readSize();
        if (readSize >= 0) {
            long j11 = (long) readSize;
            long skip = IOUtils.skip(this.inputStream, j11);
            count(skip);
            if (skip != j11) {
                throw new IOException("Premature end of stream");
            }
            return;
        }
        throw new IOException("Found illegal chunk with negative size");
    }

    public static long unmask(long j11) {
        long j12 = (j11 - MASK_OFFSET) & 4294967295L;
        return ((j12 << 15) | (j12 >> 17)) & 4294967295L;
    }

    private void verifyLastChecksumAndReset() throws IOException {
        long j11 = this.expectedChecksum;
        if (j11 < 0 || j11 == this.checksum.getValue()) {
            this.expectedChecksum = -1;
            this.checksum.reset();
            return;
        }
        throw new IOException("Checksum verification failed");
    }

    public int available() throws IOException {
        if (this.inUncompressedChunk) {
            return Math.min(this.uncompressedBytesRemaining, this.inputStream.available());
        }
        SnappyCompressorInputStream snappyCompressorInputStream = this.currentCompressedChunk;
        if (snappyCompressorInputStream != null) {
            return snappyCompressorInputStream.available();
        }
        return 0;
    }

    public void close() throws IOException {
        try {
            SnappyCompressorInputStream snappyCompressorInputStream = this.currentCompressedChunk;
            if (snappyCompressorInputStream != null) {
                snappyCompressorInputStream.close();
                this.currentCompressedChunk = null;
            }
        } finally {
            this.inputStream.close();
        }
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead() - this.unreadBytes;
    }

    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & 255;
    }

    public FramedSnappyCompressorInputStream(InputStream inputStream2, FramedSnappyDialect framedSnappyDialect) throws IOException {
        this(inputStream2, 32768, framedSnappyDialect);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        int readOnce = readOnce(bArr, i11, i12);
        if (readOnce != -1) {
            return readOnce;
        }
        readNextBlock();
        if (this.endReached) {
            return -1;
        }
        return readOnce(bArr, i11, i12);
    }

    public FramedSnappyCompressorInputStream(InputStream inputStream2, int i11, FramedSnappyDialect framedSnappyDialect) throws IOException {
        this.oneByte = new byte[1];
        this.expectedChecksum = -1;
        this.checksum = new PureJavaCrc32C();
        this.supplier = new a(this);
        if (i11 > 0) {
            CountingInputStream countingInputStream = new CountingInputStream(inputStream2);
            this.countingStream = countingInputStream;
            this.inputStream = new PushbackInputStream(countingInputStream, 1);
            this.blockSize = i11;
            this.dialect = framedSnappyDialect;
            if (framedSnappyDialect.hasStreamIdentifier()) {
                readStreamIdentifier();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("blockSize must be bigger than 0");
    }
}
