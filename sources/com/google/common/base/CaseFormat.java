package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.utility.JavaConstant;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public enum CaseFormat {
    LOWER_HYPHEN(CharMatcher.is(SignatureVisitor.SUPER), SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE) {
        public String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return str.replace(SignatureVisitor.SUPER, '_');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(str.replace(SignatureVisitor.SUPER, '_'));
            }
            return CaseFormat.super.convert(caseFormat, str);
        }

        public String normalizeWord(String str) {
            return Ascii.toLowerCase(str);
        }
    },
    LOWER_UNDERSCORE(CharMatcher.is('_'), JavaConstant.Dynamic.DEFAULT_NAME) {
        public String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return str.replace('_', SignatureVisitor.SUPER);
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(str);
            }
            return CaseFormat.super.convert(caseFormat, str);
        }

        public String normalizeWord(String str) {
            return Ascii.toLowerCase(str);
        }
    },
    LOWER_CAMEL(CharMatcher.inRange('A', 'Z'), "") {
        public String normalizeFirstWord(String str) {
            return Ascii.toLowerCase(str);
        }

        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_CAMEL(CharMatcher.inRange('A', 'Z'), "") {
        public String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_UNDERSCORE(CharMatcher.is('_'), JavaConstant.Dynamic.DEFAULT_NAME) {
        public String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return Ascii.toLowerCase(str.replace('_', SignatureVisitor.SUPER));
            }
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return Ascii.toLowerCase(str);
            }
            return CaseFormat.super.convert(caseFormat, str);
        }

        public String normalizeWord(String str) {
            return Ascii.toUpperCase(str);
        }
    };
    
    private final CharMatcher wordBoundary;
    private final String wordSeparator;

    public static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        public StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.sourceFormat = (CaseFormat) Preconditions.checkNotNull(caseFormat);
            this.targetFormat = (CaseFormat) Preconditions.checkNotNull(caseFormat2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            StringConverter stringConverter = (StringConverter) obj;
            if (!this.sourceFormat.equals(stringConverter.sourceFormat) || !this.targetFormat.equals(stringConverter.targetFormat)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }

        public String doBackward(String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        public String doForward(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }
    }

    /* access modifiers changed from: private */
    public static String firstCharOnlyToUpper(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return Ascii.toUpperCase(str.charAt(0)) + Ascii.toLowerCase(str.substring(1));
    }

    public String convert(CaseFormat caseFormat, String str) {
        StringBuilder sb2 = null;
        int i11 = 0;
        int i12 = -1;
        while (true) {
            i12 = this.wordBoundary.indexIn(str, i12 + 1);
            if (i12 == -1) {
                break;
            }
            if (i11 == 0) {
                sb2 = new StringBuilder(str.length() + (caseFormat.wordSeparator.length() * 4));
                sb2.append(caseFormat.normalizeFirstWord(str.substring(i11, i12)));
            } else {
                Objects.requireNonNull(sb2);
                sb2.append(caseFormat.normalizeWord(str.substring(i11, i12)));
            }
            sb2.append(caseFormat.wordSeparator);
            i11 = this.wordSeparator.length() + i12;
        }
        if (i11 == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        Objects.requireNonNull(sb2);
        sb2.append(caseFormat.normalizeWord(str.substring(i11)));
        return sb2.toString();
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    public String normalizeFirstWord(String str) {
        return normalizeWord(str);
    }

    public abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(caseFormat);
        Preconditions.checkNotNull(str);
        if (caseFormat == this) {
            return str;
        }
        return convert(caseFormat, str);
    }

    private CaseFormat(CharMatcher charMatcher, String str) {
        this.wordBoundary = charMatcher;
        this.wordSeparator = str;
    }
}
