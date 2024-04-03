package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\bH\u0014J\u001b\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006R\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/Duration;", "duration", "", "overflow-LRDsOJo", "(J)V", "overflow", "", "b", "plusAssign-LRDsOJo", "plusAssign", "reading", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@SinceKotlin(version = "1.3")
@ExperimentalTime
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    /* renamed from: overflow-LRDsOJo  reason: not valid java name */
    private final void m7750overflowLRDsOJo(long j11) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + Duration.m7666toStringimpl(j11) + '.');
    }

    public long b() {
        return this.reading;
    }

    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    public final void m7751plusAssignLRDsOJo(long j11) {
        long j12;
        long r02 = Duration.m7663toLongimpl(j11, a());
        if (r02 == Long.MIN_VALUE || r02 == Long.MAX_VALUE) {
            double r22 = ((double) this.reading) + Duration.m7660toDoubleimpl(j11, a());
            if (r22 > 9.223372036854776E18d || r22 < -9.223372036854776E18d) {
                m7750overflowLRDsOJo(j11);
            }
            j12 = (long) r22;
        } else {
            long j13 = this.reading;
            j12 = j13 + r02;
            if ((r02 ^ j13) >= 0 && (j13 ^ j12) < 0) {
                m7750overflowLRDsOJo(j11);
            }
        }
        this.reading = j12;
    }
}
