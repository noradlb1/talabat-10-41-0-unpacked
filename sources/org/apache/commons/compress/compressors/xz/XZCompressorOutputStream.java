package org.apache.commons.compress.compressors.xz;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZOutputStream;

public class XZCompressorOutputStream extends CompressorOutputStream {
    private final XZOutputStream out;

    public XZCompressorOutputStream(OutputStream outputStream) throws IOException {
        this.out = new XZOutputStream(outputStream, (FilterOptions) new LZMA2Options());
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void finish() throws IOException {
        this.out.finish();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(int i11) throws IOException {
        this.out.write(i11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.out.write(bArr, i11, i12);
    }

    public XZCompressorOutputStream(OutputStream outputStream, int i11) throws IOException {
        this.out = new XZOutputStream(outputStream, (FilterOptions) new LZMA2Options(i11));
    }
}
