package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    public static int codePointAt(CharSequence charSequence, int i11, int i12) {
        Preconditions.checkNotNull(charSequence);
        if (i11 < i12) {
            int i13 = i11 + 1;
            char charAt = charSequence.charAt(i11);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected low surrogate character '");
                sb2.append(charAt);
                sb2.append("' with value ");
                sb2.append(charAt);
                sb2.append(" at index ");
                sb2.append(i13 - 1);
                sb2.append(" in '");
                sb2.append(charSequence);
                sb2.append("'");
                throw new IllegalArgumentException(sb2.toString());
            } else if (i13 == i12) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i13);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + charAt2 + " at index " + i13 + " in '" + charSequence + "'");
            }
        } else {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
    }

    private static char[] growBuffer(char[] cArr, int i11, int i12) {
        if (i12 >= 0) {
            char[] cArr2 = new char[i12];
            if (i11 > 0) {
                System.arraycopy(cArr, 0, cArr2, 0, i11);
            }
            return cArr2;
        }
        throw new AssertionError("Cannot increase internal buffer any further");
    }

    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        int nextEscapeIndex = nextEscapeIndex(str, 0, length);
        if (nextEscapeIndex == length) {
            return str;
        }
        return escapeSlow(str, nextEscapeIndex);
    }

    @CheckForNull
    public abstract char[] escape(int i11);

    public final String escapeSlow(String str, int i11) {
        int i12;
        int length = str.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i13 = 0;
        int i14 = 0;
        while (i11 < length) {
            int codePointAt = codePointAt(str, i11, length);
            if (codePointAt >= 0) {
                char[] escape = escape(codePointAt);
                if (Character.isSupplementaryCodePoint(codePointAt)) {
                    i12 = 2;
                } else {
                    i12 = 1;
                }
                int i15 = i12 + i11;
                if (escape != null) {
                    int i16 = i11 - i13;
                    int i17 = i14 + i16;
                    int length2 = escape.length + i17;
                    if (charBufferFromThreadLocal.length < length2) {
                        charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i14, length2 + (length - i11) + 32);
                    }
                    if (i16 > 0) {
                        str.getChars(i13, i11, charBufferFromThreadLocal, i14);
                        i14 = i17;
                    }
                    if (escape.length > 0) {
                        System.arraycopy(escape, 0, charBufferFromThreadLocal, i14, escape.length);
                        i14 += escape.length;
                    }
                    i13 = i15;
                }
                i11 = nextEscapeIndex(str, i15, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i18 = length - i13;
        if (i18 > 0) {
            int i19 = i18 + i14;
            if (charBufferFromThreadLocal.length < i19) {
                charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i14, i19);
            }
            str.getChars(i13, length, charBufferFromThreadLocal, i14);
            i14 = i19;
        }
        return new String(charBufferFromThreadLocal, 0, i14);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i11, int i12) {
        int i13;
        while (i11 < i12) {
            int codePointAt = codePointAt(charSequence, i11, i12);
            if (codePointAt < 0 || escape(codePointAt) != null) {
                break;
            }
            if (Character.isSupplementaryCodePoint(codePointAt)) {
                i13 = 2;
            } else {
                i13 = 1;
            }
            i11 += i13;
        }
        return i11;
    }
}
