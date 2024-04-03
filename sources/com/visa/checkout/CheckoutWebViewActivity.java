package com.visa.checkout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.c.c.d;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class CheckoutWebViewActivity extends Activity implements TraceFieldInterface {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f99 = 1;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f100 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f101 = 116;
    public Trace _nr_trace;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6100(int r6, java.lang.String r7, int r8, int r9, boolean r10) {
        /*
            if (r7 == 0) goto L_0x0010
            char[] r7 = r7.toCharArray()
            int r0 = f100
            int r0 = r0 + 53
            int r1 = r0 % 128
            f99 = r1
            int r0 = r0 % 2
        L_0x0010:
            char[] r7 = (char[]) r7
            char[] r0 = new char[r8]
            r1 = 0
            r2 = r1
        L_0x0016:
            r3 = 37
            if (r2 >= r8) goto L_0x001c
            r4 = r3
            goto L_0x001e
        L_0x001c:
            r4 = 9
        L_0x001e:
            r5 = 6
            if (r4 == r3) goto L_0x0056
            if (r9 <= 0) goto L_0x0030
            char[] r6 = new char[r8]
            java.lang.System.arraycopy(r0, r1, r6, r1, r8)
            int r7 = r8 - r9
            java.lang.System.arraycopy(r6, r1, r0, r7, r9)
            java.lang.System.arraycopy(r6, r9, r0, r1, r7)
        L_0x0030:
            r6 = 79
            if (r10 == 0) goto L_0x0037
            r7 = 61
            goto L_0x0038
        L_0x0037:
            r7 = r6
        L_0x0038:
            if (r7 == r6) goto L_0x0050
            char[] r6 = new char[r8]
        L_0x003c:
            if (r1 >= r8) goto L_0x0041
            r7 = 51
            goto L_0x0042
        L_0x0041:
            r7 = r5
        L_0x0042:
            if (r7 == r5) goto L_0x004f
            int r7 = r8 - r1
            int r7 = r7 + -1
            char r7 = r0[r7]
            r6[r1] = r7
            int r1 = r1 + 1
            goto L_0x003c
        L_0x004f:
            r0 = r6
        L_0x0050:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0)
            return r6
        L_0x0056:
            int r3 = f100
            int r3 = r3 + 53
            int r4 = r3 % 128
            f99 = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0065
            r3 = 10
            goto L_0x0066
        L_0x0065:
            r3 = r5
        L_0x0066:
            if (r3 == r5) goto L_0x0077
            char r3 = r7[r2]
            r3 = r3 ^ r6
            char r3 = (char) r3
            r0[r2] = r3
            int r4 = f101
            int r3 = r3 / r4
            char r3 = (char) r3
            r0[r2] = r3
            int r2 = r2 + 101
            goto L_0x0016
        L_0x0077:
            char r3 = r7[r2]
            int r3 = r3 + r6
            char r3 = (char) r3
            r0[r2] = r3
            int r4 = f101
            int r3 = r3 - r4
            char r3 = (char) r3
            r0[r2] = r3
            int r2 = r2 + 1
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.CheckoutWebViewActivity.m6100(int, java.lang.String, int, int, boolean):java.lang.String");
    }

    public void onBackPressed() {
        boolean z11 = false;
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(m6100(217, "￼￾\u0006￫\r\u0000\u000e\u000e\u0000￿\n\t￝", 13, 10, false).intern()));
        int i11 = f99 + 81;
        f100 = i11 % 128;
        if (i11 % 2 == 0) {
            z11 = true;
        }
        if (!z11) {
            throw null;
        }
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("CheckoutWebViewActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CheckoutWebViewActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CheckoutWebViewActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        VisaCheckoutSdk.setActivity(this);
        boolean z11 = true;
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(m6100(222, "\n￿\f￿\n￹￷￺￻\n\b￷\n￩\u000f", 15, 7, true).intern()));
        int i11 = f99 + 73;
        f100 = i11 % 128;
        if (i11 % 2 != 0) {
            z11 = true;
        }
        if (!z11) {
            TraceMachine.exitMethod();
            return;
        }
        throw null;
    }

    public void onResume() {
        boolean z11;
        super.onResume();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: ˊ  reason: contains not printable characters */
            private static int f102 = 1;

            /* renamed from: ˋ  reason: contains not printable characters */
            private static int[] f103 = {-1387768415, -1081505776, -539287259, 758192728, 813718761, 1363921602, 1756622452, -1770020073, -1694493187, -247123720, -1192170136, 937054, -504121689, -1479043939, -545635058, 1213620157, 127103487, -838907217};

            /* renamed from: ˏ  reason: contains not printable characters */
            private static int f104;

            /* renamed from: ˊ  reason: contains not printable characters */
            private static String m6101(int[] iArr, int i11) {
                boolean z11;
                char[] cArr = new char[4];
                char[] cArr2 = new char[(iArr.length << 1)];
                int[] iArr2 = (int[]) f103.clone();
                int i12 = f104 + 1;
                f102 = i12 % 128;
                int i13 = i12 % 2;
                int i14 = 0;
                while (true) {
                    if (i14 < iArr.length) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        int i15 = iArr[i14];
                        cArr[0] = (char) (i15 >> 16);
                        cArr[1] = (char) i15;
                        int i16 = iArr[i14 + 1];
                        cArr[2] = (char) (i16 >> 16);
                        cArr[3] = (char) i16;
                        d.m9228(cArr, iArr2, false);
                        int i17 = i14 << 1;
                        cArr2[i17] = cArr[0];
                        cArr2[i17 + 1] = cArr[1];
                        cArr2[i17 + 2] = cArr[2];
                        cArr2[i17 + 3] = cArr[3];
                        i14 += 2;
                        int i18 = f102 + 77;
                        f104 = i18 % 128;
                        int i19 = i18 % 2;
                    } else {
                        String str = new String(cArr2, 0, i11);
                        int i21 = f104 + 57;
                        f102 = i21 % 128;
                        int i22 = i21 % 2;
                        return str;
                    }
                }
            }

            public final void run() {
                LocalBroadcastManager.getInstance(CheckoutWebViewActivity.this).sendBroadcast(new Intent(m6101(new int[]{-1350837083, 268896541, -1117678211, 1327195167, 2119237127, 1222402756, 1502238158, -984360058, 1294331411, 2013009565, -1500079071, -1633514099}, 23).intern()));
                int i11 = f102 + 89;
                f104 = i11 % 128;
                if (!(i11 % 2 == 0)) {
                    throw null;
                }
            }
        }, 1000);
        int i11 = f99 + 77;
        f100 = i11 % 128;
        if (i11 % 2 != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw null;
        }
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
