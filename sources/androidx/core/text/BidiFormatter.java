package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.google.common.base.Ascii;
import java.util.Locale;
import kotlin.text.Typography;
import net.bytebuddy.pool.TypePool;

public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '‪';
    private static final char LRM = '‎';
    private static final String LRM_STRING = Character.toString(LRM);
    private static final char PDF = '‬';
    private static final char RLE = '‫';
    private static final char RLM = '‏';
    private static final String RLM_STRING = Character.toString(RLM);

    /* renamed from: a  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f11418a;

    /* renamed from: b  reason: collision with root package name */
    public static final BidiFormatter f11419b;

    /* renamed from: c  reason: collision with root package name */
    public static final BidiFormatter f11420c;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    public static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        static {
            for (int i11 = 0; i11 < DIR_TYPE_CACHE_SIZE; i11++) {
                DIR_TYPE_CACHE[i11] = Character.getDirectionality(i11);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence, boolean z11) {
            this.text = charSequence;
            this.isHtml = z11;
            this.length = charSequence.length();
        }

        private static byte getCachedDirectionality(char c11) {
            return c11 < DIR_TYPE_CACHE_SIZE ? DIR_TYPE_CACHE[c11] : Character.getDirectionality(c11);
        }

        private byte skipEntityBackward() {
            char charAt;
            int i11 = this.charIndex;
            do {
                int i12 = this.charIndex;
                if (i12 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i13 = i12 - 1;
                this.charIndex = i13;
                charAt = charSequence.charAt(i13);
                this.lastChar = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.charIndex = i11;
            this.lastChar = TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
            return Ascii.CR;
        }

        private byte skipEntityForward() {
            char charAt;
            do {
                int i11 = this.charIndex;
                if (i11 >= this.length) {
                    return 12;
                }
                CharSequence charSequence = this.text;
                this.charIndex = i11 + 1;
                charAt = charSequence.charAt(i11);
                this.lastChar = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte skipTagBackward() {
            char charAt;
            int i11 = this.charIndex;
            while (true) {
                int i12 = this.charIndex;
                if (i12 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i13 = i12 - 1;
                this.charIndex = i13;
                char charAt2 = charSequence.charAt(i13);
                this.lastChar = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i14 = this.charIndex;
                        if (i14 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.text;
                        int i15 = i14 - 1;
                        this.charIndex = i15;
                        charAt = charSequence2.charAt(i15);
                        this.lastChar = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.charIndex = i11;
            this.lastChar = Typography.greater;
            return Ascii.CR;
        }

        private byte skipTagForward() {
            char charAt;
            int i11 = this.charIndex;
            while (true) {
                int i12 = this.charIndex;
                if (i12 < this.length) {
                    CharSequence charSequence = this.text;
                    this.charIndex = i12 + 1;
                    char charAt2 = charSequence.charAt(i12);
                    this.lastChar = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i13 = this.charIndex;
                            if (i13 >= this.length) {
                                break;
                            }
                            CharSequence charSequence2 = this.text;
                            this.charIndex = i13 + 1;
                            charAt = charSequence2.charAt(i13);
                            this.lastChar = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.charIndex = i11;
                    this.lastChar = Typography.less;
                    return Ascii.CR;
                }
            }
        }

        public byte a() {
            char charAt = this.text.charAt(this.charIndex - 1);
            this.lastChar = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            char c11 = this.lastChar;
            if (c11 == '>') {
                return skipTagBackward();
            }
            if (c11 == ';') {
                return skipEntityBackward();
            }
            return cachedDirectionality;
        }

        public byte b() {
            char charAt = this.text.charAt(this.charIndex);
            this.lastChar = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            char c11 = this.lastChar;
            if (c11 == '<') {
                return skipTagForward();
            }
            if (c11 == '&') {
                return skipEntityForward();
            }
            return cachedDirectionality;
        }

        public int c() {
            this.charIndex = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (this.charIndex < this.length && i11 == 0) {
                byte b11 = b();
                if (b11 != 0) {
                    if (b11 == 1 || b11 == 2) {
                        if (i13 == 0) {
                            return 1;
                        }
                    } else if (b11 != 9) {
                        switch (b11) {
                            case 14:
                            case 15:
                                i13++;
                                i12 = -1;
                                continue;
                            case 16:
                            case 17:
                                i13++;
                                i12 = 1;
                                continue;
                            case 18:
                                i13--;
                                i12 = 0;
                                continue;
                        }
                    }
                } else if (i13 == 0) {
                    return -1;
                }
                i11 = i13;
            }
            if (i11 == 0) {
                return 0;
            }
            if (i12 != 0) {
                return i12;
            }
            while (this.charIndex > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i11 == i13) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i11 == i13) {
                            return 1;
                        }
                        break;
                    case 18:
                        i13++;
                        continue;
                }
                i13--;
            }
            return 0;
        }

        public int d() {
            this.charIndex = this.length;
            int i11 = 0;
            while (true) {
                int i12 = i11;
                while (this.charIndex > 0) {
                    byte a11 = a();
                    if (a11 != 0) {
                        if (a11 == 1 || a11 == 2) {
                            if (i11 == 0) {
                                return 1;
                            }
                            if (i12 == 0) {
                            }
                        } else if (a11 != 9) {
                            switch (a11) {
                                case 14:
                                case 15:
                                    if (i12 == i11) {
                                        return -1;
                                    }
                                    break;
                                case 16:
                                case 17:
                                    if (i12 == i11) {
                                        return 1;
                                    }
                                    break;
                                case 18:
                                    i11++;
                                    break;
                                default:
                                    if (i12 != 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            i11--;
                        } else {
                            continue;
                        }
                    } else if (i11 == 0) {
                        return -1;
                    } else {
                        if (i12 == 0) {
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        f11418a = textDirectionHeuristicCompat;
        f11419b = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        f11420c = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    public BidiFormatter(boolean z11, int i11, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z11;
        this.mFlags = i11;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    public static boolean a(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int getEntryDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).c();
    }

    private static int getExitDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).d();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getExitDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (!this.mIsRtlContext) {
            return "";
        }
        if (!isRtl || getExitDir(charSequence) == -1) {
            return RLM_STRING;
        }
        return "";
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getEntryDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (!this.mIsRtlContext) {
            return "";
        }
        if (!isRtl || getEntryDir(charSequence) == -1) {
            return RLM_STRING;
        }
        return "";
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z11) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z11).toString();
    }

    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.a(Locale.getDefault()));
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z11) {
            return z11 ? BidiFormatter.f11420c : BidiFormatter.f11419b;
        }

        private void initialize(boolean z11) {
            this.mIsRtlContext = z11;
            this.mTextDirectionHeuristicCompat = BidiFormatter.f11418a;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.f11418a) {
                return getDefaultInstanceFromContext(this.mIsRtlContext);
            }
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z11) {
            if (z11) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }

        public Builder(boolean z11) {
            initialize(z11);
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.a(locale));
        }
    }

    public static BidiFormatter getInstance(boolean z11) {
        return new Builder(z11).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z11) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z11) {
            spannableStringBuilder.append(markBefore(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(isRtl ? RLE : LRE);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(PDF);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z11) {
            spannableStringBuilder.append(markAfter(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z11) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z11);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z11) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z11);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }
}
