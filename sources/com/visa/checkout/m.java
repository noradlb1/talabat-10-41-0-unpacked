package com.visa.checkout;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.webkit.WebView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.common.base.Ascii;
import com.huawei.hms.analytics.instance.CallBack;
import com.visa.checkout.e;
import com.visa.checkout.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONException;
import org.json.JSONObject;

abstract class m extends e {

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private static int f268 = 1;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static char[] f269 = {37970, 33322, 47353, 54960, 52569, 64265, 4554, 3975, 9811, 23570, 19110, 32173, 27622, 20782, 16253, 9403, 4810, 63505, 58957, 53139, 16901, 21583, 28306, 210, 6934, 11618, Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 5678, 11517, 17080, 22901, 28432, 34265, 35581, 40109, 42592, 51262, 54250, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 5679, 11489, 17058, 22864, 28428, 34251, 39829, 45649, 51217, 56993, 64552, 60012, 53419, 48885, 42289, 37705, 31113, 26598, 19980, 13394, 8940, 2343, 63349, 56749, 52197, 45569, 39003, 34432, 27871, 23367, 16801, 12283, 5674, 64576, 60062, 'h', 5666, 11503, 17073, 22905, 28433, 34265, 'c', 5675, 11495, 17072, 22898, 28439, 34183, 39834, 45661, 51206, 'e', 5758, 11453, 17072, 22911, 28498, 34255, 39828, 45589, 51228, 56995, 62781, 2912, 8697, 14289, 20047, 25618, 31363, 37020, 42876, 48616, 33916, 37430, 43252, 50866, 8592, 14288, 3335, 4738, 1229, 15893, 20562, 19356, 32232};

    /* renamed from: ͺ  reason: contains not printable characters */
    private static long f270 = 6744461254895474247L;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static int f271;

    /* renamed from: ʻ  reason: contains not printable characters */
    private a f272;

    /* renamed from: ʼ  reason: contains not printable characters */
    private e.C0003e f273;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f274;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f275;

    /* renamed from: ˋ  reason: contains not printable characters */
    private d f276;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected String f277;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Map<String, e.b> f278 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private WebView f279;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private BroadcastReceiver f280 = new BroadcastReceiver() {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static int f310 = 0;

        /* renamed from: ˋ  reason: contains not printable characters */
        private static char[] f311 = {Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 30974, 61770, 27014, 57917, 23197, 54249, 19524, 50388};

        /* renamed from: ˎ  reason: contains not printable characters */
        private static int f312 = 1;

        /* renamed from: ˏ  reason: contains not printable characters */
        private static long f313 = -5449583425659504489L;

        /* renamed from: ˋ  reason: contains not printable characters */
        private static String m6248(int i11, int i12, char c11) {
            boolean z11;
            int i13 = f310 + 61;
            f312 = i13 % 128;
            int i14 = i13 % 2;
            char[] cArr = new char[i11];
            int i15 = 0;
            while (true) {
                if (i15 < i11) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    return new String(cArr);
                }
                int i16 = f312 + 21;
                f310 = i16 % 128;
                int i17 = i16 % 2;
                cArr[i15] = (char) ((int) ((((long) f311[i12 + i15]) ^ (((long) i15) * f313)) ^ ((long) c11)));
                i15++;
            }
        }

