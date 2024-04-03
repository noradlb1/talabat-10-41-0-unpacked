package org.apache.commons.compress.compressors.zstandard;

import com.github.luben.zstd.ZstdOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class ZstdCompressorOutputStream extends CompressorOutputStream {
    private final ZstdOutputStream encOS;

    public ZstdCompressorOutputStream(OutputStream outputStream, int i11, boolean z11, boolean z12) throws IOException {
        ZstdOutputStream zstdOutputStream = new ZstdOutputStream(outputStream, i11);
        this.encOS = zstdOutputStream;
        zstdOutputStream.setCloseFrameOnFlush(z11);
        zstdOutputStream.setChecksum(z12);
    }

    public void close() throws IOException {
        this.encOS.close();
    }

    public void flush() throws IOException {
        this.encOS.flush();
    }

    public String toString() {
        return this.encOS.toString();
    }

    public void write(int i11) throws IOException {
        this.encOS.write(i11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.encOS.write(bArr, i11, i12);
    }

    public ZstdCompressorOutputStream(OutputStream outputStream, int i11, boolean z11) throws IOException {
        ZstdOutputStream zstdOutputStream = new ZstdOutputStream(outputStream, i11);
        this.encOS = zstdOutputStream;
        zstdOutputStream.setCloseFrameOnFlush(z11);
    }

    public ZstdCompressorOutputStream(OutputStream outputStream, int i11) throws IOException {
        this.encOS = new ZstdOutputStream(outputStream, i11);
    }

    public ZstdCompressorOutputStream(OutputStream outputStream) throws IOException {
        this.encOS = new ZstdOutputStream(outputStream);
    }
}
