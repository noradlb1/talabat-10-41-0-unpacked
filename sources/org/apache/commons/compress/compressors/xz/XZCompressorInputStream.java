package org.apache.commons.compress.compressors.xz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

public class XZCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27724in;

    public XZCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public static boolean matches(byte[] bArr, int i11) {
        if (i11 < XZ.HEADER_MAGIC.length) {
            return false;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr2 = XZ.HEADER_MAGIC;
            if (i12 >= bArr2.length) {
                return true;
            }
            if (bArr[i12] != bArr2[i12]) {
                return false;
            }
            i12++;
        }
    }

    public int available() throws IOException {
        return this.f27724in.available();
    }

    public void close() throws IOException {
        this.f27724in.close();
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public int read() throws IOException {
        try {
            int read = this.f27724in.read();
            int i11 = -1;
            if (read != -1) {
                i11 = 1;
            }
            count(i11);
            return read;
        } catch (MemoryLimitException e11) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e11.getMemoryNeeded(), e11.getMemoryLimit(), e11);
        }
    }

    public long skip(long j11) throws IOException {
        try {
            return IOUtils.skip(this.f27724in, j11);
        } catch (MemoryLimitException e11) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e11.getMemoryNeeded(), e11.getMemoryLimit(), e11);
        }
    }

    public XZCompressorInputStream(InputStream inputStream, boolean z11) throws IOException {
        this(inputStream, z11, -1);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean z11, int i11) throws IOException {
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        if (z11) {
            this.f27724in = new XZInputStream((InputStream) countingInputStream, i11);
        } else {
            this.f27724in = new SingleXZInputStream((InputStream) countingInputStream, i11);
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        try {
            int read = this.f27724in.read(bArr, i11, i12);
            count(read);
            return read;
        } catch (MemoryLimitException e11) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e11.getMemoryNeeded(), e11.getMemoryLimit(), e11);
        }
    }
}
