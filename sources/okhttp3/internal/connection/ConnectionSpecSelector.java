package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "(Ljava/util/List;)V", "isFallback", "", "isFallbackPossible", "nextModeIndex", "", "configureSecureSocket", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionFailed", "e", "Ljava/io/IOException;", "socket", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConnectionSpecSelector {
    @NotNull
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(@NotNull List<ConnectionSpec> list) {
        Intrinsics.checkNotNullParameter(list, "connectionSpecs");
        this.connectionSpecs = list;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int i11 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (i11 < size) {
            int i12 = i11 + 1;
            if (this.connectionSpecs.get(i11).isCompatible(sSLSocket)) {
                return true;
            }
            i11 = i12;
        }
        return false;
    }

    @NotNull
    public final ConnectionSpec configureSecureSocket(@NotNull SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        int i11 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i11 >= size) {
                connectionSpec = null;
                break;
            }
            int i12 = i11 + 1;
            connectionSpec = this.connectionSpecs.get(i11);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i12;
                break;
            }
            i11 = i12;
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sSLSocket);
            connectionSpec.apply$okhttp(sSLSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.isFallback);
        sb2.append(", modes=");
        sb2.append(this.connectionSpecs);
        sb2.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb2.append(arrays);
        throw new UnknownServiceException(sb2.toString());
    }

    public final boolean connectionFailed(@NotNull IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "e");
        this.isFallback = true;
        if (this.isFallbackPossible && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException) && ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) && (iOException instanceof SSLException))) {
            return true;
        }
        return false;
    }
}
