package org.apache.commons.lang3.text;

import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

public class FormattableUtils {
    private static final String SIMPLEST_FORMAT = "%s";

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i11, int i12, int i13) {
        return append(charSequence, formatter, i11, i12, i13, ' ', (CharSequence) null);
    }

    public static String toString(Formattable formattable) {
        return String.format("%s", new Object[]{formattable});
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i11, int i12, int i13, char c11) {
        return append(charSequence, formatter, i11, i12, i13, c11, (CharSequence) null);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i11, int i12, int i13, CharSequence charSequence2) {
        return append(charSequence, formatter, i11, i12, i13, ' ', charSequence2);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i11, int i12, int i13, char c11, CharSequence charSequence2) {
        boolean z11 = true;
        Validate.isTrue(charSequence2 == null || i13 < 0 || charSequence2.length() <= i13, "Specified ellipsis '%1$s' exceeds precision of %2$s", charSequence2, Integer.valueOf(i13));
        StringBuilder sb2 = new StringBuilder(charSequence);
        if (i13 >= 0 && i13 < charSequence.length()) {
            CharSequence charSequence3 = (CharSequence) ObjectUtils.defaultIfNull(charSequence2, "");
            sb2.replace(i13 - charSequence3.length(), charSequence.length(), charSequence3.toString());
        }
        if ((i11 & 1) != 1) {
            z11 = false;
        }
        for (int length = sb2.length(); length < i12; length++) {
            sb2.insert(z11 ? length : 0, c11);
        }
        formatter.format(sb2.toString(), new Object[0]);
        return formatter;
    }
}
