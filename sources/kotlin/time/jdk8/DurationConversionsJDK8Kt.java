package kotlin.time.jdk8;

import j$.time.Duration;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.ExperimentalTime;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0000*\u00020\u0001H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, d2 = {"j$/time/Duration", "Lkotlin/time/Duration;", "toKotlinDuration", "(Lj$/time/Duration;)J", "toJavaDuration-LRDsOJo", "(J)Lj$/time/Duration;", "toJavaDuration", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 7, 1}, pn = "kotlin.time")
@JvmName(name = "DurationConversionsJDK8Kt")
public final class DurationConversionsJDK8Kt {
    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    /* renamed from: toJavaDuration-LRDsOJo  reason: not valid java name */
    private static final Duration m7779toJavaDurationLRDsOJo(long j11) {
        Duration ofSeconds = Duration.ofSeconds(kotlin.time.Duration.m7638getInWholeSecondsimpl(j11), (long) kotlin.time.Duration.m7640getNanosecondsComponentimpl(j11));
        Intrinsics.checkNotNullExpressionValue(ofSeconds, "toJavaDuration-LRDsOJo");
        return ofSeconds;
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    private static final long toKotlinDuration(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "<this>");
        return kotlin.time.Duration.m7653plusLRDsOJo(DurationKt.toDuration(duration.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration(duration.getNano(), DurationUnit.NANOSECONDS));
    }
}
