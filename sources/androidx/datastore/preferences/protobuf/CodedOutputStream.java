package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    /* access modifiers changed from: private */
    public static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.w();
    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public CodedOutputStreamWriter f35757a;
    private boolean serializationDeterministic;

    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f35758b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35759c;

        /* renamed from: d  reason: collision with root package name */
        public int f35760d;

        /* renamed from: e  reason: collision with root package name */
        public int f35761e;

        public AbstractBufferedEncoder(int i11) {
            super();
            if (i11 >= 0) {
                byte[] bArr = new byte[Math.max(i11, 20)];
                this.f35758b = bArr;
                this.f35759c = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final int getTotalBytesWritten() {
            return this.f35761e;
        }

        public final void o(byte b11) {
            byte[] bArr = this.f35758b;
            int i11 = this.f35760d;
            this.f35760d = i11 + 1;
            bArr[i11] = b11;
            this.f35761e++;
        }

        public final void p(int i11) {
            byte[] bArr = this.f35758b;
            int i12 = this.f35760d;
            int i13 = i12 + 1;
            bArr[i12] = (byte) (i11 & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i11 >> 8) & 255);
            int i15 = i14 + 1;
            bArr[i14] = (byte) ((i11 >> 16) & 255);
            this.f35760d = i15 + 1;
            bArr[i15] = (byte) ((i11 >> 24) & 255);
            this.f35761e += 4;
        }

        public final void q(long j11) {
            byte[] bArr = this.f35758b;
            int i11 = this.f35760d;
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((int) (j11 & 255));
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((int) ((j11 >> 8) & 255));
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((int) ((j11 >> 16) & 255));
            int i15 = i14 + 1;
            bArr[i14] = (byte) ((int) (255 & (j11 >> 24)));
            int i16 = i15 + 1;
            bArr[i15] = (byte) (((int) (j11 >> 32)) & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) (((int) (j11 >> 40)) & 255);
            int i18 = i17 + 1;
            bArr[i17] = (byte) (((int) (j11 >> 48)) & 255);
            this.f35760d = i18 + 1;
            bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
            this.f35761e += 8;
        }

        public final void r(int i11) {
            if (i11 >= 0) {
                t(i11);
            } else {
                u((long) i11);
            }
        }

        public final void s(int i11, int i12) {
            t(WireFormat.a(i11, i12));
        }

        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        public final void t(int i11) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j11 = (long) this.f35760d;
                while ((i11 & -128) != 0) {
                    byte[] bArr = this.f35758b;
                    int i12 = this.f35760d;
                    this.f35760d = i12 + 1;
                    UnsafeUtil.B(bArr, (long) i12, (byte) ((i11 & 127) | 128));
                    i11 >>>= 7;
                }
                byte[] bArr2 = this.f35758b;
                int i13 = this.f35760d;
                this.f35760d = i13 + 1;
                UnsafeUtil.B(bArr2, (long) i13, (byte) i11);
                this.f35761e += (int) (((long) this.f35760d) - j11);
                return;
            }
            while ((i11 & -128) != 0) {
                byte[] bArr3 = this.f35758b;
                int i14 = this.f35760d;
                this.f35760d = i14 + 1;
                bArr3[i14] = (byte) ((i11 & 127) | 128);
                this.f35761e++;
                i11 >>>= 7;
            }
            byte[] bArr4 = this.f35758b;
            int i15 = this.f35760d;
            this.f35760d = i15 + 1;
            bArr4[i15] = (byte) i11;
            this.f35761e++;
        }

        public final void u(long j11) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j12 = (long) this.f35760d;
                while ((j11 & -128) != 0) {
                    byte[] bArr = this.f35758b;
                    int i11 = this.f35760d;
                    this.f35760d = i11 + 1;
                    UnsafeUtil.B(bArr, (long) i11, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                byte[] bArr2 = this.f35758b;
                int i12 = this.f35760d;
                this.f35760d = i12 + 1;
                UnsafeUtil.B(bArr2, (long) i12, (byte) ((int) j11));
                this.f35761e += (int) (((long) this.f35760d) - j12);
                return;
            }
            while ((j11 & -128) != 0) {
                byte[] bArr3 = this.f35758b;
                int i13 = this.f35760d;
                this.f35760d = i13 + 1;
                bArr3[i13] = (byte) ((((int) j11) & 127) | 128);
                this.f35761e++;
                j11 >>>= 7;
            }
            byte[] bArr4 = this.f35758b;
            int i14 = this.f35760d;
            this.f35760d = i14 + 1;
            bArr4[i14] = (byte) ((int) j11);
            this.f35761e++;
        }
    }

    public static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public ArrayEncoder(byte[] bArr, int i11, int i12) {
            super();
            if (bArr != null) {
                int i13 = i11 + i12;
                if ((i11 | i12 | (bArr.length - i13)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i11;
                    this.position = i11;
                    this.limit = i13;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        public final void n(int i11, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i11, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.writeTo(messageLite, this.f35757a);
        }

        public final int spaceLeft() {
            return this.limit - this.position;
        }

        public final void write(byte b11) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                bArr[i11] = b11;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void writeBool(int i11, boolean z11) throws IOException {
            writeTag(i11, 0);
            write(z11 ? (byte) 1 : 0);
        }

        public final void writeByteArray(int i11, byte[] bArr) throws IOException {
            writeByteArray(i11, bArr, 0, bArr.length);
        }

        public final void writeByteArrayNoTag(byte[] bArr, int i11, int i12) throws IOException {
            writeUInt32NoTag(i12);
            write(bArr, i11, i12);
        }

        public final void writeByteBuffer(int i11, ByteBuffer byteBuffer) throws IOException {
            writeTag(i11, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public final void writeBytes(int i11, ByteString byteString) throws IOException {
            writeTag(i11, 2);
            writeBytesNoTag(byteString);
        }

        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.o(this);
        }

        public final void writeFixed32(int i11, int i12) throws IOException {
            writeTag(i11, 5);
            writeFixed32NoTag(i12);
        }

        public final void writeFixed32NoTag(int i11) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i12 = this.position;
                int i13 = i12 + 1;
                bArr[i12] = (byte) (i11 & 255);
                int i14 = i13 + 1;
                bArr[i13] = (byte) ((i11 >> 8) & 255);
                int i15 = i14 + 1;
                bArr[i14] = (byte) ((i11 >> 16) & 255);
                this.position = i15 + 1;
                bArr[i15] = (byte) ((i11 >> 24) & 255);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void writeFixed64(int i11, long j11) throws IOException {
            writeTag(i11, 1);
            writeFixed64NoTag(j11);
        }

        public final void writeFixed64NoTag(long j11) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i11 = this.position;
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((int) j11) & 255);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (((int) (j11 >> 8)) & 255);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (((int) (j11 >> 16)) & 255);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (((int) (j11 >> 24)) & 255);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (((int) (j11 >> 32)) & 255);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((int) (j11 >> 40)) & 255);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((int) (j11 >> 48)) & 255);
                this.position = i18 + 1;
                bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
            }
        }

        public final void writeInt32(int i11, int i12) throws IOException {
            writeTag(i11, 0);
            writeInt32NoTag(i12);
        }

        public final void writeInt32NoTag(int i11) throws IOException {
            if (i11 >= 0) {
                writeUInt32NoTag(i11);
            } else {
                writeUInt64NoTag((long) i11);
            }
        }

        public final void writeLazy(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }

        public final void writeMessage(int i11, MessageLite messageLite) throws IOException {
            writeTag(i11, 2);
            writeMessageNoTag(messageLite);
        }

        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public final void writeMessageSetExtension(int i11, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public final void writeRawMessageSetExtension(int i11, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public final void writeString(int i11, String str) throws IOException {
            writeTag(i11, 2);
            writeStringNoTag(str);
        }

        public final void writeStringNoTag(String str) throws IOException {
            int i11 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i12 = i11 + computeUInt32SizeNoTag2;
                    this.position = i12;
                    int i13 = Utf8.i(str, this.buffer, i12, spaceLeft());
                    this.position = i11;
                    writeUInt32NoTag((i13 - i11) - computeUInt32SizeNoTag2);
                    this.position = i13;
                    return;
                }
                writeUInt32NoTag(Utf8.k(str));
                this.position = Utf8.i(str, this.buffer, this.position, spaceLeft());
            } catch (Utf8.UnpairedSurrogateException e11) {
                this.position = i11;
                h(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new OutOfSpaceException((Throwable) e12);
            }
        }

        public final void writeTag(int i11, int i12) throws IOException {
            writeUInt32NoTag(WireFormat.a(i11, i12));
        }

        public final void writeUInt32(int i11, int i12) throws IOException {
            writeTag(i11, 0);
            writeUInt32NoTag(i12);
        }

        public final void writeUInt32NoTag(int i11) throws IOException {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || Android.b() || spaceLeft() < 5) {
                while ((i11 & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i12 = this.position;
                    this.position = i12 + 1;
                    bArr[i12] = (byte) ((i11 & 127) | 128);
                    i11 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    bArr2[i13] = (byte) i11;
                } catch (IndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
                }
            } else if ((i11 & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                UnsafeUtil.B(bArr3, (long) i14, (byte) i11);
            } else {
                byte[] bArr4 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                UnsafeUtil.B(bArr4, (long) i15, (byte) (i11 | 128));
                int i16 = i11 >>> 7;
                if ((i16 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i17 = this.position;
                    this.position = i17 + 1;
                    UnsafeUtil.B(bArr5, (long) i17, (byte) i16);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i18 = this.position;
                this.position = i18 + 1;
                UnsafeUtil.B(bArr6, (long) i18, (byte) (i16 | 128));
                int i19 = i16 >>> 7;
                if ((i19 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i21 = this.position;
                    this.position = i21 + 1;
                    UnsafeUtil.B(bArr7, (long) i21, (byte) i19);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i22 = this.position;
                this.position = i22 + 1;
                UnsafeUtil.B(bArr8, (long) i22, (byte) (i19 | 128));
                int i23 = i19 >>> 7;
                if ((i23 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i24 = this.position;
                    this.position = i24 + 1;
                    UnsafeUtil.B(bArr9, (long) i24, (byte) i23);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i25 = this.position;
                this.position = i25 + 1;
                UnsafeUtil.B(bArr10, (long) i25, (byte) (i23 | 128));
                byte[] bArr11 = this.buffer;
                int i26 = this.position;
                this.position = i26 + 1;
                UnsafeUtil.B(bArr11, (long) i26, (byte) (i23 >>> 7));
            }
        }

        public final void writeUInt64(int i11, long j11) throws IOException {
            writeTag(i11, 0);
            writeUInt64NoTag(j11);
        }

        public final void writeUInt64NoTag(long j11) throws IOException {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || spaceLeft() < 10) {
                while ((j11 & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i11 = this.position;
                    this.position = i11 + 1;
                    bArr[i11] = (byte) ((((int) j11) & 127) | 128);
                    j11 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i12 = this.position;
                    this.position = i12 + 1;
                    bArr2[i12] = (byte) ((int) j11);
                } catch (IndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e11);
                }
            } else {
                while ((j11 & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    UnsafeUtil.B(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                UnsafeUtil.B(bArr4, (long) i14, (byte) ((int) j11));
            }
        }

        public final void writeByteArray(int i11, byte[] bArr, int i12, int i13) throws IOException {
            writeTag(i11, 2);
            writeByteArrayNoTag(bArr, i12, i13);
        }

        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public final void write(byte[] bArr, int i11, int i12) throws IOException {
            try {
                System.arraycopy(bArr, i11, this.buffer, this.position, i12);
                this.position += i12;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i12)}), e11);
            }
        }

        public final void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, remaining);
                this.position += remaining;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(remaining)}), e11);
            }
        }
    }

    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        private void doFlush() throws IOException {
            this.out.write(this.f35758b, 0, this.f35760d);
            this.f35760d = 0;
        }

        private void flushIfNotAvailable(int i11) throws IOException {
            if (this.f35759c - this.f35760d < i11) {
                doFlush();
            }
        }

        public void flush() throws IOException {
            if (this.f35760d > 0) {
                doFlush();
            }
        }

        public void n(int i11, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i11, 2);
            v(messageLite, schema);
        }

        public void v(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.writeTo(messageLite, this.f35757a);
        }

        public void write(byte b11) throws IOException {
            if (this.f35760d == this.f35759c) {
                doFlush();
            }
            o(b11);
        }

        public void writeBool(int i11, boolean z11) throws IOException {
            flushIfNotAvailable(11);
            s(i11, 0);
            o(z11 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i11, byte[] bArr) throws IOException {
            writeByteArray(i11, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i11, int i12) throws IOException {
            writeUInt32NoTag(i12);
            write(bArr, i11, i12);
        }

        public void writeByteBuffer(int i11, ByteBuffer byteBuffer) throws IOException {
            writeTag(i11, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i11, ByteString byteString) throws IOException {
            writeTag(i11, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.o(this);
        }

        public void writeFixed32(int i11, int i12) throws IOException {
            flushIfNotAvailable(14);
            s(i11, 5);
            p(i12);
        }

        public void writeFixed32NoTag(int i11) throws IOException {
            flushIfNotAvailable(4);
            p(i11);
        }

        public void writeFixed64(int i11, long j11) throws IOException {
            flushIfNotAvailable(18);
            s(i11, 1);
            q(j11);
        }

        public void writeFixed64NoTag(long j11) throws IOException {
            flushIfNotAvailable(8);
            q(j11);
        }

        public void writeInt32(int i11, int i12) throws IOException {
            flushIfNotAvailable(20);
            s(i11, 0);
            r(i12);
        }

        public void writeInt32NoTag(int i11) throws IOException {
            if (i11 >= 0) {
                writeUInt32NoTag(i11);
            } else {
                writeUInt64NoTag((long) i11);
            }
        }

        public void writeLazy(byte[] bArr, int i11, int i12) throws IOException {
            flush();
            this.out.writeLazy(bArr, i11, i12);
            this.f35761e += i12;
        }

        public void writeMessage(int i11, MessageLite messageLite) throws IOException {
            writeTag(i11, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i11, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i11, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i11, String str) throws IOException {
            writeTag(i11, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int length = str.length() * 3;
            int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i11 = computeUInt32SizeNoTag + length;
            int i12 = this.f35759c;
            if (i11 > i12) {
                byte[] bArr = new byte[length];
                int i13 = Utf8.i(str, bArr, 0, length);
                writeUInt32NoTag(i13);
                writeLazy(bArr, 0, i13);
                return;
            }
            if (i11 > i12 - this.f35760d) {
                doFlush();
            }
            int i14 = this.f35760d;
            try {
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i15 = i14 + computeUInt32SizeNoTag2;
                    this.f35760d = i15;
                    int i16 = Utf8.i(str, this.f35758b, i15, this.f35759c - i15);
                    this.f35760d = i14;
                    int i17 = (i16 - i14) - computeUInt32SizeNoTag2;
                    t(i17);
                    this.f35760d = i16;
                    this.f35761e += i17;
                    return;
                }
                int k11 = Utf8.k(str);
                t(k11);
                this.f35760d = Utf8.i(str, this.f35758b, this.f35760d, k11);
                this.f35761e += k11;
            } catch (Utf8.UnpairedSurrogateException e11) {
                this.f35761e -= this.f35760d - i14;
                this.f35760d = i14;
                h(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new OutOfSpaceException((Throwable) e12);
            }
        }

        public void writeTag(int i11, int i12) throws IOException {
            writeUInt32NoTag(WireFormat.a(i11, i12));
        }

        public void writeUInt32(int i11, int i12) throws IOException {
            flushIfNotAvailable(20);
            s(i11, 0);
            t(i12);
        }

        public void writeUInt32NoTag(int i11) throws IOException {
            flushIfNotAvailable(5);
            t(i11);
        }

        public void writeUInt64(int i11, long j11) throws IOException {
            flushIfNotAvailable(20);
            s(i11, 0);
            u(j11);
        }

        public void writeUInt64NoTag(long j11) throws IOException {
            flushIfNotAvailable(10);
            u(j11);
        }

        public void writeByteArray(int i11, byte[] bArr, int i12, int i13) throws IOException {
            writeTag(i11, 2);
            writeByteArrayNoTag(bArr, i12, i13);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            flush();
            this.out.write(bArr, i11, i12);
            this.f35761e += i12;
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.f35761e += remaining;
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.f35761e += remaining;
        }
    }

    public static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        public HeapNioEncoder(ByteBuffer byteBuffer2) {
            super(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), byteBuffer2.remaining());
            this.byteBuffer = byteBuffer2;
            this.initialPosition = byteBuffer2.position();
        }

        public void flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        public OutOfSpaceException(Throwable th2) {
            super(MESSAGE, th2);
        }

        public OutOfSpaceException(String str, Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th2);
        }
    }

    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        public OutputStreamEncoder(OutputStream outputStream, int i11) {
            super(i11);
            if (outputStream != null) {
                this.out = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void doFlush() throws IOException {
            this.out.write(this.f35758b, 0, this.f35760d);
            this.f35760d = 0;
        }

        private void flushIfNotAvailable(int i11) throws IOException {
            if (this.f35759c - this.f35760d < i11) {
                doFlush();
            }
        }

        public void flush() throws IOException {
            if (this.f35760d > 0) {
                doFlush();
            }
        }

        public void n(int i11, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i11, 2);
            v(messageLite, schema);
        }

        public void v(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.writeTo(messageLite, this.f35757a);
        }

        public void write(byte b11) throws IOException {
            if (this.f35760d == this.f35759c) {
                doFlush();
            }
            o(b11);
        }

        public void writeBool(int i11, boolean z11) throws IOException {
            flushIfNotAvailable(11);
            s(i11, 0);
            o(z11 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i11, byte[] bArr) throws IOException {
            writeByteArray(i11, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i11, int i12) throws IOException {
            writeUInt32NoTag(i12);
            write(bArr, i11, i12);
        }

        public void writeByteBuffer(int i11, ByteBuffer byteBuffer) throws IOException {
            writeTag(i11, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i11, ByteString byteString) throws IOException {
            writeTag(i11, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.o(this);
        }

        public void writeFixed32(int i11, int i12) throws IOException {
            flushIfNotAvailable(14);
            s(i11, 5);
            p(i12);
        }

        public void writeFixed32NoTag(int i11) throws IOException {
            flushIfNotAvailable(4);
            p(i11);
        }

        public void writeFixed64(int i11, long j11) throws IOException {
            flushIfNotAvailable(18);
            s(i11, 1);
            q(j11);
        }

        public void writeFixed64NoTag(long j11) throws IOException {
            flushIfNotAvailable(8);
            q(j11);
        }

        public void writeInt32(int i11, int i12) throws IOException {
            flushIfNotAvailable(20);
            s(i11, 0);
            r(i12);
        }

        public void writeInt32NoTag(int i11) throws IOException {
            if (i11 >= 0) {
                writeUInt32NoTag(i11);
            } else {
                writeUInt64NoTag((long) i11);
            }
        }

        public void writeLazy(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }

        public void writeMessage(int i11, MessageLite messageLite) throws IOException {
            writeTag(i11, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i11, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i11, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i11, String str) throws IOException {
            writeTag(i11, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int i11;
            int i12;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i13 = computeUInt32SizeNoTag + length;
                int i14 = this.f35759c;
                if (i13 > i14) {
                    byte[] bArr = new byte[length];
                    int i15 = Utf8.i(str, bArr, 0, length);
                    writeUInt32NoTag(i15);
                    writeLazy(bArr, 0, i15);
                    return;
                }
                if (i13 > i14 - this.f35760d) {
                    doFlush();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                i11 = this.f35760d;
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i16 = i11 + computeUInt32SizeNoTag2;
                    this.f35760d = i16;
                    int i17 = Utf8.i(str, this.f35758b, i16, this.f35759c - i16);
                    this.f35760d = i11;
                    i12 = (i17 - i11) - computeUInt32SizeNoTag2;
                    t(i12);
                    this.f35760d = i17;
                } else {
                    i12 = Utf8.k(str);
                    t(i12);
                    this.f35760d = Utf8.i(str, this.f35758b, this.f35760d, i12);
                }
                this.f35761e += i12;
            } catch (Utf8.UnpairedSurrogateException e11) {
                this.f35761e -= this.f35760d - i11;
                this.f35760d = i11;
                throw e11;
            } catch (ArrayIndexOutOfBoundsException e12) {
                throw new OutOfSpaceException((Throwable) e12);
            } catch (Utf8.UnpairedSurrogateException e13) {
                h(str, e13);
            }
        }

        public void writeTag(int i11, int i12) throws IOException {
            writeUInt32NoTag(WireFormat.a(i11, i12));
        }

        public void writeUInt32(int i11, int i12) throws IOException {
            flushIfNotAvailable(20);
            s(i11, 0);
            t(i12);
        }

        public void writeUInt32NoTag(int i11) throws IOException {
            flushIfNotAvailable(5);
            t(i11);
        }

        public void writeUInt64(int i11, long j11) throws IOException {
            flushIfNotAvailable(20);
            s(i11, 0);
            u(j11);
        }

        public void writeUInt64NoTag(long j11) throws IOException {
            flushIfNotAvailable(10);
            u(j11);
        }

        public void writeByteArray(int i11, byte[] bArr, int i12, int i13) throws IOException {
            writeTag(i11, 2);
            writeByteArrayNoTag(bArr, i12, i13);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            int i13 = this.f35759c;
            int i14 = this.f35760d;
            if (i13 - i14 >= i12) {
                System.arraycopy(bArr, i11, this.f35758b, i14, i12);
                this.f35760d += i12;
                this.f35761e += i12;
                return;
            }
            int i15 = i13 - i14;
            System.arraycopy(bArr, i11, this.f35758b, i14, i15);
            int i16 = i11 + i15;
            int i17 = i12 - i15;
            this.f35760d = this.f35759c;
            this.f35761e += i15;
            doFlush();
            if (i17 <= this.f35759c) {
                System.arraycopy(bArr, i16, this.f35758b, 0, i17);
                this.f35760d = i17;
            } else {
                this.out.write(bArr, i16, i17);
            }
            this.f35761e += i17;
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i11 = this.f35759c;
            int i12 = this.f35760d;
            if (i11 - i12 >= remaining) {
                byteBuffer.get(this.f35758b, i12, remaining);
                this.f35760d += remaining;
                this.f35761e += remaining;
                return;
            }
            int i13 = i11 - i12;
            byteBuffer.get(this.f35758b, i12, i13);
            int i14 = remaining - i13;
            this.f35760d = this.f35759c;
            this.f35761e += i13;
            doFlush();
            while (true) {
                int i15 = this.f35759c;
                if (i14 > i15) {
                    byteBuffer.get(this.f35758b, 0, i15);
                    this.out.write(this.f35758b, 0, this.f35759c);
                    int i16 = this.f35759c;
                    i14 -= i16;
                    this.f35761e += i16;
                } else {
                    byteBuffer.get(this.f35758b, 0, i14);
                    this.f35760d = i14;
                    this.f35761e += i14;
                    return;
                }
            }
        }
    }

    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        public SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) throws IOException {
            try {
                Utf8.j(str, this.buffer);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException((Throwable) e11);
            }
        }

        public void flush() {
            this.originalBuffer.position(this.buffer.position());
        }

        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        public void n(int i11, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i11, 2);
            o(messageLite, schema);
        }

        public void o(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.writeTo(messageLite, this.f35757a);
        }

        public int spaceLeft() {
            return this.buffer.remaining();
        }

        public void write(byte b11) throws IOException {
            try {
                this.buffer.put(b11);
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException((Throwable) e11);
            }
        }

        public void writeBool(int i11, boolean z11) throws IOException {
            writeTag(i11, 0);
            write(z11 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i11, byte[] bArr) throws IOException {
            writeByteArray(i11, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i11, int i12) throws IOException {
            writeUInt32NoTag(i12);
            write(bArr, i11, i12);
        }

        public void writeByteBuffer(int i11, ByteBuffer byteBuffer) throws IOException {
            writeTag(i11, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i11, ByteString byteString) throws IOException {
            writeTag(i11, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.o(this);
        }

        public void writeFixed32(int i11, int i12) throws IOException {
            writeTag(i11, 5);
            writeFixed32NoTag(i12);
        }

        public void writeFixed32NoTag(int i11) throws IOException {
            try {
                this.buffer.putInt(i11);
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException((Throwable) e11);
            }
        }

        public void writeFixed64(int i11, long j11) throws IOException {
            writeTag(i11, 1);
            writeFixed64NoTag(j11);
        }

        public void writeFixed64NoTag(long j11) throws IOException {
            try {
                this.buffer.putLong(j11);
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException((Throwable) e11);
            }
        }

        public void writeInt32(int i11, int i12) throws IOException {
            writeTag(i11, 0);
            writeInt32NoTag(i12);
        }

        public void writeInt32NoTag(int i11) throws IOException {
            if (i11 >= 0) {
                writeUInt32NoTag(i11);
            } else {
                writeUInt64NoTag((long) i11);
            }
        }

        public void writeLazy(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }

        public void writeMessage(int i11, MessageLite messageLite) throws IOException {
            writeTag(i11, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i11, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i11, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i11, String str) throws IOException {
            writeTag(i11, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int position = this.buffer.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int position2 = this.buffer.position() + computeUInt32SizeNoTag2;
                    this.buffer.position(position2);
                    encode(str);
                    int position3 = this.buffer.position();
                    this.buffer.position(position);
                    writeUInt32NoTag(position3 - position2);
                    this.buffer.position(position3);
                    return;
                }
                writeUInt32NoTag(Utf8.k(str));
                encode(str);
            } catch (Utf8.UnpairedSurrogateException e11) {
                this.buffer.position(position);
                h(str, e11);
            } catch (IllegalArgumentException e12) {
                throw new OutOfSpaceException((Throwable) e12);
            }
        }

        public void writeTag(int i11, int i12) throws IOException {
            writeUInt32NoTag(WireFormat.a(i11, i12));
        }

        public void writeUInt32(int i11, int i12) throws IOException {
            writeTag(i11, 0);
            writeUInt32NoTag(i12);
        }

        public void writeUInt32NoTag(int i11) throws IOException {
            while ((i11 & -128) != 0) {
                this.buffer.put((byte) ((i11 & 127) | 128));
                i11 >>>= 7;
            }
            try {
                this.buffer.put((byte) i11);
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException((Throwable) e11);
            }
        }

        public void writeUInt64(int i11, long j11) throws IOException {
            writeTag(i11, 0);
            writeUInt64NoTag(j11);
        }

        public void writeUInt64NoTag(long j11) throws IOException {
            while ((-128 & j11) != 0) {
                this.buffer.put((byte) ((((int) j11) & 127) | 128));
                j11 >>>= 7;
            }
            try {
                this.buffer.put((byte) ((int) j11));
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException((Throwable) e11);
            }
        }

        public void writeByteArray(int i11, byte[] bArr, int i12, int i13) throws IOException {
            writeTag(i11, 2);
            writeByteArrayNoTag(bArr, i12, i13);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            try {
                this.buffer.put(bArr, i11, i12);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException((Throwable) e11);
            } catch (BufferOverflowException e12) {
                throw new OutOfSpaceException((Throwable) e12);
            }
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException((Throwable) e11);
            }
        }
    }

    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        public UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long i11 = UnsafeUtil.i(byteBuffer);
            this.address = i11;
            long position2 = ((long) byteBuffer.position()) + i11;
            this.initialPosition = position2;
            long limit2 = i11 + ((long) byteBuffer.limit());
            this.limit = limit2;
            this.oneVarintLimit = limit2 - 10;
            this.position = position2;
        }

        private int bufferPos(long j11) {
            return (int) (j11 - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.x();
        }

        private void repositionBuffer(long j11) {
            this.buffer.position(bufferPos(j11));
        }

        public void flush() {
            this.originalBuffer.position(bufferPos(this.position));
        }

        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        public void n(int i11, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i11, 2);
            o(messageLite, schema);
        }

        public void o(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.writeTo(messageLite, this.f35757a);
        }

        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        public void write(byte b11) throws IOException {
            long j11 = this.position;
            if (j11 < this.limit) {
                this.position = 1 + j11;
                UnsafeUtil.A(j11, b11);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        }

        public void writeBool(int i11, boolean z11) throws IOException {
            writeTag(i11, 0);
            write(z11 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i11, byte[] bArr) throws IOException {
            writeByteArray(i11, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i11, int i12) throws IOException {
            writeUInt32NoTag(i12);
            write(bArr, i11, i12);
        }

        public void writeByteBuffer(int i11, ByteBuffer byteBuffer) throws IOException {
            writeTag(i11, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i11, ByteString byteString) throws IOException {
            writeTag(i11, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.o(this);
        }

        public void writeFixed32(int i11, int i12) throws IOException {
            writeTag(i11, 5);
            writeFixed32NoTag(i12);
        }

        public void writeFixed32NoTag(int i11) throws IOException {
            this.buffer.putInt(bufferPos(this.position), i11);
            this.position += 4;
        }

        public void writeFixed64(int i11, long j11) throws IOException {
            writeTag(i11, 1);
            writeFixed64NoTag(j11);
        }

        public void writeFixed64NoTag(long j11) throws IOException {
            this.buffer.putLong(bufferPos(this.position), j11);
            this.position += 8;
        }

        public void writeInt32(int i11, int i12) throws IOException {
            writeTag(i11, 0);
            writeInt32NoTag(i12);
        }

        public void writeInt32NoTag(int i11) throws IOException {
            if (i11 >= 0) {
                writeUInt32NoTag(i11);
            } else {
                writeUInt64NoTag((long) i11);
            }
        }

        public void writeLazy(byte[] bArr, int i11, int i12) throws IOException {
            write(bArr, i11, i12);
        }

        public void writeMessage(int i11, MessageLite messageLite) throws IOException {
            writeTag(i11, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i11, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i11, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i11);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i11, String str) throws IOException {
            writeTag(i11, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            long j11 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int bufferPos = bufferPos(this.position) + computeUInt32SizeNoTag2;
                    this.buffer.position(bufferPos);
                    Utf8.j(str, this.buffer);
                    int position2 = this.buffer.position() - bufferPos;
                    writeUInt32NoTag(position2);
                    this.position += (long) position2;
                    return;
                }
                int k11 = Utf8.k(str);
                writeUInt32NoTag(k11);
                repositionBuffer(this.position);
                Utf8.j(str, this.buffer);
                this.position += (long) k11;
            } catch (Utf8.UnpairedSurrogateException e11) {
                this.position = j11;
                repositionBuffer(j11);
                h(str, e11);
            } catch (IllegalArgumentException e12) {
                throw new OutOfSpaceException((Throwable) e12);
            } catch (IndexOutOfBoundsException e13) {
                throw new OutOfSpaceException((Throwable) e13);
            }
        }

        public void writeTag(int i11, int i12) throws IOException {
            writeUInt32NoTag(WireFormat.a(i11, i12));
        }

        public void writeUInt32(int i11, int i12) throws IOException {
            writeTag(i11, 0);
            writeUInt32NoTag(i12);
        }

        public void writeUInt32NoTag(int i11) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((i11 & -128) != 0) {
                    long j11 = this.position;
                    this.position = j11 + 1;
                    UnsafeUtil.A(j11, (byte) ((i11 & 127) | 128));
                    i11 >>>= 7;
                }
                long j12 = this.position;
                this.position = 1 + j12;
                UnsafeUtil.A(j12, (byte) i11);
                return;
            }
            while (true) {
                long j13 = this.position;
                if (j13 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
                } else if ((i11 & -128) == 0) {
                    this.position = 1 + j13;
                    UnsafeUtil.A(j13, (byte) i11);
                    return;
                } else {
                    this.position = j13 + 1;
                    UnsafeUtil.A(j13, (byte) ((i11 & 127) | 128));
                    i11 >>>= 7;
                }
            }
        }

        public void writeUInt64(int i11, long j11) throws IOException {
            writeTag(i11, 0);
            writeUInt64NoTag(j11);
        }

        public void writeUInt64NoTag(long j11) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((j11 & -128) != 0) {
                    long j12 = this.position;
                    this.position = j12 + 1;
                    UnsafeUtil.A(j12, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                long j13 = this.position;
                this.position = 1 + j13;
                UnsafeUtil.A(j13, (byte) ((int) j11));
                return;
            }
            while (true) {
                long j14 = this.position;
                if (j14 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
                } else if ((j11 & -128) == 0) {
                    this.position = 1 + j14;
                    UnsafeUtil.A(j14, (byte) ((int) j11));
                    return;
                } else {
                    this.position = j14 + 1;
                    UnsafeUtil.A(j14, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
            }
        }

        public void writeByteArray(int i11, byte[] bArr, int i12, int i13) throws IOException {
            writeTag(i11, 2);
            writeByteArrayNoTag(bArr, i12, i13);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            if (bArr != null && i11 >= 0 && i12 >= 0 && bArr.length - i12 >= i11) {
                long j11 = (long) i12;
                long j12 = this.position;
                if (this.limit - j11 >= j12) {
                    UnsafeUtil.l(bArr, (long) i11, j12, j11);
                    this.position += j11;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i12)}));
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int remaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += (long) remaining;
            } catch (BufferOverflowException e11) {
                throw new OutOfSpaceException((Throwable) e11);
            }
        }
    }

    @Deprecated
    public static int b(int i11, MessageLite messageLite, Schema schema) {
        return (computeTagSize(i11) * 2) + c(messageLite, schema);
    }

    @Deprecated
    public static int c(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).d(schema);
    }

    public static int computeBoolSize(int i11, boolean z11) {
        return computeTagSize(i11) + computeBoolSizeNoTag(z11);
    }

    public static int computeBoolSizeNoTag(boolean z11) {
        return 1;
    }

    public static int computeByteArraySize(int i11, byte[] bArr) {
        return computeTagSize(i11) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return d(bArr.length);
    }

    public static int computeByteBufferSize(int i11, ByteBuffer byteBuffer) {
        return computeTagSize(i11) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return d(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i11, ByteString byteString) {
        return computeTagSize(i11) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return d(byteString.size());
    }

    public static int computeDoubleSize(int i11, double d11) {
        return computeTagSize(i11) + computeDoubleSizeNoTag(d11);
    }

    public static int computeDoubleSizeNoTag(double d11) {
        return 8;
    }

    public static int computeEnumSize(int i11, int i12) {
        return computeTagSize(i11) + computeEnumSizeNoTag(i12);
    }

    public static int computeEnumSizeNoTag(int i11) {
        return computeInt32SizeNoTag(i11);
    }

    public static int computeFixed32Size(int i11, int i12) {
        return computeTagSize(i11) + computeFixed32SizeNoTag(i12);
    }

    public static int computeFixed32SizeNoTag(int i11) {
        return 4;
    }

    public static int computeFixed64Size(int i11, long j11) {
        return computeTagSize(i11) + computeFixed64SizeNoTag(j11);
    }

    public static int computeFixed64SizeNoTag(long j11) {
        return 8;
    }

    public static int computeFloatSize(int i11, float f11) {
        return computeTagSize(i11) + computeFloatSizeNoTag(f11);
    }

    public static int computeFloatSizeNoTag(float f11) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i11, MessageLite messageLite) {
        return (computeTagSize(i11) * 2) + computeGroupSizeNoTag(messageLite);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i11, int i12) {
        return computeTagSize(i11) + computeInt32SizeNoTag(i12);
    }

    public static int computeInt32SizeNoTag(int i11) {
        if (i11 >= 0) {
            return computeUInt32SizeNoTag(i11);
        }
        return 10;
    }

    public static int computeInt64Size(int i11, long j11) {
        return computeTagSize(i11) + computeInt64SizeNoTag(j11);
    }

    public static int computeInt64SizeNoTag(long j11) {
        return computeUInt64SizeNoTag(j11);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i11, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i11) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i11, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i11) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return d(lazyFieldLite.getSerializedSize());
    }

    public static int computeMessageSetExtensionSize(int i11, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i11) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i11, MessageLite messageLite) {
        return computeTagSize(i11) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return d(messageLite.getSerializedSize());
    }

    public static int computeRawMessageSetExtensionSize(int i11, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i11) + computeBytesSize(3, byteString);
    }

    @Deprecated
    public static int computeRawVarint32Size(int i11) {
        return computeUInt32SizeNoTag(i11);
    }

    @Deprecated
    public static int computeRawVarint64Size(long j11) {
        return computeUInt64SizeNoTag(j11);
    }

    public static int computeSFixed32Size(int i11, int i12) {
        return computeTagSize(i11) + computeSFixed32SizeNoTag(i12);
    }

    public static int computeSFixed32SizeNoTag(int i11) {
        return 4;
    }

    public static int computeSFixed64Size(int i11, long j11) {
        return computeTagSize(i11) + computeSFixed64SizeNoTag(j11);
    }

    public static int computeSFixed64SizeNoTag(long j11) {
        return 8;
    }

    public static int computeSInt32Size(int i11, int i12) {
        return computeTagSize(i11) + computeSInt32SizeNoTag(i12);
    }

    public static int computeSInt32SizeNoTag(int i11) {
        return computeUInt32SizeNoTag(encodeZigZag32(i11));
    }

    public static int computeSInt64Size(int i11, long j11) {
        return computeTagSize(i11) + computeSInt64SizeNoTag(j11);
    }

    public static int computeSInt64SizeNoTag(long j11) {
        return computeUInt64SizeNoTag(encodeZigZag64(j11));
    }

    public static int computeStringSize(int i11, String str) {
        return computeTagSize(i11) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int i11;
        try {
            i11 = Utf8.k(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i11 = str.getBytes(Internal.f35797a).length;
        }
        return d(i11);
    }

    public static int computeTagSize(int i11) {
        return computeUInt32SizeNoTag(WireFormat.a(i11, 0));
    }

    public static int computeUInt32Size(int i11, int i12) {
        return computeTagSize(i11) + computeUInt32SizeNoTag(i12);
    }

    public static int computeUInt32SizeNoTag(int i11) {
        if ((i11 & -128) == 0) {
            return 1;
        }
        if ((i11 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i11) == 0) {
            return 3;
        }
        return (i11 & -268435456) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i11, long j11) {
        return computeTagSize(i11) + computeUInt64SizeNoTag(j11);
    }

    public static int computeUInt64SizeNoTag(long j11) {
        int i11;
        if ((-128 & j11) == 0) {
            return 1;
        }
        if (j11 < 0) {
            return 10;
        }
        if ((-34359738368L & j11) != 0) {
            j11 >>>= 28;
            i11 = 6;
        } else {
            i11 = 2;
        }
        if ((-2097152 & j11) != 0) {
            i11 += 2;
            j11 >>>= 14;
        }
        return (j11 & -16384) != 0 ? i11 + 1 : i11;
    }

    public static int d(int i11) {
        return computeUInt32SizeNoTag(i11) + i11;
    }

    public static int e(int i11, MessageLite messageLite, Schema schema) {
        return computeTagSize(i11) + f(messageLite, schema);
    }

    public static int encodeZigZag32(int i11) {
        return (i11 >> 31) ^ (i11 << 1);
    }

    public static long encodeZigZag64(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public static int f(MessageLite messageLite, Schema schema) {
        return d(((AbstractMessageLite) messageLite).d(schema));
    }

    public static int g(int i11) {
        if (i11 > 4096) {
            return 4096;
        }
        return i11;
    }

    public static CodedOutputStream j(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    public static CodedOutputStream k(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public final void h(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f35797a);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e11) {
            throw new OutOfSpaceException((Throwable) e11);
        } catch (OutOfSpaceException e12) {
            throw e12;
        }
    }

    public boolean i() {
        return this.serializationDeterministic;
    }

    @Deprecated
    public final void l(int i11, MessageLite messageLite, Schema schema) throws IOException {
        writeTag(i11, 3);
        m(messageLite, schema);
        writeTag(i11, 4);
    }

    @Deprecated
    public final void m(MessageLite messageLite, Schema schema) throws IOException {
        schema.writeTo(messageLite, this.f35757a);
    }

    public abstract void n(int i11, MessageLite messageLite, Schema schema) throws IOException;

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    public abstract void write(byte b11) throws IOException;

    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    public abstract void write(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void writeBool(int i11, boolean z11) throws IOException;

    public final void writeBoolNoTag(boolean z11) throws IOException {
        write(z11 ? (byte) 1 : 0);
    }

    public abstract void writeByteArray(int i11, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int i11, byte[] bArr, int i12, int i13) throws IOException;

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void writeByteBuffer(int i11, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int i11, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i11, double d11) throws IOException {
        writeFixed64(i11, Double.doubleToRawLongBits(d11));
    }

    public final void writeDoubleNoTag(double d11) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d11));
    }

    public final void writeEnum(int i11, int i12) throws IOException {
        writeInt32(i11, i12);
    }

    public final void writeEnumNoTag(int i11) throws IOException {
        writeInt32NoTag(i11);
    }

    public abstract void writeFixed32(int i11, int i12) throws IOException;

    public abstract void writeFixed32NoTag(int i11) throws IOException;

    public abstract void writeFixed64(int i11, long j11) throws IOException;

    public abstract void writeFixed64NoTag(long j11) throws IOException;

    public final void writeFloat(int i11, float f11) throws IOException {
        writeFixed32(i11, Float.floatToRawIntBits(f11));
    }

    public final void writeFloatNoTag(float f11) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f11));
    }

    @Deprecated
    public final void writeGroup(int i11, MessageLite messageLite) throws IOException {
        writeTag(i11, 3);
        writeGroupNoTag(messageLite);
        writeTag(i11, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i11, int i12) throws IOException;

    public abstract void writeInt32NoTag(int i11) throws IOException;

    public final void writeInt64(int i11, long j11) throws IOException {
        writeUInt64(i11, j11);
    }

    public final void writeInt64NoTag(long j11) throws IOException {
        writeUInt64NoTag(j11);
    }

    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    public abstract void writeLazy(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void writeMessage(int i11, MessageLite messageLite) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    public abstract void writeMessageSetExtension(int i11, MessageLite messageLite) throws IOException;

    public final void writeRawByte(byte b11) throws IOException {
        write(b11);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Deprecated
    public final void writeRawLittleEndian32(int i11) throws IOException {
        writeFixed32NoTag(i11);
    }

    @Deprecated
    public final void writeRawLittleEndian64(long j11) throws IOException {
        writeFixed64NoTag(j11);
    }

    public abstract void writeRawMessageSetExtension(int i11, ByteString byteString) throws IOException;

    @Deprecated
    public final void writeRawVarint32(int i11) throws IOException {
        writeUInt32NoTag(i11);
    }

    @Deprecated
    public final void writeRawVarint64(long j11) throws IOException {
        writeUInt64NoTag(j11);
    }

    public final void writeSFixed32(int i11, int i12) throws IOException {
        writeFixed32(i11, i12);
    }

    public final void writeSFixed32NoTag(int i11) throws IOException {
        writeFixed32NoTag(i11);
    }

    public final void writeSFixed64(int i11, long j11) throws IOException {
        writeFixed64(i11, j11);
    }

    public final void writeSFixed64NoTag(long j11) throws IOException {
        writeFixed64NoTag(j11);
    }

    public final void writeSInt32(int i11, int i12) throws IOException {
        writeUInt32(i11, encodeZigZag32(i12));
    }

    public final void writeSInt32NoTag(int i11) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i11));
    }

    public final void writeSInt64(int i11, long j11) throws IOException {
        writeUInt64(i11, encodeZigZag64(j11));
    }

    public final void writeSInt64NoTag(long j11) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j11));
    }

    public abstract void writeString(int i11, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i11, int i12) throws IOException;

    public abstract void writeUInt32(int i11, int i12) throws IOException;

    public abstract void writeUInt32NoTag(int i11) throws IOException;

    public abstract void writeUInt64(int i11, long j11) throws IOException;

    public abstract void writeUInt64NoTag(long j11) throws IOException;

    private CodedOutputStream() {
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i11) {
        return new OutputStreamEncoder(outputStream, i11);
    }

    public final void writeRawByte(int i11) throws IOException {
        write((byte) i11);
    }

    public final void writeRawBytes(byte[] bArr, int i11, int i12) throws IOException {
        write(bArr, i11, i12);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.o(this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i11, int i12) {
        return new ArrayEncoder(bArr, i11, i12);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (UnsafeDirectNioEncoder.isSupported()) {
            return k(byteBuffer);
        } else {
            return j(byteBuffer);
        }
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i11) {
        return newInstance(byteBuffer);
    }
}
