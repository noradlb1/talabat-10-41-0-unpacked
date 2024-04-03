package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class ByteString implements Iterable<Byte> {
    public static final ByteString EMPTY = new LiteralByteString(new byte[0]);

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i11) {
        if (i11 == 1) {
            return it.next();
        }
        int i12 = i11 >>> 1;
        return balancedConcat(it, i12).concat(balancedConcat(it, i11 - i12));
    }

    public static ByteString copyFrom(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        return new LiteralByteString(bArr2);
    }

    public static ByteString copyFromUtf8(String str) {
        try {
            return new LiteralByteString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException("UTF-8 not supported?", e11);
        }
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public abstract void a(byte[] bArr, int i11, int i12, int i13);

    public abstract int b();

    public abstract boolean c();

    public ByteString concat(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return RopeByteString.l(this, byteString);
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("ByteString would be too long: ");
        sb2.append(size);
        sb2.append("+");
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public void copyTo(byte[] bArr, int i11, int i12, int i13) {
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i11);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i12 < 0) {
            StringBuilder sb3 = new StringBuilder(30);
            sb3.append("Target offset < 0: ");
            sb3.append(i12);
            throw new IndexOutOfBoundsException(sb3.toString());
        } else if (i13 >= 0) {
            int i14 = i11 + i13;
            if (i14 <= size()) {
                int i15 = i12 + i13;
                if (i15 > bArr.length) {
                    StringBuilder sb4 = new StringBuilder(34);
                    sb4.append("Target end offset < 0: ");
                    sb4.append(i15);
                    throw new IndexOutOfBoundsException(sb4.toString());
                } else if (i13 > 0) {
                    a(bArr, i11, i12, i13);
                }
            } else {
                StringBuilder sb5 = new StringBuilder(34);
                sb5.append("Source end offset < 0: ");
                sb5.append(i14);
                throw new IndexOutOfBoundsException(sb5.toString());
            }
        } else {
            StringBuilder sb6 = new StringBuilder(23);
            sb6.append("Length < 0: ");
            sb6.append(i13);
            throw new IndexOutOfBoundsException(sb6.toString());
        }
    }

    public abstract int d(int i11, int i12, int i13);

    public abstract int e(int i11, int i12, int i13);

    public abstract int f();

    public void g(OutputStream outputStream, int i11, int i12) throws IOException {
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i11);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i12 >= 0) {
            int i13 = i11 + i12;
            if (i13 > size()) {
                StringBuilder sb3 = new StringBuilder(39);
                sb3.append("Source end offset exceeded: ");
                sb3.append(i13);
                throw new IndexOutOfBoundsException(sb3.toString());
            } else if (i12 > 0) {
                h(outputStream, i11, i12);
            }
        } else {
            StringBuilder sb4 = new StringBuilder(23);
            sb4.append("Length < 0: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public abstract void h(OutputStream outputStream, int i11, int i12) throws IOException;

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    public abstract ByteIterator iterator();

    public abstract CodedInputStream newCodedInput();

    public abstract int size();

    public byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        a(bArr, 0, 0, size);
        return bArr;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract String toString(String str) throws UnsupportedEncodingException;

    public String toStringUtf8() {
        try {
            return toString("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException("UTF-8 not supported?", e11);
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

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        Collection collection;
        if (!(iterable instanceof Collection)) {
            collection = new ArrayList();
            for (ByteString add : iterable) {
                collection.add(add);
            }
        } else {
            collection = (Collection) iterable;
        }
        if (collection.isEmpty()) {
            return EMPTY;
        }
        return balancedConcat(collection.iterator(), collection.size());
    }
}
