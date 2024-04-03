package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

public abstract class CharSequenceTranslator {
    public static String hex(int i11) {
        return Integer.toHexString(i11).toUpperCase(Locale.ENGLISH);
    }

    public abstract int translate(CharSequence charSequence, int i11, Writer writer) throws IOException;

    public final String translate(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            translate(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final CharSequenceTranslator with(CharSequenceTranslator... charSequenceTranslatorArr) {
        CharSequenceTranslator[] charSequenceTranslatorArr2 = new CharSequenceTranslator[(charSequenceTranslatorArr.length + 1)];
        charSequenceTranslatorArr2[0] = this;
        System.arraycopy(charSequenceTranslatorArr, 0, charSequenceTranslatorArr2, 1, charSequenceTranslatorArr.length);
        return new AggregateTranslator(charSequenceTranslatorArr2);
    }

    public final void translate(CharSequence charSequence, Writer writer) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (charSequence != null) {
            int length = charSequence.length();
            int i11 = 0;
            while (i11 < length) {
                int translate = translate(charSequence, i11, writer);
                if (translate == 0) {
                    char[] chars = Character.toChars(Character.codePointAt(charSequence, i11));
                    writer.write(chars);
                    i11 += chars.length;
                } else {
                    for (int i12 = 0; i12 < translate; i12++) {
                        i11 += Character.charCount(Character.codePointAt(charSequence, i11));
                    }
                }
            }
        }
    }
}
