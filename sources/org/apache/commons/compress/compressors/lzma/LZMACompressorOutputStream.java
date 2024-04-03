package org.apache.commons.compress.compressors.lzma;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.LZMAOutputStream;

public class LZMACompressorOutputStream extends CompressorOutputStream {
    private final LZMAOutputStream out;

    public LZMACompressorOutputStream(OutputStream outputStream) throws IOException {
        this.out = new LZMAOutputStream(outputStream, new LZMA2Options(), -1);
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void finish() throws IOException {
        this.out.finish();
    }

    public void flush() throws IOException {
    }

    public void write(int i11) throws IOException {
        this.out.write(i11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.out.write(bArr, i11, i12);
    }
}
