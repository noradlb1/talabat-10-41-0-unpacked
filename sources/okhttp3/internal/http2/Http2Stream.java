package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0004_`abB1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020#J\r\u0010C\u001a\u00020AH\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020AH\u0000¢\u0006\u0002\bFJ\u0018\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010I\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010J\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020\nJ\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020PJ\u0006\u0010,\u001a\u00020QJ\u0016\u0010R\u001a\u00020A2\u0006\u00104\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010U\u001a\u00020A2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010W\u001a\u00020\nJ\u0006\u0010L\u001a\u00020\nJ\r\u0010X\u001a\u00020AH\u0000¢\u0006\u0002\bYJ$\u0010Z\u001a\u00020A2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020QR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0018\u0010,\u001a\u00060-R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u000601R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u000605R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R$\u00108\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R$\u0010;\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u0018\u0010>\u001a\u00060-R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/¨\u0006c"}, d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", "id", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "outFinished", "", "inFinished", "headers", "Lokhttp3/Headers;", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "errorException", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "hasResponseHeaders", "headersQueue", "Ljava/util/ArrayDeque;", "getId", "()I", "isLocallyInitiated", "()Z", "isOpen", "<set-?>", "", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "setReadBytesAcknowledged$okhttp", "(J)V", "readBytesTotal", "getReadBytesTotal", "setReadBytesTotal$okhttp", "readTimeout", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "source", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeTimeout", "getWriteTimeout$okhttp", "addBytesToWriteWindow", "", "delta", "cancelStreamIfNecessary", "cancelStreamIfNecessary$okhttp", "checkOutNotClosed", "checkOutNotClosed$okhttp", "close", "rstStatusCode", "closeInternal", "closeLater", "enqueueTrailers", "trailers", "getSink", "Lokio/Sink;", "getSource", "Lokio/Source;", "Lokio/Timeout;", "receiveData", "Lokio/BufferedSource;", "length", "receiveHeaders", "receiveRstStream", "takeHeaders", "waitForIo", "waitForIo$okhttp", "writeHeaders", "responseHeaders", "", "Lokhttp3/internal/http2/Header;", "flushHeaders", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Http2Stream {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    @NotNull
    private final Http2Connection connection;
    @Nullable
    private ErrorCode errorCode;
    @Nullable
    private IOException errorException;
    private boolean hasResponseHeaders;
    @NotNull
    private final ArrayDeque<Headers> headersQueue;

    /* renamed from: id  reason: collision with root package name */
    private final int f27530id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    @NotNull
    private final StreamTimeout readTimeout = new StreamTimeout(this);
    @NotNull
    private final FramingSink sink;
    @NotNull
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    @NotNull
    private final StreamTimeout writeTimeout = new StreamTimeout(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "()V", "EMIT_BUFFER_SIZE", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u001d\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", "maxByteCount", "", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getFinished$okhttp", "setFinished$okhttp", "readBuffer", "Lokio/Buffer;", "getReadBuffer", "()Lokio/Buffer;", "receiveBuffer", "getReceiveBuffer", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "read", "sink", "byteCount", "receive", "source", "Lokio/BufferedSource;", "receive$okhttp", "timeout", "Lokio/Timeout;", "updateConnectionFlowControl", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        @NotNull
        private final Buffer readBuffer = new Buffer();
        @NotNull
        private final Buffer receiveBuffer = new Buffer();
        final /* synthetic */ Http2Stream this$0;
        @Nullable
        private Headers trailers;

        public FramingSource(Http2Stream http2Stream, long j11, boolean z11) {
            Intrinsics.checkNotNullParameter(http2Stream, "this$0");
            this.this$0 = http2Stream;
            this.maxByteCount = j11;
            this.finished = z11;
        }

        private final void updateConnectionFlowControl(long j11) {
            Http2Stream http2Stream = this.this$0;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.this$0.getConnection().updateConnectionFlowControl$okhttp(j11);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        public void close() throws IOException {
            long size;
            Http2Stream http2Stream = this.this$0;
            synchronized (http2Stream) {
                setClosed$okhttp(true);
                size = getReadBuffer().size();
                getReadBuffer().clear();
                http2Stream.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            this.this$0.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        @NotNull
        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        @NotNull
        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        /* JADX INFO: finally extract failed */
        public long read(@NotNull Buffer buffer, long j11) throws IOException {
            boolean z11;
            Throwable th2;
            long j12;
            boolean z12;
            Buffer buffer2 = buffer;
            long j13 = j11;
            Intrinsics.checkNotNullParameter(buffer2, "sink");
            long j14 = 0;
            if (j13 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                while (true) {
                    Http2Stream http2Stream = this.this$0;
                    synchronized (http2Stream) {
                        http2Stream.getReadTimeout$okhttp().enter();
                        try {
                            if (http2Stream.getErrorCode$okhttp() != null) {
                                th2 = http2Stream.getErrorException$okhttp();
                                if (th2 == null) {
                                    ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                                    Intrinsics.checkNotNull(errorCode$okhttp);
                                    th2 = new StreamResetException(errorCode$okhttp);
                                }
                            } else {
                                th2 = null;
                            }
                            if (!getClosed$okhttp()) {
                                if (getReadBuffer().size() > j14) {
                                    j12 = getReadBuffer().read(buffer2, Math.min(j13, getReadBuffer().size()));
                                    http2Stream.setReadBytesTotal$okhttp(http2Stream.getReadBytesTotal() + j12);
                                    long readBytesTotal = http2Stream.getReadBytesTotal() - http2Stream.getReadBytesAcknowledged();
                                    if (th2 == null && readBytesTotal >= ((long) (http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2))) {
                                        http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), readBytesTotal);
                                        http2Stream.setReadBytesAcknowledged$okhttp(http2Stream.getReadBytesTotal());
                                    }
                                } else if (getFinished$okhttp() || th2 != null) {
                                    j12 = -1;
                                } else {
                                    http2Stream.waitForIo$okhttp();
                                    j12 = -1;
                                    z12 = true;
                                    http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                                    Unit unit = Unit.INSTANCE;
                                }
                                z12 = false;
                                http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (Throwable th3) {
                            http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                            throw th3;
                        }
                    }
                    if (z12) {
                        j14 = 0;
                    } else if (j12 != -1) {
                        updateConnectionFlowControl(j12);
                        return j12;
                    } else if (th2 == null) {
                        return -1;
                    } else {
                        throw th2;
                    }
                }
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j11)).toString());
            }
        }

        public final void receive$okhttp(@NotNull BufferedSource bufferedSource, long j11) throws IOException {
            boolean finished$okhttp;
            boolean z11;
            boolean z12;
            long j12;
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            Http2Stream http2Stream = this.this$0;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                while (j11 > 0) {
                    synchronized (this.this$0) {
                        finished$okhttp = getFinished$okhttp();
                        z11 = true;
                        if (getReadBuffer().size() + j11 > this.maxByteCount) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    if (z12) {
                        bufferedSource.skip(j11);
                        this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (finished$okhttp) {
                        bufferedSource.skip(j11);
                        return;
                    } else {
                        long read = bufferedSource.read(this.receiveBuffer, j11);
                        if (read != -1) {
                            j11 -= read;
                            Http2Stream http2Stream2 = this.this$0;
                            synchronized (http2Stream2) {
                                if (getClosed$okhttp()) {
                                    j12 = getReceiveBuffer().size();
                                    getReceiveBuffer().clear();
                                } else {
                                    if (getReadBuffer().size() != 0) {
                                        z11 = false;
                                    }
                                    getReadBuffer().writeAll(getReceiveBuffer());
                                    if (z11) {
                                        http2Stream2.notifyAll();
                                    }
                                    j12 = 0;
                                }
                            }
                            if (j12 > 0) {
                                updateConnectionFlowControl(j12);
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        public final void setClosed$okhttp(boolean z11) {
            this.closed = z11;
        }

        public final void setFinished$okhttp(boolean z11) {
            this.finished = z11;
        }

        public final void setTrailers(@Nullable Headers headers) {
            this.trailers = headers;
        }

        @NotNull
        public Timeout timeout() {
            return this.this$0.getReadTimeout$okhttp();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\t"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "(Lokhttp3/internal/http2/Http2Stream;)V", "exitAndThrowIfTimedOut", "", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class StreamTimeout extends AsyncTimeout {
        final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream http2Stream) {
            Intrinsics.checkNotNullParameter(http2Stream, "this$0");
            this.this$0 = http2Stream;
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }

        @NotNull
        public IOException newTimeoutException(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
            this.this$0.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i11, @NotNull Http2Connection http2Connection, boolean z11, boolean z12, @Nullable Headers headers) {
        Intrinsics.checkNotNullParameter(http2Connection, "connection");
        this.f27530id = i11;
        this.connection = http2Connection;
        this.writeBytesMaximum = (long) http2Connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(this, (long) http2Connection.getOkHttpSettings().getInitialWindowSize(), z12);
        this.sink = new FramingSink(this, z11);
        if (headers != null) {
            if (!isLocallyInitiated()) {
                arrayDeque.add(headers);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (!isLocallyInitiated()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    private final boolean closeInternal(ErrorCode errorCode2, IOException iOException) {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (getErrorCode$okhttp() != null) {
                    return false;
                }
                if (getSource$okhttp().getFinished$okhttp() && getSink$okhttp().getFinished()) {
                    return false;
                }
                setErrorCode$okhttp(errorCode2);
                setErrorException$okhttp(iOException);
                notifyAll();
                Unit unit = Unit.INSTANCE;
                this.connection.removeStream$okhttp(this.f27530id);
                return true;
            }
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void addBytesToWriteWindow(long j11) {
        this.writeBytesMaximum += j11;
        if (j11 > 0) {
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z11;
        boolean isOpen;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (getSource$okhttp().getFinished$okhttp() || !getSource$okhttp().getClosed$okhttp() || (!getSink$okhttp().getFinished() && !getSink$okhttp().getClosed())) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                isOpen = isOpen();
                Unit unit = Unit.INSTANCE;
            }
            if (z11) {
                close(ErrorCode.CANCEL, (IOException) null);
            } else if (!isOpen) {
                this.connection.removeStream$okhttp(this.f27530id);
            }
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (this.sink.getClosed()) {
            throw new IOException("stream closed");
        } else if (this.sink.getFinished()) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            Throwable th2 = this.errorException;
            if (th2 == null) {
                ErrorCode errorCode2 = this.errorCode;
                Intrinsics.checkNotNull(errorCode2);
                th2 = new StreamResetException(errorCode2);
            }
            throw th2;
        }
    }

    public final void close(@NotNull ErrorCode errorCode2, @Nullable IOException iOException) throws IOException {
        Intrinsics.checkNotNullParameter(errorCode2, "rstStatusCode");
        if (closeInternal(errorCode2, iOException)) {
            this.connection.writeSynReset$okhttp(this.f27530id, errorCode2);
        }
    }

    public final void closeLater(@NotNull ErrorCode errorCode2) {
        Intrinsics.checkNotNullParameter(errorCode2, "errorCode");
        if (closeInternal(errorCode2, (IOException) null)) {
            this.connection.writeSynResetLater$okhttp(this.f27530id, errorCode2);
        }
    }

    public final void enqueueTrailers(@NotNull Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "trailers");
        synchronized (this) {
            boolean z11 = true;
            if (!getSink$okhttp().getFinished()) {
                if (headers.size() == 0) {
                    z11 = false;
                }
                if (z11) {
                    getSink$okhttp().setTrailers(headers);
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalArgumentException("trailers.size() == 0".toString());
                }
            } else {
                throw new IllegalStateException("already finished".toString());
            }
        }
    }

    @NotNull
    public final Http2Connection getConnection() {
        return this.connection;
    }

    @Nullable
    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    @Nullable
    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.f27530id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @NotNull
    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0017  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okio.Sink getSink() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x000e
            boolean r0 = r2.isLocallyInitiated()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r0 = 0
            goto L_0x000f
        L_0x000e:
            r0 = 1
        L_0x000f:
            if (r0 == 0) goto L_0x0017
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink
            return r0
        L_0x0017:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0023 }
            r1.<init>(r0)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.getSink():okio.Sink");
    }

    @NotNull
    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    @NotNull
    public final Source getSource() {
        return this.source;
    }

    @NotNull
    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        boolean z11;
        if ((this.f27530id & 1) == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.connection.getClient$okhttp() == z11) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean isOpen() {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.ErrorCode r0 = r2.errorCode     // Catch:{ all -> 0x0031 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r2)
            return r1
        L_0x0008:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.getFinished$okhttp()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0018
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.getClosed$okhttp()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002e
        L_0x0018:
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.getFinished()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0028
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.getClosed()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002e
        L_0x0028:
            boolean r0 = r2.hasResponseHeaders     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r2)
            return r1
        L_0x002e:
            monitor-exit(r2)
            r0 = 1
            return r0
        L_0x0031:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.isOpen():boolean");
    }

    @NotNull
    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(@NotNull BufferedSource bufferedSource, int i11) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            this.source.receive$okhttp(bufferedSource, (long) i11);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void receiveHeaders(@org.jetbrains.annotations.NotNull okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L_0x0037
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L_0x0010
            goto L_0x0037
        L_0x0010:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0037:
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch:{ all -> 0x006c }
            r1 = 1
            if (r0 == 0) goto L_0x0048
            if (r4 != 0) goto L_0x0040
            goto L_0x0048
        L_0x0040:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.getSource$okhttp()     // Catch:{ all -> 0x006c }
            r0.setTrailers(r3)     // Catch:{ all -> 0x006c }
            goto L_0x004f
        L_0x0048:
            r2.hasResponseHeaders = r1     // Catch:{ all -> 0x006c }
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x006c }
            r0.add(r3)     // Catch:{ all -> 0x006c }
        L_0x004f:
            if (r4 == 0) goto L_0x0058
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.getSource$okhttp()     // Catch:{ all -> 0x006c }
            r3.setFinished$okhttp(r1)     // Catch:{ all -> 0x006c }
        L_0x0058:
            boolean r3 = r2.isOpen()     // Catch:{ all -> 0x006c }
            r2.notifyAll()     // Catch:{ all -> 0x006c }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006c }
            monitor-exit(r2)
            if (r3 != 0) goto L_0x006b
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.f27530id
            r3.removeStream$okhttp(r4)
        L_0x006b:
            return
        L_0x006c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public final synchronized void receiveRstStream(@NotNull ErrorCode errorCode2) {
        Intrinsics.checkNotNullParameter(errorCode2, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    public final void setErrorCode$okhttp(@Nullable ErrorCode errorCode2) {
        this.errorCode = errorCode2;
    }

    public final void setErrorException$okhttp(@Nullable IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long j11) {
        this.readBytesAcknowledged = j11;
    }

    public final void setReadBytesTotal$okhttp(long j11) {
        this.readBytesTotal = j11;
    }

    public final void setWriteBytesMaximum$okhttp(long j11) {
        this.writeBytesMaximum = j11;
    }

    public final void setWriteBytesTotal$okhttp(long j11) {
        this.writeBytesTotal = j11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r2.readTimeout.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.Headers takeHeaders() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch:{ all -> 0x004a }
            r0.enter()     // Catch:{ all -> 0x004a }
        L_0x0006:
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0016
            okhttp3.internal.http2.ErrorCode r0 = r2.errorCode     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x0016
            r2.waitForIo$okhttp()     // Catch:{ all -> 0x0043 }
            goto L_0x0006
        L_0x0016:
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch:{ all -> 0x004a }
            r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x004a }
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x004a }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004a }
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0034
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x004a }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x004a }
            java.lang.String r1 = "headersQueue.removeFirst()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x004a }
            okhttp3.Headers r0 = (okhttp3.Headers) r0     // Catch:{ all -> 0x004a }
            monitor-exit(r2)
            return r0
        L_0x0034:
            java.io.IOException r0 = r2.errorException     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x0042
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x004a }
            okhttp3.internal.http2.ErrorCode r1 = r2.errorCode     // Catch:{ all -> 0x004a }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x004a }
            r0.<init>(r1)     // Catch:{ all -> 0x004a }
        L_0x0042:
            throw r0     // Catch:{ all -> 0x004a }
        L_0x0043:
            r0 = move-exception
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r2.readTimeout     // Catch:{ all -> 0x004a }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x004a }
            throw r0     // Catch:{ all -> 0x004a }
        L_0x004a:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.takeHeaders():okhttp3.Headers");
    }

    @NotNull
    public final synchronized Headers trailers() throws IOException {
        Headers trailers;
        if (this.source.getFinished$okhttp() && this.source.getReceiveBuffer().exhausted() && this.source.getReadBuffer().exhausted()) {
            trailers = this.source.getTrailers();
            if (trailers == null) {
                trailers = Util.EMPTY_HEADERS;
            }
        } else if (this.errorCode != null) {
            Throwable th2 = this.errorException;
            if (th2 == null) {
                ErrorCode errorCode2 = this.errorCode;
                Intrinsics.checkNotNull(errorCode2);
                th2 = new StreamResetException(errorCode2);
            }
            throw th2;
        } else {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return trailers;
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(@NotNull List<Header> list, boolean z11, boolean z12) throws IOException {
        boolean z13;
        Intrinsics.checkNotNullParameter(list, "responseHeaders");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                z13 = true;
                this.hasResponseHeaders = true;
                if (z11) {
                    getSink$okhttp().setFinished(true);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (!z12) {
                synchronized (this.connection) {
                    if (getConnection().getWriteBytesTotal() < getConnection().getWriteBytesMaximum()) {
                        z13 = false;
                    }
                }
                z12 = z13;
            }
            this.connection.writeHeaders$okhttp(this.f27530id, z11, list);
            if (z12) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    @NotNull
    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "closed", "getClosed", "()Z", "setClosed", "(Z)V", "getFinished", "setFinished", "sendBuffer", "Lokio/Buffer;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "emitFrame", "outFinishedOnLastFrame", "flush", "timeout", "Lokio/Timeout;", "write", "source", "byteCount", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        @NotNull
        private final Buffer sendBuffer;
        @Nullable
        private Headers trailers;

        public FramingSink(Http2Stream http2Stream, boolean z11) {
            Intrinsics.checkNotNullParameter(http2Stream, "this$0");
            Http2Stream.this = http2Stream;
            this.finished = z11;
            this.sendBuffer = new Buffer();
        }

        /* JADX INFO: finally extract failed */
        private final void emitFrame(boolean z11) throws IOException {
            long min;
            boolean z12;
            boolean z13;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.getWriteTimeout$okhttp().enter();
                while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !getFinished() && !getClosed() && http2Stream.getErrorCode$okhttp() == null) {
                    try {
                        http2Stream.waitForIo$okhttp();
                    } catch (Throwable th2) {
                        http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                        throw th2;
                    }
                }
                http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                min = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.size());
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                if (!z11 || min != this.sendBuffer.size()) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                z13 = z12;
                Unit unit = Unit.INSTANCE;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z13, this.sendBuffer, min);
            } finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
            if (r10.this$0.getSink$okhttp().finished != false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
            if (r10.sendBuffer.size() <= 0) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
            if (r10.trailers == null) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
            if (r4 == false) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0077, code lost:
            if (r10.sendBuffer.size() <= 0) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0079, code lost:
            emitFrame(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
            r0 = r10.this$0.getConnection();
            r2 = r10.this$0.getId();
            r4 = r10.trailers;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
            r0.writeHeaders$okhttp(r2, r1, okhttp3.internal.Util.toHeaderList(r4));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
            if (r0 == false) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
            if (r10.sendBuffer.size() <= 0) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a2, code lost:
            emitFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
            if (r1 == false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
            r10.this$0.getConnection().writeData(r10.this$0.getId(), true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bb, code lost:
            r0 = r10.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bd, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            setClosed(true);
            r1 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c3, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c4, code lost:
            r10.this$0.getConnection().flush();
            r10.this$0.cancelStreamIfNecessary$okhttp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d2, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r10 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                boolean r1 = okhttp3.internal.Util.assertionsEnabled
                if (r1 == 0) goto L_0x0034
                boolean r1 = java.lang.Thread.holdsLock(r0)
                if (r1 != 0) goto L_0x000d
                goto L_0x0034
            L_0x000d:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Thread "
                r2.append(r3)
                java.lang.Thread r3 = java.lang.Thread.currentThread()
                java.lang.String r3 = r3.getName()
                r2.append(r3)
                java.lang.String r3 = " MUST NOT hold lock on "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r1.<init>(r0)
                throw r1
            L_0x0034:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r10.getClosed()     // Catch:{ all -> 0x00d6 }
                if (r1 == 0) goto L_0x003f
                monitor-exit(r0)
                return
            L_0x003f:
                okhttp3.internal.http2.ErrorCode r1 = r0.getErrorCode$okhttp()     // Catch:{ all -> 0x00d6 }
                r2 = 0
                r3 = 1
                if (r1 != 0) goto L_0x0049
                r1 = r3
                goto L_0x004a
            L_0x0049:
                r1 = r2
            L_0x004a:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d6 }
                monitor-exit(r0)
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$FramingSink r0 = r0.getSink$okhttp()
                boolean r0 = r0.finished
                if (r0 != 0) goto L_0x00bb
                okio.Buffer r0 = r10.sendBuffer
                long r4 = r0.size()
                r6 = 0
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x0065
                r0 = r3
                goto L_0x0066
            L_0x0065:
                r0 = r2
            L_0x0066:
                okhttp3.Headers r4 = r10.trailers
                if (r4 == 0) goto L_0x006c
                r4 = r3
                goto L_0x006d
            L_0x006c:
                r4 = r2
            L_0x006d:
                if (r4 == 0) goto L_0x0096
            L_0x006f:
                okio.Buffer r0 = r10.sendBuffer
                long r4 = r0.size()
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x007d
                r10.emitFrame(r2)
                goto L_0x006f
            L_0x007d:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r0 = r0.getConnection()
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this
                int r2 = r2.getId()
                okhttp3.Headers r4 = r10.trailers
                kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
                java.util.List r4 = okhttp3.internal.Util.toHeaderList(r4)
                r0.writeHeaders$okhttp(r2, r1, r4)
                goto L_0x00bb
            L_0x0096:
                if (r0 == 0) goto L_0x00a6
            L_0x0098:
                okio.Buffer r0 = r10.sendBuffer
                long r0 = r0.size()
                int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x00bb
                r10.emitFrame(r3)
                goto L_0x0098
            L_0x00a6:
                if (r1 == 0) goto L_0x00bb
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r4 = r0.getConnection()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                int r5 = r0.getId()
                r6 = 1
                r7 = 0
                r8 = 0
                r4.writeData(r5, r6, r7, r8)
            L_0x00bb:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                r10.setClosed(r3)     // Catch:{ all -> 0x00d3 }
                kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d3 }
                monitor-exit(r0)
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r0 = r0.getConnection()
                r0.flush()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                r0.cancelStreamIfNecessary$okhttp()
                return
            L_0x00d3:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x00d6:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSink.close():void");
        }

        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream http2Stream2 = Http2Stream.this;
                synchronized (http2Stream2) {
                    http2Stream2.checkOutNotClosed$okhttp();
                    Unit unit = Unit.INSTANCE;
                }
                while (this.sendBuffer.size() > 0) {
                    emitFrame(false);
                    Http2Stream.this.getConnection().flush();
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z11) {
            this.closed = z11;
        }

        public final void setFinished(boolean z11) {
            this.finished = z11;
        }

        public final void setTrailers(@Nullable Headers headers) {
            this.trailers = headers;
        }

        @NotNull
        public Timeout timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        public void write(@NotNull Buffer buffer, long j11) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.sendBuffer.write(buffer, j11);
                while (this.sendBuffer.size() >= 16384) {
                    emitFrame(false);
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FramingSink(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(Http2Stream.this, (i11 & 1) != 0 ? false : z11);
        }
    }
}
