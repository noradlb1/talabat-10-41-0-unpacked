package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\r\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a6\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u001f\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\b\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000e\"\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000f\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0012H\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0013H\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0014H\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendLine", "", "", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    @InlineOnly
    private static final StringBuilder append(StringBuilder sb2, Object obj) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        sb2.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb2, "this.append(obj)");
        return sb2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        sb2.append(10);
        Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
        return sb2;
    }

    @InlineOnly
    private static final String buildString(Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        StringBuilder sb2 = new StringBuilder();
        function1.invoke(sb2);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public static StringBuilder append(@NotNull StringBuilder sb2, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "value");
        for (String append : strArr) {
            sb2.append(append);
        }
        return sb2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb2, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        sb2.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(sb2, "append(value)");
        sb2.append(10);
        Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
        return sb2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String buildString(int i11, Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        StringBuilder sb2 = new StringBuilder(i11);
        function1.invoke(sb2);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb2, String str) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        sb2.append(str);
        Intrinsics.checkNotNullExpressionValue(sb2, "append(value)");
        sb2.append(10);
        Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
        return sb2;
    }

    @NotNull
    public static final StringBuilder append(@NotNull StringBuilder sb2, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "value");
        for (Object append : objArr) {
            sb2.append(append);
        }
        return sb2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb2, Object obj) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        sb2.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb2, "append(value)");
        sb2.append(10);
        Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
        return sb2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb2, char[] cArr) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "value");
        sb2.append(cArr);
        Intrinsics.checkNotNullExpressionValue(sb2, "append(value)");
        sb2.append(10);
        Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
        return sb2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb2, char c11) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        sb2.append(c11);
        Intrinsics.checkNotNullExpressionValue(sb2, "append(value)");
        sb2.append(10);
        Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
        return sb2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(StringBuilder sb2, boolean z11) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        sb2.append(z11);
        Intrinsics.checkNotNullExpressionValue(sb2, "append(value)");
        sb2.append(10);
        Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
        return sb2;
    }
}
