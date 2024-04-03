package org.koin.core.time;

import com.tekartik.sqflite.Constant;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010\u0006\"\u0004\b\u0000\u0010\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0003¨\u0006\b"}, d2 = {"measureDuration", "", "code", "Lkotlin/Function0;", "", "measureDurationForResult", "Lkotlin/Pair;", "T", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class MeasureKt {
    public static final double measureDuration(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, Constant.PARAM_ERROR_CODE);
        TimeMark markNow = TimeSource.Monotonic.INSTANCE.markNow();
        function0.invoke();
        return Duration.toDouble-impl(markNow.m7752elapsedNowUwyO8pc(), TimeUnit.MILLISECONDS);
    }

    @NotNull
    public static final <T> Pair<T, Double> measureDurationForResult(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, Constant.PARAM_ERROR_CODE);
        TimedValue timedValue = new TimedValue(function0.invoke(), TimeSource.Monotonic.INSTANCE.markNow().m7752elapsedNowUwyO8pc(), (DefaultConstructorMarker) null);
        return new Pair<>(timedValue.getValue(), Double.valueOf(Duration.toDouble-impl(timedValue.m7778getDurationUwyO8pc(), TimeUnit.MILLISECONDS)));
    }
}
