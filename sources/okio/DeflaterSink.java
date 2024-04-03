package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0003J\r\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "deflater", "Ljava/util/zip/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "closed", "", "close", "", "deflate", "syncFlush", "finishDeflate", "finishDeflate$okio", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeflaterSink implements Sink {
    private boolean closed;
    @NotNull
    private final Deflater deflater;
    @NotNull
    private final BufferedSink sink;

    public DeflaterSink(@NotNull BufferedSink bufferedSink, @NotNull Deflater deflater2) {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        Intrinsics.checkNotNullParameter(deflater2, "deflater");
        this.sink = bufferedSink;
        this.deflater = deflater2;
    }

    @IgnoreJRERequirement
    private final void deflate(boolean z11) {
        Segment writableSegment$okio;
        int i11;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            if (z11) {
                Deflater deflater2 = this.deflater;
                byte[] bArr = writableSegment$okio.data;
                int i12 = writableSegment$okio.limit;
                i11 = deflater2.deflate(bArr, i12, 8192 - i12, 2);
            } else {
                Deflater deflater3 = this.deflater;
                byte[] bArr2 = writableSegment$okio.data;
                int i13 = writableSegment$okio.limit;
                i11 = deflater3.deflate(bArr2, i13, 8192 - i13);
            }
            if (i11 > 0) {
                writableSegment$okio.limit += i11;
                buffer.setSize$okio(buffer.size() + ((long) i11));
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                finishDeflate$okio();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.deflater.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    public void write(@NotNull Buffer buffer, long j11) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "source");
        _UtilKt.checkOffsetAndCount(buffer.size(), 0, j11);
        while (j11 > 0) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j12 = (long) min;
            buffer.setSize$okio(buffer.size() - j12);
            int i11 = segment.pos + min;
            segment.pos = i11;
            if (i11 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j11 -= j12;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeflaterSink(@NotNull Sink sink2, @NotNull Deflater deflater2) {
        this(Okio.buffer(sink2), deflater2);
        Intrinsics.checkNotNullParameter(sink2, "sink");
        Intrinsics.checkNotNullParameter(deflater2, "deflater");
    }
}
