package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class OctalUnescaper extends CharSequenceTranslator {
    private boolean isOctalDigit(char c11) {
        return c11 >= '0' && c11 <= '7';
    }

    private boolean isZeroToThree(char c11) {
        return c11 >= '0' && c11 <= '3';
    }

    public int translate(CharSequence charSequence, int i11, Writer writer) throws IOException {
        int length = (charSequence.length() - i11) - 1;
        StringBuilder sb2 = new StringBuilder();
        if (charSequence.charAt(i11) != '\\' || length <= 0) {
            return 0;
        }
        int i12 = i11 + 1;
        if (!isOctalDigit(charSequence.charAt(i12))) {
            return 0;
        }
        int i13 = i11 + 2;
        int i14 = i11 + 3;
        sb2.append(charSequence.charAt(i12));
        if (length > 1 && isOctalDigit(charSequence.charAt(i13))) {
            sb2.append(charSequence.charAt(i13));
            if (length > 2 && isZeroToThree(charSequence.charAt(i12)) && isOctalDigit(charSequence.charAt(i14))) {
                sb2.append(charSequence.charAt(i14));
            }
        }
        writer.write(Integer.parseInt(sb2.toString(), 8));
        return sb2.length() + 1;
    }
}
