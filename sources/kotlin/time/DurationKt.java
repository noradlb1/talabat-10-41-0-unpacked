package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\b\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\nø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\nø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007ø\u0001\u0000¢\u0006\u0002\u0010G\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007ø\u0001\u0000¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"!\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"!\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"!\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"!\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"!\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"!\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"!\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* access modifiers changed from: private */
    public static final long durationOf(long j11, int i11) {
        return Duration.m7617constructorimpl((j11 << 1) + ((long) i11));
    }

    /* access modifiers changed from: private */
    public static final long durationOfMillis(long j11) {
        return Duration.m7617constructorimpl((j11 << 1) + 1);
    }

    /* access modifiers changed from: private */
    public static final long durationOfMillisNormalized(long j11) {
        if (new LongRange(-4611686018426L, MAX_NANOS_IN_MILLIS).contains(j11)) {
            return durationOfNanos(millisToNanos(j11));
        }
        return durationOfMillis(RangesKt___RangesKt.coerceIn(j11, -4611686018427387903L, (long) MAX_MILLIS));
    }

    /* access modifiers changed from: private */
    public static final long durationOfNanos(long j11) {
        return Duration.m7617constructorimpl(j11 << 1);
    }

    /* access modifiers changed from: private */
    public static final long durationOfNanosNormalized(long j11) {
        if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(j11)) {
            return durationOfNanos(j11);
        }
        return durationOfMillis(nanosToMillis(j11));
    }

    public static final long getDays(int i11) {
        return toDuration(i11, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double d11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int i11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long j11) {
    }

    public static final long getHours(int i11) {
        return toDuration(i11, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double d11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int i11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long j11) {
    }

    public static final long getMicroseconds(int i11) {
        return toDuration(i11, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double d11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int i11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long j11) {
    }

    public static final long getMilliseconds(int i11) {
        return toDuration(i11, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double d11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int i11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long j11) {
    }

    public static final long getMinutes(int i11) {
        return toDuration(i11, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double d11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int i11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long j11) {
    }

    public static final long getNanoseconds(int i11) {
        return toDuration(i11, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double d11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int i11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long j11) {
    }

    public static final long getSeconds(int i11) {
        return toDuration(i11, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double d11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int i11) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long j11) {
    }

    /* access modifiers changed from: private */
    public static final long millisToNanos(long j11) {
        return j11 * ((long) 1000000);
    }

    /* access modifiers changed from: private */
    public static final long nanosToMillis(long j11) {
        return j11 / ((long) 1000000);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x00a6 A[EDGE_INSN: B:160:0x00a6->B:45:0x00a6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009a A[LOOP:1: B:33:0x006c->B:43:0x009a, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long parseDuration(java.lang.String r27, boolean r28) {
        /*
            r6 = r27
            int r7 = r27.length()
            if (r7 == 0) goto L_0x02cf
            kotlin.time.Duration$Companion r8 = kotlin.time.Duration.Companion
            long r9 = r8.m7719getZEROUwyO8pc()
            java.lang.String r2 = "Infinity"
            r11 = 0
            char r0 = r6.charAt(r11)
            r1 = 43
            r3 = 45
            r12 = 1
            if (r0 != r1) goto L_0x001e
        L_0x001c:
            r13 = r12
            goto L_0x0022
        L_0x001e:
            if (r0 != r3) goto L_0x0021
            goto L_0x001c
        L_0x0021:
            r13 = r11
        L_0x0022:
            if (r13 <= 0) goto L_0x0026
            r14 = r12
            goto L_0x0027
        L_0x0026:
            r14 = r11
        L_0x0027:
            r0 = 2
            r15 = 0
            if (r14 == 0) goto L_0x0034
            boolean r1 = kotlin.text.StringsKt__StringsKt.startsWith$default((java.lang.CharSequence) r6, (char) r3, (boolean) r11, (int) r0, (java.lang.Object) r15)
            if (r1 == 0) goto L_0x0034
            r16 = r12
            goto L_0x0036
        L_0x0034:
            r16 = r11
        L_0x0036:
            java.lang.String r5 = "No components"
            if (r7 <= r13) goto L_0x02c8
            char r1 = r6.charAt(r13)
            r3 = 80
            java.lang.String r4 = "this as java.lang.String).substring(startIndex)"
            r17 = r5
            java.lang.String r5 = "Unexpected order of duration components"
            r11 = 48
            java.lang.String r15 = "this as java.lang.String…ing(startIndex, endIndex)"
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            if (r1 != r3) goto L_0x015c
            int r13 = r13 + r12
            if (r13 == r7) goto L_0x0156
            r1 = 0
            r2 = 0
        L_0x0053:
            if (r13 >= r7) goto L_0x02bb
            char r3 = r6.charAt(r13)
            r8 = 84
            if (r3 != r8) goto L_0x006b
            if (r1 != 0) goto L_0x0065
            int r13 = r13 + 1
            if (r13 == r7) goto L_0x0065
            r1 = r12
            goto L_0x0053
        L_0x0065:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x006b:
            r3 = r13
        L_0x006c:
            int r8 = r27.length()
            if (r3 >= r8) goto L_0x00a2
            char r8 = r6.charAt(r3)
            kotlin.ranges.CharRange r14 = new kotlin.ranges.CharRange
            r12 = 57
            r14.<init>(r11, r12)
            boolean r14 = r14.contains((char) r8)
            if (r14 != 0) goto L_0x0093
            java.lang.String r14 = "+-."
            r18 = r7
            r7 = 0
            r11 = 0
            r12 = 2
            boolean r8 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r14, (char) r8, (boolean) r7, (int) r12, (java.lang.Object) r11)
            if (r8 == 0) goto L_0x0091
            goto L_0x0097
        L_0x0091:
            r7 = 0
            goto L_0x0098
        L_0x0093:
            r18 = r7
            r11 = 0
            r12 = 2
        L_0x0097:
            r7 = 1
        L_0x0098:
            if (r7 == 0) goto L_0x00a6
            int r3 = r3 + 1
            r7 = r18
            r11 = 48
            r12 = 1
            goto L_0x006c
        L_0x00a2:
            r18 = r7
            r11 = 0
            r12 = 2
        L_0x00a6:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)
            java.lang.String r3 = r6.substring(r13, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r15)
            int r7 = r3.length()
            if (r7 != 0) goto L_0x00b8
            r7 = 1
            goto L_0x00b9
        L_0x00b8:
            r7 = 0
        L_0x00b9:
            if (r7 != 0) goto L_0x0150
            int r7 = r3.length()
            int r13 = r13 + r7
            if (r13 < 0) goto L_0x0139
            int r7 = kotlin.text.StringsKt__StringsKt.getLastIndex(r27)
            if (r13 > r7) goto L_0x0139
            char r7 = r6.charAt(r13)
            int r13 = r13 + 1
            kotlin.time.DurationUnit r7 = kotlin.time.DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(r7, r1)
            if (r2 == 0) goto L_0x00e1
            int r2 = r2.compareTo(r7)
            if (r2 <= 0) goto L_0x00db
            goto L_0x00e1
        L_0x00db:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        L_0x00e1:
            r20 = 46
            r21 = 0
            r22 = 0
            r23 = 6
            r24 = 0
            r19 = r3
            int r2 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r19, (char) r20, (int) r21, (boolean) r22, (int) r23, (java.lang.Object) r24)
            kotlin.time.DurationUnit r8 = kotlin.time.DurationUnit.SECONDS
            if (r7 != r8) goto L_0x0125
            if (r2 <= 0) goto L_0x0125
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r0)
            r8 = 0
            java.lang.String r14 = r3.substring(r8, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)
            long r11 = parseOverLongIsoComponent(r14)
            long r11 = toDuration((long) r11, (kotlin.time.DurationUnit) r7)
            long r9 = kotlin.time.Duration.m7653plusLRDsOJo(r9, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r0)
            java.lang.String r2 = r3.substring(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            double r2 = java.lang.Double.parseDouble(r2)
            long r2 = toDuration((double) r2, (kotlin.time.DurationUnit) r7)
            long r9 = kotlin.time.Duration.m7653plusLRDsOJo(r9, r2)
            goto L_0x0131
        L_0x0125:
            long r2 = parseOverLongIsoComponent(r3)
            long r2 = toDuration((long) r2, (kotlin.time.DurationUnit) r7)
            long r9 = kotlin.time.Duration.m7653plusLRDsOJo(r9, r2)
        L_0x0131:
            r2 = r7
            r7 = r18
            r11 = 48
            r12 = 1
            goto L_0x0053
        L_0x0139:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Missing unit for value "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0150:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x0156:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x015c:
            r18 = r7
            if (r28 != 0) goto L_0x02c2
            r3 = 0
            int r7 = r18 - r13
            r1 = 8
            int r7 = java.lang.Math.max(r7, r1)
            r11 = 1
            r1 = r0
            r12 = 57
            r0 = r27
            r25 = r1
            r1 = r13
            r26 = r4
            r4 = r7
            r7 = r5
            r12 = r17
            r5 = r11
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.regionMatches((java.lang.String) r0, (int) r1, (java.lang.String) r2, (int) r3, (int) r4, (boolean) r5)
            if (r0 == 0) goto L_0x0185
            long r9 = r8.m7717getINFINITEUwyO8pc()
            goto L_0x02bb
        L_0x0185:
            r0 = r14 ^ 1
            if (r14 == 0) goto L_0x01a8
            char r1 = r6.charAt(r13)
            r2 = 40
            if (r1 != r2) goto L_0x01a8
            char r1 = kotlin.text.StringsKt___StringsKt.last(r27)
            r2 = 41
            if (r1 != r2) goto L_0x01a8
            int r13 = r13 + 1
            int r0 = r18 + -1
            if (r13 == r0) goto L_0x01a2
            r1 = r0
            r0 = 1
            goto L_0x01aa
        L_0x01a2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r12)
            throw r0
        L_0x01a8:
            r1 = r18
        L_0x01aa:
            r2 = 0
            r3 = 0
        L_0x01ac:
            if (r13 >= r1) goto L_0x02bb
            if (r2 == 0) goto L_0x01c8
            if (r0 == 0) goto L_0x01c8
        L_0x01b2:
            int r2 = r27.length()
            if (r13 >= r2) goto L_0x01c8
            char r2 = r6.charAt(r13)
            r4 = 32
            if (r2 != r4) goto L_0x01c2
            r2 = 1
            goto L_0x01c3
        L_0x01c2:
            r2 = 0
        L_0x01c3:
            if (r2 == 0) goto L_0x01c8
            int r13 = r13 + 1
            goto L_0x01b2
        L_0x01c8:
            r2 = r13
        L_0x01c9:
            int r4 = r27.length()
            if (r2 >= r4) goto L_0x01ef
            char r4 = r6.charAt(r2)
            kotlin.ranges.CharRange r5 = new kotlin.ranges.CharRange
            r8 = 57
            r11 = 48
            r5.<init>(r11, r8)
            boolean r5 = r5.contains((char) r4)
            if (r5 != 0) goto L_0x01e9
            r5 = 46
            if (r4 != r5) goto L_0x01e7
            goto L_0x01e9
        L_0x01e7:
            r4 = 0
            goto L_0x01ea
        L_0x01e9:
            r4 = 1
        L_0x01ea:
            if (r4 == 0) goto L_0x01f3
            int r2 = r2 + 1
            goto L_0x01c9
        L_0x01ef:
            r8 = 57
            r11 = 48
        L_0x01f3:
            r4 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r4)
            java.lang.String r2 = r6.substring(r13, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)
            int r5 = r2.length()
            if (r5 != 0) goto L_0x0207
            r5 = 1
            goto L_0x0208
        L_0x0207:
            r5 = 0
        L_0x0208:
            if (r5 != 0) goto L_0x02b5
            int r5 = r2.length()
            int r13 = r13 + r5
            r5 = r13
        L_0x0210:
            int r12 = r27.length()
            if (r5 >= r12) goto L_0x0230
            char r12 = r6.charAt(r5)
            kotlin.ranges.CharRange r14 = new kotlin.ranges.CharRange
            r8 = 97
            r11 = 122(0x7a, float:1.71E-43)
            r14.<init>(r8, r11)
            boolean r8 = r14.contains((char) r12)
            if (r8 == 0) goto L_0x0230
            int r5 = r5 + 1
            r8 = 57
            r11 = 48
            goto L_0x0210
        L_0x0230:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r4)
            java.lang.String r5 = r6.substring(r13, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r15)
            int r8 = r5.length()
            int r13 = r13 + r8
            kotlin.time.DurationUnit r5 = kotlin.time.DurationUnitKt__DurationUnitKt.durationUnitByShortName(r5)
            if (r3 == 0) goto L_0x0252
            int r3 = r3.compareTo(r5)
            if (r3 <= 0) goto L_0x024c
            goto L_0x0252
        L_0x024c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x0252:
            r20 = 46
            r21 = 0
            r22 = 0
            r23 = 6
            r24 = 0
            r19 = r2
            int r3 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r19, (char) r20, (int) r21, (boolean) r22, (int) r23, (java.lang.Object) r24)
            if (r3 <= 0) goto L_0x02a0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r4)
            r8 = 0
            java.lang.String r11 = r2.substring(r8, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r15)
            long r11 = java.lang.Long.parseLong(r11)
            long r11 = toDuration((long) r11, (kotlin.time.DurationUnit) r5)
            long r9 = kotlin.time.Duration.m7653plusLRDsOJo(r9, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r4)
            java.lang.String r2 = r2.substring(r3)
            r3 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            double r11 = java.lang.Double.parseDouble(r2)
            long r11 = toDuration((double) r11, (kotlin.time.DurationUnit) r5)
            long r9 = kotlin.time.Duration.m7653plusLRDsOJo(r9, r11)
            if (r13 < r1) goto L_0x0298
            r26 = r3
            goto L_0x02af
        L_0x0298:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Fractional component must be last"
            r0.<init>(r1)
            throw r0
        L_0x02a0:
            r3 = r26
            r8 = 0
            long r11 = java.lang.Long.parseLong(r2)
            long r11 = toDuration((long) r11, (kotlin.time.DurationUnit) r5)
            long r9 = kotlin.time.Duration.m7653plusLRDsOJo(r9, r11)
        L_0x02af:
            r25 = r4
            r3 = r5
            r2 = 1
            goto L_0x01ac
        L_0x02b5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x02bb:
            if (r16 == 0) goto L_0x02c1
            long r9 = kotlin.time.Duration.m7669unaryMinusUwyO8pc(r9)
        L_0x02c1:
            return r9
        L_0x02c2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x02c8:
            r12 = r5
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r12)
            throw r0
        L_0x02cf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The string is empty"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.parseDuration(java.lang.String, boolean):long");
    }

    private static final long parseOverLongIsoComponent(String str) {
        int i11;
        boolean z11;
        int length = str.length();
        if (length <= 0 || !StringsKt__StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null)) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        if (length - i11 > 16) {
            IntRange intRange = new IntRange(i11, StringsKt__StringsKt.getLastIndex(str));
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator it = intRange.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (!new CharRange('0', '9').contains(str.charAt(((IntIterator) it).nextInt()))) {
                        z11 = false;
                        break;
                    }
                }
            }
            z11 = true;
            if (z11) {
                if (str.charAt(0) == '-') {
                    return Long.MIN_VALUE;
                }
                return Long.MAX_VALUE;
            }
        }
        if (StringsKt__StringsJVMKt.startsWith$default(str, "+", false, 2, (Object) null)) {
            str = StringsKt___StringsKt.drop(str, 1);
        }
        return Long.parseLong(str);
    }

    private static final int skipWhile(String str, int i11, Function1<? super Character, Boolean> function1) {
        while (i11 < str.length() && function1.invoke(Character.valueOf(str.charAt(i11))).booleanValue()) {
            i11++;
        }
        return i11;
    }

    private static final String substringWhile(String str, int i11, Function1<? super Character, Boolean> function1) {
        int i12 = i11;
        while (i12 < str.length() && function1.invoke(Character.valueOf(str.charAt(i12))).booleanValue()) {
            i12++;
        }
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i11, i12);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    /* renamed from: times-kIfJnKk  reason: not valid java name */
    private static final long m7742timeskIfJnKk(double d11, long j11) {
        return Duration.m7654timesUwyO8pc(j11, d11);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    /* renamed from: times-mvk6XK0  reason: not valid java name */
    private static final long m7743timesmvk6XK0(int i11, long j11) {
        return Duration.m7655timesUwyO8pc(j11, i11);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(int i11, @NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (durationUnit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow((long) i11, durationUnit, DurationUnit.NANOSECONDS));
        }
        return toDuration((long) i11, durationUnit);
    }

    public static final long getDays(long j11) {
        return toDuration(j11, DurationUnit.DAYS);
    }

    public static final long getHours(long j11) {
        return toDuration(j11, DurationUnit.HOURS);
    }

    public static final long getMicroseconds(long j11) {
        return toDuration(j11, DurationUnit.MICROSECONDS);
    }

    public static final long getMilliseconds(long j11) {
        return toDuration(j11, DurationUnit.MILLISECONDS);
    }

    public static final long getMinutes(long j11) {
        return toDuration(j11, DurationUnit.MINUTES);
    }

    public static final long getNanoseconds(long j11) {
        return toDuration(j11, DurationUnit.NANOSECONDS);
    }

    public static final long getSeconds(long j11) {
        return toDuration(j11, DurationUnit.SECONDS);
    }

    public static final long getDays(double d11) {
        return toDuration(d11, DurationUnit.DAYS);
    }

    public static final long getHours(double d11) {
        return toDuration(d11, DurationUnit.HOURS);
    }

    public static final long getMicroseconds(double d11) {
        return toDuration(d11, DurationUnit.MICROSECONDS);
    }

    public static final long getMilliseconds(double d11) {
        return toDuration(d11, DurationUnit.MILLISECONDS);
    }

    public static final long getMinutes(double d11) {
        return toDuration(d11, DurationUnit.MINUTES);
    }

    public static final long getNanoseconds(double d11) {
        return toDuration(d11, DurationUnit.NANOSECONDS);
    }

    public static final long getSeconds(double d11) {
        return toDuration(d11, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(long j11, @NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        long convertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, durationUnit2, durationUnit);
        if (new LongRange(-convertDurationUnitOverflow, convertDurationUnitOverflow).contains(j11)) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j11, durationUnit, durationUnit2));
        }
        return durationOfMillis(RangesKt___RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j11, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, (long) MAX_MILLIS));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(double d11, @NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        double convertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d11, durationUnit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(convertDurationUnit)) {
            long roundToLong = MathKt__MathJVMKt.roundToLong(convertDurationUnit);
            if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(roundToLong)) {
                return durationOfNanos(roundToLong);
            }
            return durationOfMillisNormalized(MathKt__MathJVMKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d11, durationUnit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }
}
