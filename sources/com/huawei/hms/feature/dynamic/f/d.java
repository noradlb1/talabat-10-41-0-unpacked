package com.huawei.hms.feature.dynamic.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48806a = "SignVerifier";

    /* renamed from: b  reason: collision with root package name */
    private static final String f48807b = "com.huawei.hms.fingerprint_signature";

    /* renamed from: c  reason: collision with root package name */
    private static final String f48808c = "com.huawei.hms.sign_certchain";

    /* renamed from: d  reason: collision with root package name */
    private static final String f48809d = "..";

    private static String a(PackageInfo packageInfo) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length == 0) {
            Logger.e(f48806a, "Failed to get application signature certificate fingerprint.");
            return null;
        }
        byte[] byteArray = signatureArr[0].toByteArray();
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        return b.b(a(byteArray), true);
    }

    private static boolean a(Context context, String str) {
        String str2;
        ApplicationInfo applicationInfo;
        StringBuilder sb2;
        String str3;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 192);
        if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
            str2 = "PackageArchiveInfo is null.";
        } else {
            String str4 = packageArchiveInfo.packageName;
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null) {
                sb2 = new StringBuilder();
                sb2.append("Verify package ");
                sb2.append(str4);
                str3 = " failed for metadata is null.";
            } else if (!bundle.containsKey(f48807b)) {
                sb2 = new StringBuilder();
                sb2.append("Verify package ");
                sb2.append(str4);
                str3 = " failed for no signer.";
            } else if (!bundle.containsKey(f48808c)) {
                sb2 = new StringBuilder();
                sb2.append("Verify package ");
                sb2.append(str4);
                str3 = " failed for no cert chain.";
            } else {
                String a11 = a(packageArchiveInfo);
                if (TextUtils.isEmpty(a11)) {
                    str2 = "Get PackageSignature failed: null.";
                } else {
                    if (!a(bundle.getString(f48807b), bundle.getString(f48808c), str4 + ContainerUtils.FIELD_DELIMITER + a11)) {
                        str2 = "Check CertChain failed.";
                    } else {
                        Logger.i(f48806a, "verify signature with cert chain success.");
                        return true;
                    }
                }
            }
            sb2.append(str3);
            str2 = sb2.toString();
        }
        Logger.e(f48806a, str2);
        return false;
    }

    private static boolean a(String str) {
        String str2;
        try {
            new ZipFile(str).close();
            return true;
        } catch (ZipException unused) {
            str2 = "Check module file ZipException: not a valid zip.";
            Logger.w(f48806a, str2);
            return false;
        } catch (IOException unused2) {
            str2 = "Check module file IOException";
            Logger.w(f48806a, str2);
            return false;
        }
    }

    private static boolean a(String str, String str2, String str3) {
        String str4;
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str4 = "Args is invalid.";
        } else {
            List<X509Certificate> b11 = e.b(str2);
            if (b11.size() == 0) {
                str4 = "CertChain is empty.";
            } else if (!e.a(e.a(), b11)) {
                str4 = "failed to verify cert chain";
            } else {
                X509Certificate x509Certificate = b11.get(0);
                if (!e.a(x509Certificate, "Huawei CBG HMS Kit")) {
                    str4 = "CN is invalid";
                } else if (!e.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                    str4 = "OU is invalid";
                } else {
                    try {
                        bArr = str3.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException e11) {
                        Logger.e(f48806a, "checkCertChain UnsupportedEncodingException:", (Throwable) e11);
                        bArr = null;
                    }
                    if (e.a(x509Certificate, bArr, a.a(str))) {
                        return true;
                    }
                    str4 = "signature is invalid: ";
                }
            }
        }
        Logger.e(f48806a, str4);
        return false;
    }

    private static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(Constants.SHA256).digest(bArr);
        } catch (NoSuchAlgorithmException e11) {
            Logger.e(f48806a, "NoSuchAlgorithmException" + e11.getMessage());
            return new byte[0];
        }
    }

    public static boolean b(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str) || str.contains(f48809d)) {
            str2 = "The context is null or module path is invalid.";
        } else if (!a(str)) {
            str2 = "The module file is in wrong format.";
        } else if (a(context, str)) {
            return true;
        } else {
            str2 = "check signature failed.";
        }
        Logger.e(f48806a, str2);
        return false;
    }
}
