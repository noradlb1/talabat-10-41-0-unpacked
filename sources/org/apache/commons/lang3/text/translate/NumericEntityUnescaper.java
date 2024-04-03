package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;

public class NumericEntityUnescaper extends CharSequenceTranslator {
    private final EnumSet<OPTION> options;

    public enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon
    }

    public NumericEntityUnescaper(OPTION... optionArr) {
        if (optionArr.length > 0) {
            this.options = EnumSet.copyOf(Arrays.asList(optionArr));
            return;
        }
        this.options = EnumSet.copyOf(Arrays.asList(new OPTION[]{OPTION.semiColonRequired}));
    }

    public boolean isSet(OPTION option) {
        EnumSet<OPTION> enumSet = this.options;
        if (enumSet == null) {
            return false;
        }
        return enumSet.contains(option);
    }

    public int translate(CharSequence charSequence, int i11, Writer writer) throws IOException {
        int i12;
        int i13;
        int i14;
        int length = charSequence.length();
        if (charSequence.charAt(i11) == '&' && i11 < length - 2 && charSequence.charAt(i11 + 1) == '#') {
            int i15 = i11 + 2;
            char charAt = charSequence.charAt(i15);
            if (charAt == 'x' || charAt == 'X') {
                i15++;
                if (i15 == length) {
                    return 0;
                }
                i12 = 1;
            } else {
                i12 = 0;
            }
            int i16 = i15;
            while (i16 < length && ((charSequence.charAt(i16) >= '0' && charSequence.charAt(i16) <= '9') || ((charSequence.charAt(i16) >= 'a' && charSequence.charAt(i16) <= 'f') || (charSequence.charAt(i16) >= 'A' && charSequence.charAt(i16) <= 'F')))) {
                i16++;
            }
            if (i16 == length || charSequence.charAt(i16) != ';') {
                i13 = 0;
            } else {
                i13 = 1;
            }
            if (i13 == 0) {
                if (isSet(OPTION.semiColonRequired)) {
                    return 0;
                }
                if (isSet(OPTION.errorIfNoSemiColon)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            if (i12 != 0) {
                try {
                    i14 = Integer.parseInt(charSequence.subSequence(i15, i16).toString(), 16);
                } catch (NumberFormatException unused) {
                }
            } else {
                i14 = Integer.parseInt(charSequence.subSequence(i15, i16).toString(), 10);
            }
            if (i14 > 65535) {
                char[] chars = Character.toChars(i14);
                writer.write(chars[0]);
                writer.write(chars[1]);
            } else {
                writer.write(i14);
            }
            return ((i16 + 2) - i15) + i12 + i13;
        }
        return 0;
    }
}
