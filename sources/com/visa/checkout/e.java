package com.visa.checkout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

@TargetApi(19)
abstract class e {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static long f195 = 6167096117737996785L;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f196 = 0;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static int f197 = 1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f198 = UUID.randomUUID().toString();

    /* renamed from: ˋ  reason: contains not printable characters */
    private Map<String, b> f199 = new HashMap();

    /* renamed from: ˏ  reason: contains not printable characters */
    private BroadcastReceiver f200 = new BroadcastReceiver() {

        /* renamed from: ˋ  reason: contains not printable characters */
        private static long f201 = -2682099676413832300L;

        /* renamed from: ˎ  reason: contains not printable characters */
        private static int f202 = 0;

        /* renamed from: ˏ  reason: contains not printable characters */
        private static int f203 = 1;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: ˏ  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String m6161(java.lang.String r9) {
            /*
                r0 = 0
                if (r9 == 0) goto L_0x0005
                r1 = r0
                goto L_0x0006
            L_0x0005:
                r1 = 1
            L_0x0006:
                if (r1 == 0) goto L_0x0009
                goto L_0x0020
            L_0x0009:
                int r1 = f203
                int r1 = r1 + 53
                int r2 = r1 % 128
                f202 = r2
                int r1 = r1 % 2
                if (r1 == 0) goto L_0x001c
                char[] r9 = r9.toCharArray()
                r1 = 7
                int r1 = r1 / r0
                goto L_0x0020
            L_0x001c:
                char[] r9 = r9.toCharArray()
            L_0x0020:
                char[] r9 = (char[]) r9
                long r0 = f201
                char[] r9 = com.c.c.b.m9224(r0, r9)
                r0 = 4
                r1 = r0
            L_0x002a:
                int r2 = r9.length
                r3 = 28
                if (r1 >= r2) goto L_0x0032
                r2 = 63
                goto L_0x0033
            L_0x0032:
                r2 = r3
            L_0x0033:
                if (r2 == r3) goto L_0x0056
                int r2 = f202
                int r2 = r2 + 61
                int r3 = r2 % 128
                f203 = r3
                int r2 = r2 % 2
                int r2 = r1 + -4
                char r3 = r9[r1]
                int r4 = r1 % 4
                char r4 = r9[r4]
                r3 = r3 ^ r4
                long r3 = (long) r3
                long r5 = (long) r2
                long r7 = f201
                long r5 = r5 * r7
                long r2 = r3 ^ r5
                int r2 = (int) r2
                char r2 = (char) r2
                r9[r1] = r2
                int r1 = r1 + 1
                goto L_0x002a
            L_0x0056:
                java.lang.String r1 = new java.lang.String
                int r2 = r9.length
                int r2 = r2 - r0
                r1.<init>(r9, r0, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.e.AnonymousClass1.m6161(java.lang.String):java.lang.String");
        }

        public final void onReceive(Context context, Intent intent) {
            boolean z11;
            int i11 = f202 + 107;
            f203 = i11 % 128;
            if (i11 % 2 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                e.m6146(e.this, intent.getStringExtra(m6161("ﳾ㯲ﲌ혔딞늵煋쿴즐葒ڵ恉顀㋰?ᘛ囦").intern()));
                return;
            }
            e.m6146(e.this, intent.getStringExtra(m6161("ﳾ㯲ﲌ혔딞늵煋쿴즐葒ڵ恉顀㋰?ᘛ囦").intern()));
            throw null;
        }
    };

    public interface b {
        /* renamed from: ˋ  reason: contains not printable characters */
        void m6165(ab abVar, C0003e eVar) throws Exception;
    }

    /* renamed from: com.visa.checkout.e$e  reason: collision with other inner class name */
    public interface C0003e {
        /* renamed from: ˊ  reason: contains not printable characters */
        void m6166(Object obj);

        /* renamed from: ॱ  reason: contains not printable characters */
        void m6167(String str);
    }

    public e() {
        this.f199.put(m6147("✵迴된嵒֙⪽폦").intern(), new b() {
            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6162(ab abVar, C0003e eVar) throws Exception {
                e.m6149(e.this, abVar);
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static /* synthetic */ void m6146(e eVar, String str) {
        Activity r02 = eVar.m6160();
        boolean z11 = false;
        final String format = String.format(m6147("䆓耈䊶Ծ쟜虝䣠આ촀辪主ႚ팰闵埓ᙉ?鬛").intern(), new Object[]{eVar.m6154(), str});
        r02.runOnUiThread(new Runnable() {
            public final void run() {
                e.this.m6155().evaluateJavascript(format, (ValueCallback) null);
            }
        });
        int i11 = f196 + 69;
        f197 = i11 % 128;
        if (i11 % 2 != 0) {
            z11 = true;
        }
        if (!z11) {
            throw null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private synchronized void m6148(final ab abVar) throws Exception {
        AnonymousClass5 r02 = new C0003e() {
            /* renamed from: ˊ  reason: contains not printable characters */
            public final void m6163(Object obj) {
                e.m6150(e.this, abVar.m6115(), i.m6185(obj));
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public final void m6164(String str) {
                e.m6150(e.this, abVar.m6115(), i.m6186(str));
            }
        };
        String r12 = abVar.m6116();
        b bVar = this.f199.get(r12);
        if (bVar == null) {
            b bVar2 = m6156().get(r12);
            if (bVar2 != null) {
                int i11 = f196 + 111;
                f197 = i11 % 128;
                if ((i11 % 2 == 0 ? 'M' : '6') != 'M') {
                    bVar2.m6165(abVar, r02);
                } else {
                    bVar2.m6165(abVar, r02);
                    throw null;
                }
            } else {
                int i12 = f197 + 67;
                f196 = i12 % 128;
                int i13 = i12 % 2;
            }
        } else {
            int i14 = f197 + 71;
            f196 = i14 % 128;
            int i15 = i14 % 2;
            bVar.m6165(abVar, r02);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ void m6150(e eVar, String str, i iVar) {
        int i11 = f196 + 37;
        f197 = i11 % 128;
        char c11 = i11 % 2 == 0 ? 'P' : '`';
        eVar.m6151(str, iVar);
        if (c11 != '`') {
            int i12 = 48 / 0;
        }
    }

    @JavascriptInterface
    public void visaMessage(String str) {
        boolean z11;
        try {
            ab abVar = new ab(str);
            int i11 = f197 + 23;
            f196 = i11 % 128;
            if (i11 % 2 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                try {
                    m6147("獗닋✺鮇ೞ脣疜嬺").intern();
                    m6147("⦇銚봇枈฻㢭趭둮廚ख़㏖?蓲꽿姤<⪯").intern();
                    m6148(abVar);
                    int i12 = f197 + 25;
                    f196 = i12 % 128;
                    int i13 = i12 % 2;
                } catch (Exception e11) {
                    m6151(abVar.m6115(), i.m6186(e11.getMessage()));
                }
            } else {
                m6147("獗닋✺鮇ೞ脣疜嬺").intern();
                m6147("⦇銚봇枈฻㢭趭둮廚ख़㏖?蓲꽿姤<⪯").intern();
                m6148(abVar);
                throw null;
            }
        } catch (JSONException unused) {
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m6152() {
        int i11 = f196 + 97;
        f197 = i11 % 128;
        int i12 = i11 % 2;
        LocalBroadcastManager.getInstance(m6160()).unregisterReceiver(this.f200);
        int i13 = f196 + 121;
        f197 = i13 % 128;
        if ((i13 % 2 == 0 ? (char) 23 : 4) == 23) {
            int i14 = 49 / 0;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public final void m6153() {
        char c11;
        int i11 = f197 + 65;
        f196 = i11 % 128;
        int i12 = i11 % 2;
        if (m6155() != null) {
            if (m6155().getParent() instanceof ViewGroup) {
                c11 = 'c';
            } else {
                c11 = '2';
            }
            if (c11 == 'c') {
                m6155().removeView(m6155());
            }
            m6155().destroy();
            int i13 = f196 + 103;
            f197 = i13 % 128;
            int i14 = i13 % 2;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract String m6154();

    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract WebView m6155();

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract Map<String, b> m6156();

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m6157() {
        int i11 = f197 + 125;
        int i12 = i11 % 128;
        f196 = i12;
        int i13 = i11 % 2;
        String str = this.f198;
        int i14 = i12 + 99;
        f197 = i14 % 128;
        if ((i14 % 2 == 0 ? (char) 14 : 18) != 18) {
            int i15 = 8 / 0;
        }
        return str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract Context m6158();

    /* renamed from: ᐝ  reason: contains not printable characters */
    public Activity m6160() {
        int i11 = f197 + 107;
        f196 = i11 % 128;
        int i12 = i11 % 2;
        Activity r02 = u.m6311(m6155());
        int i13 = f196 + 117;
        f197 = i13 % 128;
        int i14 = i13 % 2;
        return r02;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6151(String str, i iVar) {
        Activity r02 = m6160();
        boolean z11 = false;
        final String format = String.format(m6147("䆓耈䊶Ծ쟜虝䣠આ촀辪主ႚ팰闵埓ᙉ?鬛").intern(), new Object[]{m6154(), iVar.m6188(str)});
        r02.runOnUiThread(new Runnable() {
            public final void run() {
                e.this.m6155().evaluateJavascript(format, (ValueCallback) null);
            }
        });
        int i11 = f196 + 71;
        f197 = i11 % 128;
        if (i11 % 2 != 0) {
            z11 = true;
        }
        if (!z11) {
            throw null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m6159(String str) {
        LocalBroadcastManager.getInstance(m6160()).unregisterReceiver(this.f200);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m6147("蟝䙊츤嘔?曁皞Ｃ").intern());
        sb2.append(str);
        LocalBroadcastManager.getInstance(m6160()).registerReceiver(this.f200, new IntentFilter(sb2.toString()));
        int i11 = f197 + 15;
        f196 = i11 % 128;
        if (!(i11 % 2 == 0)) {
            int i12 = 40 / 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6147(java.lang.String r11) {
        /*
            r0 = 0
            r1 = 1
            if (r11 == 0) goto L_0x0006
            r2 = r1
            goto L_0x0007
        L_0x0006:
            r2 = r0
        L_0x0007:
            if (r2 == 0) goto L_0x001f
            int r2 = f197
            int r2 = r2 + 33
            int r3 = r2 % 128
            f196 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x001a
            char[] r11 = r11.toCharArray()
            goto L_0x001f
        L_0x001a:
            r11.toCharArray()
            r11 = 0
            throw r11
        L_0x001f:
            char[] r11 = (char[]) r11
            char r2 = r11[r0]
            int r3 = r11.length
            int r3 = r3 - r1
            char[] r3 = new char[r3]
            r4 = r1
        L_0x0028:
            int r5 = r11.length
            if (r4 >= r5) goto L_0x002d
            r5 = r1
            goto L_0x002e
        L_0x002d:
            r5 = r0
        L_0x002e:
            if (r5 == r1) goto L_0x0036
            java.lang.String r11 = new java.lang.String
            r11.<init>(r3)
            return r11
        L_0x0036:
            int r5 = f197
            int r5 = r5 + 59
            int r6 = r5 % 128
            f196 = r6
            int r5 = r5 % 2
            int r5 = r4 + -1
            char r7 = r11[r4]
            int r8 = r4 * r2
            r7 = r7 ^ r8
            long r7 = (long) r7
            long r9 = f195
            long r7 = r7 ^ r9
            int r7 = (int) r7
            char r7 = (char) r7
            r3[r5] = r7
            int r4 = r4 + 1
            int r6 = r6 + 23
            int r5 = r6 % 128
            f197 = r5
            int r6 = r6 % 2
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.e.m6147(java.lang.String):java.lang.String");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ void m6149(e eVar, ab abVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m6147("蟝䙊츤嘔?曁皞Ｃ").intern());
        sb2.append(eVar.f198);
        Intent intent = new Intent(sb2.toString());
        intent.putExtra(m6147("㔆⢚ᰉᎳ܁窜渳斔夹䲰䀵랬ꭗ黒").intern(), abVar.m6111());
        LocalBroadcastManager.getInstance(eVar.m6160()).sendBroadcast(intent);
        int i11 = f197 + 67;
        f196 = i11 % 128;
        int i12 = i11 % 2;
    }
}
