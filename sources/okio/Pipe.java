package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u0010J\r\u0010\u0017\u001a\u00020\u0010H\u0007¢\u0006\u0002\b$J\r\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\b%J&\u0010&\u001a\u00020\"*\u00020\u00102\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\"0(¢\u0006\u0002\b)H\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u00108G¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u0013\u0010\u001b\u001a\u00020\u001c8G¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e¨\u0006*"}, d2 = {"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", "", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "getMaxBufferSize$okio", "()J", "sink", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "cancel", "", "fold", "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Pipe {
    @NotNull
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    @Nullable
    private Sink foldedSink;
    private final long maxBufferSize;
    @NotNull
    private final Sink sink;
    private boolean sinkClosed;
    @NotNull
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j11) {
        boolean z11;
        this.maxBufferSize = j11;
        if (j11 >= 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.sink = new Pipe$sink$1(this);
            this.source = new Pipe$source$1(this);
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("maxBufferSize < 1: ", Long.valueOf(getMaxBufferSize$okio())).toString());
    }

    private final void forward(Sink sink2, Function1<? super Sink, Unit> function1) {
        Timeout timeout = sink2.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                function1.invoke(sink2);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        } else {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                function1.invoke(sink2);
                Unit unit2 = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    @JvmName(name = "-deprecated_sink")
    /* renamed from: -deprecated_sink  reason: not valid java name */
    public final Sink m8070deprecated_sink() {
        return this.sink;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "source", imports = {}))
    @JvmName(name = "-deprecated_source")
    /* renamed from: -deprecated_source  reason: not valid java name */
    public final Source m8071deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            setCanceled$okio(true);
            getBuffer$okio().clear();
            getBuffer$okio().notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r8.write(r3, r3.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r1 == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r8.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        monitor-enter(r7.buffer);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        setSourceClosed$okio(true);
        getBuffer$okio().notifyAll();
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fold(@org.jetbrains.annotations.NotNull okio.Sink r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
        L_0x0005:
            okio.Buffer r0 = r7.buffer
            monitor-enter(r0)
            okio.Sink r1 = r7.getFoldedSink$okio()     // Catch:{ all -> 0x008b }
            r2 = 1
            if (r1 != 0) goto L_0x0011
            r1 = r2
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x007f
            boolean r1 = r7.getCanceled$okio()     // Catch:{ all -> 0x008b }
            if (r1 != 0) goto L_0x0074
            okio.Buffer r1 = r7.getBuffer$okio()     // Catch:{ all -> 0x008b }
            boolean r1 = r1.exhausted()     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x002c
            r7.setSourceClosed$okio(r2)     // Catch:{ all -> 0x008b }
            r7.setFoldedSink$okio(r8)     // Catch:{ all -> 0x008b }
            monitor-exit(r0)
            return
        L_0x002c:
            boolean r1 = r7.getSinkClosed$okio()     // Catch:{ all -> 0x008b }
            okio.Buffer r3 = new okio.Buffer     // Catch:{ all -> 0x008b }
            r3.<init>()     // Catch:{ all -> 0x008b }
            okio.Buffer r4 = r7.getBuffer$okio()     // Catch:{ all -> 0x008b }
            okio.Buffer r5 = r7.getBuffer$okio()     // Catch:{ all -> 0x008b }
            long r5 = r5.size()     // Catch:{ all -> 0x008b }
            r3.write((okio.Buffer) r4, (long) r5)     // Catch:{ all -> 0x008b }
            okio.Buffer r4 = r7.getBuffer$okio()     // Catch:{ all -> 0x008b }
            r4.notifyAll()     // Catch:{ all -> 0x008b }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008b }
            monitor-exit(r0)
            long r4 = r3.size()     // Catch:{ all -> 0x005f }
            r8.write(r3, r4)     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x005b
            r8.close()     // Catch:{ all -> 0x005f }
            goto L_0x0005
        L_0x005b:
            r8.flush()     // Catch:{ all -> 0x005f }
            goto L_0x0005
        L_0x005f:
            r8 = move-exception
            okio.Buffer r0 = r7.buffer
            monitor-enter(r0)
            r7.setSourceClosed$okio(r2)     // Catch:{ all -> 0x0071 }
            okio.Buffer r1 = r7.getBuffer$okio()     // Catch:{ all -> 0x0071 }
            r1.notifyAll()     // Catch:{ all -> 0x0071 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)
            throw r8
        L_0x0071:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        L_0x0074:
            r7.setFoldedSink$okio(r8)     // Catch:{ all -> 0x008b }
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008b }
            java.lang.String r1 = "canceled"
            r8.<init>(r1)     // Catch:{ all -> 0x008b }
            throw r8     // Catch:{ all -> 0x008b }
        L_0x007f:
            java.lang.String r8 = "sink already folded"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008b }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x008b }
            r1.<init>(r8)     // Catch:{ all -> 0x008b }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x008b:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe.fold(okio.Sink):void");
    }

    @NotNull
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    @Nullable
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z11) {
        this.canceled = z11;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink2) {
        this.foldedSink = sink2;
    }

    public final void setSinkClosed$okio(boolean z11) {
        this.sinkClosed = z11;
    }

    public final void setSourceClosed$okio(boolean z11) {
        this.sourceClosed = z11;
    }

    @NotNull
    @JvmName(name = "sink")
    public final Sink sink() {
        return this.sink;
    }

    @NotNull
    @JvmName(name = "source")
    public final Source source() {
        return this.source;
    }
}
