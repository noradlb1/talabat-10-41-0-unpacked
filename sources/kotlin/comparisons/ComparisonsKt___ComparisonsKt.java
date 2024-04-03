package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f\u001aG\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"maxOf", "T", "a", "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "other", "", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    @SinceKotlin(version = "1.1")
    public static final <T> T maxOf(T t11, T t12, T t13, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxOf(t11, (T) maxOf(t12, t13, comparator), comparator);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T minOf(T t11, T t12, T t13, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minOf(t11, (T) minOf(t12, t13, comparator), comparator);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T maxOf(T t11, T t12, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return comparator.compare(t11, t12) >= 0 ? t11 : t12;
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T minOf(T t11, T t12, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return comparator.compare(t11, t12) <= 0 ? t11 : t12;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T maxOf(T t11, @NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        for (T t12 : tArr) {
            if (comparator.compare(t11, t12) < 0) {
                t11 = t12;
            }
        }
        return t11;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T minOf(T t11, @NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        for (T t12 : tArr) {
            if (comparator.compare(t11, t12) > 0) {
                t11 = t12;
            }
        }
        return t11;
    }
}
