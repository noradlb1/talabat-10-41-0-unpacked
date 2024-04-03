package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\b\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\b\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\b\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010!\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0014\u0010\"\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010#\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010$\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010%\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010&\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010'\u001a\u00020\u001e*\u00020\u0002H\b\u001a\u0014\u0010'\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010(\u001a\u00020\u0002*\u00020\u0002H\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", "", "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharJVMKt {
    @PublishedApi
    public static int checkRadix(int i11) {
        if (new IntRange(2, 36).contains(i11)) {
            return i11;
        }
        throw new IllegalArgumentException("radix " + i11 + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int digitOf(char c11, int i11) {
        return Character.digit(c11, i11);
    }

    @NotNull
    public static final CharCategory getCategory(char c11) {
        return CharCategory.Companion.valueOf(Character.getType(c11));
    }

    @NotNull
    public static final CharDirectionality getDirectionality(char c11) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality(c11));
    }

    @InlineOnly
    private static final boolean isDefined(char c11) {
        return Character.isDefined(c11);
    }

    @InlineOnly
    private static final boolean isDigit(char c11) {
        return Character.isDigit(c11);
    }

    @InlineOnly
    private static final boolean isHighSurrogate(char c11) {
        return Character.isHighSurrogate(c11);
    }

    @InlineOnly
    private static final boolean isISOControl(char c11) {
        return Character.isISOControl(c11);
    }

    @InlineOnly
    private static final boolean isIdentifierIgnorable(char c11) {
        return Character.isIdentifierIgnorable(c11);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierPart(char c11) {
        return Character.isJavaIdentifierPart(c11);
    }

    @InlineOnly
    private static final boolean isJavaIdentifierStart(char c11) {
        return Character.isJavaIdentifierStart(c11);
    }

    @InlineOnly
    private static final boolean isLetter(char c11) {
        return Character.isLetter(c11);
    }

    @InlineOnly
    private static final boolean isLetterOrDigit(char c11) {
        return Character.isLetterOrDigit(c11);
    }

    @InlineOnly
    private static final boolean isLowSurrogate(char c11) {
        return Character.isLowSurrogate(c11);
    }

    @InlineOnly
    private static final boolean isLowerCase(char c11) {
        return Character.isLowerCase(c11);
    }

    @InlineOnly
    private static final boolean isTitleCase(char c11) {
        return Character.isTitleCase(c11);
    }

    @InlineOnly
    private static final boolean isUpperCase(char c11) {
        return Character.isUpperCase(c11);
    }

    public static boolean isWhitespace(char c11) {
        return Character.isWhitespace(c11) || Character.isSpaceChar(c11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String lowercase(char c11) {
        String valueOf = String.valueOf(c11);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final char lowercaseChar(char c11) {
        return Character.toLowerCase(c11);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String titlecase(char c11, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String uppercase = uppercase(c11, locale);
        if (uppercase.length() <= 1) {
            String valueOf = String.valueOf(c11);
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            if (!Intrinsics.areEqual((Object) uppercase, (Object) upperCase)) {
                return uppercase;
            }
            return String.valueOf(Character.toTitleCase(c11));
        } else if (c11 == 329) {
            return uppercase;
        } else {
            char charAt = uppercase.charAt(0);
            Intrinsics.checkNotNull(uppercase, "null cannot be cast to non-null type java.lang.String");
            String substring = uppercase.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return charAt + lowerCase;
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final char titlecaseChar(char c11) {
        return Character.toTitleCase(c11);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toLowerCase(char c11) {
        return Character.toLowerCase(c11);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toTitleCase(char c11) {
        return Character.toTitleCase(c11);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toUpperCase(char c11) {
        return Character.toUpperCase(c11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String uppercase(char c11) {
        String valueOf = String.valueOf(c11);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final char uppercaseChar(char c11) {
        return Character.toUpperCase(c11);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String lowercase(char c11, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf(c11);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String uppercase(char c11, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf(c11);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
