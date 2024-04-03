package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010 \u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010!\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "source", "Lokio/BufferedSource;", "client", "", "(Lokio/BufferedSource;Z)V", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", "close", "", "nextFrame", "requireSettings", "handler", "Lokhttp3/internal/http2/Http2Reader$Handler;", "readConnectionPreface", "readData", "length", "", "flags", "streamId", "readGoAway", "readHeaderBlock", "", "Lokhttp3/internal/http2/Header;", "padding", "readHeaders", "readPing", "readPriority", "readPushPromise", "readRstStream", "readSettings", "readWindowUpdate", "Companion", "ContinuationSource", "Handler", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Http2Reader implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Logger logger;
    private final boolean client;
    @NotNull
    private final ContinuationSource continuation;
    @NotNull
    private final Hpack.Reader hpackReader;
    @NotNull
    private final BufferedSource source;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "lengthWithoutPadding", "", "length", "flags", "padding", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i11, int i12, int i13) throws IOException {
            if ((i12 & 8) != 0) {
                i11--;
            }
            if (i13 <= i11) {
                return i11 - i13;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i13 + " > remaining length " + i11);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006!"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "flags", "", "getFlags", "()I", "setFlags", "(I)V", "left", "getLeft", "setLeft", "length", "getLength", "setLength", "padding", "getPadding", "setPadding", "streamId", "getStreamId", "setStreamId", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readContinuationHeader", "timeout", "Lokio/Timeout;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        @NotNull
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(@NotNull BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            this.source = bufferedSource;
        }

        private final void readContinuationHeader() throws IOException {
            int i11 = this.streamId;
            int readMedium = Util.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            int and = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (and != 9) {
                throw new IOException(and + " != TYPE_CONTINUATION");
            } else if (readInt != i11) {
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
        }

        public void close() throws IOException {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        public long read(@NotNull Buffer buffer, long j11) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "sink");
            while (true) {
                int i11 = this.left;
                if (i11 == 0) {
                    this.source.skip((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j11, (long) i11));
                    if (read == -1) {
                        return -1;
                    }
                    this.left -= (int) read;
                    return read;
                }
            }
        }

        public final void setFlags(int i11) {
            this.flags = i11;
        }

        public final void setLeft(int i11) {
            this.left = i11;
        }

        public final void setLength(int i11) {
            this.length = i11;
        }

        public final void setPadding(int i11) {
            this.padding = i11;
        }

        public final void setStreamId(int i11) {
            this.streamId = i11;
        }

        @NotNull
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J8\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH&J.\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H&J(\u0010#\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0011H&J&\u0010'\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020-H&J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000eH&¨\u00060"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "ackSettings", "", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "data", "inFinished", "", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "settings", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "windowUpdate", "windowSizeIncrement", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Handler {
        void ackSettings();

        void alternateService(int i11, @NotNull String str, @NotNull ByteString byteString, @NotNull String str2, int i12, long j11);

        void data(boolean z11, int i11, @NotNull BufferedSource bufferedSource, int i12) throws IOException;

        void goAway(int i11, @NotNull ErrorCode errorCode, @NotNull ByteString byteString);

        void headers(boolean z11, int i11, int i12, @NotNull List<Header> list);

        void ping(boolean z11, int i11, int i12);

        void priority(int i11, int i12, int i13, boolean z11);

        void pushPromise(int i11, int i12, @NotNull List<Header> list) throws IOException;

        void rstStream(int i11, @NotNull ErrorCode errorCode);

        void settings(boolean z11, @NotNull Settings settings);

        void windowUpdate(int i11, long j11);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(@NotNull BufferedSource bufferedSource, boolean z11) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        this.source = bufferedSource;
        this.client = z11;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, (DefaultConstructorMarker) null);
    }

    private final void readData(Handler handler, int i11, int i12, int i13) throws IOException {
        boolean z11;
        if (i13 != 0) {
            int i14 = 0;
            boolean z12 = true;
            if ((i12 & 1) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((i12 & 32) == 0) {
                z12 = false;
            }
            if (!z12) {
                if ((i12 & 8) != 0) {
                    i14 = Util.and(this.source.readByte(), 255);
                }
                handler.data(z11, i13, this.source, Companion.lengthWithoutPadding(i11, i12, i14));
                this.source.skip((long) i14);
                return;
            }
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void readGoAway(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 < 8) {
            throw new IOException(Intrinsics.stringPlus("TYPE_GOAWAY length < 8: ", Integer.valueOf(i11)));
        } else if (i13 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            int i14 = i11 - 8;
            ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i14 > 0) {
                    byteString = this.source.readByteString((long) i14);
                }
                handler.goAway(readInt, fromHttp2, byteString);
                return;
            }
            throw new IOException(Intrinsics.stringPlus("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(readInt2)));
        } else {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
    }

    private final List<Header> readHeaderBlock(int i11, int i12, int i13, int i14) throws IOException {
        this.continuation.setLeft(i11);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i12);
        this.continuation.setFlags(i13);
        this.continuation.setStreamId(i14);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i11, int i12, int i13) throws IOException {
        boolean z11;
        if (i13 != 0) {
            int i14 = 0;
            if ((i12 & 1) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((i12 & 8) != 0) {
                i14 = Util.and(this.source.readByte(), 255);
            }
            if ((i12 & 32) != 0) {
                readPriority(handler, i13);
                i11 -= 5;
            }
            handler.headers(z11, i13, -1, readHeaderBlock(Companion.lengthWithoutPadding(i11, i12, i14), i14, i12, i13));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void readPing(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 != 8) {
            throw new IOException(Intrinsics.stringPlus("TYPE_PING length != 8: ", Integer.valueOf(i11)));
        } else if (i13 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            boolean z11 = true;
            if ((i12 & 1) == 0) {
                z11 = false;
            }
            handler.ping(z11, readInt, readInt2);
        } else {
            throw new IOException("TYPE_PING streamId != 0");
        }
    }

    private final void readPriority(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 != 5) {
            throw new IOException("TYPE_PRIORITY length: " + i11 + " != 5");
        } else if (i13 != 0) {
            readPriority(handler, i13);
        } else {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
    }

    private final void readPushPromise(Handler handler, int i11, int i12, int i13) throws IOException {
        int i14;
        if (i13 != 0) {
            if ((i12 & 8) != 0) {
                i14 = Util.and(this.source.readByte(), 255);
            } else {
                i14 = 0;
            }
            handler.pushPromise(i13, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i11 - 4, i12, i14), i14, i12, i13));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void readRstStream(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i11 + " != 4");
        } else if (i13 != 0) {
            int readInt = this.source.readInt();
            ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt);
            if (fromHttp2 != null) {
                handler.rstStream(i13, fromHttp2);
                return;
            }
            throw new IOException(Intrinsics.stringPlus("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(readInt)));
        } else {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
    }

    private final void readSettings(Handler handler, int i11, int i12, int i13) throws IOException {
        int readInt;
        if (i13 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        } else if ((i12 & 1) != 0) {
            if (i11 == 0) {
                handler.ackSettings();
                return;
            }
            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
        } else if (i11 % 6 == 0) {
            Settings settings = new Settings();
            IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, i11), 6);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    int i14 = first + step2;
                    int and = Util.and(this.source.readShort(), 65535);
                    readInt = this.source.readInt();
                    if (and != 2) {
                        if (and == 3) {
                            and = 4;
                        } else if (and != 4) {
                            if (and == 5 && (readInt < 16384 || readInt > 16777215)) {
                            }
                        } else if (readInt >= 0) {
                            and = 7;
                        } else {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                    } else if (!(readInt == 0 || readInt == 1)) {
                        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                    }
                    settings.set(and, readInt);
                    if (first == last) {
                        break;
                    }
                    first = i14;
                }
                throw new IOException(Intrinsics.stringPlus("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(readInt)));
            }
            handler.settings(false, settings);
        } else {
            throw new IOException(Intrinsics.stringPlus("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(i11)));
        }
    }

    private final void readWindowUpdate(Handler handler, int i11, int i12, int i13) throws IOException {
        if (i11 == 4) {
            long and = Util.and(this.source.readInt(), 2147483647L);
            if (and != 0) {
                handler.windowUpdate(i13, and);
                return;
            }
            throw new IOException("windowSizeIncrement was 0");
        }
        throw new IOException(Intrinsics.stringPlus("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(i11)));
    }

    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z11, @NotNull Handler handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        try {
            this.source.require(9);
            int readMedium = Util.readMedium(this.source);
            if (readMedium <= 16384) {
                int and = Util.and(this.source.readByte(), 255);
                int and2 = Util.and(this.source.readByte(), 255);
                int readInt = this.source.readInt() & Integer.MAX_VALUE;
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.INSTANCE.frameLog(true, readInt, readMedium, and, and2));
                }
                if (!z11 || and == 4) {
                    switch (and) {
                        case 0:
                            readData(handler, readMedium, and2, readInt);
                            return true;
                        case 1:
                            readHeaders(handler, readMedium, and2, readInt);
                            return true;
                        case 2:
                            readPriority(handler, readMedium, and2, readInt);
                            return true;
                        case 3:
                            readRstStream(handler, readMedium, and2, readInt);
                            return true;
                        case 4:
                            readSettings(handler, readMedium, and2, readInt);
                            return true;
                        case 5:
                            readPushPromise(handler, readMedium, and2, readInt);
                            return true;
                        case 6:
                            readPing(handler, readMedium, and2, readInt);
                            return true;
                        case 7:
                            readGoAway(handler, readMedium, and2, readInt);
                            return true;
                        case 8:
                            readWindowUpdate(handler, readMedium, and2, readInt);
                            return true;
                        default:
                            this.source.skip((long) readMedium);
                            return true;
                    }
                } else {
                    throw new IOException(Intrinsics.stringPlus("Expected a SETTINGS frame but was ", Http2.INSTANCE.formattedType$okhttp(and)));
                }
            } else {
                throw new IOException(Intrinsics.stringPlus("FRAME_SIZE_ERROR: ", Integer.valueOf(readMedium)));
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(@NotNull Handler handler) throws IOException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (!this.client) {
            BufferedSource bufferedSource = this.source;
            ByteString byteString = Http2.CONNECTION_PREFACE;
            ByteString readByteString = bufferedSource.readByteString((long) byteString.size());
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format(Intrinsics.stringPlus("<< CONNECTION ", readByteString.hex()), new Object[0]));
            }
            if (!Intrinsics.areEqual((Object) byteString, (Object) readByteString)) {
                throw new IOException(Intrinsics.stringPlus("Expected a connection header but was ", readByteString.utf8()));
            }
        } else if (!nextFrame(true, handler)) {
            throw new IOException("Required SETTINGS preface not received");
        }
    }

    private final void readPriority(Handler handler, int i11) throws IOException {
        int readInt = this.source.readInt();
        handler.priority(i11, readInt & Integer.MAX_VALUE, Util.and(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }
}
