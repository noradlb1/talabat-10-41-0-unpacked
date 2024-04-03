package com.iab.omid.library.deliveryhero3;

import com.iab.omid.library.deliveryhero3.utils.g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f44935a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f44936b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f44937c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f44938d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f44939e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f44940f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f44941g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    public static String a(String str, String str2) {
        g.a(str, "HTML is null or empty");
        int[][] a11 = a(str);
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length() + 16);
        if (b(str, sb2, f44936b, str2, a11)) {
            return sb2.toString();
        }
        if (a(str, sb2, f44935a, str2, a11)) {
            return sb2.toString();
        }
        if (b(str, sb2, f44938d, str2, a11)) {
            return sb2.toString();
        }
        if (a(str, sb2, f44937c, str2, a11)) {
            return sb2.toString();
        }
        if (b(str, sb2, f44940f, str2, a11)) {
            return sb2.toString();
        }
        if (a(str, sb2, f44939e, str2, a11)) {
            return sb2.toString();
        }
        if (a(str, sb2, f44941g, str2, a11)) {
            return sb2.toString();
        }
        return str2 + str;
    }

    private static boolean a(int i11, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i11 >= iArr2[0] && i11 <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(String str, StringBuilder sb2, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i11 = 0;
        while (matcher.find(i11)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(start, iArr)) {
                sb2.append(str.substring(0, matcher.end()));
                sb2.append(str2);
                sb2.append(str.substring(matcher.end()));
                return true;
            }
            i11 = end;
        }
        return false;
    }

    private static int[][] a(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            int indexOf = str.indexOf("<!--", i11);
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf("-->", indexOf);
                int[] iArr = new int[2];
                if (indexOf2 >= 0) {
                    iArr[0] = indexOf;
                    iArr[1] = indexOf2;
                    arrayList.add(iArr);
                    i11 = indexOf2 + 3;
                } else {
                    iArr[0] = indexOf;
                    iArr[1] = length;
                    arrayList.add(iArr);
                }
            }
            i11 = length;
        }
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance(Integer.TYPE, new int[]{0, 2}));
    }

    public static String b(String str, String str2) {
        return a(str2, "<script type=\"text/javascript\">" + str + "</script>");
    }

    private static boolean b(String str, StringBuilder sb2, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i11 = 0;
        while (matcher.find(i11)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(start, iArr)) {
                sb2.append(str.substring(0, matcher.end() - 2));
                sb2.append(">");
                sb2.append(str2);
                sb2.append("</");
                sb2.append(matcher.group(1));
                sb2.append(">");
                sb2.append(str.substring(matcher.end()));
                return true;
            }
            i11 = end;
        }
        return false;
    }
}
