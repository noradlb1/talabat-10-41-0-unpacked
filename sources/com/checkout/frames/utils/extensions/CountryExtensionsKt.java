package com.checkout.frames.utils.extensions;

import com.checkout.base.model.Country;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"emojiFlag", "", "Lcom/checkout/base/model/Country;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CountryExtensionsKt {
    @NotNull
    public static final String emojiFlag(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "<this>");
        if (country.getIso3166Alpha2().length() != 2) {
            return "";
        }
        String upperCase = country.getIso3166Alpha2().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        char[] chars = Character.toChars((upperCase.charAt(0) - 'A') + 127462);
        Intrinsics.checkNotNullExpressionValue(chars, "toChars(firstLetter)");
        String str = new String(chars);
        char[] chars2 = Character.toChars((upperCase.charAt(1) - 'A') + 127462);
        Intrinsics.checkNotNullExpressionValue(chars2, "toChars(secondLetter)");
        String str2 = new String(chars2);
        return str + str2;
    }
}
