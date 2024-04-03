package androidx.datastore.preferences.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() {
        public int compare(ByteString byteString, ByteString byteString2) {
            ByteIterator it = byteString.iterator();
            ByteIterator it2 = byteString2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int compare = Integer.compare(ByteString.toInt(it.nextByte()), ByteString.toInt(it2.nextByte()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(byteString.size(), byteString2.size());
        }
    };
    private static final ByteArrayCopier byteArrayCopier;
    private int hash = 0;

    public static abstract class AbstractByteIterator implements ByteIterator, Iterator {
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public final Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        public byte[] copyFrom(byte[] bArr, int i11, int i12) {
            return Arrays.copyOfRange(bArr, i11, i12 + i11);
        }
    }

    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public BoundedByteString(byte[] bArr, int i11, int i12) {
            super(bArr);
            ByteString.c(i11, i11 + i12, bArr.length);
            this.bytesOffset = i11;
            this.bytesLength = i12;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        public byte byteAt(int i11) {
            ByteString.b(i11, size());
            return this.f35749b[this.bytesOffset + i11];
        }

        public void d(byte[] bArr, int i11, int i12, int i13) {
            System.arraycopy(this.f35749b, r() + i11, bArr, i12, i13);
        }

        public byte internalByteAt(int i11) {
            return this.f35749b[this.bytesOffset + i11];
        }

        public int r() {
            return this.bytesOffset;
        }

        public int size() {
            return this.bytesLength;
        }

        public Object writeReplace() {
            return ByteString.m(toByteArray());
        }
    }

    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i11, int i12);
    }

    public interface ByteIterator extends java.util.Iterator<Byte> {
        byte nextByte();
    }

    public static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        private CodedBuilder(int i11) {
            byte[] bArr = new byte[i11];
            this.buffer = bArr;
            this.output = CodedOutputStream.newInstance(bArr);
        }
    }

    public static abstract class LeafByteString extends ByteString {
        public final int e() {
            return 0;
        }

        public final boolean f() {
            return true;
        }

        public /* bridge */ /* synthetic */ java.util.Iterator iterator() {
            return ByteString.super.iterator();
        }

        public void p(ByteOutput byteOutput) throws IOException {
            o(byteOutput);
        }

        public abstract boolean q(ByteString byteString, int i11, int i12);
    }

    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f35749b;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.f35749b = bArr;
        }

        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.f35749b, r(), size()).asReadOnlyBuffer();
        }

        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        public byte byteAt(int i11) {
            return this.f35749b[i11];
        }

        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.f35749b, r(), size());
        }

        public void d(byte[] bArr, int i11, int i12, int i13) {
            System.arraycopy(this.f35749b, i11, bArr, i12, i13);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int j11 = j();
            int j12 = literalByteString.j();
            if (j11 == 0 || j12 == 0 || j11 == j12) {
                return q(literalByteString, 0, size());
            }
            return false;
        }

        public final int h(int i11, int i12, int i13) {
            return Internal.e(i11, this.f35749b, r() + i12, i13);
        }

        public final int i(int i11, int i12, int i13) {
            int r11 = r() + i12;
            return Utf8.partialIsValidUtf8(i11, this.f35749b, r11, i13 + r11);
        }

        public byte internalByteAt(int i11) {
            return this.f35749b[i11];
        }

        public final boolean isValidUtf8() {
            int r11 = r();
            return Utf8.isValidUtf8(this.f35749b, r11, size() + r11);
        }

        public final String k(Charset charset) {
            return new String(this.f35749b, r(), size(), charset);
        }

        public final CodedInputStream newCodedInput() {
            return CodedInputStream.c(this.f35749b, r(), size(), true);
        }

        public final InputStream newInput() {
            return new ByteArrayInputStream(this.f35749b, r(), size());
        }

        public final void o(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.f35749b, r(), size());
        }

        public final boolean q(ByteString byteString, int i11, int i12) {
            if (i12 <= byteString.size()) {
                int i13 = i11 + i12;
                if (i13 > byteString.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + byteString.size());
                } else if (!(byteString instanceof LiteralByteString)) {
                    return byteString.substring(i11, i13).equals(substring(0, i12));
                } else {
                    LiteralByteString literalByteString = (LiteralByteString) byteString;
                    byte[] bArr = this.f35749b;
                    byte[] bArr2 = literalByteString.f35749b;
                    int r11 = r() + i12;
                    int r12 = r();
                    int r13 = literalByteString.r() + i11;
                    while (r12 < r11) {
                        if (bArr[r12] != bArr2[r13]) {
                            return false;
                        }
                        r12++;
                        r13++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i12 + size());
            }
        }

        public int r() {
            return 0;
        }

        public int size() {
            return this.f35749b.length;
        }

        public final ByteString substring(int i11, int i12) {
            int c11 = ByteString.c(i11, i12, size());
            if (c11 == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.f35749b, r() + i11, c11);
        }

        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }
    }

    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        public byte[] copyFrom(byte[] bArr, int i11, int i12) {
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            return bArr2;
        }
    }

    static {
        ByteArrayCopier byteArrayCopier2;
        if (Android.b()) {
            byteArrayCopier2 = new SystemByteArrayCopier();
        } else {
            byteArrayCopier2 = new ArraysByteArrayCopier();
        }
        byteArrayCopier = byteArrayCopier2;
    }

    public static void b(int i11, int i12) {
        if (((i12 - (i11 + 1)) | i11) >= 0) {
            return;
        }
        if (i11 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i11);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12);
    }

    private static ByteString balancedConcat(java.util.Iterator<ByteString> it, int i11) {
        if (i11 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i11)}));
        } else if (i11 == 1) {
            return it.next();
        } else {
            int i12 = i11 >>> 1;
            return balancedConcat(it, i12).concat(balancedConcat(it, i11 - i12));
        }
    }

    public static int c(int i11, int i12, int i13) {
        int i14 = i12 - i11;
        if ((i11 | i12 | i14 | (i13 - i12)) >= 0) {
            return i14;
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i11 + " < 0");
        } else if (i12 < i11) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i12 + " >= " + i13);
        }
    }

    public static ByteString copyFrom(byte[] bArr, int i11, int i12) {
        c(i11, i11 + i12, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i11, i12));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.f35797a));
    }

    public static CodedBuilder g(int i11) {
        return new CodedBuilder(i11);
    }

    public static ByteString l(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return n(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public static ByteString m(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public static ByteString n(byte[] bArr, int i11, int i12) {
        return new BoundedByteString(bArr, i11, i12);
    }

    public static Output newOutput(int i11) {
        return new Output(i11);
    }

    private static ByteString readChunk(InputStream inputStream, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            int read = inputStream.read(bArr, i12, i11 - i12);
            if (read == -1) {
                break;
            }
            i12 += read;
        }
        if (i12 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i12);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    /* access modifiers changed from: private */
    public static int toInt(byte b11) {
        return b11 & 255;
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i11);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.s(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i11) {
        copyTo(bArr, 0, i11, size());
    }

    public abstract void d(byte[] bArr, int i11, int i12, int i13);

    public abstract int e();

    public final boolean endsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString);
    }

    public abstract boolean equals(Object obj);

    public abstract boolean f();

    public abstract int h(int i11, int i12, int i13);

    public final int hashCode() {
        int i11 = this.hash;
        if (i11 == 0) {
            int size = size();
            i11 = h(size, 0, size);
            if (i11 == 0) {
                i11 = 1;
            }
            this.hash = i11;
        }
        return i11;
    }

    public abstract int i(int i11, int i12, int i13);

    public abstract byte internalByteAt(int i11);

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    public final int j() {
        return this.hash;
    }

    public abstract String k(Charset charset);

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract void o(ByteOutput byteOutput) throws IOException;

    public abstract void p(ByteOutput byteOutput) throws IOException;

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(0, byteString.size()).equals(byteString);
    }

    public final ByteString substring(int i11) {
        return substring(i11, size());
    }

    public abstract ByteString substring(int i11, int i12);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        d(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e11) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e11);
            throw unsupportedEncodingException;
        }
    }

    public final String toStringUtf8() {
        return toString(Internal.f35797a);
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i11) throws IOException {
        return readFrom(inputStream, i11, i11);
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i11, int i12, int i13) {
        c(i11, i11 + i13, size());
        c(i12, i12 + i13, bArr.length);
        if (i13 > 0) {
            d(bArr, i11, i12, i13);
        }
    }

    public ByteIterator iterator() {
        return new AbstractByteIterator() {
            private final int limit;
            private int position = 0;

            {
                this.limit = ByteString.this.size();
            }

            public boolean hasNext() {
                return this.position < this.limit;
            }

            public byte nextByte() {
                int i11 = this.position;
                if (i11 < this.limit) {
                    this.position = i11 + 1;
                    return ByteString.this.internalByteAt(i11);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i11, int i12) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString readChunk = readChunk(inputStream, i11);
            if (readChunk == null) {
                return copyFrom((Iterable<ByteString>) arrayList);
            }
            arrayList.add(readChunk);
            i11 = Math.min(i11 * 2, i12);
        }
    }

    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        public Output(int i11) {
            if (i11 >= 0) {
                this.initialCapacity = i11;
                this.flushedBuffers = new ArrayList<>();
                this.buffer = new byte[i11];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] copyArray(byte[] bArr, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i11));
            return bArr2;
        }

        private void flushFullBuffer(int i11) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i11, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i11 = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i11 >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i11 > 0) {
                this.flushedBuffers.add(new LiteralByteString(copyArray(bArr, i11)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        public synchronized void reset() {
            this.flushedBuffers.clear();
            this.flushedBuffersTotalBytes = 0;
            this.bufferPos = 0;
        }

        public synchronized int size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom((Iterable<ByteString>) this.flushedBuffers);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        public synchronized void write(int i11) {
            if (this.bufferPos == this.buffer.length) {
                flushFullBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i12 = this.bufferPos;
            this.bufferPos = i12 + 1;
            bArr[i12] = (byte) i11;
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            ByteString[] byteStringArr;
            byte[] bArr;
            int i11;
            synchronized (this) {
                ArrayList<ByteString> arrayList = this.flushedBuffers;
                byteStringArr = (ByteString[]) arrayList.toArray(new ByteString[arrayList.size()]);
                bArr = this.buffer;
                i11 = this.bufferPos;
            }
            for (ByteString writeTo : byteStringArr) {
                writeTo.writeTo(outputStream);
            }
            outputStream.write(copyArray(bArr, i11));
        }

        public synchronized void write(byte[] bArr, int i11, int i12) {
            byte[] bArr2 = this.buffer;
            int length = bArr2.length;
            int i13 = this.bufferPos;
            if (i12 <= length - i13) {
                System.arraycopy(bArr, i11, bArr2, i13, i12);
                this.bufferPos += i12;
            } else {
                int length2 = bArr2.length - i13;
                System.arraycopy(bArr, i11, bArr2, i13, length2);
                int i14 = i12 - length2;
                flushFullBuffer(i14);
                System.arraycopy(bArr, i11 + length2, this.buffer, 0, i14);
                this.bufferPos = i14;
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i11) {
        c(0, i11, byteBuffer.remaining());
        byte[] bArr = new byte[i11];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : k(charset);
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int i11;
        if (!(iterable instanceof Collection)) {
            java.util.Iterator<ByteString> it = iterable.iterator();
            i11 = 0;
            while (it.hasNext()) {
                it.next();
                i11++;
            }
        } else {
            i11 = ((Collection) iterable).size();
        }
        if (i11 == 0) {
            return EMPTY;
        }
        return balancedConcat(iterable.iterator(), i11);
    }
}
