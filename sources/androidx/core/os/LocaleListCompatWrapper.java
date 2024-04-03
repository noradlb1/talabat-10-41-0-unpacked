package androidx.core.os;

import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

final class LocaleListCompatWrapper implements LocaleListInterface {
    private static final Locale EN_LATN = LocaleListCompat.a("en-Latn");
    private static final Locale LOCALE_AR_XB = new Locale(ArchiveStreamFactory.AR, "XB");
    private static final Locale LOCALE_EN_XA = new Locale("en", "XA");
    private static final Locale[] sEmptyList = new Locale[0];
    private final Locale[] mList;
    @NonNull
    private final String mStringRepresentation;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static String a(Locale locale) {
            return locale.getScript();
        }
    }

    public LocaleListCompatWrapper(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        while (i11 < localeArr.length) {
            Locale locale = localeArr[i11];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    a(sb2, locale2);
                    if (i11 < localeArr.length - 1) {
                        sb2.append(AbstractJsonLexerKt.COMMA);
                    }
                    hashSet.add(locale2);
                }
                i11++;
            } else {
                throw new NullPointerException("list[" + i11 + "] is null");
            }
        }
        this.mList = (Locale[]) arrayList.toArray(new Locale[0]);
        this.mStringRepresentation = sb2.toString();
    }

    @VisibleForTesting
    public static void a(StringBuilder sb2, Locale locale) {
        sb2.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb2.append(SignatureVisitor.SUPER);
            sb2.append(locale.getCountry());
        }
    }

    private Locale computeFirstMatch(Collection<String> collection, boolean z11) {
        int computeFirstMatchIndex = computeFirstMatchIndex(collection, z11);
        if (computeFirstMatchIndex == -1) {
            return null;
        }
        return this.mList[computeFirstMatchIndex];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r6 < Integer.MAX_VALUE) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int computeFirstMatchIndex(java.util.Collection<java.lang.String> r5, boolean r6) {
        /*
            r4 = this;
            java.util.Locale[] r0 = r4.mList
            int r1 = r0.length
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x0008
            return r3
        L_0x0008:
            int r0 = r0.length
            if (r0 != 0) goto L_0x000d
            r5 = -1
            return r5
        L_0x000d:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == 0) goto L_0x001e
            java.util.Locale r6 = EN_LATN
            int r6 = r4.findFirstMatchIndex(r6)
            if (r6 != 0) goto L_0x001b
            return r3
        L_0x001b:
            if (r6 >= r0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r6 = r0
        L_0x001f:
            java.util.Iterator r5 = r5.iterator()
        L_0x0023:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Locale r1 = androidx.core.os.LocaleListCompat.a(r1)
            int r1 = r4.findFirstMatchIndex(r1)
            if (r1 != 0) goto L_0x003a
            return r3
        L_0x003a:
            if (r1 >= r6) goto L_0x0023
            r6 = r1
            goto L_0x0023
        L_0x003e:
            if (r6 != r0) goto L_0x0041
            return r3
        L_0x0041:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.os.LocaleListCompatWrapper.computeFirstMatchIndex(java.util.Collection, boolean):int");
    }

    private int findFirstMatchIndex(Locale locale) {
        int i11 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i11 >= localeArr.length) {
                return Integer.MAX_VALUE;
            }
            if (matchScore(locale, localeArr[i11]) > 0) {
                return i11;
            }
            i11++;
        }
    }

    private static String getLikelyScript(Locale locale) {
        String a11 = Api21Impl.a(locale);
        if (!a11.isEmpty()) {
            return a11;
        }
        return "";
    }

    private static boolean isPseudoLocale(Locale locale) {
        return LOCALE_EN_XA.equals(locale) || LOCALE_AR_XB.equals(locale);
    }

    @IntRange(from = 0, to = 1)
    private static int matchScore(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
            return 0;
        }
        String likelyScript = getLikelyScript(locale);
        if (!likelyScript.isEmpty()) {
            return likelyScript.equals(getLikelyScript(locale2)) ? 1 : 0;
        }
        String country = locale.getCountry();
        if (country.isEmpty() || country.equals(locale2.getCountry())) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).mList;
        if (this.mList.length != localeArr.length) {
            return false;
        }
        int i11 = 0;
        while (true) {
            Locale[] localeArr2 = this.mList;
            if (i11 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i11].equals(localeArr[i11])) {
                return false;
            }
            i11++;
        }
    }

    public Locale get(int i11) {
        if (i11 >= 0) {
            Locale[] localeArr = this.mList;
            if (i11 < localeArr.length) {
                return localeArr[i11];
            }
        }
        return null;
    }

    public Locale getFirstMatch(@NonNull String[] strArr) {
        return computeFirstMatch(Arrays.asList(strArr), false);
    }

    @Nullable
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        int i11 = 1;
        for (Locale hashCode : this.mList) {
            i11 = (i11 * 31) + hashCode.hashCode();
        }
        return i11;
    }

    public int indexOf(Locale locale) {
        int i11 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i11 >= localeArr.length) {
                return -1;
            }
            if (localeArr[i11].equals(locale)) {
                return i11;
            }
            i11++;
        }
    }

    public boolean isEmpty() {
        return this.mList.length == 0;
    }

    public int size() {
        return this.mList.length;
    }

    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i11 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i11 < localeArr.length) {
                sb2.append(localeArr[i11]);
                if (i11 < this.mList.length - 1) {
                    sb2.append(AbstractJsonLexerKt.COMMA);
                }
                i11++;
            } else {
                sb2.append("]");
                return sb2.toString();
            }
        }
    }
}
