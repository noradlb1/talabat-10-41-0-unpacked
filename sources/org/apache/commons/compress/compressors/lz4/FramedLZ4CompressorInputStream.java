package org.apache.commons.compress.compressors.lz4;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.ChecksumCalculatingInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import q20.b;

public class FramedLZ4CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    static final int BLOCK_CHECKSUM_MASK = 16;
    static final int BLOCK_INDEPENDENCE_MASK = 32;
    static final int BLOCK_MAX_SIZE_MASK = 112;
    static final int CONTENT_CHECKSUM_MASK = 4;
    static final int CONTENT_SIZE_MASK = 8;
    static final byte[] LZ4_SIGNATURE = {4, 34, 77, Ascii.CAN};
    private static final byte SKIPPABLE_FRAME_PREFIX_BYTE_MASK = 80;
    private static final byte[] SKIPPABLE_FRAME_TRAILER = {42, 77, Ascii.CAN};
    static final int SUPPORTED_VERSION = 64;
    static final int UNCOMPRESSED_FLAG_MASK = Integer.MIN_VALUE;
    static final int VERSION_MASK = 192;
    private byte[] blockDependencyBuffer;
    private final XXHash32 blockHash;
    private final XXHash32 contentHash;
    private InputStream currentBlock;
    private final boolean decompressConcatenated;
    private boolean endReached;
    private boolean expectBlockChecksum;
    private boolean expectBlockDependency;
    private boolean expectContentChecksum;
    private boolean expectContentSize;
    private boolean inUncompressed;
    private final CountingInputStream inputStream;
    private final byte[] oneByte;
    private final ByteUtils.ByteSupplier supplier;

    public FramedLZ4CompressorInputStream(InputStream inputStream2) throws IOException {
        this(inputStream2, false);
    }

    private void appendToBlockDependencyBuffer(byte[] bArr, int i11, int i12) {
        int min = Math.min(i12, this.blockDependencyBuffer.length);
        if (min > 0) {
            byte[] bArr2 = this.blockDependencyBuffer;
            int length = bArr2.length - min;
            if (length > 0) {
                System.arraycopy(bArr2, min, bArr2, 0, length);
            }
            System.arraycopy(bArr, i11, this.blockDependencyBuffer, length, min);
        }
    }

    private void init(boolean z11) throws IOException {
        if (readSignature(z11)) {
            readFrameDescriptor();
            nextBlock();
        }
    }

    private static boolean isSkippableFrameSignature(byte[] bArr) {
        if ((bArr[0] & SKIPPABLE_FRAME_PREFIX_BYTE_MASK) != 80) {
            return false;
        }
        for (int i11 = 1; i11 < 4; i11++) {
            if (bArr[i11] != SKIPPABLE_FRAME_TRAILER[i11 - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean matches(byte[] bArr, int i11) {
        byte[] bArr2 = LZ4_SIGNATURE;
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

    private void maybeFinishCurrentBlock() throws IOException {
        InputStream inputStream2 = this.currentBlock;
        if (inputStream2 != null) {
            inputStream2.close();
            this.currentBlock = null;
            if (this.expectBlockChecksum) {
                verifyChecksum(this.blockHash, "block");
                this.blockHash.reset();
            }
        }
    }

    private void nextBlock() throws IOException {
        boolean z11;
        maybeFinishCurrentBlock();
        long fromLittleEndian = ByteUtils.fromLittleEndian(this.supplier, 4);
        if ((-2147483648L & fromLittleEndian) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i11 = (int) (fromLittleEndian & 2147483647L);
        if (i11 < 0) {
            throw new IOException("Found illegal block with negative size");
        } else if (i11 == 0) {
            verifyContentChecksum();
            if (!this.decompressConcatenated) {
                this.endReached = true;
            } else {
                init(false);
            }
        } else {
            InputStream boundedInputStream = new BoundedInputStream(this.inputStream, (long) i11);
            if (this.expectBlockChecksum) {
                boundedInputStream = new ChecksumCalculatingInputStream(this.blockHash, boundedInputStream);
            }
            if (z11) {
                this.inUncompressed = true;
                this.currentBlock = boundedInputStream;
                return;
            }
            this.inUncompressed = false;
            BlockLZ4CompressorInputStream blockLZ4CompressorInputStream = new BlockLZ4CompressorInputStream(boundedInputStream);
            if (this.expectBlockDependency) {
                blockLZ4CompressorInputStream.prefill(this.blockDependencyBuffer);
            }
            this.currentBlock = blockLZ4CompressorInputStream;
        }
    }

    private void readFrameDescriptor() throws IOException {
        boolean z11;
        boolean z12;
        boolean z13;
        int readOneByte = readOneByte();
        if (readOneByte != -1) {
            this.contentHash.update(readOneByte);
            if ((readOneByte & 192) == 64) {
                boolean z14 = true;
                if ((readOneByte & 32) == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                this.expectBlockDependency = z11;
                if (!z11) {
                    this.blockDependencyBuffer = null;
                } else if (this.blockDependencyBuffer == null) {
                    this.blockDependencyBuffer = new byte[65536];
                }
                if ((readOneByte & 16) != 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                this.expectBlockChecksum = z12;
                if ((readOneByte & 8) != 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                this.expectContentSize = z13;
                if ((readOneByte & 4) == 0) {
                    z14 = false;
                }
                this.expectContentChecksum = z14;
                int readOneByte2 = readOneByte();
                if (readOneByte2 != -1) {
                    this.contentHash.update(readOneByte2);
                    if (this.expectContentSize) {
                        byte[] bArr = new byte[8];
                        int readFully = IOUtils.readFully((InputStream) this.inputStream, bArr);
                        count(readFully);
                        if (8 == readFully) {
                            this.contentHash.update(bArr, 0, 8);
                        } else {
                            throw new IOException("Premature end of stream while reading content size");
                        }
                    }
                    int readOneByte3 = readOneByte();
                    if (readOneByte3 != -1) {
                        int value = (int) ((this.contentHash.getValue() >> 8) & 255);
                        this.contentHash.reset();
                        if (readOneByte3 != value) {
                            throw new IOException("Frame header checksum mismatch");
                        }
                        return;
                    }
                    throw new IOException("Premature end of stream while reading frame header checksum");
                }
                throw new IOException("Premature end of stream while reading frame BD byte");
            }
            throw new IOException("Unsupported version " + (readOneByte >> 6));
        }
        throw new IOException("Premature end of stream while reading frame flags");
    }

    private int readOnce(byte[] bArr, int i11, int i12) throws IOException {
        if (this.inUncompressed) {
            int read = this.currentBlock.read(bArr, i11, i12);
            count(read);
            return read;
        }
        BlockLZ4CompressorInputStream blockLZ4CompressorInputStream = (BlockLZ4CompressorInputStream) this.currentBlock;
        long bytesRead = blockLZ4CompressorInputStream.getBytesRead();
        int read2 = this.currentBlock.read(bArr, i11, i12);
        count(blockLZ4CompressorInputStream.getBytesRead() - bytesRead);
        return read2;
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

    private boolean readSignature(boolean z11) throws IOException {
        String str;
        if (z11) {
            str = "Not a LZ4 frame stream";
        } else {
            str = "LZ4 frame stream followed by garbage";
        }
        byte[] bArr = new byte[4];
        int readFully = IOUtils.readFully((InputStream) this.inputStream, bArr);
        count(readFully);
        if (readFully == 0 && !z11) {
            this.endReached = true;
            return false;
        } else if (4 == readFully) {
            int skipSkippableFrame = skipSkippableFrame(bArr);
            if (skipSkippableFrame == 0 && !z11) {
                this.endReached = true;
                return false;
            } else if (4 == skipSkippableFrame && matches(bArr, 4)) {
                return true;
            } else {
                throw new IOException(str);
            }
        } else {
            throw new IOException(str);
        }
    }

    private int skipSkippableFrame(byte[] bArr) throws IOException {
        int i11 = 4;
        while (i11 == 4 && isSkippableFrameSignature(bArr)) {
            long fromLittleEndian = ByteUtils.fromLittleEndian(this.supplier, 4);
            if (fromLittleEndian >= 0) {
                long skip = IOUtils.skip(this.inputStream, fromLittleEndian);
                count(skip);
                if (fromLittleEndian == skip) {
                    i11 = IOUtils.readFully((InputStream) this.inputStream, bArr);
                    count(i11);
                } else {
                    throw new IOException("Premature end of stream while skipping frame");
                }
            } else {
                throw new IOException("Found illegal skippable frame with negative size");
            }
        }
        return i11;
    }

    private void verifyChecksum(XXHash32 xXHash32, String str) throws IOException {
        byte[] bArr = new byte[4];
        int readFully = IOUtils.readFully((InputStream) this.inputStream, bArr);
        count(readFully);
        if (4 != readFully) {
            throw new IOException("Premature end of stream while reading " + str + " checksum");
        } else if (xXHash32.getValue() != ByteUtils.fromLittleEndian(bArr)) {
            throw new IOException(str + " checksum mismatch.");
        }
    }

    private void verifyContentChecksum() throws IOException {
        if (this.expectContentChecksum) {
            verifyChecksum(this.contentHash, "content");
        }
        this.contentHash.reset();
    }

    public void close() throws IOException {
        try {
            InputStream inputStream2 = this.currentBlock;
            if (inputStream2 != null) {
                inputStream2.close();
                this.currentBlock = null;
            }
        } finally {
            this.inputStream.close();
        }
    }

    public long getCompressedCount() {
        return this.inputStream.getBytesRead();
    }

    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & 255;
    }

    public FramedLZ4CompressorInputStream(InputStream inputStream2, boolean z11) throws IOException {
        this.oneByte = new byte[1];
        this.supplier = new b(this);
        this.contentHash = new XXHash32();
        this.blockHash = new XXHash32();
        this.inputStream = new CountingInputStream(inputStream2);
        this.decompressConcatenated = z11;
        init(true);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        if (this.endReached) {
            return -1;
        }
        int readOnce = readOnce(bArr, i11, i12);
        if (readOnce == -1) {
            nextBlock();
            if (!this.endReached) {
                readOnce = readOnce(bArr, i11, i12);
            }
        }
        if (readOnce != -1) {
            if (this.expectBlockDependency) {
                appendToBlockDependencyBuffer(bArr, i11, readOnce);
            }
            if (this.expectContentChecksum) {
                this.contentHash.update(bArr, i11, readOnce);
            }
        }
        return readOnce;
    }
}
