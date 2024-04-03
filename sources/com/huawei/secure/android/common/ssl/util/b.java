package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33957a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static final int f33958b = 5;

    public static X509Certificate a(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e11) {
            String str2 = f33957a;
            e.b(str2, "generateX509FromStr: CertificateException" + e11.getMessage());
            return null;
        }
    }

    public static boolean b(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        int length = x509CertificateArr.length;
        int i11 = 0;
        while (i11 < length) {
            try {
                x509CertificateArr[i11].checkValidity(date);
                i11++;
            } catch (CertificateExpiredException | CertificateNotYetValidException e11) {
                e.b(f33957a, "verifyCertificateDate: exception : " + e11.getMessage());
                return false;
            } catch (Exception e12) {
                e.b(f33957a, "verifyCertificateDate : exception : " + e12.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        if (!a(x509Certificate, x509CertificateArr) && !a(x509CertificateArr, x509crl) && a(x509CertificateArr[x509CertificateArr.length - 1], str) && b(x509CertificateArr)) {
            return true;
        }
        return false;
    }

    public static boolean a(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate serialNumber : x509CertificateArr) {
            arrayList.add(serialNumber.getSerialNumber());
        }
        if (x509crl == null) {
            return true;
        }
        try {
            Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
            if (revokedCertificates == null || revokedCertificates.isEmpty()) {
                return true;
            }
            for (X509CRLEntry serialNumber2 : revokedCertificates) {
                if (arrayList.contains(serialNumber2.getSerialNumber())) {
                    e.b(f33957a, "verify: certificate revoked");
                    return false;
                }
            }
            return true;
        } catch (Exception e11) {
            e.b(f33957a, "verify: revoked verify exception : " + e11.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        e.b(f33957a, "verify: subject name is error");
        return false;
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (b(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            e.b(f33957a, "verify: date not right");
            return false;
        } catch (CertificateException e11) {
            String str = f33957a;
            e.b(str, "verify: publickey CertificateException " + e11.getMessage());
            return false;
        } catch (InvalidKeyException e12) {
            String str2 = f33957a;
            e.b(str2, "verify: publickey InvalidKeyException " + e12.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e13) {
            String str3 = f33957a;
            e.b(str3, "verify: publickey NoSuchAlgorithmException " + e13.getMessage());
            return false;
        } catch (NoSuchProviderException e14) {
            String str4 = f33957a;
            e.b(str4, "verify: publickey NoSuchProviderException " + e14.getMessage());
            return false;
        } catch (SignatureException e15) {
            String str5 = f33957a;
            e.b(str5, "verify: publickey SignatureException " + e15.getMessage());
            return false;
        } catch (Exception e16) {
            String str6 = f33957a;
            e.b(str6, "verify: Exception " + e16.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i11 = 0;
        while (i11 < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i11];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (issuerDN.equals(principal)) {
                    x509CertificateArr[i11].verify(x509CertificateArr[i11 - 1].getPublicKey());
                } else {
                    e.b(f33957a, "verify: principalIssuer not match");
                    return false;
                }
            }
            i11++;
            principal = subjectDN;
        }
        if (a(x509Certificate, x509CertificateArr[0]) && b(x509CertificateArr) && a(x509Certificate) && a(x509CertificateArr)) {
            return true;
        }
        return false;
    }

    public static X509Certificate a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e11) {
                e.a(f33957a, "exception", e11);
            }
        }
        return null;
    }

    public static boolean a(X509Certificate[] x509CertificateArr) {
        for (int i11 = 0; i11 < x509CertificateArr.length - 1; i11++) {
            if (!a(x509CertificateArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }
}
