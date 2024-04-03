package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class SASFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i  reason: collision with root package name */
    private static final String f33833i = "SASFCompatiableSystemCA";

    /* renamed from: j  reason: collision with root package name */
    private static volatile SASFCompatiableSystemCA f33834j;

    /* renamed from: a  reason: collision with root package name */
    private SSLContext f33835a;

    /* renamed from: b  reason: collision with root package name */
    private SSLSocket f33836b;

    /* renamed from: c  reason: collision with root package name */
    private Context f33837c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f33838d;

    /* renamed from: e  reason: collision with root package name */
    private X509TrustManager f33839e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f33840f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f33841g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f33842h;

    private SASFCompatiableSystemCA(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f33836b = null;
    }

    private void a(Socket socket) {
        boolean z11;
        boolean z12 = true;
        if (!a.a(this.f33842h)) {
            e.c(f33833i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f33842h);
            z11 = true;
        } else {
            z11 = false;
        }
        if (!a.a(this.f33841g) || !a.a(this.f33840f)) {
            e.c(f33833i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!a.a(this.f33841g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f33841g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f33840f);
            }
        } else {
            z12 = false;
        }
        if (!z11) {
            e.c(f33833i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z12) {
            e.c(f33833i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    @Deprecated
    public static void b(X509TrustManager x509TrustManager) {
        e.c(f33833i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f33834j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            e.b(f33833i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            e.b(f33833i, "KeyManagementException");
        } catch (UnrecoverableKeyException unused3) {
            e.b(f33833i, "UnrecoverableKeyException");
        } catch (KeyStoreException unused4) {
            e.b(f33833i, "KeyStoreException");
        }
        String str = f33833i;
        e.a(str, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void c(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f33833i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f33834j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager, secureRandom);
        } catch (NoSuchAlgorithmException unused) {
            e.b(f33833i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            e.b(f33833i, "KeyManagementException");
        } catch (UnrecoverableKeyException unused3) {
            e.b(f33833i, "UnrecoverableKeyException");
        } catch (KeyStoreException unused4) {
            e.b(f33833i, "KeyStoreException");
        }
        String str = f33833i;
        e.a(str, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f33834j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f33834j == null) {
                    f33834j = new SASFCompatiableSystemCA(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f33834j;
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        e.c(f33833i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f33835a.getSocketFactory().createSocket(socket, str, i11, z11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33836b = sSLSocket;
            this.f33838d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f33840f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f33839e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f33837c;
    }

    public String[] getProtocols() {
        return this.f33842h;
    }

    public SSLContext getSslContext() {
        return this.f33835a;
    }

    public SSLSocket getSslSocket() {
        return this.f33836b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f33838d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f33841g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f33839e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f33840f = strArr;
    }

    public void setContext(Context context) {
        this.f33837c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f33842h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f33835a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f33836b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f33841g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f33839e = x509TrustManager;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f33836b = null;
        if (context == null) {
            e.b(f33833i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager instance = SSFSecureX509SingleInstance.getInstance(context);
        this.f33839e = instance;
        this.f33835a.init((KeyManager[]) null, new X509TrustManager[]{instance}, secureRandom);
    }

    public Socket createSocket() throws IOException {
        e.c(f33833i, "createSocket: ");
        Socket createSocket = this.f33835a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33836b = sSLSocket;
            this.f33838d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f33834j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f33834j == null) {
                    f33834j = new SASFCompatiableSystemCA(keyStore, context, secureRandom);
                }
            }
        }
        return f33834j;
    }

    @Deprecated
    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f33836b = null;
        this.f33835a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33835a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f33836b = null;
        this.f33835a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33835a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
