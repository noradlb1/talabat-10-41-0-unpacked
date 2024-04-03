package com.huawei.secure.android.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
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
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: c  reason: collision with root package name */
    private static volatile SecureSSLSocketFactory f33671c = null;

    /* renamed from: a  reason: collision with root package name */
    private SSLContext f33672a;

    /* renamed from: b  reason: collision with root package name */
    private Context f33673b;

    private SecureSSLSocketFactory(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalAccessException {
        this.f33672a = null;
        this.f33673b = context;
        this.f33672a = SSLUtil.setSSLContext();
        SecureX509TrustManager secureX509TrustManager = new SecureX509TrustManager(this.f33673b);
        this.f33672a.init((KeyManager[]) null, new X509TrustManager[]{secureX509TrustManager}, secureRandom);
    }

    private void a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        SSLUtil.setEnabledProtocols(sSLSocket);
        SSLUtil.setEnableSafeCipherSuites(sSLSocket);
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException {
        if (f33671c == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f33671c == null) {
                    f33671c = new SecureSSLSocketFactory(context, (SecureRandom) null);
                }
            }
        }
        return f33671c;
    }

    public Socket createSocket(String str, int i11) throws IOException, UnknownHostException {
        Socket createSocket = this.f33672a.getSocketFactory().createSocket(str, i11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException, UnknownHostException {
        return createSocket(str, i11);
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i11);
    }

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException {
        this.f33672a = null;
        this.f33672a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        this.f33672a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, (SecureRandom) null);
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException {
        if (f33671c == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f33671c == null) {
                    f33671c = new SecureSSLSocketFactory(context, secureRandom);
                }
            }
        }
        return f33671c;
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        Socket createSocket = this.f33672a.getSocketFactory().createSocket(socket, str, i11, z11);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException {
        this.f33672a = null;
        this.f33672a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        this.f33672a.init((KeyManager[]) null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }
}
