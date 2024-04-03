package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

class InflaterInputStreamWithStatistics extends InflaterInputStream implements InputStreamStatistics {
    private long compressedCount;
    private long uncompressedCount;

    public InflaterInputStreamWithStatistics(InputStream inputStream) {
        super(inputStream);
    }

    public void fill() throws IOException {
        super.fill();
        this.compressedCount += (long) this.inf.getRemaining();
    }

    public long getCompressedCount() {
        return this.compressedCount;
    }

    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read > -1) {
            this.uncompressedCount++;
        }
        return read;
    }

    public InflaterInputStreamWithStatistics(InputStream inputStream, Inflater inflater) {
        super(inputStream, inflater);
    }

    public InflaterInputStreamWithStatistics(InputStream inputStream, Inflater inflater, int i11) {
        super(inputStream, inflater, i11);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = super.read(bArr, i11, i12);
        if (read > -1) {
            this.uncompressedCount += (long) read;
        }
        return read;
    }
}
