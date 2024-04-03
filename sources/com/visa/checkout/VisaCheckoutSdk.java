package com.visa.checkout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.visa.checkout.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class VisaCheckoutSdk {
    private static List<String> alreadyLaunchedIds = new ArrayList();
    private static CustomButtonUpdatedListener customButtonUpdatedListener = null;
    private static WeakReference<Activity> sActivity = null;
    private static String sCampaignData = null;
    private static Set<e> sManualBridges = new HashSet();
    private static v.b taskHandler = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    private static int f125 = 1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean f126 = true;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean f127 = true;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f128;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static char[] f129 = {172, 184, Typography.paragraph, 'w', 191, 178, 188, 170, Typography.plusMinus, Typography.registered, 180, 190, Typography.half, 141, 'i', 187, Typography.middleDot, Typography.degree, 138, 153, 146, 181, 'z', 130, 173, 171, 159, 140, 175, 194, 185};

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f130 = 73;

    public interface CustomButtonUpdatedListener {
        void onUpdate();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
        public static final int RESULT_CLOSED_CALLED = 6;
        public static final int RESULT_FAIL_TO_LAUNCH = 3;
        public static final int RESULT_INITIALIZED_FAILED = 5;
        public static final int RESULT_INTERNAL_ERROR = 4;
        public static final int RESULT_MISSING_PARAMETER = 2;
        public static final int RESULT_SDK_NOT_INITIALIZED = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int FAIL_TO_INITIALIZE = 4;
        public static final int INTERNAL_ERROR = 6;
        public static final int INVALID_API_KEY = 1;
        public static final int MISSING_PARAMETER = 5;
        public static final int OS_VERSION_NOT_SUPPORTED = 3;
        public static final int SDK_PAUSED = 7;
        public static final int SDK_RESUMED = 8;
        public static final int SUCCESS = 0;
        public static final int UNSUPPORTED_SDK_VERSION = 2;
    }

    public interface VisaCheckoutBaseListener {
        void onResult(VisaPaymentSummary visaPaymentSummary);
    }

    public interface VisaCheckoutResultListener extends VisaCheckoutBaseListener {

        public interface LaunchReadyHandler {
            void launch();
        }

        void onButtonClick(LaunchReadyHandler launchReadyHandler);
    }

    static {
        int i11 = f128 + 45;
        f125 = i11 % 128;
        int i12 = i11 % 2;
    }

    private VisaCheckoutSdk() {
        throw new AssertionError();
    }

    public static /* synthetic */ Set access$000() {
        int i11 = f128;
        int i12 = i11 + 15;
        f125 = i12 % 128;
        int i13 = i12 % 2;
        Set<e> set = sManualBridges;
        int i14 = i11 + 19;
        f125 = i14 % 128;
        if ((i14 % 2 == 0 ? 20 : '>') != '>') {
            int i15 = 95 / 0;
        }
        return set;
    }

    public static /* synthetic */ CustomButtonUpdatedListener access$100() {
        int i11 = f128 + 55;
        f125 = i11 % 128;
        if (!(i11 % 2 == 0)) {
            return customButtonUpdatedListener;
        }
        int i12 = 90 / 0;
        return customButtonUpdatedListener;
    }

    public static /* synthetic */ CustomButtonUpdatedListener access$102(CustomButtonUpdatedListener customButtonUpdatedListener2) {
        int i11 = f128;
        int i12 = i11 + 33;
        f125 = i12 % 128;
        int i13 = i12 % 2;
        customButtonUpdatedListener = customButtonUpdatedListener2;
        int i14 = i11 + 9;
        f125 = i14 % 128;
        int i15 = i14 % 2;
        return customButtonUpdatedListener2;
    }

    public static /* synthetic */ v.b access$200() {
        int i11 = f128 + 91;
        int i12 = i11 % 128;
        f125 = i12;
        int i13 = i11 % 2;
        v.b bVar = taskHandler;
        int i14 = i12 + 115;
        f128 = i14 % 128;
        int i15 = i14 % 2;
        return bVar;
    }

    public static void clearAlreadyLaunchedIds() {
        int i11 = f128 + 41;
        f125 = i11 % 128;
        int i12 = i11 % 2;
        alreadyLaunchedIds.clear();
        boolean z11 = true;
        int i13 = f128 + 1;
        f125 = i13 % 128;
        if (i13 % 2 != 0) {
            z11 = false;
        }
        if (z11) {
            throw null;
        }
    }

    @Deprecated
    public static void close() {
        int i11 = f125 + 77;
        f128 = i11 % 128;
        if ((i11 % 2 != 0 ? 'T' : 22) != 22) {
            int i12 = 48 / 0;
        }
    }

    private static void customButtonCleanup() {
        char c11;
        boolean z11;
        int i11 = f128 + 37;
        f125 = i11 % 128;
        if (i11 % 2 == 0) {
            c11 = 7;
        } else {
            c11 = SignatureVisitor.INSTANCEOF;
        }
        if (c11 != 7) {
            if (sManualBridges.size() > 0) {
                Iterator<e> it = sManualBridges.iterator();
                int i12 = f125 + 113;
                while (true) {
                    f128 = i12 % 128;
                    int i13 = i12 % 2;
                    if (!it.hasNext()) {
                        break;
                    }
                    it.next().m6152();
                    i12 = f125 + 103;
                }
                sManualBridges.clear();
                customButtonUpdatedListener = null;
            }
            v.b bVar = taskHandler;
            if (bVar != null) {
                bVar.m6314();
            }
            int i14 = f128 + 73;
            f125 = i14 % 128;
            if (i14 % 2 == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                throw null;
            }
            return;
        }
        sManualBridges.size();
        throw null;
    }

    public static Activity getActivity() {
        int i11 = f125 + 121;
        f128 = i11 % 128;
        if ((i11 % 2 != 0 ? 'Z' : SignatureVisitor.EXTENDS) != 'Z') {
            Activity activity = sActivity.get();
            int i12 = f125 + 13;
            f128 = i12 % 128;
            if ((i12 % 2 != 0 ? ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK : '2') == '2') {
                return activity;
            }
            throw null;
        }
        Activity activity2 = sActivity.get();
        throw null;
    }

    public static Drawable getCardArt(Context context) {
        int i11 = f125 + 89;
        f128 = i11 % 128;
        int i12 = i11 % 2;
        Drawable r22 = y.m6320(context);
        int i13 = f128 + 85;
        f125 = i13 % 128;
        if ((i13 % 2 == 0 ? '<' : Typography.greater) != '<') {
            return r22;
        }
        throw null;
    }

    @Deprecated
    public static Intent getCheckoutIntent(@NonNull Activity activity, @NonNull PurchaseInfo purchaseInfo) {
        Intent intent = new Intent(activity, CheckoutWebViewActivity.class);
        int i11 = f128 + 121;
        f125 = i11 % 128;
        int i12 = i11 % 2;
        return intent;
    }

    public static String getsCampaignData() {
        int i11 = f125 + 11;
        f128 = i11 % 128;
        if ((i11 % 2 != 0 ? 'E' : ']') == ']') {
            return sCampaignData;
        }
        throw null;
    }

    @Deprecated
    public static void init(@NonNull Context context, @NonNull Profile profile, @Nullable VisaCheckoutSdkInitListener visaCheckoutSdkInitListener) {
        int i11 = f128 + 45;
        f125 = i11 % 128;
        int i12 = i11 % 2;
    }

    @Deprecated
    public static void init(@NonNull Context context, String str, @NonNull String str2, @Nullable String str3, @Nullable VisaCheckoutSdkInitListener visaCheckoutSdkInitListener) {
        int i11 = f128 + 29;
        f125 = i11 % 128;
        int i12 = i11 % 2;
    }

    public static void initManualCheckoutSession(Activity activity, Profile profile, PurchaseInfo purchaseInfo, ManualCheckoutSession manualCheckoutSession) {
        boolean z11;
        boolean z12 = true;
        if (activity != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && profile != null) {
            if (purchaseInfo != null) {
                z12 = false;
            }
            if (!z12) {
                int i11 = f125 + 31;
                f128 = i11 % 128;
                int i12 = i11 % 2;
                if (manualCheckoutSession != null) {
                    q qVar = new q(activity, profile, purchaseInfo, manualCheckoutSession);
                    customButtonCleanup();
                    final n nVar = new n(qVar, manualCheckoutSession);
                    sManualBridges.add(nVar);
                    final WeakReference weakReference = new WeakReference(activity);
                    AnonymousClass1 r62 = new Runnable() {
                        public final void run() {
                            if (((Activity) weakReference.get()).isDestroyed()) {
                                nVar.m6279();
                                if (VisaCheckoutSdk.access$000().contains(nVar)) {
                                    VisaCheckoutSdk.access$000().remove(nVar);
                                }
                                VisaCheckoutSdk.access$102((CustomButtonUpdatedListener) null);
                                VisaCheckoutSdk.access$200().m6314();
                            }
                        }
                    };
                    Timer timer = new Timer();
                    timer.scheduleAtFixedRate(new TimerTask(new Handler(), r62) {

                        /* renamed from: ˏ  reason: contains not printable characters */
                        private /* synthetic */ Handler f410;

                        /* renamed from: ॱ  reason: contains not printable characters */
                        private /* synthetic */ Runnable f411;

                        {
                            this.f410 = r1;
                            this.f411 = r2;
                        }

                        public final void run() {
                            this.f410.post(this.f411);
                        }
                    }, 5000, 5000);
                    taskHandler = new v.b(timer) {

                        /* renamed from: ˊ  reason: contains not printable characters */
                        private /* synthetic */ Timer f412;

                        {
                            this.f412 = r1;
                        }

                        /* renamed from: ॱ  reason: contains not printable characters */
                        public final void m6313() {
                            this.f412.cancel();
                            this.f412.purge();
                        }
                    };
                    return;
                }
            }
        }
        if (manualCheckoutSession != null) {
            manualCheckoutSession.onResult(new VisaPaymentSummary(m6107(127, (String) null, (int[]) null, "").intern()));
            int i13 = f128 + 107;
            f125 = i13 % 128;
            int i14 = i13 % 2;
        }
    }

    public static boolean isAlreadyLaunched(String str) {
        if ((str == null ? '+' : 19) != '+') {
            boolean contains = alreadyLaunchedIds.contains(str);
            int i11 = f128 + 119;
            f125 = i11 % 128;
            int i12 = i11 % 2;
            return contains;
        }
        int i13 = f125 + 123;
        f128 = i13 % 128;
        int i14 = i13 % 2;
        return false;
    }

    @Deprecated
    public static boolean isSdkAvailable() {
        int i11 = f125 + 89;
        int i12 = i11 % 128;
        f128 = i12;
        int i13 = i11 % 2;
        int i14 = i12 + 95;
        f125 = i14 % 128;
        int i15 = i14 % 2;
        return false;
    }

    public static void notifyCustomButtonUpdated() {
        int i11 = f128 + 79;
        f125 = i11 % 128;
        int i12 = i11 % 2;
        if (customButtonUpdatedListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    VisaCheckoutSdk.access$100().onUpdate();
                }
            });
        }
        int i13 = f128 + 113;
        f125 = i13 % 128;
        int i14 = i13 % 2;
    }

    public static void setActivity(Activity activity) {
        sActivity = new WeakReference<>(activity);
        int i11 = f128 + 25;
        f125 = i11 % 128;
        if (!(i11 % 2 != 0)) {
            throw null;
        }
    }

    public static void setAlreadyLaunched(String str) {
        int i11 = f128 + 21;
        f125 = i11 % 128;
        int i12 = i11 % 2;
        alreadyLaunchedIds.add(str);
        int i13 = f125 + 41;
        f128 = i13 % 128;
        int i14 = i13 % 2;
    }

    public static void setCampaignData(String str) {
        int i11 = f128 + 101;
        int i12 = i11 % 128;
        f125 = i12;
        boolean z11 = false;
        boolean z12 = i11 % 2 != 0;
        sCampaignData = str;
        if (z12) {
            int i13 = i12 + 75;
            f128 = i13 % 128;
            if (i13 % 2 != 0) {
                z11 = true;
            }
            if (z11) {
                throw null;
            }
            return;
        }
        throw null;
    }

    public static void setCustomButtonUpdatedListener(CustomButtonUpdatedListener customButtonUpdatedListener2) {
        int i11 = f125 + 109;
        f128 = i11 % 128;
        int i12 = i11 % 2;
        customButtonUpdatedListener = customButtonUpdatedListener2;
        int i13 = f125 + 67;
        f128 = i13 % 128;
        int i14 = i13 % 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6107(int r6, java.lang.String r7, int[] r8, java.lang.String r9) {
        /*
            if (r9 == 0) goto L_0x0008
            java.lang.String r0 = "ISO-8859-1"
            byte[] r9 = r9.getBytes(r0)
        L_0x0008:
            byte[] r9 = (byte[]) r9
            if (r7 == 0) goto L_0x0022
            int r0 = f125
            int r0 = r0 + 63
            int r1 = r0 % 128
            f128 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x001d
            char[] r7 = r7.toCharArray()
            goto L_0x0022
        L_0x001d:
            r7.toCharArray()
            r6 = 0
            throw r6
        L_0x0022:
            char[] r7 = (char[]) r7
            char[] r0 = f129
            int r1 = f130
            boolean r2 = f126
            r3 = 0
            if (r2 == 0) goto L_0x006b
            int r7 = f125
            int r7 = r7 + 51
            int r8 = r7 % 128
            f128 = r8
            int r7 = r7 % 2
            r8 = 49
            if (r7 == 0) goto L_0x003d
            r7 = r8
            goto L_0x003f
        L_0x003d:
            r7 = 54
        L_0x003f:
            int r7 = r9.length
            char[] r8 = new char[r7]
        L_0x0042:
            if (r3 >= r7) goto L_0x0065
            int r2 = f125
            int r4 = r2 + 45
            int r5 = r4 % 128
            f128 = r5
            int r4 = r4 % 2
            int r4 = r7 + -1
            int r4 = r4 - r3
            byte r4 = r9[r4]
            int r4 = r4 + r6
            char r4 = r0[r4]
            int r4 = r4 - r1
            char r4 = (char) r4
            r8[r3] = r4
            int r3 = r3 + 1
            int r2 = r2 + 59
            int r4 = r2 % 128
            f128 = r4
            int r2 = r2 % 2
            goto L_0x0042
        L_0x0065:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r8)
            return r6
        L_0x006b:
            boolean r9 = f127
            if (r9 == 0) goto L_0x0091
            int r8 = r7.length
            char[] r9 = new char[r8]
        L_0x0072:
            r2 = 52
            if (r3 >= r8) goto L_0x0079
            r4 = 45
            goto L_0x007a
        L_0x0079:
            r4 = r2
        L_0x007a:
            if (r4 == r2) goto L_0x008b
            int r2 = r8 + -1
            int r2 = r2 - r3
            char r2 = r7[r2]
            int r2 = r2 - r6
            char r2 = r0[r2]
            int r2 = r2 - r1
            char r2 = (char) r2
            r9[r3] = r2
            int r3 = r3 + 1
            goto L_0x0072
        L_0x008b:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r9)
            return r6
        L_0x0091:
            int r7 = r8.length
            char[] r9 = new char[r7]
        L_0x0094:
            if (r3 >= r7) goto L_0x00a5
            int r2 = r7 + -1
            int r2 = r2 - r3
            r2 = r8[r2]
            int r2 = r2 - r6
            char r2 = r0[r2]
            int r2 = r2 - r1
            char r2 = (char) r2
            r9[r3] = r2
            int r3 = r3 + 1
            goto L_0x0094
        L_0x00a5:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.VisaCheckoutSdk.m6107(int, java.lang.String, int[], java.lang.String):java.lang.String");
    }

    @Deprecated
    public static Intent getCheckoutIntent(@NonNull Activity activity, @NonNull BigDecimal bigDecimal, String str) {
        Intent intent = new Intent(activity, CheckoutWebViewActivity.class);
        int i11 = f128 + 21;
        f125 = i11 % 128;
        if ((i11 % 2 == 0 ? 'M' : '7') == '7') {
            return intent;
        }
        throw null;
    }
}
