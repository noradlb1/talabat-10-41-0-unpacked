package org.apache.commons.compress.compressors.lz4;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;
import q20.a;

public class BlockLZ4CompressorOutputStream extends CompressorOutputStream {
    private static final int MIN_BACK_REFERENCE_LENGTH = 4;
    private static final int MIN_OFFSET_OF_LAST_BACK_REFERENCE = 12;
    private final LZ77Compressor compressor;
    private final Deque<byte[]> expandedBlocks;
    private boolean finished;
    private final byte[] oneByte;

    /* renamed from: os  reason: collision with root package name */
    private final OutputStream f27714os;
    private final Deque<Pair> pairs;

    /* renamed from: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27715a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType[] r0 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27715a = r0
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType r1 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.LITERAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27715a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType r1 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.BACK_REFERENCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27715a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType r1 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.EOD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Pair {
        private int brLength;
        private int brOffset;
        private final Deque<byte[]> literals = new LinkedList();
        private boolean written;

        /* access modifiers changed from: private */
        public int backReferenceLength() {
            return this.brLength;
        }

        /* access modifiers changed from: private */
        public boolean hasBeenWritten() {
            return this.written;
        }

        private static int lengths(int i11, int i12) {
            int i13 = 15;
            if (i11 >= 15) {
                i11 = 15;
            }
            if (i12 < 4) {
                i13 = 0;
            } else if (i12 < 19) {
                i13 = i12 - 4;
            }
            return (i11 << 4) | i13;
        }

        private int literalLength() {
            int i11 = 0;
            for (byte[] length : this.literals) {
                i11 += length.length;
            }
            return i11;
        }

        /* access modifiers changed from: private */
        public void prependLiteral(byte[] bArr) {
            this.literals.addFirst(bArr);
        }

        /* access modifiers changed from: private */
        public void prependTo(Pair pair) {
            Iterator<byte[]> descendingIterator = this.literals.descendingIterator();
            while (descendingIterator.hasNext()) {
                pair.prependLiteral(descendingIterator.next());
            }
        }

        /* access modifiers changed from: private */
        public Pair splitWithNewBackReferenceLengthOf(int i11) {
            Pair pair = new Pair();
            pair.literals.addAll(this.literals);
            pair.brOffset = this.brOffset;
            pair.brLength = i11;
            return pair;
        }

        private static void writeLength(int i11, OutputStream outputStream) throws IOException {
            while (i11 >= 255) {
                outputStream.write(255);
                i11 -= 255;
            }
            outputStream.write(i11);
        }

        public byte[] f(LZ77Compressor.LiteralBlock literalBlock) {
            byte[] copyOfRange = Arrays.copyOfRange(literalBlock.getData(), literalBlock.getOffset(), literalBlock.getOffset() + literalBlock.getLength());
            this.literals.add(copyOfRange);
            return copyOfRange;
        }

        public boolean g(int i11) {
            return h() && i11 >= 16;
        }

        public boolean h() {
            return this.brOffset > 0;
        }

        public int i() {
            return literalLength() + this.brLength;
        }

        public void j(LZ77Compressor.BackReference backReference) {
            if (!h()) {
                this.brOffset = backReference.getOffset();
                this.brLength = backReference.getLength();
                return;
            }
            throw new IllegalStateException();
        }

