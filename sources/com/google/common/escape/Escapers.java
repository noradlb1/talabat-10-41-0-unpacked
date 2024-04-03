package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() {
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }

        @CheckForNull
        public char[] escape(char c11) {
            return null;
        }
    };

    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        /* access modifiers changed from: private */
        @CheckForNull
        public String unsafeReplacement;

        @CanIgnoreReturnValue
        public Builder addEscape(char c11, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c11), str);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) {
                @CheckForNull
                private final char[] replacementChars;

                {
                    char[] cArr;
                    if (Builder.this.unsafeReplacement != null) {
                        cArr = Builder.this.unsafeReplacement.toCharArray();
                    } else {
                        cArr = null;
                    }
                    this.replacementChars = cArr;
                }

                @CheckForNull
                public char[] escapeUnsafe(char c11) {
                    return this.replacementChars;
                }
            };
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c11, char c12) {
            this.safeMin = c11;
            this.safeMax = c12;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(String str) {
            this.unsafeReplacement = str;
            return this;
        }

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = 0;
            this.safeMax = CharCompanionObject.MAX_VALUE;
            this.unsafeReplacement = null;
        }
    }

    private Escapers() {
    }

    public static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    public static Builder builder() {
        return new Builder();
    }

    @CheckForNull
    public static String computeReplacement(CharEscaper charEscaper, char c11) {
        return stringOrNull(charEscaper.escape(c11));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    @CheckForNull
    private static String stringOrNull(@CheckForNull char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() {
            @CheckForNull
            public char[] escape(int i11) {
                int i12;
                int i13;
                if (i11 < 65536) {
                    return CharEscaper.this.escape((char) i11);
                }
                char[] cArr = new char[2];
                Character.toChars(i11, cArr, 0);
                char[] escape = CharEscaper.this.escape(cArr[0]);
                char[] escape2 = CharEscaper.this.escape(cArr[1]);
                if (escape == null && escape2 == null) {
                    return null;
                }
                if (escape != null) {
                    i12 = escape.length;
                } else {
                    i12 = 1;
                }
                if (escape2 != null) {
                    i13 = escape2.length;
                } else {
                    i13 = 1;
                }
                char[] cArr2 = new char[(i13 + i12)];
                if (escape != null) {
                    for (int i14 = 0; i14 < escape.length; i14++) {
                        cArr2[i14] = escape[i14];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (escape2 != null) {
                    for (int i15 = 0; i15 < escape2.length; i15++) {
                        cArr2[i12 + i15] = escape2[i15];
                    }
                } else {
                    cArr2[i12] = cArr[1];
                }
                return cArr2;
            }
        };
    }

    @CheckForNull
    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i11) {
        return stringOrNull(unicodeEscaper.escape(i11));
    }
}
