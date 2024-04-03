package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

final class zzcnp extends SSLSocketFactory {
    final SSLSocketFactory zza = ((SSLSocketFactory) SSLSocketFactory.getDefault());
    final /* synthetic */ zzcnq zzb;

    public zzcnp(zzcnq zzcnq) {
        this.zzb = zzcnq;
    }

    private final Socket zza(Socket socket) throws SocketException {
        if (this.zzb.zzr > 0) {
            socket.setReceiveBufferSize(this.zzb.zzr);
        }
        this.zzb.zzs.add(socket);
        return socket;
    }

    public final Socket createSocket(String str, int i11) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i11);
        zza(createSocket);
        return createSocket;
    }

    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    public final Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i11, inetAddress, i12);
        zza(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i11) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i11);
        zza(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i11, inetAddress2, i12);
        zza(createSocket);
        return createSocket;
    }

    public final Socket createSocket(Socket socket, String str, int i11, boolean z11) throws IOException {
        Socket createSocket = this.zza.createSocket(socket, str, i11, z11);
        zza(createSocket);
        return createSocket;
    }
}
