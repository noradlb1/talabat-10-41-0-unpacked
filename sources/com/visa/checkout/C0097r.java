package com.visa.checkout;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import com.google.common.base.Ascii;
import com.visa.checkout.e;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.visa.checkout.r  reason: case insensitive filesystem */
class C0097r extends m {

    /* renamed from: ʼ  reason: contains not printable characters */
    private static int f369 = 1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f370 = 16;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f371 = 725197091;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f372 = 156320838;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static byte[] f373 = {-4, Ascii.NAK, 3, -4, 19, -34, 11, -5, 5, 19, -24, -1, -10, 8, -9, 2, Ascii.SO, -13, -3, -65, 9, -8, 37, -28, -14, Ascii.DC2, -7, 5, -15, -3, 5, -8, -55, -7, 3, 3, -9, -3, 2};

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static int f374;

    /* renamed from: ˏ  reason: contains not printable characters */
    private q f375;

    public C0097r(WebView webView, q qVar) {
        super(webView);
        this.f375 = qVar;
        Map<String, e.b> r72 = m6231();
        r72.put(m6277(-725196980, (byte) 0, -156320838, -17, 0).intern(), new e.b() {

            /* renamed from: ˋ  reason: contains not printable characters */
            private static int f383 = 0;

            /* renamed from: ˏ  reason: contains not printable characters */
            private static long f384 = -2861977652436678868L;

            /* renamed from: ॱ  reason: contains not printable characters */
            private static int f385 = 1;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: ˏ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String m6285(java.lang.String r9) {
                /*
                    int r0 = f385
                    int r0 = r0 + 125
                    int r1 = r0 % 128
                    f383 = r1
                    int r0 = r0 % 2
                    r0 = 75
                    if (r9 == 0) goto L_0x0010
                    r1 = r0
                    goto L_0x0012
                L_0x0010:
                    r1 = 11
                L_0x0012:
                    if (r1 == r0) goto L_0x0015
                    goto L_0x0023
                L_0x0015:
                    char[] r9 = r9.toCharArray()
                    int r0 = f385
                    int r0 = r0 + 95
                    int r1 = r0 % 128
                    f383 = r1
                    int r0 = r0 % 2
                L_0x0023:
                    char[] r9 = (char[]) r9
                    long r0 = f384
                    char[] r9 = com.c.c.b.m9224(r0, r9)
                    r0 = 4
                    r1 = r0
                L_0x002d:
                    int r2 = r9.length
                    r3 = 1
                    if (r1 >= r2) goto L_0x0033
                    r2 = r3
                    goto L_0x0034
                L_0x0033:
                    r2 = 0
                L_0x0034:
                    if (r2 == r3) goto L_0x003e
                    java.lang.String r1 = new java.lang.String
                    int r2 = r9.length
                    int r2 = r2 - r0
                    r1.<init>(r9, r0, r2)
                    return r1
                L_0x003e:
                    int r2 = r1 + -4
                    char r3 = r9[r1]
                    int r4 = r1 % 4
                    char r4 = r9[r4]
                    r3 = r3 ^ r4
                    long r3 = (long) r3
                    long r5 = (long) r2
                    long r7 = f384
                    long r5 = r5 * r7
                    long r2 = r3 ^ r5
                    int r2 = (int) r2
                    char r2 = (char) r2
                    r9[r1] = r2
                    int r1 = r1 + 1
                    goto L_0x002d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.C0097r.AnonymousClass5.m6285(java.lang.String):java.lang.String");
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6286(ab abVar, e.C0003e eVar) throws Exception {
                boolean z11;
                C0097r.this.f277 = abVar.m6112(m6285("嵚㿓崷䂑캺栱䇦㷆ᬡ旗侢搶४").intern());
                JSONObject jSONObject = new JSONObject();
                JSONObject json = C0097r.this.m6280().m6273().toJSON();
                json.put(m6285("ആ㞾൥旮ᆴ롣ፆ䂴쨹㑐Ⰿ").intern(), (Object) VisaCheckoutSdk.getsCampaignData());
                jSONObject.put(m6285("畾桵甎꼫瘱墾槗൜䲛?").intern(), (Object) json);
                jSONObject.put(m6285("斫旛⦡⏋귡푊礃膭쨜ښ峲⥃樿༦").intern(), (Object) C0097r.this.m6280().m6272().toJSON());
                eVar.m6166(jSONObject);
                int i11 = f385 + 3;
                f383 = i11 % 128;
                if (i11 % 2 != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    int i12 = 46 / 0;
                }
            }
        });
        r72.put(m6277(-725196977, (byte) 0, -156320826, -17, 0).intern(), new e.b() {
            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6283(ab abVar, e.C0003e eVar) throws Exception {
                final VisaPaymentSummary visaPaymentSummary = new VisaPaymentSummary((JSONObject) abVar.m6113());
                eVar.m6166((Object) null);
                C0097r.this.m6282().runOnUiThread(new Runnable() {
                    public final void run() {
                        C0097r.m6276(C0097r.this).m6275().onResult(visaPaymentSummary);
                    }
                });
            }
        });
        Map<String, VisaConfigRequest> configRequestMap = this.f375.m6272().getConfigRequestMap();
        if (configRequestMap != null) {
            for (Map.Entry next : configRequestMap.entrySet()) {
                if (next.getValue() instanceof VisaConfigRequest) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(m6277(-725196979, (byte) 0, -156320820, -17, 0).intern());
                    sb2.append((String) next.getKey());
                    String obj = sb2.toString();
                    final VisaConfigRequest visaConfigRequest = (VisaConfigRequest) next.getValue();
                    r72.put(obj, new e.b() {
                        /* renamed from: ˋ  reason: contains not printable characters */
                        public final void m6284(ab abVar, final e.C0003e eVar) throws Exception {
                            r3.handleConfigRequest(abVar.m6113(), new VisaConfigResponse() {
                                public final void sendResponse(Object obj) {
                                    eVar.m6166(obj);
                                }
                            });
                        }
                    });
                }
            }
        }
        Map<String, VisaConfigRequest> configRequestMap2 = this.f375.m6273().getConfigRequestMap();
        if (configRequestMap2 != null) {
            for (Map.Entry next2 : configRequestMap2.entrySet()) {
                if (next2.getValue() instanceof VisaConfigRequest) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(m6277(-725196979, (byte) 0, -156320807, -17, 0).intern());
                    sb3.append((String) next2.getKey());
                    String obj2 = sb3.toString();
                    final VisaConfigRequest visaConfigRequest2 = (VisaConfigRequest) next2.getValue();
                    r72.put(obj2, new e.b() {
                        /* renamed from: ˋ  reason: contains not printable characters */
                        public final void m6284(ab abVar, final e.C0003e eVar) throws Exception {
                            visaConfigRequest2.handleConfigRequest(abVar.m6113(), new VisaConfigResponse() {
                                public final void sendResponse(Object obj) {
                                    eVar.m6166(obj);
                                }
                            });
                        }
                    });
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static /* synthetic */ q m6276(C0097r rVar) {
        int i11 = f374;
        int i12 = i11 + 11;
        f369 = i12 % 128;
        int i13 = i12 % 2;
        q qVar = rVar.f375;
        int i14 = i11 + 123;
        f369 = i14 % 128;
        int i15 = i14 % 2;
        return qVar;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final String m6278() {
        int i11 = f369 + 71;
        f374 = i11 % 128;
        int i12 = i11 % 2;
        String r02 = u.m6310(m6229(), false);
        int i13 = f374 + 21;
        f369 = i13 % 128;
        if ((i13 % 2 == 0 ? 'I' : 4) != 'I') {
            return r02;
        }
        int i14 = 27 / 0;
        return r02;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final void m6279() {
        int i11 = f369 + 101;
        f374 = i11 % 128;
        int i12 = i11 % 2;
        super.m6227();
        m6153();
        int i13 = f369 + 47;
        f374 = i13 % 128;
        int i14 = i13 % 2;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public final q m6280() {
        int i11 = f369;
        int i12 = i11 + 105;
        f374 = i12 % 128;
        int i13 = i12 % 2;
        q qVar = this.f375;
        int i14 = i11 + 25;
        f374 = i14 % 128;
        int i15 = i14 % 2;
        return qVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final Context m6281() {
        int i11 = f374 + 51;
        f369 = i11 % 128;
        if ((i11 % 2 == 0 ? 15 : '2') == '2') {
            return this.f375.m6274();
        }
        this.f375.m6274();
        throw null;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final Activity m6282() {
        boolean z11;
        int i11 = f374 + 77;
        f369 = i11 % 128;
        int i12 = i11 % 2;
        Activity r02 = this.f375.m6274();
        int i13 = f374 + 109;
        f369 = i13 % 128;
        if (i13 % 2 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return r02;
        }
        int i14 = 62 / 0;
        return r02;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String m6277(int i11, byte b11, int i12, int i13, short s11) {
        StringBuilder sb2 = new StringBuilder();
        int i14 = f370;
        int i15 = i13 + i14;
        boolean z11 = i15 == -1;
        if (z11) {
            byte[] bArr = f373;
            if (bArr != null) {
                int i16 = f374 + 45;
                f369 = i16 % 128;
                int i17 = i16 % 2;
                i15 = (byte) (bArr[f372 + i12] + i14);
            } else {
                throw null;
            }
        }
        if (i15 > 0) {
            int i18 = ((i12 + i15) - 2) + f372 + (z11 ? 1 : 0);
            char c11 = (char) (i11 + f371);
            sb2.append(c11);
            int i19 = 1;
            while (true) {
                if (!(i19 < i15)) {
                    break;
                }
                int i21 = f369 + 69;
                f374 = i21 % 128;
                if (i21 % 2 == 0) {
                    byte[] bArr2 = f373;
                    if ((bArr2 != null ? 'b' : 'F') == 'b') {
                        c11 = (char) (c11 + (((byte) (bArr2[i18] + s11)) ^ b11));
                        sb2.append(c11);
                        i19++;
                        i18--;
                    } else {
                        throw null;
                    }
                } else {
                    throw null;
                }
            }
        }
        String obj = sb2.toString();
        int i22 = f369 + 117;
        f374 = i22 % 128;
        if (i22 % 2 == 0) {
            return obj;
        }
        throw null;
    }
}
