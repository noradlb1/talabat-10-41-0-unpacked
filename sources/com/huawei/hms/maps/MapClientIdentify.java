package com.huawei.hms.maps;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.maps.internal.ICreator;
import com.huawei.hms.maps.internal.IMapClientIdentity;
import com.huawei.hms.maps.internal.mab;
import com.huawei.hms.maps.model.maa;
import com.huawei.hms.maps.utils.AgcCoreUtil;
import com.huawei.hms.maps.utils.LogM;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class MapClientIdentify {

    /* renamed from: a  reason: collision with root package name */
    private static Context f49305a;

    /* renamed from: b  reason: collision with root package name */
    private static String f49306b;

    /* renamed from: c  reason: collision with root package name */
    private static String f49307c;

    /* renamed from: d  reason: collision with root package name */
    private static long f49308d;

    /* renamed from: e  reason: collision with root package name */
    private static String f49309e;

    /* renamed from: f  reason: collision with root package name */
    private IMapClientIdentity f49310f;

    private static String a(byte[] bArr) {
        try {
            return b(MessageDigest.getInstance(Constants.SHA256).digest(bArr));
        } catch (NoSuchAlgorithmException unused) {
            LogM.e("MapClientIdentify", "NoSuchAlgorithmException");
            return "";
        }
    }

    private static String b(byte[] bArr) {
        String str;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < length; i11++) {
            byte b11 = bArr[i11];
            if ((b11 & 255) < 16) {
                str = "0" + Integer.toHexString(bArr[i11] & 255);
            } else {
                str = Integer.toHexString(b11 & 255);
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    public static String getApiKey() {
        return f49306b;
    }

    public static Context getAppContext() {
        return f49305a;
    }

    public static String getAppId() {
        return f49307c;
    }

    public static String getAppName(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
        } catch (PackageManager.NameNotFoundException | Resources.NotFoundException unused) {
            LogM.e("MapClientIdentify", "In getAppName, Failed to get app name.");
            return "";
        }
    }

    public static String getCountryCode() {
        return f49309e;
    }

    public static byte[] getInstalledAPPSignature(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            LogM.e("HiPkgSignManager", "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(str, 64)) == null)) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            LogM.e("HiPkgSignManager", "PackageManager.NameNotFoundException : ");
        }
        return new byte[0];
    }

    public static String getInstalledAppHash(Context context, String str) {
        byte[] installedAPPSignature = getInstalledAPPSignature(context, str);
        return (installedAPPSignature == null || installedAPPSignature.length <= 0) ? "" : a(installedAPPSignature);
    }

    public static long getMapAuthStartTime() {
        return f49308d;
    }

    public static String getPackageCode(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            LogM.e("MapClientIdentify", "getPackageCode failed NameNotFoundException ");
            str = "";
        }
        LogM.d("MapClientIdentify", "app version = " + str);
        return String.valueOf(str);
    }

    public static void initApiKey(Context context) {
        if (TextUtils.isEmpty(f49306b)) {
            f49306b = AgcCoreUtil.getString(context, "client/api_key");
        }
    }

    public static void setApiKey(String str) {
        f49306b = str;
    }

    public static void setAppContext(Context context) {
        f49305a = context;
    }

    public static void setAppId(String str) {
        f49307c = str;
    }

    public static void setCountryCode(String str) {
        f49309e = str;
    }

    public static void setMapAuthStartTime(long j11) {
        f49308d = j11;
    }

    public boolean regestIdentity(Context context, ICreator iCreator) {
        LogM.d("MapClientIdentify", "sdk start regestIdentity to provider ");
        if (this.f49310f != null) {
            LogM.d("MapClientIdentify", "already invoked.");
            return true;
        } else if (iCreator == null) {
            LogM.d("MapClientIdentify", "creator is null.");
            return false;
        } else {
            String packageName = context.getApplicationContext().getPackageName();
            String appName = getAppName(context, packageName);
            if ("".equals(f49307c)) {
                LogM.e("MapClientIdentify", "AppId is null. Please check if agconnect-services.json file is is added in app project.");
            }
            maa g11 = new maa().b(f49307c).c(packageName).d(appName).e(getInstalledAppHash(context, packageName)).f(f49306b).a(f49308d).a(getPackageCode(context)).g(f49309e);
            try {
                IMapClientIdentity newMapClientIdentity = iCreator.newMapClientIdentity(ObjectWrapper.wrap(mab.d(context)));
                this.f49310f = newMapClientIdentity;
                newMapClientIdentity.regestToProvierIdentity(g11);
                LogM.d("MapClientIdentify", "Identity param regestToProvier success");
                return true;
            } catch (RemoteException unused) {
                LogM.e("MapClientIdentify", "regestIdentity RemoteException");
                return false;
            }
        }
    }
}
