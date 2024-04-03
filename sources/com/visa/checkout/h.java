package com.visa.checkout;

import java.nio.charset.StandardCharsets;
import java.util.Map;

final class h {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static int f222 = 0;

    /* renamed from: ʽ  reason: contains not printable characters */
    private static long f223 = -8391260755802157274L;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static int f224 = 1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Map<String, String> f225;

    /* renamed from: ˋ  reason: contains not printable characters */
    private byte[] f226;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f227;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f228;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f229;

    public h(String str, String str2, Map<String, String> map, String str3, String str4) {
        String str5;
        byte[] bArr;
        this.f227 = str;
        if (str2 != null) {
            str5 = str2.toUpperCase();
        } else {
            str5 = m6179("൏舮闽ꢟ").intern();
        }
        this.f228 = str5;
        this.f225 = map;
        if (str3 == null) {
            bArr = new byte[0];
        } else {
            bArr = str3.getBytes(StandardCharsets.UTF_8);
        }
        this.f226 = bArr;
        this.f229 = str4;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final Map<String, String> m6180() {
        int i11 = f222 + 27;
        int i12 = i11 % 128;
        f224 = i12;
        if (i11 % 2 != 0) {
            Map<String, String> map = this.f225;
            int i13 = i12 + 19;
            f222 = i13 % 128;
            int i14 = i13 % 2;
            return map;
        }
        throw null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final String m6181() {
        String str;
        int i11 = f222 + 57;
        int i12 = i11 % 128;
        f224 = i12;
        if ((i11 % 2 == 0 ? 'W' : '0') != '0') {
            str = this.f229;
            int i13 = 65 / 0;
        } else {
            str = this.f229;
        }
        int i14 = i12 + 121;
        f222 = i14 % 128;
        int i15 = i14 % 2;
        return str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final String m6182() {
        String str;
        int i11 = f222;
        int i12 = i11 + 103;
        f224 = i12 % 128;
        boolean z11 = false;
        if ((i12 % 2 == 0 ? 'U' : '5') != '5') {
            str = this.f227;
            int i13 = 91 / 0;
        } else {
            str = this.f227;
        }
        int i14 = i11 + 29;
        f224 = i14 % 128;
        if (i14 % 2 != 0) {
            z11 = true;
        }
        if (z11) {
            return str;
        }
        throw null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m6183() {
        int i11 = f222;
        int i12 = i11 + 53;
        f224 = i12 % 128;
        int i13 = i12 % 2;
        String str = this.f228;
        int i14 = i11 + 123;
        f224 = i14 % 128;
        int i15 = i14 % 2;
        return str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final byte[] m6184() {
        int i11 = f224 + 61;
        f222 = i11 % 128;
        if ((i11 % 2 != 0 ? 'T' : 5) != 'T') {
            return this.f226;
        }
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6179(java.lang.String r10) {
        /*
            int r0 = f222
            int r1 = r0 + 91
            int r2 = r1 % 128
            f224 = r2
            int r1 = r1 % 2
            r1 = 82
            if (r10 == 0) goto L_0x0011
            r2 = 34
            goto L_0x0012
        L_0x0011:
            r2 = r1
        L_0x0012:
            if (r2 == r1) goto L_0x0030
            int r0 = r0 + 115
            int r1 = r0 % 128
            f224 = r1
            int r0 = r0 % 2
            r1 = 89
            if (r0 != 0) goto L_0x0022
            r0 = r1
            goto L_0x0024
        L_0x0022:
            r0 = 75
        L_0x0024:
            if (r0 == r1) goto L_0x002b
            char[] r10 = r10.toCharArray()
            goto L_0x0030
        L_0x002b:
            r10.toCharArray()
            r10 = 0
            throw r10
        L_0x0030:
            char[] r10 = (char[]) r10
            r0 = 0
            char r1 = r10[r0]
            int r2 = r10.length
            r3 = 1
            int r2 = r2 - r3
            char[] r2 = new char[r2]
            r4 = r3
        L_0x003b:
            int r5 = r10.length
            if (r4 >= r5) goto L_0x0040
            r5 = r0
            goto L_0x0041
        L_0x0040:
            r5 = r3
        L_0x0041:
            if (r5 == r3) goto L_0x0073
            int r5 = f224
            int r5 = r5 + 87
            int r6 = r5 % 128
            f222 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0061
            int r5 = r4 + 0
            char r6 = r10[r4]
            int r7 = r4 >>> r1
            int r6 = r6 * r7
            long r6 = (long) r6
            long r8 = f223
            long r6 = r6 * r8
            int r6 = (int) r6
            char r6 = (char) r6
            r2[r5] = r6
            int r4 = r4 + 18
            goto L_0x003b
        L_0x0061:
            int r5 = r4 + -1
            char r6 = r10[r4]
            int r7 = r4 * r1
            r6 = r6 ^ r7
            long r6 = (long) r6
            long r8 = f223
            long r6 = r6 ^ r8
            int r6 = (int) r6
            char r6 = (char) r6
            r2[r5] = r6
            int r4 = r4 + 1
            goto L_0x003b
        L_0x0073:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r2)
            int r0 = f224
            int r0 = r0 + 115
            int r1 = r0 % 128
            f222 = r1
            int r0 = r0 % 2
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.h.m6179(java.lang.String):java.lang.String");
    }
}
