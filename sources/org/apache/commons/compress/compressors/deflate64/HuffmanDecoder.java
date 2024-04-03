package org.apache.commons.compress.compressors.deflate64;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import net.bytebuddy.jar.asm.Opcodes;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.ByteUtils;

class HuffmanDecoder implements Closeable {
    private static final int[] CODE_LENGTHS_ORDER = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
    /* access modifiers changed from: private */
    public static final int[] DISTANCE_TABLE = {16, 32, 48, 64, 81, 113, Opcodes.I2C, 210, 275, 403, 532, 788, 1045, 1557, 2070, 3094, 4119, 6167, 8216, 12312, 16409, 24601, 32794, 49178, 65563, 98331, 131100, 196636, 262173, 393245, 524318, 786462};
    private static final int[] FIXED_DISTANCE;
    private static final int[] FIXED_LITERALS;
    /* access modifiers changed from: private */
    public static final short[] RUN_LENGTH_TABLE = {96, 128, 160, 192, 224, 256, 288, 320, 353, 417, 481, 545, 610, 738, 866, 994, 1123, 1379, 1635, 1891, 2148, 2660, 3172, 3684, 4197, 5221, 6245, 7269, 112};
    private boolean finalBlock;
    /* access modifiers changed from: private */

    /* renamed from: in  reason: collision with root package name */
    public final InputStream f27706in;
    /* access modifiers changed from: private */
    public final DecodingMemory memory = new DecodingMemory();
    /* access modifiers changed from: private */
    public BitInputStream reader;
    private DecoderState state;

    public static class BinaryTreeNode {

        /* renamed from: a  reason: collision with root package name */
        public int f27707a;

        /* renamed from: b  reason: collision with root package name */
        public BinaryTreeNode f27708b;
        private final int bits;

        /* renamed from: c  reason: collision with root package name */
        public BinaryTreeNode f27709c;

        public void a(int i11) {
            this.f27707a = i11;
            this.f27708b = null;
            this.f27709c = null;
        }

        public BinaryTreeNode b() {
            if (this.f27708b == null && this.f27707a == -1) {
                this.f27708b = new BinaryTreeNode(this.bits + 1);
            }
            return this.f27708b;
        }

        public BinaryTreeNode c() {
            if (this.f27709c == null && this.f27707a == -1) {
                this.f27709c = new BinaryTreeNode(this.bits + 1);
            }
            return this.f27709c;
        }

        private BinaryTreeNode(int i11) {
            this.f27707a = -1;
            this.bits = i11;
        }
    }

    public static abstract class DecoderState {
        private DecoderState() {
        }

        public abstract int a() throws IOException;

        public abstract boolean b();

        public abstract int c(byte[] bArr, int i11, int i12) throws IOException;

        public abstract HuffmanState d();
    }

    public static class DecodingMemory {
        private final int mask;
        private final byte[] memory;
        private int wHead;
        private boolean wrappedAround;

        private int incCounter(int i11) {
            int i12 = (i11 + 1) & this.mask;
            if (!this.wrappedAround && i12 < i11) {
                this.wrappedAround = true;
            }
            return i12;
        }

        public byte a(byte b11) {
            byte[] bArr = this.memory;
            int i11 = this.wHead;
            bArr[i11] = b11;
            this.wHead = incCounter(i11);
            return b11;
        }

        public void b(byte[] bArr, int i11, int i12) {
            for (int i13 = i11; i13 < i11 + i12; i13++) {
                a(bArr[i13]);
            }
        }

        public void c(int i11, int i12, byte[] bArr) {
            if (i11 <= this.memory.length) {
                int i13 = this.wHead;
                int i14 = (i13 - i11) & this.mask;
                if (this.wrappedAround || i14 < i13) {
                    int i15 = 0;
                    while (i15 < i12) {
                        bArr[i15] = a(this.memory[i14]);
                        i15++;
                        i14 = incCounter(i14);
                    }
                    return;
                }
                throw new IllegalStateException("Attempt to read beyond memory: dist=" + i11);
            }
            throw new IllegalStateException("Illegal distance parameter: " + i11);
        }

