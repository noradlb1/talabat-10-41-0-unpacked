package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lokio/CipherSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "blockSize", "", "buffer", "Lokio/Buffer;", "getCipher", "()Ljavax/crypto/Cipher;", "closed", "", "final", "close", "", "doFinal", "read", "", "sink", "byteCount", "refill", "timeout", "Lokio/Timeout;", "update", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CipherSource implements Source {
    private final int blockSize;
    @NotNull
    private final Buffer buffer = new Buffer();
    @NotNull
    private final Cipher cipher;
    private boolean closed;

    /* renamed from: final  reason: not valid java name */
    private boolean f432final;
    @NotNull
    private final BufferedSource source;

    public CipherSource(@NotNull BufferedSource bufferedSource, @NotNull Cipher cipher2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        Intrinsics.checkNotNullParameter(cipher2, "cipher");
        this.source = bufferedSource;
        this.cipher = cipher2;
        int blockSize2 = cipher2.getBlockSize();
        this.blockSize = blockSize2;
        if (blockSize2 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Block cipher required ", getCipher()).toString());
        }
    }

    private final void doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize != 0) {
            Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
            int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.pos);
            writableSegment$okio.limit += doFinal;
            Buffer buffer2 = this.buffer;
            buffer2.setSize$okio(buffer2.size() + ((long) doFinal));
            if (writableSegment$okio.pos == writableSegment$okio.limit) {
                this.buffer.head = writableSegment$okio.pop();
                SegmentPool.recycle(writableSegment$okio);
            }
        }
    }

    private final void refill() {
        while (this.buffer.size() == 0) {
            if (this.source.exhausted()) {
                this.f432final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() {
        boolean z11;
        Segment segment = this.source.getBuffer().head;
        Intrinsics.checkNotNull(segment);
        int i11 = segment.limit - segment.pos;
        int outputSize = this.cipher.getOutputSize(i11);
        while (outputSize > 8192) {
            int i12 = this.blockSize;
            if (i11 > i12) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i11 -= i12;
                outputSize = this.cipher.getOutputSize(i11);
            } else {
                throw new IllegalStateException(("Unexpected output size " + outputSize + " for input size " + i11).toString());
            }
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int update = this.cipher.update(segment.data, segment.pos, i11, writableSegment$okio.data, writableSegment$okio.pos);
        this.source.skip((long) i11);
        writableSegment$okio.limit += update;
        Buffer buffer2 = this.buffer;
        buffer2.setSize$okio(buffer2.size() + ((long) update));
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
    }

    public long read(@NotNull Buffer buffer2, long j11) throws IOException {
        boolean z11;
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
        } else if (!(true ^ this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (i11 == 0) {
            return 0;
        } else {
            if (this.f432final) {
                return this.buffer.read(buffer2, j11);
            }
            refill();
            return this.buffer.read(buffer2, j11);
        }
    }

    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }
}
