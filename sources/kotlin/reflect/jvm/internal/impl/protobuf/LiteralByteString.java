package kotlin.reflect.jvm.internal.impl.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class LiteralByteString extends ByteString {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f24764b;
    private int hash = 0;

    public class LiteralByteIterator implements ByteString.ByteIterator, Iterator {
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
            try {
                byte[] bArr = LiteralByteString.this.f24764b;
                int i11 = this.position;
                this.position = i11 + 1;
                return bArr[i11];
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw new NoSuchElementException(e11.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private LiteralByteIterator() {
            this.position = 0;
            this.limit = LiteralByteString.this.size();
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public LiteralByteString(byte[] bArr) {
        this.f24764b = bArr;
    }

    public static int k(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public void a(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.f24764b, i11, bArr, i12, i13);
    }

    public int b() {
        return 0;
    }

    public byte byteAt(int i11) {
        return this.f24764b[i11];
    }

    public boolean c() {
        return true;
    }

    public int d(int i11, int i12, int i13) {
        return k(i11, this.f24764b, j() + i12, i13);
    }

    public int e(int i11, int i12, int i13) {
        int j11 = j() + i12;
        return Utf8.partialIsValidUtf8(i11, this.f24764b, j11, i13 + j11);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return i((LiteralByteString) obj, 0, size());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
        sb2.append("Has a new type of ByteString been created? Found ");
        sb2.append(valueOf);
        throw new IllegalArgumentException(sb2.toString());
    }

    public int f() {
        return this.hash;
    }

    public void h(OutputStream outputStream, int i11, int i12) throws IOException {
        outputStream.write(this.f24764b, j() + i11, i12);
    }

    public int hashCode() {
        int i11 = this.hash;
        if (i11 == 0) {
            int size = size();
            i11 = d(size, 0, size);
            if (i11 == 0) {
                i11 = 1;
            }
            this.hash = i11;
        }
        return i11;
    }

    public boolean i(LiteralByteString literalByteString, int i11, int i12) {
        if (i12 > literalByteString.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i12);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i11 + i12 <= literalByteString.size()) {
            byte[] bArr = this.f24764b;
            byte[] bArr2 = literalByteString.f24764b;
            int j11 = j() + i12;
            int j12 = j();
            int j13 = literalByteString.j() + i11;
            while (j12 < j11) {
                if (bArr[j12] != bArr2[j13]) {
                    return false;
                }
                j12++;
                j13++;
            }
            return true;
        } else {
            int size2 = literalByteString.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: ");
            sb3.append(i11);
            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb3.append(i12);
            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public boolean isValidUtf8() {
        int j11 = j();
        return Utf8.isValidUtf8(this.f24764b, j11, size() + j11);
    }

    public int j() {
        return 0;
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.a(this);
    }

    public int size() {
        return this.f24764b.length;
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.f24764b, j(), size(), str);
    }

    public ByteString.ByteIterator iterator() {
        return new LiteralByteIterator();
    }
}
