package com.visa.checkout;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.visa.checkout.e;
import com.visa.checkout.t;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.pool.TypePool;
import org.json.JSONArray;
import org.json.JSONObject;

class d extends e {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static char f153 = '饆';

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private static int f154 = 0;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static char f155 = '楰';

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static char f156 = '绺';

    /* renamed from: ͺ  reason: contains not printable characters */
    private static int f157 = 1;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static char f158 = '㟄';

    /* renamed from: ʼ  reason: contains not printable characters */
    private BroadcastReceiver f159;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Map<String, e.b> f160 = new HashMap();

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f161 = d.class.getSimpleName();

    /* renamed from: ˋ  reason: contains not printable characters */
    private WebView f162;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Context f163;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f164;

    /* renamed from: ॱ  reason: contains not printable characters */
    private t f165;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private BroadcastReceiver f166 = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            Activity activity = VisaCheckoutSdk.getActivity();
            ((MutableContextWrapper) d.m6123(d.this).getContext()).setBaseContext(activity);
            activity.setContentView(d.m6123(d.this));
            d.m6125(d.this, (Context) activity);
            d.m6126(d.this);
            t.m6298(activity);
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f167;

    public d(Context context, h hVar, String str, String str2, final e.C0003e eVar) throws Exception {
        this.f163 = context;
        this.f165 = new t(context, m6127("稯欉廎穰锺?啿䥱ⲽ?忢堈⠟ꖎꑾ").intern());
        this.f164 = str;
        new k(this.f163, this.f165).m6206();
        Map<String, e.b> map = this.f160;
        map.put(m6127("浽垐헥㋣").intern(), new e.b() {

            /* renamed from: ˊ  reason: contains not printable characters */
            private static int f168 = 0;

            /* renamed from: ˋ  reason: contains not printable characters */
            private static long f169 = 2189596641914156544L;

            /* renamed from: ˏ  reason: contains not printable characters */
            private static int f170 = 1;

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6137(ab abVar, final e.C0003e eVar) throws Exception {
                d.m6126(d.this).m6299(abVar.m6112(m6136("瘀窮ʋṣ", "瀽ᔩꊞ?", 32162, "阭ꁃ娦", 0).intern()), new t.c() {
                    /* renamed from: ˎ  reason: contains not printable characters */
                    public final void m6138(Object obj) {
                        if (obj instanceof t.a) {
                            eVar.m6166(((t.a) obj).m6302());
                        } else if (obj instanceof t.e) {
                            eVar.m6166(((t.e) obj).m6307());
                        } else {
                            eVar.m6166(obj);
                        }
                    }
                });
                int i11 = f168 + 101;
                f170 = i11 % 128;
                int i12 = i11 % 2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: ˋ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String m6136(java.lang.String r5, java.lang.String r6, char r7, java.lang.String r8, int r9) {
                /*
                    r0 = 0
                    r1 = 1
                    if (r8 == 0) goto L_0x0006
                    r2 = r0
                    goto L_0x0007
                L_0x0006:
                    r2 = r1
                L_0x0007:
                    if (r2 == r1) goto L_0x000d
                    char[] r8 = r8.toCharArray()
                L_0x000d:
                    char[] r8 = (char[]) r8
                    if (r6 == 0) goto L_0x0013
                    r2 = r1
                    goto L_0x0014
                L_0x0013:
                    r2 = r0
                L_0x0014:
                    r3 = 2
                    if (r2 == r1) goto L_0x0018
                    goto L_0x0025
                L_0x0018:
                    char[] r6 = r6.toCharArray()
                    int r2 = f168
                    int r2 = r2 + 75
                    int r4 = r2 % 128
                    f170 = r4
                    int r2 = r2 % r3
                L_0x0025:
                    char[] r6 = (char[]) r6
                    if (r5 == 0) goto L_0x002b
                    r2 = r1
                    goto L_0x002c
                L_0x002b:
                    r2 = r0
                L_0x002c:
                    if (r2 == r1) goto L_0x002f
                    goto L_0x003e
                L_0x002f:
                    int r1 = f168
                    int r1 = r1 + 77
                    int r2 = r1 % 128
                    f170 = r2
                    int r1 = r1 % r3
                    if (r1 == 0) goto L_0x007b
                    char[] r5 = r5.toCharArray()
                L_0x003e:
                    char[] r5 = (char[]) r5
                    java.lang.Object r6 = r6.clone()
                    char[] r6 = (char[]) r6
                    java.lang.Object r5 = r5.clone()
                    char[] r5 = (char[]) r5
                    char r1 = r6[r0]
                    r7 = r7 ^ r1
                    char r7 = (char) r7
                    r6[r0] = r7
                    char r7 = r5[r3]
                    char r9 = (char) r9
                    int r7 = r7 + r9
                    char r7 = (char) r7
                    r5[r3] = r7
                    int r7 = r8.length
                    char[] r9 = new char[r7]
                L_0x005c:
                    if (r0 >= r7) goto L_0x0075
                    com.c.c.c.m9225(r6, r5, r0)
                    char r1 = r8[r0]
                    int r2 = r0 + 3
                    int r2 = r2 % 4
                    char r2 = r6[r2]
                    r1 = r1 ^ r2
                    long r1 = (long) r1
                    long r3 = f169
                    long r1 = r1 ^ r3
                    int r1 = (int) r1
                    char r1 = (char) r1
                    r9[r0] = r1
                    int r0 = r0 + 1
                    goto L_0x005c
                L_0x0075:
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r9)
                    return r5
                L_0x007b:
                    r5.toCharArray()
                    r5 = 0
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.d.AnonymousClass1.m6136(java.lang.String, java.lang.String, char, java.lang.String, int):java.lang.String");
            }
        });
        map.put(m6127("镍댤헥㋣").intern(), new e.b() {

            /* renamed from: ˋ  reason: contains not printable characters */
            private static int f187 = 70;

            /* renamed from: ˎ  reason: contains not printable characters */
            private static int f188 = 0;

            /* renamed from: ॱ  reason: contains not printable characters */
            private static int f189 = 1;

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6143(ab abVar, e.C0003e eVar) throws Exception {
                Serializable serializable;
                int i11;
                boolean z11 = true;
                JSONObject r02 = abVar.m6114(m6142(172, "￻￾￻\u000e", 4, 1, false).intern());
                JSONObject r12 = abVar.m6117(m6142(Opcodes.PUTFIELD, "\u0005￺\u0000￿\u0004\u0000\u0001", 7, 5, false).intern());
                String string = r02.getString(m6142(Opcodes.PUTSTATIC, "￾\f￸", 3, 1, true).intern());
                Object opt = r02.opt(m6142(Opcodes.GETSTATIC, "\t\u0000￵\n￹", 5, 4, true).intern());
                if (opt instanceof JSONObject) {
                    serializable = new t.a((JSONObject) opt);
                } else {
                    if (opt instanceof JSONArray) {
                        serializable = new t.e((JSONArray) opt);
                        i11 = f188 + 89;
                        f189 = i11 % 128;
                    } else {
                        if ((opt != null ? TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH : '$') == '$' || opt == JSONObject.NULL) {
                            serializable = null;
                        } else {
                            serializable = (Serializable) opt;
                            i11 = f189 + 27;
                            f188 = i11 % 128;
                        }
                    }
                    int i12 = i11 % 2;
                }
                String optString = r02.optString(m6142(Opcodes.INVOKEVIRTUAL, "\u0000\u0004\u0000\u0002￿�", 6, 2, false).intern());
                EnumSet<E> noneOf = EnumSet.noneOf(x.class);
                if (r12 == null) {
                    int i13 = f189 + 33;
                    f188 = i13 % 128;
                    int i14 = i13 % 2;
                    d.m6126(d.this).m6301(string, serializable, noneOf, optString);
                    return;
                }
                if (r12.has(m6142(Opcodes.RETURN, "￸￺\b￺\u0007\n", 6, 3, true).intern())) {
                    z11 = false;
                }
                if (!z11) {
                    noneOf.add(x.f418);
                }
                if (r12.has(m6142(Opcodes.ARETURN, "\u000b\n￾\b￻\u0007\u000b￿\b￻ￗ", 11, 3, false).intern())) {
                    noneOf.add(x.f417);
                }
                d.m6126(d.this).m6301(string, serializable, noneOf, optString);
                eVar.m6166((Object) null);
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: java.lang.String} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: ˋ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String m6142(int r5, java.lang.String r6, int r7, int r8, boolean r9) {
                /*
                    int r0 = f189
                    int r1 = r0 + 53
                    int r2 = r1 % 128
                    f188 = r2
                    int r1 = r1 % 2
                    if (r6 == 0) goto L_0x0020
                    int r0 = r0 + 83
                    int r1 = r0 % 128
                    f188 = r1
                    int r0 = r0 % 2
                    if (r0 != 0) goto L_0x001b
                    char[] r6 = r6.toCharArray()
                    goto L_0x0020
                L_0x001b:
                    r6.toCharArray()
                    r5 = 0
                    throw r5
                L_0x0020:
                    char[] r6 = (char[]) r6
                    char[] r0 = new char[r7]
                    r1 = 0
                    r2 = r1
                L_0x0026:
                    if (r2 >= r7) goto L_0x0037
                    char r3 = r6[r2]
                    int r3 = r3 + r5
                    char r3 = (char) r3
                    r0[r2] = r3
                    int r4 = f187
                    int r3 = r3 - r4
                    char r3 = (char) r3
                    r0[r2] = r3
                    int r2 = r2 + 1
                    goto L_0x0026
                L_0x0037:
                    r5 = 1
                    if (r8 <= 0) goto L_0x003c
                    r6 = r5
                    goto L_0x003d
                L_0x003c:
                    r6 = r1
                L_0x003d:
                    if (r6 == 0) goto L_0x0060
                    int r6 = f189
                    int r6 = r6 + 99
                    int r2 = r6 % 128
                    f188 = r2
                    int r6 = r6 % 2
                    char[] r6 = new char[r7]
                    java.lang.System.arraycopy(r0, r1, r6, r1, r7)
                    int r2 = r7 - r8
                    java.lang.System.arraycopy(r6, r1, r0, r2, r8)
                    java.lang.System.arraycopy(r6, r8, r0, r1, r2)
                    int r6 = f189
                    int r6 = r6 + 41
                    int r8 = r6 % 128
                    f188 = r8
                    int r6 = r6 % 2
                L_0x0060:
                    r6 = 53
                    if (r9 == 0) goto L_0x0067
                    r8 = 73
                    goto L_0x0068
                L_0x0067:
                    r8 = r6
                L_0x0068:
                    if (r8 == r6) goto L_0x0090
                    int r6 = f189
                    int r6 = r6 + 101
                    int r8 = r6 % 128
                    f188 = r8
                    int r6 = r6 % 2
                    if (r6 == 0) goto L_0x0078
                    r6 = r5
                    goto L_0x0079
                L_0x0078:
                    r6 = r1
                L_0x0079:
                    char[] r6 = new char[r7]
                L_0x007b:
                    r8 = 54
                    if (r1 >= r7) goto L_0x0081
                    r9 = r8
                    goto L_0x0082
                L_0x0081:
                    r9 = r5
                L_0x0082:
                    if (r9 == r8) goto L_0x0086
                    r0 = r6
                    goto L_0x0090
                L_0x0086:
                    int r8 = r7 - r1
                    int r8 = r8 - r5
                    char r8 = r0[r8]
                    r6[r1] = r8
                    int r1 = r1 + 1
                    goto L_0x007b
                L_0x0090:
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r0)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.d.AnonymousClass5.m6142(int, java.lang.String, int, int, boolean):java.lang.String");
            }
        });
        map.put(m6127("לּ慙㹤﬛≘⾨糁").intern(), new e.b() {

            /* renamed from: ˊ  reason: contains not printable characters */
            private static int f174 = 1;

            /* renamed from: ˋ  reason: contains not printable characters */
            private static char[] f175 = {136, 271, 249, 242, 259, 264, 254, 258, 268, 269, 276, 269, 261};

            /* renamed from: ˎ  reason: contains not printable characters */
            private static int f176;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v20, resolved type: byte[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v21, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v22, resolved type: java.lang.String} */
            /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r9v3, types: [char] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: ˏ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String m6139(boolean r12, int[] r13, java.lang.String r14) {
                /*
                    int r0 = f176
                    int r0 = r0 + 17
                    int r1 = r0 % 128
                    f174 = r1
                    r1 = 2
                    int r0 = r0 % r1
                    if (r14 == 0) goto L_0x0012
                    java.lang.String r0 = "ISO-8859-1"
                    byte[] r14 = r14.getBytes(r0)
                L_0x0012:
                    byte[] r14 = (byte[]) r14
                    r0 = 0
                    r2 = r13[r0]
                    r3 = 1
                    r4 = r13[r3]
                    r5 = r13[r1]
                    r6 = 3
                    r6 = r13[r6]
                    char[] r7 = f175
                    char[] r8 = new char[r4]
                    java.lang.System.arraycopy(r7, r2, r8, r0, r4)
                    if (r14 == 0) goto L_0x0059
                    char[] r2 = new char[r4]
                    int r7 = f176
                    int r7 = r7 + 73
                    int r9 = r7 % 128
                    f174 = r9
                    int r7 = r7 % r1
                    r7 = r0
                    r9 = r7
                L_0x0035:
                    r10 = 57
                    if (r7 >= r4) goto L_0x003c
                    r11 = 42
                    goto L_0x003d
                L_0x003c:
                    r11 = r10
                L_0x003d:
                    if (r11 == r10) goto L_0x0058
                    byte r10 = r14[r7]
                    if (r10 != r3) goto L_0x004c
                    char r10 = r8[r7]
                    int r10 = r10 << r3
                    int r10 = r10 + r3
                    int r10 = r10 - r9
                    char r9 = (char) r10
                    r2[r7] = r9
                    goto L_0x0053
                L_0x004c:
                    char r10 = r8[r7]
                    int r10 = r10 << r3
                    int r10 = r10 - r9
                    char r9 = (char) r10
                    r2[r7] = r9
                L_0x0053:
                    char r9 = r2[r7]
                    int r7 = r7 + 1
                    goto L_0x0035
                L_0x0058:
                    r8 = r2
                L_0x0059:
                    if (r6 <= 0) goto L_0x0088
                    int r14 = f176
                    int r14 = r14 + 123
                    int r2 = r14 % 128
                    f174 = r2
                    int r14 = r14 % r1
                    if (r14 != 0) goto L_0x0068
                    r14 = r3
                    goto L_0x0069
                L_0x0068:
                    r14 = r0
                L_0x0069:
                    if (r14 == 0) goto L_0x007b
                    char[] r14 = new char[r4]
                    java.lang.System.arraycopy(r8, r0, r14, r0, r4)
                    int r2 = r4 * r6
                    java.lang.System.arraycopy(r14, r3, r8, r2, r6)
                    int r2 = r4 + r6
                    java.lang.System.arraycopy(r14, r6, r8, r3, r2)
                    goto L_0x0088
                L_0x007b:
                    char[] r14 = new char[r4]
                    java.lang.System.arraycopy(r8, r0, r14, r0, r4)
                    int r2 = r4 - r6
                    java.lang.System.arraycopy(r14, r0, r8, r2, r6)
                    java.lang.System.arraycopy(r14, r6, r8, r0, r2)
                L_0x0088:
                    r14 = 14
                    if (r12 == 0) goto L_0x008e
                    r12 = r14
                    goto L_0x0090
                L_0x008e:
                    r12 = 23
                L_0x0090:
                    if (r12 == r14) goto L_0x0093
                    goto L_0x00aa
                L_0x0093:
                    char[] r12 = new char[r4]
                    r14 = r0
                L_0x0096:
                    r2 = 95
                    if (r14 >= r4) goto L_0x009c
                    r6 = r2
                    goto L_0x009e
                L_0x009c:
                    r6 = 43
                L_0x009e:
                    if (r6 == r2) goto L_0x00c8
                    int r14 = f174
                    int r14 = r14 + 71
                    int r2 = r14 % 128
                    f176 = r2
                    int r14 = r14 % r1
                    r8 = r12
                L_0x00aa:
                    if (r5 <= 0) goto L_0x00c2
                L_0x00ac:
                    if (r0 >= r4) goto L_0x00c2
                    int r12 = f174
                    int r12 = r12 + 7
                    int r14 = r12 % 128
                    f176 = r14
                    int r12 = r12 % r1
                    char r12 = r8[r0]
                    r14 = r13[r1]
                    int r12 = r12 - r14
                    char r12 = (char) r12
                    r8[r0] = r12
                    int r0 = r0 + 1
                    goto L_0x00ac
                L_0x00c2:
                    java.lang.String r12 = new java.lang.String
                    r12.<init>(r8)
                    return r12
                L_0x00c8:
                    int r2 = r4 - r14
                    int r2 = r2 - r3
                    char r2 = r8[r2]
                    r12[r14] = r2
                    int r14 = r14 + 1
                    int r2 = f176
                    int r2 = r2 + 29
                    int r6 = r2 % 128
                    f174 = r6
                    int r2 = r2 % r1
                    goto L_0x0096
                */
                throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.d.AnonymousClass10.m6139(boolean, int[], java.lang.String):java.lang.String");
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6140(ab abVar, final e.C0003e eVar) throws Exception {
                d.m6124(d.this, (BroadcastReceiver) new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        eVar.m6166((Object) null);
                    }
                });
                boolean z11 = false;
                LocalBroadcastManager.getInstance(d.this.m6160()).registerReceiver(d.m6128(d.this), new IntentFilter(m6139(false, new int[]{0, 13, Opcodes.IF_ICMPLT, 0}, "\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0001").intern()));
                int i11 = f176 + 23;
                f174 = i11 % 128;
                if (i11 % 2 != 0) {
                    z11 = true;
                }
                if (!z11) {
                    throw null;
                }
            }
        });
        map.put(m6127("쨼죁諭࿐ㅝ藘䋒ᅯ㝙").intern(), new e.b() {

            /* renamed from: ˋ  reason: contains not printable characters */
            private static char f191 = '琫';

            /* renamed from: ˎ  reason: contains not printable characters */
            private static int f192 = 1;

            /* renamed from: ˏ  reason: contains not printable characters */
            private static int f193;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.String} */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: ˊ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String m6144(java.lang.String r5, int r6, java.lang.String r7, java.lang.String r8, char r9) {
                /*
                    r0 = 0
                    r1 = 2
                    if (r8 == 0) goto L_0x0023
                    int r2 = f193
                    int r2 = r2 + 67
                    int r3 = r2 % 128
                    f192 = r3
                    int r2 = r2 % r1
                    r3 = 77
                    if (r2 != 0) goto L_0x0013
                    r2 = r3
                    goto L_0x0015
                L_0x0013:
                    r2 = 15
                L_0x0015:
                    if (r2 == r3) goto L_0x001c
                    char[] r8 = r8.toCharArray()
                    goto L_0x0023
                L_0x001c:
                    char[] r8 = r8.toCharArray()
                    r2 = 42
                    int r2 = r2 / r0
                L_0x0023:
                    char[] r8 = (char[]) r8
                    if (r7 == 0) goto L_0x0029
                    r2 = r0
                    goto L_0x002a
                L_0x0029:
                    r2 = 1
                L_0x002a:
                    if (r2 == 0) goto L_0x002d
                    goto L_0x003a
                L_0x002d:
                    int r2 = f193
                    int r2 = r2 + 19
                    int r3 = r2 % 128
                    f192 = r3
                    int r2 = r2 % r1
                    char[] r7 = r7.toCharArray()
                L_0x003a:
                    char[] r7 = (char[]) r7
                    if (r5 == 0) goto L_0x004b
                    int r2 = f192
                    int r2 = r2 + 125
                    int r3 = r2 % 128
                    f193 = r3
                    int r2 = r2 % r1
                    char[] r5 = r5.toCharArray()
                L_0x004b:
                    char[] r5 = (char[]) r5
                    java.lang.Object r8 = r8.clone()
                    char[] r8 = (char[]) r8
                    java.lang.Object r5 = r5.clone()
                    char[] r5 = (char[]) r5
                    char r2 = r8[r0]
                    r9 = r9 ^ r2
                    char r9 = (char) r9
                    r8[r0] = r9
                    char r9 = r5[r1]
                    char r6 = (char) r6
                    int r9 = r9 + r6
                    char r6 = (char) r9
                    r5[r1] = r6
                    int r6 = r7.length
                    char[] r9 = new char[r6]
                L_0x0069:
                    if (r0 >= r6) goto L_0x0083
                    com.c.c.c.m9225(r8, r5, r0)
                    char r1 = r7[r0]
                    int r2 = r0 + 3
                    int r2 = r2 % 4
                    char r2 = r8[r2]
                    r1 = r1 ^ r2
                    long r1 = (long) r1
                    char r3 = f191
                    long r3 = (long) r3
                    long r1 = r1 ^ r3
                    int r1 = (int) r1
                    char r1 = (char) r1
                    r9[r0] = r1
                    int r0 = r0 + 1
                    goto L_0x0069
                L_0x0083:
                    java.lang.String r5 = new java.lang.String
                    r5.<init>(r9)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.d.AnonymousClass9.m6144(java.lang.String, int, java.lang.String, java.lang.String, char):java.lang.String");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
                if (r9 == null) goto L_0x0052;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x007f, code lost:
                com.visa.checkout.y.m6319(r8.f194.m6160(), r9);
                r9 = f192 + 11;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
                if (r6 != false) goto L_0x0052;
             */
            /* renamed from: ˋ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void m6145(com.visa.checkout.ab r9, com.visa.checkout.e.C0003e r10) throws java.lang.Exception {
                /*
                    r8 = this;
                    int r0 = f193
                    int r0 = r0 + 97
                    int r1 = r0 % 128
                    f192 = r1
                    int r0 = r0 % 2
                    r1 = 94
                    if (r0 != 0) goto L_0x0010
                    r0 = r1
                    goto L_0x0012
                L_0x0010:
                    r0 = 17
                L_0x0012:
                    r2 = 55277(0xd7ed, float:7.746E-41)
                    java.lang.String r3 = "᳆▦惗"
                    java.lang.String r4 = "䍇鳽障᫿"
                    java.lang.String r5 = "\u0000\u0000\u0000\u0000"
                    r6 = 1
                    r7 = 0
                    if (r0 == r1) goto L_0x003b
                    java.lang.String r0 = m6144(r5, r7, r4, r3, r2)
                    java.lang.String r0 = r0.intern()
                    java.lang.String r9 = r9.m6112(r0)
                    byte[] r9 = android.util.Base64.decode(r9, r7)
                    int r0 = r9.length
                    android.graphics.Bitmap r9 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeByteArray(r9, r7, r0)
                    if (r9 != 0) goto L_0x0037
                    goto L_0x0038
                L_0x0037:
                    r6 = r7
                L_0x0038:
                    if (r6 == 0) goto L_0x007f
                    goto L_0x0052
                L_0x003b:
                    java.lang.String r0 = m6144(r5, r7, r4, r3, r2)
                    java.lang.String r0 = r0.intern()
                    java.lang.String r9 = r9.m6112(r0)
                    byte[] r9 = android.util.Base64.decode(r9, r6)
                    int r0 = r9.length
                    android.graphics.Bitmap r9 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeByteArray(r9, r6, r0)
                    if (r9 != 0) goto L_0x007f
                L_0x0052:
                    int r9 = f192
                    int r9 = r9 + 117
                    int r0 = r9 % 128
                    f193 = r0
                    int r9 = r9 % 2
                    if (r9 == 0) goto L_0x006b
                    com.visa.checkout.d r9 = com.visa.checkout.d.this
                    android.app.Activity r9 = r9.m6160()
                    com.visa.checkout.y.m6318(r9)
                    r9 = 13
                    int r9 = r9 / r7
                    goto L_0x0074
                L_0x006b:
                    com.visa.checkout.d r9 = com.visa.checkout.d.this
                    android.app.Activity r9 = r9.m6160()
                    com.visa.checkout.y.m6318(r9)
                L_0x0074:
                    int r9 = f192
                    int r9 = r9 + 3
                L_0x0078:
                    int r0 = r9 % 128
                    f193 = r0
                    int r9 = r9 % 2
                    goto L_0x008d
                L_0x007f:
                    com.visa.checkout.d r0 = com.visa.checkout.d.this
                    android.app.Activity r0 = r0.m6160()
                    com.visa.checkout.y.m6319(r0, r9)
                    int r9 = f192
                    int r9 = r9 + 11
                    goto L_0x0078
                L_0x008d:
                    r9 = 0
                    r10.m6166(r9)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.d.AnonymousClass9.m6145(com.visa.checkout.ab, com.visa.checkout.e$e):void");
            }
        });
        WebView webView = new WebView(new MutableContextWrapper(context));
        this.f162 = webView;
        webView.addJavascriptInterface(this, m6127("뵥퀄啿䥱먥鹹ֻ뫑Ⱃ濦G䒒").intern());
        WebSettings settings = this.f162.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setUserAgentString(hVar.m6181());
        this.f162.setBackgroundColor(-1);
        this.f162.setWebViewClient(new WebViewClient() {
            public final void onPageFinished(WebView webView, String str) {
                eVar.m6166(Boolean.valueOf(VisaCheckoutSdk.isAlreadyLaunched(d.m6122(d.this))));
            }

            public final void onReceivedError(WebView webView, int i11, String str, String str2) {
            }

            @RequiresApi(api = 23)
            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    eVar.m6167(webResourceError.getDescription().toString());
                }
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        });
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.f162.setWebChromeClient(new WebChromeClient() {

            /* renamed from: ˋ  reason: contains not printable characters */
            private static int f182 = 1;

            /* renamed from: ˎ  reason: contains not printable characters */
            private static long f183 = -2527921019053796430L;

            /* renamed from: ॱ  reason: contains not printable characters */
            private static int f184;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: char[]} */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: ˎ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String m6141(java.lang.String r7, java.lang.String r8, char r9, java.lang.String r10, int r11) {
                /*
                    r0 = 2
                    if (r10 == 0) goto L_0x0010
                    int r1 = f184
                    int r1 = r1 + 91
                    int r2 = r1 % 128
                    f182 = r2
                    int r1 = r1 % r0
                    char[] r10 = r10.toCharArray()
                L_0x0010:
                    char[] r10 = (char[]) r10
                    r1 = 74
                    if (r8 == 0) goto L_0x0019
                    r2 = 53
                    goto L_0x001a
                L_0x0019:
                    r2 = r1
                L_0x001a:
                    if (r2 == r1) goto L_0x0020
                    char[] r8 = r8.toCharArray()
                L_0x0020:
                    char[] r8 = (char[]) r8
                    if (r7 == 0) goto L_0x0031
                    char[] r7 = r7.toCharArray()
                    int r1 = f182
                    int r1 = r1 + 107
                    int r2 = r1 % 128
                    f184 = r2
                    int r1 = r1 % r0
                L_0x0031:
                    char[] r7 = (char[]) r7
                    java.lang.Object r8 = r8.clone()
                    char[] r8 = (char[]) r8
                    java.lang.Object r7 = r7.clone()
                    char[] r7 = (char[]) r7
                    r1 = 0
                    char r2 = r8[r1]
                    r9 = r9 ^ r2
                    char r9 = (char) r9
                    r8[r1] = r9
                    char r9 = r7[r0]
                    char r11 = (char) r11
                    int r9 = r9 + r11
                    char r9 = (char) r9
                    r7[r0] = r9
                    int r9 = r10.length
                    char[] r11 = new char[r9]
                    r2 = r1
                L_0x0051:
                    r3 = 1
                    if (r2 >= r9) goto L_0x0056
                    r4 = r1
                    goto L_0x0057
                L_0x0056:
                    r4 = r3
                L_0x0057:
                    if (r4 == r3) goto L_0x0079
                    int r3 = f184
                    int r3 = r3 + 35
                    int r4 = r3 % 128
                    f182 = r4
                    int r3 = r3 % r0
                    com.c.c.c.m9225(r8, r7, r2)
                    char r3 = r10[r2]
                    int r4 = r2 + 3
                    int r4 = r4 % 4
                    char r4 = r8[r4]
                    r3 = r3 ^ r4
                    long r3 = (long) r3
                    long r5 = f183
                    long r3 = r3 ^ r5
                    int r3 = (int) r3
                    char r3 = (char) r3
                    r11[r2] = r3
                    int r2 = r2 + 1
                    goto L_0x0051
                L_0x0079:
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r11)
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.d.AnonymousClass3.m6141(java.lang.String, java.lang.String, char, java.lang.String, int):java.lang.String");
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                int i11 = f182 + 105;
                f184 = i11 % 128;
                int i12 = i11 % 2;
                d.m6129(d.this);
                m6141("Ꮂ܎Ժ?", "儭볶뾬", 0, "섛옟豥职ɕ鮓瀸", 0).intern();
                consoleMessage.message();
                m6141("Ꮂ܎Ժ?", "姄옴軻꼉", 2446, "浉៽ᆷ䠐", 0).intern();
                consoleMessage.sourceId();
                m6141("Ꮂ܎Ժ?", "礏ᶨ푧ᒢ", 41684, "뤸", 1729996921).intern();
                consoleMessage.lineNumber();
                int i13 = f182 + 13;
                f184 = i13 % 128;
                int i14 = i13 % 2;
                return true;
            }

            public final boolean onCreateWindow(WebView webView, boolean z11, boolean z12, Message message) {
                boolean z13;
                boolean z14;
                int i11 = f184 + 109;
                f182 = i11 % 128;
                int i12 = i11 % 2;
                WebView.HitTestResult hitTestResult = webView.getHitTestResult();
                if (z12) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (!z13) {
                    if (hitTestResult.getType() == 7) {
                        webView.getContext().startActivity(new Intent(m6141("Ꮂ܎Ժ?", "嬬币镪챕", 21909, "뾢ꭣヨ䔳ɛ陈Ό붷쒺㹺ۻ邍쏱㙭㖄뺏碨淂黿庖會廭⩗౉", 0).intern(), Uri.parse(hitTestResult.getExtra())));
                    } else if (hitTestResult.getType() == 0) {
                        WebView webView2 = new WebView(d.this.m6160());
                        webView2.getSettings().setJavaScriptEnabled(true);
                        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
                        message.sendToTarget();
                        int i13 = f182 + 67;
                        f184 = i13 % 128;
                        if (i13 % 2 != 0) {
                            z14 = false;
                        } else {
                            z14 = true;
                        }
                        if (!z14) {
                            int i14 = 61 / 0;
                        }
                        return true;
                    }
                }
                int i15 = f184 + 25;
                f182 = i15 % 128;
                int i16 = i15 % 2;
                return false;
            }
        });
        if (hVar.m6183().equals(m6127("ꘃ輂㉓升뼌ᡈ").intern())) {
            this.f162.postUrl(hVar.m6182(), hVar.m6184());
        } else {
            this.f162.loadUrl(hVar.m6182(), hVar.m6180());
        }
        m6159(str2);
        LocalBroadcastManager.getInstance(this.f163).registerReceiver(this.f166, new IntentFilter(m6127("䳚呭ꊢ਌㷁똗み旅Ɇ妖郲隆ꓷ⌰놔").intern()));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static /* synthetic */ String m6122(d dVar) {
        int i11 = f157;
        int i12 = i11 + 103;
        f154 = i12 % 128;
        int i13 = i12 % 2;
        String str = dVar.f167;
        int i14 = i11 + 23;
        f154 = i14 % 128;
        int i15 = i14 % 2;
        return str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static /* synthetic */ WebView m6123(d dVar) {
        int i11 = f154;
        int i12 = i11 + 99;
        f157 = i12 % 128;
        char c11 = i12 % 2 == 0 ? '\"' : 'b';
        WebView webView = dVar.f162;
        if (c11 == 'b') {
            int i13 = i11 + 63;
            f157 = i13 % 128;
            if (!(i13 % 2 != 0)) {
                int i14 = 24 / 0;
            }
            return webView;
        }
        throw null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ BroadcastReceiver m6124(d dVar, BroadcastReceiver broadcastReceiver) {
        int i11 = f154;
        int i12 = i11 + 83;
        f157 = i12 % 128;
        char c11 = i12 % 2 == 0 ? 'F' : 16;
        dVar.f159 = broadcastReceiver;
        if (c11 == 'F') {
            int i13 = 87 / 0;
        }
        int i14 = i11 + 105;
        f157 = i14 % 128;
        int i15 = i14 % 2;
        return broadcastReceiver;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ BroadcastReceiver m6128(d dVar) {
        int i11 = f154;
        int i12 = i11 + 87;
        f157 = i12 % 128;
        int i13 = i12 % 2;
        BroadcastReceiver broadcastReceiver = dVar.f159;
        int i14 = i11 + 65;
        f157 = i14 % 128;
        int i15 = i14 % 2;
        return broadcastReceiver;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ String m6129(d dVar) {
        int i11 = f157 + 57;
        f154 = i11 % 128;
        char c11 = i11 % 2 != 0 ? TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH : 10;
        String str = dVar.f161;
        if (c11 == 10) {
            return str;
        }
        throw null;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final void m6130() {
        char c11;
        int i11 = f154 + 9;
        f157 = i11 % 128;
        int i12 = i11 % 2;
        super.m6152();
        LocalBroadcastManager.getInstance(this.f163).unregisterReceiver(this.f166);
        LocalBroadcastManager.getInstance(this.f163).unregisterReceiver(this.f159);
        VisaCheckoutSdk.setActivity((Activity) null);
        m6153();
        t tVar = this.f165;
        if (tVar == null) {
            int i13 = f154 + 89;
            f157 = i13 % 128;
            int i14 = i13 % 2;
            return;
        }
        tVar.m6300();
        this.f165 = null;
        int i15 = f157 + 43;
        f154 = i15 % 128;
        if (i15 % 2 != 0) {
            c11 = '.';
        } else {
            c11 = 12;
        }
        if (c11 == '.') {
            throw null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ Context m6125(d dVar, Context context) {
        int i11 = f157 + 79;
        int i12 = i11 % 128;
        f154 = i12;
        char c11 = i11 % 2 != 0 ? '2' : 'b';
        dVar.f163 = context;
        if (c11 == '2') {
            int i13 = 50 / 0;
        }
        int i14 = i12 + 27;
        f157 = i14 % 128;
        int i15 = i14 % 2;
        return context;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m6131() {
        int i11 = f157 + 81;
        f154 = i11 % 128;
        if ((i11 % 2 != 0 ? '*' : 8) != '*') {
            return this.f164;
        }
        throw null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final WebView m6133() {
        WebView webView;
        int i11 = f157;
        int i12 = i11 + 37;
        f154 = i12 % 128;
        if ((i12 % 2 != 0 ? '*' : 'V') != '*') {
            webView = this.f162;
        } else {
            webView = this.f162;
            int i13 = 98 / 0;
        }
        int i14 = i11 + 85;
        f154 = i14 % 128;
        if ((i14 % 2 != 0 ? 'J' : 6) != 'J') {
            return webView;
        }
        throw null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final Context m6135() {
        int i11 = f154 + 105;
        int i12 = i11 % 128;
        f157 = i12;
        int i13 = i11 % 2;
        Context context = this.f163;
        int i14 = i12 + 1;
        f154 = i14 % 128;
        int i15 = i14 % 2;
        return context;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static /* synthetic */ t m6126(d dVar) {
        int i11 = f154;
        int i12 = i11 + 99;
        f157 = i12 % 128;
        int i13 = i12 % 2;
        t tVar = dVar.f165;
        int i14 = i11 + 65;
        f157 = i14 % 128;
        int i15 = i14 % 2;
        return tVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m6132(String str) {
        int i11 = f157 + 61;
        int i12 = i11 % 128;
        f154 = i12;
        char c11 = i11 % 2 != 0 ? '6' : 23;
        this.f167 = str;
        if (c11 != '6') {
            int i13 = i12 + 79;
            f157 = i13 % 128;
            int i14 = i13 % 2;
            return;
        }
        throw null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final Map<String, e.b> m6134() {
        int i11 = f157 + 83;
        int i12 = i11 % 128;
        f154 = i12;
        if (i11 % 2 == 0) {
            Map<String, e.b> map = this.f160;
            int i13 = i12 + 39;
            f157 = i13 % 128;
            int i14 = i13 % 2;
            return map;
        }
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6127(java.lang.String r11) {
        /*
            r0 = 98
            if (r11 == 0) goto L_0x0006
            r1 = 3
            goto L_0x0007
        L_0x0006:
            r1 = r0
        L_0x0007:
            r2 = 2
            if (r1 == r0) goto L_0x0017
            char[] r11 = r11.toCharArray()
            int r0 = f154
            int r0 = r0 + 85
            int r1 = r0 % 128
            f157 = r1
            int r0 = r0 % r2
        L_0x0017:
            char[] r11 = (char[]) r11
            int r0 = r11.length
            char[] r0 = new char[r0]
            char[] r1 = new char[r2]
            r3 = 0
            r4 = r3
        L_0x0020:
            int r5 = r11.length
            r6 = 1
            if (r4 >= r5) goto L_0x007f
            int r5 = f157
            int r5 = r5 + 85
            int r7 = r5 % 128
            f154 = r7
            int r5 = r5 % r2
            if (r5 == 0) goto L_0x0031
            r5 = r6
            goto L_0x0032
        L_0x0031:
            r5 = r3
        L_0x0032:
            if (r5 == 0) goto L_0x0056
            char r5 = r11[r4]
            r1[r6] = r5
            int r5 = r4 >>> 0
            char r5 = r11[r5]
            r1[r3] = r5
            char r5 = f153
            char r7 = f156
            char r8 = f158
            char r9 = f155
            com.c.c.g.m9231(r1, r5, r7, r8, r9)
            char r5 = r1[r6]
            r0[r4] = r5
            int r5 = r4 * 0
            char r6 = r1[r6]
            r0[r5] = r6
            int r4 = r4 + 90
            goto L_0x0075
        L_0x0056:
            char r5 = r11[r4]
            r1[r3] = r5
            int r5 = r4 + 1
            char r7 = r11[r5]
            r1[r6] = r7
            char r7 = f153
            char r8 = f156
            char r9 = f158
            char r10 = f155
            com.c.c.g.m9231(r1, r7, r8, r9, r10)
            char r7 = r1[r3]
            r0[r4] = r7
            char r6 = r1[r6]
            r0[r5] = r6
            int r4 = r4 + 2
        L_0x0075:
            int r5 = f157
            int r5 = r5 + 93
            int r6 = r5 % 128
            f154 = r6
            int r5 = r5 % r2
            goto L_0x0020
        L_0x007f:
            char r11 = r0[r3]
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0, r6, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.d.m6127(java.lang.String):java.lang.String");
    }
}
