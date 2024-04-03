package com.visa.checkout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.visa.checkout.ManualCheckoutSession;
import com.visa.checkout.e;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

final class n extends C0097r {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static char f319 = 'σ';

    /* renamed from: ʼ  reason: contains not printable characters */
    private static int f320 = 1;

    /* renamed from: ʽ  reason: contains not printable characters */
    private static char f321 = '';

    /* renamed from: ॱ  reason: contains not printable characters */
    private static char f322 = '뾽';

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static char f323 = '⑸';

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static int f324;

    /* renamed from: ˊ  reason: contains not printable characters */
    private BroadcastReceiver f325 = new BroadcastReceiver() {

        /* renamed from: ˋ  reason: contains not printable characters */
        private static int f335 = 1;

        /* renamed from: ˏ  reason: contains not printable characters */
        private static long f336 = -5289674272985613612L;

        /* renamed from: ॱ  reason: contains not printable characters */
        private static int f337;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
            if (r0 != false) goto L_0x0025;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            if (r0 != true) goto L_0x0021;
         */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: ॱ  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String m6258(java.lang.String r8, int r9, java.lang.String r10, java.lang.String r11, char r12) {
            /*
                int r0 = f335
                int r0 = r0 + 103
                int r1 = r0 % 128
                f337 = r1
                r1 = 2
                int r0 = r0 % r1
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L_0x0019
                r0 = 51
                int r0 = r0 / r3
                if (r11 == 0) goto L_0x0015
                r0 = r3
                goto L_0x0016
            L_0x0015:
                r0 = r2
            L_0x0016:
                if (r0 == r2) goto L_0x0025
                goto L_0x0021
            L_0x0019:
                if (r11 == 0) goto L_0x001d
                r0 = r3
                goto L_0x001e
            L_0x001d:
                r0 = r2
            L_0x001e:
                if (r0 == 0) goto L_0x0021
                goto L_0x0025
            L_0x0021:
                char[] r11 = r11.toCharArray()
            L_0x0025:
                char[] r11 = (char[]) r11
                if (r10 == 0) goto L_0x002b
                r0 = r2
                goto L_0x002c
            L_0x002b:
                r0 = r3
            L_0x002c:
                if (r0 == 0) goto L_0x0032
                char[] r10 = r10.toCharArray()
            L_0x0032:
                char[] r10 = (char[]) r10
                r0 = 38
                if (r8 == 0) goto L_0x003b
                r4 = 61
                goto L_0x003c
            L_0x003b:
                r4 = r0
            L_0x003c:
                if (r4 == r0) goto L_0x0042
                char[] r8 = r8.toCharArray()
            L_0x0042:
                char[] r8 = (char[]) r8
                java.lang.Object r11 = r11.clone()
                char[] r11 = (char[]) r11
                java.lang.Object r8 = r8.clone()
                char[] r8 = (char[]) r8
                char r0 = r11[r3]
                r12 = r12 ^ r0
                char r12 = (char) r12
                r11[r3] = r12
                char r12 = r8[r1]
                char r9 = (char) r9
                int r12 = r12 + r9
                char r9 = (char) r12
                r8[r1] = r9
                int r9 = r10.length
                char[] r12 = new char[r9]
                int r0 = f337
                int r0 = r0 + 97
                int r4 = r0 % 128
                f335 = r4
                int r0 = r0 % r1
                r0 = r3
            L_0x006a:
                if (r0 >= r9) goto L_0x006e
                r1 = r2
                goto L_0x006f
            L_0x006e:
                r1 = r3
            L_0x006f:
                if (r1 == 0) goto L_0x0088
                com.c.c.c.m9225(r11, r8, r0)
                char r1 = r10[r0]
                int r4 = r0 + 3
                int r4 = r4 % 4
                char r4 = r11[r4]
                r1 = r1 ^ r4
                long r4 = (long) r1
                long r6 = f336
                long r4 = r4 ^ r6
                int r1 = (int) r4
                char r1 = (char) r1
                r12[r0] = r1
                int r0 = r0 + 1
                goto L_0x006a
            L_0x0088:
                java.lang.String r8 = new java.lang.String
                r8.<init>(r12)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.n.AnonymousClass4.m6258(java.lang.String, int, java.lang.String, java.lang.String, char):java.lang.String");
        }

        public final void onReceive(Context context, Intent intent) {
            Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra(m6258("竔䴫䵆뚗", -1722947591, "蠽ݟ鏪뫦濢₾꺘芃", "練䷧?᱃", 0).intern(), false));
            LocalBroadcastManager.getInstance(n.this.m6282()).unregisterReceiver(n.m6252(n.this));
            if (!valueOf.booleanValue()) {
                int i11 = f337 + 7;
                f335 = i11 % 128;
                int i12 = i11 % 2;
                return;
            }
            n.m6255(n.this);
            try {
                final VisaPaymentSummary visaPaymentSummary = new VisaPaymentSummary(new JSONObject(m6258("竔䴫䵆뚗", -2107948596, "橁謚⒏鴫⣺컇䚉烰軏膫፧⇱ల翙걀낟?퐅᪻逳㮪葴制髺拘䘮嘵ⵜ䶨᝖ੳ鉩咿諚", "찾孁뾂⸱", 0).intern()));
                n.this.m6282().runOnUiThread(new Runnable() {
                    public final void run() {
                        n.m6253(n.this).m6275().onResult(visaPaymentSummary);
                    }
                });
                int i13 = f337 + 19;
                f335 = i13 % 128;
                int i14 = i13 % 2;
            } catch (JSONException unused) {
            }
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private ManualCheckoutSession.ManualCheckoutLaunchHandler f326 = new ManualCheckoutSession.ManualCheckoutLaunchHandler() {

        /* renamed from: ʼ  reason: contains not printable characters */
        private static int f328 = 1;

        /* renamed from: ʽ  reason: contains not printable characters */
        private static int f329 = 0;

        /* renamed from: ˋ  reason: contains not printable characters */
        private static char f330 = '쯶';

        /* renamed from: ˎ  reason: contains not printable characters */
        private static char f331 = '';

        /* renamed from: ˏ  reason: contains not printable characters */
        private static char f332 = 'ﺒ';

        /* renamed from: ॱ  reason: contains not printable characters */
        private static char f333 = '';

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: ˎ  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String m6257(java.lang.String r11) {
            /*
                int r0 = f329
                int r0 = r0 + 125
                int r1 = r0 % 128
                f328 = r1
                r2 = 2
                int r0 = r0 % r2
                r0 = 6
                if (r11 == 0) goto L_0x000f
                r3 = r0
                goto L_0x0011
            L_0x000f:
                r3 = 10
            L_0x0011:
                if (r3 == r0) goto L_0x0014
                goto L_0x001f
            L_0x0014:
                int r1 = r1 + 5
                int r0 = r1 % 128
                f329 = r0
                int r1 = r1 % r2
                char[] r11 = r11.toCharArray()
            L_0x001f:
                char[] r11 = (char[]) r11
                int r0 = r11.length
                char[] r0 = new char[r0]
                char[] r1 = new char[r2]
                int r3 = f329
                int r3 = r3 + 13
                int r4 = r3 % 128
                f328 = r4
                int r3 = r3 % r2
                r3 = 0
                r4 = r3
            L_0x0031:
                int r5 = r11.length
                r6 = 98
                if (r4 >= r5) goto L_0x0039
                r5 = 52
                goto L_0x003a
            L_0x0039:
                r5 = r6
            L_0x003a:
                r7 = 1
                if (r5 == r6) goto L_0x0066
                int r5 = f328
                int r5 = r5 + 43
                int r6 = r5 % 128
                f329 = r6
                int r5 = r5 % r2
                char r5 = r11[r4]
                r1[r3] = r5
                int r5 = r4 + 1
                char r6 = r11[r5]
                r1[r7] = r6
                char r6 = f332
                char r8 = f330
                char r9 = f333
                char r10 = f331
                com.c.c.g.m9231(r1, r6, r8, r9, r10)
                char r6 = r1[r3]
                r0[r4] = r6
                char r6 = r1[r7]
                r0[r5] = r6
                int r4 = r4 + 2
                goto L_0x0031
            L_0x0066:
                char r11 = r0[r3]
                java.lang.String r1 = new java.lang.String
                r1.<init>(r0, r7, r11)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.n.AnonymousClass1.m6257(java.lang.String):java.lang.String");
        }

        public final void launch() {
            n.this.m6256();
            String obj = UUID.randomUUID().toString();
            Intent intent = new Intent(n.m6253(n.this).m6274(), l.class);
            intent.putExtra(m6257("໠䌠꓿댬ꉢ?뫂䥨鿀춙聰粙嚽꓄").intern(), obj);
            n.this.m6232(obj);
            n.m6253(n.this).m6274().startActivity(intent);
            int i11 = f328 + 95;
            f329 = i11 % 128;
            int i12 = i11 % 2;
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    private q f327;

    public n(q qVar, final ManualCheckoutSession manualCheckoutSession) {
        super(new c(qVar.m6274()), qVar);
        this.f327 = qVar;
        manualCheckoutSession.onReady(this.f326);
        m6231().put(m6254("嬑嫍⅑嫧噚褓燗慠幢嘊圲麝槈똎埶").intern(), new e.b() {
            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6259(ab abVar, final e.C0003e eVar) throws Exception {
                final AnonymousClass2 r12 = new ManualCheckoutSession.ManualCheckoutLaunchHandler() {
                    public final void launch() {
                        eVar.m6166((Object) null);
                    }
                };
                n.this.m6230((g) new g() {
                    /* renamed from: ॱ  reason: contains not printable characters */
                    public final void m6260() {
                        manualCheckoutSession.onReady(r12);
                    }
                });
            }
        });
        m6229().loadUrl(b.m6119(m6281(), qVar.m6273().getEnvironment(), m6254("⥚㉑噚褓燗慠幢嘊圲麝槈똎埶").intern()));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static /* synthetic */ BroadcastReceiver m6252(n nVar) {
        int i11 = f324 + 17;
        int i12 = i11 % 128;
        f320 = i12;
        int i13 = i11 % 2;
        BroadcastReceiver broadcastReceiver = nVar.f325;
        int i14 = i12 + 25;
        f324 = i14 % 128;
        int i15 = i14 % 2;
        return broadcastReceiver;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static /* synthetic */ q m6253(n nVar) {
        int i11 = f320 + 51;
        f324 = i11 % 128;
        char c11 = i11 % 2 != 0 ? 14 : '6';
        q qVar = nVar.f327;
        if (c11 == '6') {
            return qVar;
        }
        throw null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ void m6255(n nVar) {
        int i11 = f324 + 47;
        f320 = i11 % 128;
        char c11 = i11 % 2 == 0 ? (char) 27 : 23;
        super.m6234();
        if (c11 == 27) {
            throw null;
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public final void m6256() {
        LocalBroadcastManager.getInstance(m6282()).registerReceiver(this.f325, new IntentFilter(m6254("⎭黲홿ፌ㪵ꅄę䉀扜萊䷤?喜熑삵慶忩㴻ㇸ梾訢鶴쬻噎図").intern()));
        int i11 = f324 + 41;
        f320 = i11 % 128;
        int i12 = i11 % 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˋ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6254(java.lang.String r11) {
        /*
            int r0 = f320
            int r0 = r0 + 105
            int r1 = r0 % 128
            f324 = r1
            r1 = 2
            int r0 = r0 % r1
            if (r11 == 0) goto L_0x0010
            char[] r11 = r11.toCharArray()
        L_0x0010:
            char[] r11 = (char[]) r11
            int r0 = r11.length
            char[] r0 = new char[r0]
            char[] r2 = new char[r1]
            int r3 = f324
            int r3 = r3 + 101
            int r4 = r3 % 128
            f320 = r4
            int r3 = r3 % r1
            r3 = 0
            r4 = r3
        L_0x0022:
            int r5 = r11.length
            r6 = 1
            if (r4 >= r5) goto L_0x0028
            r5 = r6
            goto L_0x0029
        L_0x0028:
            r5 = r3
        L_0x0029:
            if (r5 == 0) goto L_0x0078
            int r5 = f320
            int r5 = r5 + 43
            int r7 = r5 % 128
            f324 = r7
            int r5 = r5 % r1
            if (r5 == 0) goto L_0x0058
            char r5 = r11[r4]
            r2[r3] = r5
            int r5 = r4 % 1
            char r5 = r11[r5]
            r2[r3] = r5
            char r5 = f322
            char r7 = f321
            char r8 = f323
            char r9 = f319
            com.c.c.g.m9231(r2, r5, r7, r8, r9)
            char r5 = r2[r6]
            r0[r4] = r5
            int r5 = r4 + 0
            char r6 = r2[r6]
            r0[r5] = r6
            int r4 = r4 + 79
            goto L_0x0022
        L_0x0058:
            char r5 = r11[r4]
            r2[r3] = r5
            int r5 = r4 + 1
            char r7 = r11[r5]
            r2[r6] = r7
            char r7 = f322
            char r8 = f321
            char r9 = f323
            char r10 = f319
            com.c.c.g.m9231(r2, r7, r8, r9, r10)
            char r7 = r2[r3]
            r0[r4] = r7
            char r6 = r2[r6]
            r0[r5] = r6
            int r4 = r4 + 2
            goto L_0x0022
        L_0x0078:
            char r11 = r0[r3]
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0, r6, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.n.m6254(java.lang.String):java.lang.String");
    }
}
