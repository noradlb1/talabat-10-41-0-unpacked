package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i  reason: collision with root package name */
    private static final String f33863i = SecureApacheSSLSocketFactory.class.getSimpleName();

    /* renamed from: j  reason: collision with root package name */
    private static volatile SecureApacheSSLSocketFactory f33864j = null;

    /* renamed from: a  reason: collision with root package name */
    private SSLContext f33865a;

    /* renamed from: b  reason: collision with root package name */
    private SSLSocket f33866b;

    /* renamed from: c  reason: collision with root package name */
    private Context f33867c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f33868d;

    /* renamed from: e  reason: collision with root package name */
    private X509TrustManager f33869e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f33870f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f33871g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f33872h;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f33866b = null;
    }

    private void a(Socket socket) {
        boolean z11;
        boolean z12 = true;
        if (!a.a(this.f33872h)) {
            e.c(f33863i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f33872h);
            z11 = true;
        } else {
            z11 = false;
        }
        if (!a.a(this.f33871g) || !a.a(this.f33870f)) {
            e.c(f33863i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!a.a(this.f33871g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f33871g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f33870f);
            }
        } else {
            z12 = false;
        }
        if (!z11) {
            e.c(f33863i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z12) {
            e.c(f33863i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    @Deprecated
    public static void b(X509TrustManager x509TrustManager) {
        e.c(f33863i, "sasf update socket factory trust manager");
        try {
            f33864j = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            e.b(f33863i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            e.b(f33863i, "KeyManagementException");
        } catch (UnrecoverableKeyException unused3) {
            e.b(f33863i, "UnrecoverableKeyException");
        } catch (KeyStoreException unused4) {
            e.b(f33863i, "KeyStoreException");
        } catch (CertificateException unused5) {
            e.b(f33863i, "CertificateException");
        } catch (IOException unused6) {
            e.b(f33863i, "IOException");
        }
    }

    public static void c(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f33863i, "sasf update socket factory trust manager");
        try {
            f33864j = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager, secureRandom);
        } catch (NoSuchAlgorithmException unused) {
            e.b(f33863i, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            e.b(f33863i, "KeyManagementException");
        } catch (UnrecoverableKeyException unused3) {
            e.b(f33863i, "UnrecoverableKeyException");
        } catch (KeyStoreException unused4) {
            e.b(f33863i, "KeyStoreException");
        } catch (CertificateException unused5) {
            e.b(f33863i, "CertificateException");
        } catch (IOException unused6) {
            e.b(f33863i, "IOException");
        }
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f33864j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f33864j == null) {
                    f33864j = new SecureApacheSSLSocketFactory(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f33864j;
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        e.c(f33863i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f33865a.getSocketFactory().createSocket(socket, str, i11, z11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33866b = sSLSocket;
            this.f33868d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f33870f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f33869e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f33867c;
    }

    public String[] getProtocols() {
        return this.f33872h;
    }

    public SSLContext getSslContext() {
        return this.f33865a;
    }

    public SSLSocket getSslSocket() {
        return this.f33866b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f33868d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f33871g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f33869e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f33870f = strArr;
    }

    public void setContext(Context context) {
        this.f33867c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f33872h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f33865a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f33866b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f33871g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f33869e = x509TrustManager;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f33866b = null;
        if (context == null) {
            e.b(f33863i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager instance = SecureX509SingleInstance.getInstance(context);
        this.f33869e = instance;
        this.f33865a.init((KeyManager[]) null, new X509TrustManager[]{instance}, secureRandom);
    }

    public Socket createSocket() throws IOException {
        e.c(f33863i, "createSocket: ");
        Socket createSocket = this.f33865a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f33866b = sSLSocket;
            this.f33868d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f33864j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f33864j == null) {
                    f33864j = new SecureApacheSSLSocketFactory(keyStore, context, secureRandom);
                }
            }
        }
        return f33864j;
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f33866b = null;
        this.f33865a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f33865a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, (SecureRandom) null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f33866b = null;
        this.f33865a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f33865a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f33866b = null;
        this.f33865a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33865a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, (SecureRandom) null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f33866b = null;
        this.f33865a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f33865a.init((KeyManager[]) null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
