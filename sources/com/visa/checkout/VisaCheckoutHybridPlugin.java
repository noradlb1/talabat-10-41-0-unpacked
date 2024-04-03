package com.visa.checkout;

import android.webkit.WebView;

public class VisaCheckoutHybridPlugin {
    private static o mMerchantWebViewBridge = null;

    /* renamed from: ˊ  reason: contains not printable characters */
    private static long f122 = 488044333941012880L;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f123 = 0;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f124 = 1;

    public static void configure(WebView webView) {
        char c11;
        o oVar = mMerchantWebViewBridge;
        if (oVar != null) {
            oVar.m6227();
        }
        mMerchantWebViewBridge = new o(webView);
        int i11 = f123 + 1;
        f124 = i11 % 128;
        if (i11 % 2 == 0) {
            c11 = 22;
        } else {
            c11 = '^';
        }
        if (c11 != '^') {
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r10 = com.c.c.b.m9224(f122, (char[]) r10);
        r1 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r1 >= r10.length) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r10[r1] = (char) ((int) (((long) (r10[r1] ^ r10[r1 % 4])) ^ (((long) (r1 - 4)) * f122)));
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r1 = new java.lang.String(r10, 4, r10.length - 4);
        r10 = f123 + 97;
        f124 = r10 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005e, code lost:
        if ((r10 % 2) != 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
        r10 = 'U';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0062, code lost:
        r10 = 22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (r10 == 'U') goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        if (r10 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r10 == null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r0 = r0 + 85;
        f123 = r0 % 128;
        r0 = r0 % 2;
        r10 = r10.toCharArray();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6106(java.lang.String r10) {
        /*
            int r0 = f124
            int r1 = r0 + 97
            int r2 = r1 % 128
            f123 = r2
            int r1 = r1 % 2
            r2 = 37
            if (r1 == 0) goto L_0x0011
            r1 = 91
            goto L_0x0012
        L_0x0011:
            r1 = r2
        L_0x0012:
            r3 = 85
            if (r1 == r2) goto L_0x001d
            r1 = 15
            int r1 = r1 / 0
            if (r10 == 0) goto L_0x002a
            goto L_0x001f
        L_0x001d:
            if (r10 == 0) goto L_0x002a
        L_0x001f:
            int r0 = r0 + r3
            int r1 = r0 % 128
            f123 = r1
            int r0 = r0 % 2
            char[] r10 = r10.toCharArray()
        L_0x002a:
            char[] r10 = (char[]) r10
            long r0 = f122
            char[] r10 = com.c.c.b.m9224(r0, r10)
            r0 = 4
            r1 = r0
        L_0x0034:
            int r2 = r10.length
            if (r1 >= r2) goto L_0x004d
            int r2 = r1 + -4
            char r4 = r10[r1]
            int r5 = r1 % 4
            char r5 = r10[r5]
            r4 = r4 ^ r5
            long r4 = (long) r4
            long r6 = (long) r2
            long r8 = f122
            long r6 = r6 * r8
            long r4 = r4 ^ r6
            int r2 = (int) r4
            char r2 = (char) r2
            r10[r1] = r2
            int r1 = r1 + 1
            goto L_0x0034
        L_0x004d:
            java.lang.String r1 = new java.lang.String
            int r2 = r10.length
            int r2 = r2 - r0
            r1.<init>(r10, r0, r2)
            int r10 = f123
            int r10 = r10 + 97
            int r0 = r10 % 128
            f124 = r0
            int r10 = r10 % 2
            if (r10 != 0) goto L_0x0062
            r10 = r3
            goto L_0x0064
        L_0x0062:
            r10 = 22
        L_0x0064:
            if (r10 == r3) goto L_0x0067
            return r1
        L_0x0067:
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.VisaCheckoutHybridPlugin.m6106(java.lang.String):java.lang.String");
    }
}
