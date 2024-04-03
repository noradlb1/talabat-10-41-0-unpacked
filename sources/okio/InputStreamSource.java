package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
class InputStreamSource implements Source {
    @NotNull
    private final InputStream input;
    @NotNull
    private final Timeout timeout;

    public InputStreamSource(@NotNull InputStream inputStream, @NotNull Timeout timeout2) {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        Intrinsics.checkNotNullParameter(timeout2, "timeout");
        this.input = inputStream;
        this.timeout = timeout2;
    }

    public void close() {
        this.input.close();
    }

    public long read(@NotNull Buffer buffer, long j11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(buffer, "sink");
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0) {
            return 0;
        }
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            try {
                this.timeout.throwIfReached();
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int read = this.input.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j11, (long) (8192 - writableSegment$okio.limit)));
                if (read != -1) {
                    writableSegment$okio.limit += read;
                    long j12 = (long) read;
                    buffer.setSize$okio(buffer.size() + j12);
                    return j12;
                } else if (writableSegment$okio.pos != writableSegment$okio.limit) {
                    return -1;
                } else {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                    return -1;
                }
            } catch (AssertionError e11) {
                if (Okio.isAndroidGetsocknameError(e11)) {
                    throw new IOException(e11);
                }
                throw e11;
            }
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
        }
    }

    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    @NotNull
    public String toString() {
        return "source(" + this.input + ')';
    }
}
