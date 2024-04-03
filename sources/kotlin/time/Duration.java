package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmInline
@SinceKotlin(version = "1.6")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b@\u0018\u0000 ¤\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¤\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001b\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u001b\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001a\u0010T\u001a\u00020U2\b\u0010J\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bZ\u0010\rJ\r\u0010[\u001a\u00020U¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002¢\u0006\u0004\b_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002¢\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020U¢\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020U¢\u0006\u0004\be\u0010]J\r\u0010f\u001a\u00020U¢\u0006\u0004\bg\u0010]J\u001b\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bi\u0010jJ\u001b\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bl\u0010jJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bn\u0010PJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bn\u0010QJ\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0rH\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010{J\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0|H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0~H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010J`\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0\u0001H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0005\bz\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u00020=¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020=¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020=¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0001\u0010\u0005J\u0011\u0010\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0001\u0010\u0005J\u0013\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020=2\t\b\u0002\u0010\u0001\u001a\u00020\t¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u0005JK\u0010\u0001\u001a\u00030\u0001*\b0\u0001j\u0003`\u00012\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010 \u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010¡\u0001\u001a\u00020UH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020\t8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b20\u0001¨\u0006¥\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
public final class Duration implements Comparable<Duration> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long INFINITE = DurationKt.durationOfMillis(DurationKt.MAX_MILLIS);
    /* access modifiers changed from: private */
    public static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);
    /* access modifiers changed from: private */
    public static final long ZERO = m7617constructorimpl(0);
    private final long rawValue;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0011J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0014J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0011J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0014J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0014J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0017J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0011J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0014J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0017J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0014J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0017J\u001b\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u00108J\u001b\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b<J\u001b\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b>J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0011J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0014J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0017R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R%\u0010\f\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\f\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R%\u0010\f\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R%\u0010\u0018\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0014R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R%\u0010\u001b\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R%\u0010\u001e\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0014R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R%\u0010!\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R%\u0010!\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0014R%\u0010!\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R%\u0010$\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R%\u0010$\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0014R%\u0010$\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0017R%\u0010'\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R%\u0010'\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0014R%\u0010'\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0017\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006@"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m7673getDaysUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.DAYS);
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7675getDaysUwyO8pc$annotations(double d11) {
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7676getDaysUwyO8pc$annotations(int i11) {
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7677getDaysUwyO8pc$annotations(long j11) {
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m7679getHoursUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.HOURS);
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7681getHoursUwyO8pc$annotations(double d11) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7682getHoursUwyO8pc$annotations(int i11) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7683getHoursUwyO8pc$annotations(long j11) {
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m7685getMicrosecondsUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7687getMicrosecondsUwyO8pc$annotations(double d11) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7688getMicrosecondsUwyO8pc$annotations(int i11) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7689getMicrosecondsUwyO8pc$annotations(long j11) {
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m7691getMillisecondsUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7693getMillisecondsUwyO8pc$annotations(double d11) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7694getMillisecondsUwyO8pc$annotations(int i11) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7695getMillisecondsUwyO8pc$annotations(long j11) {
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m7697getMinutesUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7699getMinutesUwyO8pc$annotations(double d11) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7700getMinutesUwyO8pc$annotations(int i11) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7701getMinutesUwyO8pc$annotations(long j11) {
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m7703getNanosecondsUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7705getNanosecondsUwyO8pc$annotations(double d11) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7706getNanosecondsUwyO8pc$annotations(int i11) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7707getNanosecondsUwyO8pc$annotations(long j11) {
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m7709getSecondsUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7711getSecondsUwyO8pc$annotations(double d11) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7712getSecondsUwyO8pc$annotations(int i11) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m7713getSecondsUwyO8pc$annotations(long j11) {
        }

        @ExperimentalTime
        public final double convert(double d11, @NotNull DurationUnit durationUnit, @NotNull DurationUnit durationUnit2) {
            Intrinsics.checkNotNullParameter(durationUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(durationUnit2, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d11, durationUnit, durationUnit2);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @ExperimentalTime
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m7715daysUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.DAYS);
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m7717getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m7718getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m7719getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m7721hoursUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m7724microsecondsUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m7727millisecondsUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m7730minutesUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m7733nanosecondsUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.NANOSECONDS);
        }

        /* renamed from: parse-UwyO8pc  reason: not valid java name */
        public final long m7735parseUwyO8pc(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                return DurationKt.parseDuration(str, false);
            } catch (IllegalArgumentException e11) {
                throw new IllegalArgumentException("Invalid duration string format: '" + str + "'.", e11);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc  reason: not valid java name */
        public final long m7736parseIsoStringUwyO8pc(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                return DurationKt.parseDuration(str, true);
            } catch (IllegalArgumentException e11) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + str + "'.", e11);
            }
        }

        @Nullable
        /* renamed from: parseIsoStringOrNull-FghU774  reason: not valid java name */
        public final Duration m7737parseIsoStringOrNullFghU774(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                return Duration.m7615boximpl(DurationKt.parseDuration(str, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Nullable
        /* renamed from: parseOrNull-FghU774  reason: not valid java name */
        public final Duration m7738parseOrNullFghU774(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                return Duration.m7615boximpl(DurationKt.parseDuration(str, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m7740secondsUwyO8pc(int i11) {
            return DurationKt.toDuration(i11, DurationUnit.SECONDS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m7674getDaysUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.DAYS);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m7680getHoursUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.HOURS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m7686getMicrosecondsUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m7692getMillisecondsUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m7698getMinutesUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.MINUTES);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m7704getNanosecondsUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m7710getSecondsUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @ExperimentalTime
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m7716daysUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m7722hoursUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m7725microsecondsUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m7728millisecondsUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m7731minutesUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m7734nanosecondsUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m7741secondsUwyO8pc(long j11) {
            return DurationKt.toDuration(j11, DurationUnit.SECONDS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m7672getDaysUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.DAYS);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m7678getHoursUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.HOURS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m7684getMicrosecondsUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m7690getMillisecondsUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m7696getMinutesUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.MINUTES);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m7702getNanosecondsUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m7708getSecondsUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @ExperimentalTime
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m7714daysUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m7720hoursUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m7723microsecondsUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m7726millisecondsUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m7729minutesUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m7732nanosecondsUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m7739secondsUwyO8pc(double d11) {
            return DurationKt.toDuration(d11, DurationUnit.SECONDS);
        }
    }

    private /* synthetic */ Duration(long j11) {
        this.rawValue = j11;
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc  reason: not valid java name */
    private static final long m7613addValuesMixedRangesUwyO8pc(long j11, long j12, long j13) {
        long access$nanosToMillis = DurationKt.nanosToMillis(j13);
        long j14 = j12 + access$nanosToMillis;
        if (!new LongRange(-4611686018426L, 4611686018426L).contains(j14)) {
            return DurationKt.durationOfMillis(RangesKt___RangesKt.coerceIn(j14, -4611686018427387903L, (long) DurationKt.MAX_MILLIS));
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(j14) + (j13 - DurationKt.millisToNanos(access$nanosToMillis)));
    }

    /* renamed from: appendFractional-impl  reason: not valid java name */
    private static final void m7614appendFractionalimpl(long j11, StringBuilder sb2, int i11, int i12, int i13, String str, boolean z11) {
        boolean z12;
        sb2.append(i11);
        if (i12 != 0) {
            sb2.append('.');
            String padStart = StringsKt__StringsKt.padStart(String.valueOf(i12), i13, '0');
            int i14 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i15 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        i14 = length;
                        break;
                    } else if (i15 < 0) {
                        break;
                    } else {
                        length = i15;
                    }
                }
            }
            int i16 = i14 + 1;
            if (z11 || i16 >= 3) {
                sb2.append(padStart, 0, ((i16 + 2) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb2, "this.append(value, startIndex, endIndex)");
            } else {
                sb2.append(padStart, 0, i16);
                Intrinsics.checkNotNullExpressionValue(sb2, "this.append(value, startIndex, endIndex)");
            }
        }
        sb2.append(str);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m7615boximpl(long j11) {
        return new Duration(j11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m7617constructorimpl(long j11) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m7648isInNanosimpl(j11)) {
                if (!new LongRange(-4611686018426999999L, DurationKt.MAX_NANOS).contains(m7644getValueimpl(j11))) {
                    throw new AssertionError(m7644getValueimpl(j11) + " ns is out of nanoseconds range");
                }
            } else if (!new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS).contains(m7644getValueimpl(j11))) {
                throw new AssertionError(m7644getValueimpl(j11) + " ms is out of milliseconds range");
            } else if (new LongRange(-4611686018426L, 4611686018426L).contains(m7644getValueimpl(j11))) {
                throw new AssertionError(m7644getValueimpl(j11) + " ms is denormalized");
            }
        }
        return j11;
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m7618divLRDsOJo(long j11, long j12) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt___ComparisonsJvmKt.maxOf(m7642getStorageUnitimpl(j11), m7642getStorageUnitimpl(j12));
        return m7660toDoubleimpl(j11, durationUnit) / m7660toDoubleimpl(j12, durationUnit);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m7620divUwyO8pc(long j11, int i11) {
        if (i11 == 0) {
            if (m7651isPositiveimpl(j11)) {
                return INFINITE;
            }
            if (m7650isNegativeimpl(j11)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m7648isInNanosimpl(j11)) {
            return DurationKt.durationOfNanos(m7644getValueimpl(j11) / ((long) i11));
        } else {
            if (m7649isInfiniteimpl(j11)) {
                return m7655timesUwyO8pc(j11, MathKt__MathJVMKt.getSign(i11));
            }
            long j12 = (long) i11;
            long r02 = m7644getValueimpl(j11) / j12;
            if (!new LongRange(-4611686018426L, 4611686018426L).contains(r02)) {
                return DurationKt.durationOfMillis(r02);
            }
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(r02) + (DurationKt.millisToNanos(m7644getValueimpl(j11) - (r02 * j12)) / j12));
        }
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7621equalsimpl(long j11, Object obj) {
        return (obj instanceof Duration) && j11 == ((Duration) obj).m7671unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7622equalsimpl0(long j11, long j12) {
        return j11 == j12;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m7623getAbsoluteValueUwyO8pc(long j11) {
        return m7650isNegativeimpl(j11) ? m7669unaryMinusUwyO8pc(j11) : j11;
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m7624getHoursComponentimpl(long j11) {
        if (m7649isInfiniteimpl(j11)) {
            return 0;
        }
        return (int) (m7633getInWholeHoursimpl(j11) % ((long) 24));
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInDays$annotations() {
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m7625getInDaysimpl(long j11) {
        return m7660toDoubleimpl(j11, DurationUnit.DAYS);
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInHours$annotations() {
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m7626getInHoursimpl(long j11) {
        return m7660toDoubleimpl(j11, DurationUnit.HOURS);
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m7627getInMicrosecondsimpl(long j11) {
        return m7660toDoubleimpl(j11, DurationUnit.MICROSECONDS);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m7628getInMillisecondsimpl(long j11) {
        return m7660toDoubleimpl(j11, DurationUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m7629getInMinutesimpl(long j11) {
        return m7660toDoubleimpl(j11, DurationUnit.MINUTES);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m7630getInNanosecondsimpl(long j11) {
        return m7660toDoubleimpl(j11, DurationUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m7631getInSecondsimpl(long j11) {
        return m7660toDoubleimpl(j11, DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m7632getInWholeDaysimpl(long j11) {
        return m7663toLongimpl(j11, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m7633getInWholeHoursimpl(long j11) {
        return m7663toLongimpl(j11, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMicroseconds-impl  reason: not valid java name */
    public static final long m7634getInWholeMicrosecondsimpl(long j11) {
        return m7663toLongimpl(j11, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl  reason: not valid java name */
    public static final long m7635getInWholeMillisecondsimpl(long j11) {
        return (!m7647isInMillisimpl(j11) || !m7646isFiniteimpl(j11)) ? m7663toLongimpl(j11, DurationUnit.MILLISECONDS) : m7644getValueimpl(j11);
    }

    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m7636getInWholeMinutesimpl(long j11) {
        return m7663toLongimpl(j11, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeNanoseconds-impl  reason: not valid java name */
    public static final long m7637getInWholeNanosecondsimpl(long j11) {
        long r02 = m7644getValueimpl(j11);
        if (m7648isInNanosimpl(j11)) {
            return r02;
        }
        if (r02 > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (r02 < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.millisToNanos(r02);
    }

    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m7638getInWholeSecondsimpl(long j11) {
        return m7663toLongimpl(j11, DurationUnit.SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m7639getMinutesComponentimpl(long j11) {
        if (m7649isInfiniteimpl(j11)) {
            return 0;
        }
        return (int) (m7636getInWholeMinutesimpl(j11) % ((long) 60));
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m7640getNanosecondsComponentimpl(long j11) {
        long j12;
        if (m7649isInfiniteimpl(j11)) {
            return 0;
        }
        if (m7647isInMillisimpl(j11)) {
            j12 = DurationKt.millisToNanos(m7644getValueimpl(j11) % ((long) 1000));
        } else {
            j12 = m7644getValueimpl(j11) % ((long) 1000000000);
        }
        return (int) j12;
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m7641getSecondsComponentimpl(long j11) {
        if (m7649isInfiniteimpl(j11)) {
            return 0;
        }
        return (int) (m7638getInWholeSecondsimpl(j11) % ((long) 60));
    }

    /* renamed from: getStorageUnit-impl  reason: not valid java name */
    private static final DurationUnit m7642getStorageUnitimpl(long j11) {
        return m7648isInNanosimpl(j11) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* renamed from: getUnitDiscriminator-impl  reason: not valid java name */
    private static final int m7643getUnitDiscriminatorimpl(long j11) {
        return ((int) j11) & 1;
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    private static final long m7644getValueimpl(long j11) {
        return j11 >> 1;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7645hashCodeimpl(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m7646isFiniteimpl(long j11) {
        return !m7649isInfiniteimpl(j11);
    }

    /* renamed from: isInMillis-impl  reason: not valid java name */
    private static final boolean m7647isInMillisimpl(long j11) {
        return (((int) j11) & 1) == 1;
    }

    /* renamed from: isInNanos-impl  reason: not valid java name */
    private static final boolean m7648isInNanosimpl(long j11) {
        return (((int) j11) & 1) == 0;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m7649isInfiniteimpl(long j11) {
        return j11 == INFINITE || j11 == NEG_INFINITE;
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m7650isNegativeimpl(long j11) {
        return j11 < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m7651isPositiveimpl(long j11) {
        return j11 > 0;
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final long m7652minusLRDsOJo(long j11, long j12) {
        return m7653plusLRDsOJo(j11, m7669unaryMinusUwyO8pc(j12));
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m7653plusLRDsOJo(long j11, long j12) {
        if (m7649isInfiniteimpl(j11)) {
            if (m7646isFiniteimpl(j12) || (j12 ^ j11) >= 0) {
                return j11;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m7649isInfiniteimpl(j12)) {
            return j12;
        } else {
            if ((((int) j11) & 1) == (((int) j12) & 1)) {
                long r02 = m7644getValueimpl(j11) + m7644getValueimpl(j12);
                if (m7648isInNanosimpl(j11)) {
                    return DurationKt.durationOfNanosNormalized(r02);
                }
                return DurationKt.durationOfMillisNormalized(r02);
            } else if (m7647isInMillisimpl(j11)) {
                return m7613addValuesMixedRangesUwyO8pc(j11, m7644getValueimpl(j11), m7644getValueimpl(j12));
            } else {
                return m7613addValuesMixedRangesUwyO8pc(j11, m7644getValueimpl(j12), m7644getValueimpl(j11));
            }
        }
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m7655timesUwyO8pc(long j11, int i11) {
        int i12 = i11;
        if (m7649isInfiniteimpl(j11)) {
            if (i12 == 0) {
                throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
            } else if (i12 > 0) {
                return j11;
            } else {
                return m7669unaryMinusUwyO8pc(j11);
            }
        } else if (i12 == 0) {
            return ZERO;
        } else {
            long r12 = m7644getValueimpl(j11);
            long j12 = (long) i12;
            long j13 = r12 * j12;
            if (m7648isInNanosimpl(j11)) {
                if (new LongRange(-2147483647L, 2147483647L).contains(r12)) {
                    return DurationKt.durationOfNanos(j13);
                }
                if (j13 / j12 == r12) {
                    return DurationKt.durationOfNanosNormalized(j13);
                }
                long access$nanosToMillis = DurationKt.nanosToMillis(r12);
                long j14 = access$nanosToMillis * j12;
                long access$nanosToMillis2 = DurationKt.nanosToMillis((r12 - DurationKt.millisToNanos(access$nanosToMillis)) * j12) + j14;
                if (j14 / j12 != access$nanosToMillis || (access$nanosToMillis2 ^ j14) < 0) {
                    return MathKt__MathJVMKt.getSign(r12) * MathKt__MathJVMKt.getSign(i11) > 0 ? INFINITE : NEG_INFINITE;
                }
                return DurationKt.durationOfMillis(RangesKt___RangesKt.coerceIn(access$nanosToMillis2, (ClosedRange<Long>) new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            } else if (j13 / j12 == r12) {
                return DurationKt.durationOfMillis(RangesKt___RangesKt.coerceIn(j13, (ClosedRange<Long>) new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            } else {
                return MathKt__MathJVMKt.getSign(r12) * MathKt__MathJVMKt.getSign(i11) > 0 ? INFINITE : NEG_INFINITE;
            }
        }
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m7659toComponentsimpl(long j11, @NotNull Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkNotNullParameter(function5, NativeProtocol.WEB_DIALOG_ACTION);
        return function5.invoke(Long.valueOf(m7632getInWholeDaysimpl(j11)), Integer.valueOf(m7624getHoursComponentimpl(j11)), Integer.valueOf(m7639getMinutesComponentimpl(j11)), Integer.valueOf(m7641getSecondsComponentimpl(j11)), Integer.valueOf(m7640getNanosecondsComponentimpl(j11)));
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m7660toDoubleimpl(long j11, @NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (j11 == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j11 == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit((double) m7644getValueimpl(j11), m7642getStorageUnitimpl(j11), durationUnit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m7661toIntimpl(long j11, @NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        return (int) RangesKt___RangesKt.coerceIn(m7663toLongimpl(j11, durationUnit), -2147483648L, 2147483647L);
    }

    @NotNull
    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m7662toIsoStringimpl(long j11) {
        boolean z11;
        boolean z12;
        StringBuilder sb2 = new StringBuilder();
        if (m7650isNegativeimpl(j11)) {
            sb2.append(SignatureVisitor.SUPER);
        }
        sb2.append("PT");
        long r02 = m7623getAbsoluteValueUwyO8pc(j11);
        long r22 = m7633getInWholeHoursimpl(r02);
        int r42 = m7639getMinutesComponentimpl(r02);
        int r52 = m7641getSecondsComponentimpl(r02);
        int r62 = m7640getNanosecondsComponentimpl(r02);
        if (m7649isInfiniteimpl(j11)) {
            r22 = 9999999999999L;
        }
        boolean z13 = true;
        if (r22 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (r52 == 0 && r62 == 0) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (r42 == 0 && (!z12 || !z11)) {
            z13 = false;
        }
        if (z11) {
            sb2.append(r22);
            sb2.append('H');
        }
        if (z13) {
            sb2.append(r42);
            sb2.append('M');
        }
        if (z12 || (!z11 && !z13)) {
            m7614appendFractionalimpl(j11, sb2, r52, r62, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m7663toLongimpl(long j11, @NotNull DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (j11 == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j11 == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m7644getValueimpl(j11), m7642getStorageUnitimpl(j11), durationUnit);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @ExperimentalTime
    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m7664toLongMillisecondsimpl(long j11) {
        return m7635getInWholeMillisecondsimpl(j11);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @ExperimentalTime
    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m7665toLongNanosecondsimpl(long j11) {
        return m7637getInWholeNanosecondsimpl(j11);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7666toStringimpl(long j11) {
        if (j11 == 0) {
            return "0s";
        }
        if (j11 == INFINITE) {
            return "Infinity";
        }
        if (j11 == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean r22 = m7650isNegativeimpl(j11);
        StringBuilder sb2 = new StringBuilder();
        if (r22) {
            sb2.append(SignatureVisitor.SUPER);
        }
        long r32 = m7623getAbsoluteValueUwyO8pc(j11);
        long r52 = m7632getInWholeDaysimpl(r32);
        int r72 = m7624getHoursComponentimpl(r32);
        int r82 = m7639getMinutesComponentimpl(r32);
        int r92 = m7641getSecondsComponentimpl(r32);
        int r102 = m7640getNanosecondsComponentimpl(r32);
        int i11 = 0;
        boolean z11 = r52 != 0;
        boolean z12 = r72 != 0;
        boolean z13 = r82 != 0;
        boolean z14 = (r92 == 0 && r102 == 0) ? false : true;
        if (z11) {
            sb2.append(r52);
            sb2.append(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL);
            i11 = 1;
        }
        if (z12 || (z11 && (z13 || z14))) {
            int i12 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(r72);
            sb2.append('h');
            i11 = i12;
        }
        if (z13 || (z14 && (z12 || z11))) {
            int i13 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(r82);
            sb2.append(Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL);
            i11 = i13;
        }
        if (z14) {
            int i14 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            if (r92 != 0 || z11 || z12 || z13) {
                m7614appendFractionalimpl(j11, sb2, r92, r102, 9, "s", false);
            } else if (r102 >= 1000000) {
                m7614appendFractionalimpl(j11, sb2, r102 / 1000000, r102 % 1000000, 6, "ms", false);
            } else if (r102 >= 1000) {
                m7614appendFractionalimpl(j11, sb2, r102 / 1000, r102 % 1000, 3, "us", false);
            } else {
                sb2.append(r102);
                sb2.append("ns");
            }
            i11 = i14;
        }
        if (r22 && i11 > 1) {
            sb2.insert(1, '(').append(')');
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m7668toStringimpl$default(long j11, DurationUnit durationUnit, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return m7667toStringimpl(j11, durationUnit, i11);
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m7669unaryMinusUwyO8pc(long j11) {
        return DurationKt.durationOf(-m7644getValueimpl(j11), ((int) j11) & 1);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m7670compareToLRDsOJo(((Duration) obj).m7671unboximpl());
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m7670compareToLRDsOJo(long j11) {
        return m7616compareToLRDsOJo(this.rawValue, j11);
    }

    public boolean equals(Object obj) {
        return m7621equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m7645hashCodeimpl(this.rawValue);
    }

    @NotNull
    public String toString() {
        return m7666toStringimpl(this.rawValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m7671unboximpl() {
        return this.rawValue;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m7616compareToLRDsOJo(long j11, long j12) {
        long j13 = j11 ^ j12;
        if (j13 < 0 || (((int) j13) & 1) == 0) {
            return Intrinsics.compare(j11, j12);
        }
        int i11 = (((int) j11) & 1) - (((int) j12) & 1);
        return m7650isNegativeimpl(j11) ? -i11 : i11;
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m7658toComponentsimpl(long j11, @NotNull Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.checkNotNullParameter(function4, NativeProtocol.WEB_DIALOG_ACTION);
        return function4.invoke(Long.valueOf(m7633getInWholeHoursimpl(j11)), Integer.valueOf(m7639getMinutesComponentimpl(j11)), Integer.valueOf(m7641getSecondsComponentimpl(j11)), Integer.valueOf(m7640getNanosecondsComponentimpl(j11)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m7657toComponentsimpl(long j11, @NotNull Function3<? super Long, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.checkNotNullParameter(function3, NativeProtocol.WEB_DIALOG_ACTION);
        return function3.invoke(Long.valueOf(m7636getInWholeMinutesimpl(j11)), Integer.valueOf(m7641getSecondsComponentimpl(j11)), Integer.valueOf(m7640getNanosecondsComponentimpl(j11)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m7656toComponentsimpl(long j11, @NotNull Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, NativeProtocol.WEB_DIALOG_ACTION);
        return function2.invoke(Long.valueOf(m7638getInWholeSecondsimpl(j11)), Integer.valueOf(m7640getNanosecondsComponentimpl(j11)));
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m7619divUwyO8pc(long j11, double d11) {
        int roundToInt = MathKt__MathJVMKt.roundToInt(d11);
        if ((((double) roundToInt) == d11) && roundToInt != 0) {
            return m7620divUwyO8pc(j11, roundToInt);
        }
        DurationUnit r02 = m7642getStorageUnitimpl(j11);
        return DurationKt.toDuration(m7660toDoubleimpl(j11, r02) / d11, r02);
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m7654timesUwyO8pc(long j11, double d11) {
        int roundToInt = MathKt__MathJVMKt.roundToInt(d11);
        if (((double) roundToInt) == d11) {
            return m7655timesUwyO8pc(j11, roundToInt);
        }
        DurationUnit r02 = m7642getStorageUnitimpl(j11);
        return DurationKt.toDuration(m7660toDoubleimpl(j11, r02) * d11, r02);
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m7667toStringimpl(long j11, @NotNull DurationUnit durationUnit, int i11) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (i11 >= 0) {
            double r22 = m7660toDoubleimpl(j11, durationUnit);
            if (Double.isInfinite(r22)) {
                return String.valueOf(r22);
            }
            return DurationJvmKt.formatToExactDecimals(r22, RangesKt___RangesKt.coerceAtMost(i11, 12)) + DurationUnitKt__DurationUnitKt.shortName(durationUnit);
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i11).toString());
    }
}
