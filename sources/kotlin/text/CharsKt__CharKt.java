package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007¨\u0006\u0010"}, d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char digitToChar(int i11) {
        if (new IntRange(0, 9).contains(i11)) {
            return (char) (i11 + 48);
        }
        throw new IllegalArgumentException("Int " + i11 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static int digitToInt(char c11) {
        int digitOf = CharsKt__CharJVMKt.digitOf(c11, 10);
        if (digitOf >= 0) {
            return digitOf;
        }
        throw new IllegalArgumentException("Char " + c11 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static Integer digitToIntOrNull(char c11) {
        Integer valueOf = Integer.valueOf(CharsKt__CharJVMKt.digitOf(c11, 10));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static final boolean equals(char c11, char c12, boolean z11) {
        if (c11 == c12) {
            return true;
        }
        if (!z11) {
            return false;
        }
        char upperCase = Character.toUpperCase(c11);
        char upperCase2 = Character.toUpperCase(c12);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean equals$default(char c11, char c12, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return equals(c11, c12, z11);
    }

    public static final boolean isSurrogate(char c11) {
        return new CharRange(55296, 57343).contains(c11);
    }

    @InlineOnly
    private static final String plus(char c11, String str) {
        Intrinsics.checkNotNullParameter(str, "other");
        return c11 + str;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    public static String titlecase(char c11) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(c11);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer digitToIntOrNull(char c11, int i11) {
        int unused = CharsKt__CharJVMKt.checkRadix(i11);
        Integer valueOf = Integer.valueOf(CharsKt__CharJVMKt.digitOf(c11, i11));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char digitToChar(int i11, int i12) {
        if (!new IntRange(2, 36).contains(i12)) {
            throw new IllegalArgumentException("Invalid radix: " + i12 + ". Valid radix values are in range 2..36");
        } else if (i11 < 0 || i11 >= i12) {
            throw new IllegalArgumentException("Digit " + i11 + " does not represent a valid digit in radix " + i12);
        } else {
            return (char) (i11 < 10 ? i11 + 48 : ((char) (i11 + 65)) - 10);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int digitToInt(char c11, int i11) {
        Integer digitToIntOrNull = digitToIntOrNull(c11, i11);
        if (digitToIntOrNull != null) {
            return digitToIntOrNull.intValue();
        }
        throw new IllegalArgumentException("Char " + c11 + " is not a digit in the given radix=" + i11);
    }
}
