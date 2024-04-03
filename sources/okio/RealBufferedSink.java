package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001eH\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020$2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0018\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u000206H\u0016J(\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0019H\u0016J \u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001bH\u0016J\u0010\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "sink", "Lokio/Sink;", "(Lokio/Sink;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "emit", "emitCompleteSegments", "flush", "isOpen", "outputStream", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "toString", "", "write", "", "source", "Ljava/nio/ByteBuffer;", "", "offset", "byteCount", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealBufferedSink implements BufferedSink {
    @NotNull
    @JvmField
    public final Buffer bufferField = new Buffer();
    @JvmField
    public boolean closed;
    @NotNull
    @JvmField
    public final Sink sink;

    public RealBufferedSink(@NotNull Sink sink2) {
        Intrinsics.checkNotNullParameter(sink2, "sink");
        this.sink = sink2;
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if (!this.closed) {
            try {
                if (this.bufferField.size() > 0) {
                    Sink sink2 = this.sink;
                    Buffer buffer = this.bufferField;
                    sink2.write(buffer, buffer.size());
                }
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    @NotNull
    public BufferedSink emit() {
        if (!this.closed) {
            long size = this.bufferField.size();
            if (size > 0) {
                this.sink.write(this.bufferField, size);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink emitCompleteSegments() {
        if (!this.closed) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.sink.write(this.bufferField, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    public void flush() {
        if (!this.closed) {
            if (this.bufferField.size() > 0) {
                Sink sink2 = this.sink;
                Buffer buffer = this.bufferField;
                sink2.write(buffer, buffer.size());
            }
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    public boolean isOpen() {
        return !this.closed;
    }

    @NotNull
    public OutputStream outputStream() {
        return new RealBufferedSink$outputStream$1(this);
    }

    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    public int write(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        if (!this.closed) {
            int write = this.bufferField.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long writeAll(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j11 = 0;
        while (true) {
            long read = source.read(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j11;
            }
            j11 += read;
            emitCompleteSegments();
        }
    }

    @NotNull
    public BufferedSink writeByte(int i11) {
        if (!this.closed) {
            this.bufferField.writeByte(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeDecimalLong(long j11) {
        if (!this.closed) {
            this.bufferField.writeDecimalLong(j11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeHexadecimalUnsignedLong(long j11) {
        if (!this.closed) {
            this.bufferField.writeHexadecimalUnsignedLong(j11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeInt(int i11) {
        if (!this.closed) {
            this.bufferField.writeInt(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeIntLe(int i11) {
        if (!this.closed) {
            this.bufferField.writeIntLe(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeLong(long j11) {
        if (!this.closed) {
            this.bufferField.writeLong(j11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeLongLe(long j11) {
        if (!this.closed) {
            this.bufferField.writeLongLe(j11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeShort(int i11) {
        if (!this.closed) {
            this.bufferField.writeShort(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeShortLe(int i11) {
        if (!this.closed) {
            this.bufferField.writeShortLe(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeString(@NotNull String str, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (!this.closed) {
            this.bufferField.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeUtf8CodePoint(int i11) {
        if (!this.closed) {
            this.bufferField.writeUtf8CodePoint(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    public void write(@NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (!this.closed) {
            this.bufferField.write(buffer, j11);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeString(@NotNull String str, int i11, int i12, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(str, i11, i12, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeUtf8(@NotNull String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (!this.closed) {
            this.bufferField.writeUtf8(str, i11, i12);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink write(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink write(@NotNull ByteString byteString, int i11, int i12) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, i11, i12);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink write(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink write(@NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        if (!this.closed) {
            this.bufferField.write(bArr, i11, i12);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink write(@NotNull Source source, long j11) {
        Intrinsics.checkNotNullParameter(source, "source");
        while (j11 > 0) {
            long read = source.read(this.bufferField, j11);
            if (read != -1) {
                j11 -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
