package com.visa.checkout;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@Instrumented
final class y {

    /* renamed from: ʼ  reason: contains not printable characters */
    private static int f422 = 1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean f423 = true;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static char[] f424 = {327, 331, 319, 325, 323, 337, 321, 336, 322, 317, 338, 268, 334, 332};

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f425;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f426 = 222;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean f427 = true;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6317(int r7, java.lang.String r8, int[] r9, java.lang.String r10) {
        /*
            if (r10 == 0) goto L_0x0008
            java.lang.String r0 = "ISO-8859-1"
            byte[] r10 = r10.getBytes(r0)
        L_0x0008:
            byte[] r10 = (byte[]) r10
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L_0x0010
            r2 = r1
            goto L_0x0011
        L_0x0010:
            r2 = r0
        L_0x0011:
            if (r2 == 0) goto L_0x002e
            int r2 = f422
            int r2 = r2 + 69
            int r3 = r2 % 128
            f425 = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x0021
            r2 = r1
            goto L_0x0022
        L_0x0021:
            r2 = r0
        L_0x0022:
            if (r2 != 0) goto L_0x0029
            char[] r8 = r8.toCharArray()
            goto L_0x002e
        L_0x0029:
            r8.toCharArray()
            r7 = 0
            throw r7
        L_0x002e:
            char[] r8 = (char[]) r8
            char[] r2 = f424
            int r3 = f426
            boolean r4 = f427
            if (r4 == 0) goto L_0x0075
            int r8 = r10.length
            char[] r9 = new char[r8]
        L_0x003b:
            if (r0 >= r8) goto L_0x006f
            int r1 = f425
            int r1 = r1 + 51
            int r4 = r1 % 128
            f422 = r4
            int r1 = r1 % 2
            r4 = 53
            if (r1 != 0) goto L_0x004e
            r1 = 13
            goto L_0x004f
        L_0x004e:
            r1 = r4
        L_0x004f:
            if (r1 == r4) goto L_0x0060
            int r1 = r8 + -1
            int r1 = r1 >> r0
            byte r1 = r10[r1]
            int r1 = r1 >>> r7
            char r1 = r2[r1]
            int r1 = r1 / r3
            char r1 = (char) r1
            r9[r0] = r1
            int r0 = r0 + 61
            goto L_0x003b
        L_0x0060:
            int r1 = r8 + -1
            int r1 = r1 - r0
            byte r1 = r10[r1]
            int r1 = r1 + r7
            char r1 = r2[r1]
            int r1 = r1 - r3
            char r1 = (char) r1
            r9[r0] = r1
            int r0 = r0 + 1
            goto L_0x003b
        L_0x006f:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r9)
            return r7
        L_0x0075:
            boolean r10 = f423
            if (r10 == 0) goto L_0x00b4
            int r9 = f422
            int r9 = r9 + 73
            int r10 = r9 % 128
            f425 = r10
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x008a
            int r9 = r8.length
            char[] r10 = new char[r9]
            r4 = r1
            goto L_0x008e
        L_0x008a:
            int r9 = r8.length
            char[] r10 = new char[r9]
            r4 = r0
        L_0x008e:
            if (r4 >= r9) goto L_0x0092
            r5 = r0
            goto L_0x0093
        L_0x0092:
            r5 = r1
        L_0x0093:
            if (r5 == 0) goto L_0x009b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r10)
            return r7
        L_0x009b:
            int r5 = f422
            int r5 = r5 + 97
            int r6 = r5 % 128
            f425 = r6
            int r5 = r5 % 2
            int r5 = r9 + -1
            int r5 = r5 - r4
            char r5 = r8[r5]
            int r5 = r5 - r7
            char r5 = r2[r5]
            int r5 = r5 - r3
            char r5 = (char) r5
            r10[r4] = r5
            int r4 = r4 + 1
            goto L_0x008e
        L_0x00b4:
            int r8 = r9.length
            char[] r10 = new char[r8]
        L_0x00b7:
            if (r0 >= r8) goto L_0x00c8
            int r1 = r8 + -1
            int r1 = r1 - r0
            r1 = r9[r1]
            int r1 = r1 - r7
            char r1 = r2[r1]
            int r1 = r1 - r3
            char r1 = (char) r1
            r10[r0] = r1
            int r0 = r0 + 1
            goto L_0x00b7
        L_0x00c8:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r10)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.y.m6317(int, java.lang.String, int[], java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d A[SYNTHETIC, Splitter:B:32:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0083 A[SYNTHETIC, Splitter:B:38:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* renamed from: ˋ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m6319(android.content.Context r5, android.graphics.Bitmap r6) {
        /*
            android.content.ContextWrapper r0 = new android.content.ContextWrapper
            android.content.Context r5 = r5.getApplicationContext()
            r0.<init>(r5)
            java.lang.String r5 = ""
            r1 = 127(0x7f, float:1.78E-43)
            r2 = 0
            java.lang.String r5 = m6317(r1, r2, r2, r5)
            java.lang.String r5 = r5.intern()
            r3 = 0
            java.io.File r5 = r0.getDir(r5, r3)
            java.io.File r0 = new java.io.File
            java.lang.String r4 = ""
            java.lang.String r1 = m6317(r1, r2, r2, r4)
            java.lang.String r1 = r1.intern()
            r0.<init>(r5, r1)
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0081, all -> 0x007a }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0081, all -> 0x007a }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            r1 = 100
            boolean r6 = r6.compress(r0, r1, r5)     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            r0 = 1
            if (r6 == 0) goto L_0x003c
            r6 = r0
            goto L_0x003d
        L_0x003c:
            r6 = r3
        L_0x003d:
            if (r6 == r0) goto L_0x0040
            goto L_0x0060
        L_0x0040:
            int r6 = f422
            int r6 = r6 + 87
            int r1 = r6 % 128
            f425 = r1
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x0053
            com.visa.checkout.VisaCheckoutSdk.notifyCustomButtonUpdated()     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            r6 = 84
            int r6 = r6 / r3
            goto L_0x0056
        L_0x0053:
            com.visa.checkout.VisaCheckoutSdk.notifyCustomButtonUpdated()     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
        L_0x0056:
            int r6 = f425
            int r6 = r6 + 15
            int r1 = r6 % 128
            f422 = r1
            int r6 = r6 % 2
        L_0x0060:
            r5.close()     // Catch:{ IOException -> 0x0074 }
            int r5 = f422
            int r5 = r5 + 57
            int r6 = r5 % 128
            f425 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0070
            r3 = r0
        L_0x0070:
            if (r3 != 0) goto L_0x0073
            return
        L_0x0073:
            throw r2
        L_0x0074:
            return
        L_0x0075:
            r6 = move-exception
            r2 = r5
            goto L_0x007b
        L_0x0078:
            r2 = r5
            goto L_0x0081
        L_0x007a:
            r6 = move-exception
        L_0x007b:
            if (r2 == 0) goto L_0x0080
            r2.close()     // Catch:{ IOException -> 0x0080 }
        L_0x0080:
            throw r6
        L_0x0081:
            if (r2 == 0) goto L_0x0091
            r2.close()     // Catch:{ IOException -> 0x0091 }
            int r5 = f422
            int r5 = r5 + 31
            int r6 = r5 % 128
            f425 = r6
            int r5 = r5 % 2
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.y.m6319(android.content.Context, android.graphics.Bitmap):void");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Drawable m6320(Context context) {
        char c11;
        char c12;
        try {
            Bitmap decodeStream = BitmapFactoryInstrumentation.decodeStream(new FileInputStream(new File(new ContextWrapper(context.getApplicationContext()).getDir(m6317(127, (String) null, (int[]) null, "").intern(), 0).getAbsolutePath(), m6317(127, (String) null, (int[]) null, "").intern())));
            if (decodeStream == null) {
                c11 = 12;
            } else {
                c11 = ':';
            }
            if (c11 == ':') {
                return new BitmapDrawable(context.getResources(), decodeStream);
            }
            int i11 = f425 + 105;
            f422 = i11 % 128;
            int i12 = i11 % 2;
            Drawable drawable = context.getResources().getDrawable(R.drawable.com_visa_checkout_card_art_default);
            int i13 = f422 + 119;
            f425 = i13 % 128;
            if (i13 % 2 != 0) {
                c12 = 'M';
            } else {
                c12 = 26;
            }
            if (c12 != 26) {
                int i14 = 66 / 0;
            }
            return drawable;
        } catch (FileNotFoundException unused) {
            return context.getResources().getDrawable(R.drawable.com_visa_checkout_card_art_default);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m6318(Context context) {
        if ((new File(new ContextWrapper(context.getApplicationContext()).getDir(m6317(127, (String) null, (int[]) null, "").intern(), 0), m6317(127, (String) null, (int[]) null, "").intern()).delete() ? SignatureVisitor.SUPER : '^') != '^') {
            int i11 = f422 + 15;
            f425 = i11 % 128;
            int i12 = i11 % 2;
            VisaCheckoutSdk.notifyCustomButtonUpdated();
            int i13 = f422 + 79;
            f425 = i13 % 128;
            int i14 = i13 % 2;
        }
    }
}