        public final void onReceive(Context context, Intent intent) {
            char c11;
            Boolean bool;
            char c12;
            int i11 = f312 + 71;
            f310 = i11 % 128;
            if (i11 % 2 != 0) {
                c11 = '2';
            } else {
                c11 = 'B';
            }
            boolean z11 = true;
            if (c11 != 'B') {
                bool = Boolean.valueOf(intent.getBooleanExtra(m6248(54, 0, 0).intern(), true));
                if (m.m6211(m.this) == null) {
                    return;
                }
            } else {
                bool = Boolean.valueOf(intent.getBooleanExtra(m6248(9, 0, 0).intern(), false));
                if (m.m6211(m.this) != null) {
                    c12 = 'X';
                } else {
                    c12 = '\"';
                }
                if (c12 == '\"') {
                    return;
                }
            }
            int i12 = f312 + 35;
            f310 = i12 % 128;
            int i13 = i12 % 2;
            if (bool.booleanValue()) {
                z11 = false;
            }
            if (!z11) {
                m.this.m6234();
                int i14 = f312 + 91;
                f310 = i14 % 128;
                int i15 = i14 % 2;
            }
            m.m6211(m.this).m6166(bool);
            m.m6213(m.this, (e.C0003e) null);
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    private g f281;

    public interface a {
        /* renamed from: ˊ  reason: contains not printable characters */
        void m6251();
    }

    public m(WebView webView) {
        this.f279 = webView;
        this.f278.put(m6218(9, 11, 32206).intern(), new e.b() {

            /* renamed from: ʻ  reason: contains not printable characters */
            private static int f282 = 1;

            /* renamed from: ʽ  reason: contains not printable characters */
            private static int f283 = 0;

            /* renamed from: ˊ  reason: contains not printable characters */
            private static int f284 = 112;

            /* renamed from: ˋ  reason: contains not printable characters */
            private static byte[] f285 = {-12, 19, 17, -21, -2, 6, -18, 0, Ascii.SO, -8, 0};

            /* renamed from: ˎ  reason: contains not printable characters */
            private static int f286 = 1534472302;

            /* renamed from: ˏ  reason: contains not printable characters */
            private static int f287 = -1641806838;

            /* renamed from: ˊ  reason: contains not printable characters */
            private static String m6235(int i11, byte b11, int i12, int i13, short s11) {
                char c11;
                boolean z11;
                boolean z12;
                char c12;
                char c13;
                StringBuilder sb2 = new StringBuilder();
                int i14 = f284;
                int i15 = i13 + i14;
                if (i15 == -1) {
                    c11 = SignatureVisitor.EXTENDS;
                } else {
                    c11 = 'Q';
                }
                int i16 = 0;
                int i17 = 1;
                if (c11 != 'Q') {
                    z11 = true;
                } else {
                    int i18 = f283 + 41;
                    f282 = i18 % 128;
                    int i19 = i18 % 2;
                    z11 = false;
                }
                if (z11) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                if (z12) {
                    byte[] bArr = f285;
                    if (bArr != null) {
                        i15 = (byte) (bArr[f286 + i12] + i14);
                    } else {
                        throw null;
                    }
                }
                if (i15 > 0) {
                    int i21 = ((i12 + i15) - 2) + f286;
                    if (z11) {
                        c12 = 'Y';
                    } else {
                        c12 = CharUtils.CR;
                    }
                    if (c12 != 'Y') {
                        int i22 = f282 + 1;
                        f283 = i22 % 128;
                        int i23 = i22 % 2;
                    } else {
                        i16 = 1;
                    }
                    int i24 = i21 + i16;
                    char c14 = (char) (i11 + f287);
                    sb2.append(c14);
                    while (i17 < i15) {
                        int i25 = f283 + 71;
                        int i26 = i25 % 128;
                        f282 = i26;
                        int i27 = i25 % 2;
                        byte[] bArr2 = f285;
                        if (bArr2 != null) {
                            c13 = 'Z';
                        } else {
                            c13 = 12;
                        }
                        if (c13 != 12) {
                            c14 = (char) (c14 + (((byte) (bArr2[i24] + s11)) ^ b11));
                            int i28 = i26 + 105;
                            f283 = i28 % 128;
                            int i29 = i28 % 2;
                            sb2.append(c14);
                            i17++;
                            i24--;
                        } else {
                            throw null;
                        }
                    }
                }
                return sb2.toString();
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6236(ab abVar, e.C0003e eVar) throws Exception {
                char c11;
                int i11 = f282 + 113;
                f283 = i11 % 128;
                int i12 = i11 % 2;
                final JSONObject jSONObject = (JSONObject) abVar.m6113();
                m.this.f277 = abVar.m6112(m6235(1641806947, (byte) 0, -1534472302, CallBack.INIT_FAILED, 0).intern());
                final String string = jSONObject.getString(m6235(1641806947, (byte) 0, -1534472302, CallBack.INIT_FAILED, 0).intern());
                final String r52 = m.this.m6157();
                if (m.m6217(m.this) != null) {
                    c11 = 'A';
                } else {
                    c11 = Typography.amp;
                }
                if (c11 == 'A') {
                    int i13 = f283 + 101;
                    f282 = i13 % 128;
                    int i14 = i13 % 2;
                    m.m6217(m.this).m6109();
                    int i15 = f283 + 75;
                    f282 = i15 % 128;
                    int i16 = i15 % 2;
                }
                final e.C0003e eVar2 = eVar;
                m.m6215(m.this, new a() {
                    /* renamed from: ˊ  reason: contains not printable characters */
                    public final void m6237() {
                        try {
                            m.m6222(m.this, new d(m.this.m6158(), m.m6221(m.this, jSONObject), string, r52, eVar2));
                            m.m6212(m.this).m6132(m.m6223(m.this));
                            m mVar = m.this;
                            mVar.m6159(m.m6212(mVar).m6157());
                        } catch (Exception e11) {
                            eVar2.m6167(e11.getMessage());
                        }
                    }
                });
            }
        });
        this.f278.put(m6218(6, 20, 17001).intern(), new e.b() {
            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6239(ab abVar, final e.C0003e eVar) throws Exception {
                Activity r32 = m.this.m6160();
                r32.runOnUiThread(new Runnable(new w.d() {

                    /* renamed from: ˊ  reason: contains not printable characters */
                    private static long f296 = -2158826020686636692L;

                    /* renamed from: ˎ  reason: contains not printable characters */
                    private static int f297 = 0;

                    /* renamed from: ॱ  reason: contains not printable characters */
                    private static int f298 = 1;

                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: char} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: char[]} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.String} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: char} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: char} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: char} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.String} */
                    /* JADX WARNING: Multi-variable type inference failed */
                    /* renamed from: ॱ  reason: contains not printable characters */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private static java.lang.String m6240(java.lang.String r8) {
                        /*
                            r0 = 13
                            r1 = 0
                            if (r8 == 0) goto L_0x0007
                            r2 = r1
                            goto L_0x0008
                        L_0x0007:
                            r2 = r0
                        L_0x0008:
                            r3 = 1
                            if (r2 == r0) goto L_0x0028
                            int r0 = f297
                            int r0 = r0 + r3
                            int r2 = r0 % 128
                            f298 = r2
                            int r0 = r0 % 2
                            r2 = 46
                            if (r0 != 0) goto L_0x001a
                            r0 = r2
                            goto L_0x001c
                        L_0x001a:
                            r0 = 29
                        L_0x001c:
                            if (r0 == r2) goto L_0x0023
                            char[] r8 = r8.toCharArray()
                            goto L_0x0028
                        L_0x0023:
                            r8.toCharArray()
                            r8 = 0
                            throw r8
                        L_0x0028:
                            char[] r8 = (char[]) r8
                            char r0 = r8[r1]
                            int r1 = r8.length
                            int r1 = r1 - r3
                            char[] r1 = new char[r1]
                        L_0x0030:
                            int r2 = r8.length
                            if (r3 >= r2) goto L_0x0063
                            int r2 = f298
                            int r2 = r2 + 43
                            int r4 = r2 % 128
                            f297 = r4
                            int r2 = r2 % 2
                            if (r2 == 0) goto L_0x0051
                            r2 = r3 & 0
                            char r4 = r8[r3]
                            int r5 = r3 >> r0
                            int r4 = r4 / r5
                            long r4 = (long) r4
                            long r6 = f296
                            long r4 = r4 % r6
                            int r4 = (int) r4
                            char r4 = (char) r4
                            r1[r2] = r4
                            int r3 = r3 + 57
                            goto L_0x0030
                        L_0x0051:
                            int r2 = r3 + -1
                            char r4 = r8[r3]
                            int r5 = r3 * r0
                            r4 = r4 ^ r5
                            long r4 = (long) r4
                            long r6 = f296
                            long r4 = r4 ^ r6
                            int r4 = (int) r4
                            char r4 = (char) r4
                            r1[r2] = r4
                            int r3 = r3 + 1
                            goto L_0x0030
                        L_0x0063:
                            java.lang.String r8 = new java.lang.String
                            r8.<init>(r1)
                            return r8
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.m.AnonymousClass2.AnonymousClass3.m6240(java.lang.String):java.lang.String");
                    }

                    /* renamed from: ˋ  reason: contains not printable characters */
                    public final void m6241(Activity activity) throws Exception {
                        char c11;
                        if (m.m6216(m.this)) {
                            c11 = 'I';
                        } else {
                            c11 = Typography.greater;
                        }
                        if (c11 != 'I') {
                            boolean z11 = true;
                            m.m6219(m.this, true);
                            activity.startActivity(new Intent(activity, CheckoutWebViewActivity.class));
                            e.C0003e eVar = eVar;
                            if (eVar != null) {
                                z11 = false;
                            }
                            if (!z11) {
                                eVar.m6166((Object) null);
                                int i11 = f298 + 47;
                                f297 = i11 % 128;
                                int i12 = i11 % 2;
                                return;
                            }
                            return;
                        }
                        int i13 = f298 + 77;
                        f297 = i13 % 128;
                        int i14 = i13 % 2;
                        eVar.m6167(m6240("랩㙗翤螩켁ᓙ岛ⷾ疝뵀싵ઍ割鯢⎏歵냯*䧔醋?滍뛍︪ߞ佥霧?摳갩㴰").intern());
                    }
                }, r32, eVar) {

                    /* renamed from: ˊ  reason: contains not printable characters */
                    private /* synthetic */ Activity f413;

                    /* renamed from: ˋ  reason: contains not printable characters */
                    private /* synthetic */ d f414;

                    /* renamed from: ˏ  reason: contains not printable characters */
                    private /* synthetic */ e.C0003e f415;

                    {
                        this.f414 = r1;
                        this.f413 = r2;
                        this.f415 = r3;
                    }

                    public final void run() {
                        try {
                            this.f414.m6315(this.f413);
                        } catch (Exception e11) {
                            this.f415.m6167(e11.getMessage());
                        }
                    }
                });
            }
        });
        this.f278.put(m6218(7, 26, 0).intern(), new e.b() {
            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6242(ab abVar, final e.C0003e eVar) throws Exception {
                Activity r32 = m.this.m6160();
                r32.runOnUiThread(new Runnable(new Object() {
                    /* renamed from: ˊ  reason: contains not printable characters */
                    public final void m6243() {
                        VisaCheckoutSdk.clearAlreadyLaunchedIds();
                        if (m.m6220(m.this) instanceof c) {
                            ((c) m.m6220(m.this)).m6120(false);
                        }
                        eVar.m6166((Object) null);
                    }

                    /* renamed from: ˋ  reason: contains not printable characters */
                    public final void m6244(Activity activity) throws Exception {
                        m.m6215(m.this, this);
                    }
                }, r32, eVar) {

                    /* renamed from: ˊ  reason: contains not printable characters */
                    private /* synthetic */ Activity f413;

                    /* renamed from: ˋ  reason: contains not printable characters */
                    private /* synthetic */ d f414;

                    /* renamed from: ˏ  reason: contains not printable characters */
                    private /* synthetic */ e.C0003e f415;

                    {
                        this.f414 = r1;
                        this.f413 = r2;
                        this.f415 = r3;
                    }

                    public final void run() {
                        try {
                            this.f414.m6315(this.f413);
                        } catch (Exception e11) {
                            this.f415.m6167(e11.getMessage());
                        }
                    }
                });
            }
        });
        this.f278.put(m6218(5, 33, 35471).intern(), new e.b() {
            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6245(ab abVar, final e.C0003e eVar) throws Exception {
                Activity r32 = m.this.m6160();
                r32.runOnUiThread(new Runnable(new w.d() {
                    /* renamed from: ˋ  reason: contains not printable characters */
                    public final void m6246(Activity activity) throws Exception {
                        if (m.m6210(m.this) != null) {
                            m.m6210(m.this).m6178();
                        }
                        eVar.m6166((Object) null);
                    }
                }, r32, eVar) {

                    /* renamed from: ˊ  reason: contains not printable characters */
                    private /* synthetic */ Activity f413;

                    /* renamed from: ˋ  reason: contains not printable characters */
                    private /* synthetic */ d f414;

                    /* renamed from: ˏ  reason: contains not printable characters */
                    private /* synthetic */ e.C0003e f415;

                    {
                        this.f414 = r1;
                        this.f413 = r2;
                        this.f415 = r3;
                    }

                    public final void run() {
                        try {
                            this.f414.m6315(this.f413);
                        } catch (Exception e11) {
                            this.f415.m6167(e11.getMessage());
                        }
                    }
                });
            }
        });
        this.f278.put(m6218(11, 38, 0).intern(), new e.b() {

            /* renamed from: ˋ  reason: contains not printable characters */
            private static long f315 = -7818790731696150520L;

            /* renamed from: ˎ  reason: contains not printable characters */
            private static int f316 = 1;

            /* renamed from: ॱ  reason: contains not printable characters */
            private static int f317;

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6250(ab abVar, e.C0003e eVar) throws Exception {
                m.m6213(m.this, eVar);
                m.m6225(m.this);
                String obj = UUID.randomUUID().toString();
                Intent intent = new Intent(m.this.m6160(), l.class);
                intent.putExtra(m6249("෽斃玛䆌徝ⶵ㮉ংބᖄ쾁?ꮷ릿").intern(), obj);
                m.this.m6232(obj);
                m.this.m6160().startActivity(intent);
                int i11 = f317 + 27;
                f316 = i11 % 128;
                int i12 = i11 % 2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.String} */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
                if ((r8 != null ? '?' : '>') != '>') goto L_0x0025;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
                if ((r8 != null ? '^' : 15) != 15) goto L_0x0025;
             */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: ˋ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String m6249(java.lang.String r8) {
                /*
                    int r0 = f317
                    int r1 = r0 + 115
                    int r2 = r1 % 128
                    f316 = r2
                    int r1 = r1 % 2
                    r2 = 0
                    if (r1 != 0) goto L_0x001b
                    r1 = 14
                    int r1 = r1 / r2
                    r1 = 15
                    if (r8 == 0) goto L_0x0017
                    r3 = 94
                    goto L_0x0018
                L_0x0017:
                    r3 = r1
                L_0x0018:
                    if (r3 == r1) goto L_0x0031
                    goto L_0x0025
                L_0x001b:
                    r1 = 62
                    if (r8 == 0) goto L_0x0022
                    r3 = 63
                    goto L_0x0023
                L_0x0022:
                    r3 = r1
                L_0x0023:
                    if (r3 == r1) goto L_0x0031
                L_0x0025:
                    int r0 = r0 + 19
                    int r1 = r0 % 128
                    f316 = r1
                    int r0 = r0 % 2
                    char[] r8 = r8.toCharArray()
                L_0x0031:
                    char[] r8 = (char[]) r8
                    char r0 = r8[r2]
                    int r1 = r8.length
                    r2 = 1
                    int r1 = r1 - r2
                    char[] r1 = new char[r1]
                L_0x003a:
                    int r3 = r8.length
                    r4 = 39
                    if (r2 >= r3) goto L_0x0041
                    r3 = r4
                    goto L_0x0043
                L_0x0041:
                    r3 = 76
                L_0x0043:
                    if (r3 == r4) goto L_0x004b
                    java.lang.String r8 = new java.lang.String
                    r8.<init>(r1)
                    return r8
                L_0x004b:
                    int r3 = f317
                    int r3 = r3 + 71
                    int r4 = r3 % 128
                    f316 = r4
                    int r3 = r3 % 2
                    int r3 = r2 + -1
                    char r4 = r8[r2]
                    int r5 = r2 * r0
                    r4 = r4 ^ r5
                    long r4 = (long) r4
                    long r6 = f315
                    long r4 = r4 ^ r6
                    int r4 = (int) r4
                    char r4 = (char) r4
                    r1[r3] = r4
                    int r2 = r2 + 1
                    goto L_0x003a
                */
                throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.m.AnonymousClass9.m6249(java.lang.String):java.lang.String");
            }
        });
        this.f279.addJavascriptInterface(this, m6218(11, 0, 37892).intern());
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static /* synthetic */ g m6210(m mVar) {
        int i11 = f268;
        int i12 = i11 + 39;
        f271 = i12 % 128;
        boolean z11 = i12 % 2 == 0;
        g gVar = mVar.f281;
        if (z11) {
            int i13 = i11 + 105;
            f271 = i13 % 128;
            if ((i13 % 2 != 0 ? 'I' : 'O') != 'I') {
                return gVar;
            }
            throw null;
        }
        throw null;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static /* synthetic */ e.C0003e m6211(m mVar) {
        int i11 = f268 + 35;
        int i12 = i11 % 128;
        f271 = i12;
        int i13 = i11 % 2;
        e.C0003e eVar = mVar.f273;
        int i14 = i12 + 93;
        f268 = i14 % 128;
        int i15 = i14 % 2;
        return eVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static /* synthetic */ d m6212(m mVar) {
        int i11 = f271 + 45;
        int i12 = i11 % 128;
        f268 = i12;
        int i13 = i11 % 2;
        d dVar = mVar.f276;
        int i14 = i12 + 23;
        f271 = i14 % 128;
        int i15 = i14 % 2;
        return dVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static /* synthetic */ void m6215(m mVar, a aVar) {
        int i11 = f271 + 109;
        f268 = i11 % 128;
        char c11 = i11 % 2 == 0 ? 18 : 'L';
        mVar.m6224(aVar);
        if (c11 != 'L') {
            int i12 = 63 / 0;
        }
        int i13 = f268 + 11;
        f271 = i13 % 128;
        int i14 = i13 % 2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ a m6217(m mVar) {
        int i11 = f271;
        int i12 = i11 + 95;
        f268 = i12 % 128;
        boolean z11 = true;
        boolean z12 = i12 % 2 != 0;
        a aVar = mVar.f272;
        if (!z12) {
            int i13 = 28 / 0;
        }
        int i14 = i11 + 115;
        f268 = i14 % 128;
        if (i14 % 2 == 0) {
            z11 = false;
        }
        if (z11) {
            return aVar;
        }
        throw null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ WebView m6220(m mVar) {
        int i11 = f271;
        int i12 = i11 + 17;
        f268 = i12 % 128;
        int i13 = i12 % 2;
        WebView webView = mVar.f279;
        int i14 = i11 + 45;
        f268 = i14 % 128;
        int i15 = i14 % 2;
        return webView;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ d m6222(m mVar, d dVar) {
        int i11 = f271 + 121;
        f268 = i11 % 128;
        boolean z11 = i11 % 2 == 0;
        mVar.f276 = dVar;
        if (!z11) {
            return dVar;
        }
        throw null;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static /* synthetic */ void m6225(m mVar) {
        boolean z11;
        LocalBroadcastManager.getInstance(mVar.m6160()).unregisterReceiver(mVar.f280);
        LocalBroadcastManager.getInstance(mVar.m6160()).registerReceiver(mVar.f280, new IntentFilter(m6218(25, 49, 64580).intern()));
        int i11 = f268 + 119;
        f271 = i11 % 128;
        if (i11 % 2 != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw null;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public abstract String m6226();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final void m6234() {
        boolean z11;
        char c11;
        d dVar = this.f276;
        if (dVar != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            int i11 = f268 + 81;
            f271 = i11 % 128;
            if (i11 % 2 != 0) {
                c11 = 26;
            } else {
                c11 = 11;
            }
            dVar.m6134().clear();
            if (c11 == 26) {
                throw null;
            }
        }
        m6224((a) new a() {
            /* renamed from: ˊ  reason: contains not printable characters */
            public final void m6238() {
            }
        });
        int i12 = f271 + 69;
        f268 = i12 % 128;
        int i13 = i12 % 2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static /* synthetic */ e.C0003e m6213(m mVar, e.C0003e eVar) {
        int i11 = f271 + 63;
        int i12 = i11 % 128;
        f268 = i12;
        int i13 = i11 % 2;
        mVar.f273 = eVar;
        int i14 = i12 + 85;
        f271 = i14 % 128;
        int i15 = i14 % 2;
        return eVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static /* synthetic */ boolean m6216(m mVar) {
        int i11 = f271;
        int i12 = i11 + 105;
        f268 = i12 % 128;
        char c11 = i12 % 2 == 0 ? 17 : SignatureVisitor.EXTENDS;
        boolean z11 = mVar.f275;
        if (c11 != 17) {
            int i13 = i11 + 49;
            f268 = i13 % 128;
            if ((i13 % 2 == 0 ? 27 : '$') != 27) {
                return z11;
            }
            throw null;
        }
        throw null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ boolean m6219(m mVar, boolean z11) {
        int i11 = f271;
        int i12 = i11 + 53;
        f268 = i12 % 128;
        char c11 = i12 % 2 == 0 ? 29 : 'O';
        mVar.f275 = z11;
        if (c11 != 'O') {
            int i13 = 29 / 0;
        }
        int i14 = i11 + 81;
        f268 = i14 % 128;
        if (!(i14 % 2 != 0)) {
            int i15 = 49 / 0;
        }
        return z11;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ h m6221(m mVar, JSONObject jSONObject) throws Exception {
        int i11 = f271 + 31;
        f268 = i11 % 128;
        if (i11 % 2 != 0) {
            return mVar.m6214(jSONObject);
        }
        mVar.m6214(jSONObject);
        throw null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ String m6223(m mVar) {
        int i11 = f268;
        int i12 = i11 + 33;
        f271 = i12 % 128;
        int i13 = i12 % 2;
        String str = mVar.f274;
        int i14 = i11 + 93;
        f271 = i14 % 128;
        int i15 = i14 % 2;
        return str;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m6227() {
        super.m6152();
        LocalBroadcastManager.getInstance(m6160()).unregisterReceiver(this.f280);
        m6224((a) new a() {
            /* renamed from: ˊ  reason: contains not printable characters */
            public final void m6247() {
            }
        });
        int i11 = f271 + 115;
        f268 = i11 % 128;
        int i12 = i11 % 2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private synchronized void m6224(final a aVar) {
        m6160().runOnUiThread(new Runnable() {
            public final void run() {
                if (m.m6212(m.this) != null) {
                    m.m6212(m.this).m6130();
                }
                if (!m.m6216(m.this) || m.m6212(m.this) == null) {
                    aVar.m6251();
                    return;
                }
                try {
                    m.m6212(m.this).m6160().finish();
                } catch (Exception unused) {
                }
                m.m6219(m.this, false);
                m.m6222(m.this, (d) null);
                aVar.m6251();
            }
        });
        int i11 = f271 + 75;
        f268 = i11 % 128;
        if ((i11 % 2 == 0 ? 23 : '.') == 23) {
            int i12 = 19 / 0;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m6228() {
        int i11 = f268 + 71;
        f271 = i11 % 128;
        if ((i11 % 2 != 0 ? 27 : 'M') != 27) {
            return this.f277;
        }
        int i12 = 39 / 0;
        return this.f277;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final WebView m6229() {
        int i11 = f268;
        int i12 = i11 + 105;
        f271 = i12 % 128;
        int i13 = i12 % 2;
        WebView webView = this.f279;
        int i14 = i11 + 97;
        f271 = i14 % 128;
        int i15 = i14 % 2;
        return webView;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final Map<String, e.b> m6231() {
        int i11 = f268 + 85;
        f271 = i11 % 128;
        if (i11 % 2 == 0) {
            return this.f278;
        }
        throw null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m6233(a aVar) {
        int i11 = f268 + 123;
        int i12 = i11 % 128;
        f271 = i12;
        int i13 = i11 % 2;
        this.f272 = aVar;
        int i14 = i12 + 31;
        f268 = i14 % 128;
        int i15 = i14 % 2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m6230(g gVar) {
        int i11 = f271 + 95;
        f268 = i11 % 128;
        char c11 = i11 % 2 == 0 ? 8 : 'b';
        this.f281 = gVar;
        if (c11 == 8) {
            throw null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m6232(String str) {
        int i11 = f271 + 17;
        int i12 = i11 % 128;
        f268 = i12;
        int i13 = i11 % 2;
        this.f274 = str;
        d dVar = this.f276;
        if (dVar != null) {
            int i14 = i12 + 45;
            f271 = i14 % 128;
            char c11 = i14 % 2 != 0 ? '*' : 9;
            dVar.m6132(str);
            if (c11 == '*') {
                throw null;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private h m6214(JSONObject jSONObject) throws Exception {
        String str;
        JSONObject optJSONObject = jSONObject.optJSONObject(m6218(7, 74, 0).intern());
        HashMap hashMap = new HashMap();
        hashMap.put(m6218(10, 81, 0).intern(), m6218(21, 91, 0).intern());
        if ((optJSONObject != null ? 8 : AbstractJsonLexerKt.COMMA) == 8) {
            int i11 = f271 + 83;
            f268 = i11 % 128;
            int i12 = i11 % 2;
            Iterator<String> keys = optJSONObject.keys();
            while (true) {
                if (!keys.hasNext()) {
                    break;
                }
                String next = keys.next();
                hashMap.put(next, optJSONObject.getString(next));
                int i13 = f271 + 25;
                f268 = i13 % 128;
                int i14 = i13 % 2;
            }
        }
        try {
            str = jSONObject.get(m6218(4, 112, 33822).intern()).toString();
        } catch (JSONException unused) {
            str = null;
        }
        return new h(jSONObject.getString(m6218(3, 116, 8677).intern()), jSONObject.optString(m6218(6, 119, 4847).intern()), hashMap, str, m6226());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String m6218(int i11, int i12, char c11) {
        int i13;
        char[] cArr;
        int i14 = f271 + 73;
        f268 = i14 % 128;
        if ((i14 % 2 == 0 ? 27 : '/') != 27) {
            cArr = new char[i11];
            i13 = 0;
        } else {
            cArr = new char[i11];
            i13 = 1;
        }
        while (true) {
            if ((i13 < i11 ? 'C' : 'b') == 'b') {
                return new String(cArr);
            }
            int i15 = f271 + 51;
            f268 = i15 % 128;
            int i16 = i15 % 2;
            cArr[i13] = (char) ((int) ((((long) f269[i12 + i13]) ^ (((long) i13) * f270)) ^ ((long) c11)));
            i13++;
        }
    }
}
