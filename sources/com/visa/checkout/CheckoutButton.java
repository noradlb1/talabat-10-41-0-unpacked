package com.visa.checkout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.c.c.d;
import com.google.common.base.Ascii;
import com.visa.checkout.VisaCheckoutSdk;
import com.visa.checkout.t;
import java.util.EnumSet;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(19)
public class CheckoutButton extends ViewGroup {
    private static String BTN_HTML = m6090(190, true, 6, 7, "\u0005\f￠\u0006\f￺\u0004").intern();

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f53 = 86;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f54 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f55;
    private String TAG = CheckoutButton.class.getSimpleName();
    private String buttonColor;
    private c cachedWebView;
    private CheckoutWithVisaListener checkoutWithVisaListener;
    private BroadcastReceiver closeSpinnerListener = new BroadcastReceiver() {

        /* renamed from: ˋ  reason: contains not printable characters */
        private static int f72 = 0;

        /* renamed from: ˎ  reason: contains not printable characters */
        private static int f73 = 1;

        /* renamed from: ॱ  reason: contains not printable characters */
        private static long f74 = 3222403416921098670L;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: ˏ  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String m6095(java.lang.String r10) {
            /*
                r0 = 0
                r1 = 1
                if (r10 == 0) goto L_0x0006
                r2 = r1
                goto L_0x0007
            L_0x0006:
                r2 = r0
            L_0x0007:
                if (r2 == r1) goto L_0x000a
                goto L_0x0018
            L_0x000a:
                int r2 = f72
                int r2 = r2 + 105
                int r3 = r2 % 128
                f73 = r3
                int r2 = r2 % 2
                char[] r10 = r10.toCharArray()
            L_0x0018:
                char[] r10 = (char[]) r10
                char r2 = r10[r0]
                int r3 = r10.length
                int r3 = r3 - r1
                char[] r3 = new char[r3]
                r4 = r1
            L_0x0021:
                int r5 = r10.length
                if (r4 >= r5) goto L_0x0026
                r5 = r0
                goto L_0x0027
            L_0x0026:
                r5 = r1
            L_0x0027:
                if (r5 == 0) goto L_0x002f
                java.lang.String r10 = new java.lang.String
                r10.<init>(r3)
                return r10
            L_0x002f:
                int r5 = f72
                int r5 = r5 + 95
                int r6 = r5 % 128
                f73 = r6
                int r5 = r5 % 2
                int r5 = r4 + -1
                char r6 = r10[r4]
                int r7 = r4 * r2
                r6 = r6 ^ r7
                long r6 = (long) r6
                long r8 = f74
                long r6 = r6 ^ r8
                int r6 = (int) r6
                char r6 = (char) r6
                r3[r5] = r6
                int r4 = r4 + 1
                goto L_0x0021
            */
            throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.CheckoutButton.AnonymousClass5.m6095(java.lang.String):java.lang.String");
        }

        public final void onReceive(Context context, Intent intent) {
            int i11 = f73 + 61;
            f72 = i11 % 128;
            int i12 = i11 % 2;
            Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra(m6095("긇虝ﺭ훙컎✎ὖ瞣濷").intern(), false));
            LocalBroadcastManager.getInstance(CheckoutButton.this.getContext()).unregisterReceiver(CheckoutButton.access$300(CheckoutButton.this));
            if (!valueOf.booleanValue()) {
                int i13 = f72 + 9;
                f73 = i13 % 128;
                int i14 = i13 % 2;
                return;
            }
            CheckoutButton.access$200(CheckoutButton.this).m6234();
            try {
                final VisaPaymentSummary visaPaymentSummary = new VisaPaymentSummary(new JSONObject(m6095("ᗷ尢扢࠿ḋ␍쨁큍谣鉸롒乃呈穉¹ᚪ㳧슓ﺌ蒎꫱냳䚤沝犚ᣑ⻏㔦?鵛ꍚ䤐彯敠").intern()));
                CheckoutButton.access$100(CheckoutButton.this).m6274().runOnUiThread(new Runnable() {
                    public final void run() {
                        CheckoutButton.access$100(CheckoutButton.this).m6275().onResult(visaPaymentSummary);
                        CheckoutButton checkoutButton = CheckoutButton.this;
                        CheckoutButton.access$400(checkoutButton, CheckoutButton.access$100(checkoutButton).m6274(), CheckoutButton.access$100(CheckoutButton.this));
                    }
                });
            } catch (JSONException unused) {
            }
        }
    };
    private q launchConfig;
    private VisaCheckoutSdk.VisaCheckoutResultListener.LaunchReadyHandler launchHandler = new VisaCheckoutSdk.VisaCheckoutResultListener.LaunchReadyHandler() {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static int[] f56 = {1959207194, -327568108, -1223639583, -1951698794, -938700570, 1735641542, -666186759, -9840521, 1292715981, 1903225375, -805633388, 190475874, 236126918, -1735436489, 1279181229, -1068227673, -1489012468, 1988392441};

        /* renamed from: ˎ  reason: contains not printable characters */
        private static int f57 = 0;

        /* renamed from: ॱ  reason: contains not printable characters */
        private static int f58 = 1;

        /* renamed from: ˎ  reason: contains not printable characters */
        private static String m6091(int[] iArr, int i11) {
            char c11;
            int i12 = f58 + 35;
            f57 = i12 % 128;
            int i13 = i12 % 2;
            char[] cArr = new char[4];
            char[] cArr2 = new char[(iArr.length << 1)];
            int[] iArr2 = (int[]) f56.clone();
            int i14 = 0;
            while (true) {
                if (i14 < iArr.length) {
                    c11 = 20;
                } else {
                    c11 = 'W';
                }
                if (c11 == 'W') {
                    return new String(cArr2, 0, i11);
                }
                int i15 = f58 + 97;
                f57 = i15 % 128;
                int i16 = i15 % 2;
                int i17 = iArr[i14];
                cArr[0] = (char) (i17 >> 16);
                cArr[1] = (char) i17;
                int i18 = iArr[i14 + 1];
                cArr[2] = (char) (i18 >> 16);
                cArr[3] = (char) i18;
                d.m9228(cArr, iArr2, false);
                int i19 = i14 << 1;
                cArr2[i19] = cArr[0];
                cArr2[i19 + 1] = cArr[1];
                cArr2[i19 + 2] = cArr[2];
                cArr2[i19 + 3] = cArr[3];
                i14 += 2;
                int i21 = f57 + 63;
                f58 = i21 % 128;
                int i22 = i21 % 2;
            }
        }

        public final void launch() {
            boolean z11;
            int i11 = f57 + 49;
            f58 = i11 % 128;
            int i12 = i11 % 2;
            if (CheckoutButton.access$000(CheckoutButton.this).m6121()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                CheckoutButton.this.observeLoadingScreenMessages();
                String obj = UUID.randomUUID().toString();
                Intent intent = new Intent(CheckoutButton.access$100(CheckoutButton.this).m6274(), l.class);
                intent.putExtra(m6091(new int[]{574345700, 962200644, 229946490, -699607627, -1079550381, 308228432, -1539313205, 295603943}, 15).intern(), obj);
                CheckoutButton.access$200(CheckoutButton.this).m6232(obj);
                CheckoutButton.access$100(CheckoutButton.this).m6274().startActivity(intent);
                return;
            }
            c access$000 = CheckoutButton.access$000(CheckoutButton.this);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
            long j11 = uptimeMillis + 100;
            MotionEvent obtain2 = MotionEvent.obtain(j11, j11, 1, 0.0f, 0.0f, 0);
            access$000.dispatchTouchEvent(obtain);
            access$000.dispatchTouchEvent(obtain2);
            int i13 = f58 + 113;
            f57 = i13 % 128;
            int i14 = i13 % 2;
        }
    };
    private C0097r mBridge;
    private t mStorage;
    private c webView;

    @Deprecated
    public interface CheckoutWithVisaListener {
        void onClick();
    }

    static {
        int i11 = f55 + 81;
        f54 = i11 % 128;
        int i12 = i11 % 2;
    }

    public CheckoutButton(Context context) {
        super(context);
        init();
    }

    public static /* synthetic */ c access$000(CheckoutButton checkoutButton) {
        int i11 = f55 + 109;
        int i12 = i11 % 128;
        f54 = i12;
        int i13 = i11 % 2;
        c cVar = checkoutButton.webView;
        int i14 = i12 + 57;
        f55 = i14 % 128;
        if ((i14 % 2 != 0 ? 'c' : 'b') != 'c') {
            return cVar;
        }
        int i15 = 74 / 0;
        return cVar;
    }

    public static /* synthetic */ q access$100(CheckoutButton checkoutButton) {
        int i11 = f55 + 101;
        int i12 = i11 % 128;
        f54 = i12;
        char c11 = i11 % 2 == 0 ? '-' : 'a';
        q qVar = checkoutButton.launchConfig;
        if (c11 == '-') {
            int i13 = 56 / 0;
        }
        int i14 = i12 + 77;
        f55 = i14 % 128;
        int i15 = i14 % 2;
        return qVar;
    }

    public static /* synthetic */ C0097r access$200(CheckoutButton checkoutButton) {
        int i11 = f54 + 63;
        int i12 = i11 % 128;
        f55 = i12;
        char c11 = i11 % 2 != 0 ? 'b' : 'V';
        C0097r rVar = checkoutButton.mBridge;
        if (c11 == 'V') {
            int i13 = i12 + 81;
            f54 = i13 % 128;
            if (i13 % 2 == 0) {
                int i14 = 72 / 0;
            }
            return rVar;
        }
        throw null;
    }

    public static /* synthetic */ BroadcastReceiver access$300(CheckoutButton checkoutButton) {
        int i11 = f54;
        int i12 = i11 + 33;
        f55 = i12 % 128;
        int i13 = i12 % 2;
        BroadcastReceiver broadcastReceiver = checkoutButton.closeSpinnerListener;
        int i14 = i11 + 5;
        f55 = i14 % 128;
        int i15 = i14 % 2;
        return broadcastReceiver;
    }

    public static /* synthetic */ void access$400(CheckoutButton checkoutButton, Activity activity, q qVar) {
        int i11 = f55 + 43;
        f54 = i11 % 128;
        int i12 = i11 % 2;
        checkoutButton.reloadButton(activity, qVar);
        int i13 = f55 + 17;
        f54 = i13 % 128;
        int i14 = i13 % 2;
    }

    public static /* synthetic */ void access$500(CheckoutButton checkoutButton, String str, Activity activity) {
        int i11 = f55 + 49;
        f54 = i11 % 128;
        int i12 = i11 % 2;
        checkoutButton.loadButtonFromCache(str, activity);
        int i13 = f55 + 93;
        f54 = i13 % 128;
        if (i13 % 2 == 0) {
            int i14 = 50 / 0;
        }
    }

    public static /* synthetic */ String access$600(CheckoutButton checkoutButton) {
        int i11 = f55 + 25;
        int i12 = i11 % 128;
        f54 = i12;
        char c11 = i11 % 2 == 0 ? '4' : 'A';
        String str = checkoutButton.TAG;
        if (c11 != '4') {
            int i13 = i12 + 39;
            f55 = i13 % 128;
            int i14 = i13 % 2;
            return str;
        }
        throw null;
    }

    public static /* synthetic */ c access$700(CheckoutButton checkoutButton) {
        int i11 = f54 + 3;
        f55 = i11 % 128;
        char c11 = i11 % 2 != 0 ? 'I' : 20;
        c cVar = checkoutButton.cachedWebView;
        if (c11 != 'I') {
            return cVar;
        }
        throw null;
    }

    public static /* synthetic */ c access$702(CheckoutButton checkoutButton, c cVar) {
        int i11 = f55;
        int i12 = i11 + 25;
        f54 = i12 % 128;
        boolean z11 = i12 % 2 != 0;
        checkoutButton.cachedWebView = cVar;
        if (!z11) {
            int i13 = 13 / 0;
        }
        int i14 = i11 + 97;
        f54 = i14 % 128;
        int i15 = i14 % 2;
        return cVar;
    }

    public static /* synthetic */ String access$800(CheckoutButton checkoutButton, String str) {
        int i11 = f55 + 111;
        f54 = i11 % 128;
        int i12 = i11 % 2;
        String formatHTMLContent = checkoutButton.formatHTMLContent(str);
        int i13 = f55 + 119;
        f54 = i13 % 128;
        int i14 = i13 % 2;
        return formatHTMLContent;
    }

    public static /* synthetic */ void access$900(CheckoutButton checkoutButton, String str) {
        int i11 = f55 + 33;
        f54 = i11 % 128;
        int i12 = i11 % 2;
        checkoutButton.saveHtmlCache(str);
        int i13 = f54 + 41;
        f55 = i13 % 128;
        if (i13 % 2 != 0) {
            int i14 = 16 / 0;
        }
    }

    private void buttonCleanup() {
        char c11;
        boolean z11;
        C0097r rVar = this.mBridge;
        if (rVar != null) {
            c11 = 9;
        } else {
            c11 = '(';
        }
        if (c11 != '(') {
            rVar.m6279();
            this.mBridge = null;
        }
        c cVar = this.webView;
        if (cVar != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            int i11 = f54 + 49;
            f55 = i11 % 128;
            int i12 = i11 % 2;
            removeView(cVar);
            this.webView.destroy();
            int i13 = f55 + 67;
            f54 = i13 % 128;
            int i14 = i13 % 2;
        }
        c cVar2 = this.cachedWebView;
        if (cVar2 != null) {
            removeView(cVar2);
            this.cachedWebView.destroy();
        }
    }

    private String formatHTMLContent(String str) {
        boolean z11;
        char c11;
        StringBuilder sb2 = new StringBuilder(str);
        int i11 = 0;
        while (true) {
            if (i11 < sb2.length() - 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                break;
            }
            if (sb2.charAt(i11) == '\\') {
                int i12 = i11 + 6;
                int i13 = i11 + 1;
                if (sb2.charAt(i13) == 'u') {
                    c11 = 'K';
                } else {
                    c11 = 'b';
                }
                if (c11 != 'b') {
                    int i14 = f55 + 37;
                    f54 = i14 % 128;
                    int i15 = i14 % 2;
                    int i16 = i13 + 1;
                    sb2.replace(i11, i12, String.valueOf((char) Integer.parseInt(sb2.substring(i16, i16 + 4), 16)));
                } else {
                    i11 = i13;
                }
            }
            i11++;
        }
        String obj = sb2.toString();
        String replaceAll = obj.substring(1, obj.length() - 1).replaceAll(m6090(Opcodes.INVOKESTATIC, false, 1, 3, "\f￺￺").intern(), "").replaceAll(m6090(Opcodes.INVOKEDYNAMIC, false, 3, 3, "￸￸\u0010").intern(), "").replaceAll(m6090(Opcodes.INVOKEINTERFACE, true, 3, 3, "\u000f￹￹").intern(), "").replaceAll(m6090(Opcodes.GETSTATIC, false, 1, 2, TarConstants.VERSION_ANT).intern(), "");
        int i17 = f55 + 35;
        f54 = i17 % 128;
        if (i17 % 2 != 0) {
            return replaceAll;
        }
        throw null;
    }

    private a getConfigReadyListener(final CheckoutButton checkoutButton) {
        AnonymousClass7 r02 = new a() {
            /* renamed from: ˋ  reason: contains not printable characters */
            public final void m6096() {
                ((Activity) checkoutButton.getContext()).runOnUiThread(new Runnable() {

                    /* renamed from: ˊ  reason: contains not printable characters */
                    private static long f80 = -8992842903086367023L;

                    /* renamed from: ˋ  reason: contains not printable characters */
                    private static int f81 = 1;

                    /* renamed from: ˎ  reason: contains not printable characters */
                    private static int f82;

                    /* renamed from: ˏ  reason: contains not printable characters */
                    private static char[] f83 = {'W', 65204, 64960, 64517, 64301, 64112, 63633, 63373, 63144, 62731, 62543, 62102, 61859, 61675, 61191, 61009, 60791, 60353, 60145, 59874, 59447, 59213, 58771, 58531, 58296, 57918, 57695, 57449, 57002, 56772, 56347, 56120, '(', 65207, 64983, 64541, 64295, 64097, 63631, 63448, 63206, 62833, 62467, 62171, 61879, 61629, 61212, 61018, 60772, 60308, 60096, 59885, 59508, 59149, 58833, 58619, 58352, 57885, 57687, 57447, 57058, 56714, 56405, 56107, 55887, 55442, 55223, 55038, 54529, 54363, 54130, 53753, 53455, 53020, 52798, 52574, 52096, 51928, 51683, 51258, 51038, 50805, 50337, 50145, 49677, 49425, 49271, 48768, 48630, 48360, 47927, 47694, 47316, 47082, 46838, 46363, 46125, 45949, 45509, 45210, 45023, 44645, 44411, 43993, 43681, 43511, 43012, 42846, 42622, 42133, 41978, 41522, 41244, 40970, 40661, 40447, 40123, 39693, 39490, 39274, 38836, 38551, 38237, 37986, 37671, 37325, 37059, 36774, 36424, 36120, 35897};

                    /* renamed from: ˏ  reason: contains not printable characters */
                    private static String m6097(char c11, int i11, int i12) {
                        boolean z11;
                        int i13 = f82 + 55;
                        f81 = i13 % 128;
                        int i14 = i13 % 2;
                        char[] cArr = new char[i11];
                        int i15 = 0;
                        while (true) {
                            if (i15 < i11) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                cArr[i15] = (char) ((int) ((((long) f83[i12 + i15]) ^ (((long) i15) * f80)) ^ ((long) c11)));
                                i15++;
                                int i16 = f82 + 65;
                                f81 = i16 % 128;
                                int i17 = i16 % 2;
                            } else {
                                String str = new String(cArr);
                                int i18 = f82 + 83;
                                f81 = i18 % 128;
                                int i19 = i18 % 2;
                                return str;
                            }
                        }
                    }

                    public final void run() {
                        boolean z11;
                        if (CheckoutButton.access$700(CheckoutButton.this) != null) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (!z11) {
                            CheckoutButton.access$600(CheckoutButton.this);
                            m6097(0, 32, 0).intern();
                            AnonymousClass7 r02 = AnonymousClass7.this;
                            checkoutButton.removeView(CheckoutButton.access$700(CheckoutButton.this));
                            int i11 = f82 + 9;
                            f81 = i11 % 128;
                            int i12 = i11 % 2;
                        }
                        CheckoutButton.access$000(CheckoutButton.this).evaluateJavascript(m6097(0, 99, 32).intern(), new ValueCallback<String>() {

                            /* renamed from: ʻ  reason: contains not printable characters */
                            private static int f85 = 0;

                            /* renamed from: ˋ  reason: contains not printable characters */
                            private static int f86 = -129025519;

                            /* renamed from: ˎ  reason: contains not printable characters */
                            private static int f87 = 75;

                            /* renamed from: ˏ  reason: contains not printable characters */
                            private static byte[] f88 = {-69, 108, 116, 99, 101, Ascii.DC2, -59, -50, -2, -43, -33, TarConstants.LF_SYMLINK, 35, -59, 40, -43, 4, 17, -4, -43, -41, 36};

                            /* renamed from: ॱ  reason: contains not printable characters */
                            private static int f89 = 589297105;

                            /* renamed from: ॱॱ  reason: contains not printable characters */
                            private static int f90 = 1;

                            /* renamed from: ॱ  reason: contains not printable characters */
                            private static String m6098(int i11, int i12, short s11, int i13, byte b11) {
                                boolean z11;
                                int i14;
                                boolean z12;
                                boolean z13;
                                StringBuilder sb2 = new StringBuilder();
                                int i15 = f87;
                                int i16 = i12 + i15;
                                if (i16 == -1) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z11) {
                                    byte[] bArr = f88;
                                    if (bArr != null) {
                                        int i17 = f85 + 25;
                                        f90 = i17 % 128;
                                        int i18 = i17 % 2;
                                        i16 = (byte) (bArr[f89 + i13] + i15);
                                    } else {
                                        throw null;
                                    }
                                }
                                if (i16 > 0) {
                                    int i19 = ((i13 + i16) - 2) + f89;
                                    if (z11) {
                                        int i21 = f90 + 89;
                                        f85 = i21 % 128;
                                        int i22 = i21 % 2;
                                        i14 = 1;
                                    } else {
                                        int i23 = f90 + 95;
                                        f85 = i23 % 128;
                                        int i24 = i23 % 2;
                                        i14 = 0;
                                    }
                                    int i25 = i19 + i14;
                                    char c11 = (char) (i11 + f86);
                                    sb2.append(c11);
                                    int i26 = 1;
                                    while (true) {
                                        if (i26 < i16) {
                                            z12 = false;
                                        } else {
                                            z12 = true;
                                        }
                                        if (z12) {
                                            break;
                                        }
                                        int i27 = f90 + 75;
                                        f85 = i27 % 128;
                                        if (i27 % 2 != 0) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        if (!z13) {
                                            byte[] bArr2 = f88;
                                            if (bArr2 != null) {
                                                c11 = (char) (c11 + (((byte) (bArr2[i25] + s11)) ^ b11));
                                                sb2.append(c11);
                                                i26++;
                                                i25--;
                                            } else {
                                                throw null;
                                            }
                                        } else {
                                            throw null;
                                        }
                                    }
                                }
                                return sb2.toString();
                            }

                            public final /* synthetic */ void onReceiveValue(Object obj) {
                                boolean z11;
                                int i11 = f90 + 31;
                                f85 = i11 % 128;
                                int i12 = i11 % 2;
                                CheckoutButton.access$600(CheckoutButton.this);
                                m6098(129025591, -76, -57, -589297105, (byte) -43).intern();
                                String access$800 = CheckoutButton.access$800(CheckoutButton.this, (String) obj);
                                CheckoutButton.access$600(CheckoutButton.this);
                                m6098(129025591, -76, -3, -589297099, (byte) 45).intern();
                                CheckoutButton.access$900(CheckoutButton.this, access$800);
                                int i13 = f85 + 111;
                                f90 = i13 % 128;
                                if (i13 % 2 == 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z11) {
                                    throw null;
                                }
                            }
                        });
                        int i13 = f82 + 23;
                        f81 = i13 % 128;
                        int i14 = i13 % 2;
                    }
                });
            }
        };
        int i11 = f55 + 33;
        f54 = i11 % 128;
        int i12 = i11 % 2;
        return r02;
    }

    private g getLaunchReadyListener() {
        AnonymousClass10 r02 = new g() {
            /* renamed from: ॱ  reason: contains not printable characters */
            public final void m6092() {
                CheckoutButton.access$000(CheckoutButton.this).m6120(true);
            }
        };
        int i11 = f55 + 83;
        f54 = i11 % 128;
        if (!(i11 % 2 == 0)) {
            return r02;
        }
        throw null;
    }

    private void init() {
        int i11 = f54 + 45;
        f55 = i11 % 128;
        if (i11 % 2 == 0) {
            setBackgroundColor(getResources().getColor(R.color.transparent));
        } else {
            setBackgroundColor(getResources().getColor(R.color.transparent));
            throw null;
        }
    }

    private void loadButtonFromCache(final String str, final Activity activity) {
        activity.runOnUiThread(new Runnable() {

            /* renamed from: ʼ  reason: contains not printable characters */
            private static int f92 = 0;

            /* renamed from: ˊ  reason: contains not printable characters */
            private static char f93 = 6;

            /* renamed from: ॱ  reason: contains not printable characters */
            private static char[] f94 = {Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'e', 'x', '/', 'h', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'l', 'U', 'T', 'F', SignatureVisitor.SUPER, '8', 'C', 'a', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, ' ', 'H', 'M', 'L', AbstractJsonLexerKt.COLON, 'W', 'b', 'v', 'i', 'w', 'o', 'n', 'g', 'f', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, AbstractJsonLexerKt.UNICODE_ESC, 'y', 'z', AbstractJsonLexerKt.BEGIN_OBJ, '|'};

            /* renamed from: ᐝ  reason: contains not printable characters */
            private static int f95 = 1;

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: char[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.String} */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: ˊ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String m6099(java.lang.String r11, int r12, byte r13) {
                /*
                    if (r11 == 0) goto L_0x0010
                    int r0 = f92
                    int r0 = r0 + 83
                    int r1 = r0 % 128
                    f95 = r1
                    int r0 = r0 % 2
                    char[] r11 = r11.toCharArray()
                L_0x0010:
                    char[] r11 = (char[]) r11
                    char[] r0 = f94
                    char r1 = f93
                    char[] r2 = new char[r12]
                    int r3 = r12 % 2
                    if (r3 == 0) goto L_0x0024
                    int r12 = r12 + -1
                    char r3 = r11[r12]
                    int r3 = r3 - r13
                    char r3 = (char) r3
                    r2[r12] = r3
                L_0x0024:
                    r3 = 0
                    r4 = 1
                    if (r12 <= r4) goto L_0x002a
                    r5 = r4
                    goto L_0x002b
                L_0x002a:
                    r5 = r3
                L_0x002b:
                    if (r5 == r4) goto L_0x002e
                    goto L_0x0038
                L_0x002e:
                    r4 = 57
                    if (r3 >= r12) goto L_0x0034
                    r5 = r4
                    goto L_0x0036
                L_0x0034:
                    r5 = 14
                L_0x0036:
                    if (r5 == r4) goto L_0x003e
                L_0x0038:
                    java.lang.String r11 = new java.lang.String
                    r11.<init>(r2)
                    return r11
                L_0x003e:
                    char r4 = r11[r3]
                    int r5 = r3 + 1
                    char r6 = r11[r5]
                    r7 = 65
                    if (r4 != r6) goto L_0x004a
                    r8 = r7
                    goto L_0x004b
                L_0x004a:
                    r8 = 7
                L_0x004b:
                    if (r8 == r7) goto L_0x00b7
                    int r8 = com.c.c.h.m9232(r4, r1)
                    int r4 = com.c.c.h.m9235(r4, r1)
                    int r9 = com.c.c.h.m9232(r6, r1)
                    int r6 = com.c.c.h.m9235(r6, r1)
                    if (r4 != r6) goto L_0x0078
                    int r7 = com.c.c.h.m9233(r8, r1)
                    int r8 = com.c.c.h.m9233(r9, r1)
                    int r4 = com.c.c.h.m9234(r7, r4, r1)
                    int r6 = com.c.c.h.m9234(r8, r6, r1)
                    char r4 = r0[r4]
                    r2[r3] = r4
                    char r4 = r0[r6]
                    r2[r5] = r4
                    goto L_0x00bf
                L_0x0078:
                    if (r8 != r9) goto L_0x009c
                    int r10 = f95
                    int r10 = r10 + r7
                    int r7 = r10 % 128
                    f92 = r7
                    int r10 = r10 % 2
                    int r4 = com.c.c.h.m9233(r4, r1)
                    int r6 = com.c.c.h.m9233(r6, r1)
                    int r4 = com.c.c.h.m9234(r8, r4, r1)
                    int r6 = com.c.c.h.m9234(r9, r6, r1)
                    char r4 = r0[r4]
                    r2[r3] = r4
                    char r4 = r0[r6]
                    r2[r5] = r4
                    goto L_0x00bf
                L_0x009c:
                    int r6 = com.c.c.h.m9234(r8, r6, r1)
                    int r4 = com.c.c.h.m9234(r9, r4, r1)
                    char r6 = r0[r6]
                    r2[r3] = r6
                    char r4 = r0[r4]
                    r2[r5] = r4
                    int r4 = f92
                    int r4 = r4 + 109
                    int r5 = r4 % 128
                    f95 = r5
                    int r4 = r4 % 2
                    goto L_0x00bf
                L_0x00b7:
                    int r4 = r4 - r13
                    char r4 = (char) r4
                    r2[r3] = r4
                    int r6 = r6 - r13
                    char r4 = (char) r6
                    r2[r5] = r4
                L_0x00bf:
                    int r3 = r3 + 2
                    goto L_0x002e
                */
                throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.CheckoutButton.AnonymousClass9.m6099(java.lang.String, int, byte):java.lang.String");
            }

            public final void run() {
                CheckoutButton.access$702(CheckoutButton.this, new c(activity));
                CheckoutButton.access$700(CheckoutButton.this).loadData(str, m6099("\u0001\u0002\u0003\u0001\u0004\u0005\u0001\u0000|", 9, Ascii.DLE).intern(), m6099("\b\t\n\u000b¦", 5, (byte) 110).intern());
                CheckoutButton.access$600(CheckoutButton.this);
                m6099("\r\u000e\u0010\u0002\u0003\r\u0011\f\u0006\u0014\u0014\u0015F", 13, (byte) 38).intern();
                CheckoutButton.access$600(CheckoutButton.this);
                m6099("\u0013\u0003\u0017\u0012\u0019\u0000\u001a\u0013\r\u0016\u0019\u000e\f\u001b\u001c\u001d\u0011\u001c \u0018\u0004\u0011\u000f\u000e\u0010\u0002\u0003\r\u0016\n\u0001\u0000Ä", 33, TarConstants.LF_PAX_EXTENDED_HEADER_UC).intern();
                CheckoutButton checkoutButton = CheckoutButton.this;
                checkoutButton.addView(CheckoutButton.access$700(checkoutButton));
                int i11 = f95 + 15;
                f92 = i11 % 128;
                int i12 = i11 % 2;
            }
        });
        int i11 = f55 + 125;
        f54 = i11 % 128;
        int i12 = i11 % 2;
    }

    private void reloadButton(Activity activity, q qVar) {
        boolean z11;
        int i11 = f55 + 101;
        f54 = i11 % 128;
        if (i11 % 2 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            c cVar = this.webView;
            if (cVar != null) {
                removeView(cVar);
                this.webView = null;
            }
            C0097r rVar = this.mBridge;
            if (rVar != null) {
                int i12 = f54 + 23;
                f55 = i12 % 128;
                if (i12 % 2 != 0) {
                    rVar.m6279();
                    this.mBridge = null;
                    int i13 = 48 / 0;
                } else {
                    rVar.m6279();
                    this.mBridge = null;
                }
            }
            this.webView = new c(activity);
            this.mBridge = new C0097r(this.webView, qVar);
            if (qVar != null) {
                this.webView.loadUrl(b.m6119(getContext(), qVar.m6273().getEnvironment(), this.buttonColor));
                this.mBridge.m6233(getConfigReadyListener(this));
                addView(this.webView);
                this.mBridge.m6230(getLaunchReadyListener());
                setClickable(true);
                this.webView.setWebChromeClient(new WebChromeClient() {

                    /* renamed from: ʻ  reason: contains not printable characters */
                    private static int f61 = 1;

                    /* renamed from: ʽ  reason: contains not printable characters */
                    private static int f62 = 0;

                    /* renamed from: ˊ  reason: contains not printable characters */
                    private static char f63 = '꥓';

                    /* renamed from: ˋ  reason: contains not printable characters */
                    private static char f64 = '';

                    /* renamed from: ˎ  reason: contains not printable characters */
                    private static char f65 = '?';

                    /* renamed from: ˏ  reason: contains not printable characters */
                    private static char f66 = '㋐';

                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: char[]} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
                    /* JADX WARNING: Failed to insert additional move for type inference */
                    /* JADX WARNING: Multi-variable type inference failed */
                    /* renamed from: ˊ  reason: contains not printable characters */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private static java.lang.String m6093(java.lang.String r10) {
                        /*
                            int r0 = f61
                            int r1 = r0 + 101
                            int r2 = r1 % 128
                            f62 = r2
                            r2 = 2
                            int r1 = r1 % r2
                            r1 = 1
                            r3 = 0
                            if (r10 == 0) goto L_0x0010
                            r4 = r1
                            goto L_0x0011
                        L_0x0010:
                            r4 = r3
                        L_0x0011:
                            if (r4 == 0) goto L_0x002f
                            int r0 = r0 + 57
                            int r4 = r0 % 128
                            f62 = r4
                            int r0 = r0 % r2
                            if (r0 != 0) goto L_0x002a
                            char[] r10 = r10.toCharArray()
                            int r0 = f61
                            int r0 = r0 + 35
                            int r4 = r0 % 128
                            f62 = r4
                            int r0 = r0 % r2
                            goto L_0x002f
                        L_0x002a:
                            r10.toCharArray()
                            r10 = 0
                            throw r10
                        L_0x002f:
                            char[] r10 = (char[]) r10
                            int r0 = r10.length
                            char[] r0 = new char[r0]
                            char[] r4 = new char[r2]
                            int r5 = f62
                            int r5 = r5 + 49
                            int r6 = r5 % 128
                            f61 = r6
                            int r5 = r5 % r2
                            r2 = r3
                        L_0x0040:
                            int r5 = r10.length
                            if (r2 >= r5) goto L_0x0045
                            r5 = r3
                            goto L_0x0046
                        L_0x0045:
                            r5 = r1
                        L_0x0046:
                            if (r5 == 0) goto L_0x0050
                            char r10 = r0[r3]
                            java.lang.String r2 = new java.lang.String
                            r2.<init>(r0, r1, r10)
                            return r2
                        L_0x0050:
                            char r5 = r10[r2]
                            r4[r3] = r5
                            int r5 = r2 + 1
                            char r6 = r10[r5]
                            r4[r1] = r6
                            char r6 = f63
                            char r7 = f64
                            char r8 = f66
                            char r9 = f65
                            com.c.c.g.m9231(r4, r6, r7, r8, r9)
                            char r6 = r4[r3]
                            r0[r2] = r6
                            char r6 = r4[r1]
                            r0[r5] = r6
                            int r2 = r2 + 2
                            goto L_0x0040
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.CheckoutButton.AnonymousClass2.m6093(java.lang.String):java.lang.String");
                    }

                    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                        char c11;
                        int i11 = f62 + 81;
                        f61 = i11 % 128;
                        int i12 = i11 % 2;
                        CheckoutButton.access$600(CheckoutButton.this);
                        m6093("亶泱Ⱊ⛶륏曪㳕鍒Ꮇ撊").intern();
                        consoleMessage.message();
                        m6093("숦컎勞ꦱᢅ欶").intern();
                        consoleMessage.sourceId();
                        m6093("୙?").intern();
                        consoleMessage.lineNumber();
                        int i13 = f61 + 113;
                        f62 = i13 % 128;
                        if (i13 % 2 != 0) {
                            c11 = '+';
                        } else {
                            c11 = 'G';
                        }
                        if (c11 != '+') {
                            return true;
                        }
                        throw null;
                    }
                });
                int i14 = f54 + 73;
                f55 = i14 % 128;
                int i15 = i14 % 2;
                return;
            }
            return;
        }
        throw null;
    }

    private void saveHtmlCache(String str) {
        int i11 = f55 + 107;
        f54 = i11 % 128;
        int i12 = i11 % 2;
        try {
            this.mStorage.m6301(BTN_HTML, str, EnumSet.noneOf(x.class), "");
            int i13 = f55 + 59;
            f54 = i13 % 128;
            int i14 = i13 % 2;
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6090(int r5, boolean r6, int r7, int r8, java.lang.String r9) {
        /*
            if (r9 == 0) goto L_0x0006
            char[] r9 = r9.toCharArray()
        L_0x0006:
            char[] r9 = (char[]) r9
            char[] r0 = new char[r8]
            r1 = 0
            r2 = r1
        L_0x000c:
            r3 = 90
            if (r2 >= r8) goto L_0x0013
            r4 = 85
            goto L_0x0014
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r4 == r3) goto L_0x0041
            int r3 = f55
            int r3 = r3 + 91
            int r4 = r3 % 128
            f54 = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x0032
            char r3 = r9[r2]
            int r3 = r5 % r3
            char r3 = (char) r3
            r0[r2] = r3
            int r4 = f53
            int r3 = r3 + r4
            char r3 = (char) r3
            r0[r2] = r3
            int r2 = r2 + 13
            goto L_0x000c
        L_0x0032:
            char r3 = r9[r2]
            int r3 = r3 + r5
            char r3 = (char) r3
            r0[r2] = r3
            int r4 = f53
            int r3 = r3 - r4
            char r3 = (char) r3
            r0[r2] = r3
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0041:
            if (r7 <= 0) goto L_0x005a
            int r5 = f54
            int r5 = r5 + 119
            int r9 = r5 % 128
            f55 = r9
            int r5 = r5 % 2
            char[] r5 = new char[r8]
            java.lang.System.arraycopy(r0, r1, r5, r1, r8)
            int r9 = r8 - r7
            java.lang.System.arraycopy(r5, r1, r0, r9, r7)
            java.lang.System.arraycopy(r5, r7, r0, r1, r9)
        L_0x005a:
            r5 = 96
            if (r6 == 0) goto L_0x0060
            r6 = r5
            goto L_0x0062
        L_0x0060:
            r6 = 63
        L_0x0062:
            if (r6 == r5) goto L_0x0065
            goto L_0x0093
        L_0x0065:
            int r5 = f54
            int r5 = r5 + 11
            int r6 = r5 % 128
            f55 = r6
            int r5 = r5 % 2
            r6 = 60
            if (r5 == 0) goto L_0x0076
            r5 = 62
            goto L_0x0077
        L_0x0076:
            r5 = r6
        L_0x0077:
            r7 = 1
            if (r5 == r6) goto L_0x007e
            char[] r5 = new char[r8]
            r6 = r7
            goto L_0x0081
        L_0x007e:
            char[] r5 = new char[r8]
            r6 = r1
        L_0x0081:
            if (r6 >= r8) goto L_0x0085
            r9 = r1
            goto L_0x0086
        L_0x0085:
            r9 = r7
        L_0x0086:
            if (r9 == r7) goto L_0x0092
            int r9 = r8 - r6
            int r9 = r9 - r7
            char r9 = r0[r9]
            r5[r6] = r9
            int r6 = r6 + 1
            goto L_0x0081
        L_0x0092:
            r0 = r5
        L_0x0093:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.CheckoutButton.m6090(int, boolean, int, int, java.lang.String):java.lang.String");
    }

    public void observeLoadingScreenMessages() {
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.closeSpinnerListener, new IntentFilter(m6090(189, true, 5, 25, "\u0002�￺\b\u0005\u000b￾\r\u0005\u0002￟￾\f\b\u0005ￜ\u000b￾\u0007\u0007\u0002\t￬\u0000\u0007").intern()));
        int i11 = f55 + 75;
        f54 = i11 % 128;
        int i12 = i11 % 2;
    }

    public void onDetachedFromWindow() {
        boolean z11;
        int i11 = f54 + 123;
        f55 = i11 % 128;
        if (i11 % 2 != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            super.onDetachedFromWindow();
            buttonCleanup();
            int i12 = 3 / 0;
            return;
        }
        super.onDetachedFromWindow();
        buttonCleanup();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i11 = f55;
        int i12 = i11 + 87;
        f54 = i12 % 128;
        int i13 = i12 % 2;
        int i14 = i11 + 27;
        f54 = i14 % 128;
        int i15 = i14 % 2;
        return true;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        char c11;
        char c12;
        c cVar = this.webView;
        if (cVar != null) {
            c11 = 25;
        } else {
            c11 = 'P';
        }
        if (c11 == 25) {
            int i15 = f54 + 65;
            f55 = i15 % 128;
            if (i15 % 2 != 0) {
                cVar.layout(1, 0, i13 & i11, i14 | i12);
            } else {
                cVar.layout(0, 0, i13 - i11, i14 - i12);
            }
        }
        c cVar2 = this.cachedWebView;
        if (cVar2 != null) {
            c12 = 'J';
        } else {
            c12 = 'B';
        }
        if (c12 != 'B') {
            int i16 = f55 + 13;
            f54 = i16 % 128;
            if (i16 % 2 == 0) {
                cVar2.layout(1, 1, i13 >> i11, i12 | i14);
            } else {
                cVar2.layout(0, 0, i13 - i11, i14 - i12);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r4.checkoutWithVisaListener != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r0 != true) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performClick() {
        /*
            r4 = this;
            int r0 = f54
            int r0 = r0 + 95
            int r1 = r0 % 128
            f55 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 == 0) goto L_0x0030
            super.performClick()
            com.visa.checkout.q r0 = r4.launchConfig
            com.visa.checkout.VisaCheckoutSdk$VisaCheckoutBaseListener r0 = r0.m6275()
            com.visa.checkout.VisaCheckoutSdk$VisaCheckoutResultListener r0 = (com.visa.checkout.VisaCheckoutSdk.VisaCheckoutResultListener) r0
            com.visa.checkout.VisaCheckoutSdk$VisaCheckoutResultListener$LaunchReadyHandler r3 = r4.launchHandler
            r0.onButtonClick(r3)
            com.visa.checkout.CheckoutButton$CheckoutWithVisaListener r0 = r4.checkoutWithVisaListener
            r3 = 43
            int r3 = r3 / r2
            if (r0 == 0) goto L_0x002c
            r0 = r2
            goto L_0x002d
        L_0x002c:
            r0 = r1
        L_0x002d:
            if (r0 == r1) goto L_0x0063
            goto L_0x0044
        L_0x0030:
            super.performClick()
            com.visa.checkout.q r0 = r4.launchConfig
            com.visa.checkout.VisaCheckoutSdk$VisaCheckoutBaseListener r0 = r0.m6275()
            com.visa.checkout.VisaCheckoutSdk$VisaCheckoutResultListener r0 = (com.visa.checkout.VisaCheckoutSdk.VisaCheckoutResultListener) r0
            com.visa.checkout.VisaCheckoutSdk$VisaCheckoutResultListener$LaunchReadyHandler r3 = r4.launchHandler
            r0.onButtonClick(r3)
            com.visa.checkout.CheckoutButton$CheckoutWithVisaListener r0 = r4.checkoutWithVisaListener
            if (r0 == 0) goto L_0x0063
        L_0x0044:
            int r0 = f55
            int r0 = r0 + 77
            int r3 = r0 % 128
            f54 = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0052
            r0 = r2
            goto L_0x0053
        L_0x0052:
            r0 = r1
        L_0x0053:
            if (r0 == 0) goto L_0x005b
            com.visa.checkout.CheckoutButton$CheckoutWithVisaListener r0 = r4.checkoutWithVisaListener
            r0.onClick()
            goto L_0x0063
        L_0x005b:
            com.visa.checkout.CheckoutButton$CheckoutWithVisaListener r0 = r4.checkoutWithVisaListener
            r0.onClick()
            r0 = 33
            int r0 = r0 / r2
        L_0x0063:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.CheckoutButton.performClick():boolean");
    }

    @Deprecated
    public void setAnimation(boolean z11) {
        int i11 = f55 + 25;
        f54 = i11 % 128;
        if ((i11 % 2 == 0 ? (char) 20 : 30) != 30) {
            throw null;
        }
    }

    @Deprecated
    public void setButtonHeight(int i11) {
        char c11;
        int i12 = f55 + 37;
        f54 = i12 % 128;
        int i13 = i12 % 2;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = u.m6309(i11, getResources().getDisplayMetrics());
        setLayoutParams(layoutParams);
        int i14 = f55 + 107;
        f54 = i14 % 128;
        if (i14 % 2 == 0) {
            c11 = '8';
        } else {
            c11 = ' ';
        }
        if (c11 != ' ') {
            throw null;
        }
    }

    @Deprecated
    public void setButtonWidth(int i11) {
        boolean z11;
        int i12 = f54 + 87;
        f55 = i12 % 128;
        int i13 = i12 % 2;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = u.m6309(i11, getResources().getDisplayMetrics());
        setLayoutParams(layoutParams);
        int i14 = f55 + 87;
        f54 = i14 % 128;
        if (i14 % 2 == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw null;
        }
    }

    @Deprecated
    public void setCheckoutListener(CheckoutWithVisaListener checkoutWithVisaListener2) {
        char c11;
        int i11 = f54 + 125;
        f55 = i11 % 128;
        if (i11 % 2 != 0) {
            c11 = '\\';
        } else {
            c11 = 19;
        }
        if (c11 == '\\' && Build.VERSION.SDK_INT < 61) {
            int i12 = f54 + 115;
            f55 = i12 % 128;
            int i13 = i12 % 2;
            return;
        }
        this.checkoutWithVisaListener = checkoutWithVisaListener2;
    }

    @Deprecated
    public void setColorStyle(String str) {
        int i11 = f55 + 75;
        f54 = i11 % 128;
        if (i11 % 2 == 0) {
            int i12 = 63 / 0;
        }
    }

    public void init(final Activity activity, Profile profile, PurchaseInfo purchaseInfo, VisaCheckoutSdk.VisaCheckoutResultListener visaCheckoutResultListener) {
        int i11 = f54 + 103;
        f55 = i11 % 128;
        if (!(i11 % 2 == 0)) {
            if ((Build.VERSION.SDK_INT < 72 ? 22 : '7') != '7') {
                m6090(Opcodes.INVOKEDYNAMIC, true, 17, 17, "\u0010\u0011\u000b\u0007￿\u0001\u0004￿ￊ�\u000f\u0005\u0012ￊ\t\u000b￿").intern();
                m6090(Opcodes.RETURN, true, 30, 78, "ￖￅ\u0011\n\u001b\n\u0011ￅ￮￵￦ￅ\u0013\u0014ￅ\f\u0013\u000e\u0013\u0013\u001a\u0017ￅ\u0018\n\b\u000e\u001b\n￩ￓ\u001e\u0019\u000e\u0011\u0006\u0013\u0014\u000e\u0019\b\u0013\u001a\u000bￅ\u0019\u001a\u0014\u0010\b\n\r￨ￅ\u0006\u0018\u000e￻ￅ\n\u0018\u001aￅ\u0013\u0006\bￅ\n\u001b\u0014\u0007\u0006ￅ\t\u0013\u0006ￅ￞").intern();
                return;
            }
        }
        this.launchConfig = new q(activity, profile, purchaseInfo, visaCheckoutResultListener);
        try {
            t tVar = new t(getContext(), m6090(Opcodes.PUTFIELD, false, 15, 25, "\t\u0006\u0004\f\u0010\u0016\u0015ￏ\u0003\u0015\u000f￩￵￮￭\u0004\u0010\u000eￏ\u0017\n\u0014\u0002ￏ\u0004").intern());
            this.mStorage = tVar;
            tVar.m6299(BTN_HTML, new t.c() {
                /* renamed from: ˎ  reason: contains not printable characters */
                public final void m6094(Object obj) {
                    if (obj != null) {
                        CheckoutButton.access$500(CheckoutButton.this, obj.toString(), activity);
                    }
                }
            });
            int i12 = f54 + 39;
            f55 = i12 % 128;
            int i13 = i12 % 2;
        } catch (Exception unused) {
        }
        activity.runOnUiThread(new Runnable() {
            public final void run() {
                CheckoutButton checkoutButton = CheckoutButton.this;
                CheckoutButton.access$400(checkoutButton, activity, CheckoutButton.access$100(checkoutButton));
            }
        });
    }

    public CheckoutButton(Context context, String str) {
        super(context);
        this.buttonColor = str;
        init();
    }

    /* JADX INFO: finally extract failed */
    public CheckoutButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.VisaCheckoutButton, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(R.styleable.VisaCheckoutButton_buttonColor);
            if (string != null) {
                this.buttonColor = string;
            }
            obtainStyledAttributes.recycle();
            init();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
