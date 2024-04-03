package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;

public abstract class bd {
    private Object[] ijk;
    private Class<?>[] ikl;
    private String klm;
    private String lmn;

    public static class ijk extends bd {
        private final Context lmn;

        public ijk(Context context) {
            super("com.vivo.push.PushClient", "getInstance", new Class[]{Context.class}, new Object[]{context});
            this.lmn = context;
        }

        public final Object klm() {
            try {
                Class<?> cls = Class.forName("com.vivo.push.PushClient");
                Object invoke = cls.getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{this.lmn});
                if (invoke != null) {
                    return cls.getDeclaredMethod("getRegId", new Class[0]).invoke(cls.cast(invoke), new Object[0]);
                }
            } catch (Exception unused) {
                HiLog.i("PtokenAccess", "invoke token Exception");
            }
            return null;
        }

        public final Bundle lmn(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("$HuaweiMedium", "");
            bundle.putString("$XiaomiMedium", "");
            bundle.putString("$VivoMedium", str);
            bundle.putString("$OppoMedium", "");
            return bundle;
        }

        public final String lmn() {
            Object klm = klm();
            return klm instanceof String ? (String) klm : "";
        }
    }

    public static class ikl extends bd {
        public ikl() {
            super("com.heytap.msp.push.HeytapPushManager", "getRegisterID", (Class<?>[]) null, (Object[]) null);
        }

        public final Bundle lmn(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("$HuaweiMedium", "");
            bundle.putString("$XiaomiMedium", "");
            bundle.putString("$VivoMedium", "");
            bundle.putString("$OppoMedium", str);
            return bundle;
        }

        public final String lmn() {
            Object klm = klm();
            return klm instanceof String ? (String) klm : "";
        }
    }

    public static class klm extends bd {
        public klm(Context context) {
            super("com.xiaomi.mipush.sdk.MiPushClient", "getRegId", new Class[]{Context.class}, new Object[]{context});
        }

        public final Bundle lmn(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("$HuaweiMedium", "");
            bundle.putString("$XiaomiMedium", str);
            bundle.putString("$VivoMedium", "");
            bundle.putString("$OppoMedium", "");
            return bundle;
        }

        public final String lmn() {
            long j11 = av.lmn().lmn.f47870q;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j11 < 60000) {
                HiLog.i("PtokenAccess", "Get MI token interval < 1min");
                return "";
            }
            av.lmn().lmn.f47870q = currentTimeMillis;
            Object klm = klm();
            return klm instanceof String ? (String) klm : "";
        }
    }

    public static class lmn extends bd {
        private final Context lmn;

        public lmn(Context context) {
            super((String) null, (String) null, (Class<?>[]) null, (Object[]) null);
            this.lmn = context;
        }

        private String klm(String str) {
            try {
                return HmsInstanceId.getInstance(this.lmn).getToken(str, HmsMessaging.DEFAULT_TOKEN_SCOPE);
            } catch (ApiException e11) {
                throw new IllegalArgumentException(e11.getMessage());
            }
        }

        public final Bundle lmn(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("$HuaweiMedium", str);
            bundle.putString("$XiaomiMedium", "");
            bundle.putString("$VivoMedium", "");
            bundle.putString("$OppoMedium", "");
            return bundle;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String lmn() {
            /*
                r3 = this;
                com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
                com.huawei.hms.analytics.ax r0 = r0.lmn
                com.huawei.hms.analytics.bc r0 = r0.f47867n
                java.lang.String r0 = r0.klm
                java.lang.String r1 = r3.klm(r0)     // Catch:{ IllegalArgumentException -> 0x001b }
                boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IllegalArgumentException -> 0x0019 }
                if (r2 == 0) goto L_0x0027
                java.lang.String r1 = r3.klm(r0)     // Catch:{ IllegalArgumentException -> 0x0019 }
                goto L_0x0027
            L_0x0019:
                r0 = move-exception
                goto L_0x001e
            L_0x001b:
                r0 = move-exception
                java.lang.String r1 = ""
            L_0x001e:
                java.lang.String r2 = "PtokenAccess"
                java.lang.String r0 = r0.getMessage()
                com.huawei.hms.analytics.core.log.HiLog.w(r2, r0)
            L_0x0027:
                boolean r0 = android.text.TextUtils.isEmpty(r1)
                if (r0 == 0) goto L_0x0035
                com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
                com.huawei.hms.analytics.ax r0 = r0.lmn
                java.lang.String r1 = r0.f47868o
            L_0x0035:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.bd.lmn.lmn():java.lang.String");
        }
    }

    public bd(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        this.lmn = str;
        this.klm = str2;
        this.ikl = clsArr;
        this.ijk = objArr;
    }

    public Object klm() {
        try {
            return Class.forName(this.lmn).getMethod(this.klm, this.ikl).invoke((Object) null, this.ijk);
        } catch (Exception unused) {
            HiLog.i("PtokenAccess", "invokeStaticFun() Exception");
            return null;
        }
    }

    public abstract Bundle lmn(String str);

    public abstract String lmn();
}
