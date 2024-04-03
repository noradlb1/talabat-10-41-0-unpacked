package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class SecureSSLSocketFactoryNew extends SSLSocketFactory {

    /* renamed from: i  reason: collision with root package name */
    private static final String f33883i = "SSLFNew";

    /* renamed from: j  reason: collision with root package name */
    private static volatile SecureSSLSocketFactoryNew f33884j;

    /* renamed from: a  reason: collision with root package name */
    public SSLContext f33885a;

    /* renamed from: b  reason: collision with root package name */
    public SSLSocket f33886b;

    /* renamed from: c  reason: collision with root package name */
    public Context f33887c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f33888d;

    /* renamed from: e  reason: collision with root package name */
    public X509TrustManager f33889e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f33890f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f33891g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f33892h;

    @Deprecated
    public SecureSSLSocketFactoryNew(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f33885a = null;
        this.f33886b = null;
        this.f33885a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f33885a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, (SecureRandom) null);
    }

    private void a(Socket socket) {
        boolean z11;
        boolean z12 = true;
        if (!a.a(this.f33892h)) {
            e.c(f33883i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f33892h);
            z11 = true;
        } else {
            z11 = false;
        }
        if (!a.a(this.f33891g) || !a.a(this.f33890f)) {
            e.c(f33883i, "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!a.a(this.f33891g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f33891g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f33890f);
            }
        } else {
            z12 = false;
        }
        if (!z11) {
            e.c(f33883i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z12) {
            e.c(f33883i, "set default cipher");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    @Deprecated
    public static SecureSSLSocketFactoryNew getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f33884j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f33884j == null) {
                    f33884j = new SecureSSLSocketFactoryNew(context, (SecureRandom) null);
                }
            }
        }
        if (f33884j.f33887c == null && context != null) {
            f33884j.setContext(context);
        }
        e.a(f33883i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f33884j;
    }

    public Socket createSocket(String str, int i11) throws IOException {
        e.c(f33883i, "createSocket: host , port");
        Socket createSocket = this.f33885a.getSocketFactory().createSocket(str, i11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33886b = sSLSocket;
            this.f33888d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f33890f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f33889e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f33887c;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f33892h;
    }

    public SSLContext getSslContext() {
        return this.f33885a;
    }

    public SSLSocket getSslSocket() {
        return this.f33886b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f33888d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f33891g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f33889e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f33890f = strArr;
    }

    public void setContext(Context context) {
        this.f33887c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f33892h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f33885a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f33891g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f33889e = x509TrustManager;
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    public SecureSSLSocketFactoryNew(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f33885a = null;
        this.f33886b = null;
        this.f33885a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f33885a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException, UnknownHostException {
        return createSocket(str, i11);
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        e.c(f33883i, "createSocket");
        Socket createSocket = this.f33885a.getSocketFactory().createSocket(socket, str, i11, z11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33886b = sSLSocket;
            this.f33888d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SecureSSLSocketFactoryNew getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f33884j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f33884j == null) {
                    f33884j = new SecureSSLSocketFactoryNew(context, secureRandom);
                }
            }
        }
        if (f33884j.f33887c == null && context != null) {
            f33884j.setContext(context);
        }
        e.a(f33883i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f33884j;
    }

    private SecureSSLSocketFactoryNew(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f33885a = null;
        this.f33886b = null;
        if (context == null) {
            e.b(f33883i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager instance = SecureX509SingleInstance.getInstance(context);
        this.f33889e = instance;
        this.f33885a.init((KeyManager[]) null, new X509TrustManager[]{instance}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f33885a = null;
        this.f33886b = null;
        this.f33885a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33885a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }

    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f33885a = null;
        this.f33886b = null;
        this.f33885a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33885a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
