package kotlin.ranges;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a@\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b\"\u0018\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00070\n*\b\u0012\u0004\u0012\u0002H\u00070\u000b*\u0002H\t2\b\u0010\f\u001a\u0004\u0018\u0001H\u0007H\n¢\u0006\u0002\u0010\r\u001a@\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b\"\u0018\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00070\u000e*\b\u0012\u0004\u0012\u0002H\u00070\u000b*\u0002H\t2\b\u0010\f\u001a\u0004\u0018\u0001H\u0007H\n¢\u0006\u0002\u0010\u000f\u001a0\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00070\n\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0011*\u0002H\u00072\u0006\u0010\u0012\u001a\u0002H\u0007H\u0002¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H\u0002\u001a\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0016H\u0002\u001a0\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000e\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0011*\u0002H\u00072\u0006\u0010\u0012\u001a\u0002H\u0007H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e*\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H\u0002\u001a\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0016H\u0002¨\u0006\u0019"}, d2 = {"checkStepIsPositive", "", "isPositive", "", "step", "", "contains", "T", "", "R", "Lkotlin/ranges/ClosedRange;", "", "element", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Object;)Z", "Lkotlin/ranges/OpenEndRange;", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "rangeUntil", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/OpenEndRange;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/ranges/RangesKt")
class RangesKt__RangesKt {
    public static final void checkStepIsPositive(boolean z11, @NotNull Number number) {
        Intrinsics.checkNotNullParameter(number, "step");
        if (!z11) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T, R extends ClosedRange<T> & Iterable<? extends T>> boolean contains(R r11, T t11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return t11 != null && r11.contains((Comparable) t11);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(@NotNull T t11, @NotNull T t12) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(t12, "that");
        return new ComparableRange(t11, t12);
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalStdlibApi
    public static final <T extends Comparable<? super T>> OpenEndRange<T> rangeUntil(@NotNull T t11, @NotNull T t12) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(t12, "that");
        return new ComparableOpenEndRange(t11, t12);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <T, R extends OpenEndRange<T> & Iterable<? extends T>> boolean contains(R r11, T t11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return t11 != null && r11.contains((Comparable) t11);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Double> rangeTo(double d11, double d12) {
        return new ClosedDoubleRange(d11, d12);
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalStdlibApi
    public static final OpenEndRange<Double> rangeUntil(double d11, double d12) {
        return new OpenEndDoubleRange(d11, d12);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static ClosedFloatingPointRange<Float> rangeTo(float f11, float f12) {
        return new ClosedFloatRange(f11, f12);
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalStdlibApi
    public static final OpenEndRange<Float> rangeUntil(float f11, float f12) {
        return new OpenEndFloatRange(f11, f12);
    }
}
