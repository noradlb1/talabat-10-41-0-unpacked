package org.apache.commons.compress.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ByteUtils {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public interface ByteConsumer {
        void accept(int i11) throws IOException;
    }

    public interface ByteSupplier {
        int getAsByte() throws IOException;
    }

    public static class InputStreamByteSupplier implements ByteSupplier {

        /* renamed from: is  reason: collision with root package name */
        private final InputStream f27772is;

        public InputStreamByteSupplier(InputStream inputStream) {
            this.f27772is = inputStream;
        }

        public int getAsByte() throws IOException {
            return this.f27772is.read();
        }
    }

    public static class OutputStreamByteConsumer implements ByteConsumer {

        /* renamed from: os  reason: collision with root package name */
        private final OutputStream f27773os;

        public OutputStreamByteConsumer(OutputStream outputStream) {
            this.f27773os = outputStream;
        }

        public void accept(int i11) throws IOException {
            this.f27773os.write(i11);
        }
    }

    private ByteUtils() {
    }

    private static void checkReadLength(int i11) {
        if (i11 > 8) {
            throw new IllegalArgumentException("Can't read more than eight bytes into a long value");
        }
    }

    public static long fromLittleEndian(byte[] bArr) {
        return fromLittleEndian(bArr, 0, bArr.length);
    }

    public static void toLittleEndian(byte[] bArr, long j11, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[i11 + i13] = (byte) ((int) (255 & j11));
            j11 >>= 8;
        }
    }

    public static long fromLittleEndian(byte[] bArr, int i11, int i12) {
        checkReadLength(i12);
        long j11 = 0;
        for (int i13 = 0; i13 < i12; i13++) {
            j11 |= (((long) bArr[i11 + i13]) & 255) << (i13 * 8);
        }
        return j11;
    }

    public static void toLittleEndian(OutputStream outputStream, long j11, int i11) throws IOException {
        for (int i12 = 0; i12 < i11; i12++) {
            outputStream.write((int) (255 & j11));
            j11 >>= 8;
        }
    }

    public static void toLittleEndian(ByteConsumer byteConsumer, long j11, int i11) throws IOException {
        for (int i12 = 0; i12 < i11; i12++) {
            byteConsumer.accept((int) (255 & j11));
            j11 >>= 8;
        }
    }

    public static long fromLittleEndian(InputStream inputStream, int i11) throws IOException {
        checkReadLength(i11);
        long j11 = 0;
        int i12 = 0;
        while (i12 < i11) {
            long read = (long) inputStream.read();
            if (read != -1) {
                j11 |= read << (i12 * 8);
                i12++;
            } else {
                throw new IOException("Premature end of data");
            }
        }
        return j11;
    }

    public static void toLittleEndian(DataOutput dataOutput, long j11, int i11) throws IOException {
        for (int i12 = 0; i12 < i11; i12++) {
            dataOutput.write((int) (255 & j11));
            j11 >>= 8;
        }
    }

    public static long fromLittleEndian(ByteSupplier byteSupplier, int i11) throws IOException {
        checkReadLength(i11);
        long j11 = 0;
        int i12 = 0;
        while (i12 < i11) {
            long asByte = (long) byteSupplier.getAsByte();
            if (asByte != -1) {
                j11 |= asByte << (i12 * 8);
                i12++;
            } else {
                throw new IOException("Premature end of data");
            }
        }
        return j11;
    }

    public static long fromLittleEndian(DataInput dataInput, int i11) throws IOException {
        checkReadLength(i11);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 |= ((long) dataInput.readUnsignedByte()) << (i12 * 8);
        }
        return j11;
    }
}
