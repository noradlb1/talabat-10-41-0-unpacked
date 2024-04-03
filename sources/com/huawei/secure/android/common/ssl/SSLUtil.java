package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.huawei.secure.android.common.ssl.util.e;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class SSLUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33855a = "SSLUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33856b = "TLSv1.3";

    /* renamed from: c  reason: collision with root package name */
    private static final String f33857c = "TLSv1.2";

    /* renamed from: d  reason: collision with root package name */
    private static final String f33858d = "TLS";

    /* renamed from: e  reason: collision with root package name */
    private static final String f33859e = "TLSv1";

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f33860f = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f33861g = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f33862h = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static String[] getEnabledCipherSuites(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] getEnabledProtocols(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void printTLSAndCipher(SSLSocket sSLSocket) {
        for (String str : sSLSocket.getEnabledProtocols()) {
            e.c(f33855a, "new enable protocols is : " + str);
        }
        for (String str2 : sSLSocket.getEnabledCipherSuites()) {
            e.c(f33855a, "new cipher suites is : " + str2);
        }
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setBlackListCipherSuites(sSLSocket, f33862h);
    }

    public static void setEnableSafeCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket != null && !setWhiteListCipherSuites(sSLSocket)) {
            setBlackListCipherSuites(sSLSocket);
        }
    }

    public static void setEnabledProtocols(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 29) {
                sSLSocket.setEnabledProtocols(new String[]{f33856b, f33857c});
            }
            if (i11 < 29) {
                sSLSocket.setEnabledProtocols(new String[]{f33857c});
            }
        }
    }

    public static SSLContext setSSLContext() throws NoSuchAlgorithmException {
        if (Build.VERSION.SDK_INT >= 29) {
            return SSLContext.getInstance(f33856b);
        }
        return SSLContext.getInstance(f33857c);
    }

    public static void setSSLSocketOptions(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            setEnabledProtocols(sSLSocket);
            setEnableSafeCipherSuites(sSLSocket);
        }
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setWhiteListCipherSuites(sSLSocket, f33861g);
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= length) {
                break;
            }
            String str = enabledCipherSuites[i11];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length2) {
                    z11 = false;
                    break;
                } else if (upperCase.contains(strArr[i12].toUpperCase(Locale.ENGLISH))) {
                    break;
                } else {
                    i12++;
                }
            }
            if (!z11) {
                arrayList.add(str);
            }
            i11++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setEnabledProtocols(SSLSocket sSLSocket, String[] strArr) {
        if (!(sSLSocket == null || strArr == null)) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e11) {
                e.b(f33855a, "setEnabledProtocols: exception : " + e11.getMessage());
            }
        }
        return false;
    }
}
