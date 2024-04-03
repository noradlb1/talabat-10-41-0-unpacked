package kotlin.text;

import com.braze.ui.actions.brazeactions.steps.StepData;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a\f\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'H\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\b\u001a\f\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a2\u00100\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00104\u001a6\u00100\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0004\b5\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00106\u001a:\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00107\u001a>\u00100\u001a\u00020\u0002*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0004\b5\u00107\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00108\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\b\u001a\n\u0010:\u001a\u00020#*\u00020'\u001a\r\u0010;\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010;\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\b\u001a\u001d\u0010B\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\b\u001a4\u0010D\u001a\u00020#*\u00020'2\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010D\u001a\u00020#*\u00020\u00022\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020'2\u0006\u0010H\u001a\u00020\u0011\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020P*\u00020'2\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020\u0011\u001a\u001c\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\b\u001a\u001d\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\b\u001a\u0017\u0010W\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\b\u001a\r\u0010X\u001a\u00020\u0014*\u00020\u0002H\b\u001a3\u0010X\u001a\u00020\u0014*\u00020\u00022\u0006\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\b\u001a \u0010X\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010[\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010[\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\u001a\u0017\u0010\\\u001a\u00020R*\u00020\u00022\b\b\u0002\u0010]\u001a\u00020\u0011H\b\u001a\r\u0010^\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010^\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\u001a\r\u0010_\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010_\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006`"}, d2 = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "formatNullable", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    @InlineOnly
    private static final String String(byte[] bArr, int i11, int i12, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bArr, i11, i12, charset);
    }

    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static String capitalize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return capitalize(str, locale);
    }

    @InlineOnly
    private static final int codePointAt(String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.codePointAt(i11);
    }

    @InlineOnly
    private static final int codePointBefore(String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.codePointBefore(i11);
    }

    @InlineOnly
    private static final int codePointCount(String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.codePointCount(i11, i12);
    }

    public static final int compareTo(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "other");
        if (z11) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    public static /* synthetic */ int compareTo$default(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return compareTo(str, str2, z11);
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String concatToString(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new String(cArr);
    }

    public static /* synthetic */ String concatToString$default(char[] cArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = cArr.length;
        }
        return concatToString(cArr, i11, i12);
    }

    @InlineOnly
    private static final boolean contentEquals(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        sb2.append(lowerCase);
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring2);
        return sb2.toString();
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String decodeToString(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, Charsets.UTF_8);
    }

    public static /* synthetic */ String decodeToString$default(byte[] bArr, int i11, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = bArr.length;
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        return decodeToString(bArr, i11, i12, z11);
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static byte[] encodeToByteArray(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String str, int i11, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        return encodeToByteArray(str, i11, i12, z11);
    }

    public static boolean endsWith(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        if (!z11) {
            return str.endsWith(str2);
        }
        return regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return endsWith(str, str2, z11);
    }

    public static boolean equals(@Nullable String str, @Nullable String str2, boolean z11) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z11) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return equals(str, str2, z11);
    }

    @InlineOnly
    private static final String format(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "formatNullable")
    private static final String formatNullable(String str, Locale locale, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, this, *args)");
        return format;
    }

    @NotNull
    public static Comparator<String> getCASE_INSENSITIVE_ORDER(@NotNull StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    @InlineOnly
    private static final String intern(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String intern = str.intern();
        Intrinsics.checkNotNullExpressionValue(intern, "this as java.lang.String).intern()");
        return intern;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isBlank(@org.jetbrains.annotations.NotNull java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r4.length()
            r1 = 1
            if (r0 == 0) goto L_0x0040
            kotlin.ranges.IntRange r0 = kotlin.text.StringsKt__StringsKt.getIndices(r4)
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 0
            if (r2 == 0) goto L_0x0020
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0020
        L_0x001e:
            r4 = r1
            goto L_0x003c
        L_0x0020:
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001e
            r2 = r0
            kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
            int r2 = r2.nextInt()
            char r2 = r4.charAt(r2)
            boolean r2 = kotlin.text.CharsKt__CharJVMKt.isWhitespace(r2)
            if (r2 != 0) goto L_0x0024
            r4 = r3
        L_0x003c:
            if (r4 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r1 = r3
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsJVMKt.isBlank(java.lang.CharSequence):boolean");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String lowercase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @InlineOnly
    private static final int nativeIndexOf(String str, char c11, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.indexOf(c11, i11);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(String str, char c11, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.lastIndexOf(c11, i11);
    }

    @InlineOnly
    private static final int offsetByCodePoints(String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.offsetByCodePoints(i11, i12);
    }

    public static final boolean regionMatches(@NotNull CharSequence charSequence, int i11, @NotNull CharSequence charSequence2, int i12, int i13, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return StringsKt__StringsKt.regionMatchesImpl(charSequence, i11, charSequence2, i12, i13, z11);
        }
        return regionMatches((String) charSequence, i11, (String) charSequence2, i12, i13, z11);
    }

    public static /* synthetic */ boolean regionMatches$default(CharSequence charSequence, int i11, CharSequence charSequence2, int i12, int i13, boolean z11, int i14, Object obj) {
        if ((i14 & 16) != 0) {
            z11 = false;
        }
        return regionMatches(charSequence, i11, charSequence2, i12, i13, z11);
    }

    @NotNull
    public static String repeat(@NotNull CharSequence charSequence, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i11 + '.').toString());
        } else if (i11 == 0) {
            return "";
        } else {
            if (i11 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb2 = new StringBuilder(charSequence.length() * i11);
                IntIterator it = new IntRange(1, i11).iterator();
                while (it.hasNext()) {
                    it.nextInt();
                    sb2.append(charSequence);
                }
                String sb3 = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "{\n                    va…tring()\n                }");
                return sb3;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                cArr[i12] = charAt;
            }
            return new String(cArr);
        }
    }

    @NotNull
    public static final String replace(@NotNull String str, char c11, char c12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!z11) {
            String replace = str.replace(c11, c12);
            Intrinsics.checkNotNullExpressionValue(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (CharsKt__CharKt.equals(charAt, c11, z11)) {
                charAt = c12;
            }
            sb2.append(charAt);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public static /* synthetic */ String replace$default(String str, char c11, char c12, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return replace(str, c11, c12, z11);
    }

    @NotNull
    public static final String replaceFirst(@NotNull String str, char c11, char c12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, c11, 0, z11, 2, (Object) null);
        return indexOf$default < 0 ? str : StringsKt__StringsKt.replaceRange((CharSequence) str, indexOf$default, indexOf$default + 1, (CharSequence) String.valueOf(c12)).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String str, char c11, char c12, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return replaceFirst(str, c11, c12, z11);
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence charSequence, @NotNull Pattern pattern, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "regex");
        StringsKt__StringsKt.requireNonNegativeLimit(i11);
        if (i11 == 0) {
            i11 = -1;
        }
        String[] split = pattern.split(charSequence, i11);
        Intrinsics.checkNotNullExpressionValue(split, "regex.split(this, if (limit == 0) -1 else limit)");
        return ArraysKt___ArraysJvmKt.asList((T[]) split);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return split(charSequence, pattern, i11);
    }

    public static boolean startsWith(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z11) {
            return str.startsWith(str2);
        }
        return regionMatches(str, 0, str2, 0, str2.length(), z11);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return startsWith(str, str2, z11);
    }

    @InlineOnly
    private static final String substring(String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String substring = str.substring(i11);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @InlineOnly
    private static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char[] toCharArray(@NotNull String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i11, i12, str.length());
        char[] cArr = new char[(i12 - i11)];
        str.getChars(i11, i12, cArr, 0);
        return cArr;
    }

    public static /* synthetic */ char[] toCharArray$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return toCharArray(str, i11, i12);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @InlineOnly
    private static final Pattern toPattern(String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Pattern compile = Pattern.compile(str, i11);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(this, flags)");
        return compile;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String uppercase(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    @InlineOnly
    private static final String String(byte[] bArr, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bArr, charset);
    }

    @SinceKotlin(version = "1.4")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @LowPriorityInOverloadResolution
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String capitalize(@NotNull String str, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLowerCase(charAt)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        char titleCase = Character.toTitleCase(charAt);
        if (titleCase != Character.toUpperCase(charAt)) {
            sb2.append(titleCase);
        } else {
            String substring = str.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = substring.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb2.append(upperCase);
        }
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring2);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String concatToString(@NotNull char[] cArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i11, i12, cArr.length);
        return new String(cArr, i11, i12 - i11);
    }

    @InlineOnly
    private static final boolean contentEquals(String str, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(stringBuffer, "stringBuilder");
        return str.contentEquals(stringBuffer);
    }

    @SinceKotlin(version = "1.4")
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @LowPriorityInOverloadResolution
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String decapitalize(@NotNull String str, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        sb2.append(lowerCase);
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring2);
        return sb2.toString();
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String decodeToString(@NotNull byte[] bArr, int i11, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i11, i12, bArr.length);
        if (!z11) {
            return new String(bArr, i11, i12 - i11, Charsets.UTF_8);
        }
        String charBuffer = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i11, i12 - i11)).toString();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte[] encodeToByteArray(@NotNull String str, int i11, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i11, i12, str.length());
        if (!z11) {
            String substring = str.substring(i11, i12);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = Charsets.UTF_8;
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        ByteBuffer encode = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i11, i12));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            Intrinsics.checkNotNull(array);
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                Intrinsics.checkNotNullExpressionValue(array2, "{\n        byteBuffer.array()\n    }");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @InlineOnly
    private static final String format(StringCompanionObject stringCompanionObject, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "format");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "formatNullable")
    private static final String formatNullable(StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "format");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String lowercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @InlineOnly
    private static final int nativeIndexOf(String str, String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "str");
        return str.indexOf(str2, i11);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(String str, String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "str");
        return str.lastIndexOf(str2, i11);
    }

    public static /* synthetic */ boolean regionMatches$default(String str, int i11, String str2, int i12, int i13, boolean z11, int i14, Object obj) {
        if ((i14 & 16) != 0) {
            z11 = false;
        }
        return regionMatches(str, i11, str2, i12, i13, z11);
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return replace(str, str2, str3, z11);
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return replaceFirst(str, str2, str3, z11);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return startsWith(str, str2, i11, z11);
    }

    @InlineOnly
    private static final String substring(String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String substring = str.substring(i11, i12);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String uppercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @InlineOnly
    private static final String String(byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return new String(bArr, i11, i12, Charsets.UTF_8);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean contentEquals(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if (!(charSequence instanceof String) || charSequence2 == null) {
            return StringsKt__StringsKt.contentEqualsImpl(charSequence, charSequence2);
        }
        return ((String) charSequence).contentEquals(charSequence2);
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    private static final /* synthetic */ String format(String str, Locale locale, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, this, *args)");
        return format;
    }

    @NotNull
    public static final String replaceFirst(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "oldValue");
        Intrinsics.checkNotNullParameter(str3, "newValue");
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, z11, 2, (Object) null);
        return indexOf$default < 0 ? str : StringsKt__StringsKt.replaceRange((CharSequence) str, indexOf$default, str2.length() + indexOf$default, (CharSequence) str3).toString();
    }

    public static boolean startsWith(@NotNull String str, @NotNull String str2, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z11) {
            return str.startsWith(str2, i11);
        }
        return regionMatches(str, i11, str2, 0, str2.length(), z11);
    }

    @InlineOnly
    private static final char[] toCharArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        return charArray;
    }

    @InlineOnly
    private static final String String(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return new String(bArr, Charsets.UTF_8);
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @InlineOnly
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    private static final /* synthetic */ String format(StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(str, "format");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    public static boolean regionMatches(@NotNull String str, int i11, @NotNull String str2, int i12, int i13, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "other");
        if (!z11) {
            return str.regionMatches(i11, str2, i12, i13);
        }
        return str.regionMatches(z11, i11, str2, i12, i13);
    }

    @InlineOnly
    private static final char[] toCharArray(String str, char[] cArr, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "destination");
        str.getChars(i12, i13, cArr, i11);
        return cArr;
    }

    @InlineOnly
    private static final String String(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "chars");
        return new String(cArr);
    }

    @InlineOnly
    private static final String String(char[] cArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(cArr, "chars");
        return new String(cArr, i11, i12);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean contentEquals(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z11) {
        if (z11) {
            return StringsKt__StringsKt.contentEqualsIgnoreCaseImpl(charSequence, charSequence2);
        }
        return contentEquals(charSequence, charSequence2);
    }

    @NotNull
    public static String replace(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "oldValue");
        Intrinsics.checkNotNullParameter(str3, "newValue");
        int i11 = 0;
        int indexOf = StringsKt__StringsKt.indexOf((CharSequence) str, str2, 0, z11);
        if (indexOf < 0) {
            return str;
        }
        int length = str2.length();
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb2 = new StringBuilder(length2);
            do {
                sb2.append(str, i11, indexOf);
                sb2.append(str3);
                i11 = indexOf + length;
                if (indexOf >= str.length() || (indexOf = StringsKt__StringsKt.indexOf((CharSequence) str, str2, indexOf + coerceAtLeast, z11)) <= 0) {
                    sb2.append(str, i11, str.length());
                    String sb3 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "stringBuilder.append(this, i, length).toString()");
                }
                sb2.append(str, i11, indexOf);
                sb2.append(str3);
                i11 = indexOf + length;
                break;
            } while ((indexOf = StringsKt__StringsKt.indexOf((CharSequence) str, str2, indexOf + coerceAtLeast, z11)) <= 0);
            sb2.append(str, i11, str.length());
            String sb32 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb32, "stringBuilder.append(this, i, length).toString()");
            return sb32;
        }
        throw new OutOfMemoryError();
    }

    @InlineOnly
    private static final String String(int[] iArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(iArr, "codePoints");
        return new String(iArr, i11, i12);
    }

    @InlineOnly
    private static final String String(StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    @InlineOnly
    private static final String String(StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb2, "stringBuilder");
        return new String(sb2);
    }
}
