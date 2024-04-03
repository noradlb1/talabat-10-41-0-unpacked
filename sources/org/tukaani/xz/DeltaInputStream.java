package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.delta.DeltaDecoder;

public class DeltaInputStream extends InputStream {
    public static final int DISTANCE_MAX = 256;
    public static final int DISTANCE_MIN = 1;
    private final DeltaDecoder delta;
    private IOException exception = null;

    /* renamed from: in  reason: collision with root package name */
    private InputStream f63398in;
    private final byte[] tempBuf = new byte[1];

    public DeltaInputStream(InputStream inputStream, int i11) {
        inputStream.getClass();
        this.f63398in = inputStream;
        this.delta = new DeltaDecoder(i11);
    }

    public int available() throws IOException {
        InputStream inputStream = this.f63398in;
        if (inputStream != null) {
            IOException iOException = this.exception;
            if (iOException == null) {
                return inputStream.available();
            }
            throw iOException;
        }
        throw new XZIOException("Stream closed");
    }

    public void close() throws IOException {
        InputStream inputStream = this.f63398in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f63398in = null;
            }
        }
    }

    public int read() throws IOException {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        InputStream inputStream = this.f63398in;
        if (inputStream != null) {
            IOException iOException = this.exception;
            if (iOException == null) {
                try {
                    int read = inputStream.read(bArr, i11, i12);
                    if (read == -1) {
                        return -1;
                    }
                    this.delta.decode(bArr, i11, read);
                    return read;
                } catch (IOException e11) {
                    this.exception = e11;
                    throw e11;
                }
            } else {
                throw iOException;
            }
        } else {
            throw new XZIOException("Stream closed");
        }
    }
}
