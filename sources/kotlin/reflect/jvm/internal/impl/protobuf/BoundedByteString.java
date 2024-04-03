package kotlin.reflect.jvm.internal.impl.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    public class BoundedByteIterator implements ByteString.ByteIterator, Iterator {
        private final int limit;
        private int position;

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public boolean hasNext() {
            return this.position < this.limit;
        }

        public byte nextByte() {
            int i11 = this.position;
            if (i11 < this.limit) {
                byte[] bArr = BoundedByteString.this.f24764b;
                this.position = i11 + 1;
                return bArr[i11];
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private BoundedByteIterator() {
            int j11 = BoundedByteString.this.j();
            this.position = j11;
            this.limit = j11 + BoundedByteString.this.size();
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public BoundedByteString(byte[] bArr, int i11, int i12) {
        super(bArr);
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Offset too small: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i12 < 0) {
            StringBuilder sb3 = new StringBuilder(29);
            sb3.append("Length too small: ");
            sb3.append(i11);
            throw new IllegalArgumentException(sb3.toString());
        } else if (((long) i11) + ((long) i12) <= ((long) bArr.length)) {
            this.bytesOffset = i11;
            this.bytesLength = i12;
        } else {
            StringBuilder sb4 = new StringBuilder(48);
            sb4.append("Offset+Length too large: ");
            sb4.append(i11);
            sb4.append("+");
            sb4.append(i12);
            throw new IllegalArgumentException(sb4.toString());
        }
    }

    public void a(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.f24764b, j() + i11, bArr, i12, i13);
    }

    public byte byteAt(int i11) {
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder(28);
            sb2.append("Index too small: ");
            sb2.append(i11);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        } else if (i11 < size()) {
            return this.f24764b[this.bytesOffset + i11];
        } else {
            int size = size();
            StringBuilder sb3 = new StringBuilder(41);
            sb3.append("Index too large: ");
            sb3.append(i11);
            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb3.append(size);
            throw new ArrayIndexOutOfBoundsException(sb3.toString());
        }
    }

    public int j() {
        return this.bytesOffset;
    }

    public int size() {
        return this.bytesLength;
    }

    public ByteString.ByteIterator iterator() {
        return new BoundedByteIterator();
    }
}
