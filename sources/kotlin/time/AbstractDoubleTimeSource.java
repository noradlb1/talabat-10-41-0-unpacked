package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeMark;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H$J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u0007\u001a\u00020\u00068\u0004X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource;", "", "b", "Lkotlin/time/TimeMark;", "markNow", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/DurationUnit;", "a", "()Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "DoubleTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@ExperimentalTime
public abstract class AbstractDoubleTimeSource implements TimeSource {
    @NotNull
    private final DurationUnit unit;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/TimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DoubleTimeMark implements TimeMark {
        private final long offset;
        private final double startedAt;
        @NotNull
        private final AbstractDoubleTimeSource timeSource;

        private DoubleTimeMark(double d11, AbstractDoubleTimeSource abstractDoubleTimeSource, long j11) {
            this.startedAt = d11;
            this.timeSource = abstractDoubleTimeSource;
            this.offset = j11;
        }

        public /* synthetic */ DoubleTimeMark(double d11, AbstractDoubleTimeSource abstractDoubleTimeSource, long j11, DefaultConstructorMarker defaultConstructorMarker) {
            this(d11, abstractDoubleTimeSource, j11);
        }

        /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
        public long m7603elapsedNowUwyO8pc() {
            return Duration.m7652minusLRDsOJo(DurationKt.toDuration(this.timeSource.b() - this.startedAt, this.timeSource.a()), this.offset);
        }

        public boolean hasNotPassedNow() {
            return TimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        public boolean hasPassedNow() {
            return TimeMark.DefaultImpls.hasPassedNow(this);
        }

        @NotNull
        /* renamed from: minus-LRDsOJo  reason: not valid java name */
        public TimeMark m7604minusLRDsOJo(long j11) {
            return TimeMark.DefaultImpls.m7755minusLRDsOJo(this, j11);
        }

        @NotNull
        /* renamed from: plus-LRDsOJo  reason: not valid java name */
        public TimeMark m7605plusLRDsOJo(long j11) {
            return new DoubleTimeMark(this.startedAt, this.timeSource, Duration.m7653plusLRDsOJo(this.offset, j11), (DefaultConstructorMarker) null);
        }
    }

    public AbstractDoubleTimeSource(@NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        this.unit = durationUnit;
    }

    @NotNull
    public final DurationUnit a() {
        return this.unit;
    }

    public abstract double b();

    @NotNull
    public TimeMark markNow() {
        return new DoubleTimeMark(b(), this, Duration.Companion.m7719getZEROUwyO8pc(), (DefaultConstructorMarker) null);
    }
}
