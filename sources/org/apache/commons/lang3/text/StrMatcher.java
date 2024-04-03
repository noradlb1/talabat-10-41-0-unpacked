package org.apache.commons.lang3.text;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.StringUtils;

public abstract class StrMatcher {
    private static final StrMatcher COMMA_MATCHER = new CharMatcher(AbstractJsonLexerKt.COMMA);
    private static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher('\"');
    private static final StrMatcher NONE_MATCHER = new NoMatcher();
    private static final StrMatcher QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
    private static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
    private static final StrMatcher SPACE_MATCHER = new CharMatcher(' ');
    private static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    private static final StrMatcher TAB_MATCHER = new CharMatcher(9);
    private static final StrMatcher TRIM_MATCHER = new TrimMatcher();

    public static final class CharMatcher extends StrMatcher {

        /* renamed from: ch  reason: collision with root package name */
        private final char f27847ch;

        public CharMatcher(char c11) {
            this.f27847ch = c11;
        }

        public int isMatch(char[] cArr, int i11, int i12, int i13) {
            return this.f27847ch == cArr[i11] ? 1 : 0;
        }
    }

    public static final class CharSetMatcher extends StrMatcher {
        private final char[] chars;

        public CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }

        public int isMatch(char[] cArr, int i11, int i12, int i13) {
            return Arrays.binarySearch(this.chars, cArr[i11]) >= 0 ? 1 : 0;
        }
    }

    public static final class NoMatcher extends StrMatcher {
        public int isMatch(char[] cArr, int i11, int i12, int i13) {
            return 0;
        }
    }

    public static final class StringMatcher extends StrMatcher {
        private final char[] chars;

        public StringMatcher(String str) {
            this.chars = str.toCharArray();
        }

        public int isMatch(char[] cArr, int i11, int i12, int i13) {
            int length = this.chars.length;
            if (i11 + length > i13) {
                return 0;
            }
            int i14 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i14 >= cArr2.length) {
                    return length;
                }
                if (cArr2[i14] != cArr[i11]) {
                    return 0;
                }
                i14++;
                i11++;
            }
        }
    }

    public static final class TrimMatcher extends StrMatcher {
        public int isMatch(char[] cArr, int i11, int i12, int i13) {
            return cArr[i11] <= ' ' ? 1 : 0;
        }
    }

    public static StrMatcher charMatcher(char c11) {
        return new CharMatcher(c11);
    }

    public static StrMatcher charSetMatcher(char... cArr) {
        if (cArr == null || cArr.length == 0) {
            return NONE_MATCHER;
        }
        if (cArr.length == 1) {
            return new CharMatcher(cArr[0]);
        }
        return new CharSetMatcher(cArr);
    }

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher stringMatcher(String str) {
        if (StringUtils.isEmpty(str)) {
            return NONE_MATCHER;
        }
        return new StringMatcher(str);
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    public int isMatch(char[] cArr, int i11) {
        return isMatch(cArr, i11, 0, cArr.length);
    }

    public abstract int isMatch(char[] cArr, int i11, int i12, int i13);

    public static StrMatcher charSetMatcher(String str) {
        if (StringUtils.isEmpty(str)) {
            return NONE_MATCHER;
        }
        if (str.length() == 1) {
            return new CharMatcher(str.charAt(0));
        }
        return new CharSetMatcher(str.toCharArray());
    }
}