        private DecodingMemory() {
            this(16);
        }

        private DecodingMemory(int i11) {
            byte[] bArr = new byte[(1 << i11)];
            this.memory = bArr;
            this.mask = bArr.length - 1;
        }
    }

    public class HuffmanCodes extends DecoderState {
        private final BinaryTreeNode distanceTree;
        private boolean endOfBlock;
        private final BinaryTreeNode lengthTree;
        private byte[] runBuffer = ByteUtils.EMPTY_BYTE_ARRAY;
        private int runBufferLength;
        private int runBufferPos;
        private final HuffmanState state;

        public HuffmanCodes(HuffmanState huffmanState, int[] iArr, int[] iArr2) {
            super();
            this.state = huffmanState;
            this.lengthTree = HuffmanDecoder.buildTree(iArr);
            this.distanceTree = HuffmanDecoder.buildTree(iArr2);
        }

        private int copyFromRunBuffer(byte[] bArr, int i11, int i12) {
            int i13 = this.runBufferLength - this.runBufferPos;
            if (i13 <= 0) {
                return 0;
            }
            int min = Math.min(i12, i13);
            System.arraycopy(this.runBuffer, this.runBufferPos, bArr, i11, min);
            this.runBufferPos += min;
            return min;
        }

        private int decodeNext(byte[] bArr, int i11, int i12) throws IOException {
            if (this.endOfBlock) {
                return -1;
            }
            int copyFromRunBuffer = copyFromRunBuffer(bArr, i11, i12);
            while (true) {
                if (copyFromRunBuffer < i12) {
                    int h11 = HuffmanDecoder.nextSymbol(HuffmanDecoder.this.reader, this.lengthTree);
                    if (h11 >= 256) {
                        if (h11 <= 256) {
                            this.endOfBlock = true;
                            break;
                        }
                        short s11 = HuffmanDecoder.RUN_LENGTH_TABLE[h11 - 257];
                        int d11 = (int) (((long) (s11 >>> 5)) + HuffmanDecoder.this.readBits(s11 & 31));
                        int i13 = HuffmanDecoder.DISTANCE_TABLE[HuffmanDecoder.nextSymbol(HuffmanDecoder.this.reader, this.distanceTree)];
                        int d12 = (int) (((long) (i13 >>> 4)) + HuffmanDecoder.this.readBits(i13 & 15));
                        if (this.runBuffer.length < d11) {
                            this.runBuffer = new byte[d11];
                        }
                        this.runBufferLength = d11;
                        this.runBufferPos = 0;
                        HuffmanDecoder.this.memory.c(d12, d11, this.runBuffer);
                        copyFromRunBuffer += copyFromRunBuffer(bArr, i11 + copyFromRunBuffer, i12 - copyFromRunBuffer);
                    } else {
                        bArr[copyFromRunBuffer + i11] = HuffmanDecoder.this.memory.a((byte) h11);
                        copyFromRunBuffer++;
                    }
                } else {
                    break;
                }
            }
            return copyFromRunBuffer;
        }

        public int a() {
            return this.runBufferLength - this.runBufferPos;
        }

        public boolean b() {
            return !this.endOfBlock;
        }

        public int c(byte[] bArr, int i11, int i12) throws IOException {
            if (i12 == 0) {
                return 0;
            }
            return decodeNext(bArr, i11, i12);
        }

        public HuffmanState d() {
            return this.endOfBlock ? HuffmanState.INITIAL : this.state;
        }
    }

    public static class InitialState extends DecoderState {
        private InitialState() {
            super();
        }

        public int a() {
            return 0;
        }

        public boolean b() {
            return false;
        }

        public int c(byte[] bArr, int i11, int i12) throws IOException {
            if (i12 == 0) {
                return 0;
            }
            throw new IllegalStateException("Cannot read in this state");
        }

        public HuffmanState d() {
            return HuffmanState.INITIAL;
        }
    }

    public class UncompressedState extends DecoderState {
        private final long blockLength;
        private long read;

        public int a() throws IOException {
            return (int) Math.min(this.blockLength - this.read, HuffmanDecoder.this.reader.bitsAvailable() / 8);
        }

