package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.b;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.h;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.X509TrustManager;

public class c implements X509TrustManager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f33925c = "WebViewX509TrustManger";

    /* renamed from: a  reason: collision with root package name */
    private X509Certificate f33926a;

    /* renamed from: b  reason: collision with root package name */
    private List<X509TrustManager> f33927b = new ArrayList();

    public c(Context context) {
        if (context != null) {
            ContextUtil.setContext(context);
            X509Certificate b11 = new h(context).b();
            this.f33926a = b11;
            if (b11 == null) {
                throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
            }
            return;
        }
        throw new NullPointerException("WebViewX509TrustManger context is null");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.c(f33925c, "checkClientTrusted");
        if (!this.f33927b.isEmpty()) {
            this.f33927b.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.c(f33925c, "checkServerTrusted");
        boolean z11 = false;
        for (int i11 = 0; i11 < x509CertificateArr.length; i11++) {
            e.a(f33925c, "checkServerTrusted " + i11 + " : " + x509CertificateArr[i11].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i12 = 0; i12 < x509CertificateArr.length; i12++) {
            x509CertificateArr2[i12] = x509CertificateArr[(x509CertificateArr.length - 1) - i12];
        }
        CertificateException e11 = new CertificateException("CBG root CA CertificateException");
        try {
            z11 = b.a(this.f33926a, x509CertificateArr2);
        } catch (NoSuchProviderException e12) {
            e.b(f33925c, "checkServerTrusted NoSuchProviderException: " + e12.getMessage());
        } catch (NoSuchAlgorithmException e13) {
            e.b(f33925c, "checkServerTrusted NoSuchAlgorithmException: " + e13.getMessage());
        } catch (InvalidKeyException e14) {
            e.b(f33925c, "checkServerTrusted InvalidKeyException: " + e14.getMessage());
        } catch (SignatureException e15) {
            e.b(f33925c, "checkServerTrusted SignatureException: " + e15.getMessage());
        } catch (CertificateException e16) {
            e11 = e16;
            e.b(f33925c, "checkServerTrusted CertificateException: " + e11.getMessage());
        }
        if (!z11) {
            throw e11;
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager acceptedIssuers : this.f33927b) {
                arrayList.addAll(Arrays.asList(acceptedIssuers.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e11) {
            e.b(f33925c, "getAcceptedIssuers exception : " + e11.getMessage());
            return new X509Certificate[0];
        }
    }
}
