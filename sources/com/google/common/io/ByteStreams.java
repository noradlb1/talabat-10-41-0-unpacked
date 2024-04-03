package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        public void write(int i11) {
        }

        public void write(byte[] bArr) {
            Preconditions.checkNotNull(bArr);
        }

        public void write(byte[] bArr, int i11, int i12) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkPositionIndexes(i11, i12 + i11, bArr.length);
        }
    };
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    private ByteStreams() {
    }

    private static byte[] combineBuffers(Queue<byte[]> queue, int i11) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i11) {
            return remove;
        }
        int length = i11 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i11);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i11 - length, min);
            length -= min;
        }
        return copyOf;
    }

    @CanIgnoreReturnValue
    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] createBuffer = createBuffer();
        long j11 = 0;
        while (true) {
            int read = inputStream.read(createBuffer);
            if (read == -1) {
                return j11;
            }
            outputStream.write(createBuffer, 0, read);
            j11 += (long) read;
        }
    }

    public static byte[] createBuffer() {
        return new byte[8192];
    }

    @CanIgnoreReturnValue
    public static long exhaust(InputStream inputStream) throws IOException {
        byte[] createBuffer = createBuffer();
        long j11 = 0;
        while (true) {
            long read = (long) inputStream.read(createBuffer);
            if (read == -1) {
                return j11;
            }
            j11 += read;
        }
    }

    public static InputStream limit(InputStream inputStream, long j11) {
        return new LimitedInputStream(inputStream, j11);
    }

    public static ByteArrayDataInput newDataInput(byte[] bArr) {
        return newDataInput(new ByteArrayInputStream(bArr));
    }

    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    @CanIgnoreReturnValue
    public static int read(InputStream inputStream, byte[] bArr, int i11, int i12) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        int i13 = 0;
        if (i12 >= 0) {
            Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
            while (i13 < i12) {
                int read = inputStream.read(bArr, i11 + i13, i12 - i13);
                if (read == -1) {
                    break;
                }
                i13 += read;
            }
            return i13;
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[]{Integer.valueOf(i12)}));
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T readBytes(InputStream inputStream, ByteProcessor<T> byteProcessor) throws IOException {
        int read;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] createBuffer = createBuffer();
        do {
            read = inputStream.read(createBuffer);
            if (read == -1 || !byteProcessor.processBytes(createBuffer, 0, read)) {
            }
            read = inputStream.read(createBuffer);
            break;
        } while (!byteProcessor.processBytes(createBuffer, 0, read));
        return byteProcessor.getResult();
    }

    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void skipFully(InputStream inputStream, long j11) throws IOException {
        long skipUpTo = skipUpTo(inputStream, j11);
        if (skipUpTo < j11) {
            throw new EOFException("reached end of stream after skipping " + skipUpTo + " bytes; " + j11 + " bytes expected");
        }
    }

    private static long skipSafely(InputStream inputStream, long j11) throws IOException {
        int available = inputStream.available();
        if (available == 0) {
            return 0;
        }
        return inputStream.skip(Math.min((long) available, j11));
    }

    public static long skipUpTo(InputStream inputStream, long j11) throws IOException {
        byte[] bArr = null;
        long j12 = 0;
        while (j12 < j11) {
            long j13 = j11 - j12;
            long skipSafely = skipSafely(inputStream, j13);
            if (skipSafely == 0) {
                int min = (int) Math.min(j13, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (bArr == null) {
                    bArr = new byte[min];
                }
                skipSafely = (long) inputStream.read(bArr, 0, min);
                if (skipSafely == -1) {
                    break;
                }
            }
            j12 += skipSafely;
        }
        return j12;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] toByteArrayInternal(InputStream inputStream, Queue<byte[]> queue, int i11) throws IOException {
        int i12;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i11) * 2));
        while (i11 < MAX_ARRAY_LEN) {
            int min2 = Math.min(min, MAX_ARRAY_LEN - i11);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i13 = 0;
            while (i13 < min2) {
                int read = inputStream.read(bArr, i13, min2 - i13);
                if (read == -1) {
                    return combineBuffers(queue, i11);
                }
                i13 += read;
                i11 += read;
            }
            if (min < 4096) {
                i12 = 4;
            } else {
                i12 = 2;
            }
            min = IntMath.saturatedMultiply(min, i12);
        }
        if (inputStream.read() == -1) {
            return combineBuffers(queue, MAX_ARRAY_LEN);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        public ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.input = new DataInputStream(byteArrayInputStream);
        }

        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public byte readByte() {
            try {
                return this.input.readByte();
            } catch (EOFException e11) {
                throw new IllegalStateException(e11);
            } catch (IOException e12) {
                throw new AssertionError(e12);
            }
        }

        public char readChar() {
            try {
                return this.input.readChar();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public double readDouble() {
            try {
                return this.input.readDouble();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public float readFloat() {
            try {
                return this.input.readFloat();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public void readFully(byte[] bArr) {
            try {
                this.input.readFully(bArr);
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public int readInt() {
            try {
                return this.input.readInt();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        @CheckForNull
        public String readLine() {
            try {
                return this.input.readLine();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public long readLong() {
            try {
                return this.input.readLong();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public short readShort() {
            try {
                return this.input.readShort();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public String readUTF() {
            try {
                return this.input.readUTF();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public int skipBytes(int i11) {
            try {
                return this.input.skipBytes(i11);
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public void readFully(byte[] bArr, int i11, int i12) {
            try {
                this.input.readFully(bArr, i11, i12);
            } catch (IOException e11) {
                throw new IllegalStateException(e11);
            }
        }
    }

    public static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream byteArrayOutputStream;
        final DataOutput output;

        public ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream2) {
            this.byteArrayOutputStream = byteArrayOutputStream2;
            this.output = new DataOutputStream(byteArrayOutputStream2);
        }

        public byte[] toByteArray() {
            return this.byteArrayOutputStream.toByteArray();
        }

        public void write(int i11) {
            try {
                this.output.write(i11);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeBoolean(boolean z11) {
            try {
                this.output.writeBoolean(z11);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeByte(int i11) {
            try {
                this.output.writeByte(i11);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeBytes(String str) {
            try {
                this.output.writeBytes(str);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeChar(int i11) {
            try {
                this.output.writeChar(i11);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeChars(String str) {
            try {
                this.output.writeChars(str);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeDouble(double d11) {
            try {
                this.output.writeDouble(d11);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeFloat(float f11) {
            try {
                this.output.writeFloat(f11);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeInt(int i11) {
            try {
                this.output.writeInt(i11);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeLong(long j11) {
            try {
                this.output.writeLong(j11);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeShort(int i11) {
            try {
                this.output.writeShort(i11);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void writeUTF(String str) {
            try {
                this.output.writeUTF(str);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void write(byte[] bArr) {
            try {
                this.output.write(bArr);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public void write(byte[] bArr, int i11, int i12) {
            try {
                this.output.write(bArr, i11, i12);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public static ByteArrayDataInput newDataInput(byte[] bArr, int i11) {
        Preconditions.checkPositionIndex(i11, bArr.length);
        return newDataInput(new ByteArrayInputStream(bArr, i11, bArr.length - i11));
    }

    public static ByteArrayDataOutput newDataOutput(int i11) {
        if (i11 >= 0) {
            return newDataOutput(new ByteArrayOutputStream(i11));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[]{Integer.valueOf(i11)}));
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i11, int i12) throws IOException {
        int read = read(inputStream, bArr, i11, i12);
        if (read != i12) {
            throw new EOFException("reached end of stream after reading " + read + " bytes; " + i12 + " bytes expected");
        }
    }

    public static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark = -1;

        public LimitedInputStream(InputStream inputStream, long j11) {
            super(inputStream);
            boolean z11;
            Preconditions.checkNotNull(inputStream);
            if (j11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "limit must be non-negative");
            this.left = j11;
        }

        public int available() throws IOException {
            return (int) Math.min((long) this.in.available(), this.left);
        }

        public synchronized void mark(int i11) {
            this.in.mark(i11);
            this.mark = this.left;
        }

        public int read() throws IOException {
            if (this.left == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.left--;
            }
            return read;
        }

        public synchronized void reset() throws IOException {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.mark != -1) {
                this.in.reset();
                this.left = this.mark;
            } else {
                throw new IOException("Mark not set");
            }
        }

        public long skip(long j11) throws IOException {
            long skip = this.in.skip(Math.min(j11, this.left));
            this.left -= skip;
            return skip;
        }

        public int read(byte[] bArr, int i11, int i12) throws IOException {
            long j11 = this.left;
            if (j11 == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i11, (int) Math.min((long) i12, j11));
            if (read != -1) {
                this.left -= (long) read;
            }
            return read;
        }
    }

    public static byte[] toByteArray(InputStream inputStream, long j11) throws IOException {
        Preconditions.checkArgument(j11 >= 0, "expectedSize (%s) must be non-negative", j11);
        if (j11 <= 2147483639) {
            int i11 = (int) j11;
            byte[] bArr = new byte[i11];
            int i12 = i11;
            while (i12 > 0) {
                int i13 = i11 - i12;
                int read = inputStream.read(bArr, i13, i12);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i13);
                }
                i12 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) read2});
            return toByteArrayInternal(inputStream, arrayDeque, i11 + 1);
        }
        throw new OutOfMemoryError(j11 + " bytes is too large to fit in a byte array");
    }

    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(byteArrayInputStream));
    }

    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(byteArrayOutputStream));
    }

    @CanIgnoreReturnValue
    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        long j11 = 0;
        if (readableByteChannel instanceof FileChannel) {
            FileChannel fileChannel = (FileChannel) readableByteChannel;
            long position = fileChannel.position();
            long j12 = position;
            while (true) {
                long transferTo = fileChannel.transferTo(j12, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, writableByteChannel);
                j12 += transferTo;
                fileChannel.position(j12);
                if (transferTo <= 0 && j12 >= fileChannel.size()) {
                    return j12 - position;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(createBuffer());
            while (readableByteChannel.read(wrap) != -1) {
                Java8Compatibility.flip(wrap);
                while (wrap.hasRemaining()) {
                    j11 += (long) writableByteChannel.write(wrap);
                }
                Java8Compatibility.clear(wrap);
            }
            return j11;
        }
    }
}
