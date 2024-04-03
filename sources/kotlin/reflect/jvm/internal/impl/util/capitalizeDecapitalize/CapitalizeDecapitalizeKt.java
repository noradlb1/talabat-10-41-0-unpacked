package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CapitalizeDecapitalizeKt {
    @NotNull
    public static final String capitalizeAsciiOnly(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z12 = false;
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt < '{') {
            z12 = true;
        }
        if (!z12) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return upperCase + substring;
    }

    @NotNull
    public static final String decapitalizeAsciiOnly(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z12 = false;
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt < '[') {
            z12 = true;
        }
        if (!z12) {
            return str;
        }
        char lowerCase = Character.toLowerCase(charAt);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return lowerCase + substring;
    }

    @NotNull
    public static final String decapitalizeSmartForCompiler(@NotNull String str, boolean z11) {
        boolean z12;
        boolean z13;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 || !isUpperCaseCharAt(str, 0, z11)) {
            return str;
        }
        if (str.length() != 1 && isUpperCaseCharAt(str, 1, z11)) {
            Iterator it = StringsKt__StringsKt.getIndices(str).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!isUpperCaseCharAt(str, ((Number) obj).intValue(), z11)) {
                    break;
                }
            }
            Integer num = (Integer) obj;
            if (num == null) {
                return toLowerCase(str, z11);
            }
            int intValue = num.intValue() - 1;
            StringBuilder sb2 = new StringBuilder();
            String substring = str.substring(0, intValue);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb2.append(toLowerCase(substring, z11));
            String substring2 = str.substring(intValue);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            sb2.append(substring2);
            return sb2.toString();
        } else if (z11) {
            return decapitalizeAsciiOnly(str);
        } else {
            if (str.length() > 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (!z13) {
                return str;
            }
            char lowerCase = Character.toLowerCase(str.charAt(0));
            String substring3 = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            return lowerCase + substring3;
        }
    }

    private static final boolean isUpperCaseCharAt(String str, int i11, boolean z11) {
        char charAt = str.charAt(i11);
        if (!z11) {
            return Character.isUpperCase(charAt);
        }
        if ('A' > charAt || charAt >= '[') {
            return false;
        }
        return true;
    }

    private static final String toLowerCase(String str, boolean z11) {
        if (z11) {
            return toLowerCaseAsciiOnly(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @NotNull
    public static final String toLowerCaseAsciiOnly(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb2 = new StringBuilder(str.length());
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if ('A' > charAt || charAt >= '[') {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                charAt = Character.toLowerCase(charAt);
            }
            sb2.append(charAt);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
        return sb3;
    }
}
