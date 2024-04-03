package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class NumericEntityEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    private NumericEntityEscaper(int i11, int i12, boolean z11) {
        this.below = i11;
        this.above = i12;
        this.between = z11;
    }

    public static NumericEntityEscaper above(int i11) {
        return outsideOf(0, i11);
    }

    public static NumericEntityEscaper below(int i11) {
        return outsideOf(i11, Integer.MAX_VALUE);
    }

    public static NumericEntityEscaper between(int i11, int i12) {
        return new NumericEntityEscaper(i11, i12, true);
    }

    public static NumericEntityEscaper outsideOf(int i11, int i12) {
        return new NumericEntityEscaper(i11, i12, false);
    }

    public boolean translate(int i11, Writer writer) throws IOException {
        if (this.between) {
            if (i11 < this.below || i11 > this.above) {
                return false;
            }
        } else if (i11 >= this.below && i11 <= this.above) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i11, 10));
        writer.write(59);
        return true;
    }

    public NumericEntityEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }
}
