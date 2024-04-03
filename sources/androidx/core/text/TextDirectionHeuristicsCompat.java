package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.f11422a, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE = TextDirectionHeuristicLocale.f11424a;
    public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, false);
    public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, true);
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    public static class AnyStrong implements TextDirectionAlgorithm {

        /* renamed from: a  reason: collision with root package name */
        public static final AnyStrong f11422a = new AnyStrong(true);
        private final boolean mLookForRtl;

        private AnyStrong(boolean z11) {
            this.mLookForRtl = z11;
        }

        public int checkRtl(CharSequence charSequence, int i11, int i12) {
            int i13 = i12 + i11;
            boolean z11 = false;
            while (i11 < i13) {
                int a11 = TextDirectionHeuristicsCompat.a(Character.getDirectionality(charSequence.charAt(i11)));
                if (a11 != 0) {
                    if (a11 != 1) {
                        continue;
                        i11++;
                    } else if (!this.mLookForRtl) {
                        return 1;
                    }
                } else if (this.mLookForRtl) {
                    return 0;
                }
                z11 = true;
                i11++;
            }
            if (z11) {
                return this.mLookForRtl ? 1 : 0;
            }
            return 2;
        }
    }

    public static class FirstStrong implements TextDirectionAlgorithm {

        /* renamed from: a  reason: collision with root package name */
        public static final FirstStrong f11423a = new FirstStrong();

        private FirstStrong() {
        }

        public int checkRtl(CharSequence charSequence, int i11, int i12) {
            int i13 = i12 + i11;
            int i14 = 2;
            while (i11 < i13 && i14 == 2) {
                i14 = TextDirectionHeuristicsCompat.b(Character.getDirectionality(charSequence.charAt(i11)));
                i11++;
            }
            return i14;
        }
    }

    public interface TextDirectionAlgorithm {
        int checkRtl(CharSequence charSequence, int i11, int i12);
    }

    public static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.mAlgorithm = textDirectionAlgorithm;
        }

        private boolean doCheck(CharSequence charSequence, int i11, int i12) {
            int checkRtl = this.mAlgorithm.checkRtl(charSequence, i11, i12);
            if (checkRtl == 0) {
                return true;
            }
            if (checkRtl != 1) {
                return a();
            }
            return false;
        }

        public abstract boolean a();

        public boolean isRtl(char[] cArr, int i11, int i12) {
            return isRtl((CharSequence) CharBuffer.wrap(cArr), i11, i12);
        }

        public boolean isRtl(CharSequence charSequence, int i11, int i12) {
            if (charSequence == null || i11 < 0 || i12 < 0 || charSequence.length() - i12 < i11) {
                throw new IllegalArgumentException();
            } else if (this.mAlgorithm == null) {
                return a();
            } else {
                return doCheck(charSequence, i11, i12);
            }
        }
    }

    public static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        public TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z11) {
            super(textDirectionAlgorithm);
            this.mDefaultIsRtl = z11;
        }

        public boolean a() {
            return this.mDefaultIsRtl;
        }
    }

    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {

        /* renamed from: a  reason: collision with root package name */
        public static final TextDirectionHeuristicLocale f11424a = new TextDirectionHeuristicLocale();

        public TextDirectionHeuristicLocale() {
            super((TextDirectionAlgorithm) null);
        }

        public boolean a() {
            return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.f11423a;
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(firstStrong, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(firstStrong, true);
    }

    private TextDirectionHeuristicsCompat() {
    }

    public static int a(int i11) {
        if (i11 != 0) {
            return (i11 == 1 || i11 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i11) {
        if (i11 != 0) {
            if (i11 == 1 || i11 == 2) {
                return 0;
            }
            switch (i11) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
