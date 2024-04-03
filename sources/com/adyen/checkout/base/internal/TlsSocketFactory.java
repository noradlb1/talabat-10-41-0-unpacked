package com.adyen.checkout.base.internal;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

class TlsSocketFactory extends SSLSocketFactory {
    private String[] mEnabledProtocols = {"TLSv1.2"};
    private SSLSocketFactory mInternalSslSocketFactory;

    public TlsSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.mInternalSslSocketFactory = instance.getSocketFactory();
    }

    @Nullable
    private Socket enableTlsOnSocket(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(this.mEnabledProtocols);
        }
        return socket;
    }

    public Socket createSocket() throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket());
    }

    public String[] getDefaultCipherSuites() {
        return this.mInternalSslSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.mInternalSslSocketFactory.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(socket, str, i11, z11));
    }

    public Socket createSocket(String str, int i11) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(str, i11));
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(str, i11, inetAddress, i12));
    }

    public Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(inetAddress, i11));
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(inetAddress, i11, inetAddress2, i12));
    }
}
