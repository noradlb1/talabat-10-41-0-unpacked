package org.apache.commons.compress.compressors.gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class GzipCompressorOutputStream extends CompressorOutputStream {
    private static final int FCOMMENT = 16;
    private static final int FNAME = 8;
    private boolean closed;
    private final CRC32 crc;
    private final byte[] deflateBuffer;
    private final Deflater deflater;
    private final OutputStream out;

    public GzipCompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, new GzipParameters());
    }

    private void deflate() throws IOException {
        Deflater deflater2 = this.deflater;
        byte[] bArr = this.deflateBuffer;
        int deflate = deflater2.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            this.out.write(this.deflateBuffer, 0, deflate);
        }
    }

    private void writeHeader(GzipParameters gzipParameters) throws IOException {
        int i11;
        String filename = gzipParameters.getFilename();
        String comment = gzipParameters.getComment();
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort(-29921);
        int i12 = 8;
        allocate.put((byte) 8);
        if (filename == null) {
            i12 = 0;
        }
        if (comment != null) {
            i11 = 16;
        } else {
            i11 = 0;
        }
        allocate.put((byte) (i12 | i11));
        allocate.putInt((int) (gzipParameters.getModificationTime() / 1000));
        int compressionLevel = gzipParameters.getCompressionLevel();
        if (compressionLevel == 9) {
            allocate.put((byte) 2);
        } else if (compressionLevel == 1) {
            allocate.put((byte) 4);
        } else {
            allocate.put((byte) 0);
        }
        allocate.put((byte) gzipParameters.getOperatingSystem());
        this.out.write(allocate.array());
        if (filename != null) {
            this.out.write(filename.getBytes(StandardCharsets.ISO_8859_1));
            this.out.write(0);
        }
        if (comment != null) {
            this.out.write(comment.getBytes(StandardCharsets.ISO_8859_1));
            this.out.write(0);
        }
    }

    private void writeTrailer() throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt((int) this.crc.getValue());
        allocate.putInt(this.deflater.getTotalIn());
        this.out.write(allocate.array());
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                finish();
            } finally {
                this.deflater.end();
                this.out.close();
                this.closed = true;
            }
        }
    }

    public void finish() throws IOException {
        if (!this.deflater.finished()) {
            this.deflater.finish();
            while (!this.deflater.finished()) {
                deflate();
            }
            writeTrailer();
        }
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(int i11) throws IOException {
        write(new byte[]{(byte) (i11 & 255)}, 0, 1);
    }

    public GzipCompressorOutputStream(OutputStream outputStream, GzipParameters gzipParameters) throws IOException {
        this.crc = new CRC32();
        this.out = outputStream;
        this.deflater = new Deflater(gzipParameters.getCompressionLevel(), true);
        this.deflateBuffer = new byte[gzipParameters.getBufferSize()];
        writeHeader(gzipParameters);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (this.deflater.finished()) {
            throw new IOException("Cannot write more data, the end of the compressed data stream has been reached");
        } else if (i12 > 0) {
            this.deflater.setInput(bArr, i11, i12);
            while (!this.deflater.needsInput()) {
                deflate();
            }
            this.crc.update(bArr, i11, i12);
        }
    }
}
