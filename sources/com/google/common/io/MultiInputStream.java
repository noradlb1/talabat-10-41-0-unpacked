package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
final class MultiInputStream extends InputStream {
    @CheckForNull

    /* renamed from: in  reason: collision with root package name */
    private InputStream f44690in;
    private Iterator<? extends ByteSource> it;

    public MultiInputStream(Iterator<? extends ByteSource> it2) throws IOException {
        this.it = (Iterator) Preconditions.checkNotNull(it2);
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext()) {
            this.f44690in = ((ByteSource) this.it.next()).openStream();
        }
    }

    public int available() throws IOException {
        InputStream inputStream = this.f44690in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    public void close() throws IOException {
        InputStream inputStream = this.f44690in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f44690in = null;
            }
        }
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f44690in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    public long skip(long j11) throws IOException {
        InputStream inputStream = this.f44690in;
        if (inputStream == null || j11 <= 0) {
            return 0;
        }
        long skip = inputStream.skip(j11);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0;
        }
        return this.f44690in.skip(j11 - 1) + 1;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.f44690in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i11, i12);
            if (read != -1) {
                return read;
            }
            advance();
        }
    }
}