        public void k(OutputStream outputStream) throws IOException {
            int literalLength = literalLength();
            outputStream.write(lengths(literalLength, this.brLength));
            if (literalLength >= 15) {
                writeLength(literalLength - 15, outputStream);
            }
            for (byte[] write : this.literals) {
                outputStream.write(write);
            }
            if (h()) {
                ByteUtils.toLittleEndian(outputStream, (long) this.brOffset, 2);
                int i11 = this.brLength;
                if (i11 - 4 >= 15) {
                    writeLength((i11 - 4) - 15, outputStream);
                }
            }
            this.written = true;
        }
    }

    public BlockLZ4CompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, createParameterBuilder().build());
    }

    private void addBackReference(LZ77Compressor.BackReference backReference) throws IOException {
        writeBlocksAndReturnUnfinishedPair(backReference.getLength()).j(backReference);
        recordBackReference(backReference);
        clearUnusedBlocksAndPairs();
    }

    private void addLiteralBlock(LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        recordLiteral(writeBlocksAndReturnUnfinishedPair(literalBlock.getLength()).f(literalBlock));
        clearUnusedBlocksAndPairs();
    }

    private void clearUnusedBlocks() {
        int i11 = 0;
        int i12 = 0;
        for (byte[] length : this.expandedBlocks) {
            i11++;
            i12 += length.length;
            if (i12 >= 65536) {
                break;
            }
        }
        int size = this.expandedBlocks.size();
        while (i11 < size) {
            this.expandedBlocks.removeLast();
            i11++;
        }
    }

    private void clearUnusedBlocksAndPairs() {
        clearUnusedBlocks();
        clearUnusedPairs();
    }

    private void clearUnusedPairs() {
        Iterator<Pair> descendingIterator = this.pairs.descendingIterator();
        int i11 = 0;
        int i12 = 0;
        while (descendingIterator.hasNext()) {
            i11++;
            i12 += descendingIterator.next().i();
            if (i12 >= 65536) {
                break;
            }
        }
        int size = this.pairs.size();
        while (i11 < size && this.pairs.peekFirst().hasBeenWritten()) {
            this.pairs.removeFirst();
            i11++;
        }
    }

    public static Parameters.Builder createParameterBuilder() {
        return Parameters.builder(65536).withMinBackReferenceLength(4).withMaxBackReferenceLength(65535).withMaxOffset(65535).withMaxLiteralLength(65535);
    }

    private byte[] expand(int i11, int i12) {
        byte[] bArr = new byte[i12];
        if (i11 == 1) {
            byte[] peekFirst = this.expandedBlocks.peekFirst();
            byte b11 = peekFirst[peekFirst.length - 1];
            if (b11 != 0) {
                Arrays.fill(bArr, b11);
            }
        } else {
            expandFromList(bArr, i11, i12);
        }
        return bArr;
    }

    private void expandFromList(byte[] bArr, int i11, int i12) {
        byte[] bArr2;
        int i13;
        int i14;
        int i15 = i11;
        int i16 = 0;
        while (i12 > 0) {
            if (i15 > 0) {
                Iterator<byte[]> it = this.expandedBlocks.iterator();
                int i17 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        bArr2 = null;
                        break;
                    }
                    bArr2 = it.next();
                    if (bArr2.length + i17 >= i15) {
                        break;
                    }
                    i17 += bArr2.length;
                }
                if (bArr2 != null) {
                    i13 = (i17 + bArr2.length) - i15;
                    i14 = Math.min(i12, bArr2.length - i13);
                } else {
                    throw new IllegalStateException("Failed to find a block containing offset " + i11);
                }
            } else {
                i13 = -i15;
                i14 = Math.min(i12, i16 + i15);
                bArr2 = bArr;
            }
            System.arraycopy(bArr2, i13, bArr, i16, i14);
            i15 -= i14;
            i12 -= i14;
            i16 += i14;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(LZ77Compressor.Block block) throws IOException {
        int i11 = AnonymousClass1.f27715a[block.getType().ordinal()];
        if (i11 == 1) {
            addLiteralBlock((LZ77Compressor.LiteralBlock) block);
        } else if (i11 == 2) {
            addBackReference((LZ77Compressor.BackReference) block);
        } else if (i11 == 3) {
            writeFinalLiteralBlock();
        }
    }

    private void recordBackReference(LZ77Compressor.BackReference backReference) {
        this.expandedBlocks.addFirst(expand(backReference.getOffset(), backReference.getLength()));
    }

    private void recordLiteral(byte[] bArr) {
        this.expandedBlocks.addFirst(bArr);
    }

    private void rewriteLastPairs() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Iterator<Pair> descendingIterator = this.pairs.descendingIterator();
        int i11 = 0;
        int i12 = 0;
        while (descendingIterator.hasNext()) {
            Pair next = descendingIterator.next();
            if (!next.hasBeenWritten()) {
                int i13 = next.i();
                linkedList2.addFirst(Integer.valueOf(i13));
                linkedList.addFirst(next);
                i12 += i13;
                if (i12 >= 12) {
                    break;
                }
            } else {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.pairs.remove((Pair) it.next());
        }
        int size = linkedList.size();
        int i14 = 0;
        for (int i15 = 1; i15 < size; i15++) {
            i14 += ((Integer) linkedList2.get(i15)).intValue();
        }
        Pair pair = new Pair();
        if (i14 > 0) {
            pair.prependLiteral(expand(i14, i14));
        }
        Pair pair2 = (Pair) linkedList.get(0);
        int i16 = 12 - i14;
        if (pair2.h()) {
            i11 = pair2.backReferenceLength();
        }
        if (!pair2.h() || i11 < i16 + 4) {
            if (pair2.h()) {
                pair.prependLiteral(expand(i14 + i11, i11));
            }
            pair2.prependTo(pair);
        } else {
            pair.prependLiteral(expand(i14 + i16, i16));
            this.pairs.add(pair2.splitWithNewBackReferenceLengthOf(i11 - i16));
        }
        this.pairs.add(pair);
    }

    private Pair writeBlocksAndReturnUnfinishedPair(int i11) throws IOException {
        writeWritablePairs(i11);
        Pair peekLast = this.pairs.peekLast();
        if (peekLast != null && !peekLast.h()) {
            return peekLast;
        }
        Pair pair = new Pair();
        this.pairs.addLast(pair);
        return pair;
    }

    private void writeFinalLiteralBlock() throws IOException {
        rewriteLastPairs();
        for (Pair next : this.pairs) {
            if (!next.hasBeenWritten()) {
                next.k(this.f27714os);
            }
        }
        this.pairs.clear();
    }

    private void writeWritablePairs(int i11) throws IOException {
        Iterator<Pair> descendingIterator = this.pairs.descendingIterator();
        while (descendingIterator.hasNext()) {
            Pair next = descendingIterator.next();
            if (next.hasBeenWritten()) {
                break;
            }
            i11 += next.i();
        }
        for (Pair next2 : this.pairs) {
            if (!next2.hasBeenWritten()) {
                i11 -= next2.i();
                if (next2.g(i11)) {
                    next2.k(this.f27714os);
                } else {
                    return;
                }
            }
        }
    }

    public void close() throws IOException {
        try {
            finish();
        } finally {
            this.f27714os.close();
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            this.compressor.finish();
            this.finished = true;
        }
    }

    public void prefill(byte[] bArr, int i11, int i12) {
        if (i12 > 0) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i11, i12 + i11);
            this.compressor.prefill(copyOfRange);
            recordLiteral(copyOfRange);
        }
    }

    public void write(int i11) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i11 & 255);
        write(bArr);
    }

    public BlockLZ4CompressorOutputStream(OutputStream outputStream, Parameters parameters) throws IOException {
        this.oneByte = new byte[1];
        this.pairs = new LinkedList();
        this.expandedBlocks = new LinkedList();
        this.f27714os = outputStream;
        this.compressor = new LZ77Compressor(parameters, new a(this));
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.compressor.compress(bArr, i11, i12);
    }
}
