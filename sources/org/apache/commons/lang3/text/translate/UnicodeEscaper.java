package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class UnicodeEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static UnicodeEscaper above(int i11) {
        return outsideOf(0, i11);
    }

    public static UnicodeEscaper below(int i11) {
        return outsideOf(i11, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper between(int i11, int i12) {
        return new UnicodeEscaper(i11, i12, true);
    }

    public static UnicodeEscaper outsideOf(int i11, int i12) {
        return new UnicodeEscaper(i11, i12, false);
    }

    public String toUtf16Escape(int i11) {
        return "\\u" + CharSequenceTranslator.hex(i11);
    }

    public boolean translate(int i11, Writer writer) throws IOException {
        if (this.between) {
            if (i11 < this.below || i11 > this.above) {
                return false;
            }
        } else if (i11 >= this.below && i11 <= this.above) {
            return false;
        }
        if (i11 > 65535) {
            writer.write(toUtf16Escape(i11));
            return true;
        } else if (i11 > 4095) {
            writer.write("\\u" + CharSequenceTranslator.hex(i11));
            return true;
        } else if (i11 > 255) {
            writer.write("\\u0" + CharSequenceTranslator.hex(i11));
            return true;
        } else if (i11 > 15) {
            writer.write("\\u00" + CharSequenceTranslator.hex(i11));
            return true;
        } else {
            writer.write("\\u000" + CharSequenceTranslator.hex(i11));
            return true;
        }
    }

    public UnicodeEscaper(int i11, int i12, boolean z11) {
        this.below = i11;
        this.above = i12;
        this.between = z11;
    }
}
