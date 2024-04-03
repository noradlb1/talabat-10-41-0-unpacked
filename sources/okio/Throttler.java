package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ$\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\f\u0010\u0016\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$okio", "", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "take", "take$okio", "waitNanos", "nanosToWait", "bytesToNanos", "nanosToBytes", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j11) {
        this.allocatedUntil = j11;
        this.waitByteCount = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        this.maxByteCount = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j11, long j12, long j13, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j12 = throttler.waitByteCount;
        }
        long j14 = j12;
        if ((i11 & 4) != 0) {
            j13 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j11, j14, j13);
    }

    private final long bytesToNanos(long j11) {
        return (j11 * C.NANOS_PER_SECOND) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j11) {
        return (j11 * this.bytesPerSecond) / C.NANOS_PER_SECOND;
    }

    private final void waitNanos(long j11) {
        long j12 = j11 / 1000000;
        wait(j12, (int) (j11 - (1000000 * j12)));
    }

    public final long byteCountOrWaitNanos$okio(long j11, long j12) {
        if (this.bytesPerSecond == 0) {
            return j12;
        }
        long max = Math.max(this.allocatedUntil - j11, 0);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j12) {
            this.allocatedUntil = j11 + max + bytesToNanos(j12);
            return j12;
        }
        long j13 = this.waitByteCount;
        if (nanosToBytes >= j13) {
            this.allocatedUntil = j11 + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j13, j12);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos != 0) {
            return -bytesToNanos;
        }
        this.allocatedUntil = j11 + bytesToNanos(this.maxByteCount);
        return min;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j11) {
        bytesPerSecond$default(this, j11, 0, 0, 6, (Object) null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j11, long j12) {
        bytesPerSecond$default(this, j11, j12, 0, 4, (Object) null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long j11, long j12, long j13) {
        boolean z11;
        boolean z12;
        synchronized (this) {
            boolean z13 = true;
            if (j11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (j12 > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (j13 < j12) {
                        z13 = false;
                    }
                    if (z13) {
                        this.bytesPerSecond = j11;
                        this.waitByteCount = j12;
                        this.maxByteCount = j13;
                        notifyAll();
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new Throttler$sink$1(this, sink);
    }

    @NotNull
    public final Source source(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new Throttler$source$1(this, source);
    }

    public final long take$okio(long j11) {
        boolean z11;
        long byteCountOrWaitNanos$okio;
        if (j11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            synchronized (this) {
                while (true) {
                    byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j11);
                    if (byteCountOrWaitNanos$okio < 0) {
                        waitNanos(-byteCountOrWaitNanos$okio);
                    }
                }
            }
            return byteCountOrWaitNanos$okio;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
