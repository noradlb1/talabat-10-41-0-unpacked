package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0002ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0002ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\f\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalTime
public interface TimeMark {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static boolean hasNotPassedNow(@NotNull TimeMark timeMark) {
            return Duration.m7650isNegativeimpl(timeMark.m7752elapsedNowUwyO8pc());
        }

        public static boolean hasPassedNow(@NotNull TimeMark timeMark) {
            return !Duration.m7650isNegativeimpl(timeMark.m7752elapsedNowUwyO8pc());
        }

        @NotNull
        /* renamed from: minus-LRDsOJo  reason: not valid java name */
        public static TimeMark m7755minusLRDsOJo(@NotNull TimeMark timeMark, long j11) {
            return timeMark.m7754plusLRDsOJo(Duration.m7669unaryMinusUwyO8pc(j11));
        }

        @NotNull
        /* renamed from: plus-LRDsOJo  reason: not valid java name */
        public static TimeMark m7756plusLRDsOJo(@NotNull TimeMark timeMark, long j11) {
            return new AdjustedTimeMark(timeMark, j11, (DefaultConstructorMarker) null);
        }
    }

    /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
    long m7752elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    @NotNull
    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    TimeMark m7753minusLRDsOJo(long j11);

    @NotNull
    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    TimeMark m7754plusLRDsOJo(long j11);
}
