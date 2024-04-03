package com.huawei.secure.android.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
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
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: c  reason: collision with root package name */
    private static volatile SecureApacheSSLSocketFactory f33668c = null;

    /* renamed from: a  reason: collision with root package name */
    private SSLContext f33669a;

    /* renamed from: b  reason: collision with root package name */
    private Context f33670b;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
    }

    private void a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        SSLUtil.setEnabledProtocols(sSLSocket);
        SSLUtil.setEnableSafeCipherSuites(sSLSocket);
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        if (f33668c == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f33668c == null) {
                    f33668c = new SecureApacheSSLSocketFactory(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f33668c;
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        Socket createSocket = this.f33669a.getSocketFactory().createSocket(socket, str, i11, z11);
        a(createSocket);
        return createSocket;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        super(keyStore);
        this.f33670b = context;
        this.f33669a = SSLUtil.setSSLContext();
        SecureX509TrustManager secureX509TrustManager = new SecureX509TrustManager(this.f33670b);
        this.f33669a.init((KeyManager[]) null, new X509TrustManager[]{secureX509TrustManager}, secureRandom);
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = this.f33669a.getSocketFactory().createSocket();
        a(createSocket);
        return createSocket;
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        super(keyStore);
        this.f33669a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        this.f33669a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, (SecureRandom) null);
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        if (f33668c == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f33668c == null) {
                    f33668c = new SecureApacheSSLSocketFactory(keyStore, context, secureRandom);
                }
            }
        }
        return f33668c;
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        super(keyStore);
        this.f33669a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        this.f33669a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }
}