        public boolean b() {
            return this.read < this.blockLength;
        }

        public int c(byte[] bArr, int i11, int i12) throws IOException {
            int i13;
            int i14 = 0;
            if (i12 == 0) {
                return 0;
            }
            int min = (int) Math.min(this.blockLength - this.read, (long) i12);
            while (i14 < min) {
                if (HuffmanDecoder.this.reader.bitsCached() > 0) {
                    bArr[i11 + i14] = HuffmanDecoder.this.memory.a((byte) ((int) HuffmanDecoder.this.readBits(8)));
                    i13 = 1;
                } else {
                    int i15 = i11 + i14;
                    i13 = HuffmanDecoder.this.f27706in.read(bArr, i15, min - i14);
                    if (i13 != -1) {
                        HuffmanDecoder.this.memory.b(bArr, i15, i13);
                    } else {
                        throw new EOFException("Truncated Deflate64 Stream");
                    }
                }
                this.read += (long) i13;
                i14 += i13;
            }
            return min;
        }

        public HuffmanState d() {
            return this.read < this.blockLength ? HuffmanState.STORED : HuffmanState.INITIAL;
        }

        private UncompressedState(long j11) {
            super();
            this.blockLength = j11;
        }
    }

    static {
        int[] iArr = new int[288];
        FIXED_LITERALS = iArr;
        Arrays.fill(iArr, 0, Opcodes.D2F, 8);
        Arrays.fill(iArr, Opcodes.D2F, 256, 9);
        Arrays.fill(iArr, 256, 280, 7);
        Arrays.fill(iArr, 280, 288, 8);
        int[] iArr2 = new int[32];
        FIXED_DISTANCE = iArr2;
        Arrays.fill(iArr2, 5);
    }

    public HuffmanDecoder(InputStream inputStream) {
        this.reader = new BitInputStream(inputStream, ByteOrder.LITTLE_ENDIAN);
        this.f27706in = inputStream;
        this.state = new InitialState();
    }

