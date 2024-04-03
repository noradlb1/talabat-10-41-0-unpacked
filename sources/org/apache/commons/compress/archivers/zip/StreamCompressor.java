package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;

public abstract class StreamCompressor implements Closeable {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFLATER_BLOCK_SIZE = 8192;
    private final CRC32 crc = new CRC32();
    private final Deflater def;
    private final byte[] outputBuffer = new byte[4096];
    private final byte[] readerBuf = new byte[4096];
    private long sourcePayloadLength;
    private long totalWrittenToOutputStream;
    private long writtenToOutputStreamForLastEntry;

    public static final class DataOutputCompressor extends StreamCompressor {
        private final DataOutput raf;

        public DataOutputCompressor(Deflater deflater, DataOutput dataOutput) {
            super(deflater);
            this.raf = dataOutput;
        }

        public void writeOut(byte[] bArr, int i11, int i12) throws IOException {
            this.raf.write(bArr, i11, i12);
        }
    }

    public static final class OutputStreamCompressor extends StreamCompressor {

        /* renamed from: os  reason: collision with root package name */
        private final OutputStream f27653os;

        public OutputStreamCompressor(Deflater deflater, OutputStream outputStream) {
            super(deflater);
            this.f27653os = outputStream;
        }

        public void writeOut(byte[] bArr, int i11, int i12) throws IOException {
            this.f27653os.write(bArr, i11, i12);
        }
    }

    public static final class ScatterGatherBackingStoreCompressor extends StreamCompressor {

        /* renamed from: bs  reason: collision with root package name */
        private final ScatterGatherBackingStore f27654bs;

        public ScatterGatherBackingStoreCompressor(Deflater deflater, ScatterGatherBackingStore scatterGatherBackingStore) {
            super(deflater);
            this.f27654bs = scatterGatherBackingStore;
        }

        public void writeOut(byte[] bArr, int i11, int i12) throws IOException {
            this.f27654bs.writeOut(bArr, i11, i12);
        }
    }

    public static final class SeekableByteChannelCompressor extends StreamCompressor {
        private final SeekableByteChannel channel;

        public SeekableByteChannelCompressor(Deflater deflater, SeekableByteChannel seekableByteChannel) {
            super(deflater);
            this.channel = seekableByteChannel;
        }

        public void writeOut(byte[] bArr, int i11, int i12) throws IOException {
            int unused = this.channel.write(ByteBuffer.wrap(bArr, i11, i12));
        }
    }

    public StreamCompressor(Deflater deflater) {
        this.def = deflater;
    }

    public static StreamCompressor create(OutputStream outputStream, Deflater deflater) {
        return new OutputStreamCompressor(deflater, outputStream);
    }

    private void deflateUntilInputIsNeeded() throws IOException {
        while (!this.def.needsInput()) {
            deflate();
        }
    }

    private void writeDeflated(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 > 0 && !this.def.finished()) {
            if (i12 <= 8192) {
                this.def.setInput(bArr, i11, i12);
                deflateUntilInputIsNeeded();
                return;
            }
            int i13 = i12 / 8192;
            for (int i14 = 0; i14 < i13; i14++) {
                this.def.setInput(bArr, (i14 * 8192) + i11, 8192);
                deflateUntilInputIsNeeded();
            }
            int i15 = i13 * 8192;
            if (i15 < i12) {
                this.def.setInput(bArr, i11 + i15, i12 - i15);
                deflateUntilInputIsNeeded();
            }
        }
    }

    public void close() throws IOException {
        this.def.end();
    }

    public void deflate(InputStream inputStream, int i11) throws IOException {
        reset();
        while (true) {
            byte[] bArr = this.readerBuf;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read < 0) {
                break;
            }
            write(this.readerBuf, 0, read, i11);
        }
        if (i11 == 8) {
            flushDeflater();
        }
    }

    public void flushDeflater() throws IOException {
        this.def.finish();
        while (!this.def.finished()) {
            deflate();
        }
    }

    public long getBytesRead() {
        return this.sourcePayloadLength;
    }

    public long getBytesWrittenForLastEntry() {
        return this.writtenToOutputStreamForLastEntry;
    }

    public long getCrc32() {
        return this.crc.getValue();
    }

    public long getTotalBytesWritten() {
        return this.totalWrittenToOutputStream;
    }

    public void reset() {
        this.crc.reset();
        this.def.reset();
        this.sourcePayloadLength = 0;
        this.writtenToOutputStreamForLastEntry = 0;
    }

    public long write(byte[] bArr, int i11, int i12, int i13) throws IOException {
        long j11 = this.writtenToOutputStreamForLastEntry;
        this.crc.update(bArr, i11, i12);
        if (i13 == 8) {
            writeDeflated(bArr, i11, i12);
        } else {
            writeCounted(bArr, i11, i12);
        }
        this.sourcePayloadLength += (long) i12;
        return this.writtenToOutputStreamForLastEntry - j11;
    }

    public void writeCounted(byte[] bArr) throws IOException {
        writeCounted(bArr, 0, bArr.length);
    }

    public abstract void writeOut(byte[] bArr, int i11, int i12) throws IOException;

    public static StreamCompressor create(OutputStream outputStream) {
        return create(outputStream, new Deflater(-1, true));
    }

    public void writeCounted(byte[] bArr, int i11, int i12) throws IOException {
        writeOut(bArr, i11, i12);
        long j11 = (long) i12;
        this.writtenToOutputStreamForLastEntry += j11;
        this.totalWrittenToOutputStream += j11;
    }

    public static StreamCompressor create(DataOutput dataOutput, Deflater deflater) {
        return new DataOutputCompressor(deflater, dataOutput);
    }

    public static StreamCompressor create(SeekableByteChannel seekableByteChannel, Deflater deflater) {
        return new SeekableByteChannelCompressor(deflater, seekableByteChannel);
    }

    public static StreamCompressor create(int i11, ScatterGatherBackingStore scatterGatherBackingStore) {
        return new ScatterGatherBackingStoreCompressor(new Deflater(i11, true), scatterGatherBackingStore);
    }

    public void deflate() throws IOException {
        Deflater deflater = this.def;
        byte[] bArr = this.outputBuffer;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            writeCounted(this.outputBuffer, 0, deflate);
        }
    }

    public static StreamCompressor create(ScatterGatherBackingStore scatterGatherBackingStore) {
        return create(-1, scatterGatherBackingStore);
    }
}
