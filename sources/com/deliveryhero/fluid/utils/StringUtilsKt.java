package com.deliveryhero.fluid.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u001a\u0015\u0010\b\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\b¨\u0006\u000b"}, d2 = {"addPrefix", "", "prefix", "", "addSuffix", "suffix", "hasPrefix", "", "hasSuffix", "removePrefix", "removeSuffix", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class StringUtilsKt {
    @NotNull
    public static final String addPrefix(@NotNull String str, char c11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return c11 + str;
    }

    @NotNull
    public static final String addSuffix(@NotNull String str, char c11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str + c11;
    }

    public static final boolean hasPrefix(@NotNull String str, char c11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Character firstOrNull = StringsKt___StringsKt.firstOrNull(str);
        if (firstOrNull != null && firstOrNull.charValue() == c11) {
            return true;
        }
        return false;
    }

    public static final boolean hasSuffix(@NotNull String str, char c11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Character lastOrNull = StringsKt___StringsKt.lastOrNull(str);
        if (lastOrNull != null && lastOrNull.charValue() == c11) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String removePrefix(@NotNull String str, char c11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Character firstOrNull = StringsKt___StringsKt.firstOrNull(str);
        if (firstOrNull != null && firstOrNull.charValue() == c11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return str;
        }
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    public static final String removeSuffix(@NotNull String str, char c11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Character lastOrNull = StringsKt___StringsKt.lastOrNull(str);
        if (lastOrNull != null && lastOrNull.charValue() == c11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return str;
        }
        String substring = str.substring(0, str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
