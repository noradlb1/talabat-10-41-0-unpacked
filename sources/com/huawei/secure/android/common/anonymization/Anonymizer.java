package com.huawei.secure.android.common.anonymization;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

public class Anonymizer {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33700a = "Anonymizer";

    public static String maskAccountId(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        if (str.length() < 8) {
            return maskCommonString(str, 0, 1);
        }
        return maskCommonString(str, 0, 4);
    }

    public static String maskBankAccount(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return a.a(str, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        }
        if (str.length() < 11 || str.length() >= 20) {
            return maskCommonString(str, 6, 4);
        }
        return maskCommonString(str, 4, 4);
    }

    public static String maskBirthday(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 4) {
            return a.a(str, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        }
        String[] a11 = a.a(str, 4);
        return a.a("", a.a(a11, 0), a.a(a.a(a11, 1), "0123456789", "*"));
    }

    public static String maskCommonString(String str, int i11, int i12) {
        int i13;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 < 0) {
            i12 = 0;
        }
        if (str.length() <= i11 + i12) {
            i13 = str.length() - 1;
            i11 = 1;
        } else {
            i13 = str.length() - i12;
        }
        String[] a11 = a.a(str, i11, i13);
        return a.a("", a.a(a11, 0), a.a(a.a(a11, 1), (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH), a.a(a11, 2));
    }

    public static String maskEmail(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            String[] a11 = a.a(str, 1);
            return a.a("", a.a(a11, 0), a.a(a.a(a11, 1), (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH));
        }
        String[] a12 = a.a(str, indexOf, indexOf + 1, str.lastIndexOf(46));
        return a.a("", a.a(a.a(a12, 0), (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH), a.a(a12, 1), a.a(a.a(a12, 2), (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH), a.a(a12, 3));
    }

    public static String maskId(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return maskCommonString(str, str.length() - 12, 0);
    }

    public static String maskImeiImsi(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return maskCommonString(str, str.length() - 4, 0);
    }

    public static String maskIpV4(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return a.a(str, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        }
        String[] a11 = a.a(str, lastIndexOf + 1);
        return a.a("", a.a(a11, 0), a.a(a.a(a11, 1), (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH));
    }

    public static String maskIpV6(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String[] b11 = a.b(str, (char) AbstractJsonLexerKt.COLON);
        if (b11.length <= 1) {
            return a.a(str, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        }
        if (b11.length != 8) {
            String[] a11 = a.a(str, str.indexOf(58) + 1);
            return a.a("", a.a(a11, 0), a.a(a.a(a11, 1), "0123456789ABCDEFabcdef", "*"));
        }
        b11[2] = maskLower8Bit(b11[2]);
        for (int i11 = 3; i11 < b11.length; i11++) {
            b11[i11] = a.a(b11[i11], (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        }
        return a.a(CertificateUtil.DELIMITER, b11);
    }

    public static String maskLower8Bit(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f33700a, "maskLower8Bit: s is null");
            return "";
        } else if (str.length() <= 2) {
            return a.a(str, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        } else {
            String[] a11 = a.a(str, str.length() - 2);
            return a.a("", a.a(a11, 0), a.a(a.a(a11, 1), (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH));
        }
    }

    public static String maskMac(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int a11 = a.a(str, (char) SignatureVisitor.SUPER, 2);
        if (a11 < 0) {
            return a.a(str, "0123456789ABCDEFabcdef", "*");
        }
        String[] a12 = a.a(str, a11);
        return a.a("", a.a(a12, 0), a.a(a.a(a12, 1), "0123456789ABCDEFabcdef", "*"));
    }

    public static String maskName(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        return maskCommonString(str, 1, 0);
    }

    public static String maskPhone(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return a.a(str, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH);
        }
        if (str.length() < 8 || str.length() >= 11) {
            return maskCommonString(str, 3, 4);
        }
        return maskCommonString(str, 2, 2);
    }
}
