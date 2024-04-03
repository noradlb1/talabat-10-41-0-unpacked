package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "close", "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Pipe$sink$1 implements Sink {
    final /* synthetic */ Pipe this$0;
    @NotNull
    private final Timeout timeout = new Timeout();

    public Pipe$sink$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r2 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        r0 = r12.this$0;
        r1 = r2.timeout();
        r0 = r0.sink().timeout();
        r3 = r1.timeoutNanos();
        r5 = okio.Timeout.Companion.minTimeout(r0.timeoutNanos(), r1.timeoutNanos());
        r7 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r1.timeout(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        if (r1.hasDeadline() == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        r5 = r1.deadlineNanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        if (r0.hasDeadline() == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        r1.deadlineNanoTime(java.lang.Math.min(r1.deadlineNanoTime(), r0.deadlineNanoTime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008e, code lost:
        r1.timeout(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        if (r0.hasDeadline() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0097, code lost:
        r1.deadlineNanoTime(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a5, code lost:
        if (r0.hasDeadline() != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        r1.deadlineNanoTime(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
        if (r0.hasDeadline() == false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b1, code lost:
        r1.deadlineNanoTime(r0.deadlineNanoTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bb, code lost:
        r1.timeout(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c2, code lost:
        if (r0.hasDeadline() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c4, code lost:
        r1.clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c8, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c9, code lost:
        r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d2, code lost:
        if (r0.hasDeadline() != false) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d4, code lost:
        r1.clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d7, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r12 = this;
            okio.Pipe r0 = r12.this$0
            okio.Buffer r0 = r0.getBuffer$okio()
            okio.Pipe r1 = r12.this$0
            monitor-enter(r0)
            boolean r2 = r1.getSinkClosed$okio()     // Catch:{ all -> 0x00d8 }
            if (r2 == 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            okio.Sink r2 = r1.getFoldedSink$okio()     // Catch:{ all -> 0x00d8 }
            if (r2 != 0) goto L_0x0040
            boolean r2 = r1.getSourceClosed$okio()     // Catch:{ all -> 0x00d8 }
            if (r2 == 0) goto L_0x0034
            okio.Buffer r2 = r1.getBuffer$okio()     // Catch:{ all -> 0x00d8 }
            long r2 = r2.size()     // Catch:{ all -> 0x00d8 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x002c
            goto L_0x0034
        L_0x002c:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "source is closed"
            r1.<init>(r2)     // Catch:{ all -> 0x00d8 }
            throw r1     // Catch:{ all -> 0x00d8 }
        L_0x0034:
            r2 = 1
            r1.setSinkClosed$okio(r2)     // Catch:{ all -> 0x00d8 }
            okio.Buffer r1 = r1.getBuffer$okio()     // Catch:{ all -> 0x00d8 }
            r1.notifyAll()     // Catch:{ all -> 0x00d8 }
            r2 = 0
        L_0x0040:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d8 }
            monitor-exit(r0)
            if (r2 != 0) goto L_0x0047
            goto L_0x00c7
        L_0x0047:
            okio.Pipe r0 = r12.this$0
            okio.Timeout r1 = r2.timeout()
            okio.Sink r0 = r0.sink()
            okio.Timeout r0 = r0.timeout()
            long r3 = r1.timeoutNanos()
            okio.Timeout$Companion r5 = okio.Timeout.Companion
            long r6 = r0.timeoutNanos()
            long r8 = r1.timeoutNanos()
            long r5 = r5.minTimeout(r6, r8)
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.timeout(r5, r7)
            boolean r5 = r1.hasDeadline()
            if (r5 == 0) goto L_0x00ab
            long r5 = r1.deadlineNanoTime()
            boolean r8 = r0.hasDeadline()
            if (r8 == 0) goto L_0x008b
            long r8 = r1.deadlineNanoTime()
            long r10 = r0.deadlineNanoTime()
            long r8 = java.lang.Math.min(r8, r10)
            r1.deadlineNanoTime(r8)
        L_0x008b:
            r2.close()     // Catch:{ all -> 0x009b }
            r1.timeout(r3, r7)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00c7
            r1.deadlineNanoTime(r5)
            goto L_0x00c7
        L_0x009b:
            r2 = move-exception
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.timeout(r3, r7)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00aa
            r1.deadlineNanoTime(r5)
        L_0x00aa:
            throw r2
        L_0x00ab:
            boolean r5 = r0.hasDeadline()
            if (r5 == 0) goto L_0x00b8
            long r5 = r0.deadlineNanoTime()
            r1.deadlineNanoTime(r5)
        L_0x00b8:
            r2.close()     // Catch:{ all -> 0x00c8 }
            r1.timeout(r3, r7)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00c7
            r1.clearDeadline()
        L_0x00c7:
            return
        L_0x00c8:
            r2 = move-exception
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.timeout(r3, r5)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00d7
            r1.clearDeadline()
        L_0x00d7:
            throw r2
        L_0x00d8:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.close():void");
    }

    public void flush() {
        Sink foldedSink$okio;
        Buffer buffer$okio = this.this$0.getBuffer$okio();
        Pipe pipe = this.this$0;
        synchronized (buffer$okio) {
            if (!(!pipe.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.getCanceled$okio()) {
                foldedSink$okio = pipe.getFoldedSink$okio();
                if (foldedSink$okio == null) {
                    if (pipe.getSourceClosed$okio()) {
                        if (pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    foldedSink$okio = null;
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IOException("canceled");
            }
        }
        if (foldedSink$okio != null) {
            Pipe pipe2 = this.this$0;
            Timeout timeout2 = foldedSink$okio.timeout();
            Timeout timeout3 = pipe2.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            timeout2.timeout(minTimeout, timeUnit);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    foldedSink$okio.flush();
                    timeout2.timeout(timeoutNanos, timeUnit);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                } catch (Throwable th2) {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                    throw th2;
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    foldedSink$okio.flush();
                    timeout2.timeout(timeoutNanos, timeUnit);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                } catch (Throwable th3) {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                    throw th3;
                }
            }
        }
    }

    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    public void write(@NotNull Buffer buffer, long j11) {
        Sink sink;
        Intrinsics.checkNotNullParameter(buffer, "source");
        Buffer buffer$okio = this.this$0.getBuffer$okio();
        Pipe pipe = this.this$0;
        synchronized (buffer$okio) {
            if (!(!pipe.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!pipe.getCanceled$okio()) {
                while (true) {
                    if (j11 <= 0) {
                        sink = null;
                        break;
                    }
                    sink = pipe.getFoldedSink$okio();
                    if (sink != null) {
                        break;
                    } else if (!pipe.getSourceClosed$okio()) {
                        long maxBufferSize$okio = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                        if (maxBufferSize$okio == 0) {
                            this.timeout.waitUntilNotified(pipe.getBuffer$okio());
                            if (pipe.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        } else {
                            long min = Math.min(maxBufferSize$okio, j11);
                            pipe.getBuffer$okio().write(buffer, min);
                            j11 -= min;
                            pipe.getBuffer$okio().notifyAll();
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IOException("canceled");
            }
        }
        if (sink != null) {
            Pipe pipe2 = this.this$0;
            Timeout timeout2 = sink.timeout();
            Timeout timeout3 = pipe2.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            timeout2.timeout(minTimeout, timeUnit);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    sink.write(buffer, j11);
                    timeout2.timeout(timeoutNanos, timeUnit);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                } catch (Throwable th2) {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                    throw th2;
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    sink.write(buffer, j11);
                    timeout2.timeout(timeoutNanos, timeUnit);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                } catch (Throwable th3) {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                    throw th3;
                }
            }
        }
    }
}
