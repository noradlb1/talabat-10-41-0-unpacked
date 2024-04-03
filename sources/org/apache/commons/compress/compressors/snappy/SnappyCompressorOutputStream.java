package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;
import s20.b;

public class SnappyCompressorOutputStream extends CompressorOutputStream {
    private static final int FOUR_BYTE_COPY_TAG = 3;
    private static final int FOUR_SIZE_BYTE_MARKER = 252;
    private static final int MAX_LITERAL_SIZE_WITHOUT_SIZE_BYTES = 60;
    private static final int MAX_LITERAL_SIZE_WITH_ONE_SIZE_BYTE = 256;
    private static final int MAX_LITERAL_SIZE_WITH_THREE_SIZE_BYTES = 16777216;
    private static final int MAX_LITERAL_SIZE_WITH_TWO_SIZE_BYTES = 65536;
    private static final int MAX_MATCH_LENGTH = 64;
    private static final int MAX_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 11;
    private static final int MAX_OFFSET_WITH_ONE_OFFSET_BYTE = 1024;
    private static final int MAX_OFFSET_WITH_TWO_OFFSET_BYTES = 32768;
    private static final int MIN_MATCH_LENGTH = 4;
    private static final int MIN_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 4;
    private static final int ONE_BYTE_COPY_TAG = 1;
    private static final int ONE_SIZE_BYTE_MARKER = 240;
    private static final int THREE_SIZE_BYTE_MARKER = 248;
    private static final int TWO_BYTE_COPY_TAG = 2;
    private static final int TWO_SIZE_BYTE_MARKER = 244;
    private final LZ77Compressor compressor;
    private final ByteUtils.ByteConsumer consumer;
    private boolean finished;
    private final byte[] oneByte;

    /* renamed from: os  reason: collision with root package name */
    private final OutputStream f27722os;

    /* renamed from: org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27723a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType[] r0 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27723a = r0
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType r1 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.LITERAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27723a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType r1 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.BACK_REFERENCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27723a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType r1 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.EOD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream.AnonymousClass1.<clinit>():void");
        }
    }

    public SnappyCompressorOutputStream(OutputStream outputStream, long j11) throws IOException {
        this(outputStream, j11, 32768);
    }

    public static Parameters.Builder createParameterBuilder(int i11) {
        return Parameters.builder(i11).withMinBackReferenceLength(4).withMaxBackReferenceLength(64).withMaxOffset(i11).withMaxLiteralLength(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(LZ77Compressor.Block block) throws IOException {
        int i11 = AnonymousClass1.f27723a[block.getType().ordinal()];
        if (i11 == 1) {
            writeLiteralBlock((LZ77Compressor.LiteralBlock) block);
        } else if (i11 == 2) {
            writeBackReference((LZ77Compressor.BackReference) block);
        }
    }

    private void writeBackReference(LZ77Compressor.BackReference backReference) throws IOException {
        int length = backReference.getLength();
        int offset = backReference.getOffset();
        if (length >= 4 && length <= 11 && offset <= 1024) {
            writeBackReferenceWithOneOffsetByte(length, offset);
        } else if (offset < 32768) {
            writeBackReferenceWithTwoOffsetBytes(length, offset);
        } else {
            writeBackReferenceWithFourOffsetBytes(length, offset);
        }
    }

    private void writeBackReferenceWithFourOffsetBytes(int i11, int i12) throws IOException {
        writeBackReferenceWithLittleEndianOffset(3, 4, i11, i12);
    }

    private void writeBackReferenceWithLittleEndianOffset(int i11, int i12, int i13, int i14) throws IOException {
        this.f27722os.write(i11 | ((i13 - 1) << 2));
        writeLittleEndian(i12, i14);
    }

    private void writeBackReferenceWithOneOffsetByte(int i11, int i12) throws IOException {
        this.f27722os.write(((i11 - 4) << 2) | 1 | ((i12 & 1792) >> 3));
        this.f27722os.write(i12 & 255);
    }

    private void writeBackReferenceWithTwoOffsetBytes(int i11, int i12) throws IOException {
        writeBackReferenceWithLittleEndianOffset(2, 2, i11, i12);
    }

    private void writeLiteralBlock(LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        int length = literalBlock.getLength();
        if (length <= 60) {
            writeLiteralBlockNoSizeBytes(literalBlock, length);
        } else if (length <= 256) {
            writeLiteralBlockOneSizeByte(literalBlock, length);
        } else if (length <= 65536) {
            writeLiteralBlockTwoSizeBytes(literalBlock, length);
        } else if (length <= 16777216) {
            writeLiteralBlockThreeSizeBytes(literalBlock, length);
        } else {
            writeLiteralBlockFourSizeBytes(literalBlock, length);
        }
    }

    private void writeLiteralBlockFourSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i11) throws IOException {
        writeLiteralBlockWithSize(FOUR_SIZE_BYTE_MARKER, 4, i11, literalBlock);
    }

    private void writeLiteralBlockNoSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i11) throws IOException {
        writeLiteralBlockWithSize((i11 - 1) << 2, 0, i11, literalBlock);
    }

    private void writeLiteralBlockOneSizeByte(LZ77Compressor.LiteralBlock literalBlock, int i11) throws IOException {
        writeLiteralBlockWithSize(240, 1, i11, literalBlock);
    }

    private void writeLiteralBlockThreeSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i11) throws IOException {
        writeLiteralBlockWithSize(THREE_SIZE_BYTE_MARKER, 3, i11, literalBlock);
    }

    private void writeLiteralBlockTwoSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i11) throws IOException {
        writeLiteralBlockWithSize(TWO_SIZE_BYTE_MARKER, 2, i11, literalBlock);
    }

    private void writeLiteralBlockWithSize(int i11, int i12, int i13, LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        this.f27722os.write(i11);
        writeLittleEndian(i12, i13 - 1);
        this.f27722os.write(literalBlock.getData(), literalBlock.getOffset(), i13);
    }

    private void writeLittleEndian(int i11, int i12) throws IOException {
        ByteUtils.toLittleEndian(this.consumer, (long) i12, i11);
    }

    private void writeUncompressedSize(long j11) throws IOException {
        boolean z11;
        do {
            int i11 = (int) (127 & j11);
            z11 = j11 > ((long) i11);
            if (z11) {
                i11 |= 128;
            }
            this.f27722os.write(i11);
            j11 >>= 7;
        } while (z11);
    }

    public void close() throws IOException {
        try {
            finish();
        } finally {
            this.f27722os.close();
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            this.compressor.finish();
            this.finished = true;
        }
    }

    public void write(int i11) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i11 & 255);
        write(bArr);
    }

    public SnappyCompressorOutputStream(OutputStream outputStream, long j11, int i11) throws IOException {
        this(outputStream, j11, createParameterBuilder(i11).build());
    }

    public SnappyCompressorOutputStream(OutputStream outputStream, long j11, Parameters parameters) throws IOException {
        this.oneByte = new byte[1];
        this.f27722os = outputStream;
        this.consumer = new ByteUtils.OutputStreamByteConsumer(outputStream);
        this.compressor = new LZ77Compressor(parameters, new b(this));
        writeUncompressedSize(j11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.compressor.compress(bArr, i11, i12);
    }
}
