package org.apache.commons.compress.compressors.brotli;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.brotli.dec.BrotliInputStream;

public class BrotliCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final BrotliInputStream decIS;

    public BrotliCompressorInputStream(InputStream inputStream) throws IOException {
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        this.decIS = new BrotliInputStream(countingInputStream);
    }

    public int available() throws IOException {
        return this.decIS.available();
    }

    public void close() throws IOException {
        this.decIS.close();
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public synchronized void mark(int i11) {
        this.decIS.mark(i11);
    }

    public boolean markSupported() {
        return this.decIS.markSupported();
    }

    public int read(byte[] bArr) throws IOException {
        return this.decIS.read(bArr);
    }

    public synchronized void reset() throws IOException {
        this.decIS.reset();
    }

    public long skip(long j11) throws IOException {
        return IOUtils.skip(this.decIS, j11);
    }

    public String toString() {
        return this.decIS.toString();
    }

    public int read() throws IOException {
        int read = this.decIS.read();
        count(read == -1 ? 0 : 1);
        return read;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = this.decIS.read(bArr, i11, i12);
        count(read);
        return read;
    }
}
