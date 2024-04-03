package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.simple.SimpleFilter;

class SimpleInputStream extends InputStream {
    private static final int FILTER_BUF_SIZE = 4096;
    private boolean endReached = false;
    private IOException exception = null;
    private final byte[] filterBuf = new byte[4096];
    private int filtered = 0;

    /* renamed from: in  reason: collision with root package name */
    private InputStream f63416in;
    private int pos = 0;
    private final SimpleFilter simpleFilter;
    private final byte[] tempBuf = new byte[1];
    private int unfiltered = 0;

    public SimpleInputStream(InputStream inputStream, SimpleFilter simpleFilter2) {
        inputStream.getClass();
        this.f63416in = inputStream;
        this.simpleFilter = simpleFilter2;
    }

    public static int a() {
        return 5;
    }

    public int available() throws IOException {
        if (this.f63416in != null) {
            IOException iOException = this.exception;
            if (iOException == null) {
                return this.filtered;
            }
            throw iOException;
        }
        throw new XZIOException("Stream closed");
    }

    public void close() throws IOException {
        InputStream inputStream = this.f63416in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f63416in = null;
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
        int i13;
        if (i11 < 0 || i12 < 0 || (i13 = i11 + i12) < 0 || i13 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i12 == 0) {
            return 0;
        } else {
            if (this.f63416in != null) {
                IOException iOException = this.exception;
                if (iOException == null) {
                    int i14 = 0;
                    while (true) {
                        try {
                            int min = Math.min(this.filtered, i12);
                            System.arraycopy(this.filterBuf, this.pos, bArr, i11, min);
                            int i15 = this.pos + min;
                            this.pos = i15;
                            int i16 = this.filtered - min;
                            this.filtered = i16;
                            i11 += min;
                            i12 -= min;
                            i14 += min;
                            int i17 = this.unfiltered;
                            if (i15 + i16 + i17 == 4096) {
                                byte[] bArr2 = this.filterBuf;
                                System.arraycopy(bArr2, i15, bArr2, 0, i16 + i17);
                                this.pos = 0;
                            }
                            if (i12 == 0) {
                                break;
                            } else if (this.endReached) {
                                break;
                            } else {
                                int i18 = this.pos;
                                int i19 = this.filtered;
                                int i21 = this.unfiltered;
                                int read = this.f63416in.read(this.filterBuf, i18 + i19 + i21, 4096 - ((i18 + i19) + i21));
                                if (read == -1) {
                                    this.endReached = true;
                                    this.filtered = this.unfiltered;
                                    this.unfiltered = 0;
                                } else {
                                    int i22 = this.unfiltered + read;
                                    this.unfiltered = i22;
                                    int code = this.simpleFilter.code(this.filterBuf, this.pos, i22);
                                    this.filtered = code;
                                    this.unfiltered -= code;
                                }
                            }
                        } catch (IOException e11) {
                            this.exception = e11;
                            throw e11;
                        }
                    }
                    if (i14 > 0) {
                        return i14;
                    }
                    return -1;
                }
                throw iOException;
            }
            throw new XZIOException("Stream closed");
        }
    }
}
