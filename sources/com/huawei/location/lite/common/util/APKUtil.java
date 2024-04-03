package com.huawei.location.lite.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.android.receiver.PackageOperateCallback;
import com.huawei.location.lite.common.android.receiver.PackageReceiver;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.secure.android.common.util.SafeString;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class APKUtil {
    private static final String AUTHORITIES = "content://com.huawei.hms.servicemanager";
    private static final String KEY_AAID = "AAID";
    private static final String LBS_PKG_NAME = "com.huawei.lbs";
    private static final String METHOD_GET_AAID = "getAAID";
    private static final String TAG = "APKUtil";
    private static String aaid;
    private static LruCache<String, ApkInfo> apkInfoLruCache;

    public static class ApkInfo {
        public int applicationFlag;
        public int applicationLabelRes;
        public String defSecretSignature;
        public Signature signature;
        public int targetSdkVersion;
        public int uid;
        public long versionCode = -1;
        public String versionName;
    }

    static {
        PackageReceiver.getInstance().registerCallback(new PackageOperateCallback() {
            public void onAdded(String str) {
            }

            public void onRemoved(String str) {
                APKUtil.updateLruCache(str);
            }

            public void onReplaced(String str) {
                APKUtil.updateLruCache(str);
            }
        });
    }

    public static synchronized String getAAID() {
        String str;
        synchronized (APKUtil.class) {
            if (TextUtils.isEmpty(aaid)) {
                try {
                    Bundle call = ContextUtil.getHMSContext().getContentResolver().call(Uri.parse(AUTHORITIES), METHOD_GET_AAID, (String) null, (Bundle) null);
                    if (call != null) {
                        aaid = call.getString(KEY_AAID);
                    }
                } catch (Exception unused) {
                    LogConsole.e(TAG, "getAAID Exception");
                }
            }
            LogConsole.d(TAG, "getAAID:" + aaid);
            str = aaid;
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.huawei.location.lite.common.util.APKUtil.ApkInfo getApkInfo(java.lang.String r6, int r7) {
        /*
            java.lang.Class<com.huawei.location.lite.common.util.APKUtil> r0 = com.huawei.location.lite.common.util.APKUtil.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x0017
            java.lang.String r6 = "APKUtil"
            java.lang.String r7 = "package name is empty"
            com.huawei.location.lite.common.log.LogConsole.e(r6, r7)     // Catch:{ all -> 0x006f }
            com.huawei.location.lite.common.util.APKUtil$ApkInfo r6 = new com.huawei.location.lite.common.util.APKUtil$ApkInfo     // Catch:{ all -> 0x006f }
            r6.<init>()     // Catch:{ all -> 0x006f }
            monitor-exit(r0)
            return r6
        L_0x0017:
            android.util.LruCache<java.lang.String, com.huawei.location.lite.common.util.APKUtil$ApkInfo> r1 = apkInfoLruCache     // Catch:{ all -> 0x006f }
            if (r1 != 0) goto L_0x0023
            android.util.LruCache r1 = new android.util.LruCache     // Catch:{ all -> 0x006f }
            r2 = 4
            r1.<init>(r2)     // Catch:{ all -> 0x006f }
            apkInfoLruCache = r1     // Catch:{ all -> 0x006f }
        L_0x0023:
            android.util.LruCache<java.lang.String, com.huawei.location.lite.common.util.APKUtil$ApkInfo> r1 = apkInfoLruCache     // Catch:{ all -> 0x006f }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x006f }
            com.huawei.location.lite.common.util.APKUtil$ApkInfo r1 = (com.huawei.location.lite.common.util.APKUtil.ApkInfo) r1     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x0069
            java.lang.String r2 = "APKUtil"
            java.lang.String r3 = "getPackageInfo From Cache"
            com.huawei.location.lite.common.log.LogConsole.i(r2, r3)     // Catch:{ all -> 0x006f }
            r2 = 1
            if (r7 == r2) goto L_0x005e
            r2 = 64
            if (r7 == r2) goto L_0x004f
            r2 = 16384(0x4000, float:2.2959E-41)
            if (r7 == r2) goto L_0x0040
            goto L_0x0069
        L_0x0040:
            long r2 = r1.versionCode     // Catch:{ all -> 0x006f }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0049
            goto L_0x004d
        L_0x0049:
            com.huawei.location.lite.common.util.APKUtil$ApkInfo r1 = getPackageInfo(r1, r6, r7)     // Catch:{ all -> 0x006f }
        L_0x004d:
            monitor-exit(r0)
            return r1
        L_0x004f:
            java.lang.String r2 = r1.defSecretSignature     // Catch:{ all -> 0x006f }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x006f }
            if (r2 != 0) goto L_0x0058
            goto L_0x005c
        L_0x0058:
            com.huawei.location.lite.common.util.APKUtil$ApkInfo r1 = getPackageInfo(r1, r6, r7)     // Catch:{ all -> 0x006f }
        L_0x005c:
            monitor-exit(r0)
            return r1
        L_0x005e:
            int r2 = r1.uid     // Catch:{ all -> 0x006f }
            if (r2 <= 0) goto L_0x0063
            goto L_0x0067
        L_0x0063:
            com.huawei.location.lite.common.util.APKUtil$ApkInfo r1 = getPackageInfo(r1, r6, r7)     // Catch:{ all -> 0x006f }
        L_0x0067:
            monitor-exit(r0)
            return r1
        L_0x0069:
            com.huawei.location.lite.common.util.APKUtil$ApkInfo r6 = getPackageInfo(r1, r6, r7)     // Catch:{ all -> 0x006f }
            monitor-exit(r0)
            return r6
        L_0x006f:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.APKUtil.getApkInfo(java.lang.String, int):com.huawei.location.lite.common.util.APKUtil$ApkInfo");
    }

    public static String getAppName(Context context) {
        return context == null ? "" : context.getResources().getString(getApkInfo(context.getPackageName(), 16384).applicationLabelRes);
    }

    public static long getAppVersionCode(Context context) {
        if (context == null) {
            return -1;
        }
        return getVersionCode(context.getPackageName());
    }

    public static long getHMSVersionCode() {
        return getAppVersionCode(ContextUtil.getHMSContext());
    }

    public static long getLBSVersionCode() {
        return getThirdAppVersionCode(LBS_PKG_NAME);
    }

    public static long getLocationVersionCode() {
        return getAppVersionCode(ContextUtil.getContext());
    }

    private static ApkInfo getPackageInfo(ApkInfo apkInfo, String str, int i11) {
        String str2;
        PackageManager packageManager = ContextUtil.getContext().getPackageManager();
        if (apkInfo == null) {
            apkInfo = new ApkInfo();
        }
        try {
            LogConsole.i(TAG, "getPackageInfo From PackageManager");
            PackageInfo packageInfo = packageManager.getPackageInfo(str, i11);
            if (packageInfo == null) {
                return apkInfo;
            }
            if (i11 == 1) {
                apkInfo.uid = packageInfo.applicationInfo.uid;
            } else if (i11 == 64) {
                apkInfo.signature = !CollectionsUtils.isEmpty((Object[]) packageInfo.signatures) ? packageInfo.signatures[0] : null;
                apkInfo.defSecretSignature = getSignature(packageInfo.signatures);
            } else if (i11 == 16384) {
                apkInfo.versionName = packageInfo.versionName;
                apkInfo.versionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode;
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                apkInfo.targetSdkVersion = applicationInfo.targetSdkVersion;
                apkInfo.applicationLabelRes = applicationInfo.labelRes;
                apkInfo.applicationFlag = applicationInfo.flags;
            }
            if (i11 != 64) {
                apkInfoLruCache.put(str, apkInfo);
            }
            return apkInfo;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "NameNotFoundException!";
            LogConsole.e(TAG, str2);
            return apkInfo;
        } catch (Exception unused2) {
            str2 = "Package  manager  has  died Exception";
            LogConsole.e(TAG, str2);
            return apkInfo;
        }
    }

    public static Map<String, String> getPackageVersionCode(String str) {
        HashMap hashMap = new HashMap();
        if (str == null || str.isEmpty()) {
            hashMap.put("versionCode", String.valueOf(-1));
            hashMap.put("versionName", "");
            LogConsole.d(TAG, "packageName is empty, return -1");
            return hashMap;
        }
        long versionCode = getVersionCode(str);
        String versionName = getVersionName(str);
        LogConsole.d(TAG, str + ":versionName:" + versionName + ", versionCode:" + versionCode);
        hashMap.put("versionCode", String.valueOf(versionCode));
        hashMap.put("versionName", versionName);
        return hashMap;
    }

    public static String getPackageVersionName(String str) {
        return getVersionName(str);
    }

    private static String getSignature(Signature[] signatureArr) {
        String str;
        if (CollectionsUtils.isEmpty((Object[]) signatureArr)) {
            str = "signatures is empty!";
        } else {
            try {
                return getSignatureString(signatureArr[0]);
            } catch (NoSuchAlgorithmException unused) {
                str = "NoSuchAlgorithmException!";
            }
        }
        LogConsole.e(TAG, str);
        return null;
    }

    public static String getSignatureForPkgName(String str) {
        return getApkInfo(str, 64).defSecretSignature;
    }

    private static String getSignatureString(Signature signature) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : digest) {
            sb2.append(SafeString.substring(Integer.toHexString((b11 & 255) | 256), 1, 3).toUpperCase(Locale.ROOT));
        }
        return sb2.toString();
    }

    public static int getTargetSdkVersion(String str) {
        return getApkInfo(str, 16384).targetSdkVersion;
    }

    public static long getThirdAppVersionCode(@NonNull String str) {
        return getVersionCode(str);
    }

    public static int getUidByPackageName(String str) {
        if (str != null && !str.isEmpty()) {
            return getApkInfo(str, 1).uid;
        }
        LogConsole.d(TAG, "packageName is empty, return -1");
        return -1;
    }

    private static long getVersionCode(String str) {
        return getApkInfo(str, 16384).versionCode;
    }

    public static String getVersionName() {
        return getVersionName(ContextUtil.getContext().getPackageName());
    }

    private static String getVersionName(String str) {
        return getApkInfo(str, 16384).versionName;
    }

    public static boolean isSystemApplication(String str) {
        return (getApkInfo(str, 16384).applicationFlag & 1) != 0;
    }

    /* access modifiers changed from: private */
    public static void updateLruCache(String str) {
        if (apkInfoLruCache.get(str) != null) {
            apkInfoLruCache.remove(str);
        }
    }
}
