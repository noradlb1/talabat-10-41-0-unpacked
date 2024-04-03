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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
public class SecureSSLSocketFactory extends SSLSocketFactory {
    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i  reason: collision with root package name */
    private static final String f33873i = SecureSSLSocketFactory.class.getSimpleName();

    /* renamed from: j  reason: collision with root package name */
    private static volatile SecureSSLSocketFactory f33874j = null;

    /* renamed from: a  reason: collision with root package name */
    private SSLContext f33875a;

    /* renamed from: b  reason: collision with root package name */
    private SSLSocket f33876b;

    /* renamed from: c  reason: collision with root package name */
    private Context f33877c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f33878d;

    /* renamed from: e  reason: collision with root package name */
    private X509TrustManager f33879e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f33880f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f33881g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f33882h;

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f33875a = null;
        this.f33876b = null;
        this.f33875a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f33875a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, (SecureRandom) null);
    }

    private void a(Socket socket) {
        boolean z11;
        boolean z12 = true;
        if (!a.a(this.f33882h)) {
            e.c(f33873i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f33882h);
            z11 = true;
        } else {
            z11 = false;
        }
        if (!a.a(this.f33881g) || !a.a(this.f33880f)) {
            e.c(f33873i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!a.a(this.f33881g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f33881g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f33880f);
            }
        } else {
            z12 = false;
        }
        if (!z11) {
            e.c(f33873i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z12) {
            e.c(f33873i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    @Deprecated
    public static void b(X509TrustManager x509TrustManager) {
        e.c(f33873i, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f33874j = new SecureSSLSocketFactory(x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            e.b(f33873i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            e.b(f33873i, "KeyManagementException");
        }
        String str = f33873i;
        e.a(str, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void c(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f33873i, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f33874j = new SecureSSLSocketFactory(x509TrustManager, secureRandom);
        } catch (NoSuchAlgorithmException unused) {
            e.b(f33873i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            e.b(f33873i, "KeyManagementException");
        }
        String str = f33873i;
        e.a(str, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f33874j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f33874j == null) {
                    f33874j = new SecureSSLSocketFactory(context, (SecureRandom) null);
                }
            }
        }
        if (f33874j.f33877c == null && context != null) {
            f33874j.setContext(context);
        }
        String str = f33873i;
        e.a(str, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f33874j;
    }

    public Socket createSocket(String str, int i11) throws IOException {
        e.c(f33873i, "createSocket: host , port");
        Socket createSocket = this.f33875a.getSocketFactory().createSocket(str, i11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33876b = sSLSocket;
            this.f33878d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f33880f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f33879e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f33877c;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f33882h;
    }

    public SSLContext getSslContext() {
        return this.f33875a;
    }

    public SSLSocket getSslSocket() {
        return this.f33876b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f33878d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f33881g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f33879e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f33880f = strArr;
    }

    public void setContext(Context context) {
        this.f33877c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f33882h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f33875a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f33881g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f33879e = x509TrustManager;
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    public SecureSSLSocketFactory(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f33875a = null;
        this.f33876b = null;
        this.f33875a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f33875a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException, UnknownHostException {
        return createSocket(str, i11);
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        e.c(f33873i, "createSocket s host port autoClose");
        Socket createSocket = this.f33875a.getSocketFactory().createSocket(socket, str, i11, z11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33876b = sSLSocket;
            this.f33878d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SecureSSLSocketFactory getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f33874j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f33874j == null) {
                    f33874j = new SecureSSLSocketFactory(context, secureRandom);
                }
            }
        }
        if (f33874j.f33877c == null && context != null) {
            f33874j.setContext(context);
        }
        String str = f33873i;
        e.a(str, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f33874j;
    }

    private SecureSSLSocketFactory(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f33875a = null;
        this.f33876b = null;
        if (context == null) {
            e.b(f33873i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager instance = SecureX509SingleInstance.getInstance(context);
        this.f33879e = instance;
        this.f33875a.init((KeyManager[]) null, new X509TrustManager[]{instance}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f33875a = null;
        this.f33876b = null;
        this.f33875a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33875a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }

    public SecureSSLSocketFactory(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f33875a = null;
        this.f33876b = null;
        this.f33875a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33875a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
