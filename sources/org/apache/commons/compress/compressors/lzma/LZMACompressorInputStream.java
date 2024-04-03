package org.apache.commons.compress.compressors.lzma;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.MemoryLimitException;

public class LZMACompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27717in;

    public LZMACompressorInputStream(InputStream inputStream) throws IOException {
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        this.f27717in = new LZMAInputStream((InputStream) countingInputStream, -1);
    }

    public static boolean matches(byte[] bArr, int i11) {
        return bArr != null && i11 >= 3 && bArr[0] == 93 && bArr[1] == 0 && bArr[2] == 0;
    }

    public int available() throws IOException {
        return this.f27717in.available();
    }

    public void close() throws IOException {
        this.f27717in.close();
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public int read() throws IOException {
        int read = this.f27717in.read();
        count(read == -1 ? 0 : 1);
        return read;
    }

    public long skip(long j11) throws IOException {
        return IOUtils.skip(this.f27717in, j11);
    }

    public LZMACompressorInputStream(InputStream inputStream, int i11) throws IOException {
        try {
            CountingInputStream countingInputStream = new CountingInputStream(inputStream);
            this.countingStream = countingInputStream;
            this.f27717in = new LZMAInputStream((InputStream) countingInputStream, i11);
        } catch (MemoryLimitException e11) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e11.getMemoryNeeded(), e11.getMemoryLimit(), e11);
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = this.f27717in.read(bArr, i11, i12);
        count(read);
        return read;
    }
}
