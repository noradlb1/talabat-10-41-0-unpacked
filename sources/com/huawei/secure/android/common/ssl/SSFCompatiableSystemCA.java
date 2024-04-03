package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
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

public class SSFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i  reason: collision with root package name */
    private static final String f33843i = "SSFCompatiableSystemCA";

    /* renamed from: j  reason: collision with root package name */
    private static volatile SSFCompatiableSystemCA f33844j;

    /* renamed from: a  reason: collision with root package name */
    private SSLContext f33845a;

    /* renamed from: b  reason: collision with root package name */
    private SSLSocket f33846b;

    /* renamed from: c  reason: collision with root package name */
    private Context f33847c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f33848d;

    /* renamed from: e  reason: collision with root package name */
    private X509TrustManager f33849e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f33850f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f33851g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f33852h;

    private SSFCompatiableSystemCA(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f33845a = null;
        this.f33846b = null;
        if (context == null) {
            e.b(f33843i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager instance = SSFSecureX509SingleInstance.getInstance(context);
        this.f33849e = instance;
        this.f33845a.init((KeyManager[]) null, new X509TrustManager[]{instance}, secureRandom);
    }

    private void a(Socket socket) {
        boolean z11;
        boolean z12 = true;
        if (!a.a(this.f33852h)) {
            e.c(f33843i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f33852h);
            z11 = true;
        } else {
            z11 = false;
        }
        if (!a.a(this.f33851g) || !a.a(this.f33850f)) {
            e.c(f33843i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!a.a(this.f33851g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f33851g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f33850f);
            }
        } else {
            z12 = false;
        }
        if (!z11) {
            e.c(f33843i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z12) {
            e.c(f33843i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    @Deprecated
    public static void b(X509TrustManager x509TrustManager) {
        e.c(f33843i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f33844j = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            e.b(f33843i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            e.b(f33843i, "KeyManagementException");
        }
        String str = f33843i;
        e.a(str, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void c(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f33843i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f33844j = new SSFCompatiableSystemCA(x509TrustManager, secureRandom);
        } catch (NoSuchAlgorithmException unused) {
            e.b(f33843i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            e.b(f33843i, "KeyManagementException");
        }
        String str = f33843i;
        e.a(str, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public static SSFCompatiableSystemCA getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f33844j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f33844j == null) {
                    f33844j = new SSFCompatiableSystemCA(context, (SecureRandom) null);
                }
            }
        }
        if (f33844j.f33847c == null && context != null) {
            f33844j.setContext(context);
        }
        return f33844j;
    }

    public Socket createSocket(String str, int i11) throws IOException {
        e.c(f33843i, "createSocket: host , port");
        Socket createSocket = this.f33845a.getSocketFactory().createSocket(str, i11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33846b = sSLSocket;
            this.f33848d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f33850f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f33849e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f33847c;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f33852h;
    }

    public SSLContext getSslContext() {
        return this.f33845a;
    }

    public SSLSocket getSslSocket() {
        return this.f33846b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f33848d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f33851g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f33849e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f33850f = strArr;
    }

    public void setContext(Context context) {
        this.f33847c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f33852h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f33845a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f33851g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f33849e = x509TrustManager;
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException, UnknownHostException {
        return createSocket(str, i11);
    }

    @Deprecated
    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f33845a = null;
        this.f33846b = null;
        this.f33845a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33845a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    public static SSFCompatiableSystemCA getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f33844j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f33844j == null) {
                    f33844j = new SSFCompatiableSystemCA(context, secureRandom);
                }
            }
        }
        if (f33844j.f33847c == null && context != null) {
            f33844j.setContext(context);
        }
        return f33844j;
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        e.c(f33843i, "createSocket: s , host , port , autoClose");
        Socket createSocket = this.f33845a.getSocketFactory().createSocket(socket, str, i11, z11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33846b = sSLSocket;
            this.f33848d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f33845a = null;
        this.f33846b = null;
        this.f33845a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33845a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
