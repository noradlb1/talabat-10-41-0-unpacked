package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\b¨\u0006*"}, d2 = {"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class _RealBufferedSinkKt {
    public static final void commonClose(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            try {
                if (realBufferedSink.bufferField.size() > 0) {
                    Sink sink = realBufferedSink.sink;
                    Buffer buffer = realBufferedSink.bufferField;
                    sink.write(buffer, buffer.size());
                }
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                realBufferedSink.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            realBufferedSink.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    @NotNull
    public static final BufferedSink commonEmit(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            long size = realBufferedSink.bufferField.size();
            if (size > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, size);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonEmitCompleteSegments(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            long completeSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, completeSegmentByteCount);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonFlush(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            if (realBufferedSink.bufferField.size() > 0) {
                Sink sink = realBufferedSink.sink;
                Buffer buffer = realBufferedSink.bufferField;
                sink.write(buffer, buffer.size());
            }
            realBufferedSink.sink.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        return realBufferedSink.sink.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final void commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull Buffer buffer, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(buffer, j11);
            realBufferedSink.emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonWriteAll(@NotNull RealBufferedSink realBufferedSink, @NotNull Source source) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        long j11 = 0;
        while (true) {
            long read = source.read(realBufferedSink.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j11;
            }
            j11 += read;
            realBufferedSink.emitCompleteSegments();
        }
    }

    @NotNull
    public static final BufferedSink commonWriteByte(@NotNull RealBufferedSink realBufferedSink, int i11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeByte(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteDecimalLong(@NotNull RealBufferedSink realBufferedSink, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeDecimalLong(j11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull RealBufferedSink realBufferedSink, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteInt(@NotNull RealBufferedSink realBufferedSink, int i11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeInt(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteIntLe(@NotNull RealBufferedSink realBufferedSink, int i11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeIntLe(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteLong(@NotNull RealBufferedSink realBufferedSink, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLong(j11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteLongLe(@NotNull RealBufferedSink realBufferedSink, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLongLe(j11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteShort(@NotNull RealBufferedSink realBufferedSink, int i11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShort(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteShortLe(@NotNull RealBufferedSink realBufferedSink, int i11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShortLe(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink realBufferedSink, @NotNull String str) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8CodePoint(@NotNull RealBufferedSink realBufferedSink, int i11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8CodePoint(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink realBufferedSink, @NotNull String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str, i11, i12);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull ByteString byteString, int i11, int i12) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i11, i12);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i11, i12);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull Source source, long j11) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j11 > 0) {
            long read = source.read(realBufferedSink.bufferField, j11);
            if (read != -1) {
                j11 -= read;
                realBufferedSink.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }
}
