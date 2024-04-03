package com.visa.checkout;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebView;
import java.util.Iterator;

final class u {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f407 = 0;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long f408 = 7199266767484258638L;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f409 = 1;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6308(java.lang.String r7, int r8, java.lang.String r9, java.lang.String r10, char r11) {
        /*
            r0 = 0
            r1 = 2
            if (r10 == 0) goto L_0x0018
            int r2 = f409
            int r2 = r2 + 29
            int r3 = r2 % 128
            f407 = r3
            int r2 = r2 % r1
            if (r2 != 0) goto L_0x0014
            char[] r10 = r10.toCharArray()
            goto L_0x0018
        L_0x0014:
            r10.toCharArray()
            throw r0
        L_0x0018:
            char[] r10 = (char[]) r10
            if (r9 == 0) goto L_0x0020
            char[] r9 = r9.toCharArray()
        L_0x0020:
            char[] r9 = (char[]) r9
            r2 = 73
            if (r7 == 0) goto L_0x0029
            r3 = 42
            goto L_0x002a
        L_0x0029:
            r3 = r2
        L_0x002a:
            if (r3 == r2) goto L_0x0048
            int r2 = f409
            int r2 = r2 + 31
            int r3 = r2 % 128
            f407 = r3
            int r2 = r2 % r1
            r3 = 18
            if (r2 == 0) goto L_0x003c
            r2 = 83
            goto L_0x003d
        L_0x003c:
            r2 = r3
        L_0x003d:
            if (r2 != r3) goto L_0x0044
            char[] r7 = r7.toCharArray()
            goto L_0x0048
        L_0x0044:
            r7.toCharArray()
            throw r0
        L_0x0048:
            char[] r7 = (char[]) r7
            java.lang.Object r10 = r10.clone()
            char[] r10 = (char[]) r10
            java.lang.Object r7 = r7.clone()
            char[] r7 = (char[]) r7
            r0 = 0
            char r2 = r10[r0]
            r11 = r11 ^ r2
            char r11 = (char) r11
            r10[r0] = r11
            char r11 = r7[r1]
            char r8 = (char) r8
            int r11 = r11 + r8
            char r8 = (char) r11
            r7[r1] = r8
            int r8 = r9.length
            char[] r11 = new char[r8]
            r2 = r0
        L_0x0068:
            r3 = 1
            if (r2 >= r8) goto L_0x006d
            r4 = r3
            goto L_0x006e
        L_0x006d:
            r4 = r0
        L_0x006e:
            if (r4 == r3) goto L_0x0076
            java.lang.String r7 = new java.lang.String
            r7.<init>(r11)
            return r7
        L_0x0076:
            int r3 = f407
            int r3 = r3 + 93
            int r4 = r3 % 128
            f409 = r4
            int r3 = r3 % r1
            com.c.c.c.m9225(r10, r7, r2)
            char r3 = r9[r2]
            int r4 = r2 + 3
            int r4 = r4 % 4
            char r4 = r10[r4]
            r3 = r3 ^ r4
            long r3 = (long) r3
            long r5 = f408
            long r3 = r3 ^ r5
            int r3 = (int) r3
            char r3 = (char) r3
            r11[r2] = r3
            int r2 = r2 + 1
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.u.m6308(java.lang.String, int, java.lang.String, java.lang.String, char):java.lang.String");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m6309(int i11, DisplayMetrics displayMetrics) {
        int i12 = f409 + 59;
        f407 = i12 % 128;
        int i13 = i12 % 2;
        int round = Math.round(((float) i11) * displayMetrics.density);
        int i14 = f409 + 17;
        f407 = i14 % 128;
        int i15 = i14 % 2;
        return round;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Activity m6311(View view) {
        int i11 = f407 + 21;
        f409 = i11 % 128;
        if (i11 % 2 != 0) {
            Context context = view.getContext();
            if (context instanceof Activity) {
                return (Activity) context;
            }
            while (context instanceof ContextWrapper) {
                int i12 = f407 + 49;
                f409 = i12 % 128;
                boolean z11 = false;
                if (!(i12 % 2 == 0)) {
                    if (!(context instanceof Activity)) {
                        z11 = true;
                    }
                    if (!z11) {
                        return (Activity) context;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                    int i13 = f407 + 97;
                    f409 = i13 % 128;
                    int i14 = i13 % 2;
                } else {
                    boolean z12 = context instanceof Activity;
                    throw null;
                }
            }
            return null;
        }
        boolean z13 = view.getContext() instanceof Activity;
        throw null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m6310(WebView webView, boolean z11) {
        String str;
        int i11 = f407 + 19;
        f409 = i11 % 128;
        int i12 = i11 % 2;
        if (!(!z11)) {
            str = m6308("襎伬揨", 0, "ꢌ䕂땈ڷ", "뿪៚?퉧", 26586).intern();
            int i13 = f407 + 111;
            f409 = i13 % 128;
            int i14 = i13 % 2;
        } else {
            str = m6308("襎伬揨", 123583630, "蟏箲豯", "軗嶼╙", 23011).intern();
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(userAgentString);
        sb2.append(m6308("襎伬揨", 41884585, "岨晆瓿悃꟦", "ꦩ缛٤", 25840).intern());
        sb2.append(str);
        sb2.append(m6308("襎伬揨", 370472239, "ၗ", "⼚ᓵ㰖红", 41532).intern());
        sb2.append(m6308("襎伬揨", -137024992, "灪벫傡", "⁚픪˷懌", 52226).intern());
        String obj = sb2.toString();
        int i15 = f407 + 17;
        f409 = i15 % 128;
        int i16 = i15 % 2;
        return obj;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m6312(Context context, String str) {
        Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(0).iterator();
        do {
            if ((it.hasNext() ? 'M' : 18) != 18) {
                int i11 = f407 + 83;
                f409 = i11 % 128;
                if (i11 % 2 == 0) {
                    it.next().packageName.equalsIgnoreCase(str);
                    throw null;
                }
            } else {
                int i12 = f407 + 11;
                f409 = i12 % 128;
                int i13 = i12 % 2;
                return false;
            }
        } while (!it.next().packageName.equalsIgnoreCase(str));
        int i14 = f407 + 105;
        f409 = i14 % 128;
        if (i14 % 2 == 0) {
            return false;
        }
        return true;
    }
}
