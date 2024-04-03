package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class MarkableInputStream extends InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_LIMIT_INCREMENT = 1024;
    private boolean allowExpire;
    private long defaultMark;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f53422in;
    private long limit;
    private int limitIncrement;
    private long offset;
    private long reset;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void setLimit(long j11) {
        try {
            long j12 = this.reset;
            long j13 = this.offset;
            if (j12 >= j13 || j13 > this.limit) {
                this.reset = j13;
                this.f53422in.mark((int) (j11 - j13));
            } else {
                this.f53422in.reset();
                this.f53422in.mark((int) (j11 - this.reset));
                skip(this.reset, this.offset);
            }
            this.limit = j11;
        } catch (IOException e11) {
            throw new IllegalStateException("Unable to mark: " + e11);
        }
    }

    private void skip(long j11, long j12) throws IOException {
        while (j11 < j12) {
            long skip = this.f53422in.skip(j12 - j11);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j11 += skip;
        }
    }

    public void allowMarksToExpire(boolean z11) {
        this.allowExpire = z11;
    }

    public int available() throws IOException {
        return this.f53422in.available();
    }

    public void close() throws IOException {
        this.f53422in.close();
    }

    public void mark(int i11) {
        this.defaultMark = savePosition(i11);
    }

    public boolean markSupported() {
        return this.f53422in.markSupported();
    }

    public int read() throws IOException {
        if (!this.allowExpire) {
            long j11 = this.limit;
            if (this.offset + 1 > j11) {
                setLimit(j11 + ((long) this.limitIncrement));
            }
        }
        int read = this.f53422in.read();
        if (read != -1) {
            this.offset++;
        }
        return read;
    }

    public void reset() throws IOException {
        reset(this.defaultMark);
    }

    public long savePosition(int i11) {
        long j11 = this.offset + ((long) i11);
        if (this.limit < j11) {
            setLimit(j11);
        }
        return this.offset;
    }

    public MarkableInputStream(InputStream inputStream, int i11) {
        this(inputStream, i11, 1024);
    }

    public void reset(long j11) throws IOException {
        if (this.offset > this.limit || j11 < this.reset) {
            throw new IOException("Cannot reset");
        }
        this.f53422in.reset();
        skip(this.reset, j11);
        this.offset = j11;
    }

    private MarkableInputStream(InputStream inputStream, int i11, int i12) {
        this.defaultMark = -1;
        this.allowExpire = true;
        this.limitIncrement = -1;
        this.f53422in = !inputStream.markSupported() ? new BufferedInputStream(inputStream, i11) : inputStream;
        this.limitIncrement = i12;
    }

    public long skip(long j11) throws IOException {
        if (!this.allowExpire) {
            long j12 = this.offset;
            if (j12 + j11 > this.limit) {
                setLimit(j12 + j11 + ((long) this.limitIncrement));
            }
        }
        long skip = this.f53422in.skip(j11);
        this.offset += skip;
        return skip;
    }

    public int read(byte[] bArr) throws IOException {
        if (!this.allowExpire) {
            long j11 = this.offset;
            if (((long) bArr.length) + j11 > this.limit) {
                setLimit(j11 + ((long) bArr.length) + ((long) this.limitIncrement));
            }
        }
        int read = this.f53422in.read(bArr);
        if (read != -1) {
            this.offset += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (!this.allowExpire) {
            long j11 = this.offset;
            long j12 = (long) i12;
            if (j11 + j12 > this.limit) {
                setLimit(j11 + j12 + ((long) this.limitIncrement));
            }
        }
        int read = this.f53422in.read(bArr, i11, i12);
        if (read != -1) {
            this.offset += (long) read;
        }
        return read;
    }
}
