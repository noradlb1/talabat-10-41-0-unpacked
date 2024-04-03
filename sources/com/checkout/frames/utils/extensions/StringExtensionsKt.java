package com.checkout.frames.utils.extensions;

import com.checkout.tokenization.model.ExpiryDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toExpiryDate", "Lcom/checkout/tokenization/model/ExpiryDate;", "", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class StringExtensionsKt {
    @NotNull
    public static final ExpiryDate toExpiryDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        if (length == 3) {
            return new ExpiryDate(Integer.parseInt(String.valueOf(str.charAt(0))), Integer.parseInt(StringsKt__StringsKt.substring(str, new IntRange(1, 2))));
        }
        if (length == 4) {
            return new ExpiryDate(Integer.parseInt(StringsKt__StringsKt.substring(str, new IntRange(0, 1))), Integer.parseInt(StringsKt__StringsKt.substring(str, new IntRange(2, 3))));
        }
        return new ExpiryDate(0, 0);
    }
}
