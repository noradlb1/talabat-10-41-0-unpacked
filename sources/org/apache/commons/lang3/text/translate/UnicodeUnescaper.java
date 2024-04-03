package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class UnicodeUnescaper extends CharSequenceTranslator {
    public int translate(CharSequence charSequence, int i11, Writer writer) throws IOException {
        int i12;
        int i13;
        if (charSequence.charAt(i11) != '\\' || (i12 = i11 + 1) >= charSequence.length() || charSequence.charAt(i12) != 'u') {
            return 0;
        }
        int i14 = 2;
        while (true) {
            i13 = i11 + i14;
            if (i13 < charSequence.length() && charSequence.charAt(i13) == 'u') {
                i14++;
            }
        }
        if (i13 < charSequence.length() && charSequence.charAt(i13) == '+') {
            i14++;
        }
        int i15 = i11 + i14;
        int i16 = i15 + 4;
        if (i16 <= charSequence.length()) {
            CharSequence subSequence = charSequence.subSequence(i15, i16);
            try {
                writer.write((char) Integer.parseInt(subSequence.toString(), 16));
                return i14 + 4;
            } catch (NumberFormatException e11) {
                throw new IllegalArgumentException("Unable to parse unicode value: " + subSequence, e11);
            }
        } else {
            throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + charSequence.subSequence(i11, charSequence.length()) + "' due to end of CharSequence");
        }
    }
}
