package okhttp3.internal.ws;

import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0005_`abcB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000203H\u0016J\u001f\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0000¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DJ\u001c\u0010E\u001a\u0002032\n\u0010F\u001a\u00060Gj\u0002`H2\b\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010I\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u0006\u0010J\u001a\u000203J\u0018\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u000e\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020 J\u0006\u0010S\u001a\u00020\u0012J\b\u0010!\u001a\u00020\fH\u0016J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u000203H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010N\u001a\u00020 H\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0006\u0010Y\u001a\u000203J\r\u0010Z\u001a\u00020\u0012H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u000203H\u0000¢\u0006\u0002\b]J\f\u0010^\u001a\u00020\u0012*\u00020\u000eH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancel", "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", "code", "reason", "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", "request", "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "isValid", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    @NotNull
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt__CollectionsJVMKt.listOf(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    @Nullable
    private Call call;
    private boolean enqueuedClose;
    /* access modifiers changed from: private */
    @Nullable
    public WebSocketExtensions extensions;
    private boolean failed;
    @NotNull
    private final String key;
    @NotNull
    private final WebSocketListener listener;
    /* access modifiers changed from: private */
    @NotNull
    public final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private long minimumDeflateSize;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    public String f27531name;
    @NotNull
    private final Request originalRequest;
    private final long pingIntervalMillis;
    @NotNull
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private long queueSize;
    @NotNull
    private final Random random;
    @Nullable
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    @Nullable
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    @Nullable
    private Streams streams;
    @NotNull
    private TaskQueue taskQueue;
    @Nullable
    private WebSocketWriter writer;
    @Nullable
    private Task writerTask;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        @Nullable
        private final ByteString reason;

        public Close(int i11, @Nullable ByteString byteString, long j11) {
            this.code = i11;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j11;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final ByteString getReason() {
            return this.reason;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "DEFAULT_MINIMUM_DEFLATE_SIZE", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Message {
        @NotNull
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i11, @NotNull ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "data");
            this.formatOpcode = i11;
            this.data = byteString;
        }

        @NotNull
        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Streams implements Closeable {
        private final boolean client;
        @NotNull
        private final BufferedSink sink;
        @NotNull
        private final BufferedSource source;

        public Streams(boolean z11, @NotNull BufferedSource bufferedSource, @NotNull BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            Intrinsics.checkNotNullParameter(bufferedSink, "sink");
            this.client = z11;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }

        public final boolean getClient() {
            return this.client;
        }

        @NotNull
        public final BufferedSink getSink() {
            return this.sink;
        }

        @NotNull
        public final BufferedSource getSource() {
            return this.source;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class WriterTask extends Task {
        final /* synthetic */ RealWebSocket this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WriterTask(RealWebSocket realWebSocket) {
            super(Intrinsics.stringPlus(realWebSocket.f27531name, " writer"), false, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(realWebSocket, "this$0");
            this.this$0 = realWebSocket;
        }

        public long runOnce() {
            try {
                if (this.this$0.writeOneFrame$okhttp()) {
                    return 0;
                }
                return -1;
            } catch (IOException e11) {
                this.this$0.failWebSocket(e11, (Response) null);
                return -1;
            }
        }
    }

    public RealWebSocket(@NotNull TaskRunner taskRunner, @NotNull Request request, @NotNull WebSocketListener webSocketListener, @NotNull Random random2, long j11, @Nullable WebSocketExtensions webSocketExtensions, long j12) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(request, "originalRequest");
        Intrinsics.checkNotNullParameter(webSocketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(random2, "random");
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random2;
        this.pingIntervalMillis = j11;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j12;
        this.taskQueue = taskRunner.newQueue();
        if (Intrinsics.areEqual((Object) "GET", (Object) request.method())) {
            ByteString.Companion companion = ByteString.Companion;
            byte[] bArr = new byte[16];
            random2.nextBytes(bArr);
            Unit unit = Unit.INSTANCE;
            this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, (Object) null).base64();
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Request must be GET: ", request.method()).toString());
    }

    /* access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits == null || new IntRange(8, 15).contains(webSocketExtensions.serverMaxWindowBits.intValue())) {
            return true;
        }
        return false;
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0, 2, (Object) null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final void awaitTermination(long j11, @NotNull TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j11, timeUnit);
    }

    public void cancel() {
        Call call2 = this.call;
        Intrinsics.checkNotNull(call2);
        call2.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(@NotNull Response response, @Nullable Exchange exchange) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 101) {
            String header$default = Response.header$default(response, "Connection", (String) null, 2, (Object) null);
            if (StringsKt__StringsJVMKt.equals(HttpHeaders.UPGRADE, header$default, true)) {
                String header$default2 = Response.header$default(response, HttpHeaders.UPGRADE, (String) null, 2, (Object) null);
                if (StringsKt__StringsJVMKt.equals("websocket", header$default2, true)) {
                    String header$default3 = Response.header$default(response, HttpHeaders.SEC_WEBSOCKET_ACCEPT, (String) null, 2, (Object) null);
                    String base64 = ByteString.Companion.encodeUtf8(Intrinsics.stringPlus(this.key, WebSocketProtocol.ACCEPT_MAGIC)).sha1().base64();
                    if (!Intrinsics.areEqual((Object) base64, (Object) header$default3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
                    } else if (exchange == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
            }
        } else {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
    }

    public boolean close(int i11, @Nullable String str) {
        return close(i11, str, 60000);
    }

    public final void connect(@NotNull OkHttpClient okHttpClient) {
        Request request;
        Intrinsics.checkNotNullParameter(okHttpClient, ContactDetailsKeys.SENT_FROM_VALUE);
        if (this.originalRequest.header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS) != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), (Response) null);
            return;
        }
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        Request.Builder header = this.originalRequest.newBuilder().header(HttpHeaders.UPGRADE, "websocket").header("Connection", HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.key).header(HttpHeaders.SEC_WEBSOCKET_VERSION, "13").header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate");
        if (!(header instanceof Request.Builder)) {
            request = header.build();
        } else {
            request = OkHttp3Instrumentation.build(header);
        }
        RealCall realCall = new RealCall(build, request, true);
        this.call = realCall;
        Intrinsics.checkNotNull(realCall);
        realCall.enqueue(new RealWebSocket$connect$1(this, request));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4.listener.onFailure(r4, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r0 != null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (r2 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (r3 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void failWebSocket(@org.jetbrains.annotations.NotNull java.lang.Exception r5, @org.jetbrains.annotations.Nullable okhttp3.Response r6) {
        /*
            r4 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            monitor-enter(r4)
            boolean r0 = r4.failed     // Catch:{ all -> 0x0050 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)
            return
        L_0x000c:
            r0 = 1
            r4.failed = r0     // Catch:{ all -> 0x0050 }
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r4.streams     // Catch:{ all -> 0x0050 }
            r1 = 0
            r4.streams = r1     // Catch:{ all -> 0x0050 }
            okhttp3.internal.ws.WebSocketReader r2 = r4.reader     // Catch:{ all -> 0x0050 }
            r4.reader = r1     // Catch:{ all -> 0x0050 }
            okhttp3.internal.ws.WebSocketWriter r3 = r4.writer     // Catch:{ all -> 0x0050 }
            r4.writer = r1     // Catch:{ all -> 0x0050 }
            okhttp3.internal.concurrent.TaskQueue r1 = r4.taskQueue     // Catch:{ all -> 0x0050 }
            r1.shutdown()     // Catch:{ all -> 0x0050 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0050 }
            monitor-exit(r4)
            okhttp3.WebSocketListener r1 = r4.listener     // Catch:{ all -> 0x003c }
            r1.onFailure(r4, r5, r6)     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x002c
            goto L_0x002f
        L_0x002c:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x002f:
            if (r2 != 0) goto L_0x0032
            goto L_0x0035
        L_0x0032:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0035:
            if (r3 != 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x003b:
            return
        L_0x003c:
            r5 = move-exception
            if (r0 != 0) goto L_0x0040
            goto L_0x0043
        L_0x0040:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x0043:
            if (r2 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0049:
            if (r3 != 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x004f:
            throw r5
        L_0x0050:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.failWebSocket(java.lang.Exception, okhttp3.Response):void");
    }

    @NotNull
    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(@NotNull String str, @NotNull Streams streams2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(streams2, "streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        Intrinsics.checkNotNull(webSocketExtensions);
        synchronized (this) {
            this.f27531name = str;
            this.streams = streams2;
            this.writer = new WebSocketWriter(streams2.getClient(), streams2.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams2.getClient()), this.minimumDeflateSize);
            this.writerTask = new WriterTask(this);
            long j11 = this.pingIntervalMillis;
            if (j11 != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j11);
                this.taskQueue.schedule(new RealWebSocket$initReaderAndWriter$lambda3$$inlined$schedule$1(Intrinsics.stringPlus(str, " ping"), this, nanos), nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(streams2.getClient(), streams2.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams2.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [okhttp3.internal.ws.WebSocketWriter, okhttp3.internal.ws.WebSocketReader, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReadClose(int r5, @org.jetbrains.annotations.NotNull java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "reason"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 1
            r1 = 0
            r2 = -1
            if (r5 == r2) goto L_0x000c
            r3 = r0
            goto L_0x000d
        L_0x000c:
            r3 = r1
        L_0x000d:
            if (r3 == 0) goto L_0x0083
            monitor-enter(r4)
            int r3 = r4.receivedCloseCode     // Catch:{ all -> 0x0080 }
            if (r3 != r2) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x0074
            r4.receivedCloseCode = r5     // Catch:{ all -> 0x0080 }
            r4.receivedCloseReason = r6     // Catch:{ all -> 0x0080 }
            boolean r0 = r4.enqueuedClose     // Catch:{ all -> 0x0080 }
            r1 = 0
            if (r0 == 0) goto L_0x003c
            java.util.ArrayDeque<java.lang.Object> r0 = r4.messageAndCloseQueue     // Catch:{ all -> 0x0080 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x003c
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r4.streams     // Catch:{ all -> 0x0080 }
            r4.streams = r1     // Catch:{ all -> 0x0080 }
            okhttp3.internal.ws.WebSocketReader r2 = r4.reader     // Catch:{ all -> 0x0080 }
            r4.reader = r1     // Catch:{ all -> 0x0080 }
            okhttp3.internal.ws.WebSocketWriter r3 = r4.writer     // Catch:{ all -> 0x0080 }
            r4.writer = r1     // Catch:{ all -> 0x0080 }
            okhttp3.internal.concurrent.TaskQueue r1 = r4.taskQueue     // Catch:{ all -> 0x0080 }
            r1.shutdown()     // Catch:{ all -> 0x0080 }
            r1 = r0
            goto L_0x003e
        L_0x003c:
            r2 = r1
            r3 = r2
        L_0x003e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0080 }
            monitor-exit(r4)
            okhttp3.WebSocketListener r0 = r4.listener     // Catch:{ all -> 0x0060 }
            r0.onClosing(r4, r5, r6)     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x004d
            okhttp3.WebSocketListener r0 = r4.listener     // Catch:{ all -> 0x0060 }
            r0.onClosed(r4, r5, r6)     // Catch:{ all -> 0x0060 }
        L_0x004d:
            if (r1 != 0) goto L_0x0050
            goto L_0x0053
        L_0x0050:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x0053:
            if (r2 != 0) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0059:
            if (r3 != 0) goto L_0x005c
            goto L_0x005f
        L_0x005c:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x005f:
            return
        L_0x0060:
            r5 = move-exception
            if (r1 != 0) goto L_0x0064
            goto L_0x0067
        L_0x0064:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x0067:
            if (r2 != 0) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x006d:
            if (r3 != 0) goto L_0x0070
            goto L_0x0073
        L_0x0070:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0073:
            throw r5
        L_0x0074:
            java.lang.String r5 = "already closed"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0080 }
            r6.<init>(r5)     // Catch:{ all -> 0x0080 }
            throw r6     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0083:
            java.lang.String r5 = "Failed requirement."
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadClose(int, java.lang.String):void");
    }

    public void onReadMessage(@NotNull String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "text");
        this.listener.onMessage((WebSocket) this, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(@org.jetbrains.annotations.NotNull okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch:{ all -> 0x0029 }
            boolean r0 = r1.failed     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            goto L_0x0027
        L_0x0017:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0029 }
            r0.add(r2)     // Catch:{ all -> 0x0029 }
            r1.runWriter()     // Catch:{ all -> 0x0029 }
            int r2 = r1.receivedPingCount     // Catch:{ all -> 0x0029 }
            int r2 = r2 + 1
            r1.receivedPingCount = r2     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)
            return
        L_0x0027:
            monitor-exit(r1)
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean pong(@org.jetbrains.annotations.NotNull okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch:{ all -> 0x0025 }
            boolean r0 = r1.failed     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0017
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0025 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0017
            goto L_0x0022
        L_0x0017:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0025 }
            r0.add(r2)     // Catch:{ all -> 0x0025 }
            r1.runWriter()     // Catch:{ all -> 0x0025 }
            monitor-exit(r1)
            r2 = 1
            return r2
        L_0x0022:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0025:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.pong(okio.ByteString):boolean");
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            failWebSocket(e11, (Response) null);
            return false;
        }
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    public boolean send(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return send(ByteString.Companion.encodeUtf8(str), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        if (r2 == null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0.writePong(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        if ((r4 instanceof okhttp3.internal.ws.RealWebSocket.Message) == false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007c, code lost:
        r4 = (okhttp3.internal.ws.RealWebSocket.Message) r4;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0.writeMessageFrame(r4.getFormatOpcode(), r4.getData());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        monitor-enter(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r12.queueSize -= (long) r4.getData().size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        monitor-exit(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a2, code lost:
        if ((r4 instanceof okhttp3.internal.ws.RealWebSocket.Close) == false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a4, code lost:
        r4 = (okhttp3.internal.ws.RealWebSocket.Close) r4;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0.writeClose(r4.getCode(), r4.getReason());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b4, code lost:
        if (r5 == null) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b6, code lost:
        r0 = r12.listener;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r7);
        r0.onClosed(r12, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00be, code lost:
        if (r5 != null) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c1, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c4, code lost:
        if (r8 != null) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c7, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ca, code lost:
        if (r9 != null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cd, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d0, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d6, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d8, code lost:
        if (r5 != null) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00db, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00de, code lost:
        if (r8 != null) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e1, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e4, code lost:
        if (r9 != null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e7, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ea, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.failed     // Catch:{ all -> 0x00eb }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r12)
            return r1
        L_0x0008:
            okhttp3.internal.ws.WebSocketWriter r0 = r12.writer     // Catch:{ all -> 0x00eb }
            java.util.ArrayDeque<okio.ByteString> r2 = r12.pongQueue     // Catch:{ all -> 0x00eb }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x00eb }
            r3 = 1
            r4 = 0
            r5 = -1
            if (r2 != 0) goto L_0x0065
            java.util.ArrayDeque<java.lang.Object> r6 = r12.messageAndCloseQueue     // Catch:{ all -> 0x00eb }
            java.lang.Object r6 = r6.poll()     // Catch:{ all -> 0x00eb }
            boolean r7 = r6 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x00eb }
            if (r7 == 0) goto L_0x005a
            int r1 = r12.receivedCloseCode     // Catch:{ all -> 0x00eb }
            java.lang.String r7 = r12.receivedCloseReason     // Catch:{ all -> 0x00eb }
            if (r1 == r5) goto L_0x0037
            okhttp3.internal.ws.RealWebSocket$Streams r5 = r12.streams     // Catch:{ all -> 0x00eb }
            r12.streams = r4     // Catch:{ all -> 0x00eb }
            okhttp3.internal.ws.WebSocketReader r8 = r12.reader     // Catch:{ all -> 0x00eb }
            r12.reader = r4     // Catch:{ all -> 0x00eb }
            okhttp3.internal.ws.WebSocketWriter r9 = r12.writer     // Catch:{ all -> 0x00eb }
            r12.writer = r4     // Catch:{ all -> 0x00eb }
            okhttp3.internal.concurrent.TaskQueue r4 = r12.taskQueue     // Catch:{ all -> 0x00eb }
            r4.shutdown()     // Catch:{ all -> 0x00eb }
            goto L_0x0063
        L_0x0037:
            r5 = r6
            okhttp3.internal.ws.RealWebSocket$Close r5 = (okhttp3.internal.ws.RealWebSocket.Close) r5     // Catch:{ all -> 0x00eb }
            long r8 = r5.getCancelAfterCloseMillis()     // Catch:{ all -> 0x00eb }
            okhttp3.internal.concurrent.TaskQueue r5 = r12.taskQueue     // Catch:{ all -> 0x00eb }
            java.lang.String r10 = r12.f27531name     // Catch:{ all -> 0x00eb }
            java.lang.String r11 = " cancel"
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r11)     // Catch:{ all -> 0x00eb }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00eb }
            long r8 = r11.toNanos(r8)     // Catch:{ all -> 0x00eb }
            okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda-8$$inlined$execute$default$1 r11 = new okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda-8$$inlined$execute$default$1     // Catch:{ all -> 0x00eb }
            r11.<init>(r10, r3, r12)     // Catch:{ all -> 0x00eb }
            r5.schedule(r11, r8)     // Catch:{ all -> 0x00eb }
            r5 = r4
            r8 = r5
            r9 = r8
            goto L_0x0063
        L_0x005a:
            if (r6 != 0) goto L_0x005e
            monitor-exit(r12)
            return r1
        L_0x005e:
            r7 = r4
            r8 = r7
            r9 = r8
            r1 = r5
            r5 = r9
        L_0x0063:
            r4 = r6
            goto L_0x006a
        L_0x0065:
            r7 = r4
            r8 = r7
            r9 = r8
            r1 = r5
            r5 = r9
        L_0x006a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00eb }
            monitor-exit(r12)
            if (r2 == 0) goto L_0x0078
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x00d7 }
            okio.ByteString r2 = (okio.ByteString) r2     // Catch:{ all -> 0x00d7 }
            r0.writePong(r2)     // Catch:{ all -> 0x00d7 }
            goto L_0x00be
        L_0x0078:
            boolean r2 = r4 instanceof okhttp3.internal.ws.RealWebSocket.Message     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x00a0
            okhttp3.internal.ws.RealWebSocket$Message r4 = (okhttp3.internal.ws.RealWebSocket.Message) r4     // Catch:{ all -> 0x00d7 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x00d7 }
            int r1 = r4.getFormatOpcode()     // Catch:{ all -> 0x00d7 }
            okio.ByteString r2 = r4.getData()     // Catch:{ all -> 0x00d7 }
            r0.writeMessageFrame(r1, r2)     // Catch:{ all -> 0x00d7 }
            monitor-enter(r12)     // Catch:{ all -> 0x00d7 }
            long r0 = r12.queueSize     // Catch:{ all -> 0x009d }
            okio.ByteString r2 = r4.getData()     // Catch:{ all -> 0x009d }
            int r2 = r2.size()     // Catch:{ all -> 0x009d }
            long r6 = (long) r2     // Catch:{ all -> 0x009d }
            long r0 = r0 - r6
            r12.queueSize = r0     // Catch:{ all -> 0x009d }
            monitor-exit(r12)     // Catch:{ all -> 0x00d7 }
            goto L_0x00be
        L_0x009d:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00d7 }
            throw r0     // Catch:{ all -> 0x00d7 }
        L_0x00a0:
            boolean r2 = r4 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x00d1
            okhttp3.internal.ws.RealWebSocket$Close r4 = (okhttp3.internal.ws.RealWebSocket.Close) r4     // Catch:{ all -> 0x00d7 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x00d7 }
            int r2 = r4.getCode()     // Catch:{ all -> 0x00d7 }
            okio.ByteString r4 = r4.getReason()     // Catch:{ all -> 0x00d7 }
            r0.writeClose(r2, r4)     // Catch:{ all -> 0x00d7 }
            if (r5 == 0) goto L_0x00be
            okhttp3.WebSocketListener r0 = r12.listener     // Catch:{ all -> 0x00d7 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x00d7 }
            r0.onClosed(r12, r1, r7)     // Catch:{ all -> 0x00d7 }
        L_0x00be:
            if (r5 != 0) goto L_0x00c1
            goto L_0x00c4
        L_0x00c1:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r5)
        L_0x00c4:
            if (r8 != 0) goto L_0x00c7
            goto L_0x00ca
        L_0x00c7:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8)
        L_0x00ca:
            if (r9 != 0) goto L_0x00cd
            goto L_0x00d0
        L_0x00cd:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9)
        L_0x00d0:
            return r3
        L_0x00d1:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00d7 }
            r0.<init>()     // Catch:{ all -> 0x00d7 }
            throw r0     // Catch:{ all -> 0x00d7 }
        L_0x00d7:
            r0 = move-exception
            if (r5 != 0) goto L_0x00db
            goto L_0x00de
        L_0x00db:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r5)
        L_0x00de:
            if (r8 != 0) goto L_0x00e1
            goto L_0x00e4
        L_0x00e1:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8)
        L_0x00e4:
            if (r9 != 0) goto L_0x00e7
            goto L_0x00ea
        L_0x00e7:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9)
        L_0x00ea:
            throw r0
        L_0x00eb:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0022, code lost:
        if (r1 == -1) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0024, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.writePing(okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        failWebSocket(r0, (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writePingFrame$okhttp() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.failed     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            okhttp3.internal.ws.WebSocketWriter r0 = r7.writer     // Catch:{ all -> 0x0059 }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r1 = r7.awaitingPong     // Catch:{ all -> 0x0059 }
            r2 = -1
            if (r1 == 0) goto L_0x0015
            int r1 = r7.sentPingCount     // Catch:{ all -> 0x0059 }
            goto L_0x0016
        L_0x0015:
            r1 = r2
        L_0x0016:
            int r3 = r7.sentPingCount     // Catch:{ all -> 0x0059 }
            r4 = 1
            int r3 = r3 + r4
            r7.sentPingCount = r3     // Catch:{ all -> 0x0059 }
            r7.awaitingPong = r4     // Catch:{ all -> 0x0059 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0059 }
            monitor-exit(r7)
            r3 = 0
            if (r1 == r2) goto L_0x004e
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r2.append(r5)
            long r5 = r7.pingIntervalMillis
            r2.append(r5)
            java.lang.String r5 = "ms (after "
            r2.append(r5)
            int r1 = r1 - r4
            r2.append(r1)
            java.lang.String r1 = " successful ping/pongs)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r7.failWebSocket(r0, r3)
            return
        L_0x004e:
            okio.ByteString r1 = okio.ByteString.EMPTY     // Catch:{ IOException -> 0x0054 }
            r0.writePing(r1)     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            r7.failWebSocket(r0, r3)
        L_0x0058:
            return
        L_0x0059:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writePingFrame$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean close(int r8, @org.jetbrains.annotations.Nullable java.lang.String r9, long r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            okhttp3.internal.ws.WebSocketProtocol r0 = okhttp3.internal.ws.WebSocketProtocol.INSTANCE     // Catch:{ all -> 0x004e }
            r0.validateCloseCode(r8)     // Catch:{ all -> 0x004e }
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L_0x0031
            okio.ByteString$Companion r2 = okio.ByteString.Companion     // Catch:{ all -> 0x004e }
            okio.ByteString r2 = r2.encodeUtf8(r9)     // Catch:{ all -> 0x004e }
            int r3 = r2.size()     // Catch:{ all -> 0x004e }
            long r3 = (long) r3     // Catch:{ all -> 0x004e }
            r5 = 123(0x7b, double:6.1E-322)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x001d
            r3 = r1
            goto L_0x001e
        L_0x001d:
            r3 = r0
        L_0x001e:
            if (r3 == 0) goto L_0x0021
            goto L_0x0032
        L_0x0021:
            java.lang.String r8 = "reason.size() > 123: "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r9)     // Catch:{ all -> 0x004e }
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x004e }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x004e }
            r9.<init>(r8)     // Catch:{ all -> 0x004e }
            throw r9     // Catch:{ all -> 0x004e }
        L_0x0031:
            r2 = 0
        L_0x0032:
            boolean r9 = r7.failed     // Catch:{ all -> 0x004e }
            if (r9 != 0) goto L_0x004c
            boolean r9 = r7.enqueuedClose     // Catch:{ all -> 0x004e }
            if (r9 == 0) goto L_0x003b
            goto L_0x004c
        L_0x003b:
            r7.enqueuedClose = r1     // Catch:{ all -> 0x004e }
            java.util.ArrayDeque<java.lang.Object> r9 = r7.messageAndCloseQueue     // Catch:{ all -> 0x004e }
            okhttp3.internal.ws.RealWebSocket$Close r0 = new okhttp3.internal.ws.RealWebSocket$Close     // Catch:{ all -> 0x004e }
            r0.<init>(r8, r2, r10)     // Catch:{ all -> 0x004e }
            r9.add(r0)     // Catch:{ all -> 0x004e }
            r7.runWriter()     // Catch:{ all -> 0x004e }
            monitor-exit(r7)
            return r1
        L_0x004c:
            monitor-exit(r7)
            return r0
        L_0x004e:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.close(int, java.lang.String, long):boolean");
    }

    public void onReadMessage(@NotNull ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        this.listener.onMessage((WebSocket) this, byteString);
    }

    public boolean send(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return send(byteString, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean send(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.failed     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.enqueuedClose     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.queueSize = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.messageAndCloseQueue     // Catch:{ all -> 0x003e }
            okhttp3.internal.ws.RealWebSocket$Message r1 = new okhttp3.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.runWriter()     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.send(okio.ByteString, int):boolean");
    }
}
