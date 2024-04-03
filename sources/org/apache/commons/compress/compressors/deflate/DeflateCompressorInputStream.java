package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class DeflateCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private static final int MAGIC_1 = 120;
    private static final int MAGIC_2a = 1;
    private static final int MAGIC_2b = 94;
    private static final int MAGIC_2c = 156;
    private static final int MAGIC_2d = 218;
    private final CountingInputStream countingStream;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f27705in;
    private final Inflater inflater;

    public DeflateCompressorInputStream(InputStream inputStream) {
        this(inputStream, new DeflateParameters());
    }

    public static boolean matches(byte[] bArr, int i11) {
        if (i11 <= 3 || bArr[0] != 120) {
            return false;
        }
        byte b11 = bArr[1];
        return b11 == 1 || b11 == 94 || b11 == -100 || b11 == -38;
    }

    public int available() throws IOException {
        return this.f27705in.available();
    }

    public void close() throws IOException {
        try {
            this.f27705in.close();
        } finally {
            this.inflater.end();
        }
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public int read() throws IOException {
        int read = this.f27705in.read();
        count(read == -1 ? 0 : 1);
        return read;
    }

    public long skip(long j11) throws IOException {
        return IOUtils.skip(this.f27705in, j11);
    }

    public DeflateCompressorInputStream(InputStream inputStream, DeflateParameters deflateParameters) {
        Inflater inflater2 = new Inflater(!deflateParameters.withZlibHeader());
        this.inflater = inflater2;
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        this.f27705in = new InflaterInputStream(countingInputStream, inflater2);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        int read = this.f27705in.read(bArr, i11, i12);
        count(read);
        return read;
    }
}
