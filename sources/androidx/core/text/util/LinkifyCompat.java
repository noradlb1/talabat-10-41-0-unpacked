package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR = new a();
    private static final String[] EMPTY_STRING = new String[0];

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void a(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
        }

        @DoNotInline
        public static boolean b(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
    }

    public static class LinkSpec {

        /* renamed from: a  reason: collision with root package name */
        public URLSpan f11429a;

        /* renamed from: b  reason: collision with root package name */
        public String f11430b;

        /* renamed from: c  reason: collision with root package name */
        public int f11431c;

        /* renamed from: d  reason: collision with root package name */
        public int f11432d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(@NonNull TextView textView) {
        if (!(textView.getMovementMethod() instanceof LinkMovementMethod) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, int i11) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, i11);
        }
        if (i11 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i11 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i11 & 1) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, (Linkify.TransformFilter) null);
        }
        if ((i11 & 2) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
        if ((i11 & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it.next();
            if (linkSpec.f11429a == null) {
                applyLink(linkSpec.f11430b, linkSpec.f11431c, linkSpec.f11432d, spannable);
            }
        }
        return true;
    }

    private static void applyLink(String str, int i11, int i12, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i11, i12, 33);
    }

    private static String findAddress(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            return WebView.findAddress(str);
        }
        return FindAddress.a(str);
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if ((matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) && group != null) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.f11430b = makeUrl(group, strArr, matcher, transformFilter);
                linkSpec.f11431c = start;
                linkSpec.f11432d = end;
                arrayList.add(linkSpec);
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0005 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A[LOOP:0: B:1:0x0005->B:14:0x0005, LOOP_START, PHI: r0 r6 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:0:0x0000, B:14:0x0005] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r6v2 java.lang.String) = (r6v1 java.lang.String), (r6v3 java.lang.String) binds: [B:0:0x0000, B:14:0x0005] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void gatherMapLinks(java.util.ArrayList<androidx.core.text.util.LinkifyCompat.LinkSpec> r5, android.text.Spannable r6) {
        /*
            java.lang.String r6 = r6.toString()
            r0 = 0
        L_0x0005:
            java.lang.String r1 = findAddress(r6)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            if (r1 == 0) goto L_0x0043
            int r2 = r6.indexOf(r1)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            if (r2 >= 0) goto L_0x0012
            goto L_0x0043
        L_0x0012:
            androidx.core.text.util.LinkifyCompat$LinkSpec r3 = new androidx.core.text.util.LinkifyCompat$LinkSpec     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r3.<init>()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r4 = r1.length()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r4 = r4 + r2
            int r2 = r2 + r0
            r3.f11431c = r2     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r0 = r0 + r4
            r3.f11432d = r0     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r6 = r6.substring(r4)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r2 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x0005 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r2.<init>()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r4 = "geo:0,0?q="
            r2.append(r4)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r2.append(r1)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r1 = r2.toString()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r3.f11430b = r1     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r5.add(r3)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            goto L_0x0005
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.LinkifyCompat.gatherMapLinks(java.util.ArrayList, android.text.Spannable):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(LinkSpec linkSpec, LinkSpec linkSpec2) {
        int i11 = linkSpec.f11431c;
        int i12 = linkSpec2.f11431c;
        if (i11 < i12) {
            return -1;
        }
        if (i11 > i12) {
            return 1;
        }
        return Integer.compare(linkSpec2.f11432d, linkSpec.f11432d);
    }

    private static String makeUrl(@NonNull String str, @NonNull String[] strArr, Matcher matcher, @Nullable Linkify.TransformFilter transformFilter) {
        boolean z11;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                z11 = false;
                break;
            }
            String str2 = strArr[i11];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                z11 = true;
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i11++;
            }
        }
        if (z11 || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int i11;
        int i12;
        int i13 = 0;
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            LinkSpec linkSpec = new LinkSpec();
            linkSpec.f11429a = uRLSpan;
            linkSpec.f11431c = spannable.getSpanStart(uRLSpan);
            linkSpec.f11432d = spannable.getSpanEnd(uRLSpan);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i13 < size - 1) {
            LinkSpec linkSpec2 = arrayList.get(i13);
            int i14 = i13 + 1;
            LinkSpec linkSpec3 = arrayList.get(i14);
            int i15 = linkSpec2.f11431c;
            int i16 = linkSpec3.f11431c;
            if (i15 <= i16 && (i11 = linkSpec2.f11432d) > i16) {
                int i17 = linkSpec3.f11432d;
                if (i17 <= i11 || i11 - i15 > i17 - i16) {
                    i12 = i14;
                } else if (i11 - i15 < i17 - i16) {
                    i12 = i13;
                } else {
                    i12 = -1;
                }
                if (i12 != -1) {
                    URLSpan uRLSpan2 = arrayList.get(i12).f11429a;
                    if (uRLSpan2 != null) {
                        spannable.removeSpan(uRLSpan2);
                    }
                    arrayList.remove(i12);
                    size--;
                }
            }
            i13 = i14;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean addLinks(@NonNull TextView textView, int i11) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(textView, i11);
        }
        if (i11 == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            SpannableString valueOf = SpannableString.valueOf(text);
            if (addLinks((Spannable) valueOf, i11)) {
                addLinkMovementMethod(textView);
                textView.setText(valueOf);
                return true;
            }
        } else if (addLinks((Spannable) text, i11)) {
            addLinkMovementMethod(textView);
            return true;
        }
        return false;
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Api24Impl.a(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks((Spannable) valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str);
        }
        return addLinks(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter);
        }
        return addLinks(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        String str2;
        if (shouldAddLinksFallbackToFramework()) {
            return Api24Impl.b(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = EMPTY_STRING;
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i11 = 0;
        while (i11 < strArr.length) {
            String str3 = strArr[i11];
            i11++;
            if (str3 == null) {
                str2 = "";
            } else {
                str2 = str3.toLowerCase(Locale.ROOT);
            }
            strArr2[i11] = str2;
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z11 = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if ((matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) && group != null) {
                applyLink(makeUrl(group, strArr2, matcher, transformFilter), start, end, spannable);
                z11 = true;
            }
        }
        return z11;
    }
}
