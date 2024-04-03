package bo.app;

import com.braze.support.BrazeLogger;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\t\u0010\bJ\b\u0010\n\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0016¨\u0006\u0017"}, d2 = {"Lbo/app/v5;", "Ljavax/net/ssl/SSLSocketFactory;", "Ljava/net/Socket;", "socket", "a", "", "", "getDefaultCipherSuites", "()[Ljava/lang/String;", "getSupportedCipherSuites", "createSocket", "host", "", "port", "", "autoClose", "Ljava/net/InetAddress;", "localHost", "localPort", "address", "localAddress", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class v5 extends SSLSocketFactory {

    /* renamed from: b  reason: collision with root package name */
    public static final a f39508b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f39509a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lbo/app/v5$a;", "", "", "SSL_V3_PROTOCOL", "Ljava/lang/String;", "TLS_PROTOCOL", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List<String> f39510b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(List<String> list) {
            super(0);
            this.f39510b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Enabling SSL protocols: ", this.f39510b);
        }
    }

    public v5() {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        SSLSocketFactory socketFactory = instance.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "sslContext.socketFactory");
        this.f39509a = socketFactory;
    }

    private final Socket a(Socket socket) {
        Socket socket2 = socket;
        if (socket2 instanceof SSLSocket) {
            ArrayList arrayList = new ArrayList();
            SSLSocket sSLSocket = (SSLSocket) socket2;
            String[] supportedProtocols = sSLSocket.getSupportedProtocols();
            Intrinsics.checkNotNullExpressionValue(supportedProtocols, "socket.supportedProtocols");
            int length = supportedProtocols.length;
            int i11 = 0;
            while (i11 < length) {
                String str = supportedProtocols[i11];
                i11++;
                if (!Intrinsics.areEqual((Object) str, (Object) "SSLv3")) {
                    Intrinsics.checkNotNullExpressionValue(str, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL);
                    arrayList.add(str);
                }
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new b(arrayList), 6, (Object) null);
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                sSLSocket.setEnabledProtocols((String[]) array);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        return socket2;
    }

    public Socket createSocket() {
        Socket createSocket = this.f39509a.createSocket();
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory.createSocket()");
        return a(createSocket);
    }

    public String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites = this.f39509a.getDefaultCipherSuites();
        Intrinsics.checkNotNullExpressionValue(defaultCipherSuites, "internalSSLSocketFactory.defaultCipherSuites");
        return defaultCipherSuites;
    }

    public String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites = this.f39509a.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "internalSSLSocketFactory.supportedCipherSuites");
        return supportedCipherSuites;
    }

    public Socket createSocket(Socket socket, String str, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(str, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Socket createSocket = this.f39509a.createSocket(socket, str, i11, z11);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory…t, host, port, autoClose)");
        return a(createSocket);
    }

    public Socket createSocket(String str, int i11) {
        Intrinsics.checkNotNullParameter(str, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Socket createSocket = this.f39509a.createSocket(str, i11);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory.createSocket(host, port)");
        return a(createSocket);
    }

    public Socket createSocket(String str, int i11, InetAddress inetAddress, int i12) {
        Intrinsics.checkNotNullParameter(str, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(inetAddress, "localHost");
        Socket createSocket = this.f39509a.createSocket(str, i11, inetAddress, i12);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory…rt, localHost, localPort)");
        return a(createSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i11) {
        Intrinsics.checkNotNullParameter(inetAddress, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Socket createSocket = this.f39509a.createSocket(inetAddress, i11);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory.createSocket(host, port)");
        return a(createSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i11, InetAddress inetAddress2, int i12) {
        Intrinsics.checkNotNullParameter(inetAddress, "address");
        Intrinsics.checkNotNullParameter(inetAddress2, "localAddress");
        Socket createSocket = this.f39509a.createSocket(inetAddress, i11, inetAddress2, i12);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory… localAddress, localPort)");
        return a(createSocket);
    }
}
