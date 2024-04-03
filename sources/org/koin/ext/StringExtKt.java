package org.koin.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"clearQuotes", "", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class StringExtKt {
    @NotNull
    public static final String clearQuotes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 1 || StringsKt___StringsKt.first(str) != '\"' || StringsKt___StringsKt.last(str) != '\"') {
            return str;
        }
        String substring = str.substring(1, StringsKt__StringsKt.getLastIndex(str));
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }
}
