package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeMark;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H$J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u0007\u001a\u00020\u00068\u0004X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "", "b", "Lkotlin/time/TimeMark;", "markNow", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/DurationUnit;", "a", "()Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@ExperimentalTime
public abstract class AbstractLongTimeSource implements TimeSource {
    @NotNull
    private final DurationUnit unit;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/TimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LongTimeMark implements TimeMark {
        private final long offset;
        private final long startedAt;
        @NotNull
        private final AbstractLongTimeSource timeSource;

        private LongTimeMark(long j11, AbstractLongTimeSource abstractLongTimeSource, long j12) {
            this.startedAt = j11;
            this.timeSource = abstractLongTimeSource;
            this.offset = j12;
        }

        public /* synthetic */ LongTimeMark(long j11, AbstractLongTimeSource abstractLongTimeSource, long j12, DefaultConstructorMarker defaultConstructorMarker) {
            this(j11, abstractLongTimeSource, j12);
        }

        /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
        public long m7606elapsedNowUwyO8pc() {
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
        public TimeMark m7607minusLRDsOJo(long j11) {
            return TimeMark.DefaultImpls.m7755minusLRDsOJo(this, j11);
        }

        @NotNull
        /* renamed from: plus-LRDsOJo  reason: not valid java name */
        public TimeMark m7608plusLRDsOJo(long j11) {
            return new LongTimeMark(this.startedAt, this.timeSource, Duration.m7653plusLRDsOJo(this.offset, j11), (DefaultConstructorMarker) null);
        }
    }

    public AbstractLongTimeSource(@NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        this.unit = durationUnit;
    }

    @NotNull
    public final DurationUnit a() {
        return this.unit;
    }

    public abstract long b();

    @NotNull
    public TimeMark markNow() {
        return new LongTimeMark(b(), this, Duration.Companion.m7719getZEROUwyO8pc(), (DefaultConstructorMarker) null);
    }
}
