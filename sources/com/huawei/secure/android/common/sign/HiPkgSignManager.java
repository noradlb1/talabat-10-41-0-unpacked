package com.huawei.secure.android.common.sign;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.exoplayer2.C;
import com.huawei.secure.android.common.util.LogsUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HiPkgSignManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33832a = "HiPkgSignManager";

    private static PackageInfo a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageArchiveInfo(str, 64);
            }
            return null;
        } catch (Exception e11) {
            LogsUtil.e(f33832a, "Exception : " + e11.getMessage(), true);
            return null;
        }
    }

    private static String b(byte[] bArr) {
        try {
            return a(MessageDigest.getInstance(Constants.SHA256).digest(bArr));
        } catch (NoSuchAlgorithmException e11) {
            LogsUtil.e(f33832a, "NoSuchAlgorithmException" + e11.getMessage());
            return "";
        }
    }

    public static boolean doCheckArchiveApk(Context context, String str, String str2, String str3) {
        PackageInfo a11;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null || TextUtils.isEmpty(str3) || (a11 = a(context, str2)) == null) {
            return false;
        }
        String b11 = b(a11.signatures[0].toByteArray());
        String str4 = a11.packageName;
        if (!str.equalsIgnoreCase(b11) || !str3.equals(str4)) {
            return false;
        }
        return true;
    }

    public static boolean doCheckInstalled(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return str.equalsIgnoreCase(getInstalledAppHash(context, str2));
    }

    public static boolean doCheckInstalledV2V3(Context context, List<String> list, String str) {
        List<String> installedAppHashV2V3;
        if (TextUtils.isEmpty(str) || list == null || context == null || (installedAppHashV2V3 = getInstalledAppHashV2V3(context, str)) == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String upperCase : list) {
            arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
        }
        for (String contains : installedAppHashV2V3) {
            if (!arrayList.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] getInstalledAPPSignature(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            LogsUtil.e(f33832a, "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(str, 64)) == null)) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e11) {
            LogsUtil.e(f33832a, "PackageManager.NameNotFoundException : " + e11.getMessage(), true);
        } catch (Exception e12) {
            LogsUtil.e(f33832a, "Exception : " + e12.getMessage(), true);
        }
        return new byte[0];
    }

    public static String getInstalledAppHash(Context context, String str) {
        byte[] installedAPPSignature = getInstalledAPPSignature(context, str);
        if (installedAPPSignature == null || installedAPPSignature.length <= 0) {
            return "";
        }
        return b(installedAPPSignature);
    }

    public static List<String> getInstalledAppHashV2V3(Context context, String str) {
        Signature[] signatureArr;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, C.BUFFER_FLAG_FIRST_SAMPLE);
                if (packageInfo != null) {
                    if (packageInfo.signingInfo != null) {
                        if (packageInfo.signingInfo.hasMultipleSigners()) {
                            return a(packageInfo.signingInfo.getApkContentsSigners());
                        }
                        return a(packageInfo.signingInfo.getSigningCertificateHistory());
                    }
                }
                return null;
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
            if (!(packageInfo2 == null || (signatureArr = packageInfo2.signatures) == null || signatureArr.length == 0)) {
                if (signatureArr[0] != null) {
                    return a(signatureArr);
                }
            }
            return null;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
    }

    public static String getUnInstalledAPPPackageName(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            LogsUtil.e(f33832a, "archiveFilePath is null or context is null");
            return "";
        }
        PackageInfo a11 = a(context, str);
        if (a11 != null) {
            return a11.packageName;
        }
        return "";
    }

    public static byte[] getUnInstalledAPPSignature(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            LogsUtil.e(f33832a, "archiveFilePath is null or context is null");
            return new byte[0];
        }
        PackageInfo a11 = a(context, str);
        if (a11 != null) {
            Signature signature = a11.signatures[0];
            if (signature != null) {
                return signature.toByteArray();
            }
        } else {
            LogsUtil.e(f33832a, "PackageInfo is null ");
        }
        return new byte[0];
    }

    public static String getUnInstalledAppHash(Context context, String str) {
        byte[] unInstalledAPPSignature = getUnInstalledAPPSignature(context, str);
        if (unInstalledAPPSignature == null || unInstalledAPPSignature.length <= 0) {
            return "";
        }
        return b(unInstalledAPPSignature);
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < length; i11++) {
            byte b11 = bArr[i11];
            if ((b11 & 255) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i11] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(b11 & 255));
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    private static List<String> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        if (!(signatureArr == null || signatureArr.length == 0)) {
            for (Signature byteArray : signatureArr) {
                arrayList.add(b(byteArray.toByteArray()));
            }
        }
        return arrayList;
    }
}
