package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "source", "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readOrInflate", "refill", "releaseBytesAfterInflate", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    @NotNull
    private final Inflater inflater;
    @NotNull
    private final BufferedSource source;

    public InflaterSource(@NotNull BufferedSource bufferedSource, @NotNull Inflater inflater2) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        Intrinsics.checkNotNullParameter(inflater2, "inflater");
        this.source = bufferedSource;
        this.inflater = inflater2;
    }

    private final void releaseBytesAfterInflate() {
        int i11 = this.bufferBytesHeldByInflater;
        if (i11 != 0) {
            int remaining = i11 - this.inflater.getRemaining();
            this.bufferBytesHeldByInflater -= remaining;
            this.source.skip((long) remaining);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.inflater.end();
            this.closed = true;
            this.source.close();
        }
    }

    public long read(@NotNull Buffer buffer, long j11) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        do {
            long readOrInflate = readOrInflate(buffer, j11);
            if (readOrInflate > 0) {
                return readOrInflate;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(@NotNull Buffer buffer, long j11) throws IOException {
        boolean z11;
        Intrinsics.checkNotNullParameter(buffer, "sink");
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
        } else if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (i11 == 0) {
            return 0;
        } else {
            try {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                refill();
                int inflate = this.inflater.inflate(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j11, (long) (8192 - writableSegment$okio.limit)));
                releaseBytesAfterInflate();
                if (inflate > 0) {
                    writableSegment$okio.limit += inflate;
                    long j12 = (long) inflate;
                    buffer.setSize$okio(buffer.size() + j12);
                    return j12;
                }
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                return 0;
            } catch (DataFormatException e11) {
                throw new IOException(e11);
            }
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        Intrinsics.checkNotNull(segment);
        int i11 = segment.limit;
        int i12 = segment.pos;
        int i13 = i11 - i12;
        this.bufferBytesHeldByInflater = i13;
        this.inflater.setInput(segment.data, i12, i13);
        return false;
    }

    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InflaterSource(@NotNull Source source2, @NotNull Inflater inflater2) {
        this(Okio.buffer(source2), inflater2);
        Intrinsics.checkNotNullParameter(source2, "source");
        Intrinsics.checkNotNullParameter(inflater2, "inflater");
    }
}
