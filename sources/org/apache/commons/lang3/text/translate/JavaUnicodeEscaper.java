package org.apache.commons.lang3.text.translate;

public class JavaUnicodeEscaper extends UnicodeEscaper {
    public JavaUnicodeEscaper(int i11, int i12, boolean z11) {
        super(i11, i12, z11);
    }

    public static JavaUnicodeEscaper above(int i11) {
        return outsideOf(0, i11);
    }

    public static JavaUnicodeEscaper below(int i11) {
        return outsideOf(i11, Integer.MAX_VALUE);
    }

    public static JavaUnicodeEscaper between(int i11, int i12) {
        return new JavaUnicodeEscaper(i11, i12, true);
    }

    public static JavaUnicodeEscaper outsideOf(int i11, int i12) {
        return new JavaUnicodeEscaper(i11, i12, false);
    }

    public String toUtf16Escape(int i11) {
        char[] chars = Character.toChars(i11);
        return "\\u" + CharSequenceTranslator.hex(chars[0]) + "\\u" + CharSequenceTranslator.hex(chars[1]);
    }
}
