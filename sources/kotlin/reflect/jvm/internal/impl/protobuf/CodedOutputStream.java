package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position;
    private int totalBytesWritten = 0;

    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
    }

    public static int a(int i11) {
        if (i11 > 4096) {
            return 4096;
        }
        return i11;
    }

    public static int computeBoolSize(int i11, boolean z11) {
        return computeTagSize(i11) + computeBoolSizeNoTag(z11);
    }

    public static int computeBoolSizeNoTag(boolean z11) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeBytesSize(int i11, ByteString byteString) {
        return computeTagSize(i11) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeRawVarint32Size(byteString.size()) + byteString.size();
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

    public static int computeFixed32SizeNoTag(int i11) {
        return 4;
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

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i11, int i12) {
        return computeTagSize(i11) + computeInt32SizeNoTag(i12);
    }

    public static int computeInt32SizeNoTag(int i11) {
        if (i11 >= 0) {
            return computeRawVarint32Size(i11);
        }
        return 10;
    }

    public static int computeInt64SizeNoTag(long j11) {
        return computeRawVarint64Size(j11);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        int serializedSize = lazyFieldLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeMessageSize(int i11, MessageLite messageLite) {
        return computeTagSize(i11) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeRawVarint32Size(int i11) {
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

    public static int computeRawVarint64Size(long j11) {
        if ((-128 & j11) == 0) {
            return 1;
        }
        if ((-16384 & j11) == 0) {
            return 2;
        }
        if ((-2097152 & j11) == 0) {
            return 3;
        }
        if ((-268435456 & j11) == 0) {
            return 4;
        }
        if ((-34359738368L & j11) == 0) {
            return 5;
        }
        if ((-4398046511104L & j11) == 0) {
            return 6;
        }
        if ((-562949953421312L & j11) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j11) == 0) {
            return 8;
        }
        return (j11 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32SizeNoTag(int i11) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j11) {
        return 8;
    }

    public static int computeSInt32SizeNoTag(int i11) {
        return computeRawVarint32Size(encodeZigZag32(i11));
    }

    public static int computeSInt64Size(int i11, long j11) {
        return computeTagSize(i11) + computeSInt64SizeNoTag(j11);
    }

    public static int computeSInt64SizeNoTag(long j11) {
        return computeRawVarint64Size(encodeZigZag64(j11));
    }

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException("UTF-8 not supported.", e11);
        }
    }

    public static int computeTagSize(int i11) {
        return computeRawVarint32Size(WireFormat.b(i11, 0));
    }

    public static int computeUInt32SizeNoTag(int i11) {
        return computeRawVarint32Size(i11);
    }

    public static int computeUInt64SizeNoTag(long j11) {
        return computeRawVarint64Size(j11);
    }

    public static int encodeZigZag32(int i11) {
        return (i11 >> 31) ^ (i11 << 1);
    }

    public static long encodeZigZag64(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i11) {
        return new CodedOutputStream(outputStream, new byte[i11]);
    }

    private void refreshBuffer() throws IOException {
        OutputStream outputStream = this.output;
        if (outputStream != null) {
            outputStream.write(this.buffer, 0, this.position);
            this.position = 0;
            return;
        }
        throw new OutOfSpaceException();
    }

    public void flush() throws IOException {
        if (this.output != null) {
            refreshBuffer();
        }
    }

    public void writeBool(int i11, boolean z11) throws IOException {
        writeTag(i11, 0);
        writeBoolNoTag(z11);
    }

    public void writeBoolNoTag(boolean z11) throws IOException {
        writeRawByte(z11 ? 1 : 0);
    }

    public void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeBytes(int i11, ByteString byteString) throws IOException {
        writeTag(i11, 2);
        writeBytesNoTag(byteString);
    }

    public void writeBytesNoTag(ByteString byteString) throws IOException {
        writeRawVarint32(byteString.size());
        writeRawBytes(byteString);
    }

    public void writeDouble(int i11, double d11) throws IOException {
        writeTag(i11, 1);
        writeDoubleNoTag(d11);
    }

    public void writeDoubleNoTag(double d11) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(d11));
    }

    public void writeEnum(int i11, int i12) throws IOException {
        writeTag(i11, 0);
        writeEnumNoTag(i12);
    }

    public void writeEnumNoTag(int i11) throws IOException {
        writeInt32NoTag(i11);
    }

    public void writeFixed32NoTag(int i11) throws IOException {
        writeRawLittleEndian32(i11);
    }

    public void writeFixed64NoTag(long j11) throws IOException {
        writeRawLittleEndian64(j11);
    }

    public void writeFloat(int i11, float f11) throws IOException {
        writeTag(i11, 5);
        writeFloatNoTag(f11);
    }

    public void writeFloatNoTag(float f11) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(f11));
    }

    public void writeGroup(int i11, MessageLite messageLite) throws IOException {
        writeTag(i11, 3);
        writeGroupNoTag(messageLite);
        writeTag(i11, 4);
    }

    public void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public void writeInt32(int i11, int i12) throws IOException {
        writeTag(i11, 0);
        writeInt32NoTag(i12);
    }

    public void writeInt32NoTag(int i11) throws IOException {
        if (i11 >= 0) {
            writeRawVarint32(i11);
        } else {
            writeRawVarint64((long) i11);
        }
    }

    public void writeInt64NoTag(long j11) throws IOException {
        writeRawVarint64(j11);
    }

    public void writeMessage(int i11, MessageLite messageLite) throws IOException {
        writeTag(i11, 2);
        writeMessageNoTag(messageLite);
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeMessageSetExtension(int i11, MessageLite messageLite) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i11);
        writeMessage(3, messageLite);
        writeTag(1, 4);
    }

    public void writeRawByte(byte b11) throws IOException {
        if (this.position == this.limit) {
            refreshBuffer();
        }
        byte[] bArr = this.buffer;
        int i11 = this.position;
        this.position = i11 + 1;
        bArr[i11] = b11;
        this.totalBytesWritten++;
    }

    public void writeRawBytes(ByteString byteString) throws IOException {
        writeRawBytes(byteString, 0, byteString.size());
    }

    public void writeRawLittleEndian32(int i11) throws IOException {
        writeRawByte(i11 & 255);
        writeRawByte((i11 >> 8) & 255);
        writeRawByte((i11 >> 16) & 255);
        writeRawByte((i11 >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j11) throws IOException {
        writeRawByte(((int) j11) & 255);
        writeRawByte(((int) (j11 >> 8)) & 255);
        writeRawByte(((int) (j11 >> 16)) & 255);
        writeRawByte(((int) (j11 >> 24)) & 255);
        writeRawByte(((int) (j11 >> 32)) & 255);
        writeRawByte(((int) (j11 >> 40)) & 255);
        writeRawByte(((int) (j11 >> 48)) & 255);
        writeRawByte(((int) (j11 >> 56)) & 255);
    }

    public void writeRawVarint32(int i11) throws IOException {
        while ((i11 & -128) != 0) {
            writeRawByte((i11 & 127) | 128);
            i11 >>>= 7;
        }
        writeRawByte(i11);
    }

    public void writeRawVarint64(long j11) throws IOException {
        while ((-128 & j11) != 0) {
            writeRawByte((((int) j11) & 127) | 128);
            j11 >>>= 7;
        }
        writeRawByte((int) j11);
    }

    public void writeSFixed32NoTag(int i11) throws IOException {
        writeRawLittleEndian32(i11);
    }

    public void writeSFixed64NoTag(long j11) throws IOException {
        writeRawLittleEndian64(j11);
    }

    public void writeSInt32NoTag(int i11) throws IOException {
        writeRawVarint32(encodeZigZag32(i11));
    }

    public void writeSInt64(int i11, long j11) throws IOException {
        writeTag(i11, 0);
        writeSInt64NoTag(j11);
    }

    public void writeSInt64NoTag(long j11) throws IOException {
        writeRawVarint64(encodeZigZag64(j11));
    }

    public void writeStringNoTag(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i11, int i12) throws IOException {
        writeRawVarint32(WireFormat.b(i11, i12));
    }

    public void writeUInt32(int i11, int i12) throws IOException {
        writeTag(i11, 0);
        writeUInt32NoTag(i12);
    }

    public void writeUInt32NoTag(int i11) throws IOException {
        writeRawVarint32(i11);
    }

    public void writeUInt64NoTag(long j11) throws IOException {
        writeRawVarint64(j11);
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this.limit;
        int i14 = this.position;
        if (i13 - i14 >= i12) {
            System.arraycopy(bArr, i11, this.buffer, i14, i12);
            this.position += i12;
            this.totalBytesWritten += i12;
            return;
        }
        int i15 = i13 - i14;
        System.arraycopy(bArr, i11, this.buffer, i14, i15);
        int i16 = i11 + i15;
        int i17 = i12 - i15;
        this.position = this.limit;
        this.totalBytesWritten += i15;
        refreshBuffer();
        if (i17 <= this.limit) {
            System.arraycopy(bArr, i16, this.buffer, 0, i17);
            this.position = i17;
        } else {
            this.output.write(bArr, i16, i17);
        }
        this.totalBytesWritten += i17;
    }

    public void writeRawByte(int i11) throws IOException {
        writeRawByte((byte) i11);
    }

    public void writeRawBytes(ByteString byteString, int i11, int i12) throws IOException {
        int i13 = this.limit;
        int i14 = this.position;
        if (i13 - i14 >= i12) {
            byteString.copyTo(this.buffer, i11, i14, i12);
            this.position += i12;
            this.totalBytesWritten += i12;
            return;
        }
        int i15 = i13 - i14;
        byteString.copyTo(this.buffer, i11, i14, i15);
        int i16 = i11 + i15;
        int i17 = i12 - i15;
        this.position = this.limit;
        this.totalBytesWritten += i15;
        refreshBuffer();
        if (i17 <= this.limit) {
            byteString.copyTo(this.buffer, i16, 0, i17);
            this.position = i17;
        } else {
            byteString.g(this.output, i16, i17);
        }
        this.totalBytesWritten += i17;
    }
}