    /* access modifiers changed from: private */
    public static BinaryTreeNode buildTree(int[] iArr) {
        int[] codes = getCodes(iArr);
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(0);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            int i12 = iArr[i11];
            if (i12 != 0) {
                int i13 = i12 - 1;
                int i14 = codes[i13];
                BinaryTreeNode binaryTreeNode2 = binaryTreeNode;
                int i15 = i13;
                while (i15 >= 0) {
                    if (((1 << i15) & i14) == 0) {
                        binaryTreeNode2 = binaryTreeNode2.b();
                    } else {
                        binaryTreeNode2 = binaryTreeNode2.c();
                    }
                    if (binaryTreeNode2 != null) {
                        i15--;
                    } else {
                        throw new IllegalStateException("node doesn't exist in Huffman tree");
                    }
                }
                binaryTreeNode2.a(i11);
                codes[i13] = codes[i13] + 1;
            }
        }
        return binaryTreeNode;
    }

    private static int[] getCodes(int[] iArr) {
        int[] iArr2 = new int[65];
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 < 0 || i12 > 64) {
                throw new IllegalArgumentException("Invalid code " + i12 + " in literal table");
            }
            i11 = Math.max(i11, i12);
            iArr2[i12] = iArr2[i12] + 1;
        }
        int i13 = i11 + 1;
        int[] copyOf = Arrays.copyOf(iArr2, i13);
        int[] iArr3 = new int[i13];
        int i14 = 0;
        for (int i15 = 0; i15 <= i11; i15++) {
            i14 = (i14 + copyOf[i15]) << 1;
            iArr3[i15] = i14;
        }
        return iArr3;
    }

    /* access modifiers changed from: private */
    public static int nextSymbol(BitInputStream bitInputStream, BinaryTreeNode binaryTreeNode) throws IOException {
        while (binaryTreeNode != null && binaryTreeNode.f27707a == -1) {
            if (readBits(bitInputStream, 1) == 0) {
                binaryTreeNode = binaryTreeNode.f27708b;
            } else {
                binaryTreeNode = binaryTreeNode.f27709c;
            }
        }
        if (binaryTreeNode != null) {
            return binaryTreeNode.f27707a;
        }
        return -1;
    }

    private static void populateDynamicTables(BitInputStream bitInputStream, int[] iArr, int[] iArr2) throws IOException {
        long j11;
        int readBits = (int) (readBits(bitInputStream, 4) + 4);
        int[] iArr3 = new int[19];
        for (int i11 = 0; i11 < readBits; i11++) {
            iArr3[CODE_LENGTHS_ORDER[i11]] = (int) readBits(bitInputStream, 3);
        }
        BinaryTreeNode buildTree = buildTree(iArr3);
        int length = iArr.length + iArr2.length;
        int[] iArr4 = new int[length];
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        while (i13 < length) {
            if (i14 > 0) {
                iArr4[i13] = i12;
                i14--;
                i13++;
            } else {
                int nextSymbol = nextSymbol(bitInputStream, buildTree);
                if (nextSymbol < 16) {
                    iArr4[i13] = nextSymbol;
                    i13++;
                    i12 = nextSymbol;
                } else {
                    long j12 = 3;
                    switch (nextSymbol) {
                        case 16:
                            i14 = (int) (readBits(bitInputStream, 2) + 3);
                            continue;
                        case 17:
                            j11 = readBits(bitInputStream, 3);
                            break;
                        case 18:
                            j11 = readBits(bitInputStream, 7);
                            j12 = 11;
                            break;
                    }
                    i14 = (int) (j11 + j12);
                    i12 = 0;
                }
            }
        }
        System.arraycopy(iArr4, 0, iArr, 0, iArr.length);
        System.arraycopy(iArr4, iArr.length, iArr2, 0, iArr2.length);
    }

    /* access modifiers changed from: private */
    public long readBits(int i11) throws IOException {
        return readBits(this.reader, i11);
    }

    private int[][] readDynamicTables() throws IOException {
        int[] iArr = new int[((int) (readBits(5) + 1))];
        int[][] iArr2 = {new int[((int) (readBits(5) + 257))], iArr};
        populateDynamicTables(this.reader, iArr2[0], iArr);
        return iArr2;
    }

    private void switchToUncompressedState() throws IOException {
        this.reader.alignWithByteBoundary();
        long readBits = readBits(16);
        if ((WebSocketProtocol.PAYLOAD_SHORT_MAX & (readBits ^ WebSocketProtocol.PAYLOAD_SHORT_MAX)) == readBits(16)) {
            this.state = new UncompressedState(readBits);
            return;
        }
        throw new IllegalStateException("Illegal LEN / NLEN values");
    }

    public int available() throws IOException {
        return this.state.a();
    }

    public void close() {
        this.state = new InitialState();
        this.reader = null;
    }

    public int decode(byte[] bArr) throws IOException {
        return decode(bArr, 0, bArr.length);
    }

    public long i() {
        return this.reader.getBytesRead();
    }

    private static long readBits(BitInputStream bitInputStream, int i11) throws IOException {
        long readBits = bitInputStream.readBits(i11);
        if (readBits != -1) {
            return readBits;
        }
        throw new EOFException("Truncated Deflate64 Stream");
    }

    public int decode(byte[] bArr, int i11, int i12) throws IOException {
        while (true) {
            if (this.finalBlock && !this.state.b()) {
                return -1;
            }
            if (this.state.d() == HuffmanState.INITIAL) {
                this.finalBlock = readBits(1) == 1;
                int readBits = (int) readBits(2);
                if (readBits == 0) {
                    switchToUncompressedState();
                } else if (readBits == 1) {
                    this.state = new HuffmanCodes(HuffmanState.FIXED_CODES, FIXED_LITERALS, FIXED_DISTANCE);
                } else if (readBits == 2) {
                    int[][] readDynamicTables = readDynamicTables();
                    this.state = new HuffmanCodes(HuffmanState.DYNAMIC_CODES, readDynamicTables[0], readDynamicTables[1]);
                } else {
                    throw new IllegalStateException("Unsupported compression: " + readBits);
                }
            } else {
                int c11 = this.state.c(bArr, i11, i12);
                if (c11 != 0) {
                    return c11;
                }
            }
        }
    }
}
