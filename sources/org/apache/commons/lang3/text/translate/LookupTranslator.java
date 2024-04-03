package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final HashMap<String, CharSequence> lookupMap = new HashMap<>();
    private final int shortest;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i11 = Integer.MAX_VALUE;
        int i12 = 0;
        if (charSequenceArr != null) {
            int i13 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.lookupMap.put(charSequenceArr2[0].toString(), charSequenceArr2[1]);
                int length = charSequenceArr2[0].length();
                i11 = length < i11 ? length : i11;
                if (length > i13) {
                    i13 = length;
                }
            }
            i12 = i13;
        }
        this.shortest = i11;
        this.longest = i12;
    }

    public int translate(CharSequence charSequence, int i11, Writer writer) throws IOException {
        int i12 = this.longest;
        if (i11 + i12 > charSequence.length()) {
            i12 = charSequence.length() - i11;
        }
        while (i12 >= this.shortest) {
            CharSequence charSequence2 = this.lookupMap.get(charSequence.subSequence(i11, i11 + i12).toString());
            if (charSequence2 != null) {
                writer.write(charSequence2.toString());
                return i12;
            }
            i12--;
        }
        return 0;
    }
}
