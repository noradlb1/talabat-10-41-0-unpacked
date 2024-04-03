package com.visa.checkout;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
abstract class i {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f230 = 8;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f231 = 1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f232;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Object f233;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static i m6185(Object obj) {
        boolean z11;
        AnonymousClass3 r02 = new i() {
            /* renamed from: ˏ  reason: contains not printable characters */
            public final String m6190() {
                return null;
            }
        };
        r02.f233 = obj;
        int i11 = f232 + 107;
        f231 = i11 % 128;
        if (i11 % 2 == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return r02;
        }
        throw null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static i m6186(final String str) {
        AnonymousClass5 r02 = new i() {
            /* renamed from: ˏ  reason: contains not printable characters */
            public final String m6191() {
                return str;
            }
        };
        int i11 = f231 + 113;
        f232 = i11 % 128;
        if (i11 % 2 == 0) {
            return r02;
        }
        int i12 = 76 / 0;
        return r02;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m6188(String str) {
        char c11;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(m6187(1, "\u0006�\u0005￹", 112, true, 4).intern(), (Object) m6187(4, "\u0004\u0006�\u0005\u0003￶", 119, false, 6).intern());
            jSONObject.put(m6187(1, "\u0003￾", 110, true, 2).intern(), (Object) str);
            jSONObject.put(m6187(3, "\u0004\u0004￷\u0004\u0001", 118, true, 5).intern(), (Object) m6189());
            jSONObject.put(m6187(3, "￻\u000e￻￾", 110, false, 4).intern(), this.f233);
        } catch (JSONException unused) {
        }
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
        int i11 = f231 + 101;
        f232 = i11 % 128;
        if (i11 % 2 != 0) {
            c11 = CharUtils.CR;
        } else {
            c11 = 31;
        }
        if (c11 == 31) {
            return jSONObjectInstrumentation;
        }
        throw null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract String m6189();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6187(int r6, java.lang.String r7, int r8, boolean r9, int r10) {
        /*
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L_0x0006
            r2 = r0
            goto L_0x0007
        L_0x0006:
            r2 = r1
        L_0x0007:
            if (r2 == 0) goto L_0x001f
            int r2 = f232
            int r2 = r2 + 29
            int r3 = r2 % 128
            f231 = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x001a
            char[] r7 = r7.toCharArray()
            goto L_0x001f
        L_0x001a:
            r7.toCharArray()
            r6 = 0
            throw r6
        L_0x001f:
            char[] r7 = (char[]) r7
            char[] r2 = new char[r10]
            r3 = r1
        L_0x0024:
            if (r3 >= r10) goto L_0x0028
            r4 = r1
            goto L_0x0029
        L_0x0028:
            r4 = r0
        L_0x0029:
            if (r4 == r0) goto L_0x0044
            char r4 = r7[r3]
            int r4 = r4 + r8
            char r4 = (char) r4
            r2[r3] = r4
            int r5 = f230
            int r4 = r4 - r5
            char r4 = (char) r4
            r2[r3] = r4
            int r3 = r3 + 1
            int r4 = f232
            int r4 = r4 + 61
            int r5 = r4 % 128
            f231 = r5
            int r4 = r4 % 2
            goto L_0x0024
        L_0x0044:
            if (r6 <= 0) goto L_0x0053
            char[] r7 = new char[r10]
            java.lang.System.arraycopy(r2, r1, r7, r1, r10)
            int r8 = r10 - r6
            java.lang.System.arraycopy(r7, r1, r2, r8, r6)
            java.lang.System.arraycopy(r7, r6, r2, r1, r8)
        L_0x0053:
            if (r9 == 0) goto L_0x0057
            r6 = r1
            goto L_0x0058
        L_0x0057:
            r6 = r0
        L_0x0058:
            if (r6 == r0) goto L_0x0073
            char[] r6 = new char[r10]
        L_0x005c:
            if (r1 >= r10) goto L_0x0072
            int r7 = f231
            int r7 = r7 + 71
            int r8 = r7 % 128
            f232 = r8
            int r7 = r7 % 2
            int r7 = r10 - r1
            int r7 = r7 - r0
            char r7 = r2[r7]
            r6[r1] = r7
            int r1 = r1 + 1
            goto L_0x005c
        L_0x0072:
            r2 = r6
        L_0x0073:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.i.m6187(int, java.lang.String, int, boolean, int):java.lang.String");
    }
}
