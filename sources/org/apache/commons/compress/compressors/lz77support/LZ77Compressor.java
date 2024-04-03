package org.apache.commons.compress.compressors.lz77support;

import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class LZ77Compressor {
    private static final int HASH_MASK = 32767;
    private static final int HASH_SIZE = 32768;
    private static final int H_SHIFT = 5;
    private static final int NO_MATCH = -1;
    static final int NUMBER_OF_BYTES_IN_HASH = 3;
    private static final Block THE_EOD = new EOD();
    private int blockStart;
    private final Callback callback;
    private int currentPosition;
    private final int[] head;
    private boolean initialized;
    private int insertHash;
    private int lookahead;
    private int matchStart = -1;
    private int missedInserts;
    private final Parameters params;
    private final int[] prev;
    private final int wMask;
    private final byte[] window;

    public static final class BackReference extends Block {
        private final int length;
        private final int offset;

        public BackReference(int i11, int i12) {
            this.offset = i11;
            this.length = i12;
        }

        public int getLength() {
            return this.length;
        }

        public int getOffset() {
            return this.offset;
        }

        public Block.BlockType getType() {
            return Block.BlockType.BACK_REFERENCE;
        }

        public String toString() {
            return "BackReference with offset " + this.offset + " and length " + this.length;
        }
    }

    public static abstract class Block {

        public enum BlockType {
            LITERAL,
            BACK_REFERENCE,
            EOD
        }

        public abstract BlockType getType();
    }

    public interface Callback {
        void accept(Block block) throws IOException;
    }

    public static final class EOD extends Block {
        public Block.BlockType getType() {
            return Block.BlockType.EOD;
        }
    }

    public static final class LiteralBlock extends Block {
        private final byte[] data;
        private final int length;
        private final int offset;

        public LiteralBlock(byte[] bArr, int i11, int i12) {
            this.data = bArr;
            this.offset = i11;
            this.length = i12;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getLength() {
            return this.length;
        }

        public int getOffset() {
            return this.offset;
        }

        public Block.BlockType getType() {
            return Block.BlockType.LITERAL;
        }

        public String toString() {
            return "LiteralBlock starting at " + this.offset + " with length " + this.length;
        }
    }

    public LZ77Compressor(Parameters parameters, Callback callback2) {
        Objects.requireNonNull(parameters, NativeProtocol.WEB_DIALOG_PARAMS);
        Objects.requireNonNull(callback2, "callback");
        this.params = parameters;
        this.callback = callback2;
        int windowSize = parameters.getWindowSize();
        this.window = new byte[(windowSize * 2)];
        this.wMask = windowSize - 1;
        int[] iArr = new int[32768];
        this.head = iArr;
        Arrays.fill(iArr, -1);
        this.prev = new int[windowSize];
    }

    private void catchUpMissedInserts() {
        while (true) {
            int i11 = this.missedInserts;
            if (i11 > 0) {
                int i12 = this.currentPosition;
                this.missedInserts = i11 - 1;
                insertString(i12 - i11);
            } else {
                return;
            }
        }
    }

    private void doCompress(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 > (this.window.length - this.currentPosition) - this.lookahead) {
            slide();
        }
        System.arraycopy(bArr, i11, this.window, this.currentPosition + this.lookahead, i12);
        int i13 = this.lookahead + i12;
        this.lookahead = i13;
        if (!this.initialized && i13 >= this.params.getMinBackReferenceLength()) {
            initialize();
        }
        if (this.initialized) {
            compress();
        }
    }

    private void flushBackReference(int i11) throws IOException {
        this.callback.accept(new BackReference(this.currentPosition - this.matchStart, i11));
    }

    private void flushLiteralBlock() throws IOException {
        Callback callback2 = this.callback;
        byte[] bArr = this.window;
        int i11 = this.blockStart;
        callback2.accept(new LiteralBlock(bArr, i11, this.currentPosition - i11));
    }

    private void initialize() {
        for (int i11 = 0; i11 < 2; i11++) {
            this.insertHash = nextHash(this.insertHash, this.window[i11]);
        }
        this.initialized = true;
    }

    private int insertString(int i11) {
        int nextHash = nextHash(this.insertHash, this.window[(i11 - 1) + 3]);
        this.insertHash = nextHash;
        int[] iArr = this.head;
        int i12 = iArr[nextHash];
        this.prev[this.wMask & i11] = i12;
        iArr[nextHash] = i11;
        return i12;
    }

    private void insertStringsInMatch(int i11) {
        int min = Math.min(i11 - 1, this.lookahead - 3);
        for (int i12 = 1; i12 <= min; i12++) {
            insertString(this.currentPosition + i12);
        }
        this.missedInserts = (i11 - min) - 1;
    }

    private int longestMatch(int i11) {
        int minBackReferenceLength = this.params.getMinBackReferenceLength() - 1;
        int min = Math.min(this.params.getMaxBackReferenceLength(), this.lookahead);
        int max = Math.max(0, this.currentPosition - this.params.getMaxOffset());
        int min2 = Math.min(min, this.params.getNiceBackReferenceLength());
        int maxCandidates = this.params.getMaxCandidates();
        for (int i12 = 0; i12 < maxCandidates && i11 >= max; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < min; i14++) {
                byte[] bArr = this.window;
                if (bArr[i11 + i14] != bArr[this.currentPosition + i14]) {
                    break;
                }
                i13++;
            }
            if (i13 > minBackReferenceLength) {
                this.matchStart = i11;
                minBackReferenceLength = i13;
                if (i13 >= min2) {
                    break;
                }
            }
            i11 = this.prev[i11 & this.wMask];
        }
        return minBackReferenceLength;
    }

    private int longestMatchForNextPosition(int i11) {
        int i12 = this.matchStart;
        int i13 = this.insertHash;
        this.lookahead--;
        int i14 = this.currentPosition + 1;
        this.currentPosition = i14;
        int insertString = insertString(i14);
        int i15 = this.prev[this.currentPosition & this.wMask];
        int longestMatch = longestMatch(insertString);
        if (longestMatch > i11) {
            return longestMatch;
        }
        this.matchStart = i12;
        this.head[this.insertHash] = i15;
        this.insertHash = i13;
        this.currentPosition--;
        this.lookahead++;
        return i11;
    }

    private int nextHash(int i11, byte b11) {
        return ((i11 << 5) ^ (b11 & 255)) & 32767;
    }

    private void slide() throws IOException {
        int i11;
        int windowSize = this.params.getWindowSize();
        int i12 = this.blockStart;
        if (i12 != this.currentPosition && i12 < windowSize) {
            flushLiteralBlock();
            this.blockStart = this.currentPosition;
        }
        byte[] bArr = this.window;
        System.arraycopy(bArr, windowSize, bArr, 0, windowSize);
        this.currentPosition -= windowSize;
        this.matchStart -= windowSize;
        this.blockStart -= windowSize;
        int i13 = 0;
        while (true) {
            int i14 = -1;
            if (i13 >= 32768) {
                break;
            }
            int[] iArr = this.head;
            int i15 = iArr[i13];
            if (i15 >= windowSize) {
                i14 = i15 - windowSize;
            }
            iArr[i13] = i14;
            i13++;
        }
        for (int i16 = 0; i16 < windowSize; i16++) {
            int[] iArr2 = this.prev;
            int i17 = iArr2[i16];
            if (i17 >= windowSize) {
                i11 = i17 - windowSize;
            } else {
                i11 = -1;
            }
            iArr2[i16] = i11;
        }
    }

    public void compress(byte[] bArr) throws IOException {
        compress(bArr, 0, bArr.length);
    }

    public void finish() throws IOException {
        int i11 = this.blockStart;
        int i12 = this.currentPosition;
        if (i11 != i12 || this.lookahead > 0) {
            this.currentPosition = i12 + this.lookahead;
            flushLiteralBlock();
        }
        this.callback.accept(THE_EOD);
    }

    public void prefill(byte[] bArr) {
        if (this.currentPosition == 0 && this.lookahead == 0) {
            int min = Math.min(this.params.getWindowSize(), bArr.length);
            System.arraycopy(bArr, bArr.length - min, this.window, 0, min);
            if (min >= 3) {
                initialize();
                int i11 = (min - 3) + 1;
                for (int i12 = 0; i12 < i11; i12++) {
                    insertString(i12);
                }
                this.missedInserts = 2;
            } else {
                this.missedInserts = min;
            }
            this.currentPosition = min;
            this.blockStart = min;
            return;
        }
        throw new IllegalStateException("The compressor has already started to accept data, can't prefill anymore");
    }

    public void compress(byte[] bArr, int i11, int i12) throws IOException {
        int windowSize = this.params.getWindowSize();
        while (i12 > windowSize) {
            doCompress(bArr, i11, windowSize);
            i11 += windowSize;
            i12 -= windowSize;
        }
        if (i12 > 0) {
            doCompress(bArr, i11, i12);
        }
    }

    private void compress() throws IOException {
        int i11;
        int minBackReferenceLength = this.params.getMinBackReferenceLength();
        boolean lazyMatching = this.params.getLazyMatching();
        int lazyMatchingThreshold = this.params.getLazyMatchingThreshold();
        while (this.lookahead >= minBackReferenceLength) {
            catchUpMissedInserts();
            int insertString = insertString(this.currentPosition);
            if (insertString == -1 || insertString - this.currentPosition > this.params.getMaxOffset()) {
                i11 = 0;
            } else {
                i11 = longestMatch(insertString);
                if (lazyMatching && i11 <= lazyMatchingThreshold && this.lookahead > minBackReferenceLength) {
                    i11 = longestMatchForNextPosition(i11);
                }
            }
            if (i11 >= minBackReferenceLength) {
                if (this.blockStart != this.currentPosition) {
                    flushLiteralBlock();
                    this.blockStart = -1;
                }
                flushBackReference(i11);
                insertStringsInMatch(i11);
                this.lookahead -= i11;
                int i12 = this.currentPosition + i11;
                this.currentPosition = i12;
                this.blockStart = i12;
            } else {
                this.lookahead--;
                int i13 = this.currentPosition + 1;
                this.currentPosition = i13;
                if (i13 - this.blockStart >= this.params.getMaxLiteralLength()) {
                    flushLiteralBlock();
                    this.blockStart = this.currentPosition;
                }
            }
        }
    }
}
