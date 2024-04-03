package kotlin.reflect.jvm.internal.impl.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

class RopeByteString extends ByteString {
    /* access modifiers changed from: private */
    public static final int[] minLengthByDepth;
    private int hash;
    /* access modifiers changed from: private */
    public final ByteString left;
    private final int leftLength;
    /* access modifiers changed from: private */
    public final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    public static class Balancer {
        private final Stack<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new Stack<>();
        }

        /* access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            doBalance(byteString);
            doBalance(byteString2);
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty()) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop);
            }
            return pop;
        }

        private void doBalance(ByteString byteString) {
            if (byteString.c()) {
                insert(byteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                doBalance(ropeByteString.left);
                doBalance(ropeByteString.right);
            } else {
                String valueOf = String.valueOf(byteString.getClass());
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
                sb2.append("Has a new type of ByteString been created? Found ");
                sb2.append(valueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        private int getDepthBinForLength(int i11) {
            int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i11);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void insert(ByteString byteString) {
            int depthBinForLength = getDepthBinForLength(byteString.size());
            int i11 = RopeByteString.minLengthByDepth[depthBinForLength + 1];
            if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= i11) {
                this.prefixesStack.push(byteString);
                return;
            }
            int i12 = RopeByteString.minLengthByDepth[depthBinForLength];
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < i12) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop);
            }
            RopeByteString ropeByteString = new RopeByteString(pop, byteString);
            while (!this.prefixesStack.isEmpty()) {
                if (this.prefixesStack.peek().size() >= RopeByteString.minLengthByDepth[getDepthBinForLength(ropeByteString.size()) + 1]) {
                    break;
                }
                ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString);
            }
            this.prefixesStack.push(ropeByteString);
        }
    }

    public static class PieceIterator implements Iterator<LiteralByteString>, j$.util.Iterator {
        private final Stack<RopeByteString> breadCrumbs;
        private LiteralByteString next;

        private LiteralByteString getLeafByLeft(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.breadCrumbs.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (LiteralByteString) byteString;
        }

        private LiteralByteString getNextNonEmptyLeaf() {
            while (!this.breadCrumbs.isEmpty()) {
                LiteralByteString leafByLeft = getLeafByLeft(this.breadCrumbs.pop().right);
                if (!leafByLeft.isEmpty()) {
                    return leafByLeft;
                }
            }
            return null;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private PieceIterator(ByteString byteString) {
            this.breadCrumbs = new Stack<>();
            this.next = getLeafByLeft(byteString);
        }

        public LiteralByteString next() {
            LiteralByteString literalByteString = this.next;
            if (literalByteString != null) {
                this.next = getNextNonEmptyLeaf();
                return literalByteString;
            }
            throw new NoSuchElementException();
        }
    }

    public class RopeByteIterator implements ByteString.ByteIterator, j$.util.Iterator {

        /* renamed from: b  reason: collision with root package name */
        public int f24766b;
        private ByteString.ByteIterator bytes;
        private final PieceIterator pieces;

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.f24766b > 0;
        }

        public byte nextByte() {
            if (!this.bytes.hasNext()) {
                this.bytes = this.pieces.next().iterator();
            }
            this.f24766b--;
            return this.bytes.nextByte();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private RopeByteIterator() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.pieces = pieceIterator;
            this.bytes = pieceIterator.next().iterator();
            this.f24766b = RopeByteString.this.size();
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i11 = 1;
        int i12 = 1;
        while (i11 > 0) {
            arrayList.add(Integer.valueOf(i11));
            int i13 = i12 + i11;
            i12 = i11;
            i11 = i13;
        }
        arrayList.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[arrayList.size()];
        int i14 = 0;
        while (true) {
            int[] iArr = minLengthByDepth;
            if (i14 < iArr.length) {
                iArr[i14] = ((Integer) arrayList.get(i14)).intValue();
                i14++;
            } else {
                return;
            }
        }
    }

    private static LiteralByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return new LiteralByteString(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        boolean z11;
        PieceIterator pieceIterator = new PieceIterator(this);
        LiteralByteString literalByteString = (LiteralByteString) pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        LiteralByteString literalByteString2 = (LiteralByteString) pieceIterator2.next();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int size = literalByteString.size() - i11;
            int size2 = literalByteString2.size() - i12;
            int min = Math.min(size, size2);
            if (i11 == 0) {
                z11 = literalByteString.i(literalByteString2, i12, min);
            } else {
                z11 = literalByteString2.i(literalByteString, i11, min);
            }
            if (!z11) {
                return false;
            }
            i13 += min;
            int i14 = this.totalLength;
            if (i13 < i14) {
                if (min == size) {
                    literalByteString = (LiteralByteString) pieceIterator.next();
                    i11 = 0;
                } else {
                    i11 += min;
                }
                if (min == size2) {
                    literalByteString2 = (LiteralByteString) pieceIterator2.next();
                    i12 = 0;
                } else {
                    i12 += min;
                }
            } else if (i13 == i14) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public static ByteString l(ByteString byteString, ByteString byteString2) {
        RopeByteString ropeByteString;
        if (byteString instanceof RopeByteString) {
            ropeByteString = (RopeByteString) byteString;
        } else {
            ropeByteString = null;
        }
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() != 0) {
            int size = byteString.size() + byteString2.size();
            if (size < 128) {
                return concatenateBytes(byteString, byteString2);
            }
            if (ropeByteString != null && ropeByteString.right.size() + byteString2.size() < 128) {
                byteString2 = new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
            } else if (ropeByteString == null || ropeByteString.left.b() <= ropeByteString.right.b() || ropeByteString.b() <= byteString2.b()) {
                if (size >= minLengthByDepth[Math.max(byteString.b(), byteString2.b()) + 1]) {
                    return new RopeByteString(byteString, byteString2);
                }
                return new Balancer().balance(byteString, byteString2);
            } else {
                byteString2 = new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        return byteString2;
    }

    public void a(byte[] bArr, int i11, int i12, int i13) {
        int i14 = i11 + i13;
        int i15 = this.leftLength;
        if (i14 <= i15) {
            this.left.a(bArr, i11, i12, i13);
        } else if (i11 >= i15) {
            this.right.a(bArr, i11 - i15, i12, i13);
        } else {
            int i16 = i15 - i11;
            this.left.a(bArr, i11, i12, i16);
            this.right.a(bArr, 0, i12 + i16, i13 - i16);
        }
    }

    public int b() {
        return this.treeDepth;
    }

    public boolean c() {
        return this.totalLength >= minLengthByDepth[this.treeDepth];
    }

    public int d(int i11, int i12, int i13) {
        int i14 = i12 + i13;
        int i15 = this.leftLength;
        if (i14 <= i15) {
            return this.left.d(i11, i12, i13);
        }
        if (i12 >= i15) {
            return this.right.d(i11, i12 - i15, i13);
        }
        int i16 = i15 - i12;
        return this.right.d(this.left.d(i11, i12, i16), 0, i13 - i16);
    }

    public int e(int i11, int i12, int i13) {
        int i14 = i12 + i13;
        int i15 = this.leftLength;
        if (i14 <= i15) {
            return this.left.e(i11, i12, i13);
        }
        if (i12 >= i15) {
            return this.right.e(i11, i12 - i15, i13);
        }
        int i16 = i15 - i12;
        return this.right.e(this.left.e(i11, i12, i16), 0, i13 - i16);
    }

    public boolean equals(Object obj) {
        int f11;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        if (this.hash == 0 || (f11 = byteString.f()) == 0 || this.hash == f11) {
            return equalsFragments(byteString);
        }
        return false;
    }

    public int f() {
        return this.hash;
    }

    public void h(OutputStream outputStream, int i11, int i12) throws IOException {
        int i13 = i11 + i12;
        int i14 = this.leftLength;
        if (i13 <= i14) {
            this.left.h(outputStream, i11, i12);
        } else if (i11 >= i14) {
            this.right.h(outputStream, i11 - i14, i12);
        } else {
            int i15 = i14 - i11;
            this.left.h(outputStream, i11, i15);
            this.right.h(outputStream, 0, i12 - i15);
        }
    }

    public int hashCode() {
        int i11 = this.hash;
        if (i11 == 0) {
            int i12 = this.totalLength;
            i11 = d(i12, 0, i12);
            if (i11 == 0) {
                i11 = 1;
            }
            this.hash = i11;
        }
        return i11;
    }

    public boolean isValidUtf8() {
        int e11 = this.left.e(0, 0, this.leftLength);
        ByteString byteString = this.right;
        if (byteString.e(e11, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new RopeInputStream());
    }

    public int size() {
        return this.totalLength;
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.hash = 0;
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.b(), byteString2.b()) + 1;
    }

    public ByteString.ByteIterator iterator() {
        return new RopeByteIterator();
    }

    public class RopeInputStream extends InputStream {
        private LiteralByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;

        public RopeInputStream() {
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            int i11;
            if (this.currentPiece != null && this.currentPieceIndex == (i11 = this.currentPieceSize)) {
                this.currentPieceOffsetInRope += i11;
                this.currentPieceIndex = 0;
                if (this.pieceIterator.hasNext()) {
                    LiteralByteString next = this.pieceIterator.next();
                    this.currentPiece = next;
                    this.currentPieceSize = next.size();
                    return;
                }
                this.currentPiece = null;
                this.currentPieceSize = 0;
            }
        }

        private void initialize() {
            PieceIterator pieceIterator2 = new PieceIterator(RopeByteString.this);
            this.pieceIterator = pieceIterator2;
            LiteralByteString next = pieceIterator2.next();
            this.currentPiece = next;
            this.currentPieceSize = next.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] bArr, int i11, int i12) {
            int i13 = i12;
            while (true) {
                if (i13 <= 0) {
                    break;
                }
                advanceIfCurrentPieceFullyRead();
                if (this.currentPiece != null) {
                    int min = Math.min(this.currentPieceSize - this.currentPieceIndex, i13);
                    if (bArr != null) {
                        this.currentPiece.copyTo(bArr, this.currentPieceIndex, i11, min);
                        i11 += min;
                    }
                    this.currentPieceIndex += min;
                    i13 -= min;
                } else if (i13 == i12) {
                    return -1;
                }
            }
            return i12 - i13;
        }

        public int available() throws IOException {
            return RopeByteString.this.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
        }

        public void mark(int i11) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        public boolean markSupported() {
            return true;
        }

        public int read(byte[] bArr, int i11, int i12) {
            bArr.getClass();
            if (i11 >= 0 && i12 >= 0 && i12 <= bArr.length - i11) {
                return readSkipInternal(bArr, i11, i12);
            }
            throw new IndexOutOfBoundsException();
        }

        public synchronized void reset() {
            initialize();
            readSkipInternal((byte[]) null, 0, this.mark);
        }

        public long skip(long j11) {
            if (j11 >= 0) {
                if (j11 > 2147483647L) {
                    j11 = 2147483647L;
                }
                return (long) readSkipInternal((byte[]) null, 0, (int) j11);
            }
            throw new IndexOutOfBoundsException();
        }

        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            LiteralByteString literalByteString = this.currentPiece;
            if (literalByteString == null) {
                return -1;
            }
            int i11 = this.currentPieceIndex;
            this.currentPieceIndex = i11 + 1;
            return literalByteString.byteAt(i11) & 255;
        }
    }
}
